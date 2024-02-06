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

## 109 - Classes Utilitárias - Strings pt 02[^03]

[^03]: Assita o vídeo no Youtube -> [109 - Classes Utilitárias - Strings pt 02](https://abre.ai/iK5L)

A classe `String` em Java fornece uma ampla gama de métodos para manipulação e operações em strings. Abaixo estão alguns
dos métodos mais comumente usados da classe `String`:

1. **length()**: Retorna o comprimento da string.

```java
String str = "Hello";
int length = str.length(); // Retorna 5
```

2. **charAt(int index)**: Retorna o caractere na posição especificada pelo índice.

```java
char ch = str.charAt(0); // Retorna 'H'
```

3. **substring(int beginIndex)** ou **substring(int beginIndex, int endIndex)**: Retorna uma substring da string,
   começando do `beginIndex` até o `endIndex` (opcional).

```java
String sub1 = str.substring(2); // Retorna "llo"
String sub2 = str.substring(1, 3); // Retorna "el"
```

4. **equals(Object obj)** ou **equalsIgnoreCase(String anotherString)**: Verifica se duas strings são iguais (sensível
   ou não a maiúsculas e minúsculas).

```java
boolean isEqual = str.equals("Hello");
boolean isEqualIgnoreCase = str.equalsIgnoreCase("hello");
```

5. **toUpperCase()** ou **toLowerCase()**: Converte a string para maiúsculas ou minúsculas.

```java
String upperCaseStr = str.toUpperCase(); // Retorna "HELLO"
String lowerCaseStr = str.toLowerCase(); // Retorna "hello"
```

6. **indexOf(String str)** ou **indexOf(String str, int fromIndex)**: Retorna o índice da primeira ocorrência de uma
   substring na string.

```java
int index1 = str.indexOf("l"); // Retorna 2
int index2 = str.indexOf("l", 3); // Retorna 3
```

7. **startsWith(String prefix)** ou **endsWith(String suffix)**: Verifica se a string começa ou termina com a substring
   especificada.

```java
boolean startsWith = str.startsWith("He"); // Retorna true
boolean endsWith = str.endsWith("lo"); // Retorna true
```

8. **replace(char oldChar, char newChar)** ou **replace(CharSequence target, CharSequence replacement)**: Substitui
   todas as ocorrências de um caractere ou substring na string por outra.

```java
String replacedStr = str.replace('l', 'x'); // Retorna "Hexxo"
String replacedStr2 = str.replace("l", "x"); // Retorna "Hexxo"
```

Esses são apenas alguns dos métodos oferecidos pela classe `String` em Java. Existem muitos outros métodos disponíveis
para realizar várias operações de manipulação de strings, como divisão, concatenação, remoção de espaços em branco, etc.
Sempre que precisar realizar uma operação específica em uma string, é útil verificar a documentação oficial da
classe `String` para encontrar o método apropriado.

## 110 - Classes Utilitárias - Strings pt 03 - Desempenho[^04]

[^04]: Assita o vídeo no Youtube -> [110 - Classes Utilitárias - Strings pt 03 - Desempenho](https://abre.ai/iK6t)

## 111 - Classes Utilitárias - Strings pt 04 - StringBuilder[^05]

[^05]: Assita o vídeo no Youtube -> [111 - Classes Utilitárias - Strings pt 04 - StringBuilder](https://abre.ai/iOOY)

As três classes - `String`, `StringBuilder`, e `StringBuffer` - em Java são usadas para manipulação de strings, mas têm
diferenças importantes em termos de mutabilidade, desempenho e concorrência. Aqui estão as principais diferenças entre
elas:

1. **Imutabilidade**:
    - **String**: Strings em Java são imutáveis, o que significa que uma vez criadas, elas não podem ser modificadas.
      Qualquer operação que pareça modificar uma string na verdade cria uma nova string.
    - **StringBuilder** e **StringBuffer**: Ambas são mutáveis, permitindo a modificação do conteúdo da string sem criar
      novas instâncias. Isso as torna mais eficientes em operações de manipulação de strings que envolvem muitas
      alterações.

2. **Desempenho**:
    - **String**: Devido à imutabilidade, operações que modificam strings (`concat()`, `replace()`, etc.) podem ser
      menos eficientes, especialmente em loops ou em casos de manipulação intensiva de strings.
    - **StringBuilder**: É otimizado para manipulação eficiente de strings mutáveis. Ideal para cenários em que a
      concatenação ou a manipulação de strings envolve muitas operações e pode mudar frequentemente.
    - **StringBuffer**: Similar ao `StringBuilder`, mas é sincronizado (thread-safe), o que significa que é mais lento
      devido ao overhead de sincronização. É preferível usar `StringBuilder` em cenários onde a sincronização não é
      necessária.

3. **Concorrência**:
    - **String**: Como as strings são imutáveis, elas são seguras para uso em ambientes concorrentes sem necessidade de
      sincronização.
    - **StringBuilder**: Não é sincronizado, o que o torna mais rápido, mas não é seguro para uso em ambientes
      concorrentes sem sincronização adicional.
    - **StringBuffer**: É sincronizado, tornando-o seguro para uso em ambientes concorrentes. No entanto, devido à
      sincronização, pode ser menos eficiente em comparação com `StringBuilder` em cenários não concorrentes.

4. **Uso adequado**:
    - Use `String` quando a string for imutável e não precisar ser modificada.
    - Use `StringBuilder` quando precisar manipular strings mutáveis de forma eficiente, especialmente em cenários com
      muitas operações de concatenação ou manipulação.
    - Use `StringBuffer` apenas em casos onde a sincronização é necessária devido a requisitos de concorrência,
      pois `StringBuilder` geralmente tem melhor desempenho em cenários não concorrentes.

Em resumo, a escolha entre `String`, `StringBuilder` e `StringBuffer` depende das necessidades específicas do seu
aplicativo, incluindo a natureza das operações de manipulação de strings, desempenho e requisitos de concorrência.