# Polimorfismo em Java [^01]

[^01]: Acesse o site em inglês - Baeldung -> [Polimorfismo em Java](https://www.baeldung.com/java-polymorphism)

## 90 - Orientação Objetos - Polimorfismo pt 01 - Introdução[^02]

[^02]: Assita o vídeo no Youtube -> [90 - Orientação Objetos - Polimorfismo pt 01 - Introdução](https://abre.ai/hF6D)

## 1. Visão Geral

Todas as linguagens de Programação Orientada a Objetos (OOP) devem exibir quatro características básicas: abstração,
encapsulamento, herança e polimorfismo.

Neste artigo, cobrimos dois tipos principais de polimorfismo: polimorfismo estático ou em tempo de compilação e
polimorfismo dinâmico ou em tempo de execução. O polimorfismo estático é aplicado em tempo de compilação enquanto o
polimorfismo dinâmico é realizado em tempo de execução.

## 2. Polimorfismo Estático

De acordo com a Wikipedia, o polimorfismo estático é uma imitação do polimorfismo que é resolvido em tempo de
compilação e, portanto, elimina pesquisas em tabelas virtuais em tempo de execução.

Por exemplo, nossa classe TextFile em um aplicativo gerenciador de arquivos pode ter três métodos com a mesma assinatura
do método read():

```java
public class TextFile extends GenericFile {
//...

    public String read() {
        return this.getContent()
                .toString();
    }

    public String read(int limit) {
        return this.getContent()
                .toString()
                .substring(0, limit);
    }

    public String read(int start, int stop) {
        return this.getContent()
                .toString()
                .substring(start, stop);
    }

}
```

Durante a compilação do código, o compilador verifica se todas as invocações do método read correspondem a pelo menos um
dos três métodos definidos acima.

## 3. Polimorfismo Dinâmico

Com o polimorfismo dinâmico, a Java Virtual Machine (JVM) trata da detecção do método apropriado a ser executado quando
uma subclasse é atribuída ao seu formulário pai. Isto é necessário porque a subclasse pode substituir alguns ou todos
os métodos definidos na classe pai.

Em um aplicativo gerenciador de arquivos hipotético, vamos definir a classe pai para todos os arquivos chamados
GenericFile:

```java
public class GenericFile {
    private String name;

    //...

    public String getFileInfo() {
        return "Generic File Impl";
    }

}
```

Também podemos implementar uma ImageFile classe que estende GenericFile, mas substitui o método getFileInfo() e
acrescenta mais informações:

```java
public class ImageFile extends GenericFile {
    private int height;
    private int width;

    //... getters and setters

    public String getFileInfo() {
        return "Image File Impl";
    }

}
```

Quando criamos uma instância de ImageFile e a atribuímos a uma classe GenericFile, uma conversão implícita é feita. No
entanto, a JVM mantém uma referência à forma real de ImageFile.

A construção acima é análoga à substituição de método. Podemos confirmar isso invocando o método getFileInfo():

```java
public static void main(String[] args) {
    GenericFile genericFile = new ImageFile("SampleImageFile", 200, 100,
            new BufferedImage(100, 200, BufferedImage.TYPE_INT_RGB)
                    .toString()
                    .getBytes(), "v1.0.0");
    logger.info("File Info: \n" + genericFile.getFileInfo());
}
```

Como esperado, genericFile.getFileInfo() aciona o método getFileInfo() da classe ImageFile conforme visto na saída
abaixo:

```
File Info:
Image File Impl
```

## 4. Outras características polimórficas em Java

Além desses dois tipos principais de polimorfismo em Java, existem outras características na linguagem de programação
Java que apresentam polimorfismo. Vamos discutir algumas dessas características.

### 4.1. Coerção

A coerção polimórfica trata da conversão implícita de tipo feita pelo compilador para evitar erros de tipo. Um exemplo
típico é visto em uma concatenação de inteiros e strings:

```java
String str = “string” +2;
```

### 4.2. Sobrecarga do Operador

A sobrecarga de operador ou método refere-se a uma característica polimórfica do mesmo símbolo ou operador com
significados (formas) diferentes dependendo do contexto.

Por exemplo, o símbolo de mais (+) pode ser usado para adição matemática, bem como para de strings concatenação. Em
ambos os casos, apenas o contexto (ou seja, tipos de argumentos) determina a interpretação do símbolo:

```java
String str = "2" + 2;
int sum = 2 + 2;
System.out.

printf(" str = %s\n sum = %d\n",str, sum);
```

Saída:

```
str = 22
sum = 4
```

### 4.3. Parâmetros Polimórficos

O polimorfismo paramétrico permite que o nome de um parâmetro ou método em uma classe seja associado a diferentes tipos.
Temos abaixo um exemplo típico onde definimos content como String e posteriormente como Integer:

```java
public class TextFile extends GenericFile {
    private String content;

    public String setContentDelimiter() {
        int content = 100;
        this.content = this.content + content;
    }

}
```

Também é importante observar que a declaração de parâmetros polimórficos pode levar a um problema conhecido como
ocultação de variáveis, onde uma declaração local de um parâmetro sempre substitui a declaração global de outro
parâmetro com o mesmo nome.

Para resolver este problema, muitas vezes é aconselhável usar referências globais como esta palavra-chave para apontar
para variáveis globais dentro de um contexto local.

### 4.4. Subtipos Polimórficos

O subtipo polimórfico possibilita convenientemente atribuir vários subtipos a um tipo e esperar que todas as invocações
no tipo acionem as definições disponíveis no subtipo.

Por exemplo, se tivermos uma coleção de GenericFile se invocarmos o método getInfo() em cada um deles, podemos esperar
que a saída seja diferente dependendo do subtipo do qual cada item da coleção foi derivado:

```java
GenericFile[] files = {new ImageFile("SampleImageFile", 200, 100,
        new BufferedImage(100, 200, BufferedImage.TYPE_INT_RGB).toString()
                .getBytes(), "v1.0.0"), new TextFile("SampleTextFile",
        "This is a sample text content", "v1.0.0")};

for(
int i = 0;
i<files.length;i++){
files[i].

getInfo();
}
```

O polimorfismo de subtipo é possível por uma combinação de upcasting e ligação tardia. Upcasting envolve a conversão da
hierarquia de herança de um supertipo para um subtipo:

```java
ImageFile imageFile = new ImageFile();
GenericFile file = imageFile;
```

O efeito resultante do acima é que os métodos específicos de ImageFile não podem ser invocados no novo upcast
GenericFile. No entanto, os métodos no subtipo substituem métodos semelhantes definidos no supertipo.

Para resolver o problema de não ser possível invocar métodos específicos de subtipo ao fazer upcast para um supertipo,
podemos fazer um downcasting da herança de um supertipo para um subtipo. Isso é feito por:

```
ImageFile imageFile = (ImageFile) file;
```

A estratégia de ligação tardia ajuda o compilador a decidir qual método será acionado após o upcasting. No caso de i
mageFile#getInfo vs file#getInfo no exemplo acima, o compilador mantém uma referência ao ImageFile de método getInfo.

## 5. Problemas com polimorfismo

Vejamos algumas ambiguidades no polimorfismo que podem levar a erros de tempo de execução se não forem verificadas
adequadamente.

### 5.1. Identificação de tipo durante downcasting

Lembre-se de que anteriormente perdemos o acesso a alguns métodos específicos de subtipo após realizar um upcast. Embora
tenhamos conseguido resolver isso com downcast, isso não garante a verificação real do tipo.

Por exemplo, se realizarmos um upcast e subsequente downcast:

```java
GenericFile file = new GenericFile();
ImageFile imageFile = (ImageFile) file;
System.out.

println(imageFile.getHeight());
```

Notamos que o compilador permite um downcast de um GenericFile em um ImageFile, mesmo que a classe na verdade seja um
GenericFile e não um ImageFile.

Consequentemente, se tentarmos invocar o método getHeight() na classe imageFile, obteremos uma ClassCastException,
pois GenericFile não define o método getHeight():

```
Exception in thread "main" java.lang.ClassCastException:
GenericFile cannot be cast to ImageFile
```

Para resolver esse problema, a JVM executa uma verificação de informações de tipo de tempo de execução (RTTI). Também
podemos tentar uma identificação explícita do tipo usando a palavra-chave instanceof assim:

```java
ImageFile imageFile;
if(file instanceof ImageFile){
imageFile =file;
}
```

O acima ajuda a evitar uma exceção ClassCastException em tempo de execução. Outra opção que pode ser usada é agrupar o
elenco em um bloco try e catch e capturar ClassCastException.

Deve-se notar que a verificação do RTTI é cara devido ao tempo e aos recursos necessários para verificar efetivamente se
um tipo está correto. Além disso, o uso frequente da palavra-chave instanceof quase sempre implica um design ruim.

### 5.2. Problema de classe base frágil

De acordo com a Wikipedia, bases ou superclasses são consideradas frágeis se modificações aparentemente seguras em uma
classe base puderem causar mau funcionamento de classes derivadas.

Vamos considerar uma declaração de uma superclasse chamada GenericFile e sua subclasse TextFile:

```java
public class GenericFile {
    private String content;

    void writeContent(String content) {
        this.content = content;
    }

    void toString(String str) {
        str.toString();
    }

}
```

```java
public class TextFile extends GenericFile {
    @Override
    void writeContent(String content) {
        toString(content);
    }
}
```

Quando modificamos a GenericFile : classe

```java
public class GenericFile {
//...

    void toString(String str) {
        writeContent(str);
    }

}
```

Observamos que a modificação acima deixa TextFile em uma recursão infinita no método writeContent(), o que
eventualmente resulta em um estouro de pilha.

Para resolver um problema de classe base frágil, podemos usar a palavra-chave final para evitar que subclasses
substituam o método writeContent(). A documentação adequada também pode ajudar. E por último, mas não menos importante,
a composição geralmente deve ser preferida à herança.

6. Conclusão

Neste artigo, discutimos o conceito fundamental de polimorfismo, focando nas vantagens e desvantagens.

## **Polimorfismo em Java - Uma Introdução**

O polimorfismo é um dos quatro pilares da programação orientada a objetos (POO). Ele permite que objetos de diferentes
classes sejam tratados como objetos de uma mesma classe por meio de uma referência de tipo comum. Existem dois tipos
principais de polimorfismo em Java: polimorfismo de tempo de compilação (ou estático) e polimorfismo de tempo de
execução (ou dinâmico). Vamos explorar ambos.

### 1. **Polimorfismo de Tempo de Compilação (Estático):**

No polimorfismo de tempo de compilação, o tipo da referência é determinado durante a compilação. Isso significa que o
método chamado é decidido em tempo de compilação.

```java
class Animal {
    void som() {
        System.out.println("Som genérico de um animal.");
    }
}

class Cachorro extends Animal {
    void som() {
        System.out.println("Latido de cachorro.");
    }
}

class Gato extends Animal {
    void som() {
        System.out.println("Miado de gato.");
    }
}

public class Exemplo {
    public static void main(String[] args) {
        Animal meuAnimal1 = new Cachorro();
        Animal meuAnimal2 = new Gato();

        meuAnimal1.som(); // Latido de cachorro.
        meuAnimal2.som(); // Miado de gato.
    }
}
```

Neste exemplo, `meuAnimal1` e `meuAnimal2` são referências do tipo `Animal`, mas apontam para objetos de classes
diferentes (`Cachorro` e `Gato`). O método chamado é decidido em tempo de compilação com base no tipo da referência.

### 2. **Polimorfismo de Tempo de Execução (Dinâmico):**

No polimorfismo de tempo de execução, o tipo da referência é determinado durante a execução. Isso significa que o método
chamado é decidido em tempo de execução.

```java
class Animal {
    void som() {
        System.out.println("Som genérico de um animal.");
    }
}

class Cachorro extends Animal {
    void som() {
        System.out.println("Latido de cachorro.");
    }
}

class Gato extends Animal {
    void som() {
        System.out.println("Miado de gato.");
    }
}

public class OutroExemplo {
    public static void main(String[] args) {
        Animal meuAnimal = obterAnimal(); // Retorna um Cachorro ou Gato em tempo de execução.

        meuAnimal.som(); // O método chamado é decidido em tempo de execução.
    }

    static Animal obterAnimal() {
        return new Cachorro(); // Retorna um Cachorro em tempo de execução.
    }
}
```

Neste exemplo, o método `obterAnimal()` retorna um objeto de tipo `Cachorro` em tempo de execução. A
referência `meuAnimal` é do tipo `Animal`, mas aponta para um objeto de tipo `Cachorro`. O método chamado será o
método `som` da classe `Cachorro` em tempo de execução.

### Vantagens do Polimorfismo:

1. **Flexibilidade:** Permite tratar diferentes tipos de objetos de maneira uniforme.

2. **Facilita a Manutenção:** Se novas classes são adicionadas ao sistema, o código existente que usa polimorfismo não
   precisa ser alterado.

3. **Encapsulamento:** Ajuda a esconder a implementação específica e expõe apenas a interface comum.

O polimorfismo é uma poderosa técnica que contribui para a construção de sistemas flexíveis e extensíveis em Java.

# **Funcionamento do Polimorfismo em Java**

## 91 - Orientação Objetos - Polimorfismo pt 02 - Funcionamento[^03]

[^03]: Assita o vídeo no Youtube -> [91 - Orientação Objetos - Polimorfismo pt 02 - Funcionamento](https://abre.ai/hPqr)

O polimorfismo em Java permite que objetos de diferentes classes sejam tratados como objetos de uma mesma classe por
meio de uma referência de tipo comum. Ele é implementado por meio de dois conceitos principais: sobrescrita de métodos e
referências de tipo.

### 1. **Sobrescrita de Métodos:**

A sobrescrita de métodos é a capacidade de uma classe fornecer uma implementação específica para um método que é já
fornecido por uma de suas superclasses. Para isso, a classe derivada (subclasse) deve fornecer uma implementação
específica para o método que está sendo sobrescrito.

```java
class Animal {
    void fazerSom() {
        System.out.println("Som genérico de um animal.");
    }
}

class Cachorro extends Animal {
    void fazerSom() {
        System.out.println("Latido de cachorro.");
    }
}

class Gato extends Animal {
    void fazerSom() {
        System.out.println("Miado de gato.");
    }
}

public class ExemploPolimorfismo {
    public static void main(String[] args) {
        Animal meuAnimal1 = new Cachorro();
        Animal meuAnimal2 = new Gato();

        meuAnimal1.fazerSom(); // Latido de cachorro.
        meuAnimal2.fazerSom(); // Miado de gato.
    }
}
```

No exemplo acima, os métodos `fazerSom()` nas classes `Cachorro` e `Gato` estão sobrescrevendo o método homônimo na
classe `Animal`. Isso significa que, quando você chama `fazerSom()` usando uma referência de tipo `Animal`, o método
específico da classe real (Cachorro ou Gato) é executado.

### 2. **Referências de Tipo e Objetos Reais:**

O polimorfismo em Java também é possível devido à relação entre referências de tipo e objetos reais em tempo de
execução. Você pode ter uma referência de tipo de uma classe mais genérica apontando para um objeto de uma classe mais
específica.

```java
Animal meuAnimal = new Cachorro();
```

Neste exemplo, `meuAnimal` é uma referência de tipo `Animal`, mas aponta para um objeto real da classe `Cachorro`. Isso
significa que, em tempo de execução, os métodos chamados por meio de `meuAnimal` serão os métodos da classe `Cachorro`.

### 3. **Vantagens do Polimorfismo:**

- **Flexibilidade:** Permite que o mesmo código trabalhe com diferentes tipos de objetos.

- **Extensibilidade:** Facilita a adição de novas classes sem modificar o código existente.

- **Manutenção:** Facilita a manutenção do código, pois reduz a necessidade de alterações quando novas classes são
  introduzidas.

- **Encapsulamento:** Ajuda a esconder detalhes de implementação e expõe apenas a interface.

### 4. **Resumo do Funcionamento:**

1. **Decisão em Tempo de Execução:** O método específico a ser chamado é decidido em tempo de execução, com base no tipo
   real do objeto ao qual a referência está apontando.

2. **Vinculação Dinâmica:** A vinculação dinâmica é o mecanismo que permite que o método apropriado seja chamado durante
   a execução.

3. **Flexibilidade e Extensibilidade:** O polimorfismo fornece uma base sólida para criar sistemas flexíveis e
   extensíveis em Java.

# **Parâmetros polimórficos**

## 92 - Orientação Objetos - Polimorfismo pt 03 - Parâmetros polimórficos[^04]

[^04]: Assita o vídeo no
Youtube -> [92 - Orientação Objetos - Polimorfismo pt 03 - Parâmetros polimórficos](https://abre.ai/hPWj)

**Parâmetros Polimórficos em Java**

Os parâmetros polimórficos em Java referem-se à capacidade de aceitar diferentes tipos de objetos através de parâmetros
de método ou construtor. Isso é possível devido à hierarquia de classes e à capacidade de uma classe mais específica ser
tratada como sua classe base. Esse conceito é fundamental para o polimorfismo em programação orientada a objetos. Vamos
explorar como funciona.

### Exemplo Prático:

Vamos considerar uma hierarquia de classes simples com uma classe base `Animal` e duas classes derivadas `Cachorro`
e `Gato`. Cada uma dessas classes tem um método chamado `emitirSom()`.

```java
class Animal {
    void emitirSom() {
        System.out.println("Som genérico de um animal.");
    }
}

class Cachorro extends Animal {
    void emitirSom() {
        System.out.println("Latido de cachorro.");
    }
}

class Gato extends Animal {
    void emitirSom() {
        System.out.println("Miado de gato.");
    }
}
```

Agora, vamos criar uma classe que tem um método que aceita um parâmetro polimórfico:

```java
public class TestePolimorfismo {
    static void fazerBarulho(Animal animal) {
        animal.emitirSom();
    }

    public static void main(String[] args) {
        Animal meuAnimal = new Cachorro();
        fazerBarulho(meuAnimal);  // Saída: Latido de cachorro.

        meuAnimal = new Gato();
        fazerBarulho(meuAnimal);  // Saída: Miado de gato.
    }
}
```

No exemplo acima, `fazerBarulho` aceita um parâmetro do tipo `Animal`. No entanto, você pode passar instâncias
de `Cachorro` ou `Gato` para esse método, graças ao polimorfismo. Em tempo de execução, o método correto, correspondente
à classe real do objeto, é chamado.

### Vantagens dos Parâmetros Polimórficos:

1. **Flexibilidade:** Você pode usar métodos com parâmetros polimórficos para aceitar uma variedade de tipos de objetos.

2. **Manutenção Fácil:** Facilita a adição de novos tipos (classes) sem modificar métodos existentes.

3. **Reusabilidade:** Métodos que aceitam parâmetros polimórficos podem ser reutilizados para diferentes tipos de
   objetos.

### Considerações Importantes:

1. **Hierarquia de Classes:** Os tipos de objetos passados como parâmetros devem fazer parte da hierarquia de classes.

2. **Métodos Sobrescritos:** É preferível que os métodos chamados sejam sobrescritos nas classes envolvidas para
   garantir o comportamento desejado.

3. **Entendimento do Código:** O código pode se tornar mais abstrato, então é importante garantir que os desenvolvedores
   que interagem com o código compreendam a hierarquia de classes.

O uso de parâmetros polimórficos é uma prática comum em Java e em programação orientada a objetos em geral. Isso
contribui para criar código mais flexível e fácil de manter.