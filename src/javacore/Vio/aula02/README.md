# 📌 **Classe Utilitária `FileWriter` - Java IO**

A classe **`FileWriter`**, do pacote `java.io`, é usada para **escrever dados em arquivos**. Diferente da classe `File`,
que apenas **manipula arquivos e diretórios**, o `FileWriter` permite **escrever diretamente no arquivo**.

---

## 🎯 **1. Para que serve a classe `FileWriter`?**

✅ **Criar e escrever em arquivos** de forma simples.  
✅ **Sobrescrever ou adicionar conteúdo** a arquivos existentes.  
✅ **Trabalhar com `BufferedWriter`** para melhorar o desempenho da escrita.

---

## 🛠 **2. Como utilizar a classe `FileWriter` no Java?**

### **2.1 Escrevendo em um Arquivo (Criando e Sobrescrevendo)**

Por padrão, `FileWriter` **cria um novo arquivo** ou **sobrescreve um existente**.

```java
import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivo {
    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("exemplo.txt");

            escritor.write("Olá, mundo!\n");
            escritor.write("Escrevendo em um arquivo com FileWriter.");

            escritor.close();
            System.out.println("Texto escrito com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
```

🔎 **Saída esperada (conteúdo do arquivo `exemplo.txt`):**

```
Olá, mundo!
Escrevendo em um arquivo com FileWriter.
```

📌 **Explicação:**

- `new FileWriter("exemplo.txt")` cria ou sobrescreve o arquivo.
- `write()` escreve texto no arquivo.
- `close()` fecha o arquivo, garantindo que os dados sejam gravados corretamente.

---

### **2.2 Adicionando Conteúdo ao Arquivo (Modo Append)**

Se quisermos **adicionar conteúdo sem apagar o existente**, usamos **`true`** no construtor do `FileWriter`.

```java
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarArquivo {
    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("exemplo.txt", true); // Modo append

            escritor.write("\nNova linha adicionada.");
            escritor.close();

            System.out.println("Texto adicionado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
```

🔎 **Saída esperada (conteúdo atualizado de `exemplo.txt`):**

```
Olá, mundo!
Escrevendo em um arquivo com FileWriter.
Nova linha adicionada.
```

📌 **Explicação:**

- `new FileWriter("exemplo.txt", true)` → O parâmetro `true` **ativa o modo de adição** (append).

---

### **2.3 Melhorando a Escrita com `BufferedWriter`**

O `FileWriter` escreve **caractere por caractere**, o que pode ser lento. Para melhorar a eficiência, podemos usar
`BufferedWriter`.

```java
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class EscreverComBuffer {
    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("exemplo.txt", true);
            BufferedWriter buffer = new BufferedWriter(escritor);

            buffer.write("\nUsando BufferedWriter para melhorar a escrita.");
            buffer.newLine(); // Adiciona uma nova linha
            buffer.write("Escrita mais eficiente!");

            buffer.close();
            System.out.println("Texto escrito com buffer!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
```

🔎 **Saída esperada (conteúdo atualizado de `exemplo.txt`):**

```
Olá, mundo!
Escrevendo em um arquivo com FileWriter.
Nova linha adicionada.
Usando BufferedWriter para melhorar a escrita.
Escrita mais eficiente!
```

📌 **Explicação:**

- `BufferedWriter` armazena os dados em **memória temporária** e só escreve no arquivo quando necessário, **melhorando o
  desempenho**.

---

### **2.4 Tentando Escrever em Arquivo Protegido**

Se tentarmos escrever em um arquivo **somente leitura**, o programa gera um erro.

```java
FileWriter escritor = new FileWriter("arquivo_protegido.txt");
```

🔎 **Erro esperado:**

```
java.io.IOException: Permission denied
```

📌 **Explicação:**

- **Se o arquivo estiver protegido contra escrita**, o `FileWriter` lançará uma `IOException`.

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você está escrevendo um diário.**

- O diário (arquivo) pode **já existir** ou você pode **criar um novo**.
- Você pode **escrever um novo capítulo** (sobrescrevendo o arquivo).
- Ou **adicionar novas páginas** sem apagar as antigas (modo append).
- Se você escrever **com uma caneta que solta pouca tinta (FileWriter puro)**, será mais demorado.
- Mas se você **usar uma caneta de ponta macia (BufferedWriter)**, a escrita será **mais rápida e fluida**.

🔎 **Moral da história:**  
O `FileWriter` permite **escrever arquivos no Java**, e **usá-lo com `BufferedWriter` torna o processo mais eficiente**!
📝🚀