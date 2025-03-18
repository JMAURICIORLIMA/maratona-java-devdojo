# 📌 **Classe Utilitária `File` - Java IO**

A classe **`File`**, do pacote `java.io`, é usada para manipular **arquivos e diretórios** em Java. **Ela não lê ou
escreve diretamente no arquivo**, mas permite **verificar a existência, criar, excluir e obter informações** sobre
arquivos e pastas.

---

## 🎯 **1. Para que serve a classe `File`?**

✅ **Criar, excluir e verificar a existência** de arquivos e diretórios.  
✅ **Obter informações** como nome, caminho, tamanho e permissões.  
✅ **Navegar por diretórios** e listar arquivos dentro de uma pasta.

---

## 🛠 **2. Como utilizar a classe `File` no Java?**

### **2.1 Criando um Arquivo**

Podemos criar um arquivo usando o método `.createNewFile()`.

```java
import java.io.File;
import java.io.IOException;

public class CriarArquivo {
    public static void main(String[] args) {
        try {
            File arquivo = new File("exemplo.txt");

            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado: " + arquivo.getName());
            } else {
                System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }
}
```

🔎 **Saída esperada:**

```
Arquivo criado: exemplo.txt
```

📌 **Explicação:**

- `File arquivo = new File("exemplo.txt")` cria um objeto **representando um arquivo**.
- `createNewFile()` **tenta criar o arquivo**, retornando `true` se criado com sucesso.
- Se o arquivo já existir, exibe a mensagem correspondente.

---

### **2.2 Verificando se um Arquivo Existe**

Podemos verificar se um arquivo já existe usando `.exists()`.

```java
File arquivo = new File("exemplo.txt");

if(arquivo.

exists()){
        System.out.

println("O arquivo existe.");
}else{
        System.out.

println("O arquivo não existe.");
}
```

🔎 **Saída esperada:**

```
O arquivo existe.
```

📌 **Explicação:**

- `exists()` retorna `true` se o arquivo estiver presente.

---

### **2.3 Obtendo Informações do Arquivo**

Podemos obter informações do arquivo, como nome, caminho e tamanho.

```java
File arquivo = new File("exemplo.txt");

if(arquivo.

exists()){
        System.out.

println("Nome: "+arquivo.getName());
        System.out.

println("Caminho absoluto: "+arquivo.getAbsolutePath());
        System.out.

println("Tamanho (bytes): "+arquivo.length());
        }
```

🔎 **Saída esperada:**

```
Nome: exemplo.txt
Caminho absoluto: C:\Users\MeuPC\exemplo.txt
Tamanho (bytes): 0
```

📌 **Explicação:**

- `.getName()` → Retorna o nome do arquivo.
- `.getAbsolutePath()` → Retorna o caminho completo.
- `.length()` → Retorna o tamanho do arquivo **em bytes**.

---

### **2.4 Criando um Diretório**

Podemos criar **pastas** usando `.mkdir()`.

```java
File pasta = new File("minhaPasta");

if(pasta.

mkdir()){
        System.out.

println("Pasta criada com sucesso.");
}else{
        System.out.

println("A pasta já existe ou não pôde ser criada.");
}
```

🔎 **Saída esperada:**

```
Pasta criada com sucesso.
```

📌 **Explicação:**

- `.mkdir()` cria **um único diretório**.
- `.mkdirs()` cria **vários diretórios aninhados**, se necessário.

---

### **2.5 Listando Arquivos de uma Pasta**

Podemos listar arquivos dentro de uma pasta com `.listFiles()`.

```java
File pasta = new File("minhaPasta");

File[] arquivos = pasta.listFiles();

if(arquivos !=null){
        for(
File arquivo :arquivos){
        System.out.

println("Encontrado: "+arquivo.getName());
        }
        }else{
        System.out.

println("A pasta não existe ou está vazia.");
}
```

🔎 **Saída esperada:**

```
Encontrado: arquivo1.txt
Encontrado: arquivo2.txt
Encontrado: subpasta
```

📌 **Explicação:**

- `.listFiles()` retorna um **array de arquivos e pastas** dentro do diretório especificado.

---

### **2.6 Excluindo Arquivos e Diretórios**

Podemos excluir arquivos e pastas com `.delete()`.

```java
File arquivo = new File("exemplo.txt");

if(arquivo.

delete()){
        System.out.

println("Arquivo excluído com sucesso.");
}else{
        System.out.

println("Falha ao excluir o arquivo.");
}
```

🔎 **Saída esperada:**

```
Arquivo excluído com sucesso.
```

📌 **Explicação:**

- `.delete()` remove **arquivos e pastas vazias**.
- **Não remove diretórios com arquivos dentro**.

---

## 📖 **3. Resumo com Parábola**

💡 **Imagine que seu computador é uma grande biblioteca**.

- Cada **arquivo** é um **livro** armazenado. 📚
- A classe `File` é como **um bibliotecário**, que **não lê os livros**, mas **sabe onde eles estão, quais existem e
  pode criar ou remover livros**.
- Ele pode **organizar estantes (pastas)** 📂 e listar os livros que estão em cada uma delas.
- Se um livro **não existir**, o bibliotecário avisa.
- Se você quiser **remover um livro**, ele pode excluí-lo da biblioteca.

🔎 **Moral da história:**  
A classe `File` é **essencial para gerenciar arquivos e diretórios**, mas para **ler ou escrever** em arquivos, usamos
`FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`, entre outros.

📂 **Agora você sabe como manipular arquivos e pastas em Java!** 🚀