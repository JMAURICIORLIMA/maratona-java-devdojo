# 📌 **Regex - Classe Utilitária Quantificadores**

As expressões regulares (**Regex**) permitem encontrar padrões de texto de maneira flexível. **Os quantificadores** são
elementos poderosos que **definem a quantidade de vezes** que um caractere ou grupo pode aparecer.

---

## 🎯 **1. O que são Quantificadores e Para que Servem?**

Os **quantificadores** indicam **quantas vezes** um caractere ou grupo pode aparecer dentro de um padrão de texto. Eles
permitem buscar, validar e manipular dados com maior precisão.

✅ **Validar CPF, CEP, telefones e emails**.  
✅ **Encontrar palavras de tamanhos específicos**.  
✅ **Buscar repetições dentro de um texto**.

---

## 🔢 **2. Tipos de Quantificadores no Regex**

| Quantificador | Significado                                                         |
|---------------|---------------------------------------------------------------------|
| `*`           | **Zero ou mais vezes** (pode aparecer nenhuma vez ou várias vezes). |
| `+`           | **Uma ou mais vezes** (precisa aparecer pelo menos uma vez).        |
| `?`           | **Zero ou uma vez** (torna o caractere opcional).                   |
| `{n}`         | Exatamente **n** vezes.                                             |
| `{n,}`        | Pelo menos **n** vezes.                                             |
| `{n,m}`       | Entre **n** e **m** vezes.                                          |

---

## 🛠 **3. Como Utilizar Quantificadores no Java?**

### **3.1 Encontrando Palavras com Uma ou Mais Letras (`\w+`)**

Vamos buscar **palavras** em um texto.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploQuantificadorMais {
    public static void main(String[] args) {
        String regex = "\\w+"; // Uma ou mais letras/números
        String texto = "O Java é incrível!";

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
Palavra encontrada: O
Palavra encontrada: Java
Palavra encontrada: é
Palavra encontrada: incrível
```

📌 **Explicação:**

- `\w+` → Captura **uma ou mais** letras ou números.
- Como `+` exige pelo menos **uma ocorrência**, ele encontra todas as palavras.

---

### **3.2 Encontrando Dígitos com Zero ou Mais Ocorrências (`\d*`)**

Vamos buscar **números que podem ou não estar presentes**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploQuantificadorAsterisco {
    public static void main(String[] args) {
        String regex = "\\d*"; // Zero ou mais dígitos
        String texto = "O código é 123 e o preço é R$45.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Encontrado: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Encontrado: 
Encontrado: 
Encontrado: 123
Encontrado: 
Encontrado: 
Encontrado: 
Encontrado: 
Encontrado: 45
Encontrado: 
Encontrado: 
```

📌 **Explicação:**

- `\d*` → Captura **zero ou mais dígitos**.
- Como pode aparecer **nenhuma vez**, ele encontra até espaços vazios entre palavras.

---

### **3.3 Validando Código Postal com Exatamente 5 Dígitos (`\d{5}`)**

Podemos verificar se um código postal tem **exatamente 5 números**.

```java
import java.util.regex.Pattern;

public class ValidarCodigoPostal {
    public static void main(String[] args) {
        String regex = "\\d{5}"; // Exatamente 5 números
        String codigo = "12345";

        if (Pattern.matches(regex, codigo)) {
            System.out.println("Código postal válido!");
        } else {
            System.out.println("Código postal inválido!");
        }
    }
}
```

🔎 **Saída esperada:**

```
Código postal válido!
```

📌 **Explicação:**

- `\d{5}` → Captura **exatamente 5 dígitos numéricos**.

---

### **3.4 Validando Telefone com Mínimo de 10 Dígitos (`\d{10,}`)**

Podemos verificar se um número de telefone tem **pelo menos 10 dígitos**.

```java
import java.util.regex.Pattern;

public class ValidarTelefone {
    public static void main(String[] args) {
        String regex = "\\d{10,}"; // Pelo menos 10 números
        String telefone = "11987654321";

        if (Pattern.matches(regex, telefone)) {
            System.out.println("Número de telefone válido!");
        } else {
            System.out.println("Número de telefone inválido!");
        }
    }
}
```

🔎 **Saída esperada:**

```
Número de telefone válido!
```

📌 **Explicação:**

- `\d{10,}` → Captura **pelo menos 10 dígitos**.

---

### **3.5 Validando Placa de Carro Padrão (`[A-Z]{3}-\d{4}`)**

Vamos verificar se uma placa segue o formato **ABC-1234**.

```java
import java.util.regex.Pattern;

public class ValidarPlaca {
    public static void main(String[] args) {
        String regex = "[A-Z]{3}-\\d{4}"; // Três letras e quatro números
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

- `[A-Z]{3}` → Três letras maiúsculas.
- `-\d{4}` → Hífen seguido de **quatro números**.

---

## 📖 **4. Resumo com Parábola**

💡 **Imagine que você é um chefe de cozinha preparando um prato especial.**

- Você tem um **ingrediente mágico** (Regex) que pode ser usado **em diferentes quantidades**.
- Se quiser **uma pitada ou mais** de sal, usa `+`.
- Se precisar de **zero ou mais colheres de açúcar**, usa `*`.
- Para um **exato número de ovos**, usa `{n}`.
- Se for entre **duas e quatro colheres de azeite**, usa `{2,4}`.

🔎 **Moral da história:**  
Os **quantificadores no Regex** permitem definir **exatamente quanto de um padrão queremos encontrar**. Assim como um
cozinheiro ajusta ingredientes para criar o prato perfeito, você pode ajustar os quantificadores para capturar **apenas
os dados desejados**! 🍽️👨‍🍳