// Abstract Class: CarBase (Base Class for all Car types)
// This abstract class provides a base for different car types with common properties and an abstract method.
abstract class CarBase {
    // Abstract method to be implemented by derived classes
    public abstract void displayDetails();

    // Non-abstract method that can be shared among derived classes
    public void increaseSpeed(int increment) {
        System.out.println("Speed increased by: " + increment + " km/h");
    }
}

// Class 1: Car (Derived Class)
class Car extends CarBase {
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

    // Implementation of the abstract method from CarBase
    // Polymorphic behavior: each derived class will have its own version of displayDetails
    @Override
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

// Interface for CarTheme to follow Open/Closed Principle
interface CarTheme {
    void applyTheme(CarBase car);  // Method to apply the theme to a car
}

// Class 2: Theme (Implements CarTheme interface)
class Theme implements CarTheme {
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

    // Implementation of applyTheme method from CarTheme interface
    public void applyTheme(CarBase car) {
        System.out.println("Applying " + this.themeName + " (" + this.themeType + ") theme to a car.");
        themesApplied++;
    }

    // Static method to display the number of themes applied (publicly accessible)
    public static void displayThemesApplied() {
        System.out.println("Total themes applied: " + themesApplied);
    }
}

// Class 3: LuxuryCar (Derived Class)
class LuxuryCar extends Car {
    private String interiorType;

    public LuxuryCar(String model, int speed, String engineType, String interiorType) {
        super(model, speed, engineType);
        this.interiorType = interiorType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();  // Call to base class method
        System.out.println("Interior Type: " + this.interiorType);
    }

    // Public method to show luxury features
    public void showLuxuryFeatures() {
        System.out.println("Interior: " + this.interiorType);
    }
}

// Class 4: ElectricCar (Derived Class)
class ElectricCar extends LuxuryCar {
    private int batteryCapacity; // in kWh

    public ElectricCar(String model, int speed, String interiorType, int batteryCapacity) {
        super(model, speed, "Electric", interiorType);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();  // Call to base class method
        System.out.println("Battery Capacity: " + this.batteryCapacity + " kWh");
    }

    // Public method to display electric-specific features
    public void displayElectricFeatures() {
        System.out.println("Battery Capacity: " + this.batteryCapacity + " kWh");
    }
}

public class Main {
    public static void main(String[] args) {
        // Using polymorphism: creating an array of CarBase type to store different subclasses
        CarBase[] cars = new CarBase[3];

        // Storing different objects (demonstrating polymorphism and abstract class usage) in the CarBase array
        cars[0] = new Car();  // Base Car object
        cars[1] = new LuxuryCar("Mercedes-Benz S-Class", 220, "V8", "Leather");  // LuxuryCar object as CarBase
        cars[2] = new ElectricCar("Tesla Model S", 200, "Futuristic", 100);  // ElectricCar object as CarBase

        // Demonstrating polymorphism in method calls
        for (CarBase car : cars) {
            car.displayDetails();  // Calls the overridden version in the correct subclass
        }

        // Demonstrating static member function usage
        System.out.println("\n--- Static Member Function Demonstration ---");
        Car.displayCarCount();  // Displays count of cars created

        // Using theme to apply various themes on different cars
        Theme theme1 = new Theme("Steampunk", "Retro-Futuristic");  // Applying a theme to different cars
        theme1.applyTheme(cars[1]);
        theme1.applyTheme(cars[2]);

        // Demonstrating static method to display total themes applied
        Theme.displayThemesApplied();
    }
}
