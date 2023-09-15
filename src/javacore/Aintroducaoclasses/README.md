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

> [Maratona Java 39 - Orientação Objetos pt 01 - Introdução classes pt 01](https://www.youtube.com/watch?v=EyuPFLuvD7Q&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW&index=41)

# Maratona Java 40 - Orientação Objetos - Introdução classes pt 02



Variáveis de referência e valores padrão de inicialização são conceitos importantes em Java e têm relação com a criação
e uso de objetos. Vou explicar esses conceitos usando a classe `Estudante` como exemplo.

**Variáveis de Referência**:

Em Java, uma variável de referência é uma variável que armazena uma referência a um objeto em vez de armazenar
diretamente o objeto em si. Quando você cria um objeto, na verdade está criando-o na memória e a variável de referência
guarda o endereço de memória onde esse objeto está localizado.

No contexto da classe `Estudante`, suponha que você declare uma variável de referência para um objeto `Estudante`:

```java
Estudante estudante1;
```

Neste momento, `estudante1` é apenas uma variável de referência que ainda não aponta para nenhum objeto. Ela está vazia
(ou "nula" em Java).

**Valores Padrão de Inicialização**:

Em Java, todas as variáveis têm valores padrão de inicialização, a menos que você atribua um valor a elas
explicitamente. O valor padrão depende do tipo da variável:

- Para variáveis de referência (como `estudante1`), o valor padrão é `null`, o que significa que a variável não faz
- referência a nenhum objeto.

- Para variáveis numéricas (como `int`, `double`, etc.), o valor padrão é `0` ou `0.0`, dependendo do tipo.

- Para variáveis booleanas (como `boolean`), o valor padrão é `false`.

- Para variáveis de caracteres (como `char`), o valor padrão é o caractere nulo (`'\u0000'`).

**Exemplo de Uso**:

Aqui está um exemplo que demonstra a criação de uma variável de referência `estudante1`, que inicialmente contém `null`,
e então você cria um objeto `Estudante` e faz `estudante1` referenciar esse objeto:

```java
Estudante estudante1;  // Variável de referência inicializada com null

// Criando um objeto Estudante
estudante1 = new Estudante();

// A variável de referência estudante1 agora aponta para o objeto recém-criado
estudante1.nome = "Alice";
estudante1.idade = 20;
estudante1.sexo = 'F';

System.out.println("Nome: " + estudante1.nome);
System.out.println("Idade: " + estudante1.idade);
System.out.println("Sexo: " + estudante1.sexo);
```

Este código ilustra como uma variável de referência pode ser inicializada com `null` e posteriormente apontar para um
objeto criado.

Lembre-se de que é importante sempre inicializar variáveis antes de usá-las para evitar erros. No caso de variáveis de
referência, você pode inicializá-las com `null` ou com uma instância de objeto, dependendo de sua lógica de programa.