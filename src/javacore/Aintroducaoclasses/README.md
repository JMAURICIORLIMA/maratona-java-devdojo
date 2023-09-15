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

> [Maratona Java 40 - Orientação Objetos - Introdução classes pt 02](https://www.youtube.com/watch?v=uB7KvSz6WiA&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW&index=41)

# Maratona Java 41 - Orientação Objetos - Introdução classes pt 03 - Coesão

Coesão é um princípio de design de software que se refere à medida em que as funcionalidades de um módulo, classe ou
componente estão relacionadas e agrupadas de forma lógica. Quanto mais coeso for um componente, mais relacionadas são
suas responsabilidades internas e menos dependências ele tem de outros componentes. A coesão é um indicador de quão bem
uma classe ou módulo mantém um foco singular e claro em sua funcionalidade.

A coesão é importante no desenvolvimento de software por várias razões:

1. **Facilita a Manutenção**: Componentes coesos são mais fáceis de entender, modificar e manter, porque suas
responsabilidades estão claramente definidas. Isso facilita a detecção e correção de erros, bem como a adição de novos
recursos.

2. **Reutilização de Código**: Componentes coesos são mais propensos a serem reutilizados em diferentes partes do
sistema, porque são independentes e focados em uma funcionalidade específica.

3. **Testabilidade**: Componentes coesos são mais fáceis de testar, porque suas funcionalidades estão claramente
definidas e isoladas umas das outras.

Existem vários tipos de coesão que descrevem diferentes níveis de relacionamento interno dentro de um componente:

1. **Coesão Funcional**: Neste nível mais alto de coesão, todas as responsabilidades internas de um componente estão
diretamente relacionadas à realização de uma única tarefa ou funcionalidade específica.

2. **Coesão Sequencial**: As responsabilidades internas do componente estão relacionadas em uma sequência lógica, onde
a saída de uma função se torna a entrada da próxima.

3. **Coesão Comunicacional**: Os componentes são agrupados com base em quais dados eles compartilham ou com quais
outros componentes eles precisam se comunicar.

4. **Coesão Temporal**: As responsabilidades internas do componente estão relacionadas ao mesmo período de tempo ou
atividade.

5. **Coesão Procedural**: As responsabilidades internas do componente estão relacionadas a uma série de etapas ou
procedimentos.

6. **Coesão Lógica**: As responsabilidades internas do componente estão relacionadas logicamente, mas não
necessariamente em uma sequência específica.

7. **Coesão de Coincidência**: Os componentes não têm uma relação lógica entre si; eles foram agrupados por acaso.

Em geral, o objetivo é alcançar coesão funcional, onde cada componente tem uma única responsabilidade bem definida e
independente. Isso resulta em um código mais organizado, modular e fácil de manter. Um dos princípios relacionados é o
princípio da responsabilidade única (SRP), que afirma que uma classe deve ter apenas um motivo para mudar, promovendo
alta coesão.

> [Maratona Java 41 - Orientação Objetos - Introdução classes pt 03 - Coesão](https://www.youtube.com/watch?v=dJLYPP1ExYY&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW&index=42)