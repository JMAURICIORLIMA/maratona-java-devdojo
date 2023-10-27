# Maratona Java 44 - Orientação Objetos - Métodos

1. **Introdução**

Em Java, os métodos são onde definimos a lógica de negócios de um aplicativo. Eles definem as interações entre os dados
contidos em um objeto.

Neste tutorial, veremos a sintaxe dos métodos Java, a definição da assinatura do método e como chamar e sobrecarregar
métodos.

2. **Sintaxe do método**

Primeiro, um método consiste em seis partes:

> * **Modificador de acesso:** opcionalmente podemos especificar de onde o código pode acessar o método.
> * **Tipo de retorno:** o tipo do valor retornado pelo método, se houver.
> * **Identificador do método:** o nome que damos ao método.
> * **Lista de parâmetros:** uma lista opcional de entradas separadas por vírgula para o método.
> * **Lista de exceções:** uma lista opcional de exceções que o método pode lançar
> * **Corpo:** definição da lógica (pode estar vazio)

Vejamos um exemplo:

![esquema de metodo](https://github.com/JMAURICIORLIMA/maratona-java-devdojo/blob/91dfc7c64e2fcfb24ce191dc41e21c1846436118/img/method-structure-3-1024x131.png)

2.1. **Modificador de acesso**

O modificador de acesso nos permite especificar quais objetos podem ter acesso ao método. Existem quatro modificadores
de acesso possíveis: public, protected, private e default (também chamado package-private ).

Um método também pode incluir a static palavra-chave antes ou depois do modificador de acesso. Isso significa que o
método pertence à classe e não às instâncias e, portanto, podemos chamar o método sem criar uma instância da classe.
Métodos sem a palavra-chave static são conhecidos como métodos de instância e só podem ser invocados em uma instância
da classe.

Em relação ao desempenho, um método estático será carregado na memória apenas uma vez – durante o carregamento da
classe – e, portanto, é mais eficiente em termos de memória.

2.2. **Tipo de retorno**

Os métodos podem retornar dados para o código de onde foram chamados. Um método pode retornar um valor primitivo ou uma
referência de objeto, ou pode não retornar nada se usarmos a palavra-chave void como tipo de retorno.

Vejamos um exemplo de método void

```java
public void printFullName(String firstName, String lastName) {
    System.out.println(firstName + " " + lastName);
}
```

Se declararmos um tipo de retorno, teremos que especificar uma instrução de retorno no corpo do método. a instrução
return, a execução do corpo do método será finalizada e se houver mais instruções, estas não serão processadas. Uma vez
executada.

Por outro lado, um método void não retorna nenhum valor e, portanto, não possui uma instrução de retorno.

2.3. **Identificador de método**

O identificador do método é o nome que atribuímos a uma especificação de método. É uma boa prática usar um nome
informativo e descritivo. Vale ressaltar que um identificador de método pode ter no máximo 65.536 caracteres (embora
seja um nome longo).

2.4. **Lista de parâmetros**

Podemos especificar valores de entrada para um método em sua lista de parâmetros, que está entre parênteses. Um método
pode ter de 0 a 255 parâmetros delimitados por vírgulas. Um parâmetro pode ser um objeto, uma primitiva ou uma
enumeração . Podemos usar anotações Java no nível do parâmetro do método (por exemplo, a anotação Spring @RequestParam).

2.5. **Lista de exceções**

Podemos especificar quais exceções são lançadas por um método usando a cláusula throws. No caso de uma exceção
verificada, devemos colocar o código em uma try-catch cláusula ou devemos fornecer uma cláusula throws na assinatura do
método.

Então, vamos dar uma olhada em uma variante mais complexa do nosso método anterior, que lança uma exceção verificada:

```java
public void writeName(String name) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        out.println("Name: " + name);
        out.close();
}
```

2.6. **Corpo do método**

A última parte de um método Java é o corpo do método, que contém a lógica que queremos executar. No corpo do método,
podemos escrever quantas linhas de código quisermos — ou nenhuma, no caso de métodos estáticos. Se nosso método
declarar um tipo de retorno, o corpo do método deverá conter uma instrução de retorno.

3. **Assinatura do Método**

De acordo com sua definição, uma assinatura de método é composta por apenas dois componentes – o nome do método e a
lista de parâmetros.

Então, vamos escrever um método simples:

```java
public String getName(String firstName, String lastName) {
    return firstName + " " + middleName + " " + lastName;
}
```

A assinatura deste método é getName(String firstName, String lastName).

O identificador do método pode ser qualquer identificador. No entanto, se seguirmos as convenções comuns de codificação
Java, o identificador do método deve ser um verbo em letras minúsculas que pode ser seguido por adjetivos e/ou
substantivos.

4. **Chamando um Método**

Agora, vamos explorar como chamar um método em Java. Seguindo o exemplo anterior, vamos supor que esses métodos estejam
incluídos em uma classe Java chamada PersonName:

```java
public class PersonName {
    
    public String getName(String firstName, String lastName) {
        return firstName + " " + middleName + " " + lastName;
    }
}
```

Como nosso método getName é um método de instância e não um método estático, para chamar o método getName, precisamos
criar uma instância da classe PersonName:

```java
PersonName personName = new PersonName();
String fullName = personName.getName("Alan", "Turing");
```

Como podemos ver, usamos o objeto criado para chamar o método getName.

Finalmente, vamos dar uma olhada em como chamar um método estático. No caso de um método estático, não precisamos de
uma instância de classe para fazer a chamada. Em vez disso, invocamos o método com seu nome prefixado pelo nome da
classe.

Vamos demonstrar usando uma variante do exemplo anterior:

```java
public class PersonName {

    public static String getName(String firstName, String lastName) {
        return firstName + " " + middleName + " " + lastName;
    }
}
```

Neste caso, a chamada do método é:

```java
String fullName = PersonName.getName("Alan", "Turing");
```

5. Sobrecarga de método

Java nos permite ter dois ou mais métodos com o mesmo identificador, mas com listas de parâmetros diferentes —
assinaturas de métodos diferentes. Neste caso, dizemos que o método está sobrecarregado. Vamos com um exemplo:

```java
public String getName(String firstName, String lastName) {
    return getName(firstName, "", lastName);
}

public String getName(String firstName, String middleName, String lastName) {
    if (!middleName.isEqualsTo("")) {
        return firstName + " " + lastName;
    }
        return firstName + " " + middleName + " " + lastName;
}
```

A sobrecarga de métodos é útil para casos como o do exemplo, onde podemos ter um método implementando uma versão
simplificada da mesma funcionalidade.

Finalmente, um bom hábito de design é garantir que os métodos sobrecarregados se comportem de maneira semelhante.
Caso contrário, o código ficará confuso se um método com o mesmo identificador se comportar de maneira diferente.

6. Conclusão

Neste tutorial, exploramos as partes da sintaxe Java envolvidas ao especificar um método em Java.

Em particular, examinamos o modificador de acesso, o tipo de retorno, o identificador do método, a lista de parâmetros,
a lista de exceções e o corpo do método. Depois vimos a definição da assinatura do método, como chamar um método e como
sobrecarregar um método.

Methods in Java [^1].

[^1]: Mais informações podem ser encontradas no [site Baeldung](https://www.baeldung.com/java-methods).

Orientação Objetos - Métodos pt-01 [^2].

[^2]: Acesso o vídeo YouTube -> [Maratona Java 44 - Orientação Objetos - Métodos pt 01](https://abre.ai/g4Q5).

# Maratona Java 45 - Orientação Objetos - Métodos - Parâmetros

**Parâmetros em Java: Resumo**

Em Java, parâmetros são informações que você passa para um método ou construtor quando o chama. Eles são usados para
transmitir dados ou argumentos necessários para a execução do método. Aqui estão os pontos-chave sobre parâmetros em
Java:

### 1. **Definição de Parâmetros:**
- **Métodos:** São funções definidas em uma classe.
- **Construtores:** São métodos especiais usados para inicializar objetos.

### 2. **Sintaxe:**
- **Método sem Parâmetros:**
  ```java
  void meuMetodo() {
      // Código aqui
  }
  ```
- **Método com Parâmetros:**
  ```java
  void meuMetodo(int parametro1, String parametro2) {
      // Código aqui
  }
  ```

### 3. **Tipos de Parâmetros:**
- **Parâmetros Primitivos:** Tipos de dados básicos como `int`, `double`, `char`, etc.
- **Objetos como Parâmetros:** Você pode passar instâncias de classes como parâmetros.
- **Arrays como Parâmetros:** Arrays podem ser usados como parâmetros.

### 4. **Passagem por Valor:**
- Em Java, os parâmetros são passados por valor.
- Para tipos primitivos, o valor real é passado.
- Para objetos, a referência para o objeto é passada por valor.

### 5. **Número e Ordem dos Parâmetros:**
- O número e a ordem dos parâmetros em uma chamada de método devem corresponder à definição do método.
- É possível ter métodos com o mesmo nome, desde que a assinatura (tipo e ordem dos parâmetros) seja diferente.

### 6. **Parâmetros Opcionais (Java 8+):**
- Em Java 8 e posteriores, você pode usar a API de Streams para trabalhar com parâmetros opcionais.
- Isso é útil para lidar com valores que podem ser nulos.

### 7. **Palavra-chave `this`:**
- A palavra-chave `this` pode ser usada dentro de métodos para se referir aos campos da classe quando há ambiguidade
com parâmetros.

### 8. **Métodos Variáveis (Java 5+):**
- Métodos que aceitam um número variável de parâmetros são suportados no Java usando `varargs`.
- Exemplo:
  ```java
  void meuMetodo(String... palavras) {
      // Código aqui
  }
  ```

Entender como trabalhar com parâmetros é fundamental para a programação em Java, pois você frequentemente precisará
passar dados para métodos a fim de que eles realizem tarefas específicas.

Orientação Objetos - Métodos pt-02 - Parâmetros [^3].

[^3]: Acesso o vídeo YouTube -> [Maratona Java 45 - Orientação Objetos - Métodos pt 02 - Parâmetros](https://abre.ai/g4VK).

# Maratona Java 46 e 47 - Orientação Objetos - Métodos - Retorno

**Retorno em Métodos em Java: Resumo**

Em Java, o retorno de um método se refere ao valor que o método fornece após sua execução. Aqui estão alguns pontos
essenciais sobre o retorno de métodos:

### 1. **Sintaxe de Retorno:**
- A palavra-chave `return` é usada para especificar o valor que o método retorna.
- Exemplo:
  ```java
  int soma(int a, int b) {
      return a + b;
  }
  ```

### 2. **Tipos de Retorno:**
- Os métodos podem retornar qualquer tipo de dado, incluindo tipos primitivos, objetos e até mesmo `void` (indicando
que o método não retorna nenhum valor).
- Exemplo:
  ```java
  String cumprimento() {
      return "Olá, mundo!";
  }
  ```

### 3. **Métodos sem Retorno (`void`):**
- Quando um método não precisa retornar um valor, o tipo de retorno é `void`.
- Exemplo:
  ```java
  void exibirMensagem(String mensagem) {
      System.out.println(mensagem);
  }
  ```

### 4. **Passagem de Valor de Retorno:**
- O valor retornado por um método pode ser usado diretamente ou atribuído a uma variável.
- Exemplo:
  ```java
  int resultado = soma(3, 4); // resultado agora é 7
  ```

### 5. **Instrução `return` Múltipla (Java 12+):**
- A partir do Java 12, é possível usar a instrução `yield` em métodos para retornar um valor de uma expressão.
- Exemplo:
  ```java
  int calcularSoma(int a, int b) {
      return a + b;
  }
  ```

### 6. **Retorno Condicional (Java 8+):**
- Em Java 8 e posteriores, você pode usar expressões lambda e Streams para implementar retornos condicionais de maneira
mais concisa.
- Exemplo:
  ```java
  int calcularSoma(int a, int b) {
      return (a > 0 && b > 0) ? a + b : 0;
  }
  ```

### 7. **Exceções em Métodos:**
- Se um método pode lançar exceções, é importante documentar isso usando a palavra-chave `throws` na declaração do
método ou usando blocos `try-catch` internos.

### 8. **Métodos Recursivos:**
- Em Java, métodos podem chamar a si mesmos. Essa técnica é chamada de recursão e é frequentemente usada para resolver
problemas que podem ser quebrados em subproblemas semelhantes.

Entender como funciona o retorno em métodos é crucial, pois isso permite que você crie funções reutilizáveis que podem
ser integradas eficientemente em diferentes partes de seu código.

Orientação Objetos - Métodos pt-03 - Retorno pt-01 [^4].

[^4]: Acesso o vídeo YouTube -> [Maratona Java 46 - Orientação Objetos - Métodos pt 03 - Retorno pt-01](https://abre.ai/g4Zi).

Orientação Objetos - Métodos pt-03 - Retorno pt-02 [^5].

[^5]: Acesso o vídeo YouTube -> [Maratona Java 47 - Orientação Objetos - Métodos pt 04 - Retorno pt-02](https://abre.ai/g4ZY).

# Maratona Java 48, 49 e 50 - Orientação Objetos - Métodos - Parâmetros tipo Primitivos e tipo Referência.

### 1. Introdução

Os dois modos mais comuns de passar argumentos para métodos são “passagem por valor” e “passagem por referência”.
Diferentes linguagens de programação usam esses conceitos de maneiras diferentes. No que diz respeito ao Java, tudo é
estritamente Pass-by-Value.

Neste tutorial, ilustraremos como Java passa argumentos para vários tipos.

### 2. Passagem por Valor vs. Passagem por Referência

Vamos começar com alguns dos diferentes mecanismos de passagem de parâmetros para funções:

* valor
* referência
* resultado
* valor-resultado
* nome

Os dois mecanismos mais comuns nas linguagens de programação modernas são “Passagem por Valor” e “Passagem por
Referência”. Antes de prosseguirmos, vamos discutir isso primeiro:

#### 2.1. Passagem por Valor

Quando um parâmetro é passado por valor, o método chamador e o método chamado operam em duas variáveis diferentes que
são cópias uma da outra. Quaisquer alterações em uma variável não modificam a outra.

Isso significa que ao chamar um método, os parâmetros passados para o método chamado serão clones dos parâmetros
originais. Qualquer modificação feita no método chamado não terá efeito nos parâmetros originais do método chamador.

#### 2.2. Passagem por Referência

Quando um parâmetro é passado por referência, o chamador e o receptor operam no mesmo objeto.

Isso significa que quando uma variável é passada por referência, o identificador único do objeto é enviado ao método.
Quaisquer alterações nos membros da instância do parâmetro resultarão na alteração do valor original.

### 3. Passagem de Parâmetros em Java

Os conceitos fundamentais em qualquer linguagem de programação são “valores” e “referências”. Em Java, as variáveis 
primitivas armazenam os valores reais, enquanto as não primitivas armazenam as variáveis de referência que apontam para
os endereços dos objetos aos quais estão se referindo. Tanto os valores quanto as referências são armazenados na
memória da pilha.

Argumentos em Java são sempre passados por valor. Durante a invocação do método, uma cópia de cada argumento, seja um
valor ou uma referência, é criada na memória da pilha que é então passada para o método.

No caso de primitivos, o valor é simplesmente copiado dentro da memória da pilha que é então passado para o método
chamado; no caso de não primitivos, uma referência na memória da pilha aponta para os dados reais que residem no heap.
Quando passamos um objeto, a referência na memória da pilha é copiada e a nova referência é passada para o método.

Vamos agora ver isso em ação com a ajuda de alguns exemplos de código.

#### 3.1. Passando Tipos Primitivos

A linguagem de programação Java apresenta oito tipos de dados primitivos. Variáveis primitivas são armazenadas
diretamente na memória da pilha. Sempre que qualquer variável de tipo de dados primitivo é passada como argumento, os
parâmetros reais são copiados para argumentos formais e esses argumentos formais acumulam seu próprio espaço na memória
da pilha.

A vida útil desses parâmetros formais dura apenas enquanto o método estiver em execução e, ao retornar, esses argumentos
formais são removidos da pilha e descartados.

Vamos tentar entendê-lo com a ajuda de um exemplo de código:

```java
public class PrimitivesUnitTest {
 
    @Test   //ao modificar primitivos, então valores originais não modificados
    public void whenModifyingPrimitives_thenOriginalValuesNotModified() {
        
        int x = 1;
        int y = 2;
       
        // Before Modification
        assertEquals(x, 1);
        assertEquals(y, 2);
        
        modify(x, y);
        
        // After Modification
        assertEquals(x, 1);
        assertEquals(y, 2);
    }
    
    public static void modify(int x1, int y1) {
        x1 = 5;
        y1 = 10;
    }
}

```

Vamos tentar entender as afirmações do programa acima analisando como esses valores são armazenados na memória:

1. As variáveis “x” e “y” no método principal são tipos primitivos e seus valores são armazenados diretamente na
memória da pilha.
2. Quando chamamos o método modificar(), uma cópia exata de cada uma dessas variáveis é criada e armazenada em um local
diferente na memória da pilha.
3. Qualquer modificação nessas cópias afeta apenas elas e deixa as variáveis originais inalteradas.

![img01](https://github.com/JMAURICIORLIMA/maratona-java-devdojo/blob/9cd23e596a87c27d55ee0b33578b73fd36f4abd8/img/baeldung_-_pass_by_value_-_passing_primitives.jpg)

#### 3.2. Passando Referências de Objetos

Em Java, todos os objetos são armazenados dinamicamente no espaço Heap nos bastidores. Esses objetos são referenciados
a partir de referências chamadas variáveis de referência.

Um objeto Java, ao contrário dos Primitivos, é armazenado em dois estágios. As variáveis de referência são armazenadas
na memória stack e o objeto ao qual se referem é armazenado na memória Heap.

Sempre que um objeto é passado como argumento, é criada uma cópia exata da variável de referência que aponta para o
mesmo local do objeto na memória heap que a variável de referência original.

Como resultado disso, sempre que fizermos alguma alteração no mesmo objeto do método, essa alteração será refletida no
objeto original. Entretanto, se alocarmos um novo objeto à variável de referência passada, ele não será refletido no
objeto original.

Vamos tentar compreender isso com a ajuda de um exemplo de código:

```java
public class NonPrimitivesUnitTest {
 
    @Test
    public void whenModifyingObjects_thenOriginalObjectChanged() {
        Foo a = new Foo(1);
        Foo b = new Foo(1);

        // Before Modification
        assertEquals(a.num, 1);
        assertEquals(b.num, 1);
        
        modify(a, b);
        
        // After Modification
        assertEquals(a.num, 2);
        assertEquals(b.num, 1);
    }
 
    public static void modify(Foo a1, Foo b1) {
        a1.num++;
       
        b1 = new Foo(1);
        b1.num++;
    }
}
 
class Foo {
    public int num;
   
    public Foo(int num) {
        this.num = num;
    }
}
```

Vamos analisar as afirmações do programa acima. Passamos os objetos no "a" e "b" valor método modificar() que possui o
mesmo 1. Inicialmente, essas referências de objeto apontam para dois locais distintos de objeto em um espaço de heap:

![img02](https://github.com/JMAURICIORLIMA/maratona-java-devdojo/blob/9cd23e596a87c27d55ee0b33578b73fd36f4abd8/img/baeldung_-_pass_by_value_-_passing_primitives_-_initial.jpg)

Quando essas referências a e b são passadas no método modificar(), ele cria cópias espelhadas das referências a1 e b1
que apontam para os mesmos objetos antigos:

![img03](https://github.com/JMAURICIORLIMA/maratona-java-devdojo/blob/9cd23e596a87c27d55ee0b33578b73fd36f4abd8/img/baeldung_-_pass_by_value_-_passing_primitives_-_before_method_ca.jpg)

No método modificar(), quando modificamos a referência a1 , ela altera o objeto original. Porém, para uma referência b1,
atribuímos um novo objeto. Então agora está apontando para um novo objeto na memória heap.

Qualquer alteração feita em b1 não refletirá nada no objeto original:

![img04](https://github.com/JMAURICIORLIMA/maratona-java-devdojo/blob/9cd23e596a87c27d55ee0b33578b73fd36f4abd8/img/baeldung_-_pass_by_value_-_passing_primitives_-_after_method_cal.jpg)

### 4. Conclusão

Neste artigo, vimos como a passagem de parâmetros é tratada no caso de Primitivos e Não Primitivos.

Aprendemos que a passagem de parâmetros em Java é sempre passagem por valor. No entanto, o contexto muda dependendo se
estamos lidando com Primitivos ou Objetos:

1. Para tipos primitivos, os parâmetros são passados por valor.
2. Para tipos de objetos, a referência do objeto é passada por valor.

Passagem por valor como mecanismo de passagem de parâmetros em Java [^6].

[^6]: Parâmetros em Java [site Baeldung](https://abre.ai/g43y).

Orientação Objetos - Métodos pt-05 - Parâmetros tipo primitivo pt-01 [^7].

[^7]: Acesso o vídeo YouTube -> [Maratona Java 48 - Orientação Objetos - Métodos pt 05 - Parâmetros tipo primitivo](https://abre.ai/g43S).

Orientação Objetos - Métodos pt-06 - Parâmetros tipo referência [^8].

[^8]: Acesso o vídeo YouTube -> [Maratona Java 49 - Orientação Objetos - Métodos pt 06 - Parâmetros tipo referência](https://abre.ai/g43U).

Orientação Objetos - Métodos pt-07 - Parâmetros tipo referência pt 02 [^9].

[^9]: Acesso o vídeo YouTube -> [Maratona Java 50 - Orientação Objetos - Métodos pt 07 - Parâmetros tipo referência pt-02](https://abre.ai/g44h).

# Maratona Java 51 - Orientação Objetos - Métodos - Referência this.

### 1. Introdução

Neste tutorial, daremos uma olhada na palavra-chave this Java.

Em Java, esta palavra-chave é uma referência ao objeto atual cujo método está sendo chamado.

Vamos explorar como e quando podemos usar a palavra-chave.

### 2. Desambiguação do sombreamento de campo

A palavra-chave é útil para desambiguar variáveis de instância de parâmetros locais. O motivo mais comum é
quando temos parâmetros de construtor com o mesmo nome dos campos de instância:

```java
public class KeywordTest {

    private String name;
    private int age;
    
    public KeywordTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Como podemos ver aqui, estamos usando isso com os campos de instância de nome e idade – para distingui-los dos
parâmetros.

Outro uso é usar isso com o parâmetro oculto ou sombreado no escopo local. Um exemplo de uso pode ser encontrado no
[artigo Ocultação de variáveis e métodos](https://www.baeldung.com/java-variable-method-hiding).

### 3. Referenciando Construtores da Mesma Classe

A partir de um construtor, podemos usar this() para chamar um construtor diferente da mesma classe. Aqui, usamos this()
para o encadeamento do construtor para reduzir o uso do código.

O caso de uso mais comum é chamar um construtor padrão do construtor parametrizado:

```java
public KeywordTest(String name, int age) {
    this();
    
    // the rest of the code
}
```

Ou podemos chamar o construtor parametrizado do construtor sem argumento e passar alguns argumentos:

```java
public KeywordTest() {
    this("John", 27);
}
```

Observe que this() deve ser a primeira instrução no construtor, caso contrário ocorrerá um erro de compilação.

### 4. Passando isso como parâmetro

Aqui temos o método printInstance(), onde o argumento this Keyword é definido:

```java
public KeywordTest() {
    printInstance(this);
}

public void printInstance(KeywordTest thisKeyword) {
    System.out.println(thisKeyword);
}
```

Dentro do construtor, invocamos o método printInstance(). Com this, passamos uma referência para a instância atual.

### 5. Devolvendo isto

Também podemos usar esta palavra-chave para retornar a instância da classe atual do método.

Para não duplicar o código, aqui está um exemplo prático completo de como ele é implementado no [padrão de design do
construtor.](https://www.baeldung.com/creational-design-patterns)

### 6. A palavra-chave this dentro da classe interna

Também usamos isso para acessar a instância da classe externa de dentro da classe interna:

```java
public class KeywordTest {

    private String name;

    class ThisInnerClass {

        boolean isInnerClass = true;

        public ThisInnerClass() {
            KeywordTest thisKeyword = KeywordTest.this;
            String outerString = KeywordTest.this.name;
        }
    }
}
```

Aqui, dentro do construtor, podemos obter uma referência à instância KeywordTest com a KeywordTest.this chamada.
Podemos ir ainda mais fundo e acessar as variáveis de instância como o campo KeywordTest.this.name.

### 7. Conclusão

Neste artigo, exploramos a palavra-chave this em Java.

Orientação Objetos - Métodos pt-08 - Referência this [^10].

[^10]: Acesso o vídeo YouTube -> [Maratona Java 51 - Orientação Objetos - Métodos pt 08 - Referência this](https://abre.ai/g7wM).

Guia para palavra-chave this em java [^11].

[^11]: Acesse o site (em inglês) -> [Guia palavra-chave this em java](https://abre.ai/g7wZ).
