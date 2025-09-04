package com.tanmoy.clone;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human tanmoy = new Human("Tanmoy Das", 27);
        Human twin1 = new Human(tanmoy);

        System.out.println("Twin 1: " + twin1.getName() + " " + twin1.getAge());

        Human twin2 = (Human) tanmoy.clone();
        System.out.println("Twin 2: " + twin2.getName()+ " " + twin2.getAge());
    }
}
