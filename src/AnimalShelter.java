import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalShelter {

    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int orderCounter = 0; // increases every time we enqueue an animal

    // Add a new animal to the shelter
    public void enqueue(Animal animal) {
        animal.setOrder(orderCounter);
        orderCounter++;

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        } else {
            throw new IllegalArgumentException("Shelter only accepts dogs and cats.");
        }
    }

    // Adopt the oldest animal overall
    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new NoSuchElementException("No animals in shelter.");
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog oldestDog = dogs.peekFirst();
        Cat oldestCat = cats.peekFirst();

        if (oldestDog.isOlderThan(oldestCat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    // Adopt the oldest dog
    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            throw new NoSuchElementException("No dogs in shelter.");
        }
        return dogs.removeFirst();
    }

    // Adopt the oldest cat
    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            throw new NoSuchElementException("No cats in shelter.");
        }
        return cats.removeFirst();
    }

    
    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }

    public boolean hasDogs() {
        return !dogs.isEmpty();
    }

    public boolean hasCats() {
        return !cats.isEmpty();
    }
}
