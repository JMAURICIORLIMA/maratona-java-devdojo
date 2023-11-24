# Orientação Objetos - Associação

## 64 - Orientação Obejtos - Associação pt 01 - Arrays com Objetos [^01]

[^01]: Acesse o vídeo YouTube -> [64 - Orientação Obejtos - Associação pt 01 - Arrays com Objetos](https://abre.ai/hkAa)

A associação em programação orientada a objetos refere-se à relação entre objetos. Uma forma comum de associação é
quando um objeto contém uma coleção de outros objetos, como um array de objetos. Vamos explorar um exemplo de associação
usando arrays em Java:

Suponha que você tenha uma classe `Aluno` e uma classe `Turma`. Cada turma pode conter vários alunos. Vamos criar uma
associação usando um array de objetos `Aluno` na classe `Turma`:

```java
public class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

public class Turma {
    private String nomeTurma;
    private Aluno[] alunos;

    public Turma(String nomeTurma, int numeroAlunos) {
        this.nomeTurma = nomeTurma;
        this.alunos = new Aluno[numeroAlunos];
    }

    public void adicionarAluno(Aluno aluno, int indice) {
        if (indice >= 0 && indice < alunos.length) {
            alunos[indice] = aluno;
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarAlunos() {
        System.out.println("Alunos da turma " + nomeTurma + ":");
        for (Aluno aluno : alunos) {
            if (aluno != null) {
                System.out.println(aluno.getNome());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");

        Turma turmaA = new Turma("Turma A", 2);
        turmaA.adicionarAluno(aluno1, 0);
        turmaA.adicionarAluno(aluno2, 1);

        turmaA.listarAlunos();
    }
}
```

Neste exemplo:

- A classe `Aluno` representa um aluno com um nome.
- A classe `Turma` tem um array de objetos `Aluno` e métodos para adicionar alunos e listar alunos.

Este é um exemplo simples de associação em que uma classe (`Turma`) contém uma coleção de objetos de outra
classe (`Aluno`). Essa coleção poderia ser um array, uma lista ou qualquer outra estrutura de dados, dependendo das
necessidades do programa.

#

## 65 - Orientação Obejtos - Associação pt 02 - Associação unidirecional um para muitos [^02]

[^02]: Acesse o vídeo
YouTube -> [65 - Orientação Obejtos - Associação pt 02 - Associação unidirecional um para muitos](https://abre.ai/hkA0)

**Associação em Programação Orientada a Objetos (POO):**

**Definições de tipos de associações**

A associação é um conceito chave em programação orientada a objetos, representando a relação entre classes e objetos.
Essa relação pode ser classificada em diferentes tipos, cada um descrevendo a natureza e a cardinalidade da associação.
Vamos explorar esses tipos:

### 1. **Associação Binária:**

- **Definição:** Relação entre dois tipos de objetos.
- **Exemplo:** Relacionamento entre `Carro` e `Motor`.

### 2. **Associação de Agregação:**

- **Definição:** Uma forma específica de associação binária indicando que uma classe é parte de outra classe.
- **Exemplo:** Uma `RodadeCarro` é parte de um `Carro`.

### 3. **Associação de Composição:**

- **Definição:** Uma forma mais forte de agregação, indicando que uma classe é composta por outra classe.
- **Exemplo:** Um `Motor` é uma parte vital de um `Carro`. Se o `Carro` for destruído, o `Motor` também será.

### 4. **Associação Bidirecional:**

- **Definição:** Ambas as classes podem interagir entre si.
- **Exemplo:** Relacionamento entre `Professor` e `Aluno`.

### 5. **Associação Unidirecional:**

- **Definição:** A relação entre as classes ocorre em uma única direção.
- **Exemplo:** Apenas o `Aluno` conhece o `Professor`, mas não o contrário.

### 6. **Associação Multiplicidade:**

- **Definição:** Indica quantos objetos de uma classe estão associados a quantos objetos da outra classe.
- **Exemplo:** Um `Aluno` pode ter várias `Matérias` (1-n).

### 7. **Associação Reflexiva:**

- **Definição:** Uma classe está associada a ela mesma.
- **Exemplo:** Relacionamento entre `Pessoa` e `Amigo`.

### 8. **Associação de Navegação:**

- **Definição:** Descreve se uma classe pode "navegar" para a outra.
- **Exemplo:** `Pessoa` pode navegar para `Endereço`.

### 9. **Associação de Dependência:**

- **Definição:** Uma classe depende de outra se a alteração em uma pode afetar a outra.
- **Exemplo:** `Pedido` depende de `Produto`.

### 10. **Associação de Agregação Fraca:**

- **Definição:** Um objeto pode existir independentemente do outro.
- **Exemplo:** Uma `Escola` pode ter ou não `Alunos`.

### 11. **Associação de Agregação Forte:**

- **Definição:** Um objeto não pode existir independentemente do outro.
- **Exemplo:** Uma `Mão` não pode existir sem um `Corpo`.

### 12. **Associação de Canal Único:**

- **Definição:** Uma classe é conectada a outra por meio de um único caminho.
- **Exemplo:** Relacionamento de canal único entre `Pessoa` e `Passaporte`.

Estas são generalizações e as implementações podem variar dependendo da linguagem de programação e do design específico
do sistema.

#

**Associação Unidirecional Um-para-Muitos:**

Na associação unidirecional um-para-muitos, uma classe (a classe "um") está associada a várias instâncias de outra
classe (a classe "muitos"). Vamos usar um exemplo para ilustrar isso:

**Exemplo:**
Imagine um sistema de uma escola, onde temos duas classes principais: `Professor` e `Aluno`. Uma abordagem unidirecional
um-para-muitos pode ser estabelecida entre `Professor` e `Aluno`. Um professor pode ter vários alunos, mas um aluno tem
apenas um professor.

**Implementação em Java:**

```java
import java.util.List;
import java.util.ArrayList;

class Professor {
    private String nome;
    private List<Aluno> alunos;

    public Professor(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}

class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

public class Escola {
    public static void main(String[] args) {
        Professor professor = new Professor("Dr. Silva");

        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");

        professor.adicionarAluno(aluno1);
        professor.adicionarAluno(aluno2);

        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos:");
        for (Aluno aluno : professor.getAlunos()) {
            System.out.println("- " + aluno.getNome());
        }
    }
}
```

Neste exemplo:

- A classe `Professor` tem uma lista de alunos (`List<Aluno> alunos`).
- O método `adicionarAluno` permite que um professor adicione alunos à sua lista.
- A classe `Aluno` é simples e apenas armazena o nome do aluno.
- O programa principal (`Escola`) demonstra como criar um professor, adicionar alunos a ele e exibir as informações.

Lembre-se de que este é um exemplo simplificado, e na prática, você precisaria lidar com mais complexidades, como
tratamento de exceções, persistência de dados, entre outros.

#

## 66 - Orientação Obejtos - Associação pt 03 - Associação unidirecional muitos para um [^03]

[^03]: Acesse o vídeo
YouTube -> [66 - Orientação Obejtos - Associação pt 03 - Associação unidirecional muitos para um](https://abre.ai/hkB2)

**Associação Unidirecional Muitos-para-Um:**

Na associação unidirecional muitos-para-um, várias instâncias de uma classe (a classe "muitos") estão associadas a uma
única instância de outra classe (a classe "um"). Vamos usar um exemplo para ilustrar isso:

**Exemplo:**
Suponha um sistema de blog onde temos duas classes principais: `Post` e `Autor`. Uma abordagem unidirecional
muitos-para-um pode ser estabelecida entre `Post` e `Autor`. Vários posts podem ter um único autor, mas um autor está
associado a vários posts.

**Implementação em Java:**

```java
import java.util.List;
import java.util.ArrayList;

class Post {
    private String titulo;
    private String conteudo;
    private Autor autor;

    public Post(String titulo, String conteudo, Autor autor) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Autor getAutor() {
        return autor;
    }
}

class Autor {
    private final String nome;

    public Autor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

public class Blog {
    public static void main(String[] args) {
        Autor autor = new Autor("Carlos");

        Post post1 = new Post("Java Basics", "Introduction to Java programming.", autor);
        Post post2 = new Post("OOP Principles", "Understanding Object-Oriented Programming.", autor);

        System.out.println("Autor: " + autor.getNome());
        System.out.println("Posts:");
        System.out.println("- " + post1.getTitulo());
        System.out.println("- " + post2.getTitulo());
    }
}
```

Neste exemplo:

- A classe `Post` tem uma referência para um `Autor` (`Autor autor`).
- O construtor do `Post` exige um autor ao criar um novo post.
- A classe `Autor` é simples e apenas armazena o nome do autor.
- O programa principal (`Blog`) demonstra como criar um autor, criar posts associados a esse autor e exibir as
  informações.

Assim como no exemplo anterior, esta é uma simplificação, e em situações mais complexas, outras considerações e práticas
de programação seriam necessárias.

#

## 67 - Orientação Obejtos - Associação pt 04 - Associação bidirecional [^04]

[^04]: Acesse o vídeo
YouTube -> [67 - Orientação Obejtos - Associação pt 04 - Associação bidirecional](https://abre.ai/hkEh)

**Associação Bidirecional:**

Na associação bidirecional, duas classes estão associadas de tal forma que ambas conhecem uma à outra. Vamos usar um
exemplo para entender isso.

**Exemplo:**
Considere um modelo de escola com duas classes principais: `Estudante` e `Turma`. Cada estudante está associado a uma
turma, e uma turma tem vários estudantes. Esta é uma associação bidirecional.

**Implementação em Java:**

```java
import java.util.List;
import java.util.ArrayList;

class Estudante {
    private String nome;
    private Turma turma;

    public Estudante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void associarTurma(Turma turma) {
        this.turma = turma;
    }
}

class Turma {
    private String nome;
    private List<Estudante> estudantes;

    public Turma(String nome) {
        this.nome = nome;
        this.estudantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
        estudante.associarTurma(this);
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }
}

public class Escola {
    public static void main(String[] args) {
        Turma turma = new Turma("Matemática");

        Estudante estudante1 = new Estudante("Alice");
        Estudante estudante2 = new Estudante("Bob");

        turma.adicionarEstudante(estudante1);
        turma.adicionarEstudante(estudante2);

        System.out.println("Turma: " + turma.getNome());
        System.out.println("Estudantes na Turma:");
        for (Estudante estudante : turma.getEstudantes()) {
            System.out.println("- " + estudante.getNome());
        }
    }
}
```

Neste exemplo:

- A classe `Estudante` tem uma referência para uma `Turma` (`Turma turma`).
- A classe `Turma` mantém uma lista de estudantes (`List<Estudante> estudantes`) e cada estudante mantém uma referência
  à sua turma (`this.turma = turma;` no método `associarTurma`).
- A classe `Turma` possui um método `adicionarEstudante` que adiciona um estudante à lista e também associa a turma ao
  estudante.
- O programa principal (`Escola`) cria uma turma, adiciona dois estudantes a essa turma e imprime os estudantes
  associados à turma.

Essa é uma forma de associação bidirecional, onde ambas as classes têm conhecimento uma da outra. Isso permite navegar
facilmente de um objeto para outro em ambas as direções.

#

## 68 - Orientação Objetos - Leitura de dados pelo console[^04]

[^05]: Acesse o vídeo
YouTube -> [68 - Orientação Objetos - Leitura de dados pelo console](https://abre.ai/hk2K)

A leitura de dados do teclado em Java pode ser realizada usando a classe `Scanner` ou a classe `BufferedReader`. Vou
fornecer exemplos para ambas.

### Usando `Scanner`:

```java
import java.util.Scanner;

public class LeituraTeclado {
    public static void main(String[] args) {
        // Criar um objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // Leitura de uma linha como String
        System.out.print("Digite uma linha: ");
        String linha = scanner.nextLine();
        System.out.println("Você digitou: " + linha);

        // Leitura de um número inteiro
        System.out.print("Digite um número inteiro: ");
        int numeroInteiro = scanner.nextInt();
        System.out.println("Você digitou: " + numeroInteiro);

        // Leitura de um número decimal
        System.out.print("Digite um número decimal: ");
        double numeroDecimal = scanner.nextDouble();
        System.out.println("Você digitou: " + numeroDecimal);

        // Fechar o scanner
        scanner.close();
    }
}
```

### Usando `BufferedReader`:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LeituraTeclado {
    public static void main(String[] args) {
        // Criar um objeto BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Leitura de uma linha como String
        try {
            System.out.print("Digite uma linha: ");
            String linha = br.readLine();
            System.out.println("Você digitou: " + linha);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leitura de um número inteiro
        try {
            System.out.print("Digite um número inteiro: ");
            int numeroInteiro = Integer.parseInt(br.readLine());
            System.out.println("Você digitou: " + numeroInteiro);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leitura de um número decimal
        try {
            System.out.print("Digite um número decimal: ");
            double numeroDecimal = Double.parseDouble(br.readLine());
            System.out.println("Você digitou: " + numeroDecimal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Ambos os exemplos fazem a leitura de dados do teclado, seja uma linha inteira como uma string, um número inteiro ou um
número decimal. Lembre-se de lidar com exceções, especialmente ao usar `BufferedReader`.