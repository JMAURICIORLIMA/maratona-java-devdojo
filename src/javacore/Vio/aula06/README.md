Oi! 😄 Agora vamos explorar como trabalhar com **diretórios** usando a classe utilitária **`File`**, da API de **IO (
Input/Output)** em Java.

---

## 📁 **File para Diretórios**

A classe `java.io.File` **não serve apenas para arquivos**, mas também para **diretórios (pastas)**.

### ✅ **O que dá pra fazer com `File` e diretórios?**

- Criar diretórios.
- Verificar se um caminho é diretório ou arquivo.
- Listar arquivos e pastas dentro de um diretório.
- Verificar se o diretório existe.
- Deletar diretórios (vazios).

---

## 🛠️ **Exemplos práticos**

### ✅ 1. **Criar um diretório**

```java
import java.io.File;

public class CriarDiretorio {
    public static void main(String[] args) {
        File pasta = new File("meu_diretorio");

        if (!pasta.exists()) {
            if (pasta.mkdir()) {
                System.out.println("📁 Diretório criado com sucesso!");
            } else {
                System.out.println("❌ Não foi possível criar o diretório.");
            }
        } else {
            System.out.println("⚠️ O diretório já existe.");
        }
    }
}
```

---

### ✅ 2. **Criar diretórios em hierarquia (aninhados)**

```java
File pastas = new File("diarios/2025/marco");
pastas.mkdirs(); // cria todos os diretórios intermediários se não existirem
```

---

### ✅ 3. **Listar arquivos e subpastas de um diretório**

```java
File pasta = new File("diarios");

if(pasta.exists() && pasta.isDirectory()){
String[] arquivos = pasta.list();

    System.out.println("📂 Conteúdo da pasta:");
    
    for(String nome :arquivos){
        System.out.println("📝 "+nome);
    }}else{
            System.out.println("❌ Pasta não encontrada.");
}

```

---

### ✅ 4. **Verificar se é arquivo ou diretório**

```java
File f = new File("diarios/entrada.txt");

if(f.isFile()){
        System.out.println("É um arquivo.");
}else if(f.isDirectory()){
        System.out.println("É um diretório.");
}else{
        System.out.println("Não existe.");
}
```

---

### ✅ 5. **Deletar diretório vazio**

```java
File pasta = new File("meu_diretorio");

if(pasta.exists() && pasta.isDirectory()){
        if(pasta.delete()){
            System.out.println("🗑️ Diretório deletado.");
        }else{
            System.out.println("⚠️ Não foi possível deletar (está vazio?).");
    }
}
```

⚠️ *Atenção*: `delete()` **só funciona se o diretório estiver vazio!*

---

## 📖 Resumo Rápido

| Método          | Descrição                                    |
|-----------------|----------------------------------------------|
| `mkdir()`       | Cria um diretório                            |
| `mkdirs()`      | Cria diretórios aninhados                    |
| `exists()`      | Verifica se existe                           |
| `isDirectory()` | Verifica se é um diretório                   |
| `list()`        | Lista o conteúdo (nomes de arquivos/pastas)  |
| `delete()`      | Apaga o diretório (somente se estiver vazio) |

---

## 🧠 Parábola para fixar

Imagine o sistema de arquivos como um **prédio**.  
Cada diretório é uma **porta de sala**, e os arquivos são **papéis guardados lá dentro**.

A classe `File` é como um **zelador**, que pode:

- Criar novas salas (pastas),
- Ver quem mora onde (listar conteúdo),
- Ver se a porta está aberta ou se a sala existe,
- E até trancar ou apagar salas vazias.

---