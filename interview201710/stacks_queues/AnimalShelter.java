package interview201710.stacks_queues;

import interview201710.DataStructures.*;

public class AnimalShelter {
  Queue<Dog> dogs;
  Queue<Cat> cats;
  int currentEntryTime;
  int currentDogEntry;
  int currentCatEntry;

  public enum AnimalType {
    DOG, CAT
  }

  public static void main(String[] args) {
    AnimalShelter as = new AnimalShelter();
    as.enqueue("Cat1", AnimalType.CAT);
    as.enqueue("Cat2", AnimalType.CAT);
    as.enqueue("Dog1", AnimalType.DOG);
    as.enqueue("Cat3", AnimalType.CAT);
    as.enqueue("Dog2", AnimalType.DOG);
    as.enqueue("Cat4", AnimalType.CAT);
    as.enqueue("Dog3", AnimalType.DOG);
    as.enqueue("Dog4", AnimalType.DOG);
    as.enqueue("Cat5", AnimalType.CAT);
    as.enqueue("Dog5", AnimalType.DOG);

    System.out.println("DequeueCat: " + as.dequeueCat().getName());
    System.out.println("DequeueAny: " + as.dequeueAny().getName());
    System.out.println("DequeueCat: " + as.dequeueCat().getName());
    System.out.println("DequeueAny: " + as.dequeueAny().getName());
    System.out.println("DequeueAny: " + as.dequeueAny().getName());
  }

  public AnimalShelter() {
    this.dogs = new Queue<Dog>();
    this.cats = new Queue<Cat>();
    this.currentEntryTime = 0;
    this.currentDogEntry = 0;
    this.currentCatEntry = 0;
  }

  public void enqueue(String name, AnimalType type) {
    if(type == AnimalType.DOG) {
      dogs.add(new Dog(name, currentEntryTime, getAnimalID(AnimalType.DOG)));
      currentDogEntry++;
    } else if(type == AnimalType.CAT) {
      cats.add(new Cat(name, currentEntryTime, getAnimalID(AnimalType.CAT)));
      currentCatEntry++;
    }
    currentEntryTime++;
  }

  public Animal dequeueAny() {
    Dog oldestDog = dogs.peek();
    Cat oldestCat = cats.peek();

    if(oldestDog == null || oldestCat.isOlderThan(oldestDog)) {
      return cats.poll();
    } else if(oldestCat == null || oldestDog.isOlderThan(oldestCat)) {
      return dogs.poll();
    }

    return null;
  }

  public Dog dequeueDog() {
    return dogs.poll();
  }

  public Cat dequeueCat() {
    return cats.poll();
  }

  public int getAnimalID(AnimalType type) {
    String identifier = "";
    if(type == AnimalType.DOG) {
      identifier = "DOG"+currentDogEntry;
    } else if(type == AnimalType.CAT) {
      identifier = "CAT"+currentCatEntry;
    }
    return identifier.hashCode();
  }

  public abstract class Animal {
    private int entryTime; // should be a date but for this purpose just an int
    private String name;
    private int animalID;

    public Animal(String name, int entryTime, int animalID) {
      this.name = name;
      this.entryTime = entryTime;
      this.animalID = animalID;
    }

    public boolean isOlderThan(Animal a) {
      return this.entryTime < a.entryTime;
    }

    public String getName() {
      return this.name;
    }
  }

  public class Dog extends Animal {
    public Dog(String name, int entryTime, int animalID) {
      super(name, entryTime, animalID);
    }
  }

  public class Cat extends Animal {
    public Cat(String name, int entryTime, int animalID) {
      super(name, entryTime, animalID);
    }
  }
}
