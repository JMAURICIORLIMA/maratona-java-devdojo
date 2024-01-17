# Tratamento de exceções em Java [^01]

[^01]: Acesse o site em inglês - Baeldung -> [Tratamento de exceções em Java](https://www.baeldung.com/java-exceptions)

## 95 - Exceções pt 01 - Errors[^02]

[^02]: Assita o vídeo no Youtube -> [95 - Exceções pt 01 - Errors](https://abre.ai/hSmz)

Em programação, exceções são eventos que ocorrem durante a
execução de um programa e que interrompem o fluxo normal de instruções. Em Java, as exceções são tratadas usando o
mecanismo de tratamento de exceções.

Aqui estão alguns conceitos importantes sobre exceções em Java:

1. **Tipos de Exceções:**
    - **Checked Exceptions:** São exceções que o compilador exige que você lide explicitamente, usando a
      cláusula `throws` ou tratando a exceção com `try-catch`. Exemplos incluem `IOException` e `SQLException`.
    - **Unchecked Exceptions (ou RuntimeExceptions):** São exceções que não precisam ser tratadas explicitamente.
      Exemplos incluem `NullPointerException` e `ArrayIndexOutOfBoundsException`.

2. **Blocos try-catch:**
    - O bloco `try` contém o código que pode gerar uma exceção.
    - O bloco `catch` contém o código que é executado quando uma exceção específica ocorre.

   Exemplo:
   ```java
   try {
       // Código que pode gerar uma exceção
   } catch (ExcecaoTipoA e) {
       // Tratamento para a exceção do tipo A
   } catch (ExcecaoTipoB e) {
       // Tratamento para a exceção do tipo B
   } finally {
       // Código que será executado independentemente de exceções
   }
   ```

3. **A cláusula `throws`:**
    - Se um método pode lançar uma exceção que não é tratada internamente, você deve declarar isso usando a
      cláusula `throws`.
   ```java
   void meuMetodo() throws MinhaExcecao {
       // Código que pode lançar MinhaExcecao
   }
   ```

4. **Exceções personalizadas:**
    - É possível criar suas próprias exceções personalizadas estendendo a classe `Exception` ou suas subclasses.

   Exemplo:
   ```java
   class MinhaExcecao extends Exception {
       // Construtores e métodos adicionais podem ser implementados aqui
   }
   ```

5. **Bloco `finally`:**
    - O bloco `finally` é usado para conter código que deve ser executado, independentemente de ocorrer ou não uma
      exceção no bloco `try`.

   Exemplo:
   ```java
   try {
       // Código que pode gerar uma exceção
   } finally {
       // Este bloco será sempre executado, mesmo que ocorra uma exceção
   }
   ```

6. **Múltiplos blocos catch:**
    - É possível ter vários blocos `catch` para lidar com diferentes tipos de exceções.

   Exemplo:
   ```java
   try {
       // Código que pode gerar exceções
   } catch (ExcecaoTipoA e) {
       // Tratamento para exceção do tipo A
   } catch (ExcecaoTipoB e) {
       // Tratamento para exceção do tipo B
   }
   ```

O tratamento de exceções em Java ajuda a escrever código mais robusto e a lidar com situações inesperadas de maneira
controlada.

**//--------------------------------------------------------------------------------------------------------------//**

# Error

Em Java, um `Error` é uma subclasse da classe `Throwable` e representa condições mais graves e irreversíveis do que
exceções. Erros geralmente indicam falhas no ambiente de execução ou problemas que normalmente não podem ser
recuperados. Ao contrário das exceções, os erros geralmente não devem ser tratados pelo código, pois representam
situações que estão fora do controle do programa.

Os erros são normalmente divididos em duas categorias principais:

1. **Erro de Tempo de Compilação (Compile-Time Error):**
    - Erros que ocorrem durante a compilação do código-fonte e impedem a geração do arquivo executável. Eles não são do
      tipo `Error` em tempo de execução, mas são erros de programação.
    - Exemplo: Erro de sintaxe, uso incorreto de tipos de dados, etc.

2. **Erro de Tempo de Execução (Runtime Error):**
    - Erros que ocorrem durante a execução do programa. Alguns destes são representados por objetos da classe `Error`.
    - Exemplo: `StackOverflowError` - ocorre quando a pilha de chamadas de métodos fica muito profunda, geralmente
      devido a uma recursão infinita.

Exemplo de um `StackOverflowError`:

```java
public class ExemploError {
    public static void main(String[] args) {
        // Este método chama a si mesmo recursivamente sem uma condição de parada
        chamaMetodoInfinitamente();
    }

    public static void chamaMetodoInfinitamente() {
        chamaMetodoInfinitamente();
    }
}
```

Neste exemplo, o método `chamaMetodoInfinitamente` chama a si mesmo recursivamente sem uma condição de parada. Isso
eventualmente leva a um estouro de pilha (`StackOverflowError`), que é uma condição irreversível e geralmente não pode
ser tratada de maneira eficaz no código.

Lembre-se de que, em geral, erros não são destinados a serem tratados no código Java regular. Eles indicam problemas
graves que podem não ter solução durante a execução normal do programa. O programador geralmente deve se concentrar em
corrigir esses problemas durante o desenvolvimento.

## 96 - Exceções pt 02 - RuntimeException[^03]

[^03]: Assita o vídeo no Youtube -> [96 - Exceções pt 02 - RuntimeException](https://abre.ai/hSLM)

Em Java, as exceções são eventos que ocorrem durante a execução de um programa e que podem ser tratados para evitar a
interrupção abrupta do programa. As exceções são objetos que pertencem à hierarquia de classes `Throwable`. Duas
categorias principais de exceções são as `Exception` e as `RuntimeException`.

1. **Exception:**
    - `Exception` é uma classe base para exceções que são esperadas e que podem ser tratadas pelo programa. As exceções
      dessa categoria são conhecidas como "checked exceptions".
    - Checked exceptions são aquelas que o compilador exige que sejam tratadas explicitamente, seja usando a
      cláusula `throws` na assinatura do método ou através de blocos `try-catch`.
    - Exemplos comuns incluem `IOException`, `SQLException` e `FileNotFoundException`.

   Exemplo de tratamento de uma `Exception`:

   ```java
   try {
       // Código que pode gerar uma checked exception
   } catch (IOException e) {
       // Tratamento específico para IOException
   } catch (SQLException e) {
       // Tratamento específico para SQLException
   }
   ```

2. **RuntimeException:**
    - `RuntimeException` é uma subclasse de `Exception` e representa exceções que geralmente indicam erros de
      programação. Essas exceções são conhecidas como "unchecked exceptions" ou "runtimes".
    - Ao contrário das checked exceptions, as unchecked exceptions não precisam ser tratadas explicitamente. O
      programador é encorajado a corrigir esses problemas durante o desenvolvimento.
    - Exemplos comuns incluem `NullPointerException`, `ArrayIndexOutOfBoundsException` e `ArithmeticException`.

   Exemplo de RuntimeException:

   ```java
   // Este código pode lançar uma ArithmeticException se o denominador for zero
   int resultado = numerador / denominador;
   ```

   Neste exemplo, se `denominador` for zero, uma `ArithmeticException` será lançada em tempo de execução.

Em resumo, a diferença principal entre `Exception` e `RuntimeException` está no tratamento. As `Exception` (checked) são
aquelas que o compilador exige que sejam tratadas explicitamente, enquanto as `RuntimeException` (unchecked) são
normalmente erros de programação que não exigem tratamento obrigatório. No entanto, ambas são subclasses de `Throwable`
e podem ser capturadas por blocos `try-catch` se necessário.

**//--------------------------------------------------------------------------------------------------------------//**

## 97 - Exceções pt 03 - Exception[^04]

[^04]: Assita o vídeo no Youtube -> [97 - Exceções pt 03 - Exception](https://abre.ai/hSMI)

Aprofundando um pouco mais sobre a classe `Exception` em Java. A classe `Exception` é a classe base para
exceções que são esperadas e podem ser tratadas durante a execução de um programa. Essas exceções são chamadas de "
checked exceptions". A ideia é que o programador deve antecipar essas exceções e lidar com elas de maneira adequada para
garantir que o programa seja robusto e capaz de lidar com situações excepcionais.

A hierarquia de classes relacionadas a `Exception` inclui várias subclasses que representam diferentes tipos de
situações de erro. Algumas delas incluem:

1. **IOException:**
    - Esta exceção é geralmente lançada quando ocorre um problema de entrada/saída, como falha ao ler ou gravar em um
      arquivo.
   ```java
   try {
       // Código que pode gerar uma IOException
   } catch (IOException e) {
       // Tratamento específico para IOException
   }
   ```

2. **SQLException:**
    - Esta exceção é lançada quando ocorre um problema ao acessar um banco de dados usando JDBC.
   ```java
   try {
       // Código que pode gerar uma SQLException
   } catch (SQLException e) {
       // Tratamento específico para SQLException
   }
   ```

3. **FileNotFoundException:**
    - Lançada quando um arquivo que o programa tenta acessar não é encontrado.
   ```java
   try {
       // Código que pode gerar uma FileNotFoundException
   } catch (FileNotFoundException e) {
       // Tratamento específico para FileNotFoundException
   }
   ```

4. **InterruptedException:**
    - Lançada quando uma thread é interrompida enquanto está em um estado de espera (bloqueada).
   ```java
   try {
       // Código que pode gerar uma InterruptedException
   } catch (InterruptedException e) {
       // Tratamento específico para InterruptedException
   }
   ```

É importante notar que, ao usar exceções, o programador tem a oportunidade de lidar com falhas de maneira adequada, seja
corrigindo o problema ou informando ao usuário sobre a situação excepcional. A declaração `throws` é usada para indicar
que um método pode lançar uma checked exception, enquanto `try-catch` é usado para capturar e tratar essas exceções.

```java
void meuMetodo() throws IOException {
    // Código que pode gerar uma IOException
}
```

```java
try{
        // Código que pode gerar uma IOException
        }catch(IOException e){
        // Tratamento específico para IOException
        }
```

Em resumo, `Exception` e suas subclasses fornecem uma estrutura para lidar com situações excepcionais que podem ocorrer
durante a execução de um programa, permitindo um melhor controle sobre o fluxo do programa e uma resposta mais adequada
a condições inesperadas.

**//--------------------------------------------------------------------------------------------------------------//**

## 98 - Exceções pt 04 - Lançando exceção unchecked[^05]

[^05]: Assita o vídeo no Youtube -> [98 - Exceções pt 04 - Lançando exceção unchecked](https://abre.ai/hSNA)

Em Java, as exceções unchecked são representadas por subclasses de `RuntimeException` e suas subclasses. Diferentemente
das exceções checked, as exceções unchecked não precisam ser declaradas explicitamente no método com `throws` ou
tratadas com blocos `try-catch`. Isso significa que o compilador não força o programador a lidar explicitamente com
essas exceções.

Alguns exemplos comuns de exceções unchecked incluem:

1. **NullPointerException:**
    - Ocorre quando um programa tenta acessar um membro de um objeto que possui valor `null`.
   ```java
   String texto = null;
   int comprimento = texto.length(); // Isso lançará NullPointerException
   ```

2. **ArrayIndexOutOfBoundsException:**
    - Lançada quando um programa tenta acessar um índice inválido em um array.
   ```java
   int[] numeros = {1, 2, 3};
   int valor = numeros[4]; // Isso lançará ArrayIndexOutOfBoundsException
   ```

3. **ArithmeticException:**
    - Ocorre em operações aritméticas, como divisão por zero.
   ```java
   int resultado = 10 / 0; // Isso lançará ArithmeticException
   ```

4. **ClassCastException:**
    - Lançada quando ocorre uma tentativa de converter um objeto para um tipo incompatível.
   ```java
   Object obj = "Hello";
   Integer numero = (Integer) obj; // Isso lançará ClassCastException
   ```

5. **IllegalArgumentException:**
    - Ocorre quando um método recebe um argumento inválido.
   ```java
   public void setValor(int valor) {
       if (valor < 0) {
           throw new IllegalArgumentException("O valor não pode ser negativo.");
       }
       // Restante do código...
   }
   ```

6. **RuntimeException:**
    - Uma exceção genérica que pode ser usada quando uma situação excepcional não se encaixa em uma categoria mais
      específica.

As exceções unchecked geralmente indicam erros de programação ou condições que são difíceis de antecipar durante o
desenvolvimento. Embora não seja obrigatório tratá-las explicitamente, é uma boa prática lidar com essas exceções sempre
que possível para garantir a robustez do código e fornecer informações úteis em caso de falha.

```java
public void meuMetodo(int divisor) {
    if (divisor == 0) {
        throw new ArithmeticException("Divisão por zero não é permitida.");
    }
    // Restante do código...
}
```

Lançar exceções unchecked é uma maneira de indicar que algo está fundamentalmente errado com a lógica do programa e que
uma correção é necessária.

**//--------------------------------------------------------------------------------------------------------------//**

## 99 - Exceções pt 05 - Lançando exceção checked[^06]

[^06]: Assita o vídeo no Youtube -> [99 - Exceções pt 05 - Lançando exceção checked](https://abre.ai/hYOO)

Quando você está criando um método que pode lançar exceções checked, você precisa informar isso na assinatura do método
usando a palavra-chave `throws`. Isso alerta o compilador de que o método pode gerar exceções específicas e que quem
chama esse método deve lidar com essas exceções.

Aqui está um exemplo de como criar um método que lança uma exceção checked:

```java
import java.io.FileNotFoundException;

public class ExemploMetodoChecked {

    // Este método lança uma exceção checked (FileNotFoundException)
    public void lerArquivo(String nomeArquivo) throws FileNotFoundException {
        // Código para ler o arquivo
        // Se o arquivo não for encontrado, lança uma exceção
        throw new FileNotFoundException("Arquivo não encontrado: " + nomeArquivo);
    }
}
```

Agora, ao chamar esse método, quem o chama precisa lidar com a exceção ou propagá-la para cima na cadeia de chamadas
usando a palavra-chave `throws`.

```java
public class ExemploChamadaMetodo {

    public static void main(String[] args) {
        ExemploMetodoChecked exemplo = new ExemploMetodoChecked();

        // Tentando chamar o método que lança uma exceção checked
        try {
            exemplo.lerArquivo("arquivo.txt");
        } catch (FileNotFoundException e) {
            // Tratamento específico para FileNotFoundException
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
```

Neste exemplo, o método `lerArquivo` é chamado e, como ele pode lançar `FileNotFoundException`, a chamada do método está
envolta em um bloco `try-catch` que trata essa exceção específica.

Alternativamente, se você não deseja tratar a exceção no local, você pode propagá-la usando a palavra-chave `throws`.
Isso significa que o método chamador também precisa lidar com essa exceção ou propagá-la ainda mais.

```java
public class ExemploChamadaMetodoSemTratamento {

    public static void main(String[] args) throws FileNotFoundException {
        ExemploMetodoChecked exemplo = new ExemploMetodoChecked();

        // Chamando o método sem tratamento local
        exemplo.lerArquivo("arquivo.txt");
    }
}
```

Neste caso, a exceção é propagada para o método chamador (`main` neste exemplo), e agora quem chama `main` também
precisa lidar com essa exceção ou propagá-la ainda mais.

O tratamento de exceções checked é uma parte importante da construção de software robusto em Java. Certifique-se de
entender os tipos de exceções que um método pode lançar, para que você possa tomar as medidas adequadas ao chamá-lo.
Isso geralmente envolve ou tratamento local (`try-catch`) ou propagação da exceção usando `throws`.

**//--------------------------------------------------------------------------------------------------------------//**

## 100 - Exceções pt 06 - Bloco finally[^07]

[^07]: Assita o vídeo no Youtube -> [100 - Exceções pt 06 - Bloco Finally](https://abre.ai/hZm9)

O bloco `finally` em Java é usado para conter código que deve ser executado independentemente de ocorrer ou não uma
exceção dentro de um bloco `try`. O código dentro do bloco `finally` será sempre executado, mesmo que uma exceção tenha
sido lançada e capturada ou se o bloco `try` foi executado sem problemas.

A estrutura básica de um bloco `try` com `catch` e `finally` é a seguinte:

```java
try{
        // Código que pode gerar uma exceção
        }catch(TipoDeExcecao1 e){
        // Tratamento para TipoDeExcecao1
        }catch(
TipoDeExcecao2 e){
        // Tratamento para TipoDeExcecao2
        }finally{
        // Código que será executado independentemente de exceções
        }
```

Aqui estão alguns pontos importantes sobre o bloco `finally`:

1. **Execução Garantida:**
    - O código dentro do bloco `finally` será executado, independentemente de ocorrer uma exceção ou não.

2. **Uso para Liberação de Recursos:**
    - É comum usar o bloco `finally` para liberar recursos que foram adquiridos no bloco `try`. Por exemplo, fechar um
      arquivo, conexão com banco de dados ou liberar outros recursos.

3. **Código Limpo:**
    - O bloco `finally` ajuda a manter o código limpo, movendo lógica de limpeza ou liberação de recursos para um local
      centralizado.

Aqui está um exemplo que ilustra o uso do bloco `finally` para liberar recursos:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploFinally {

    public static void main(String[] args) {
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader("arquivo.txt"));
            // Código para ler o arquivo
            System.out.println(leitor.readLine());
        } catch (IOException e) {
            System.err.println("Erro de leitura: " + e.getMessage());
        } finally {
            try {
                // Fechar o BufferedReader no bloco finally
                if (leitor != null) {
                    leitor.close();
                }
            } catch (IOException e) {
                System.err.println("Erro ao fechar o leitor: " + e.getMessage());
            }
        }
    }
}
```

Neste exemplo, o bloco `finally` é usado para garantir que o `BufferedReader` seja fechado, independentemente de ocorrer
uma exceção ou não durante a leitura do arquivo. Isso ajuda a evitar vazamentos de recursos.

Ao utilizar o bloco `finally`, você assegura que determinadas ações de limpeza ou liberação de recursos serão
realizadas, contribuindo para um código mais robusto e confiável.

**//--------------------------------------------------------------------------------------------------------------//**

## 101 - Exceções pt 07 - Capturando múltiplas exceções[^08]

[^08]: Assita o vídeo no Youtube -> [101 - Exceções pt 07 - Capturando múltiplas exceções](https://abre.ai/hZzf)

A captura de múltiplas exceções em Java permite que você lide com diferentes tipos de exceções de maneira específica em
um único bloco `catch`. Isso é útil quando você deseja tratar várias exceções de maneira semelhante ou quando deseja
fornecer tratamentos específicos para diferentes tipos de exceções.

A sintaxe básica para capturar múltiplas exceções é usar vários blocos `catch` após um bloco `try`. Cada bloco `catch`
trata uma exceção específica. Aqui está um exemplo simples:

```java
try{
        // Código que pode gerar exceções
        }catch(TipoDeExcecao1 e){
        // Tratamento específico para TipoDeExcecao1
        }catch(
TipoDeExcecao2 e){
        // Tratamento específico para TipoDeExcecao2
        }catch(
TipoDeExcecao3 e){
        // Tratamento específico para TipoDeExcecao3
        }catch(
Exception e){
        // Tratamento para outras exceções
        }
```

Neste exemplo, o bloco `try` contém código que pode gerar diferentes tipos de exceções. Cada bloco `catch` é responsável
por lidar com um tipo específico de exceção. O último bloco `catch` com `Exception` é opcional e captura exceções que
não são especificamente tratadas pelos blocos anteriores.

A ordem dos blocos `catch` é importante, pois Java verifica cada bloco na ordem em que aparecem e executa o primeiro
bloco que corresponde à exceção lançada.

Aqui estão algumas considerações sobre a captura de múltiplas exceções:

1. **Ordem de Blocos Catch:**
    - Coloque blocos `catch` para exceções mais específicas antes dos blocos para exceções mais genéricas. Isso evita
      que exceções mais específicas sejam capturadas por blocos mais genéricos.

2. **Evite Ambiguidades:**
    - Evite blocos `catch` que podem capturar exceções ambíguas. Se possível, organize os blocos de maneira que cada
      exceção seja tratada em apenas um bloco.

Aqui está um exemplo mais prático:

```java
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExemploCapturaMultipla {

    public static void main(String[] args) {
        try {
            // Código que pode gerar exceções
            lerArquivo("arquivo.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de leitura: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exceção geral: " + e.getMessage());
        }
    }

    public static void lerArquivo(String nomeArquivo) throws IOException {
        // Código para ler o arquivo
        throw new IOException("Erro de leitura no arquivo: " + nomeArquivo);
    }
}
```

Neste exemplo, o método `lerArquivo` pode lançar uma `FileNotFoundException` ou uma `IOException`. O bloco `catch`
específico para `FileNotFoundException` é colocado antes do bloco `catch` mais genérico para `IOException`. Isso garante
que o tratamento específico seja realizado antes do tratamento mais genérico.

Em resumo, a captura de múltiplas exceções em Java oferece flexibilidade ao tratar diferentes tipos de exceções de
maneira específica. Use essa abordagem quando precisar fornecer tratamentos específicos para diferentes tipos de
exceções ou quando desejar consolidar o tratamento de exceções em um único local.

**//--------------------------------------------------------------------------------------------------------------//**

## 102 - Exceções pt 08 - Multi catch em linha[^09]

[^09]: Assita o vídeo no Youtube -> [102 - Exceções pt 08 - Multi catch em linha](https://abre.ai/hZDC)

O multi-catch em Java é uma funcionalidade que permite capturar várias exceções em um único bloco `catch`. Isso pode
tornar o código mais conciso e legível quando você deseja aplicar o mesmo tratamento a várias exceções. A sintaxe básica
é colocar os tipos de exceção desejados entre parênteses, separados por barras verticais (`|`).

Aqui está um exemplo básico de multi-catch:

```java
try{
        // Código que pode gerar exceções
        }catch(TipoDeExcecao1 |TipoDeExcecao2 |
TipoDeExcecao3 e){
        // Tratamento para TipoDeExcecao1, TipoDeExcecao2 ou TipoDeExcecao3
        }
```

Aqui está um exemplo mais prático:

```java
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExemploMultiCatch {

    public static void main(String[] args) {
        try {
            // Código que pode gerar exceções
            lerArquivo("arquivo.txt");
        } catch (FileNotFoundException | IOException e) {
            System.err.println("Erro de leitura: " + e.getMessage());
        }
    }

    public static void lerArquivo(String nomeArquivo) throws IOException {
        // Código para ler o arquivo
        throw new IOException("Erro de leitura no arquivo: " + nomeArquivo);
    }
}
```

Neste exemplo, o bloco `catch` utiliza o multi-catch para tratar tanto `FileNotFoundException` quanto `IOException`. Se
uma dessas exceções ocorrer, o bloco `catch` será executado, e o tratamento específico será aplicado.

### Quando Usar o Multi-Catch:

1. **Tratamento Simples:**
    - Use o multi-catch quando o tratamento para várias exceções é o mesmo.

2. **Redução de Código Repetitivo:**
    - Se diferentes exceções exigirem o mesmo tratamento, o uso de multi-catch pode reduzir a duplicação de código.

3. **Melhoria na Legibilidade:**
    - O uso de multi-catch pode tornar o código mais conciso e legível, especialmente quando várias exceções têm
      tratamento semelhante.

### Cuidados e Limitações:

1. **Ordem dos Tipos de Exceção:**
    - A ordem dos tipos de exceção é importante. Java verifica os tipos na ordem em que aparecem e executa o
      bloco `catch` do primeiro tipo correspondente encontrado.

2. **Exceções Relacionadas:**
    - Use multi-catch quando as exceções são de tipos relacionados ou subclasses entre si. Não é permitido misturar
      tipos de exceção não relacionados.

3. **Variáveis Final:**
    - A variável no bloco `catch` é efetivamente final. Isso significa que você não pode modificar seu valor dentro do
      bloco `catch`.

Em geral, o multi-catch é uma ferramenta útil quando você deseja simplificar o tratamento de exceções, proporcionando um
código mais limpo e claro. Use-o com cuidado, considerando a relação entre as exceções que você está tratando. Se
diferentes exceções exigirem tratamento específico, ainda pode ser apropriado usar blocos `catch` separados.

**//--------------------------------------------------------------------------------------------------------------//**

## 103 - Exceções pt 09 - Try with resources[^10]

[^10]: Assita o vídeo no Youtube -> [Exceções pt 09 - Try with resources](https://abre.ai/hZGq)

O bloco "try-with-resources" em Java é uma construção que simplifica o código ao lidar com recursos que precisam ser
fechados explicitamente, como arquivos, sockets ou conexões com bancos de dados. Essa construção introduz o conceito
de "resources" que implementa a interface `AutoCloseable` ou `Closeable`. O Java se encarregará automaticamente de
fechar esses recursos, eliminando a necessidade de bloco `finally` para liberar recursos manualmente.

Aqui está a sintaxe básica do bloco "try-with-resources":

```java
try(Recurso1 recurso1 = new Recurso1();
Recurso2 recurso2 = new Recurso2()){
        // Código que utiliza os recursos
        }catch(
TipoDeExcecao1 e1){
        // Tratamento para TipoDeExcecao1
        }catch(
TipoDeExcecao2 e2){
        // Tratamento para TipoDeExcecao2
        }
```

Aqui estão alguns pontos importantes sobre o "try-with-resources":

1. **Recursos AutoCloseable:**
    - Os recursos utilizados no "try-with-resources" devem implementar a interface `AutoCloseable` ou `Closeable`.

2. **Fechamento Automático:**
    - Os recursos declarados no bloco "try-with-resources" são automaticamente fechados após a conclusão do bloco, seja
      por término normal ou por exceção.

3. **Ordem de Fechamento:**
    - Os recursos são fechados na ordem inversa da sua declaração. O último recurso declarado é fechado primeiro.

4. **Sem Necessidade de Bloco Finally:**
    - Não é necessário um bloco `finally` para fechar explicitamente os recursos. Isso reduz a quantidade de código e
      torna o código mais legível.

### Exemplo de "try-with-resources":

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploTryWithResources {

    public static void main(String[] args) {
        // Usando try-with-resources para ler um arquivo
        try (BufferedReader leitor = new BufferedReader(new FileReader("arquivo.txt"))) {
            // Código para ler o arquivo
            System.out.println(leitor.readLine());
        } catch (IOException e) {
            // Tratamento para exceção de leitura
            System.err.println("Erro de leitura: " + e.getMessage());
        }
    }
}
```

Neste exemplo, a classe `BufferedReader` e o `FileReader` são recursos que implementam a interface `AutoCloseable`. O
bloco "try-with-resources" garante que esses recursos sejam fechados automaticamente após a conclusão do bloco.

### Quando Usar o "try-with-resources":

1. **Leitura ou Gravação de Arquivos:**
    - Use "try-with-resources" ao ler ou gravar arquivos para garantir que os recursos associados aos arquivos sejam
      fechados corretamente.

2. **Operações com Banco de Dados:**
    - Use-o ao trabalhar com conexões de banco de dados para garantir que as conexões sejam fechadas automaticamente.

3. **Operações de Rede:**
    - Ao realizar operações de rede, como abrir e fechar sockets, use "try-with-resources" para garantir que os recursos
      sejam liberados corretamente.

### Quando Não Usar o "try-with-resources":

1. **Recursos Não Implementam AutoCloseable:**
    - Não use "try-with-resources" se o recurso que você está usando não implementar a interface `AutoCloseable`
      ou `Closeable`.

2. **Lógica Personalizada de Fechamento:**
    - Se você precisar de lógica personalizada para o fechamento de recursos que não seja simplesmente chamar `close()`,
      o "try-with-resources" pode não ser adequado.

Em resumo, use "try-with-resources" sempre que estiver trabalhando com recursos que implementam `AutoCloseable`
ou `Closeable`. Isso ajuda a garantir que os recursos sejam fechados corretamente, simplificando seu código e tornando-o
mais seguro. Evite seu uso apenas quando os recursos não implementam essas interfaces ou quando você precisa de lógica
personalizada de fechamento.

**//--------------------------------------------------------------------------------------------------------------//**

## 104 - Exceções pt 10 - Exceção customizada[^10]

[^10]: Assita o vídeo no Youtube -> [104 - Exceções pt 10 - Exceção customizada](https://abre.ai/hZJr)

Uma exceção customizada, também conhecida como exceção personalizada ou exceção definida pelo usuário, é uma classe de
exceção criada pelo desenvolvedor para representar condições específicas em seu programa. Essas exceções são úteis
quando você deseja sinalizar erros ou situações excepcionais que são específicos da lógica do seu aplicativo.

### Como Criar uma Exceção Customizada:

1. **Estenda uma Classe de Exceção:**
    - Crie uma classe que estenda `Exception` ou uma de suas subclasses, como `RuntimeException` se você deseja criar
      uma exceção unchecked.

2. **Construtor Personalizado:**
    - Adicione um construtor que permite passar informações adicionais para a exceção, como uma mensagem de erro
      personalizada.

Aqui está um exemplo simples de uma exceção customizada:

```java
public class MinhaExcecao extends Exception {

    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}
```

### Exemplo de Uso da Exceção Customizada:

```java
public class ExemploExcecaoCustomizada {

    public static void main(String[] args) {
        try {
            validarNumero(5);
            validarNumero(-2); // Isso lançará a exceção customizada
        } catch (MinhaExcecao e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static void validarNumero(int numero) throws MinhaExcecao {
        if (numero < 0) {
            throw new MinhaExcecao("Número não pode ser negativo.");
        }
        // Lógica adicional...
    }
}
```

Neste exemplo, a exceção customizada `MinhaExcecao` é lançada quando o método `validarNumero` recebe um número negativo.
A mensagem personalizada da exceção é então capturada e impressa no bloco `catch` do método `main`.

### Quando Usar Exceções Customizadas:

1. **Casos Específicos:**
    - Use exceções customizadas quando você precisa representar situações excepcionais específicas que não são bem
      representadas por exceções existentes.

2. **Mensagens Descritivas:**
    - Utilize exceções customizadas para fornecer mensagens de erro detalhadas e descritivas que ajudem na depuração e
      no entendimento dos problemas.

3. **Hierarquia de Exceções:**
    - Crie uma hierarquia de exceções customizadas se você tiver várias condições excepcionais específicas no seu
      programa.

### Quando Não Usar Exceções Customizadas:

1. **Complexidade Excessiva:**
    - Evite criar exceções customizadas desnecessárias se a lógica do seu programa puder ser tratada de maneira mais
      simples e direta sem o uso delas.

2. **Reutilização de Exceções Padrão:**
    - Em alguns casos, pode ser mais apropriado reutilizar exceções padrão do Java e fornecer informações adicionais por
      meio de mensagens ou métodos de acesso.

3. **Pouco Valor Adicional:**
    - Não crie exceções customizadas se elas não adicionarem valor significativo à clareza e manutenção do seu código.

Ao criar exceções customizadas, é importante equilibrar a granularidade das exceções com a simplicidade e clareza do
código. Use-as quando realmente adicionarem valor e expressividade ao seu código.