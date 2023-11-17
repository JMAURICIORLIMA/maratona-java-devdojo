# Orientação Objetos - Modificador Static

61 - Orientação Objetos - Modificador Static [^01]

[^01]: Acesso o vídeo YouTube ->  [61 - Orientação Objetos - Modificador Static](https://abre.ai/hjy7)

O modificador `static` em Java é usado para criar membros de classe, o que significa que eles pertencem à classe em vez
de a instâncias individuais da classe. Vamos explorar como o modificador `static` pode ser aplicado a diferentes
contextos em Java:

1. **Variáveis Estáticas (Static Variables):**
    - **Sintaxe:** `static tipo nome;`
    - **Descrição:** Uma variável estática pertence à classe e não a instâncias individuais dessa classe. Todas as
      instâncias compartilham a mesma variável estática.
    - **Exemplo:**
      ```java
      class Exemplo {
          static int contador = 0;
      }
      ```
    - **Uso:**
      ```java
      Exemplo obj1 = new Exemplo();
      Exemplo obj2 = new Exemplo();
      obj1.contador++;  // Acessado através da instância obj1
      System.out.println(obj2.contador);  // Acessado através da instância obj2
      ```

2. **Métodos Estáticos (Static Methods):**
    - **Sintaxe:** `static tipo nome() { ... }`
    - **Descrição:** Um método estático pertence à classe e não precisa de uma instância da classe para ser chamado. Ele
      pode ser chamado usando o nome da classe.
    - **Exemplo:**
      ```java
      class Exemplo {
          static void imprimirMensagem() {
              System.out.println("Isso é um método estático!");
          }
      }
      ```
    - **Uso:**
      ```java
      Exemplo.imprimirMensagem();  // Chamando o método estático diretamente pela classe
      ```

3. **Bloco Estático (Static Block):**
    - **Sintaxe:** `static { ... }`
    - **Descrição:** Um bloco estático é usado para inicializar variáveis estáticas. Ele é executado quando a classe é
      carregada.
    - **Exemplo:**
      ```java
      class Exemplo {
          static int valor;
 
          static {
              valor = 42;
          }
      }
      ```
    - **Uso:**
      ```java
      System.out.println(Exemplo.valor);  // Imprime 42, pois o bloco estático já foi executado
      ```

4. **Classe Estática Interna (Static Nested Class):**
    - **Sintaxe:** `static class Nome { ... }`
    - **Descrição:** Uma classe estática interna é uma classe que está aninhada em outra classe, mas marcada como
      estática. Ela pode ser acessada sem criar uma instância da classe externa.
    - **Exemplo:**
      ```java
      class Externa {
          static class Interna {
              // ...
          }
      }
      ```
    - **Uso:**
      ```java
      Externa.Interna objeto = new Externa.Interna();
      ```

O uso do `static` é uma parte fundamental do design de classes em Java e é frequentemente utilizado para membros ou
métodos que devem ser compartilhados por todas as instâncias da classe.

62 - Orientação Objetos - Métodos Static [^02]

[^02]: Acesso o vídeo YouTube ->  [62 - Orientação Objetos - Métodos estáticos](https://abre.ai/hjXy)

**Métodos Estáticos em Java: Definição e Exemplos**

Em Java, um método estático é um método que pertence à classe e não a uma instância específica dessa classe. Isso
significa que você pode chamar um método estático sem criar uma instância da classe. Aqui estão a definição e alguns
exemplos de métodos estáticos:

### Definição:

```java
public class Exemplo {
    static tipo retorno

    nome(parametros) {
        // corpo do método
    }
}
```

### Exemplos:

1. **Método Estático Simples:**

   ```java
   public class Matematica {
       // Método estático que retorna o dobro de um número
       static int dobro(int numero) {
           return numero * 2;
       }
   }
   ```

   Uso:

   ```java
   int resultado = Matematica.dobro(5);
   ```

2. **Método Estático com Chamada de Outro Método Estático:**

   ```java
   public class Util {
       // Método estático que retorna o quadrado de um número
       static int quadrado(int numero) {
           return numero * numero;
       }

       // Método estático que retorna o dobro do quadrado de um número
       static int dobroDoQuadrado(int numero) {
           int quadrado = quadrado(numero);
           return quadrado * 2;
       }
   }
   ```

   Uso:

   ```java
   int resultado = Util.dobroDoQuadrado(3);
   ```

3. **Método Estático em uma Classe com Método de Instância:**

   ```java
   public class Exemplo {
       // Método estático que retorna a soma de dois números
       static int somar(int a, int b) {
           return a + b;
       }

       // Método de instância que retorna o produto de dois números
       int multiplicar(int a, int b) {
           return a * b;
       }
   }
   ```

   Uso:

   ```java
   int resultado1 = Exemplo.somar(2, 3);  // Chamando método estático
   Exemplo obj = new Exemplo();
   int resultado2 = obj.multiplicar(2, 3);  // Chamando método de instância
   ```

Os métodos estáticos são úteis quando a lógica do método não depende do estado de uma instância específica da classe,
mas sim de parâmetros passados ou de variáveis estáticas da própria classe. Eles são chamados diretamente usando o nome
da classe, sem a necessidade de criar um objeto da classe.

#

63 - Orientação Objetos - Bloco de inicialização estático [^03]

[^03]: Acesso o vídeo YouTube ->  [63 - Orientação Objetos - Bloco de inicialização estático](https://abre.ai/hj8I)

Em Java, um bloco de inicialização estático é um bloco de código usado para inicializar variáveis estáticas de uma
classe. Este bloco é executado quando a classe é carregada na memória. Vamos ver um exemplo:

```java
public class Exemplo {
    // Variável estática
    static int valorEstatico;

    // Bloco de inicialização estático
    static {
        // Lógica de inicialização
        valorEstatico = 42;
        System.out.println("Bloco de inicialização estático executado.");
    }

    // Outros membros da classe...
}
```

Neste exemplo, `valorEstatico` é uma variável estática e o bloco de inicialização estático é usado para inicializá-la. O
bloco estático será executado assim que a classe for carregada, e a mensagem "Bloco de inicialização estático
executado." será impressa.

Principais características do bloco de inicialização estático:

1. **Execução Única:** O bloco de inicialização estático é executado apenas uma vez quando a classe é carregada.

2. **Inicialização de Variáveis Estáticas:** É comumente usado para inicializar variáveis estáticas, embora também possa
   conter outras lógicas de inicialização.

3. **Sintaxe:** Usa a palavra-chave `static` seguida por chaves `{}` que contêm o código a ser executado.

Exemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        // A classe é carregada quando referenciamos algo estático
        System.out.println("Valor estático: " + Exemplo.valorEstatico);

        // Saída:
        // Bloco de inicialização estático executado.
        // Valor estático: 42
    }
}
```

Note que o bloco de inicialização estático é executado antes de qualquer outra parte da classe quando ela é carregada,
garantindo que a inicialização ocorra antes do acesso a qualquer membro estático da classe.