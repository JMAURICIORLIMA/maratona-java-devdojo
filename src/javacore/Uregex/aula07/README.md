Acho que houve um erro de digitação no final. Você quis dizer **"Scanner - Tokens e Delimitadores"**? Se for isso, vou
te explicar tudo sobre o uso do **Scanner**, como ele trabalha com **tokens** e **delimitadores**, e no final trago uma
parábola para fixar melhor o conceito.

---

# 📌 **Scanner - Tokens e Delimitadores**

A classe **`Scanner`** do Java é usada para **ler entrada de dados** de diferentes fontes, como **teclado**, **arquivos
** ou **strings**. O Scanner divide os dados em **tokens**, que são partes separadas de um texto, usando **delimitadores
**.

---

## 🎯 **1. O que são Tokens e Delimitadores?**

- **Token**: É uma **unidade de texto separada** pelo Scanner. Pode ser uma palavra, número ou qualquer outro conjunto
  de caracteres.
- **Delimitador**: É o **símbolo que separa os tokens**. O Scanner, por padrão, usa **espaço em branco** (` `), *
  *tabulação** (`\t`), **nova linha** (`\n`) como delimitadores, mas podemos alterá-los.

---

## 🛠 **2. Como Utilizar Tokens e Delimitadores no Java?**

### **2.1 Lendo Tokens Padrão (Separados por Espaços)**

O Scanner separa tokens por **espaços em branco** automaticamente.

```java
import java.util.Scanner;

public class ScannerTokens {
    public static void main(String[] args) {
        String texto = "Java é incrível!";
        Scanner scanner = new Scanner(texto);

        while (scanner.hasNext()) {
            System.out.println("Token: " + scanner.next());
        }

        scanner.close();
    }
}
```

🔎 **Saída esperada:**

```
Token: Java
Token: é
Token: incrível!
```

📌 **Explicação:**

- O Scanner lê o texto **palavra por palavra**, separando pelo **espaço**.
- `next()` pega **o próximo token disponível**.

---

### **2.2 Definindo um Delimitador Personalizado**

Podemos usar `useDelimiter()` para definir **outros separadores**, como **vírgulas**, **pontos** ou **qualquer caractere
especial**.

```java
import java.util.Scanner;

public class ScannerDelimitador {
    public static void main(String[] args) {
        String texto = "Maçã,Laranja,Banana,Uva";
        Scanner scanner = new Scanner(texto);

        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            System.out.println("Fruta: " + scanner.next());
        }

        scanner.close();
    }
}
```

🔎 **Saída esperada:**

```
Fruta: Maçã
Fruta: Laranja
Fruta: Banana
Fruta: Uva
```

📌 **Explicação:**

- `useDelimiter(",")` faz com que **a vírgula seja usada como separador** em vez de espaço.

---

### **2.3 Lendo Números com Scanner**

Podemos ler diferentes tipos de dados, como **inteiros e decimais**.

```java
import java.util.Scanner;

public class ScannerNumeros {
    public static void main(String[] args) {
        String numeros = "10 20 30 40 50";
        Scanner scanner = new Scanner(numeros);

        while (scanner.hasNextInt()) {
            System.out.println("Número: " + scanner.nextInt());
        }

        scanner.close();
    }
}
```

🔎 **Saída esperada:**

```
Número: 10
Número: 20
Número: 30
Número: 40
Número: 50
```

📌 **Explicação:**

- `hasNextInt()` verifica se **o próximo token é um número inteiro** antes de lê-lo.

---

### **2.4 Mudando Delimitador para Regex**

Podemos usar **expressões regulares** como delimitadores.

```java
import java.util.Scanner;

public class ScannerRegex {
    public static void main(String[] args) {
        String texto = "Ana|Bruno|Carlos|Daniela";
        Scanner scanner = new Scanner(texto);

        scanner.useDelimiter("\\|"); // Usando "|" como separador

        while (scanner.hasNext()) {
            System.out.println("Nome: " + scanner.next());
        }

        scanner.close();
    }
}
```

🔎 **Saída esperada:**

```
Nome: Ana
Nome: Bruno
Nome: Carlos
Nome: Daniela
```

📌 **Explicação:**

- `useDelimiter("\\|")` **usa a barra vertical (`|`) como separador**, sendo necessário escapar (`\\`) porque `|` é um
  caractere especial no regex.

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você está separando frutas em cestos**.

- Você tem uma caixa cheia de frutas misturadas **(string com dados)**.
- Você decide separá-las **uma por uma** para organizar melhor **(tokens)**.
- Se você usar **espaços para separar**, cada fruta fica em um **cesto diferente**.
- Mas e se algumas frutas estiverem separadas por **vírgulas ou traços**? Você precisa usar um **novo delimitador** para
  organizá-las corretamente.

🔎 **Moral da história:**  
O **Scanner no Java** é como um organizador de itens: **lê uma entrada, divide em partes menores (tokens) e usa
delimitadores para definir os separadores**! 🍎🍊🧺