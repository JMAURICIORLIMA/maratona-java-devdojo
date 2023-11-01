package javacore.Bintroducaometodos.aula11.dominio;

public class Employee {

    private String name;
    private int age;
    private double[] salary;
    private double averege;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double[] getSalary() {
        return salary;
    }

    public void setSalary(double[] salary) {
        this.salary = salary;
    }

}
