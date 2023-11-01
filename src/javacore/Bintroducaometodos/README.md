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

# Maratona Java 52 - Orientação Objetos - Métodos - Varargs

### 1.Visão Geral

Neste tutorial, exploraremos a diferença entre método(String… args) e método(String[] args) em Java. Ao longo do
caminho, examinaremos como passar um array ou uma lista de argumentos de comprimento variável para um método.

### 2. Passando Arrays para Métodos

Nesta seção, mostraremos como declarar um array do tipo String como parâmetro de um método e como passar um array do 
mesmo tipo como argumento durante uma invocação de método.

Java é uma linguagem de programação de tipo estatístico, o que significa que o tipo da variável é conhecido em tempo de
compilação. Um programador deve indicar um tipo de variável, seja primitivo ou de referência. Ao definir um método com
um parâmetro de array, espera-se que declaremos o tipo de array que queremos que seja passado como argumento durante a
chamada do método.

Vamos ver a sintaxe para definir um parâmetro de array String em um cabeçalho de método:

```java
void capitalizeNames(String[] args)
```

Vamos analisar o argumento declarado no cabeçalho do método acima:

* String[] – nome do tipo
* args – nome do parâmetro

```java
void capitalizeNames(String[] args) {
    for(int i = 0; i < args.length; i++){
       args[i] = args[i].toUpperCase();
    }
}
```

Do exposto acima, o método capitalizeNames() possui um String parâmetro de array args. O cabeçalho do método especifica
que o método recebe apenas uma referência de array do tipo java.lang.String[] quando chamado.

Em essência, quando encontramos (String[] args) no cabeçalho de um método, devemos entender que o método usa um único
array do tipo String como argumento quando chamado.

Vejamos um exemplo:

```java
@Test
void whenCheckingArgumentClassName_thenNameShouldBeStringArray() {
    String[] names = {"john", "ade", "kofi", "imo"};
    assertNotNull(names);
    assertEquals("java.lang.String[]", names.getClass().getTypeName());
    capitalizeNames(names);
}
```

Quando verificamos o nome da classe do capitalizeNames() argumento do método, names, obtemos java.lang.String[], que
corresponde ao parâmetro na definição do método. Se tentarmos passar um tipo diferente como argumento para o método,
obteremos um erro de compilação :

```java
@Test
void whenCheckingArgumentClassName_thenNameShouldBeStringArray() {
    ...
    int[] evenNumbers = {2, 4, 6, 8};
    capitalizeNames(evenNumbers);
}
```

O trecho de código acima geraria a mensagem de erro do compilador em nosso console:

```java
incompatible types: int[] cannot be converted to java.lang.String[]
```

### 3. Listas de argumentos de comprimento variável

Listas de argumentos de comprimento variável, também conhecidas como varargs em Java, nos permitem passar um número
arbitrário de argumentos do mesmo tipo durante uma chamada de método.

A sintaxe para listas de argumentos de comprimento variável em um método é semelhante a: 

```java
String[] firstLetterOfWords(String... args)
```

Vamos analisar o argumento declarado no cabeçalho do método acima:

* String… – digite o nome com reticências
* args – nome do parâmetro

```java
String[] firstLetterOfWords(String... args) {
    String[] firstLetter = new String[args.length];
    for(int i = 0; i < args.length; i++){
        firstLetter[i] = String.valueOf(args[i].charAt(0));
    }
    return firstLetter;
}
```

Declaramos o tipo de parâmetro seguido por reticências (...) e o nome do parâmetro em nossa assinatura de método.

Com listas de argumentos de comprimento variável, podemos adicionar qualquer número de argumentos do mesmo tipo a um
método porque Java trata os argumentos fornecidos como elementos em um array. Ao adicionar varargs como parte dos
parâmetros de um método, certifique-se de que o tipo, as reticências e o nome do parâmetro sejam os últimos.

Por exemplo, isso seria incorreto: 

```java
static String[] someMethod(String... args, int number)
```

Podemos corrigir isso facilmente trocando a ordem dos argumentos, colocando o varargs por último: parâmetro

```java
static String[] someMethod(int number, String... args)
```

Vamos testar o método firstLetterOfWords que escrevemos acima: 

```java
@Test
void whenCheckingReturnedObjectClass_thenClassShouldBeStringArray() {
    assertEquals(String[].class, firstLetterOfWords("football", "basketball", "volleyball").getClass());
    assertEquals(3, firstLetterOfWords("football", "basketball", "volleyball").length);
}
```

Sabemos que o método firstLetterOfWords() usa listas de argumentos de comprimento variável do tipo String por causa das
reticências, e passamos o mesmo como argumentos. O teste mostra que o método retorna um array quando acessamos seu
atributo getClass(). Também obtemos 3 quando acessamos a propriedade length do array, que corresponde ao número de
argumentos passados para ele.

