package javacore.Bintroducaometodos.aula09exercicio.dominio;

public class Employee {

    public String name;
    public int age;
    public double[] salary;

    public void print() {
        System.out.println("Nome: " + name);
        System.out.println("Idade: " + age);
        if (salary == null) {
            return;
        }
        for (double slr : salary) {
            System.out.print(" | " + slr + " | ");
        }
        System.out.printf("%nMédia salarial: R$%.2f%n", AverageOfTheLastThreeSalaries(salary));
    }

    protected double AverageOfTheLastThreeSalaries(double[] salary) {
        if (salary == null) {
            return 0;
        }
        double averege = 0;
        if (salary.length != 3) {
            System.out.println("\nQuantidade de salário inferior ou maior que 3.");
            return 0;
        } else {
            for (double slr : salary) {
                averege += slr;
            }
            return averege / salary.length;
        }
    }
}
