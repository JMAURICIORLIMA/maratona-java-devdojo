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