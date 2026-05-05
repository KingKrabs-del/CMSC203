/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: This program allows users to manage a circus by adding and viewing animals, people, and buildings, 
 * searching and sorting animals, and generating tickets with different pricing and discounts.
 * Due: 05/04/2026
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Ishatta King
*/

import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
    }
    
    //getter methods
    public List<Animal> getAnimals() {
        return animals;
    }
    
    public List<Person> getPersons() {
        return persons; 
    }
    
    public List<Building> getBuildings() {
        return buildings;
    }

    // Add building
    public void addBuilding(Building build) {
        buildings.add(build);
    }

    // Display all buildings
    public void displayAllBuildings() {
        System.out.println("All Buildings:");
        for (Building building : buildings) {
            System.out.println(building);
        }
    }

    // Add person
    public void addPerson(Person human) {
        persons.add(human);
    }

    // Display all persons
    public void displayAllPersons() {
        System.out.println("All Earthlings:");
        for (Person human : persons) {
            System.out.println(human);
        }
    }


    // Add animal
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Display all animals
    public void displayAllAnimals() {
        System.out.println("All Animals:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    // Selection sort to sort animals by age
    public void sortAnimalsByAge() {
        for (int i = 0; i < animals.size(); i++) {
            int min = i;

            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getAge() < animals.get(min).getAge()) {
                    min = j;
                }
            }
            Animal temp = animals.get(i);
            animals.set(i, animals.get(min));
            animals.set(min, temp);
        }
    }
    
    // Selection sort to sort animals by name
    public void sortAnimalsByName() {
        for (int i = 0; i < animals.size(); i++) {
            int min = i;

            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getName().compareToIgnoreCase(animals.get(min).getName()) < 0) {
                    min = j;
                }
            }
            Animal temp = animals.get(i);
            animals.set(i, animals.get(min));
            animals.set(min, temp);
        }
    }

    // Search for an animal by name
    public Animal searchAnimalsByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

}
