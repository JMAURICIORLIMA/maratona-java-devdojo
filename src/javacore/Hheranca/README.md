# Guia para herança em Java

71 - Orientação Obejtos - Herança pt 01[^01]

[^01]: Acesse o vídeo YouTube -> [71 - Orientação Obejtos - Herança pt 01](https://abre.ai/htLG)

Guia para herança em Java - Baeldung [^02]

[^02]: Acesse o site (em ingles) -> [Guia para herança em Java](https://www.baeldung.com/java-inheritance)

## 1. Visão Geral

Um dos princípios fundamentais da Programação Orientada a Objetos – **herança – nos permite reutilizar código existente
ou estender um tipo existente.**

Simplificando, em Java, uma classe pode herdar outra classe e múltiplas interfaces, enquanto uma interface pode herdar
outras interfaces.

Neste artigo, começaremos com a necessidade de herança, passando para como a herança funciona com classes e interfaces.

Em seguida, abordaremos como os nomes de variáveis/métodos e modificadores de acesso afetam os membros que são herdados.

E no final veremos o que significa herdar um tipo.

## 2. A necessidade de herança

Imagine que, como fabricante de automóveis, você oferece vários modelos de automóveis aos seus clientes. Mesmo que
diferentes modelos de carros possam oferecer recursos diferentes, como teto solar ou janelas à prova de balas, todos
eles incluiriam componentes e recursos comuns, como motor e rodas.

Faz sentido **criar um design básico e ampliá-lo para criar suas versões especializadas**, em vez de projetar cada
modelo de carro separadamente, do zero.

De maneira semelhante, com a herança, podemos criar uma classe com características e comportamento básicos e criar suas
versões especializadas, criando classes que herdam essa classe base. Da mesma forma, as interfaces podem estender as
interfaces existentes.

Notaremos o uso de vários termos para se referir a um tipo que é herdado por outro tipo, especificamente:

- **um tipo base também é chamado de tipo super ou pai**
- **um tipo derivado é referido como um tipo estendido, sub ou filho**

## 3. Herança de classe

### 3.1. Estendendo uma aula

Uma classe pode herdar outra classe e definir membros adicionais.
freestar

Vamos começar definindo uma classe base Car :

```java
public class Car {
    int wheels;
    String model;

    void start() {
        // Check essential parts
    }
}
```

A classe ArmoredCar (CarroBlindado) pode herdar os membros da Car classe **usando a palavra-chave extends em sua
declaração**:

```java
public class ArmoredCar extends Car {
    int bulletProofWindows;

    void remoteStartCar() {
        // this vehicle can be started by using a remote control
    }
}
```

Podemos agora dizer que a classe ArmoredCar é uma subclasse de Car, e esta última é uma superclasse de ArmoredCar.

**Classes em Java suportam herança única** ; a classe ArmoredCar não pode estender várias classes.

Além disso, observe que, na ausência de uma palavra-chave extends , uma classe herda implicitamente a classe
java.lang.Object.

**não estáticos _protegidos e Uma classe de subclasse herda os membros_ públicos da classe de superclasse**. Além disso,
os
membros com acesso padrão ( package-private) serão herdados se as duas classes estiverem no mesmo pacote.

Por outro lado, os membros privados e estáticos de uma classe não são herdados.

### 3.2. Acessando membros pais de uma classe filha

Para acessar propriedades ou métodos herdados, podemos simplesmente usá-los diretamente:

```java
public class ArmoredCar extends Car {
    public String registerModel() {
        return model;
    }
}
```

Observe que não precisamos de uma referência à superclasse para acessar seus membros.

## 4. Herança de interface

### 4.1. Implementando Múltiplas Interfaces

**Embora as classes possam herdar apenas uma classe, elas podem implementar múltiplas interfaces.**

Imagine que o ArmoredCar que definimos na seção anterior seja necessário para um superespião. Portanto, a empresa
fabricante de automóveis pensou em adicionar funcionalidades de vôo e flutuação:

```java
public interface Floatable {
    void floatOnWater();
}
```

```java
public interface Flyable {
    void fly();
}
```

```java
public class ArmoredCar extends Car implements Floatable, Flyable {
    public void floatOnWater() {
        System.out.println("I can float!");
    }

    public void fly() {
        System.out.println("I can fly!");
    }
}
```

No exemplo acima, notamos o uso da palavra-chave implements para herdar de uma interface.

### 4.2. Problemas com herança múltipla

Java permite herança múltipla usando interfaces.
freestar

Até o Java 7, isso não era um problema. As interfaces só poderiam definir métodos abstratos , ou seja, métodos sem
qualquer implementação. Portanto, se uma classe implementasse múltiplas interfaces com a mesma assinatura de método, não
seria um problema. A classe de implementação eventualmente tinha apenas um método para implementar.

Vamos ver como essa equação simples mudou com a introdução de métodos padrão nas interfaces, com o Java 8.

**A partir do Java 8, as interfaces podem optar por definir implementações padrão para seus métodos** (uma interface
ainda
pode definir métodos abstratos ). Isso significa que se uma classe implementa múltiplas interfaces, que definem métodos
com a mesma assinatura, a classe filha herdaria implementações separadas. Isso parece complexo e não é permitido.

**Java não permite herança de múltiplas implementações dos mesmos métodos, definidos em interfaces separadas.**

Aqui está um exemplo:

```java
public interface Floatable {
    default void repair() {
        System.out.println("Repairing Floatable object");
    }
}
```

```java
public interface Flyable {
    default void repair() {
        System.out.println("Repairing Flyable object");
    }
}
```

```java
public class ArmoredCar extends Car implements Floatable, Flyable {
    // this won't compile
}
```

Se quisermos implementar ambas as interfaces, teremos que substituir o método repair() .

Se as interfaces nos exemplos anteriores definirem variáveis com o mesmo nome, digamos, duration , não poderemos
acessá-las sem preceder o nome da variável com o nome da interface:

```java
public interface Floatable {
    int duration = 10;
}
```

```java
public interface Flyable {
    int duration = 20;
}
```

```java
public class ArmoredCar extends Car implements Floatable, Flyable {

    public void aMethod() {
        System.out.println(duration); // won't compile
        System.out.println(Floatable.duration); // outputs 10
        System.out.println(Flyable.duration); // outputs 20
    }
}
```

### 4.3. Interfaces que estendem outras interfaces

Uma interface pode estender múltiplas interfaces. Aqui está um exemplo:

```java
public interface Floatable {
    void floatOnWater();
}
```

```java
interface

interface Flyable {
    void fly();
}
```

```java
public interface SpaceTraveller extends Floatable, Flyable {
    void remoteControl();
}
```

Uma interface herda outras interfaces usando a palavra-chave extends . As classes usam a palavra-chave implements para
herdar uma interface.

## 5. Tipo de herança

Quando uma classe herda outra classe ou interface, além de herdar seus membros, ela também herda seu tipo. Isto também
se aplica a uma interface que herda outras interfaces.

Este é um conceito muito poderoso, que permite aos desenvolvedores **programar para uma interface (classe base ou
interface)** , em vez de programar para suas implementações.

Por exemplo, imagine uma condição em que uma organização mantém uma lista dos carros de propriedade de seus
funcionários. É claro que todos os funcionários podem possuir modelos de automóveis diferentes. Então, como podemos nos
referir a diferentes instâncias de carros? Aqui está a solução:

```java
public class Employee {
    private String name;
    private Car car;

    // standard constructor
}
```

Como todas as classes derivadas de Car herdam o tipo Car , as instâncias da classe derivada podem ser referenciadas
usando uma variável da classe Car :

```java
Employee e1=new Employee("Shreya",new ArmoredCar());
        Employee e2=new Employee("Paul",new SpaceCar());
        Employee e3=new Employee("Pavni",new BMW());
```

## 6. Membros da turma ocultos

### 6.1. Membros de instância ocultos

O que acontece se **a superclasse e a subclasse definirem uma variável ou método com o mesmo nome** ? Não se preocupe;
ainda podemos acessar os dois. No entanto, devemos deixar clara a nossa intenção para Java, prefixando a variável ou
método com as palavras-chave this ou super .

A _palavra-chave_ this refere-se à instância em que é usada. A _palavra-chave super_ (como parece óbvia) refere-se à
instância da classe pai:

```java
public class ArmoredCar extends Car {
    private String model;

    public String getAValue() {
        return super.model;   // returns value of model defined in base class Car
        // return this.model;   // will return value of model defined in ArmoredCar
        // return model;   // will return value of model defined in ArmoredCar
    }
}
```

Muitos desenvolvedores usam this e super palavras-chave para declarar explicitamente a qual variável ou método estão se
referindo. No entanto, usá-los com todos os membros pode fazer com que nosso código pareça confuso.

### 6.2. Membros estáticos ocultos

O que acontece **quando nossa classe base e subclasses definem variáveis e métodos estáticos com o mesmo nome** ?
Podemos acessar um membro estático da classe base, na classe derivada, da mesma forma que fazemos para as variáveis ​​de
instância?

Vamos descobrir usando um exemplo:

```java
public class Car {
    public static String msg() {
        return "Car";
    }
}
```

```java
public class ArmoredCar extends Car {
    public static String msg() {
        return super.msg(); // this won't compile.
    }
}
```

Não, não podemos. Os membros estáticos pertencem a uma classe e não a instâncias. Portanto, não podemos usar a super
palavra-chave não estática em _msg()_ .

Como os membros estáticos pertencem a uma classe, podemos modificar a chamada anterior da seguinte forma:

```java
return Car.msg();
```

Considere o exemplo a seguir, no qual tanto a classe base quanto a classe derivada definem um método estático msg() com
a mesma assinatura:

```java
public class Car {
    public static String msg() {
        return "Car";
    }
}
```

```java
public class ArmoredCar extends Car {
    public static String msg() {
        return "ArmoredCar";
    }
}
```

Veja como podemos chamá-los:

```java
Car first=new ArmoredCar();
        ArmoredCar second=new ArmoredCar();
```

Para o código anterior, first.msg() produzirá “Car ” e second.msg() produzirá “ArmoredCar”. A mensagem estática chamada
depende do tipo de variável usada para se referir à ArmoredCar . instância

## 7. Conclusão

Neste artigo, cobrimos um aspecto central da linguagem Java – herança.

Vimos como Java suporta herança única com classes e herança múltipla com interfaces e discutimos as complexidades de
como o mecanismo funciona na linguagem.

# Herança - Super

72 - Orientação Obejtos - Herança pt 02 - Super[^03]

[^03]: Acesse o vídeo YouTube -> [72 - Orientação Obejtos - Herança pt 02 - Super](https://abre.ai/htLY)

A sobrescrita é um conceito importante na programação orientada a objetos que ocorre quando uma subclasse fornece uma
implementação específica para um método que já está sendo fornecido por sua superclasse. A ideia é substituir a
implementação na superclasse por uma implementação específica na subclasse.

Em Java, a sobrescrita é feita quando:

1. **Você tem uma classe pai (superclasse) e uma classe filha (subclasse).**
2. **Ambas as classes têm um método com a mesma assinatura (mesmo nome, mesmo tipo de retorno e mesmos parâmetros).**

Aqui está um exemplo simples:

```java
class Animal {
    void fazerSom() {
        System.out.println("Som genérico de animal");
    }
}

class Cachorro extends Animal {
    // Sobrescrevendo o método fazerSom da superclasse Animal
    void fazerSom() {
        System.out.println("Latido de cachorro");
    }
}
```

No exemplo acima, a classe `Cachorro` herda da classe `Animal` e sobrescreve o método `fazerSom`. Quando você
chama `fazerSom` para uma instância de `Cachorro`, a versão do método na classe `Cachorro` é chamada em vez da versão na
classe `Animal`.

Principais pontos a serem observados:

- A assinatura do método na subclasse deve ser idêntica à assinatura do método na superclasse.
- O modificador de acesso na subclasse não pode ser mais restritivo do que o modificador de acesso na superclasse. Por
  exemplo, se o método é público na superclasse, ele não pode ser privado na subclasse.

```java
// Exemplo de sobrescrita válida
class Animal {
    public void fazerSom() {
        System.out.println("Som genérico de animal");
    }
}

class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Latido de cachorro");
    }
}
```

A anotação `@Override` é opcional, mas é uma boa prática usá-la para indicar explicitamente que você está sobrescrevendo
um método.

A sobrescrita é fundamental para o polimorfismo, pois permite que objetos de diferentes classes sejam tratados de
maneira uniforme quando eles estão na hierarquia de classes.

# Herança - Protected

73 - Orientação Obejtos - Herança pt 03 - Protected[^04]

[^04]: Acesse o vídeo YouTube -> [73 - Orientação Obejtos - Herança pt 03 - Protected](https://abre.ai/htMP)

Em Java, o modificador `protected` é um modificador de acesso que oferece visibilidade a membros (métodos, campos)
dentro da mesma classe, pacote e também por subclasses (mesmo que estejam em pacotes diferentes).

**Características do modificador `protected`:**

1. **Acesso na mesma classe:** Os membros protegidos podem ser acessados dentro da própria classe onde foram declarados.

2. **Acesso no mesmo pacote:** Os membros protegidos também podem ser acessados por classes que estão no mesmo pacote.

3. **Acesso por subclasses:** Membros protegidos podem ser acessados por subclasses, independentemente do pacote ao qual
   as subclasses pertencem.

Aqui está um exemplo simples para ilustrar:

```java
// Classe no mesmo pacote que contém membros protegidos
class Animal {
    // Membro protegido
    protected void comer() {
        System.out.println("Animal comendo");
    }
}

// Subclasse que estende Animal
class Cachorro extends Animal {
    void comerComRacao() {
        // Pode acessar o método protegido da superclasse
        comer();
        System.out.println("Cachorro comendo ração");
    }
}

// Outra classe no mesmo pacote
class TesteProtegido {
    public static void main(String[] args) {
        Animal animal = new Animal();
        // Mesmo pacote, pode acessar o método protegido
        animal.comer();

        Cachorro cachorro = new Cachorro();
        // Mesmo pacote, pode acessar o método protegido
        cachorro.comer();
        // Pode chamar o novo método definido na subclasse
        cachorro.comerComRacao();
    }
}
```

No exemplo acima:

- `comer()` é um método protegido em `Animal`.
- `Cachorro`, que estende `Animal`, pode acessar esse método protegido diretamente.
- `TesteProtegido`, que está no mesmo pacote, também pode acessar o método protegido diretamente.

A herança com membros protegidos é frequentemente usada para permitir que subclasses acessem ou modifiquem certos
aspectos do comportamento da superclasse, mantendo outros membros encapsulados.

# Herança Construtores

74 - Orientação Obejtos - Herança pt 04 - Construtores[^05]

[^05]: Acesse o vídeo YouTube -> [74 - Orientação Obejtos - Herança pt 04 - Construtores](https://abre.ai/htNg)

Na herança em Java, quando você cria uma subclasse (filha) que estende uma superclasse (pai), pode ser necessário chamar
o construtor da superclasse a partir do construtor da subclasse. Isso é feito usando a palavra-chave `super`.

**Sintaxe para chamar o construtor da superclasse:**

```java
super(); // Chama o construtor padrão da superclasse
        super(argumentos); // Chama um construtor específico da superclasse com argumentos
```

A chamada para `super()` ou `super(argumentos)` deve ser a primeira instrução no construtor da subclasse. Isso ocorre
porque o construtor da superclasse é chamado antes do código da subclasse ser executado.

**Exemplo:**

Considere uma classe de Animal com um construtor que inicializa o nome do animal. A classe `Cachorro` estende `Animal` e
tem seu próprio construtor que também inicializa uma variável específica da classe `Cachorro`. Aqui está um exemplo:

```java
class Animal {
    private String nome;

    // Construtor da superclasse
    public Animal(String nome) {
        this.nome = nome;
        System.out.println("Construindo um animal com nome " + nome);
    }
}

class Cachorro extends Animal {
    private String raca;

    // Construtor da subclasse
    public Cachorro(String nome, String raca) {
        super(nome); // Chama o construtor da superclasse
        this.raca = raca;
        System.out.println("Construindo um cachorro da raça " + raca);
    }
}

public class Main {
    public static void main(String[] args) {
        Cachorro meuCachorro = new Cachorro("Buddy", "Labrador");
    }
}
```

Neste exemplo:

- `Animal` tem um construtor que inicializa o nome.
- `Cachorro` estende `Animal` e tem seu próprio construtor que inicializa a raça, mas antes disso, chama o construtor da
  superclasse para inicializar o nome.

Ao criar uma instância de `Cachorro`, o construtor de `Animal` é chamado primeiro (graças ao `super(nome)`), seguido
pelo construtor de `Cachorro`. Isso garante que a inicialização da parte relacionada ao `Animal` seja tratada antes de
qualquer coisa específica do `Cachorro`.