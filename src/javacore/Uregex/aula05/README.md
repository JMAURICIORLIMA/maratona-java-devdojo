# 📌 **Regex - Outros Quantificadores**

As **expressões regulares (Regex)** são ferramentas poderosas para encontrar e manipular padrões de texto. Além dos
quantificadores básicos (`*`, `+`, `?`, `{n}`, `{n,}`, `{n,m}`), existem **outros quantificadores** que nos permitem um
controle ainda mais preciso sobre as buscas.

---

## 🎯 **1. O que são os "Outros" Quantificadores e Para que Servem?**

Os **quantificadores avançados** controlam **como os padrões são aplicados** em um texto. Eles podem ser:

✅ **Gananciosos (Greedy)**: Pegam o máximo possível de correspondências.  
✅ **Relutantes (Lazy)**: Pegam o mínimo necessário de correspondências.  
✅ **Possessivos (Possessive)**: Pegam o máximo possível e não permitem retrocesso (backtracking).

Esses quantificadores são úteis para:  
✔ **Evitar capturas excessivas** (exemplo: pegar apenas o primeiro HTML `<p>` e não todo o código).  
✔ **Otimizar desempenho** ao evitar retrocessos desnecessários.  
✔ **Ter mais controle sobre padrões complexos**.

---

## 🔢 **2. Tipos de Quantificadores Avançados no Regex**

| Quantificador | Tipo       | Significado                                              |
|---------------|------------|----------------------------------------------------------|
| `*`           | Ganancioso | **Zero ou mais vezes**, pegando **o máximo** possível.   |
| `*?`          | Relutante  | **Zero ou mais vezes**, pegando **o mínimo** possível.   |
| `*+`          | Possessivo | **Zero ou mais vezes**, pegando o máximo sem retroceder. |
| `+`           | Ganancioso | **Uma ou mais vezes**, pegando **o máximo** possível.    |
| `+?`          | Relutante  | **Uma ou mais vezes**, pegando **o mínimo** possível.    |
| `++`          | Possessivo | **Uma ou mais vezes**, pegando o máximo sem retroceder.  |
| `?`           | Ganancioso | **Zero ou uma vez**, pegando **o máximo** possível.      |
| `??`          | Relutante  | **Zero ou uma vez**, pegando **o mínimo** possível.      |
| `?+`          | Possessivo | **Zero ou uma vez**, pegando o máximo sem retroceder.    |

---

## 🛠 **3. Como Utilizar no Java?**

### **3.1 Quantificadores Gananciosos (`*`, `+`, `{n}`)**

