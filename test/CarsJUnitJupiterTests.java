import org.junit.jupiter.api.Test;

import java.awt.*;

public class CarsJUnitJupiterTests {
    private final Volvo240 volvo240 = new Volvo240();
    private final Saab95 saab95 = new Saab95();

    @Test
    public void initTest(){
        // tests initialization
        System.out.println("___\nTests initialization:");
        System.out.println(volvo240);
        System.out.println(saab95);
    }

    @Test
    public void getterTest(){
        // tests getters
        System.out.println("___\nTests getters:");
        System.out.printf("Volvo240 numDoors: %s, Saab95 numDoors: %s.\n", volvo240.getNrDoors(), saab95.getNrDoors());
        System.out.printf("Volvo240 color: %s, Saab95 color: %s.\n", volvo240.getColor(), saab95.getColor());
        System.out.printf("Volvo240 speed: %s, Saab95 speed: %s.\n", volvo240.getCurrentSpeed(), saab95.getCurrentSpeed());
    }

    @Test
    public void setterTest(){
        // tests setters
        System.out.println("___\nTests setters:");
        System.out.printf("Saab95s color before: %s.\n", saab95.getColor());
        saab95.setColor(Color.magenta);
        System.out.printf("Saab95s color now: %s.\n", saab95.getColor());

        System.out.printf("Volvo240s color before: %s.\n", volvo240.getColor());
        volvo240.setColor(Color.cyan);
        System.out.printf("Volvo240s color now: %s.\n", volvo240.getColor());
    }

    @Test
    public void movement_And_rotationTest(){
        // tests the movement of the cars
        System.out.println("___\nTests movement:");
        volvo240.startEngine();
        System.out.printf("Volvo240s speed before: %s.\n", volvo240.getCurrentSpeed());
        volvo240.incrementSpeed(10);
        System.out.printf("Volvo240s speed now: %s.\n", volvo240.getCurrentSpeed());

        System.out.printf("Volvo240s coords before: %s.\n", volvo240.coordinates);
        for (int i = 0; i < 2; i++){
            volvo240.turnRight();
            volvo240.move();
            volvo240.turnLeft();
            volvo240.move();
        }
        System.out.printf("Volvo240s coords now: %s.\n", volvo240.coordinates);

        for (int i = 1; i < 3; i++){
            volvo240.decrementSpeed(i);
            volvo240.move();
            System.out.printf("Volvo240s coords after decrement %s: %s.\n", i, volvo240.coordinates);
        }

        volvo240.stopEngine();
        volvo240.move();
        System.out.printf("Volvo240s coords after stop: %s.\n", volvo240.coordinates);

    }
}
