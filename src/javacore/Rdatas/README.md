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
       converter de `Date` para os tipos desejados, e os métodos `from()` ou `valueOf()` para converter de tipos
       modernos
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

# Guia para java.util.GregorianCalendar [^02]

[^02]: Acesse o site em inglês -
Baeldung -> [Guia para java.util.GregorianCalendar](https://www.baeldung.com/java-gregorian-calendar)

## 113 - Classes Utilitárias - Calendar[^04]

[^04]: Assita o vídeo no Youtube -> [113 - Classes Utilitárias - Calendar](https://abre.ai/iOSf)

A classe `Calendar` em Java fornece um conjunto de métodos para trabalhar com datas e horas em um calendário específico.
Ela é abstrata e não pode ser instanciada diretamente. Em vez disso, você deve usar o método estático `getInstance()`
para obter uma instância de `Calendar` com base na localidade e no fuso horário padrão do sistema.

Aqui está um exemplo de como usar a classe `Calendar` para obter e manipular datas:

```java
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Obtendo uma instância de Calendar com base no fuso horário padrão do sistema
        Calendar calendar = Calendar.getInstance();

        // Obtendo e imprimindo o ano atual
        int year = calendar.get(Calendar.YEAR);
        System.out.println("Ano atual: " + year);

        // Configurando uma data específica (por exemplo, 31 de dezembro de 2022)
        calendar.set(2022, Calendar.DECEMBER, 31);

        // Adicionando um dia à data atual
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        // Imprimindo a nova data
        System.out.println("Nova data: " + calendar.getTime());
    }
}
```

Neste exemplo:

- Primeiro, obtém-se uma instância de `Calendar` usando `Calendar.getInstance()`.
- Em seguida, o ano atual é obtido usando `calendar.get(Calendar.YEAR)`.
- Depois, uma data específica é configurada usando `calendar.set(2022, Calendar.DECEMBER, 31)`.
- Um dia é adicionado à data atual usando `calendar.add(Calendar.DAY_OF_MONTH, 1)`.
- Finalmente, a nova data é impressa.

A classe `Calendar` fornece muitos outros métodos para manipular datas, incluindo configuração de campos de data, adição
e subtração de unidades de tempo, rolagem de datas para frente ou para trás, obtenção de valores específicos de data (
ano, mês, dia, etc.), e muito mais. É uma classe bastante versátil para lidar com operações de data e hora em Java.

#

O método `roll(int field, int amount)` da classe `Calendar` em Java é usado para rolar (ou ajustar) um campo de data ou
hora específico para frente ou para trás, sem mudar campos de datas maiores.

Por exemplo, ao chamar `c.roll(Calendar.HOUR, 1)`, você está rolando o campo de hora (`HOUR`) do objeto `Calendar` `c`
para frente em uma unidade, que geralmente significa adicionar uma hora à hora atual.

Vamos entender isso com um exemplo:

```java
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Obtendo uma instância de Calendar
        Calendar c = Calendar.getInstance();

        // Imprimindo a data e hora atual
        System.out.println("Data e hora atual: " + c.getTime());

        // Rolando o campo de hora para frente em uma unidade (adicionando uma hora)
        c.roll(Calendar.HOUR, 1);

        // Imprimindo a data e hora após a rolagem
        System.out.println("Data e hora após rolar 1 hora: " + c.getTime());
    }
}
```

Suponha que a data e hora atual seja "2024-01-31 10:30:00". Após chamar `c.roll(Calendar.HOUR, 1)`, a hora será ajustada
para "2024-01-31 11:30:00", adicionando uma hora ao campo de hora.

É importante observar que `roll()` ajusta apenas o campo especificado, mantendo os outros campos de data ou hora
inalterados. Por exemplo, se o campo de hora estiver em 23 e você rolar para frente uma hora, ele voltará a 0, mantendo
o dia e outros campos de data intactos.

## 114 - Classes Utilitárias - DateFormat[^05]

[^05]: Assita o vídeo no Youtube -> [114 - Classes Utilitárias - DateFormat](https://abre.ai/iOVg)

A classe `DateFormat` em Java é uma classe abstrata que fornece métodos para formatação e análise (parsing) de datas e
horas em strings, seguindo as regras de formatação de uma determinada localidade (locale).

Esta classe é geralmente utilizada em conjunto com classes como `SimpleDateFormat` e `DateFormatSymbols` para formatar
datas e horas de acordo com padrões específicos ou para analisar strings de datas em objetos `Date` ou `Calendar`.

Aqui está um exemplo básico de como usar `DateFormat` e `SimpleDateFormat` para formatar e analisar datas:

```java
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando um objeto Date representando a data e hora atual
        Date date = new Date();

        // Criando um objeto SimpleDateFormat para formatar datas
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Formatando a data para uma string
        String formattedDate = dateFormat.format(date);
        System.out.println("Data formatada: " + formattedDate);

        try {
            // Analisando uma string de data em um objeto Date
            String dateString = "31/01/2024 15:30:00";
            Date parsedDate = dateFormat.parse(dateString);
            System.out.println("Data analisada: " + parsedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

Neste exemplo:

- Criamos um objeto `SimpleDateFormat` com o padrão `"dd/MM/yyyy HH:mm:ss"` para formatar datas no formato "dia/mês/ano
  hora:minuto:segundo".
- Usamos o método `format()` para formatar a data atual em uma string.
- Usamos o método `parse()` para analisar uma string de data em um objeto `Date`.

`DateFormat` fornece métodos abstratos para formatação e análise de datas, mas geralmente é mais comum trabalhar com
suas subclasses, como `SimpleDateFormat`, que implementam a funcionalidade específica de formatação e análise de datas.
Essas subclasses fornecem maior controle sobre o formato e a localidade das datas.
