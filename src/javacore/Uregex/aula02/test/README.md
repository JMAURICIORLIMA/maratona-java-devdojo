# 📌 **Classes Utilitárias - Regex - Meta Caracteres**

As **expressões regulares** (**Regex**) são um conjunto de regras que permitem identificar padrões de texto.

Os **meta caracteres** são **símbolos especiais** usados no Regex para definir padrões **mais flexíveis e poderosos**.
Eles nos ajudam a encontrar palavras, validar formatos e fazer substituições em strings.

---

## 🎯 **1. O que são e para que servem os Meta Caracteres?**

Os **meta caracteres** permitem criar regras avançadas para buscar e manipular texto.  
Por exemplo:  
✅ Encontrar **números**, **letras**, **espaços** e **caracteres especiais** em um texto.  
✅ Validar **formatos como CPF, telefone e e-mail**.  
✅ Substituir **palavras ou caracteres automaticamente**.

### 🔥 **Lista dos principais Meta Caracteres do Regex em Java**

| Meta Caractere | Significado                                                                |
|----------------|----------------------------------------------------------------------------|
| `.`            | Qualquer caractere, exceto nova linha (`\n`).                              |
| `\d`           | Qualquer dígito (`0-9`).                                                   |
| `\D`           | Qualquer caractere que **não** seja um dígito.                             |
| `\w`           | Qualquer letra, número ou **_** (underline).                               |
| `\W`           | Qualquer caractere que **não** seja letra, número ou underline.            |
| `\s`           | Qualquer espaço em branco (espaço, tabulação `\t`, quebra de linha `\n`).  |
| `\S`           | Qualquer caractere que **não** seja um espaço em branco.                   |
| `^`            | Indica o **início** de uma string.                                         |
| `$`            | Indica o **fim** de uma string.                                            |
| `[]`           | Define um conjunto de caracteres permitidos.                               |
| `[^]`          | Define um conjunto de caracteres **negados** (não permitidos).             |
| `*`            | Repete **zero ou mais vezes** o caractere anterior.                        |
| `+`            | Repete **uma ou mais vezes** o caractere anterior.                         |
| `?`            | Torna o caractere anterior **opcional** (pode aparecer **0 ou 1 vez**).    |
| `{n,m}`        | Especifica **quantas vezes** um caractere deve aparecer (**n a m** vezes). |
| `              | `                                                                          | Representa **"OU"** (aceita uma opção **ou** outra). |
| `()`           | Agrupa uma parte da expressão para aplicarmos regras específicas.          |

---

## 🛠 **2. Como Utilizar os Meta Caracteres no Java?**

### **2.1 Encontrando Qualquer Dígito (`\d`)**

Vamos verificar se um **texto contém números**:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploMetaCaracteres {
    public static void main(String[] args) {
        String regex = "\\d+"; // Busca um ou mais dígitos
        String texto = "Meu telefone é 98765-4321 e custa 2500 reais.";

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
Número encontrado: 98765
Número encontrado: 4321
Número encontrado: 2500
```

📌 **Explicação:**

- `\d+` → Encontra **um ou mais dígitos consecutivos**.
- `find()` → Busca todas as ocorrências do padrão dentro do texto.

---

### **2.2 Encontrando Palavras (`\w+`)**

Agora, vamos encontrar **todas as palavras** em um texto.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploPalavras {
    public static void main(String[] args) {
        String regex = "\\w+"; // Busca palavras (letras e números)
        String texto = "O carro é azul e custa $10.000!";

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
Palavra encontrada: carro
Palavra encontrada: é
Palavra encontrada: azul
Palavra encontrada: e
Palavra encontrada: custa
Palavra encontrada: 10
Palavra encontrada: 000
```

📌 **Explicação:**

- `\w+` → Captura **qualquer sequência de letras ou números**.
- O **`$` e `!`** não são capturados porque não são letras ou números.

---

### **2.3 Validando Formato de Telefone (`\d{2}-\d{5}-\d{4}`)**

Podemos verificar se um telefone segue um formato **(XX-XXXXX-XXXX)**.

```java
import java.util.regex.Pattern;

public class ValidarTelefone {
    public static void main(String[] args) {
        String regex = "\\d{2}-\\d{5}-\\d{4}"; // Formato: XX-XXXXX-XXXX
        String telefone = "11-98765-4321";

        if (Pattern.matches(regex, telefone)) {
            System.out.println("Telefone válido!");
        } else {
            System.out.println("Telefone inválido!");
        }
    }
}
```

🔎 **Saída esperada:**

```
Telefone válido!
```

📌 **Explicação:**

- `\d{2}` → Exige **dois dígitos** para o DDD.
- `\d{5}` → Exige **cinco dígitos** para a primeira parte do número.
- `\d{4}` → Exige **quatro dígitos** para a segunda parte do número.

---

### **2.4 Removendo Espaços Extras (`\s+`)**

Vamos substituir **múltiplos espaços** por um único:

```java
import java.util.regex.Pattern;

public class RemoverEspacos {
    public static void main(String[] args) {
        String texto = "Este    texto   contém     muitos   espaços!";
        String resultado = texto.replaceAll("\\s+", " "); // Substitui espaços extras por um único espaço.

        System.out.println(resultado);
    }
}
```

🔎 **Saída esperada:**

```
Este texto contém muitos espaços!
```

📌 **Explicação:**

- `\s+` → Captura **um ou mais espaços em branco**.
- `replaceAll()` → Substitui **múltiplos espaços** por **apenas um espaço**.

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você é um caçador de tesouros em uma floresta misteriosa.**

- No meio da floresta (o texto), existem **joias escondidas** (informações importantes).
- Você tem um **mapa mágico** (Regex) que ajuda a **encontrar padrões específicos**.
- Dependendo do tipo de joia que você quer:
    - `\d` → Mostra **tesouros numéricos**.
    - `\w+` → Encontra **palavras valiosas**.
    - `\s+` → Remove **obstáculos (espaços em branco)** para limpar o caminho.

🔎 **Moral da história:**  
Os **meta caracteres do Regex** são seu **kit de ferramentas mágicas** para explorar e manipular qualquer texto de forma
rápida e eficiente! 🏆🔍