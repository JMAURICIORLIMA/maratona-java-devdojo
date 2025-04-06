Maravilha! Vamos continuar nossa jornada com **BufferedReader**, uma ferramenta poderosa para leitura de arquivos em
Java. 📖💻

---

## 📘 **O que é a classe `BufferedReader`?**

A classe `BufferedReader`, do pacote `java.io`, é usada para **ler dados de forma eficiente de arquivos ou qualquer
outra fonte de caracteres** (como teclado ou rede).

🔍 Diferente de `FileReader`, que lê **caractere por caractere**, o `BufferedReader` **armazena um pedaço maior em
memória (buffer)**, permitindo ler **linha por linha** ou grandes blocos com mais desempenho.

---

## 🧠 **Para que serve o `BufferedReader`?**

✅ Ler arquivos de texto com **eficiência**.  
✅ Ler **linha por linha** com o método `readLine()`.  
✅ Pode ser usado junto com `FileReader`, `InputStreamReader` e até `System.in`.

---

## 🛠️ **Como utilizar `BufferedReader`**

### ✅ **1. Lendo um arquivo linha por linha**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("exemplo.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}
```

### 🧾 Suponha que `exemplo.txt` contenha:

```
Olá, mundo!
Bem-vindo ao Java.
BufferedReader é muito útil.
```

💡 **Saída no console:**

```
Olá, mundo!
Bem-vindo ao Java.
BufferedReader é muito útil.
```

---

### ✅ **2. Lendo do teclado com BufferedReader (opcional)**

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LerTeclado {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Digite algo: ");
        String entrada = br.readLine();
        System.out.println("Você digitou: " + entrada);
    }
}
```

🧠 Aqui usamos `InputStreamReader` para adaptar a entrada do teclado (`System.in`) ao `BufferedReader`.

---

## ✅ **Resumo rápido**

| Classe           | Usada para           | Leitura                 | Eficiente? |
|------------------|----------------------|-------------------------|------------|
| `FileReader`     | Arquivos de texto    | caractere por caractere | ❌          |
| `BufferedReader` | Fontes de caracteres | linha por linha         | ✅          |

---

## 🧠 **Parábola para fixar o conceito**

Imagine que você está lendo um livro 📘, mas só pode abrir uma letra por vez com uma lupa (como faz o `FileReader`). Isso
é **muito demorado**!

Agora imagine que você pega uma folha inteira de uma vez e lê uma linha de cada vez com os olhos livres. Isso é o
`BufferedReader`: **mais rápido, mais prático, mais produtivo**. ⚡

🧵 Moral da história: **Leia com inteligência, não com pressa — e escolha o `BufferedReader`.**

---