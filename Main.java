// Class 1: Car
class Car {
    // Attributes
    String model;
    int speed;
    String engineType;

    // Constructor using 'this' to differentiate between parameters and attributes
    public Car(String model, int speed, String engineType) {
        this.model = model; // 'this' refers to the class's model attribute
        this.speed = speed; // 'this' refers to the class's speed attribute
        this.engineType = engineType; // 'this' refers to the class's engineType attribute
    }

    // Member function 1: Display car details
    public void displayDetails() {
        System.out.println("Car Model: " + this.model + ", Speed: " + this.speed + " km/h, Engine Type: " + this.engineType);
    }

    // Member function 2: Increase speed
    public void increaseSpeed(int increment) {
        this.speed += increment; // Using 'this' to refer to the current object's speed
        System.out.println("New speed of " + this.model + ": " + this.speed + " km/h");
    }

    // Member function 3: Modify engine
    public void modifyEngine(String newEngineType) {
        this.engineType = newEngineType; // Update the engine type
        System.out.println("Engine type of " + this.model + " modified to: " + this.engineType);
    }
}

// Class 2: Theme
class Theme {
    // Attributes
    String themeName;
    String themeType;

    // Constructor using 'this' to differentiate between parameters and attributes
    public Theme(String themeName, String themeType) {
        this.themeName = themeName; // 'this' refers to the class's themeName attribute
        this.themeType = themeType; // 'this' refers to the class's themeType attribute
    }

    // Member function 1: Apply theme to car
    public void applyTheme(Car car) {
        System.out.println("Applying " + this.themeName + " (" + this.themeType + ") theme to " + car.model);
    }
}

public class Main {
    public static void main(String[] args) {
        // Instantiate an array of Car objects
        Car[] cars = new Car[3];
        cars[0] = new Car("Steampunk Racer", 100, "V8");
        cars[1] = new Car("Mad Max Fury", 120, "V6");
        cars[2] = new Car("Futuristic Speedster", 150, "Electric");

        // Display details of all cars in the array
        for (Car car : cars) {
            car.displayDetails();
        }

        // Increase speed for all cars in the array
        for (Car car : cars) {
            car.increaseSpeed(30);
        }

        // Modify engine type for the first car in the array
        cars[0].modifyEngine("V10");

        // Instantiate Theme object
        Theme theme1 = new Theme("Steampunk", "Retro-Futuristic");

        // Apply the theme to the first car in the array
        theme1.applyTheme(cars[0]);
    }
}