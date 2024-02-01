# Tudo sobre String em Java [^01]

[^01]: Acesse o site em inglês - Baeldung -> [Tudo sobre String em Java](https://www.baeldung.com/java-string)

## 108 - Classes Utilitárias - Strings pt 01[^02]

[^02]: Assita o vídeo no Youtube -> [108 - Classes Utilitárias - Strings pt 01](https://abre.ai/iK2w)

Um "pool de strings" refere-se a uma área na memória onde as strings são armazenadas de forma eficiente para promover a
reutilização e economizar recursos. Em muitas linguagens de programação, incluindo Java, as strings são objetos
imutáveis, o que significa que uma vez criadas, elas não podem ser modificadas. Como resultado, em vez de criar novas
instâncias de strings idênticas toda vez que elas são usadas, os sistemas podem economizar memória armazenando apenas
uma única instância de cada string e reutilizando-a quando necessário.

Em Java, o pool de strings é uma parte importante do comportamento da linguagem. Quando você cria uma string literal (
por exemplo, `"hello"`), o Java verifica se uma string com o mesmo conteúdo já está no pool de strings. Se estiver, ele
reutiliza essa instância existente em vez de criar uma nova. Isso é conhecido como "interning" da string.

Por exemplo:

```java
String str1 = "hello";
String str2 = "hello";
String str3 = new String("hello");

System.out.

println(str1 ==str2); // true (ambas apontam para a mesma instância no pool de strings)
System.out.

println(str1 ==str3); // false (str3 é uma nova instância criada explicitamente)
System.out.

println(str1.equals(str3)); // true (o conteúdo das strings é o mesmo)
```

Neste exemplo, `str1` e `str2` apontam para a mesma instância no pool de strings porque são literais de strings
idênticas. No entanto, `str3` é uma nova instância criada explicitamente usando o operador `new`, portanto não está no
pool de strings e não é igual a `str1` ou `str2` em termos de referência (`==`), mas seu conteúdo é igual (`equals()`).

O pool de strings é uma técnica eficaz para otimizar o uso de memória em programas que fazem uso intensivo de strings,
garantindo que strings idênticas sejam armazenadas apenas uma vez na memória. Isso é especialmente útil em situações em
que você precisa manipular muitas strings com o mesmo conteúdo.