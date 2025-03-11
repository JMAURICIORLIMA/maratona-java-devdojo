# 📌 **Regex - Âncoras (Anchors)**

As **âncoras** (`^` e `$`) em expressões regulares são **posicionadores** que definem **onde** um padrão deve aparecer
dentro de um texto. Diferente de caracteres ou quantificadores, **elas não capturam caracteres, apenas indicam posições
específicas**.

---

## 🎯 **1. O que são as Âncoras e Para que Servem?**

✅ **Controlar a posição do padrão** dentro do texto.  
✅ **Garantir que a correspondência ocorra no início ou no final da string**.  
✅ **Evitar capturas parciais**, garantindo que um padrão esteja isolado.

As principais âncoras são:

| Âncora | Significado                  | Exemplo                                                   |
|--------|------------------------------|-----------------------------------------------------------|
| `^`    | **Início da linha**          | `^Java` → Casa com "Java" **somente no início**.          |
| `$`    | **Fim da linha**             | `Java$` → Casa com "Java" **somente no final**.           |
| `\b`   | **Fronteira de palavra**     | `\bJava\b` → Casa com "Java" **como palavra isolada**.    |
| `\B`   | **Não-fronteira de palavra** | `\BJava\B` → Casa com "Java" **dentro de outra palavra**. |

---

## 🛠 **2. Como Utilizar no Java?**

### **2.1 Usando `^` para Casar Somente no Início da Linha**

Se quisermos encontrar **"Java" apenas se estiver no começo**, usamos `^Java`:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploAnchorInicio {
    public static void main(String[] args) {
        String regex = "^Java";
        String texto1 = "Java é uma linguagem poderosa";
        String texto2 = "Aprender Java é ótimo";

        System.out.println("Texto 1 casa? " + texto1.matches(regex));
        System.out.println("Texto 2 casa? " + texto2.matches(regex));
    }
}
```

🔎 **Saída esperada:**

```
Texto 1 casa? true
Texto 2 casa? false
```

📌 **Explicação:**

- `^Java` → Só encontra "Java" se for **a primeira palavra da linha**.

---

### **2.2 Usando `$` para Casar Somente no Final da Linha**

Se quisermos encontrar **"Java" apenas se estiver no final**, usamos `Java$`:

```java
public class ExemploAnchorFim {
    public static void main(String[] args) {
        String regex = "Java$";
        String texto1 = "A linguagem usada foi Java";
        String texto2 = "Java é muito usada";

        System.out.println("Texto 1 casa? " + texto1.matches(regex));
        System.out.println("Texto 2 casa? " + texto2.matches(regex));
    }
}
```

🔎 **Saída esperada:**

```
Texto 1 casa? true
Texto 2 casa? false
```

📌 **Explicação:**

- `Java$` → Só encontra "Java" **se estiver no final da linha**.

---

### **2.3 Usando `\b` para Garantir que é uma Palavra Isolada**

O `\b` **garante que estamos capturando apenas a palavra exata**:

```java
public class ExemploAnchorPalavra {
    public static void main(String[] args) {
        String regex = "\\bJava\\b";
        String texto1 = "Eu estudo Java";
        String texto2 = "Javascript é diferente de Java";

        System.out.println("Texto 1 casa? " + texto1.matches(".*" + regex + ".*"));
        System.out.println("Texto 2 casa? " + texto2.matches(".*" + regex + ".*"));
    }
}
```

🔎 **Saída esperada:**

```
Texto 1 casa? true
Texto 2 casa? false
```

📌 **Explicação:**

- `\bJava\b` → Só encontra "Java" **se não estiver grudado em outras letras** (ex.: **"Javascript" não casa**).

---

### **2.4 Usando `\B` para Encontrar dentro de Outras Palavras**

Se quisermos encontrar "Java" **apenas quando fizer parte de outra palavra**, usamos `\B`:

```java
public class ExemploAnchorNaoPalavra {
    public static void main(String[] args) {
        String regex = "\\BJava\\B";
        String texto1 = "Eu estudo Java";   // NÃO casa
        String texto2 = "Javascript usa Java"; // Casa

        System.out.println("Texto 1 casa? " + texto1.matches(".*" + regex + ".*"));
        System.out.println("Texto 2 casa? " + texto2.matches(".*" + regex + ".*"));
    }
}
```

🔎 **Saída esperada:**

```
Texto 1 casa? false
Texto 2 casa? true
```

📌 **Explicação:**

- `\BJava\B` → Só casa se **"Java" estiver dentro de outra palavra** (como "Javascript").

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você é um segurança de um evento e precisa conferir os ingressos.**

1️⃣ O ingresso precisa começar com um **código específico** → Você verifica **o início** (`^`).  
2️⃣ O ingresso precisa terminar com uma **assinatura válida** → Você verifica **o final** (`$`).  
3️⃣ O ingresso só vale se tiver **a palavra exata "VIP" isolada** → Você verifica **fronteiras de palavra** (`\b`).  
4️⃣ Se o ingresso tiver "VIP" dentro de outra palavra, ele não é válido → Você usa **não-fronteiras de palavra** (`\B`).

🔎 **Moral da história:**  
As **âncoras no Regex** são como **regras de validação**, garantindo que um padrão **esteja exatamente no lugar certo**!
🎟️🔎

---

**Acessar o site: [https://regexr.com/](https://regexr.com/)**