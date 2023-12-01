# Modificador final

Palavra-chave "final" - Baeldung [^01]

[^01]: Acesse o site (em ingles) -> [A Palavra-chave "final" - Baeldung](https://www.baeldung.com/java-final)

77 - Orientação Objetos - Modificador final pt 01 - Tipos primitivos [^02]

[^02]: Acesse o vídeo
YouTube -> [77 - Orientação Obejtos - Modificador final pt 01 - Tipos primitivos](https://abre.ai/huJS)

78 - Orientação Objetos - Modificador final pt 02 - Tipos referência [^03]

[^03]: Acesse o vídeo
Youtube -> [78 - Orientação Objetos - Modificador final pt 02 - Tipos referência](https://abre.ai/huJZ)

## 1. Visão Geral

Embora a herança nos permita reutilizar o código existente, às vezes precisamos **definir limitações à extensibilidade**
por vários motivos; a _palavra-chave final_ nos permite fazer exatamente isso.

Neste tutorial, veremos o que a _palavra-chave final_ significa para classes, métodos e variáveis.

## 2. Classe Final

**As aulas marcadas como finais não poderão ser prorrogadas**. Se olharmos o código das principais bibliotecas Java,
encontraremos muitas _finais_ classes lá. Um exemplo é a _classe String_.

Considere a situação se pudermos estender a classe _String_, substituir qualquer um de seus métodos e substituir todas
as _instâncias de String_ pelas instâncias de nossa _subclasse String_ específica.

O resultado das operações sobre _objetos String_ se tornará imprevisível. E dado que a classe _String_ é usada em todos
os lugares, é inaceitável. É por isso que a _classe String_ está marcada como _final_.

Qualquer tentativa de herdar de uma _classe final_ causará um erro no compilador. Para demonstrar isso, vamos criar a
_final_ classe Cat:

```java
public final class Cat {

    private int weight;

    // standard getter and setter

}
```

E vamos tentar estendê-lo:

```java
public class BlackCat extends Cat {
}
```

Veremos o erro do compilador:

> The type BlackCat cannot subclass the final class Cat

Observe que **a _palavra-chave final_ em uma declaração de classe não significa que os objetos desta classe sejam
imutáveis**. Podemos alterar os campos do _objeto Cat_ livremente:

```java
Cat cat=new Cat();
        cat.setWeight(1);

        assertEquals(1,cat.getWeight());
```

Simplesmente não podemos estendê-lo.

Se seguirmos rigorosamente as regras de um bom design, devemos criar e documentar uma classe cuidadosamente ou
declará-la _final_ por razões de segurança. No entanto, devemos ter cuidado ao criar _classes finais_.

Observe que tornar uma classe _final_ significa que nenhum outro programador pode melhorá-la. Imagine que estamos usando
uma classe e não temos o código-fonte dela, e há um problema com um método.

Se a classe for _final_, não poderemos estendê-la para substituir o método e corrigir o problema. Em outras palavras,
perdemos a extensibilidade, um dos benefícios da programação orientada a objetos.

## 3. Métodos Final

**Os métodos marcados como _finais_ não podem ser substituídos**. Quando projetamos uma classe e sentimos que um método
não deve ser substituído, podemos tornar esse método _final_ . Também podemos encontrar muitos _métodos finais_ nas
principais bibliotecas Java.

Às vezes não precisamos proibir totalmente uma extensão de classe, mas apenas evitar a substituição de alguns métodos.
Um bom exemplo disso é a _classe Thread_. É legal estendê-lo e assim criar uma classe de thread personalizada. Mas seus
_isAlive()_ métodos são _finais_.

Este método verifica se um thread está ativo. É impossível substituir o _isAlive()_ método corretamente por vários
motivos. Uma delas é que esse método é nativo. O código nativo é implementado em outra linguagem de programação e
geralmente é específico do sistema operacional e do hardware em que está sendo executado.

Vamos criar uma _classe Dog_ e tornar seu _sound()_ método final:

```java
public class Dog {
    public final void sound() {
// ...
    }
}
```

Agora vamos estender a _classe Dog_ e tentar substituir seu _sound()_: método

```java
public class BlackDog extends Dog {
    public void sound() {
    }
}
```

Veremos o erro do compilador:

> -- overrides
>
> com.baeldung.finalkeyword.Dog.sound
>
> -- Cannot override the final method from Dog
>
> sound() method is final and can’t be overridden

Se alguns métodos de nossa classe forem chamados por outros métodos, devemos considerar tornar os métodos chamados
_finais_. Caso contrário, substituí-los pode afetar o trabalho dos chamadores e causar resultados surpreendentes.

Se nosso construtor chamar outros métodos, geralmente devemos declarar esses métodos como _finais_ pelo motivo acima.

Qual é a diferença entre tornar todos os métodos da classe _finais_ e marcar a própria classe como _final_? No primeiro
caso, podemos estender a classe e adicionar novos métodos a ela.

No segundo caso, não podemos fazer isso.

## 4. Variáveis Final

**Variáveis marcadas como _finais_ não podem ser reatribuídas**. Depois que uma _variável final_ é inicializada, ela não
pode ser alterada.

### 4.1. Variáveis Primitivas Final

Vamos declarar uma _final_ variável _primitiva_ i e então atribuir 1 a ela.

E vamos tentar atribuir um valor 2 a ele:

```java
public void whenFinalVariableAssign_thenOnlyOnce(){
final int i=1;
//...
        i=2;
        }
```

O compilador diz:

> The final local variable i may already have been assigned (A variável local final i pode já ter sido atribuída)

### 4.2. Variáveis de Referência Final

Se tivermos uma _variável de referência final_, também não poderemos reatribuí-la. Mas **isso não significa que o objeto
ao qual se refere seja imutável**. Podemos alterar as propriedades deste objeto livremente.

Para demonstrar isso, vamos declarar a _final_ variável de referência _cat_ e inicializá-la:

```java
final Cat cat=new Cat();
```

Se tentarmos reatribuí-lo, veremos um erro do compilador:

> The final local variable cat cannot be assigned. It must be blank and not using a compound assignment
>
> (A variável local final cat não pode ser atribuída. Deve estar em branco e não usar uma atribuição composta)

Mas podemos alterar as propriedades da _instância Cat_:

```java
cat.setWeight(5);

        assertEquals(5,cat.getWeight());
```

### 4.3. Campos Final

**Os _campos finais_ podem ser constantes ou campos de gravação única**. Para distingui-los, deveríamos fazer uma
pergunta —
incluiríamos este campo se serializássemos o objeto? Se não, então não faz parte do objeto, mas é uma constante.

Observe que, de acordo com as convenções de nomenclatura, as constantes de classe devem estar em letras maiúsculas, com
os componentes separados por caracteres de sublinhado (“_”):

```java
static final int MAX_WIDTH=999;
```

Observe que **qualquer _campo final_ deve ser inicializado antes da conclusão do construtor**.

Para _campos finais estáticos_, isso significa que podemos inicializá-los:

* mediante declaração conforme mostrado no exemplo acima
* no bloco inicializador estático

Por exemplo, _campos finais_, isso significa que podemos inicializá-los:

* mediante declaração
* no bloco inicializador de instância
* no construtor

Caso contrário, o compilador nos dará um erro.

### 4.4. Argumentos Final

A _palavra-chave final_ também é legal para ser colocada antes dos argumentos do método. **Um argumento final não pode
ser alterado dentro de um método**:

```java
public void methodWithFinalArguments(final int x){
        x=1;
        }
```

A atribuição acima causa o erro do compilador:

> The final local variable x cannot be assigned. It must be blank and not using a compound assignment
>
> (A variável local final x não pode ser atribuída. Deve estar em branco e não usar uma atribuição composta)

### 5. Conclusão

Neste artigo, aprendemos o que a _palavra-chave final_ significa para classes, métodos e variáveis. Embora não possamos
usar a _palavra-chave final_ com frequência em nosso código interno, ela pode ser uma boa solução de design.