// Class 1: Car (Base Class)
class Car {
    // Private attributes: Encapsulating the fields to prevent direct access
    private String model;
    private int speed;
    private String engineType;

    // Static variables to keep track of car counts and speed limit
    public static int carCount = 0;  // Accessible publicly
    public static int speedLimit = 200; // Public static variable for global speed limit

    // Default constructor: Initializes the car with default values
    public Car() {
        this.model = "Generic Model";
        this.speed = 0;
        this.engineType = "Unknown";
        carCount++;  // Increment car count when a new object is created
    }

    // Parameterized constructor: Initializes the car with given values
    public Car(String model, int speed, String engineType) {
        this.model = model;
        this.speed = speed;
        this.engineType = engineType;
        carCount++;  // Increment car count when a new object is created
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
    // Private attributes for theme details
    private String themeName;
    private String themeType;

    // Static variable to keep track of themes applied
    public static int themesApplied = 0;  // Public to access the number of themes applied

    // Default constructor: Initializes the theme with default values
    public Theme() {
        this.themeName = "Default Theme";
        this.themeType = "Default Type";
    }

    // Parameterized constructor: Initializes the theme with given values
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

// Class 3: LuxuryCar (Derived Class - Single Inheritance)
class LuxuryCar extends Car {
    private String interiorType;

    public LuxuryCar(String model, int speed, String engineType, String interiorType) {
        super(model, speed, engineType);
        this.interiorType = interiorType;
    }

    // Public method to show luxury features
    public void showLuxuryFeatures() {
        System.out.println("Interior: " + this.interiorType);
    }
}

// Class 4: ElectricCar (Derived Class - Multilevel Inheritance)
class ElectricCar extends LuxuryCar {
    private int batteryCapacity; // in kWh

    public ElectricCar(String model, int speed, String interiorType, int batteryCapacity) {
        super(model, speed, "Electric", interiorType);
        this.batteryCapacity = batteryCapacity;
    }

    // Public method to display electric-specific features
    public void displayElectricFeatures() {
        System.out.println("Battery Capacity: " + this.batteryCapacity + " kWh");
    }
}

public class Main {
    public static void main(String[] args) {
        // Instantiate an array of Car objects using both default and parameterized constructors
        Car[] cars = new Car[3];
        cars[0] = new Car(); // Using default constructor
        cars[1] = new Car("Mad Max Fury", 120, "V6"); // Using parameterized constructor
        cars[2] = new Car("Futuristic Speedster", 150, "Electric"); // Using parameterized constructor

        // Display details of all cars in the array
        for (Car car : cars) {
            car.displayDetails();
        }

        // Demonstrating Single Inheritance
        LuxuryCar luxuryCar = new LuxuryCar("Mercedes-Benz S-Class", 220, "V8", "Leather");
        luxuryCar.displayDetails();
        luxuryCar.showLuxuryFeatures();

        // Demonstrating Multilevel Inheritance
        ElectricCar electricCar = new ElectricCar("Tesla Model S", 200, "Futuristic", 100);
        electricCar.displayDetails();
        electricCar.displayElectricFeatures();

        // Demonstrating the use of static member functions:
        System.out.println("\n--- Static Member Function Demonstration ---");

        // Display total number of cars created using the static method
        Car.displayCarCount();

        // Instantiate Theme objects using both default and parameterized constructors
        Theme theme1 = new Theme(); // Using default constructor
        Theme theme2 = new Theme("Steampunk", "Retro-Futuristic"); // Using parameterized constructor

        // Apply themes to cars
        theme1.applyTheme(cars[0]);
        theme2.applyTheme(cars[1]);

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
