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