### 4. (String[] args) vs. (String… args)

Argumentos String[] indicam um array do tipo String como parâmetro de método em Java. Muitas vezes é encontrado como um
parâmetro de array do método principal em classes Java. O parâmetro String[] args no método principal forma um String
array a partir de argumentos de linha de comando. Ao invocar um método com (String[] args), um array String deve ser
passado como argumento.

Só podemos ter uma lista de argumentos de comprimento variável ao definir um método. Varargs não se limita apenas ao
tipo java.lang.String. Podemos ter outros tipos como (int… args) , (double… args) e assim por diante. Nos bastidores,
Java pega todos os argumentos passados ao invocar um método com varargs e cria um array com eles. No entanto, podemos
invocar um método com parâmetros varargs sem argumento, caso em que será tratado como um array vazio.

Lembre-se de que args como nome de variável é apenas uma convenção — qualquer outro nome apropriado pode ser usado.

### 5. Conclusão

Neste tutorial, examinamos a diferença entre method(String[] args) e method(String… args). O primeiro é um método com
um parâmetro de array String, enquanto o último é um método com uma lista de argumentos de comprimento variável
( varargs ).

Varargs são sempre colocados como o último parâmetro na lista de parâmetros de um método, portanto, um método pode
declarar apenas um varargs. argumento.

Orientação Objetos - Métodos pt-09 - Varargs [^12].

