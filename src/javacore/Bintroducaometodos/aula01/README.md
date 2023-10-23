# Maratona Java 44 - Orientação Objetos - Métodos

1. **Introdução**

Em Java, os métodos são onde definimos a lógica de negócios de um aplicativo. Eles definem as interações entre os dados
contidos em um objeto.

Neste tutorial, veremos a sintaxe dos métodos Java, a definição da assinatura do método e como chamar e sobrecarregar
métodos.

2. **Sintaxe do método**

Primeiro, um método consiste em seis partes:

> * **Modificador de acesso:** opcionalmente podemos especificar de onde o código pode acessar o método.
> * **Tipo de retorno:** o tipo do valor retornado pelo método, se houver.
> * **Identificador do método:** o nome que damos ao método.
> * **Lista de parâmetros:** uma lista opcional de entradas separadas por vírgula para o método.
> * **Lista de exceções:** uma lista opcional de exceções que o método pode lançar
> * **Corpo:** definição da lógica (pode estar vazio)

Vejamos um exemplo:

![esquema de metodo](https://github.com/JMAURICIORLIMA/maratona-java-devdojo/blob/91dfc7c64e2fcfb24ce191dc41e21c1846436118/img/method-structure-3-1024x131.png)

2.1. **Modificador de acesso**

O modificador de acesso nos permite especificar quais objetos podem ter acesso ao método. Existem quatro modificadores
de acesso possíveis: public, protected, private e default (também chamado package-private ).

Um método também pode incluir a static palavra-chave antes ou depois do modificador de acesso. Isso significa que o
método pertence à classe e não às instâncias e, portanto, podemos chamar o método sem criar uma instância da classe.
Métodos sem a palavra-chave static são conhecidos como métodos de instância e só podem ser invocados em uma instância
da classe.

Em relação ao desempenho, um método estático será carregado na memória apenas uma vez – durante o carregamento da
classe – e, portanto, é mais eficiente em termos de memória.

2.2. **Tipo de retorno**

Os métodos podem retornar dados para o código de onde foram chamados. Um método pode retornar um valor primitivo ou uma
referência de objeto, ou pode não retornar nada se usarmos a palavra-chave void como tipo de retorno.

Vejamos um exemplo de método void

```java
public void printFullName(String firstName, String lastName) {
    System.out.println(firstName + " " + lastName);
}
```

Se declararmos um tipo de retorno, teremos que especificar uma instrução de retorno no corpo do método. a instrução
return, a execução do corpo do método será finalizada e se houver mais instruções, estas não serão processadas. Uma vez
executada.

Por outro lado, um método void não retorna nenhum valor e, portanto, não possui uma instrução de retorno.

2.3. **Identificador de método**

O identificador do método é o nome que atribuímos a uma especificação de método. É uma boa prática usar um nome
informativo e descritivo. Vale ressaltar que um identificador de método pode ter no máximo 65.536 caracteres (embora
seja um nome longo).

2.4. **Lista de parâmetros**

Podemos especificar valores de entrada para um método em sua lista de parâmetros, que está entre parênteses. Um método
pode ter de 0 a 255 parâmetros delimitados por vírgulas. Um parâmetro pode ser um objeto, uma primitiva ou uma
enumeração . Podemos usar anotações Java no nível do parâmetro do método (por exemplo, a anotação Spring @RequestParam).

2.5. **Lista de exceções**

Podemos especificar quais exceções são lançadas por um método usando a cláusula throws. No caso de uma exceção
verificada, devemos colocar o código em uma try-catch cláusula ou devemos fornecer uma cláusula throws na assinatura do
método.

Então, vamos dar uma olhada em uma variante mais complexa do nosso método anterior, que lança uma exceção verificada:

```java
public void writeName(String name) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        out.println("Name: " + name);
        out.close();
}
```

2.6. **Corpo do método**

A última parte de um método Java é o corpo do método, que contém a lógica que queremos executar. No corpo do método,
podemos escrever quantas linhas de código quisermos — ou nenhuma, no caso de métodos estáticos. Se nosso método
declarar um tipo de retorno, o corpo do método deverá conter uma instrução de retorno.

3. **Assinatura do Método**

De acordo com sua definição, uma assinatura de método é composta por apenas dois componentes – o nome do método e a
lista de parâmetros.

Então, vamos escrever um método simples:

```java
public String getName(String firstName, String lastName) {
    return firstName + " " + middleName + " " + lastName;
}
```

A assinatura deste método é getName(String firstName, String lastName).

O identificador do método pode ser qualquer identificador. No entanto, se seguirmos as convenções comuns de codificação
Java, o identificador do método deve ser um verbo em letras minúsculas que pode ser seguido por adjetivos e/ou
substantivos.

4. **Chamando um Método**

Agora, vamos explorar como chamar um método em Java. Seguindo o exemplo anterior, vamos supor que esses métodos estejam
incluídos em uma classe Java chamada PersonName:

```java
public class PersonName {
    
    public String getName(String firstName, String lastName) {
        return firstName + " " + middleName + " " + lastName;
    }
}
```

Como nosso método getName é um método de instância e não um método estático, para chamar o método getName, precisamos
criar uma instância da classe PersonName:

```java
PersonName personName = new PersonName();
String fullName = personName.getName("Alan", "Turing");
```

Como podemos ver, usamos o objeto criado para chamar o método getName.

Finalmente, vamos dar uma olhada em como chamar um método estático. No caso de um método estático, não precisamos de
uma instância de classe para fazer a chamada. Em vez disso, invocamos o método com seu nome prefixado pelo nome da
classe.

Vamos demonstrar usando uma variante do exemplo anterior:

```java
public class PersonName {

    public static String getName(String firstName, String lastName) {
        return firstName + " " + middleName + " " + lastName;
    }
}
```

Neste caso, a chamada do método é:

```java
String fullName = PersonName.getName("Alan", "Turing");
```

5. Sobrecarga de método

Java nos permite ter dois ou mais métodos com o mesmo identificador, mas com listas de parâmetros diferentes —
assinaturas de métodos diferentes. Neste caso, dizemos que o método está sobrecarregado. Vamos com um exemplo:

```java
public String getName(String firstName, String lastName) {
    return getName(firstName, "", lastName);
}

public String getName(String firstName, String middleName, String lastName) {
    if (!middleName.isEqualsTo("")) {
        return firstName + " " + lastName;
    }
        return firstName + " " + middleName + " " + lastName;
}
```

A sobrecarga de métodos é útil para casos como o do exemplo, onde podemos ter um método implementando uma versão
simplificada da mesma funcionalidade.

Finalmente, um bom hábito de design é garantir que os métodos sobrecarregados se comportem de maneira semelhante.
Caso contrário, o código ficará confuso se um método com o mesmo identificador se comportar de maneira diferente.

6. Conclusão

Neste tutorial, exploramos as partes da sintaxe Java envolvidas ao especificar um método em Java.

Em particular, examinamos o modificador de acesso, o tipo de retorno, o identificador do método, a lista de parâmetros,
a lista de exceções e o corpo do método. Depois vimos a definição da assinatura do método, como chamar um método e como
sobrecarregar um método.

Methods in Java [^1].

[^1]: Mais informações podem ser encontradas no [site Baeldung](https://www.baeldung.com/java-methods).

Orientação Objetos - Métodos pt-01 [^2].

[^2] [Maratona Java 44 - Orientação Objetos - Métodos pt 01](https://abre.ai/g4Q5)
