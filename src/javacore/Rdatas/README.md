# Introdução à API de data/hora do Java 8 [^01]

[^01]: Acesse o site em inglês -
Baeldung -> [Introdução à API de data/hora do Java 8](https://www.baeldung.com/java-8-date-time-intro)

## 112 - Classes Utilitárias - Date[^02]

[^02]: Assita o vídeo no Youtube -> [112 - Classes Utilitárias - Date](https://abre.ai/iOQR)

A classe `Date` em Java é uma das classes mais antigas para lidar com datas e horas, embora tenha algumas limitações e
problemas de design. Ela representa um ponto no tempo, com precisão de milissegundos, desde a "epoch" (1 de janeiro de
1970, 00:00:00 UTC). No entanto, há algumas considerações importantes a serem feitas ao trabalhar com esta classe:

1. **Depreciação**: A classe `Date` foi marcada como obsoleta e foi substituída por classes mais modernas,
   como `java.time.LocalDate`, `java.time.LocalDateTime`, `java.time.ZonedDateTime`, etc., introduzidas no Java 8. Estas
   novas classes fazem parte do pacote `java.time`, que fornece uma API mais robusta e funcionalidades avançadas para
   manipulação de datas e horas.

2. **Mutabilidade**: A classe `Date` é mutável, o que pode levar a problemas de concorrência em ambientes multithreaded,
   uma vez que não é thread-safe. Isso significa que modificações em uma instância de `Date` podem afetar outras partes
   do código, resultando em comportamento inesperado.

3. **Precisão**: A classe `Date` fornece precisão até milissegundos, mas não é capaz de representar datas anteriores
   ao "epoch" ou datas após o ano 2038 (devido às limitações do tipo `long` usado para armazenar o tempo em
   milissegundos).

4. **Conversão**: É comum a necessidade de converter entre `Date` e as novas classes de data/hora introduzidas no Java
   8. Para isso, é recomendável usar os métodos `toInstant()`, `toLocalDate()`, `toLocalDateTime()`, etc., para
   converter de `Date` para os tipos desejados, e os métodos `from()` ou `valueOf()` para converter de tipos modernos
   para `Date`.

5. **Formatação e Parsing**: A classe `Date` não possui métodos dedicados para formatação e parsing de strings, o que
   muitas vezes requer o uso da classe `SimpleDateFormat`. No entanto, essa classe é conhecida por ser thread-unsafe e
   propensa a erros de parsing. As novas classes de data/hora fornecem métodos mais seguros e eficientes para formatação
   e parsing.

Aqui está um exemplo simples de uso da classe `Date`:

```java
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(); // Cria uma instância de Date representando o momento atual

        System.out.println("Data atual: " + date);
    }
}
```

Apesar da classe `Date` ainda ser suportada por razões de compatibilidade, é altamente recomendável utilizar as classes
modernas do pacote `java.time` para novos desenvolvimentos, devido à sua melhor funcionalidade, robustez e segurança.
