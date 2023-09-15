# Maratona Java 39 - Orientação Objetos pt 01 - Introdução classes pt 01

### Qual a função da Orientação a Objeto?
R - Mapear o mundo real para o mundo computacional.
* Partindo de um princípio que as coisas podem ser agrapadas.

Uma representação Básica:

> | Estudante |
> | - |
> | nome |
> | idade |
> | Sexo |

* O exemplo mostrado acima, é representado como uma **Classe**.
* Classe é composta por `atributos`(**características**) e `métodos`(**ações**).
* Todo objeto é criado a partir de uma classe.
* Para criar um objeto:

Para criar um objeto a partir de uma classe chamada `Estudante` com os atributos `nome`, `idade` e `sexo`, siga este
passo a passo:

1. **Defina a Classe `Estudante`**:

   Primeiro, crie a classe `Estudante` com os atributos desejados. Certifique-se de que seus atributos são definidos
como `public` se você planeja acessá-los diretamente fora da classe.

   ```java
   public class Estudante {
       public String nome;
       public int idade;
       public char sexo;
   }
   ```

2. **Crie um Objeto `Estudante`**:

   Em sua classe principal (ou em qualquer lugar onde você deseje criar um objeto `Estudante`), siga estas etapas:

   ```java
   // Importe a classe Estudante se ela estiver em um pacote diferente
   // import pacote.Estudante;

   public class EstudanteTeste01 {
       public static void main(String[] args) {
           // Crie um novo objeto Estudante
           Estudante estudante = new Estudante();

           // Atribua valores aos atributos do estudante
           estudante.nome = "Alice";
           estudante.idade = 20;
           estudante.sexo = 'F';

           // Você agora tem um objeto Estudante com os atributos definidos
           // Acessando os atributos do objeto
           System.out.println("Nome: " + estudante.nome);
           System.out.println("Idade: " + estudante.idade);
           System.out.println("Sexo: " + estudante.sexo);
       }
   }
   ```

   Neste exemplo, criamos um objeto `estudante1` da classe `Estudante` e definimos os valores dos atributos `nome`,
`idade` e `sexo` usando o operador de ponto (`.`). Em seguida, imprimimos esses valores na saída.

Este é um exemplo simples de como criar um objeto a partir de uma classe com atributos públicos. Lembre-se de que, em
práticas de programação mais seguras, é comum definir os atributos como `private` e fornecer métodos públicos (getters
e setters) para acessá-los e modificá-los, em vez de acessá-los diretamente. Isso ajuda a encapsular os dados e torna o
código mais robusto.

[Maratona Java 39 - Orientação Objetos pt 01 - Introdução classes pt 01](https://www.youtube.com/watch?v=EyuPFLuvD7Q&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW&index=41)