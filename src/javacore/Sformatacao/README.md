# 📌 **Classe Utilitária - `DateTimeFormatter`**

A classe `DateTimeFormatter` faz parte da API `java.time.format` e é usada para **formatar e analisar** (`parse`) datas
e horas em Java. Ela permite converter objetos de data (`LocalDate`, `LocalDateTime`, `ZonedDateTime`, etc.) para *
*strings formatadas** e vice-versa.

---

# 🎯 **1. O que é e para que serve?**

Imagine que você tem uma data e quer exibi-la de uma forma específica para um usuário, como **"09/03/2025"** ou **"
Sunday, March 9, 2025"**. O `DateTimeFormatter` permite definir um padrão para essa formatação.

Ele também permite transformar **uma string** com uma data formatada em um objeto de data válido.

✅ **Principais usos do `DateTimeFormatter`:**

- **Formatar datas** (`LocalDate → String`).
- **Converter strings para datas** (`String → LocalDate`).
- **Usar padrões personalizados** (`"dd/MM/yyyy"`, `"yyyy-MM-dd HH:mm"`, etc.).
- **Internacionalizar datas** com `Locale` (exibir datas em diferentes idiomas).

---

# 🛠 **2. Como Utilizar o `DateTimeFormatter`?**

## **2.1 Formatando Datas (`format`)**

Vamos começar formatando uma data para diferentes padrões:

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExemploFormatacao {
    public static void main(String[] args) {
        // Criando um LocalDate (data de hoje)
        LocalDate hoje = LocalDate.now();

        // Criando um DateTimeFormatter com um formato personalizado
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoAmericano = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter formatoCompleto = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy");

        // Formatando a data em diferentes formatos
        System.out.println("Formato Brasileiro: " + hoje.format(formatoBrasileiro));
        System.out.println("Formato Americano: " + hoje.format(formatoAmericano));
        System.out.println("Formato Completo: " + hoje.format(formatoCompleto));
    }
}
```

📌 **Explicação:**

- `ofPattern("dd/MM/yyyy")` → Define um formato personalizado para o Brasil.
- `format()` → Converte a data (`LocalDate`) para uma `String` formatada.
- `"EEEE, dd 'de' MMMM 'de' yyyy"` → Exibe o nome do dia da semana e do mês.

🔎 **Saída esperada (para 9 de março de 2025):**

```
Formato Brasileiro: 09/03/2025
Formato Americano: 03-09-2025
Formato Completo: Sunday, 09 de March de 2025
```

---

## **2.2 Convertendo Strings para Datas (`parse`)**

Agora, vamos converter **uma string formatada para um objeto `LocalDate`**.

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExemploParse {
    public static void main(String[] args) {
        // Criando um DateTimeFormatter com o mesmo padrão da string
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convertendo uma String para LocalDate
        String dataTexto = "09/03/2025";
        LocalDate dataConvertida = LocalDate.parse(dataTexto, formatoBrasileiro);

        System.out.println("Data convertida: " + dataConvertida);
    }
}
```

📌 **Explicação:**

- `parse(dataTexto, formatoBrasileiro)` → Converte a string `"09/03/2025"` para um objeto `LocalDate`.
- A saída será no formato `yyyy-MM-dd`, pois é o formato padrão do `LocalDate`:
  ```
  Data convertida: 2025-03-09
  ```

---

## **2.3 Formatando Datas com Idiomas Diferentes (`Locale`)**

O `DateTimeFormatter` pode usar `Locale` para exibir datas em diferentes idiomas:

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExemploInternacionalizacao {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();

        // Criando formatadores para diferentes idiomas
        DateTimeFormatter formatoIngles = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.ENGLISH);
        DateTimeFormatter formatoFrances = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.FRENCH);
        DateTimeFormatter formatoAlemao = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.GERMAN);

        System.out.println("Inglês: " + hoje.format(formatoIngles));
        System.out.println("Francês: " + hoje.format(formatoFrances));
        System.out.println("Alemão: " + hoje.format(formatoAlemao));
    }
}
```

🔎 **Saída esperada para 9 de março de 2025:**

```
Inglês: Sunday, 09 March 2025
Francês: dimanche, 09 mars 2025
Alemão: Sonntag, 09 März 2025
```

📌 **Explicação:**

- `Locale.ENGLISH`, `Locale.FRENCH`, `Locale.GERMAN` → Define o idioma da data.
- `EEEE, dd MMMM yyyy` → Exibe o nome completo do dia e do mês no idioma escolhido.

---

## **2.4 Usando Formatos Padrão do `DateTimeFormatter`**

O Java já fornece alguns **formatos pré-definidos** prontos para uso:

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExemploFormatosPadrao {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();

        System.out.println("ISO DateTime: " + agora.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("ISO Local Date: " + agora.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("ISO Local Time: " + agora.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
}
```

🔎 **Saída esperada:**

```
ISO DateTime: 2025-03-09T14:30:45
ISO Local Date: 2025-03-09
ISO Local Time: 14:30:45
```

📌 **Explicação:**

- `ISO_DATE_TIME`, `ISO_LOCAL_DATE`, `ISO_LOCAL_TIME` → São padrões pré-definidos.
- Eles seguem o formato ISO 8601, usado internacionalmente.

---

# 📖 **3. Resumo com Parábola**

💡 **Imagine que você é um chefe de cozinha preparando um prato especial.**

- Você tem **os ingredientes (datas)** e precisa organizá-los de forma bonita no prato.
- Dependendo do cliente, o prato pode ser apresentado de maneiras diferentes:
    - Um brasileiro pode preferir a data no formato **"09/03/2025"**.
    - Um americano pode querer **"03-09-2025"**.
    - Um francês pode pedir **"dimanche, 09 mars 2025"**.
- Seu assistente, `DateTimeFormatter`, é o responsável por **organizar e exibir os ingredientes da forma correta para
  cada cliente**.

🔎 **Moral da história:**  
O `DateTimeFormatter` é seu ajudante na cozinha da programação! Ele permite que você sirva as datas corretamente,
adaptando-se ao gosto de cada usuário, seja no Brasil, nos EUA ou na França. 🍽️😃