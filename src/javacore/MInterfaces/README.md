# Interfaces Java[^01]

[^01]: Acesse o site em inglês -> [Interfaces Java](https://www.baeldung.com/java-interfaces)

## 87 - Orientação Objetos - Interfaces pt 01 - Introdução[^02]

[^02]: Assita o vídeo no Youtube -> [87 - Orientação Objetos - Interfaces pt 01 - Introdução](https://abre.ai/hCoV)

## 1. Visão Geral

Neste tutorial, falaremos sobre interfaces em Java. Veremos também como Java os utiliza para implementar polimorfismo e
heranças múltiplas.

## 2. O que são interfaces em Java?

Em Java, uma interface é um tipo abstrato que contém uma coleção de métodos e variáveis constantes. É um dos conceitos
centrais em Java e é usado para obter abstração, polimorfismo e heranças múltiplas.

Vejamos um exemplo simples de interface em Java:

```java
public interface Electronic {

    // Constant variable
    String LED = "LED";

    // Abstract method
    int getElectricityUse();

    // Static method
    static boolean isEnergyEfficient(String electtronicType) {
        if (electtronicType.equals(LED)) {
            return true;
        }
        return false;
    }

    //Default method
    default void printDescription() {
        System.out.println("Electronic Description");
    }

}
```

Podemos implementar uma interface em uma classe Java usando a palavra-chave implements.

A seguir, vamos criar também uma classe Computer que implemente a interface Electronic que acabamos de criar:

```java
public class Computer implements Electronic {

    @Override
    public int getElectricityUse() {
        return 1000;
    }

}
```

### 2.1. Regras para criação de interfaces

Em umvariáveis constantesa interface, podemos usar:

- [variáveis constantes](https://www.baeldung.com/java-final)
- [métodos abstratos](https://www.baeldung.com/java-abstract-class)
- [métodos estáticos](https://www.baeldung.com/java-static-default-methods)
- [métodos padrão](https://www.baeldung.com/java-static-default-methods)

Também devemos lembrar que:

- não podemos instanciar interfaces diretamente
- uma interface pode estar vazia, sem métodos ou variáveis nela
- não podemos usar a palavra final na definição da interface, pois isso resultará em um erro do compilador
- todas as declarações de interface devem ter o modificador de acesso público ou padrão; o modificador abstrato será
  adicionado automaticamente pelo compilador
- um método de interface não pode ser protegido ou final
- até Java 9, os métodos de interface não podiam ser privados; entretanto, Java 9 introduziu a possibilidade de definir
  métodos privados em interfaces
- variáveis de interface são public, static e final por definição; não temos permissão para alterar sua visibilidade

## 3. O que podemos conseguir usando-os?

### 3.1. Funcionalidade Comportamental

Usamos interfaces para adicionar certas funcionalidades comportamentais que podem ser usadas por classes não
relacionadas. Por exemplo, Comparable, Comparator e Cloneable são interfaces Java que podem ser implementadas por
classes não relacionadas. Abaixo está um exemplo da Comparator interface usada para comparar duas instâncias da classe
Employee:

```java
public class Employee {

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employeeA, Employee employeeB) {
        if (employeeA.getSalary() < employeeB.getSalary()) {
            return -1;
        } else if (employeeA.getSalary() > employeeB.getSalary()) {
            return 1;
        } else {
            return 0;
        }
    }

}
```

Para obter mais informações, visite nosso tutorial
sobre [Comparador e Comparable em Java](https://www.baeldung.com/java-comparator-comparable).

### 3.2. Múltiplas Heranças

As classes Java suportam herança singular. No entanto, usando interfaces, também podemos implementar heranças múltiplas.

Por exemplo, no exemplo abaixo, notamos que a classe Car implementa as interfaces Fly e Transform. Ao fazer isso, ele
herda os métodos fly e transform:

```java
public interface Transform {
    void transform();
}

public interface Fly {
    void fly();
}

public class Car implements Fly, Transform {

    @Override
    public void fly() {
        System.out.println("I can Fly!!");
    }

    @Override
    public void transform() {
        System.out.println("I can Transform!!");
    }

}
```

### 3.3. Polimorfismo

Vamos começar perguntando: o que é polimorfismo? É a capacidade de um objeto assumir diferentes formas durante o tempo
de execução. Para ser mais específico, é a execução do método override relacionado a um tipo de objeto específico em
tempo de execução.

Em Java, podemos alcançar polimorfismo usando interfaces. Por exemplo, a interface Shape pode assumir diferentes
formas – pode ser um Círculo ou um Quadrado.

Vamos começar definindo a interface Shape:

```java
public interface Shape {
    String name();
}

Agora vamos
criar também
a Circle :classe

public class Circle implements Shape {

    @Override
    public String name() {
        return "Circle";
    }

}
```

E também a classe Square:

```java
public class Square implements Shape {

    @Override
    public String name() {
        return "Square";
    }

}
```

Finalmente, é hora de ver o polimorfismo em ação usando nossa interface Shape e suas implementações. Vamos instanciar
alguns objetos Shape, adicioná-los a um List e, finalmente, imprimir seus nomes em um loop:

```java
List<Shape> shapes = new ArrayList<>();
Shape circleShape = new Circle();
Shape squareShape = new Square();

shapes.

add(circleShape);
shapes.

add(squareShape);

for(
Shape shape :shapes){
        System.out.

println(shape.name());
        }
```

## 4. Métodos padrão em interfaces

As interfaces tradicionais em Java 7 e anteriores não oferecem compatibilidade com versões anteriores.

O que isso significa é que se você tiver código legado escrito em Java 7 ou anterior e decidir adicionar um método
abstrato a uma interface existente, todas as classes que implementam essa interface deverão substituir o novo método
abstrato. Caso contrário, o código será quebrado.

Java 8 resolveu esse problema introduzindo o método padrão que é opcional e pode ser implementado no nível da interface.

## 5. Regras de herança de interface

Para conseguir heranças múltiplas através de interfaces, temos que lembrar algumas regras. Vamos examinar isso em
detalhes.

### 5.1. Interface estendendo outra interface

Quando uma interface estende outra interface, ela herda todos os métodos abstratos dessa interface. Vamos começar
criando duas interfaces, HasColor e Shape:

```java
public interface HasColor {
    String getColor();
}

public interface Box extends HasColor {
    int getHeight()
}
```

No exemplo acima, Box herda de HasColor usando a palavra-chave extends. Ao fazer isso, a interface Box herda getColor.
Como resultado, a interface Box agora possui dois métodos: getColor e getHeight.

### 5.2. Classe abstrata implementando uma interface

Quando uma classe abstrata implementa uma interface, ela herda todos os seus métodos padrão e abstratos. Vamos
considerar a interface Transform e a classe abstrata Vehicle que a implementa:

```java
public interface Transform {

    void transform();

    default void printSpecs() {
        System.out.println("Transform Specification");
    }

}

public abstract class Vehicle implements Transform {
}
```

Neste exemplo, a classe Vehicle herda dois métodos: o método abstract transform e o método printSpecs padrão.

## 6. Interfaces Funcionais

Java teve muitas interfaces funcionais desde seus primeiros dias, como Comparable (desde Java 1.2) e Runnable (desde
Java 1.0).

Java 8 introduziu novas interfaces funcionais, como Predicate, Consumer e Function. Para saber mais sobre isso, visite
nosso tutorial sobre [Interfaces Funcionais em Java 8](https://www.baeldung.com/java-8-functional-interfaces).

7. Conclusão

Neste tutorial, demos uma visão geral das interfaces Java e falamos sobre como usá-las para obter polimorfismo e
heranças múltiplas.

# **Interfaces em Java: Uma Introdução Completa**

Em Java, uma interface é uma coleção de métodos abstratos. Diferentemente de uma classe abstrata, uma interface pode
conter apenas métodos abstratos e campos finais (constantes). As interfaces são usadas para definir contratos para as
classes que a implementam.

Aqui estão alguns conceitos importantes sobre interfaces em Java:

### Declaração de uma Interface

```java
public interface ExemploInterface {
    // Campos (implicitamente estáticos e finais)
    int NUMERO = 42;

    // Métodos (implicitamente abstratos)
    void metodo1();

    String metodo2(int parametro);
}
```

### Implementação de uma Interface

```java
public class MinhaClasse implements ExemploInterface {
    // Implementação dos métodos da interface
    @Override
    public void metodo1() {
        System.out.println("Implementação do método 1");
    }

    @Override
    public String metodo2(int parametro) {
        return "Implementação do método 2 com parâmetro: " + parametro;
    }
}
```

### Herança Múltipla

Java permite que uma classe implemente várias interfaces. Isso é útil para permitir a herança múltipla de
comportamentos.

```java
public class MinhaClasse implements Interface1, Interface2 {
    // Implementação dos métodos das interfaces
    // ...
}
```

### Campos em Interfaces

Os campos em interfaces são implicitamente estáticos, finais e públicos. Isso significa que eles são constantes e
compartilhados por todas as classes que implementam a interface.

### Métodos Default

A partir do Java 8, interfaces podem ter métodos default. Isso permite que você adicione métodos a uma interface sem
quebrar as implementações existentes.

```java
public interface NovaInterface {
    default void novoMetodo() {
        System.out.println("Novo método adicionado a partir do Java 8");
    }
}
```

### Métodos Estáticos

A partir do Java 8, interfaces podem ter métodos estáticos.

```java
public interface InterfaceEstatica {
    static void metodoEstatico() {
        System.out.println("Método estático na interface");
    }
}
```

### Uso de Interfaces

As interfaces são frequentemente usadas para definir contratos comuns entre várias classes. Elas fornecem uma maneira de
alcançar a abstração e a flexibilidade nas relações entre objetos.

```java
ExemploInterface objeto = new MinhaClasse();
objeto.

metodo1();
```

Esses são os conceitos fundamentais das interfaces em Java. Elas são uma parte essencial da linguagem para alcançar a
abstração e fornecer uma estrutura de herança eficiente e flexível.

# Implementeção múltiplas interfaces

## 88 - Orientação Objetos - Interfaces pt 02 - Implementando múltiplas interfaces [^03]

[^03]: Assita o vídeo no
Youtube -> [88 - Orientação Objetos - Interfaces pt 02 - Implementando múltiplas interfaces](https://abre.ai/hCqB)

**Implementação de Múltiplas Interfaces em Java**

Em Java, uma classe pode implementar várias interfaces, o que permite que ela herde comportamentos de diferentes fontes.
Vamos explorar como isso é feito e entender alguns conceitos relacionados.

### Sintaxe Básica:

```java
public class MinhaClasse implements Interface1, Interface2 {
    // Implementação dos métodos das interfaces
    // ...
}
```

### Exemplo Prático:

```java
// Interface 1
interface Animal {
    void fazerSom();
}

// Interface 2
interface Corredor {
    void correr();
}

// Classe que implementa ambas as interfaces
class Cachorro implements Animal, Corredor {
    @Override
    public void fazerSom() {
        System.out.println("Latindo...");
    }

    @Override
    public void correr() {
        System.out.println("Correndo...");
    }
}

public class Exemplo {
    public static void main(String[] args) {
        // Criando uma instância da classe que implementa ambas as interfaces
        Cachorro meuCachorro = new Cachorro();

        // Chamando métodos das interfaces
        meuCachorro.fazerSom();
        meuCachorro.correr();
    }
}
```

Neste exemplo, a classe `Cachorro` implementa tanto a interface `Animal` quanto a interface `Corredor`. Isso significa
que ela precisa fornecer uma implementação para todos os métodos dessas interfaces.

### Múltiplas Interfaces com Métodos Conflitantes:

Se duas interfaces têm métodos com a mesma assinatura, a classe que as implementa deve fornecer uma implementação
específica para resolver o conflito.

```java
interface InterfaceA {
    void metodoComum();
}

interface InterfaceB {
    void metodoComum();
}

class MinhaClasse implements InterfaceA, InterfaceB {
    @Override
    public void metodoComum() {
        System.out.println("Implementação específica");
    }
}
```

### Vantagens de Múltiplas Interfaces:

1. **Reutilização de Código:** Permite que uma classe reutilize funcionalidades de diferentes fontes.

2. **Flexibilidade:** Permite que as classes sejam adaptáveis a diferentes contextos através da implementação de
   interfaces específicas.

3. **Design Modular:** Facilita o design modular ao dividir funcionalidades em interfaces independentes.

### Cuidados ao Usar Múltiplas Interfaces:

1. **Conflitos de Nomes de Métodos:** Certifique-se de resolver conflitos de nomes de métodos quando ocorrerem.

2. **Coerência Lógica:** Certifique-se de que a classe que implementa várias interfaces faz sentido do ponto de vista
   lógico.

Ao entender e aplicar corretamente a implementação de múltiplas interfaces, você pode criar classes mais flexíveis e
reutilizáveis em seus programas Java.

# **Interfaces com Atributos e Métodos Estáticos em Java**

## 89 - Orientação Objetos - Interfaces pt 03 - Atributos e métodos estáticos [^04]

[^04]: Assita o vídeo no
Youtube -> [89 - Orientação Objetos - Interfaces pt 03 - Atributos e métodos estáticos](https://abre.ai/hCsm)

Em Java, a partir da versão 8, interfaces podem ter métodos e atributos estáticos. Vamos entender como isso funciona.

### Métodos Estáticos em Interfaces:

```java
interface MinhaInterface {
    // Método estático
    static void meuMetodoEstatico() {
        System.out.println("Método estático na interface.");
    }

    // Outros métodos (pode haver métodos padrão também)
    void meuMetodoNormal();
}

class MinhaClasse implements MinhaInterface {
    @Override
    public void meuMetodoNormal() {
        System.out.println("Método normal implementado na classe.");
    }
}

public class Exemplo {
    public static void main(String[] args) {
        // Chamando o método estático diretamente da interface
        MinhaInterface.meuMetodoEstatico();

        // Criando uma instância da classe
        MinhaClasse minhaInstancia = new MinhaClasse();
        minhaInstancia.meuMetodoNormal();
    }
}
```

Neste exemplo, a interface `MinhaInterface` possui um método estático `meuMetodoEstatico()`. Esse método pode ser
chamado diretamente da interface sem a necessidade de uma instância da classe que a implementa.

### Atributos Estáticos em Interfaces:

```java
interface OutraInterface {
    // Atributo estático (constante)
    int MIN_VALOR = 0;

    // Método normal
    void meuOutroMetodo();
}

class OutraClasse implements OutraInterface {
    @Override
    public void meuOutroMetodo() {
        System.out.println("Método normal implementado na outra classe.");
        System.out.println("Valor mínimo: " + MIN_VALOR); // Acessando o atributo estático
    }
}

public class SegundoExemplo {
    public static void main(String[] args) {
        // Criando uma instância da classe
        OutraClasse outraInstancia = new OutraClasse();
        outraInstancia.meuOutroMetodo();
    }
}
```

Aqui, a interface `OutraInterface` possui um atributo estático `MIN_VALOR`. Esse atributo pode ser acessado diretamente
da interface ou através da classe que a implementa.

### Considerações:

1. Métodos estáticos em interfaces são úteis para fornecer utilidades relacionadas à interface, que podem ser
   compartilhadas por todas as classes que a implementam.

2. Atributos estáticos em interfaces geralmente são usados para definir constantes que são relevantes para todas as
   classes que implementam a interface.

3. Métodos e atributos estáticos em interfaces são implicitamente públicos, estáticos e finais.

4. A partir do Java 9, interfaces podem ter métodos privados e métodos privados estáticos. Isso é útil para compartilhar
   código entre métodos padrão sem expor esses métodos ao mundo exterior.

```java
interface MinhaInterface {
    // Método público
    default void meuMetodoPublico() {
        // Chama o método privado
        meuMetodoPrivado();
    }

    // Método privado
    private void meuMetodoPrivado() {
        System.out.println("Método privado na interface.");
    }
}
```

Esse recurso ajuda a evitar a duplicação de código em métodos padrão dentro de uma interface.