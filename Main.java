// Class 1: Car
class Car {
    // Attributes
    String model;
    int speed;

    // Constructor using 'this' to differentiate between parameters and attributes
    public Car(String model, int speed) {
        this.model = model; // 'this' refers to the class's model attribute
        this.speed = speed; // 'this' refers to the class's speed attribute
    }

    // Member function 1: Display car details
    public void displayDetails() {
        System.out.println("Car Model: " + this.model + ", Speed: " + this.speed + " km/h");
    }

    // Member function 2: Increase speed
    public void increaseSpeed(int increment) {
        this.speed += increment; // Using 'this' to refer to the current object's speed
        System.out.println("New speed of " + this.model + ": " + this.speed + " km/h");
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

    // Member function 2: Display theme details
    public void displayThemeDetails() {
        System.out.println("Theme Name: " + this.themeName + ", Theme Type: " + this.themeType);
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Instantiate an array of Car objects
        Car[] cars = new Car[3];
        cars[0] = new Car("Steampunk Racer", 100);
        cars[1] = new Car("Mad Max Fury", 120);
        cars[2] = new Car("Futuristic Speedster", 150);

        // Display details of all cars in the array
        for (Car car : cars) {
            car.displayDetails();
        }

        // Increase speed for all cars in the array
        for (Car car : cars) {
            car.increaseSpeed(30);
        }

        // Instantiate Theme object
        Theme theme1 = new Theme("Steampunk", "Retro-Futuristic");
        theme1.displayThemeDetails();
        
        // Apply the theme to the first car in the array
        theme1.applyTheme(cars[0]);
    }
}
