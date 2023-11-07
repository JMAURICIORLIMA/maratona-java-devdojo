Um guia para construtores em Java [^01]

[^01]: Baeldung "em inglês" ->  [Um guia para construtores em Java](https://www.baeldung.com/java-constructors)

58 - Orientação Objetos - Construtores pt 01 [^02]

[^02]: Acesso o vídeo YouTube ->  [58 - Orientação Objetos - Construtores pt 01](https://abre.ai/hcUZ)

# 58 - Orientação Objetos - Construtores pt 01

### 1. Introdução

Os construtores são os guardiões do design orientado a objetos .

Neste tutorial, veremos como eles atuam como um local único a partir do qual inicializar o estado interno do objeto que
está sendo criado.

Vamos seguir em frente e criar um objeto simples que represente uma conta bancária.

### 2. Configurando uma conta bancária

Imagine que precisamos criar uma classe que represente uma conta bancária. Ele conterá um Nome, Data de Criação e Saldo.

Além disso, vamos substituir o método toString para imprimir os detalhes no console:

```java
class BankAccount {
    String name;
    LocalDateTime opened;
    double balance;

    @Override
    public String toString() {
        return String.format("%s, %s, %f",
                this.name, this.opened.toString(), this.balance);
    }
}
```

Agora, esta classe contém todos os campos necessários para armazenar informações sobre uma conta bancária, mas ainda
não contém um construtor.

Isso significa que se criarmos um novo objeto, os valores dos campos não serão inicializados:

```java
BankAccount account=new BankAccount();
        account.toString();
```

Executar o método toString acima resultará em uma exceção porque o nome dos objetos e os objetos abertos ainda são
nulos:

```java
java.lang.NullPointerException
        at com.baeldung.constructors.BankAccount.toString(BankAccount.java:12)
        at com.baeldung.constructors.ConstructorUnitTest
        .givenNoExplicitContructor_whenUsed_thenFails(ConstructorUnitTest.java:23)
```

### 3. Um construtor sem argumentos

Vamos consertar isso com um construtor:

```java
class BankAccount {
    public BankAccount() {
        this.name = "";
        this.opened = LocalDateTime.now();
        this.balance = 0.0d;
    }
}
```

Observe algumas coisas sobre o construtor que acabamos de escrever. Primeiro, é um método, mas não possui tipo de
retorno. Isso ocorre porque um construtor retorna implicitamente o tipo do objeto que ele cria. Chamar new BankAccount()
agora chamará o construtor acima.

Em segundo lugar, não são necessários argumentos. Esse tipo específico de construtor é chamado de construtor sem
argumento.

Por que não precisamos disso pela primeira vez? É porque quando não escrevemos explicitamente nenhum construtor, o
compilador adiciona um construtor padrão sem argumentos.

É por isso que conseguimos construir o objeto pela primeira vez, embora não tenhamos escrito um construtor
explicitamente. O padrão, nenhum construtor de argumento simplesmente definirá todos os membros com seus valores padrão.

Para objetos, isso é nulo, o que resultou na exceção que vimos anteriormente.

### 4. Um construtor parametrizado

Agora, um benefício real dos construtores é que eles nos ajudam a manter o encapsulamento ao injetar estado no objeto.

Então, para fazer algo realmente útil com esta conta bancária, precisamos ser capazes de injetar alguns valores iniciais
no objeto.

Para fazer isso, vamos escrever um construtor parametrizado, ou seja, um construtor que recebe alguns argumentos:

```java
class BankAccount {
    public BankAccount() { ...}

    public BankAccount(String name, LocalDateTime opened, double balance) {
        this.name = name;
        this.opened = opened;
        this.balance = balance;
    }
}
```

Agora podemos fazer algo útil com nossa classe: BankAccount

```java
    LocalDateTime opened=LocalDateTime.of(2018,Month.JUNE,29,06,30,00);
        BankAccount account=new BankAccount("Tom",opened,1000.0f);
        account.toString();
```

Observe que nossa classe agora possui 2 construtores. Um construtor explícito, sem argumentos e um construtor
parametrizado.

Podemos criar quantos construtores quisermos, mas provavelmente não gostaríamos de criar muitos. Isso seria um pouco
confuso.

Se encontrarmos muitos construtores em nosso código, alguns padrões de design criacionais podem ser úteis.

### 5. Uma cópia de construtor

Os construtores não precisam se limitar apenas à inicialização. Eles também podem ser usados para criar objetos de
outras maneiras. Imagine que precisamos criar uma nova conta a partir de uma já existente.

A nova conta deverá ter o mesmo nome da conta antiga, data de criação de hoje e sem fundos. Podemos fazer isso usando
uma cópia de construtor:

```java
public BankAccount(BankAccount other){
        this.name=other.name;
        this.opened=LocalDateTime.now();
        this.balance=0.0f;
        }
```

Agora temos o seguinte comportamento:

```java
    LocalDateTime opened=LocalDateTime.of(2018,Month.JUNE,29,06,30,00);
        BankAccount account=new BankAccount("Tim",opened,1000.0f);
        BankAccount newAccount=new BankAccount(account);

        assertThat(account.getName()).isEqualTo(newAccount.getName());
        assertThat(account.getOpened()).isNotEqualTo(newAccount.getOpened());
        assertThat(newAccount.getBalance()).isEqualTo(0.0f);
```

### 6. Um construtor encadeado

É claro que podemos inferir alguns dos parâmetros do construtor ou fornecer valores padrão a alguns deles.

Por exemplo, poderíamos simplesmente criar uma nova conta bancária apenas com o nome.

Então, vamos criar um construtor com um parâmetro name e fornecer valores padrão aos outros parâmetros:

```java
public BankAccount(String name,LocalDateTime opened,double balance){
        this.name=name;
        this.opened=opened;
        this.balance=balance;
        }
public BankAccount(String name){
        this(name,LocalDateTime.now(),0.0f);
        }
```

Com a palavra-chave this, estamos chamando o outro construtor.

Temos que lembrar que se quisermos encadear um construtor de superclasse, teremos que usar super em vez de this.

Além disso, lembre-se de que esta ou super expressão deve ser sempre a primeira afirmação.

### 7. Tipos de valor

Um uso interessante de construtores em Java é na criação de Value Objects. Um objeto de valor é um objeto que não
altera seu estado interno após a inicialização.

Ou seja, o objeto é imutável. A imutabilidade em Java é um pouco sutil e deve-se tomar cuidado ao criar objetos.

Vamos em frente e criar uma classe imutável:

```java
class Transaction {
    final BankAccount bankAccount;
    final LocalDateTime date;
    final double amount;

    public Transaction(BankAccount account, LocalDateTime date, double amount) {
        this.bankAccount = account;
        this.date = date;
        this.amount = amount;
    }

}
```

Observe que agora usamos a palavra-chave final ao definir os membros da classe. Isso significa que cada um desses
membros só pode ser inicializado dentro do construtor da classe. Eles não podem ser reatribuídos posteriormente em
qualquer outro método. Podemos ler esses valores, mas não alterá-los.

Se criarmos vários construtores para a classe Transaction, cada construtor precisará inicializar cada variável final.
Não fazer isso resultará em um erro de compilação.

### 8. Conclusão

Fizemos um tour pelas diferentes maneiras pelas quais os construtores constroem objetos. Quando usadas criteriosamente,
as construções formam os blocos básicos de construção do design Orientado a Objetos em Java.

# Contrutores pt 02 - Sobrecarga

58 - Orientação Objetos - Construtores pt 02 - Sobrecarga [^03]

[^03]: Acesso o vídeo YouTube ->  [59 - Orientação Objetos - Construtores pt 02 - Sobrecarga](https://abre.ai/hdse)

Aqui está um exemplo de sobrecarga de construtores usando o `this` em Java:

```java
public class ExemploSobrecargaConstrutores {
    private String nome;
    private int idade;
    private double salario;
    private boolean estudante;

    // Construtor vazio
    public ExemploSobrecargaConstrutores() {
        System.out.println("Dentro do construtor vazio");
    }

    // Construtor com 3 parâmetros, chamando o construtor vazio
    public ExemploSobrecargaConstrutores(String nome, int idade, double salario) {
        this();  // Chamando o construtor vazio
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    // Construtor com 4 parâmetros, chamando o construtor com 3 parâmetros
    public ExemploSobrecargaConstrutores(String nome, int idade, double salario, boolean estudante) {
        this(nome, idade, salario);  // Chamando o construtor com 3 parâmetros
        this.estudante = estudante;
    }

    // Outros métodos e getters/setters...

    public static void main(String[] args) {
        // Exemplos de uso dos construtores
        ExemploSobrecargaConstrutores obj1 = new ExemploSobrecargaConstrutores();
        ExemploSobrecargaConstrutores obj2 = new ExemploSobrecargaConstrutores("Alice", 25, 50000);
        ExemploSobrecargaConstrutores obj3 = new ExemploSobrecargaConstrutores("Bob", 30, 60000, true);
    }
}
```

Neste exemplo:

- O construtor vazio imprime a mensagem quando é chamado.
- O construtor com 3 parâmetros chama o construtor vazio usando `this()` antes de executar suas próprias operações.
- O construtor com 4 parâmetros chama o construtor com 3 parâmetros usando `this(nome, idade, salario)` antes de
  executar suas próprias operações.

Essa é uma maneira comum de estruturar construtores quando você deseja reutilizar parte da lógica de inicialização em
diferentes construtores.