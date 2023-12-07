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