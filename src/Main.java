import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Scanner scanner = new Scanner(System.in);

        
        shelter.enqueue(new Dog("Rex"));
        shelter.enqueue(new Cat("Mittens"));
        shelter.enqueue(new Dog("Buddy"));
        shelter.enqueue(new Cat("Luna"));
        shelter.enqueue(new Dog("Rocky"));

        System.out.println("Welcome to the Animal Shelter!");
        System.out.println("--------------------------------");

        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Adopt the oldest animal");
            System.out.println("2. Adopt a dog");
            System.out.println("3. Adopt a cat");
            System.out.println("4. Exit");

            System.out.print("Enter choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1 -> {
                        Animal adopted = shelter.dequeueAny();
                        System.out.println(" Congrats! You adopted " + adopted.getName() + " the " + adopted.getClass().getSimpleName() + "!");
                    }
                    case 2 -> {
                        Dog adoptedDog = shelter.dequeueDog();
                        System.out.println(" Congrats! You adopted " + adoptedDog.getName() + " the Dog!");
                    }
                    case 3 -> {
                        Cat adoptedCat = shelter.dequeueCat();
                        System.out.println(" Congrats! You adopted " + adoptedCat.getName() + " the Cat!");
                    }
                    case 4 -> {
                        System.out.println("Thank you for visiting the shelter. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid option, please try again.");
                }
            } catch (Exception e) {
                System.out.println("⚠️  " + e.getMessage());
            }
        }

        scanner.close();
    }
}
