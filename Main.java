class Car {
    // Attributes
    String model;
    int speed;
    String engineType;

    // Static variable to count the total number of cars created
    static int carCount = 0;

    // Static variable for a global speed limit
    static int speedLimit = 200; // Common speed limit for all cars

    // Constructor using 'this' to differentiate between parameters and attributes
    public Car(String model, int speed, String engineType) {
        this.model = model;
        this.speed = speed;
        this.engineType = engineType;
        carCount++; // Increment the car count whenever a new Car object is created
    }

    // Member function 1: Display car details
    public void displayDetails() {
        System.out.println("Car Model: " + this.model + ", Speed: " + this.speed + " km/h, Engine Type: " + this.engineType);
    }

    // Member function 2: Increase speed
    public void increaseSpeed(int increment) {
        if (this.speed + increment > speedLimit) {
            System.out.println("Cannot exceed the speed limit of " + speedLimit + " km/h");
        } else {
            this.speed += increment; // Using 'this' to refer to the current object's speed
            System.out.println("New speed of " + this.model + ": " + this.speed + " km/h");
        }
    }

    // Member function 3: Modify engine
    public void modifyEngine(String newEngineType) {
        this.engineType = newEngineType; // Update the engine type
        System.out.println("Engine type of " + this.model + " modified to: " + this.engineType);
    }

    // Static method to display the total number of cars created
    public static void displayCarCount() {
        System.out.println("Total number of cars created: " + carCount);
    }

    // New Static Method: Set a new speed limit for all cars
    public static void setSpeedLimit(int newSpeedLimit) {
        speedLimit = newSpeedLimit;
        System.out.println("The new global speed limit for all cars is now: " + speedLimit + " km/h");
    }
}


// Class 2: Theme
class Theme {
    // Attributes
    String themeName;
    String themeType;

    // Static variable to keep track of themes applied
    static int themesApplied = 0;

    // Constructor using 'this' to differentiate between parameters and attributes
    public Theme(String themeName, String themeType) {
        this.themeName = themeName;
        this.themeType = themeType;
    }

    // Member function 1: Apply theme to car
    public void applyTheme(Car car) {
        System.out.println("Applying " + this.themeName + " (" + this.themeType + ") theme to " + car.model);
        themesApplied++; // Increment the count of themes applied
    }

    // Static method to display the number of themes applied
    public static void displayThemesApplied() {
        System.out.println("Total themes applied: " + themesApplied);
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

        // Demonstrating the use of static member functions:
        System.out.println("\n--- Static Member Function Demonstration ---");

        // Display total number of cars created using the static method
        Car.displayCarCount();

        // Display total number of themes applied using the static method
        Theme.displayThemesApplied();

        // Adjust the speed limit using the new static method
        System.out.println("\nSetting a new global speed limit:");
        Car.setSpeedLimit(180); // Lowering the speed limit to 180 km/h

        // Attempt to increase speed for all cars after changing the speed limit
        for (Car car : cars) {
            car.increaseSpeed(30);
        }
    }
}