Os quantificadores **gananciosos** tentam capturar **o máximo possível**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploGanancioso {
    public static void main(String[] args) {
        String regex = "<.*>"; // Captura o máximo possível
        String texto = "<p>Parágrafo 1</p> <p>Parágrafo 2</p>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Capturado: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Capturado: <p>Parágrafo 1</p> <p>Parágrafo 2</p>
```

📌 **Explicação:**

- `<.*>` → **Captura tudo entre o primeiro `<` e o último `>`** porque `*` é **ganancioso**.

---

### **3.2 Quantificadores Relutantes (`*?`, `+?`, `{n,m}?`)**

Os quantificadores **relutantes** tentam capturar **o mínimo possível**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploRelutante {
    public static void main(String[] args) {
        String regex = "<.*?>"; // Captura o mínimo possível
        String texto = "<p>Parágrafo 1</p> <p>Parágrafo 2</p>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Capturado: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Capturado: <p>
Capturado: </p>
Capturado: <p>
Capturado: </p>
```

📌 **Explicação:**

- `<.*?>` → **Captura o mínimo entre `<` e `>`**, encontrando **apenas as tags HTML individuais**.

---

### **3.3 Quantificadores Possessivos (`*+`, `++`, `{n,m}+`)**

Os quantificadores **possessivos** pegam **o máximo possível sem permitir retrocesso**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploPossessivo {
    public static void main(String[] args) {
        String regex = "<.*+>"; // Sem backtracking
        String texto = "<p>Parágrafo 1</p> <p>Parágrafo 2</p>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Capturado: " + matcher.group());
        }
    }
}
```

🔎 **Saída esperada:**

```
Capturado: <p>Parágrafo 1</p> <p>Parágrafo 2</p>
```

📌 **Explicação:**

- `<.*+>` → **Tenta capturar tudo de uma vez e não permite "voltar atrás" para refazer a busca**.

---

## 📖 **4. Resumo com Parábola**

💡 **Imagine que você está pescando peixes em um rio.**

- 🎣 O pescador **ganancioso** usa uma **rede enorme** (`*` ou `+`) e pega **todos os peixes possíveis**, inclusive
  alguns que não queria.
- 🎣 O pescador **relutante** usa uma **rede pequena** (`*?` ou `+?`), pegando **apenas o primeiro peixe que encontrar**.
- 🎣 O pescador **possessivo** (`*+` ou `++`) usa uma **rede que prende os peixes**, mas **não permite soltar nenhum**
  depois que pega algo.

🔎 **Moral da história:**  
Os **quantificadores avançados no Regex** são como diferentes tipos de pescadores:

- 🏆 **Gananciosos** pegam **o máximo possível**.
- 🎯 **Relutantes** pegam **o mínimo necessário**.
- 🔒 **Possessivos** pegam **tudo de uma vez sem devolver nada**.

Se você **souber usar o tipo certo de rede**, vai **capturar exatamente o que deseja** no mar de informações! 🌊🐟

---

# 📌 **Regex - Quantificador `.` (Ponto)**

O **ponto (`.`)** em expressões regulares é um **quantificador universal** que representa **qualquer caractere**, *
*exceto quebras de linha**. Ele é muito útil quando queremos buscar padrões sem se preocupar com quais caracteres estão
no meio.

---

## 🎯 **1. O que é o Quantificador `.` e Para que Serve?**

O **ponto (`.`)** é um **metacaractere** no **Regex** que corresponde a **qualquer caractere individual**, **exceto uma
quebra de linha (`\n` ou `\r`)**.

✅ **Encontrar qualquer sequência de caracteres desconhecidos.**  
✅ **Substituir qualquer caractere em padrões específicos.**  
✅ **Trabalhar com textos dinâmicos que possuem variações.**

---

## 🛠 **2. Como Utilizar o `.` no Java?**

### **2.1 Encontrando Padrões com Qualquer Caractere**

Podemos utilizar o `.` para encontrar padrões onde **qualquer caractere pode aparecer**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploPonto {
    public static void main(String[] args) {
        String regex = "c.m"; // Qualquer caractere entre 'c' e 'm'
        String texto = "cam cem cim com cum";

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
Encontrado: cam
Encontrado: cem
Encontrado: cim
Encontrado: com
Encontrado: cum
```

📌 **Explicação:**

- O padrão `"c.m"` **captura qualquer palavra de três letras que comece com "c", termine com "m" e tenha um caractere
  qualquer no meio**.
- Ele encontra **"cam", "cem", "cim", "com" e "cum"**.

---

### **2.2 Encontrando Qualquer Sequência de Caracteres (`.*`)**

Se combinarmos `.` com `*`, podemos capturar **qualquer sequência de caracteres**.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExemploPontoComAsterisco {
    public static void main(String[] args) {
        String regex = "a.*o"; // Captura qualquer coisa entre "a" e "o"
        String texto = "amor adoção avião astro alho";

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
Encontrado: amor
Encontrado: adoção
Encontrado: avião
Encontrado: astro
Encontrado: alho
```

📌 **Explicação:**

- O padrão `"a.*o"` captura qualquer coisa **que comece com "a" e termine com "o"**, **independentemente do que estiver
  no meio**.

---

### **2.3 Substituindo Qualquer Caractere por Outro**

Podemos substituir **qualquer caractere específico** dentro de um padrão.

```java
public class SubstituirPonto {
    public static void main(String[] args) {
        String regex = "c.m";
        String texto = "cam cem cim com cum";
        String novoTexto = texto.replaceAll(regex, "c#M");

        System.out.println(novoTexto);
    }
}
```

🔎 **Saída esperada:**

```
c#M c#M c#M c#M c#M
```

📌 **Explicação:**

- `"c.m"` → Substitui **todas as palavras que começam com "c" e terminam com "m"**, colocando `"c#M"` no lugar.

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você é um detetive investigando um caso misterioso.**

- Você tem **um arquivo com um nome parcialmente ilegível**, onde só consegue ler que ele **começa com "c" e termina
  com "m"**.
- Mas há **um borrão** no meio, então você **não sabe se é "cam", "com" ou "cum"**.
- Usando **o ponto (`.`) como ferramenta**, você pode dizer ao sistema: **"Ache qualquer coisa que tenha um caractere
  desconhecido entre 'c' e 'm'!"** 🔎

🔎 **Moral da história:**  
O **ponto (`.`) no Regex** é como um espaço em branco em um quebra-cabeça 🔍. Ele representa **qualquer peça que possa se
encaixar** e nos permite buscar informações **mesmo quando não conhecemos todos os detalhes**! 🕵️‍♂️✨