package LabClass8March;
/* public class Main {
    public static void main(String[] args) {
        Vehicle v = new Bike();  
        v.start();          
    }
}
*/

class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat() };

        for (Animal a : animals) {
            a.makeSound();
        }
    }
}
