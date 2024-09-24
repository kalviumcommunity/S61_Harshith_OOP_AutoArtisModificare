class Car {
    // Private attributes: Encapsulating the fields to prevent direct access
    private String model;
    private int speed;
    private String engineType;

    // Static variables are generally public to allow easy access (could also be private if desired)
    public static int carCount = 0;  // Accessible publicly
    public static int speedLimit = 200; // Public static variable (global speed limit for all cars)

    // Public constructor: Can be accessed outside the class to create Car objects
    public Car(String model, int speed, String engineType) {
        this.model = model;
        this.speed = speed;
        this.engineType = engineType;
        carCount++;  // Increment the car count whenever a new Car object is created
    }

    // Public Accessor (Getter) for model
    public String getModel() {
        return this.model;
    }

    // Public Mutator (Setter) for model
    public void setModel(String model) {
        this.model = model;
    }

    // Public Accessor (Getter) for speed
    public int getSpeed() {
        return this.speed;
    }

    // Public Mutator (Setter) for speed with validation logic
    public void setSpeed(int speed) {
        if (speed <= speedLimit) {
            this.speed = speed;
        } else {
            System.out.println("Speed cannot exceed the global speed limit of " + speedLimit + " km/h");
        }
    }

    // Public Accessor (Getter) for engineType
    public String getEngineType() {
        return this.engineType;
    }

    // Public Mutator (Setter) for engineType
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    // Public method to display car details
    public void displayDetails() {
        System.out.println("Car Model: " + this.model + ", Speed: " + this.speed + " km/h, Engine Type: " + this.engineType);
    }

    // Public method to increase speed with validation logic
    public void increaseSpeed(int increment) {
        if (this.speed + increment > speedLimit) {
            System.out.println("Cannot exceed the speed limit of " + speedLimit + " km/h");
        } else {
            this.speed += increment;
            System.out.println("New speed of " + this.model + ": " + this.speed + " km/h");
        }
    }

    // Static method to display the total number of cars created (publicly accessible)
    public static void displayCarCount() {
        System.out.println("Total number of cars created: " + carCount);
    }

    // Static method to set a new speed limit for all cars (publicly accessible)
    public static void setSpeedLimit(int newSpeedLimit) {
        speedLimit = newSpeedLimit;
        System.out.println("The new global speed limit for all cars is now: " + speedLimit + " km/h");
    }
}

// Class 2: Theme
class Theme {
    // Private attributes: Encapsulating the fields to prevent direct access
    private String themeName;
    private String themeType;

    // Static variables can be public to allow easy access
    public static int themesApplied = 0;  // Public to access the number of themes applied

    // Public constructor: Can be accessed outside the class to create Theme objects
    public Theme(String themeName, String themeType) {
        this.themeName = themeName;
        this.themeType = themeType;
    }

    // Public Accessor (Getter) for themeName
    public String getThemeName() {
        return this.themeName;
    }

    // Public Mutator (Setter) for themeName
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    // Public Accessor (Getter) for themeType
    public String getThemeType() {
        return this.themeType;
    }

    // Public Mutator (Setter) for themeType
    public void setThemeType(String themeType) {
        this.themeType = themeType;
    }

    // Public method to apply theme to a car (accessible publicly)
    public void applyTheme(Car car) {
        System.out.println("Applying " + this.themeName + " (" + this.themeType + ") theme to " + car.getModel());
        themesApplied++;
    }

    // Static method to display the number of themes applied (publicly accessible)
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
