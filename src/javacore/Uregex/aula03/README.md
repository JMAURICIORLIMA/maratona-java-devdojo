# 📌 **Regex - Classe Utilitária Range (Intervalos em Expressões Regulares)**

As expressões regulares (**Regex**) permitem buscar padrões em um texto. Um dos recursos mais úteis é o **range** (*
*intervalo**), que nos permite especificar **conjuntos de caracteres** dentro de **uma faixa específica**.

---

## 🎯 **1. O que é o Range (`[]`) e para que serve?**

O **range** (`[]`) permite definir **um conjunto de caracteres** que queremos encontrar. Podemos especificar:  
✅ **Intervalos de letras** (`[a-z]`, `[A-Z]`).  
✅ **Intervalos de números** (`[0-9]`).  
✅ **Conjuntos mistos** (`[a-zA-Z0-9]`).  
✅ **Exclusões (negações)** (`[^abc]`, tudo **exceto** `a`, `b` ou `c`).

💡 **Exemplo de uso prático:**  
✔ **Validar placas de carros (ABC-1234)**.  
✔ **Filtrar números entre 1 e 5 (`[1-5]`)**.  
✔ **Encontrar palavras com apenas letras minúsculas (`[a-z]+`)**.  
✔ **Remover caracteres indesejados (`[^a-zA-Z]`)**.

---

## 🛠 **2. Como Utilizar Range no Java?**

### **2.1 Encontrando Apenas Letras Minúsculas (`[a-z]+`)**

Vamos buscar todas as **palavras minúsculas** em um texto.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploRangeLetras {
    public static void main(String[] args) {
        String regex = "[a-z]+"; // Apenas letras minúsculas
        String texto = "Java é uma linguagem Poderosa";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Palavra encontrada: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Palavra encontrada: ava
Palavra encontrada: é
Palavra encontrada: uma
```

📌 **Explicação:**

- `[a-z]+` → Captura palavras com **apenas letras minúsculas**.
- `matcher.find()` → Encontra todas as correspondências no texto.

---

### **2.2 Encontrando Apenas Números Entre 1 e 5 (`[1-5]+`)**

Vamos buscar **números que estejam entre 1 e 5** em um texto.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploRangeNumeros {
    public static void main(String[] args) {
        String regex = "[1-5]+"; // Apenas números entre 1 e 5
        String texto = "Os números sorteados foram: 1, 2, 3, 6, 7, 8.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Número encontrado: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Número encontrado: 1
Número encontrado: 2
Número encontrado: 3
```

📌 **Explicação:**

- `[1-5]+` → Captura **apenas números entre 1 e 5**.

---

### **2.3 Encontrando Letras Maiúsculas (`[A-Z]+`)**

Vamos buscar todas as **palavras que contêm letras maiúsculas**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploRangeMaiusculas {
    public static void main(String[] args) {
        String regex = "[A-Z]+"; // Apenas letras maiúsculas
        String texto = "O Sistema Operacional Windows e o Linux são populares.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Maiúsculas encontradas: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Maiúsculas encontradas: O
Maiúsculas encontradas: S
Maiúsculas encontradas: O
Maiúsculas encontradas: W
Maiúsculas encontradas: L
```

📌 **Explicação:**

- `[A-Z]+` → Captura **apenas letras maiúsculas**.

---

### **2.4 Encontrando Placas de Carro (`[A-Z]{3}-[0-9]{4}`)**

Podemos validar placas de carros no formato **ABC-1234**.

```java
import java.util.regex.Pattern;

public class ValidarPlaca {
    public static void main(String[] args) {
        String regex = "[A-Z]{3}-[0-9]{4}"; // Placas no formato ABC-1234
        String placa = "XYZ-9876";

        if (Pattern.matches(regex, placa)) {
            System.out.println("Placa válida!");
        } else {
            System.out.println("Placa inválida!");
        }
    }
}
```

🔎 **Saída esperada:**

```
Placa válida!
```

📌 **Explicação:**

- `[A-Z]{3}` → Exige **três letras maiúsculas**.
- `-[0-9]{4}` → Exige **quatro números**.

---

### **2.5 Negação: Encontrando Caracteres Que NÃO São Letras (`[^a-zA-Z]+`)**

Podemos encontrar **tudo que não seja letra**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploNegacao {
    public static void main(String[] args) {
        String regex = "[^a-zA-Z]+"; // Tudo que NÃO seja letra
        String texto = "Endereço: Rua 123, Bairro Nova Vida!";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Caracteres não alfabéticos: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Caracteres não alfabéticos:  123, 
Caracteres não alfabéticos:  !
```

📌 **Explicação:**

- `[^a-zA-Z]+` → Captura **tudo que não seja letra**.
- O espaço e os números foram identificados porque **não fazem parte do alfabeto**.

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você está jogando um jogo de pesca.**

Você tem **uma rede mágica** (Regex) que pode capturar **peixes específicos** no oceano de informações.

- Se quiser pegar **apenas peixes azuis**, você ajusta sua rede para **[a-z]**.
- Se precisar capturar **peixes grandes e pequenos**, usa **[A-Z][a-z]**.
- Para capturar **peixes numerados**, ajusta para **[0-9]**.
- Se quiser **evitar tubarões**, exclui **[^T]**.

🔎 **Moral da história:**  
Os **ranges** no Regex são **filtros poderosos** que nos permitem capturar **somente os dados que precisamos** e ignorar
o resto. Como um pescador habilidoso, você pode usar **os intervalos certos** para extrair **apenas as informações
valiosas**! 🎣🌊