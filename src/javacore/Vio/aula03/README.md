# 📌 **Classe Utilitária `FileReader` - Java IO**

A classe **`FileReader`**, do pacote `java.io`, é usada para **ler dados de arquivos de texto**. Ela lê **caractere por
caractere** e funciona bem para arquivos pequenos, mas pode ser combinada com `BufferedReader` para melhorar o
desempenho.

---

## 🎯 **1. Para que serve a classe `FileReader`?**

✅ **Ler arquivos de texto no formato de caracteres (char).**  
✅ **Processar arquivos linha por linha quando combinado com `BufferedReader`.**  
✅ **Facilitar a leitura de arquivos sem precisar lidar com bytes diretamente.**

---

## 🛠 **2. Como utilizar a classe `FileReader` no Java?**

### **2.1 Lendo um Arquivo Caracter por Caracter**

Podemos usar `read()` para ler o arquivo **um caractere de cada vez**.

```java
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
    public static void main(String[] args) {
        try {
            FileReader leitor = new FileReader("exemplo.txt");

            int caractere;
            while ((caractere = leitor.read()) != -1) { // Lê até o final do arquivo
                System.out.print((char) caractere); // Converte para caractere
            }

            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}
```

🔎 **Saída esperada (conteúdo de `exemplo.txt`):**

```
Olá, mundo!
Escrevendo em um arquivo com FileWriter.
Nova linha adicionada.
```

📌 **Explicação:**

- `FileReader leitor = new FileReader("exemplo.txt")` abre o arquivo.
- `read()` lê **um caractere por vez** até o final (`-1`).
- `(char) caractere` converte o número lido para um **caractere legível**.
- `close()` fecha o arquivo para evitar **vazamento de memória**.

---

### **2.2 Lendo um Arquivo Linha por Linha (com `BufferedReader`)**

Para **melhor desempenho**, podemos ler **linha por linha** com `BufferedReader`.

```java
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LerArquivoLinha {
    public static void main(String[] args) {
        try {
            FileReader leitor = new FileReader("exemplo.txt");
            BufferedReader buffer = new BufferedReader(leitor);

            String linha;
            while ((linha = buffer.readLine()) != null) { // Lê até o final
                System.out.println(linha);
            }

            buffer.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}
```

🔎 **Saída esperada:**

```
Olá, mundo!
Escrevendo em um arquivo com FileWriter.
Nova linha adicionada.
```

📌 **Explicação:**

- `BufferedReader` usa `readLine()`, que lê uma linha inteira de uma vez.
- Isso **evita ler caractere por caractere**, tornando a leitura **mais eficiente**.

---

### **2.3 Tentando Ler um Arquivo que Não Existe**

Se o arquivo **não existir**, o `FileReader` lançará uma `FileNotFoundException`.

```java
FileReader leitor = new FileReader("arquivo_inexistente.txt");
```

🔎 **Erro esperado:**

```
java.io.FileNotFoundException: arquivo_inexistente.txt (O sistema não pode encontrar o arquivo especificado)
```

📌 **Solução:**  
Podemos **verificar se o arquivo existe antes de tentar ler**:

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VerificarArquivo {
    public static void main(String[] args) {
        File arquivo = new File("exemplo.txt");

        if (arquivo.exists()) {
            try {
                FileReader leitor = new FileReader(arquivo);
                System.out.println("Arquivo encontrado e pronto para leitura.");
                leitor.close();
            } catch (IOException e) {
                System.out.println("Erro ao abrir o arquivo.");
            }
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
```

🔎 **Saída esperada (se o arquivo existir):**

```
Arquivo encontrado e pronto para leitura.
```

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que você está lendo um livro.**

- **FileReader lê letra por letra** 📖 (lento, mas preciso).
- **BufferedReader lê linha por linha** 📜 (mais rápido e eficiente).
- Se você **não encontrar o livro (arquivo não existe), recebe um erro**.

🔎 **Moral da história:**  
O `FileReader` permite **ler arquivos no Java**, mas combiná-lo com **`BufferedReader` melhora a velocidade e eficiência
da leitura**! 🚀