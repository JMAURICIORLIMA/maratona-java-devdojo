# Classes abstratas em Java

## Classes abstratas - Baeldung [^01]

[^01]: Acesse o site em inglês -> [Classes abstratas em Java - Baeldung](https://www.baeldung.com/java-abstract-class)

## 84 - Orientação Objetos - Classes abstratas pt 01 [^02]

[^02]: Assita o vídeo no Youtube -> [84 - Orientação Objetos - Classes abstratas pt 01](https://abre.ai/hzaZ)

## 1. Visão Geral

Existem muitos casos na implementação de um contrato em que queremos adiar algumas partes da implementação para serem
concluídas mais tarde. Podemos fazer isso facilmente em Java por meio de classes abstratas.

**Neste tutorial, aprenderemos o básico das classes abstratas em Java e em quais casos elas podem ser úteis.**

## 2. Conceitos-chave para classes abstratas

Antes de nos aprofundarmos em quando usar uma classe abstrata, **vejamos suas características mais relevantes**:

- **Definimos uma classe abstrata com o _modificador abstrato_ precedendo a _class_ palavra-chave**
- Uma classe abstrata pode ter subclasses, mas não pode ser instanciada
- Se uma classe define um ou mais _métodos abstratos_, então a própria classe deve ser declarada _abstrata_
- **Uma classe abstrata pode declarar métodos abstratos e concretos**
- Uma subclasse derivada de uma classe abstrata deve implementar todos os métodos abstratos da classe base ou ser ela
  mesma abstrata

Para entender melhor esses conceitos, criaremos um exemplo simples.

Vamos fazer com que nossa classe abstrata base defina a API abstrata de um jogo de tabuleiro:

```java
public abstract class BoardGame {

    //... field declarations, constructors

    public abstract void play();

    //... concrete methods

}
```

Então, podemos criar uma subclasse que implemente o método play:

```java
public class Checkers extends BoardGame {

    public void play() {
        //... implementation
    }

}
```

## 3. Quando usar classes abstratas

Agora, **vamos analisar alguns cenários típicos onde devemos preferir classes abstratas a interfaces** e classes
concretas:

- Queremos encapsular algumas funcionalidades comuns em um só lugar (reutilização de código) que múltiplas subclasses
  relacionadas irão compartilhar
- Precisamos definir parcialmente uma API que nossas subclasses possam estender e refinar facilmente
- As subclasses precisam herdar um ou mais métodos ou campos comuns com modificadores de acesso protegidos

Tenhamos em mente que todos esses cenários são bons exemplos de adesão total e baseada em herança ao [princípio
Aberto/Fechado](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle).

Além disso, como o uso de classes abstratas lida implicitamente com tipos e subtipos básicos, também estamos
aproveitando o [Polimorfismo](https://www.baeldung.com/java-polymorphism).

Observe que a reutilização de código é um motivo muito convincente para usar classes abstratas, desde que o
relacionamento “é um” dentro da hierarquia de classes seja preservado.

**E [o Java 8 adiciona outro problema com os métodos padrão](https://www.baeldung.com/java-static-default-methods), que
às vezes podem substituir a necessidade de criar uma classe abstrata por completo.**

## 4. Um exemplo de hierarquia de leitores de arquivos

Para entender mais claramente a funcionalidade que as classes abstratas trazem para a mesa, vejamos outro exemplo.

### 4.1. Definindo uma classe abstrata base

Então, se quiséssemos ter vários tipos de leitores de arquivos, poderíamos criar uma classe abstrata que encapsulasse o
que é comum na leitura de arquivos:

```java
public abstract class BaseFileReader {

    protected Path filePath;

    protected BaseFileReader(Path filePath) {
        this.filePath = filePath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public List<String> readFile() throws IOException {
        return Files.lines(filePath)
                .map(this::mapFileLine).collect(Collectors.toList());
    }

    protected abstract String mapFileLine(String line);

}
```

Observe que tornamos o filePath protegido para que as subclasses possam acessá-lo, se necessário. Mais importante ainda,
**deixamos algo por fazer: como realmente analisar uma linha de texto** do conteúdo do arquivo.

Nosso plano é simples: embora nossas classes concretas não tenham uma maneira especial de armazenar o caminho do arquivo
ou percorrer o arquivo, cada uma delas terá uma maneira especial de transformar cada linha.

À primeira vista, BaseFileReader pode parecer desnecessário. No entanto, é a base de um design limpo e facilmente
extensível. A partir dele, **podemos implementar facilmente diferentes versões de um leitor de arquivos que podem se
concentrar em sua lógica de negócios exclusiva**.

### 4.2. Definindo Subclasses

Uma implementação natural é provavelmente aquela que converte o conteúdo de um arquivo em letras minúsculas:

```java
public class LowercaseFileReader extends BaseFileReader {

    public LowercaseFileReader(Path filePath) {
        super(filePath);
    }

    @Override
    public String mapFileLine(String line) {
        return line.toLowerCase();
    }

}
```

Ou outro pode ser aquele que converte o conteúdo de um arquivo em letras maiúsculas:

```java
public class UppercaseFileReader extends BaseFileReader {

    public UppercaseFileReader(Path filePath) {
        super(filePath);
    }

    @Override
    public String mapFileLine(String line) {
        return line.toUpperCase();
    }

}
```

Como podemos ver neste exemplo simples, cada subclasse pode focar em seu comportamento único sem a necessidade de
especificar outros aspectos de leitura de arquivo.

### 4.3. Usando uma subclasse

Finalmente, usar uma classe que herda de uma classe abstrata não é diferente de qualquer outra classe concreta:

```java

@Test
public void givenLowercaseFileReaderInstance_whenCalledreadFile_thenCorrect() throws Exception {
    URL location = getClass().getClassLoader().getResource("files/test.txt")
    Path path = Paths.get(location.toURI());
    BaseFileReader lowercaseFileReader = new LowercaseFileReader(path);

    assertThat(lowercaseFileReader.readFile()).isInstanceOf(List.class);

}
```

Para simplificar, o arquivo de destino está localizado na pasta src/main/resources/files . Portanto, usamos um
carregador de classes de aplicativo para obter o caminho do arquivo de exemplo. Sinta-se à vontade para conferir [nosso
tutorial sobre carregadores de classes em Java](https://www.baeldung.com/java-classloaders).

## 5. Conclusão

Neste artigo rápido, **aprendemos os fundamentos das classes abstratas em Java e quando usá-las para obter abstração e
encapsular implementações comuns em um único lugar**.

# **Métodos Abstratos em Classes Abstratas - Detalhes Adicionais**

## 85 - Orientação Objetos - Classes abstratas pt 02 - Métodos abstratos [^04]

[^04]: Assita o vídeo no
Youtube -> [85 - Orientação Objetos - Classes abstratas pt 02 - Métodos abstratos](https://abre.ai/hzlo)

Vamos aprofundar um pouco mais nos métodos abstratos dentro de classes abstratas:

1. **Implementação nas Subclasses:**

- Um método abstrato em uma classe abstrata não tem implementação na própria classe. A implementação é fornecida por
  subclasses concretas.

  ```java
  public abstract class Animal {
      public abstract void fazerSom();
  }

  public class Cachorro extends Animal {
      @Override
      public void fazerSom() {
          System.out.println("Latindo...");
      }
  }
  ```

2. **Modificadores de Acesso:**

- Métodos abstratos em uma classe abstrata podem ter modificadores de acesso, como `public`, `protected`, ou `default`.

  ```java
  public abstract class Animal {
      protected abstract void mover();
  }
  ```

3. **Assinatura do Método:**

- As subclasses devem fornecer uma implementação que tenha a mesma assinatura (nome, tipo de retorno, e tipos de
  parâmetros) do método abstrato na classe pai.

  ```java
  public abstract class Animal {
      public abstract void fazerSom();
  }

  public class Gato extends Animal {
      @Override
      public void fazerSom() {
          System.out.println("Miando...");
      }
  }
  ```

4. **Métodos Concretos Junto com Métodos Abstratos:**

- Uma classe abstrata pode ter métodos concretos (com implementação) além de métodos abstratos. Isso permite fornecer
  alguma funcionalidade padrão nas classes que herdam.

  ```java
  public abstract class Animal {
      public void mover() {
          System.out.println("Movendo-se...");
      }

      public abstract void fazerSom();
  }
  ```

5. **Chamada de Métodos Abstratos:**

- Métodos abstratos podem ser chamados em outras partes do código da classe abstrata, mesmo que não tenham uma
  implementação real na classe. A implementação será fornecida pelas subclasses.

  ```java
  public abstract class Animal {
      public void executarAcao() {
          fazerSom();
          mover();
      }

      public abstract void fazerSom();
      protected abstract void mover();
  }
  ```

Lembre-se de que a ideia principal de métodos abstratos em classes abstratas é fornecer uma estrutura para subclasses
implementarem. Esses métodos são como contratos que as subclasses devem cumprir.

# **Regras para Métodos Abstratos em Classes Abstratas**

## 86 - Orientação Objetos - Classes abstratas pt 03 - Métodos abstratos regras [^05]

[^05]: Assita o vídeo no
Youtube -> [86 - Orientação Objetos - Classes abstratas pt 03 - Métodos abstratos regras](https://abre.ai/hzm2)

Métodos abstratos em classes abstratas seguem algumas regras específicas:

1. **Não Pode Ter Implementação:**

- Um método abstrato não pode ter uma implementação na classe abstrata. Se tiver qualquer implementação, ele não pode
  ser declarado como abstrato.

  ```java
  // Incorreto
  public abstract class Exemplo {
      public abstract void metodoAbstrato() {
          // implementação...
      }
  }
  ```

2. **Deve Ser Implementado por Subclasses:**

- Subclasses concretas (não abstratas) da classe abstrata devem fornecer uma implementação para todos os métodos
  abstratos da classe pai.

  ```java
  public abstract class Animal {
      public abstract void fazerSom();
  }

  public class Cachorro extends Animal {
      @Override
      public void fazerSom() {
          System.out.println("Latindo...");
      }
  }
  ```

3. **Pode Ter Modificadores de Acesso:**

- Métodos abstratos podem ter modificadores de acesso como `public`, `protected`, ou `default`. Não faz sentido
  ser `private` porque, nesse caso, não poderia ser implementado pelas subclasses.

  ```java
  public abstract class Exemplo {
      protected abstract void metodoAbstrato();
  }
  ```

4. **Pode Ter Parâmetros e Tipo de Retorno:**

- Assim como métodos normais, métodos abstratos podem ter parâmetros e um tipo de retorno.

  ```java
  public abstract class Exemplo {
      public abstract int calcularAlgumaCoisa(int a, int b);
  }
  ```

5. **Pode Ser Chamado por Outros Métodos da Classe:**

- Mesmo não tendo uma implementação, um método abstrato pode ser chamado por outros métodos na mesma classe abstrata. A
  implementação será fornecida pelas subclasses.

  ```java
  public abstract class Animal {
      public void executarAcao() {
          fazerSom();
      }

      public abstract void fazerSom();
  }
  ```

6. **Deve Ser Marcado como "Abstract":**

- Para indicar que um método é abstrato, você usa a palavra-chave `abstract`. Isso é necessário para a sintaxe correta e
  para informar ao compilador que as subclasses devem fornecer uma implementação.

  ```java
  public abstract class Exemplo {
      public abstract void metodoAbstrato();
  }
  ```

Lembre-se, a ideia principal é que métodos abstratos em classes abstratas proporcionam uma estrutura ou contrato que as
subclasses devem seguir.