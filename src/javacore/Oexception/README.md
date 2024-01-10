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