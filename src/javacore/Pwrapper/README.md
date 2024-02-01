# Classes de wrapper em Java [^01]

[^01]: Acesse o site em inglês - Baeldung -> [Classes de wrapper em Java](https://www.baeldung.com/java-wrapper-classes)

## 106 - Classes Utilitárias - Wrappers pt 01[^02]

[^02]: Assita o vídeo no Youtube -> [106 - Classes Utilitárias - Wrappers pt 01](https://abre.ai/iKDI)

"Classes Utilitárias Wrapper" geralmente se refere a classes que encapsulam ou envolvem objetos primitivos em linguagens
de programação que suportam tipos primitivos e objetos. O objetivo principal dessas classes é fornecer métodos úteis
para trabalhar com os tipos primitivos de maneira mais flexível, aproveitando o conceito de orientação a objetos.

Por exemplo, em Java, existem classes wrapper para tipos primitivos, como `Integer`, `Double`, `Boolean`, etc. Essas
classes permitem que você realize operações mais complexas com tipos primitivos, além de fornecer métodos auxiliares
úteis.

Aqui está um exemplo de como você pode usar as classes wrapper em Java:

```java
public class Main {
    public static void main(String[] args) {
        // Exemplo com Integer
        Integer num1 = new Integer(10); // Criando um objeto Integer
        int value1 = num1.intValue(); // Obtendo o valor primitivo
        System.out.println("Value1: " + value1);

        // Exemplo com Double
        Double num2 = new Double(5.5);
        double value2 = num2.doubleValue();
        System.out.println("Value2: " + value2);

        // Exemplo com Boolean
        Boolean bool = new Boolean(true);
        boolean value3 = bool.booleanValue();
        System.out.println("Value3: " + value3);
    }
}
```

Além disso, as classes wrapper fornecem métodos estáticos para converter strings em tipos primitivos e vice-versa, o que
pode ser útil em algumas situações:

```java
public class Main {
    public static void main(String[] args) {
        // Convertendo String para int
        String str = "123";
        int intValue = Integer.parseInt(str);
        System.out.println("Converted to int: " + intValue);

        // Convertendo String para double
        String str2 = "3.14";
        double doubleValue = Double.parseDouble(str2);
        System.out.println("Converted to double: " + doubleValue);

        // Convertendo int para String
        int num = 456;
        String strValue = Integer.toString(num);
        System.out.println("Converted to String: " + strValue);
    }
}
```

Essas classes wrapper fornecem funcionalidades adicionais e são úteis em situações onde você precisa trabalhar com tipos
primitivos como objetos.

## 107 - Classes Utilitárias - Wrappers pt 02[^03]

[^03]: Assita o vídeo no Youtube -> [107 - Classes Utilitárias - Wrappers pt 02](https://abre.ai/iKG5)

O autoboxing e o unboxing são recursos introduzidos no Java que simplificam o uso de classes wrapper para tipos
primitivos. Eles permitem que você atribua valores diretamente entre tipos primitivos e suas classes wrapper
correspondentes, sem a necessidade de chamar explicitamente os métodos de conversão.

**Autoboxing**:
É o processo pelo qual um tipo primitivo é automaticamente convertido para seu correspondente objeto wrapper quando é
necessário. Isso ocorre quando você atribui um valor primitivo a uma variável de um tipo wrapper.

**Unboxing**:
É o oposto do autoboxing. É o processo pelo qual um objeto wrapper é automaticamente convertido para seu tipo primitivo
correspondente quando é necessário. Isso ocorre quando você atribui um objeto wrapper a uma variável de um tipo
primitivo.

Aqui está um exemplo que demonstra tanto o autoboxing quanto o unboxing em Java:

```java
public class Main {
    public static void main(String[] args) {
        // Autoboxing: int -> Integer
        Integer num1 = 10;

        // Unboxing: Integer -> int
        int value1 = num1;

        System.out.println("Autoboxing: " + num1);
        System.out.println("Unboxing: " + value1);

        // Autoboxing: double -> Double
        Double num2 = 5.5;

        // Unboxing: Double -> double
        double value2 = num2;

        System.out.println("Autoboxing: " + num2);
        System.out.println("Unboxing: " + value2);
    }
}
```

Neste exemplo:

- `num1` é um `Integer` que é inicializado com um valor primitivo `int` (autoboxing).
- `value1` é uma variável `int` que é inicializada com o valor primitivo dentro de `num1` (unboxing).
- Similarmente, `num2` é um `Double` inicializado com um valor primitivo `double`, e `value2` é uma variável `double`
  inicializada com o valor primitivo dentro de `num2`.

Esses recursos tornam o código mais legível e menos propenso a erros, reduzindo a necessidade de converter
explicitamente entre tipos primitivos e suas classes wrapper.