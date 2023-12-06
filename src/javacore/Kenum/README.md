# Um guia para enums Java [^01]

[^01]: Acesse o site em inglês - Baeldung -> [Um guia para enums Java](https://www.baeldung.com/a-guide-to-java-enums)

## 80 - Orientação Objetos - Enumeração pt 01 - Introdução [^02]

[^02]: Assita o vídeo no Youtube -> [80 - Orientação Objetos - Enumeração pt 01 - Introdução](https://abre.ai/hx8f)

## 1. Visão Geral

Neste tutorial, aprenderemos o que são enums Java, quais problemas eles resolvem e como alguns de seus padrões de design
podem ser usados na prática.

**Java 5 introduziu pela primeira vez a palavra-chave enum**. Denota um tipo especial de classe que sempre estende a
classe java.lang.Enum. Para a documentação oficial sobre uso, podemos acessar
a [documentação](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Enum.html).

As constantes definidas dessa forma tornam o código mais legível, permitem a verificação em tempo de compilação,
documentam antecipadamente a lista de valores aceitos e evitam comportamentos inesperados devido à passagem de valores
inválidos.

Aqui está um exemplo rápido e simples de enum que define o status de um pedido de pizza; o status do pedido pode ser
PEDIDO, PRONTO ou ENTREGUE:

```java
public enum PizzaStatus {
    ORDERED,
    READY,
    DELIVERED;
}
```

Além disso, enums vêm com muitos métodos úteis que, de outra forma, precisaríamos escrever se estivéssemos usando
constantes finais estáticas públicas tradicionais.

## 2. Métodos de Enum Personalizados

Agora que temos uma compreensão básica do que são enums e como podemos usá-los, levaremos nosso exemplo anterior para o
próximo nível, definindo alguns métodos de API extras no enum:

```java
public class Pizza {
    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    // Methods that set and get the status variable.
}
```

## 3. Comparando tipos de enum usando o operador “==”

Como os tipos enum garantem que exista apenas uma instância das constantes na JVM, podemos usar com segurança o
operador “==” para comparar duas variáveis, como fizemos no exemplo acima. Além disso, o operador “==” fornece segurança
em tempo de compilação e tempo de execução.

Primeiro, veremos **a segurança em tempo de execução** no trecho a seguir, onde usaremos o operador “==” para comparar
status. Qualquer um dos valores pode ser nulo e não obteremos uma NullPointerException. Por outro lado, se usarmos o
método equals, obteremos uma NullPointerException:

```java
if(testPz.getStatus().equals(Pizza.PizzaStatus.DELIVERED));
        if(testPz.getStatus()==Pizza.PizzaStatus.DELIVERED);
```

Quanto à **segurança em tempo de compilação**, vejamos um exemplo em que determinaremos que um enum de um tipo diferente
é igual comparando-o usando o método equals. Isso ocorre porque os valores do método getStatus e enum coincidentemente
são os mesmos; entretanto, logicamente a comparação deveria ser falsa. Evitamos esse problema usando o operador “==”.

O compilador sinalizará a comparação como um erro de incompatibilidade:

```java
if(testPz.getStatus().equals(TestColor.GREEN));
        if(testPz.getStatus()==TestColor.GREEN);
```

## 4. Usando tipos Enum em instruções Switch

Também podemos usar tipos enum em instruções switch:

```java
public int getDeliveryTimeInDays(){
        switch(status){
        case ORDERED:return 5;
        case READY:return 2;
        case DELIVERED:return 0;
        }
        return 0;
        }
```

## 5. Campos, Métodos e Construtores em Enums

Podemos definir construtores, métodos e campos dentro de tipos enum, o que os torna muito poderosos.

A seguir, vamos estender o exemplo acima implementando a transição de uma etapa de um pedido de pizza para outra.
Veremos como podemos nos livrar das instruções if e switch usadas antes:

```java
public class Pizza {

    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    // Methods that set and get the status variable.
}
```

O trecho de teste abaixo demonstra como isso funciona:

```java
@Test
public void givenPizaOrder_whenReady_thenDeliverable(){
        Pizza testPz=new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        assertTrue(testPz.isDeliverable());
        }
```

## 6. EnumSet e EnumMap

### 6.1. EnumSet

O EnumSet é uma implementação Set especializada que deve ser usada com tipos Enum.

Comparado a um HashSet, é uma representação muito eficiente e compacta de um determinado conjunto de constantes Enum,
devido à representação interna de vetor de bits usada. Ele também fornece uma alternativa de tipo seguro aos
tradicionais “bit flags” baseados em int, permitindo-nos escrever código conciso que é mais legível e de fácil
manutenção.

O EnumSet é uma classe abstrata que possui duas implementações, RegularEnumSet e JumboEnumSet, uma das quais é
escolhida dependendo do número de constantes no enum no momento da instanciação.

Portanto, é uma boa ideia usar esse conjunto sempre que quisermos trabalhar com uma coleção de constantes enum na
maioria dos cenários (como subconjunto, adição, remoção e operações em massa como containsAll e removeAll ) e usar
Enum.values() se quisermos só quero iterar sobre todas as constantes possíveis.

No trecho de código abaixo, podemos ver como usar EnumSet para criar um subconjunto de constantes:

```java
public class Pizza {

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
            EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    private PizzaStatus status;

    public enum PizzaStatus {
        ...
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery() + " days");
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                        (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    // Methods that set and get the status variable.
}
```

A execução do teste a seguir demonstra o poder da implementação EnumSet da interface Set:

```java
@Test
public void givenPizaOrders_whenRetrievingUnDeliveredPzs_thenCorrectlyRetrieved(){
        List<Pizza> pzList=new ArrayList<>();
        Pizza pz1=new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2=new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3=new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4=new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza> undeliveredPzs=Pizza.getAllUndeliveredPizzas(pzList);
        assertTrue(undeliveredPzs.size()==3);
        }
```

### 6.2. EnumMap

EnumMap especializada é uma implementação de mapa destinada a ser usada com constantes enum como chaves. Comparado ao
seu homólogo HashMap, é uma implementação eficiente e compacta que é representada internamente como um array:

```java
EnumMap<Pizza.PizzaStatus,Pizza>map;
```

Vejamos um exemplo de como podemos usá-lo na prática:

```java
public static EnumMap<PizzaStatus, List<Pizza>>
        groupPizzaByStatus(List<Pizza> pizzaList){
        EnumMap<PizzaStatus, List<Pizza>>pzByStatus=
        new EnumMap<PizzaStatus, List<Pizza>>(PizzaStatus.class);

        for(Pizza pz:pizzaList){
        PizzaStatus status=pz.getStatus();
        if(pzByStatus.containsKey(status)){
        pzByStatus.get(status).add(pz);
        }else{
        List<Pizza> newPzList=new ArrayList<Pizza>();
        newPzList.add(pz);
        pzByStatus.put(status,newPzList);
        }
        }
        return pzByStatus;
        }
```

A execução do teste a seguir demonstra o poder da implementação EnumMap da interface Map:

```java
@Test
public void givenPizaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped(){
        List<Pizza> pzList=new ArrayList<>();
        Pizza pz1=new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2=new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3=new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4=new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        EnumMap<Pizza.PizzaStatus,List<Pizza>>map=Pizza.groupPizzaByStatus(pzList);
        assertTrue(map.get(Pizza.PizzaStatus.DELIVERED).size()==1);
        assertTrue(map.get(Pizza.PizzaStatus.ORDERED).size()==2);
        assertTrue(map.get(Pizza.PizzaStatus.READY).size()==1);
        }
```

## 7. Implementar padrões de design usando enumerações

### 7.1. Padrão Singleton

Normalmente, implementar uma classe usando o padrão Singleton não é trivial. Enums fornecem uma maneira rápida e fácil
de implementar singletons.

Além disso, como a classe enum implementa a interface Serializable nos bastidores, a JVM garante que a classe seja um
singleton. Isto é diferente da implementação convencional, onde temos que garantir que nenhuma nova instância seja
criada durante a desserialização.

No trecho de código abaixo, vemos como podemos implementar um padrão singleton:

```java
public enum PizzaDeliverySystemConfiguration {
    INSTANCE;

    PizzaDeliverySystemConfiguration() {
        // Initialization configuration which involves
        // overriding defaults like delivery strategy
    }

    private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    public static PizzaDeliverySystemConfiguration getInstance() {
        return INSTANCE;
    }

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}
```

### 7.2. Padrão de Estratégia

Convencionalmente, o padrão Strategy é escrito tendo uma interface que é implementada por diferentes classes.

Adicionar uma nova estratégia significa adicionar uma nova classe de implementação. Com enums, podemos conseguir isso
com menos esforço, e adicionar uma nova implementação significa simplesmente definir outra instância com alguma
implementação.

O trecho de código abaixo mostra como implementar o padrão Strategy:

```java
public enum PizzaDeliveryStrategy {
    EXPRESS {
        @Override
        public void deliver(Pizza pz) {
            System.out.println("Pizza will be delivered in express mode");
        }
    },
    NORMAL {
        @Override
        public void deliver(Pizza pz) {
            System.out.println("Pizza will be delivered in normal mode");
        }
    };

    public abstract void deliver(Pizza pz);
}
```

Em seguida, adicionamos o seguinte método à classe Pizza :

```java
public void deliver(){
        if(isDeliverable()){
        PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
        .deliver(this);
        this.setStatus(PizzaStatus.DELIVERED);
        }
        }
```

```java
@Test
public void givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges(){
        Pizza pz=new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        assertTrue(pz.getStatus()==Pizza.PizzaStatus.DELIVERED);
        }
```

## 8. Java 8 e Enums

Podemos reescrever a classe Pizza em Java 8 e ver como os métodos getAllUndeliveredPizzas() e groupPizzaByStatus() se
tornam tão concisos com o uso de lambdas e APIs Stream:

```java
public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input){
        return input.stream().filter(
        (s)->!deliveredPizzaStatuses.contains(s.getStatus()))
        .collect(Collectors.toList());
        }
```

```java
public static EnumMap<PizzaStatus, List<Pizza>>
        groupPizzaByStatus(List<Pizza> pzList){
        EnumMap<PizzaStatus, List<Pizza>>map=pzList.stream().collect(
        Collectors.groupingBy(Pizza::getStatus,
        ()->new EnumMap<>(PizzaStatus.class),Collectors.toList()));
        return map;
        }
```

## 9. Representação JSON de Enum

Usando bibliotecas Jackson, é possível ter uma representação JSON de tipos enum como se fossem POJOs. No trecho de
código abaixo, veremos como podemos usar as anotações Jackson para o mesmo:

```java

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PizzaStatus {
    ORDERED(5) {
        @Override
        public boolean isOrdered() {
            return true;
        }
    },
    READY(2) {
        @Override
        public boolean isReady() {
            return true;
        }
    },
    DELIVERED(0) {
        @Override
        public boolean isDelivered() {
            return true;
        }
    };

    private int timeToDelivery;

    public boolean isOrdered() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public boolean isDelivered() {
        return false;
    }

    @JsonProperty("timeToDelivery")
    public int getTimeToDelivery() {
        return timeToDelivery;
    }

    private PizzaStatus(int timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }
}
```

Podemos usar Pizza e PizzaStatus da seguinte forma:

```java
Pizza pz=new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(Pizza.getJsonString(pz));
```

Isso irá gerar a seguinte representação JSON do status da Pizza :

```java
{
        "status":{
        "timeToDelivery":2,
        "ready":true,
        "ordered":false,
        "delivered":false
        },
        "deliverable":true
        }
```

Para obter mais informações sobre serialização/desserialização JSON (incluindo personalização) de tipos de enum, podemos
consultar [Jackson – Serialize Enums as JSON Objects](https://www.baeldung.com/jackson-serialize-enums).

## 10. Conclusão

Neste artigo, exploramos o enum Java, desde o básico da linguagem até casos de uso mais avançados e interessantes do
mundo real.

# Enumeração - Construtores e atributos

## 81 - Orientação Objetos - Enumeração pt 02 - Construtores e atributos [^03]

[^03]: Assita o vídeo no
Youtube -> [81 - Orientação Objetos - Enumeração pt 02 - Construtores e atributos](https://abre.ai/hx8n)

Em Java, uma enumeração (enum) é um tipo de dado que consiste em um conjunto fixo de constantes (valores). Enumerações
são utilizadas para representar conjuntos de valores fixos, como dias da semana, meses, etc.

Cada constante dentro de uma enumeração é tratada como uma instância dessa enumeração. As enumerações em Java podem ter
construtores, métodos e campos, semelhantes a classes normais.

Aqui está um exemplo de uma enumeração que representa os dias da semana:

```java
public enum DiaDaSemana {
    // As constantes e seus respectivos construtores
    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    // Um campo para armazenar o nome do dia
    private String nome;

    // Um construtor privado para inicializar o campo
    private DiaDaSemana(String nome) {
        this.nome = nome;
    }

    // Um método para obter o nome do dia
    public String getNome() {
        return nome;
    }
}
```

Aqui estão alguns pontos importantes:

1. **Constantes com construtores:** Cada constante (`SEGUNDA`, `TERCA`, etc.) tem um construtor privado que é chamado
   quando a constante é inicializada.

2. **Campos e métodos:** Cada constante pode ter campos e métodos. No exemplo, cada constante tem um campo `nome` e um
   método `getNome()`.

3. **Inicialização de campos:** Os campos de uma enumeração são inicializados quando as constantes são criadas. No
   exemplo, cada constante tem um campo `nome` que é inicializado quando a constante é criada.

Agora, você pode usar essa enumeração em seu código da seguinte forma:

```java
public class ExemploEnum {
    public static void main(String[] args) {
        // Acesso às constantes
        DiaDaSemana dia = DiaDaSemana.SEGUNDA;
        System.out.println("Hoje é " + dia.getNome());

        // Iteração sobre todas as constantes
        for (DiaDaSemana d : DiaDaSemana.values()) {
            System.out.println(d.getNome());
        }
    }
}
```

Esse exemplo ilustra como criar, acessar e iterar sobre as constantes de uma enumeração em Java.