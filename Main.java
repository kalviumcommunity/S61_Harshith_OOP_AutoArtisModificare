// Class 1: Car
class Car {
    // Attributes
    String model;
    int speed;

    // Constructor
    public Car(String carModel, int carSpeed) {
        model = carModel;
        speed = carSpeed;
    }

    // Member function 1: Display car details
    public void displayDetails() {
        System.out.println("Car Model: " + model + ", Speed: " + speed + " km/h");
    }

    // Member function 2: Increase speed
    public void increaseSpeed(int increment) {
        speed += increment;
        System.out.println("New speed of " + model + ": " + speed + " km/h");
    }
}

// Class 2: Theme
class Theme {
    // Attributes
    String themeName;
    String themeType;

    // Constructor
    public Theme(String name, String type) {
        themeName = name;
        themeType = type;
    }

    // Member function 1: Apply theme to car
    public void applyTheme(Car car) {
        System.out.println("Applying " + themeName + " (" + themeType + ") theme to " + car.model);
    }

    // Member function 2: Display theme details
    public void displayThemeDetails() {
        System.out.println("Theme Name: " + themeName + ", Theme Type: " + themeType);
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Instantiate Car object
        Car car1 = new Car("Steampunk Racer", 100);
        car1.displayDetails();
        car1.increaseSpeed(20);

        // Instantiate Theme object
        Theme theme1 = new Theme("Steampunk", "Retro-Futuristic");
        theme1.displayThemeDetails();
        theme1.applyTheme(car1);
    }
}