[^12]: Acesso o vídeo YouTube -> [Maratona Java 52 - Orientação Objetos - Métodos pt 09 - Varargs](https://abre.ai/g8Xa).

Parâmetros de entrada VarArgs vs array em Java [^13].

[^13]: Acesse o site (em inglês) -> [Parâmetros de entrada VarArgs vs array em Java](https://www.baeldung.com/varargs-vs-array).

# Maratona Java 53, 54 e 55 - Orientação Objetos - Modificadores de acesso private, get e set pt 01, 02 e 03.

**Acoplamento em Java:**

Em programação orientada a objetos, acoplamento refere-se ao grau de dependência entre diferentes partes de um sistema.
Em Java, onde os objetos interagem uns com os outros, o acoplamento descreve como as classes ou componentes de software
estão interligados.

### Tipos de Acoplamento:

1. **Acoplamento Forte:**
  - Classes fortemente acopladas têm uma alta dependência uma da outra.
  - Uma mudança em uma classe pode afetar significativamente outras classes.
  - Isso pode tornar o sistema mais difícil de entender, manter e modificar.

2. **Acoplamento Fraco:**
  - Classes fracamente acopladas têm uma baixa dependência.
  - Uma classe pode ser modificada sem afetar muito as outras classes.
  - Isso resulta em um sistema mais flexível e fácil de manter.

### Estratégias para Reduzir o Acoplamento:

1. **Encapsulamento:**
  - Ocultar detalhes internos de uma classe e expor apenas uma interface.
  - Outras classes interagem com essa interface, não com os detalhes internos.

2. **Injeção de Dependência:**
  - Em vez de criar instâncias de objetos dentro de uma classe, eles são fornecidos externamente.
  - Isso reduz a dependência direta entre classes.

3. **Interfaces:**
  - Programar para interfaces em vez de implementações concretas.
  - Classes dependem de interfaces, não de implementações específicas.

4. **Eventos e Listeners:**
  - Usar padrões de projeto como Observador onde objetos interessados se registram para receber notificações.
  - Reduz a dependência direta entre observadores e observáveis.

5. **Inversão de Controle (IoC):**
  - Transferir o controle da criação de objetos para uma estrutura externa (contêiner IoC).
  - Exemplos incluem Spring Framework.

### Benefícios de Reduzir o Acoplamento:

1. **Manutenção Facilitada:**
  - Mudanças em uma classe têm menos probabilidade de impactar outras.
  - Isso facilita a manutenção e evolução do código.

2. **Reusabilidade:**
  - Classes fracamente acopladas podem ser mais facilmente reutilizadas em diferentes contextos.

3. **Testabilidade:**
  - Classes independentes são mais fáceis de testar isoladamente.

4. **Flexibilidade e Escalabilidade:**
  - O código é mais flexível para mudanças e é escalável para sistemas maiores.

5. **Entendimento Simples:**
  - O código é mais fácil de entender porque há menos dependências complexas.

Em resumo, o acoplamento é uma consideração chave ao projetar sistemas em Java, e reduzir o acoplamento é geralmente um
objetivo desejado para criar sistemas mais flexíveis e fáceis de manter.
#
**Modificadores de Acesso em Java:**

Em Java, os modificadores de acesso são palavras-chave que determinam a visibilidade de classes, métodos, variáveis e
construtores em diferentes partes de um programa. Eles ajudam a controlar o acesso aos membros de uma classe. Existem
quatro tipos principais de modificadores de acesso:

### 1. Public (`public`):
- **Acesso Global:**
  - Membros marcados como `public` são acessíveis de qualquer lugar.
  - Podem ser acessados por qualquer classe ou pacote.

```java
public class Exemplo {
    public int numero;  // Atributo público
    public void metodoPublico() {
        // Método público
    }
}
```

### 2. Private (`private`):
- **Acesso Restrito:**
  - Membros marcados como `private` são acessíveis apenas dentro da própria classe.
  - Não são visíveis fora da classe, mesmo para subclasses.

```java
public class Exemplo {
    private int numero;  // Atributo privado
    private void metodoPrivado() {
        // Método privado
    }
}
```

### 3. Protected (`protected`):
- **Acesso para Subclasses:**
  - Membros marcados como `protected` são acessíveis dentro da mesma classe, pacote e por subclasses.
  - Não são acessíveis fora do pacote se não forem subclasses.

```java
public class Exemplo {
    protected int numero;  // Atributo protegido
    protected void metodoProtegido() {
        // Método protegido
    }
}
```

### 4. Default (Sem Modificador):
- **Acesso Padrão (Pacote):**
  - Se nenhum modificador for especificado, é considerado o acesso padrão.
  - Membros são acessíveis apenas no mesmo pacote.

```java
class Exemplo {
    int numero;  // Atributo com acesso padrão
    void metodoPadrao() {
        // Método com acesso padrão
    }
}
```

### Resumo:
- O modificador `public` oferece o maior nível de acesso.
- O modificador `private` oferece o menor nível de acesso.
- Os modificadores `protected` e padrão fornecem níveis intermediários.

### Dicas:
- **Encapsulamento:**
  - Em geral, é uma boa prática encapsular membros de uma classe usando `private` e fornecer métodos públicos (`getters`
  e `setters`) para acessá-los.

```java
public class Exemplo {
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
```

- **Princípio da Menor Exposição (Princípio do Mínimo Exposto):**
  - Evite expor mais do que é necessário. Limite o acesso aos membros da classe ao mínimo necessário para realizar suas
  tarefas.
#
**Métodos Getters e Setters em Java:**

Os métodos `getters` e `setters` são métodos especiais usados para obter e definir valores em objetos. Eles são uma
parte fundamental do conceito de encapsulamento em programação orientada a objetos. Vamos entender cada um deles:

### 1. Getter (Método de Acesso):

- **Objetivo:**
  - Usado para obter o valor de um atributo privado.

- **Sintaxe Típica:**
  - O nome começa com `get` seguido pelo nome do atributo com a primeira letra em maiúscula.

```java
public class Exemplo {
    private int idade;

    public int getIdade() {
        return idade;
    }
}
```

### 2. Setter (Método Modificador):

- **Objetivo:**
  - Usado para definir o valor de um atributo privado.

- **Sintaxe Típica:**
  - O nome começa com `set` seguido pelo nome do atributo com a primeira letra em maiúscula. Normalmente, tem um
  parâmetro para aceitar o novo valor.

```java
public class Exemplo {
    private int idade;

    public void setIdade(int novaIdade) {
        idade = novaIdade;
    }
}
```

### Exemplo Completo com Encapsulamento:

```java
public class Pessoa {
    // Atributos privados
    private String nome;
    private int idade;

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int novaIdade) {
        idade = novaIdade;
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando uma instância de Pessoa
        Pessoa pessoa = new Pessoa();

        // Usando os setters para definir valores
        pessoa.setNome("Alice");
        pessoa.setIdade(25);

        // Usando os getters para obter valores
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
    }
}
```

### Vantagens do Uso de Getters e Setters:

1. **Encapsulamento:**
  - Os atributos são protegidos e podem ser acessados e modificados apenas por meio de métodos controlados.

2. **Controle de Acesso:**
  - Permite validar ou controlar o acesso e modificação de atributos.

3. **Flexibilidade:**
  - Facilita futuras alterações na implementação interna da classe sem afetar o código externo.

4. **Manutenção do Código:**
  - Facilita a manutenção do código e a detecção de possíveis erros.

Orientação Objetos - Modificador de acesso private, get e set pt 01 [^14].

[^14]: Acesso o vídeo YouTube -> [Maratona Java 54 - Orientação Objetos - Modificador de acesso private, get e set pt 01](https://abre.ai/g9EG).

Orientação Objetos - Modificador de acesso private, get e set pt 02 [^15].

[^15]: Acesso o vídeo YouTube -> [Maratona Java 55 - Orientação Objetos - Modificador de acesso private, get e set pt 02](https://abre.ai/g9EI).

Orientação Objetos - Modificador de acesso private, get e set pt 03 [^16].

[^16]: Acesso o vídeo YouTube -> [Maratona Java 56 - Orientação Objetos - Modificador de acesso private, get e set pt 03](https://abre.ai/g9EK).