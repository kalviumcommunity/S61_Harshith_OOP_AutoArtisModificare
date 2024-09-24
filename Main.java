class Car {
    // Attributes
    private String model;
    private int speed;
    private String engineType;

    // Static variable to count the total number of cars created
    static int carCount = 0;

    // Static variable for a global speed limit
    static int speedLimit = 200; // Common speed limit for all cars

    // Constructor
    public Car(String model, int speed, String engineType) {
        this.model = model;
        this.speed = speed;
        this.engineType = engineType;
        carCount++; // Increment the car count whenever a new Car object is created
    }

    // Accessor (Getter) for model
    public String getModel() {
        return this.model;
    }

    // Mutator (Setter) for model
    public void setModel(String model) {
        this.model = model;
    }

    // Accessor (Getter) for speed
    public int getSpeed() {
        return this.speed;
    }

    // Mutator (Setter) for speed
    public void setSpeed(int speed) {
        if (speed <= speedLimit) {
            this.speed = speed;
        } else {
            System.out.println("Speed cannot exceed the global speed limit of " + speedLimit + " km/h");
        }
    }

    // Accessor (Getter) for engineType
    public String getEngineType() {
        return this.engineType;
    }

    // Mutator (Setter) for engineType
    public void setEngineType(String engineType) {
        this.engineType = engineType;
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
            this.speed += increment;
            System.out.println("New speed of " + this.model + ": " + this.speed + " km/h");
        }
    }

    // Static method to display the total number of cars created
    public static void displayCarCount() {
        System.out.println("Total number of cars created: " + carCount);
    }

    // Static method to set a new speed limit for all cars
    public static void setSpeedLimit(int newSpeedLimit) {
        speedLimit = newSpeedLimit;
        System.out.println("The new global speed limit for all cars is now: " + speedLimit + " km/h");
    }
}

// Class 2: Theme
class Theme {
    // Attributes
    private String themeName;
    private String themeType;

    // Static variable to keep track of themes applied
    static int themesApplied = 0;

    // Constructor
    public Theme(String themeName, String themeType) {
        this.themeName = themeName;
        this.themeType = themeType;
    }

    // Accessor (Getter) for themeName
    public String getThemeName() {
        return this.themeName;
    }

    // Mutator (Setter) for themeName
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    // Accessor (Getter) for themeType
    public String getThemeType() {
        return this.themeType;
    }

    // Mutator (Setter) for themeType
    public void setThemeType(String themeType) {
        this.themeType = themeType;
    }

    // Member function: Apply theme to car
    public void applyTheme(Car car) {
        System.out.println("Applying " + this.themeName + " (" + this.themeType + ") theme to " + car.getModel());
        themesApplied++;
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

        // Modify engine type for the first car in the array using mutator method
        cars[0].setEngineType("V10");
        System.out.println(cars[0].getModel() + " engine modified to: " + cars[0].getEngineType());

        // Instantiate Theme object
        Theme theme1 = new Theme("Steampunk", "Retro-Futuristic");

        // Apply the theme to the first car in the array
        theme1.applyTheme(cars[0]);

        // Display total number of cars created using the static method
        Car.displayCarCount();

        // Display total number of themes applied using the static method
        Theme.displayThemesApplied();

        // Adjust the speed limit using the static method
        Car.setSpeedLimit(180);

        // Attempt to increase speed for all cars after changing the speed limit
        for (Car car : cars) {
            car.increaseSpeed(30);
        }
    }
}
