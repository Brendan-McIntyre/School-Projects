/****************************************************
 Name: Brendan McIntyre  Period:2
 Name of the Lab/Assignment:  Animal Kingdom Lab

 What I Learned:
I learned how I had to type cast the objects in the array to be able to use the unique methods.
 ****************************************************/

public class Pd2BrendanMcIntyreAnimalKingdom {
    public static void main(String[] args) {
        // Create an array of Animal objects
        Animal[] creatures = new Animal[3];

        // Add different types of animals to the array
        creatures[0] = new Bird("Eagle");
        creatures[1] = new Fish("GoldFish");
        creatures[2] = new Mammal("Lion");

        // Each animal and test their behaviors
        // Eagle
        System.out.println("Testing " + creatures[0].getName() + ":");
        creatures[0].makeSound();
        creatures[0].move();
        System.out.println();

        // Goldfish
        System.out.println("Testing " + creatures[1].getName() + ":");
        creatures[1].makeSound();
        creatures[1].move();
        System.out.println();

        // Lion
        System.out.println("Testing " + creatures[2].getName() + ":");
        creatures[2].makeSound();
        creatures[2].move();
        System.out.println();

        // Call unique methods for each type of animal
        System.out.println("Unique activities:");
        ((Bird) creatures[0]).layEggs();
        ((Fish) creatures[1]).swimInSchool();
        ((Mammal) creatures[2]).nurseYoung();
    } // main
} // end of Pd2BrendanMcIntyreAnimalKingdom


// Base class: Animal
class Animal {
    private String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Method to be overridden
    public void makeSound() {
        // Precondition: name is a non-null valid string.
        // Postcondition: Prints the sound the animal makes with the animal's name.
        System.out.println(name + " makes a sound.");
    }

    // Method to be overridden
    public void move() {
        // Precondition: name is a non-null valid string.
        // Postcondition: Prints how the animal moves.
        System.out.println(name + " moves around.");
    }
} // end of Animal


// Subclass: Bird
class Bird extends Animal {
    // Constructor
    public Bird(String name) {
        super(name);
    }

    // Overriding makeSound
    public void makeSound() {
        // Precondition: Bird object is instantiated, and name is non-null.
        // Postcondition: Prints that the bird chirps with the bird's name.
        System.out.println(super.getName() + " chirps.");
    }

    // Overriding move
    public void move() {
        // Precondition: Bird object is instantiated, and name is non-null.
        // Postcondition: Prints how the bird flies.
        System.out.println(getName() + " flies through the air.");
    }

    // Unique method
    public void layEggs() {
        // Precondition: Bird object is instantiated.
        // Postcondition: Prints that the bird lays eggs.
        System.out.println(getName() + " lays eggs.");
    }
}  // end of Bird


// Subclass: Fish
class Fish extends Animal {
    // Constructor
    public Fish(String name) {
        super(name);
    }

    // Overriding makeSound
    public void makeSound() {
        // Precondition: Fish object is instantiated, and name is non-null.
        // Postcondition: Prints that the fish bubbles with the fish's name.
        System.out.println(super.getName() + " bubbles.");
    }

    // Overriding move
    public void move() {
        // Precondition: Fish object is instantiated, and name is non-null.
        // Postcondition: Prints how the fish swims.
        System.out.println(getName() + " swims in the water.");
    }

    // Unique method
    public void swimInSchool() {
        // Precondition: Fish object is instantiated.
        // Postcondition: Prints that the fish swims in a school.
        System.out.println(getName() + " swims in a school.");
    }
}  // end of Fish


// Subclass: Mammal
class Mammal extends Animal {
    // Constructor
    public Mammal(String name) {
        super(name);
    }

    // Overriding makeSound
    public void makeSound() {
        // Precondition: Mammal object is instantiated, and name is non-null.
        // Postcondition: Prints that the mammal growls with the mammal's name.
        System.out.println(super.getName() + " growls.");
    }

    // Overriding move
    public void move() {
        // Precondition: Mammal object is instantiated, and name is non-null.
        // Postcondition: Prints how the mammal walks on land.
        System.out.println(getName() + " walks on land.");
    }

    // Unique method
    public void nurseYoung() {
        // Precondition: Mammal object is instantiated.
        // Postcondition: Prints that the mammal nurses its young.
        System.out.println(getName() + " nurses its young.");
    }
}  // end of Mammal
