# 📌 **Classes Utilitárias - `Pattern` e `Matcher` (Expressões Regulares - Regex)**

As expressões regulares (**Regex**) são usadas para buscar, validar e manipular **padrões de texto** em Java. Para
trabalhar com elas, o Java oferece as classes **`Pattern`** e **`Matcher`**, que permitem criar e testar padrões de
busca em strings.

---

## 🎯 **1. O que são e para que servem?**

- **`Pattern`** → Representa um padrão de expressão regular compilado.
- **`Matcher`** → Verifica se um texto corresponde ao padrão e permite realizar buscas e substituições.

✅ **Principais usos do Regex (`Pattern` e `Matcher`):**  
✔ **Validação de dados** → E-mails, CPFs, telefones, senhas, etc.  
✔ **Busca de padrões** → Encontrar palavras específicas em um texto.  
✔ **Substituições** → Modificar partes de um texto automaticamente.

---

## 🛠 **2. Como Utilizar `Pattern` e `Matcher`?**

### **2.1 Verificando um Padrão Simples (`matches`)**

Vamos verificar se uma string contém **apenas números** (`\d+`).

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploPatternMatcher {
    public static void main(String[] args) {
        // Definição do padrão (somente números)
        String regex = "\\d+";
        String texto = "12345";

        // Compila o padrão
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        // Verifica se a string corresponde ao padrão
        if (matcher.matches()) {
            System.out.println("A string contém apenas números!");
        } else {
            System.out.println("A string contém caracteres não numéricos.");
        }
    }
}
```

📌 **Explicação:**

- `\d+` → Indica **um ou mais dígitos numéricos**.
- `Pattern.compile(regex)` → Cria um padrão de regex.
- `pattern.matcher(texto)` → Associa o padrão à string a ser testada.
- `matches()` → Retorna `true` se a string inteira corresponde ao padrão.

🔎 **Saída esperada:**

```
A string contém apenas números!
```

---

### **2.2 Encontrando um Padrão Dentro de um Texto (`find`)**

Agora, vamos buscar **números dentro de um texto**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploFind {
    public static void main(String[] args) {
        String regex = "\\d+";
        String texto = "O preço é 199 reais e 50 centavos.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Número encontrado: " + matcher.group());
        }
    }
}
```

📌 **Explicação:**

- `find()` → Busca **ocorrências dentro do texto**, não apenas a string completa.
- `group()` → Retorna o valor encontrado.

🔎 **Saída esperada:**

```
Número encontrado: 199
Número encontrado: 50
```

---

### **2.3 Substituindo Palavras em um Texto (`replaceAll`)**

Vamos substituir **todos os números por `X`**.

```java
import java.util.regex.Pattern;

public class ExemploReplace {
    public static void main(String[] args) {
        String regex = "\\d+";
        String texto = "O produto custa 199 reais e 50 centavos.";

        // Substituindo todos os números por 'X'
        String novoTexto = texto.replaceAll(regex, "X");

        System.out.println("Texto modificado: " + novoTexto);
    }
}
```

📌 **Explicação:**

- `replaceAll(regex, "X")` → Substitui todas as ocorrências do padrão por "X".

🔎 **Saída esperada:**

```
Texto modificado: O produto custa X reais e X centavos.
```

---

### **2.4 Validação de E-mails (`matches`)**

Podemos usar Regex para validar e-mails:

```java
import java.util.regex.Pattern;

public class ValidarEmail {
    public static void main(String[] args) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.\\w+$"; // Padrão para e-mails simples
        String email = "usuario@gmail.com";

        boolean valido = Pattern.matches(regex, email);

        if (valido) {
            System.out.println("E-mail válido!");
        } else {
            System.out.println("E-mail inválido!");
        }
    }
}
```

📌 **Explicação:**

- `^` → Início da string.
- `[\\w.-]+` → Letras, números, pontos e traços antes do `@`.
- `@` → Obrigatório.
- `[\\w.-]+\\.\\w+` → Domínio e extensão (`.com`, `.org`, etc.).
- `$` → Fim da string.

🔎 **Saída esperada:**

```
E-mail válido!
```

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você é um detetive investigando um caso.**

Você entra em uma **biblioteca** repleta de livros (textos) e precisa encontrar pistas escondidas, como **números de
telefone, datas, nomes ou palavras-chave**.

Para isso, você tem um **scanner inteligente** (`Pattern` e `Matcher`) que permite **identificar padrões específicos**
rapidamente:

- Se quiser encontrar **todos os números**, basta configurar seu scanner para **buscar por dígitos (`\d+`)**.
- Se precisar localizar **e-mails**, ele pode verificar se um texto segue um formato de e-mail (`usuario@dominio.com`).
- Se quiser **substituir palavras suspeitas**, pode configurar o scanner para **trocá-las automaticamente**.

🔎 **Moral da história:**  
O Regex é seu **detetive digital**! 🕵️‍♂️ Com ele, você pode encontrar **pistas (dados) ocultas**, validar informações e
até modificar textos de forma rápida e eficiente. 🚀