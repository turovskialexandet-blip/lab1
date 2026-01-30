import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarsJUnitJupiterTests {
    private final Car volvo240 = new Volvo240();
    private final Car saab95 = new Saab95();

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
        assertEquals(4, volvo240.getNrDoors());
        assertEquals(2, saab95.getNrDoors());
        assertEquals(100, volvo240.getEnginePower());
        assertEquals(125,saab95.getEnginePower());
        assertEquals(Color.red,saab95.getColor());
        assertEquals(Color.black,volvo240.getColor());
        assertFalse(saab95.getCurrentSpeed() >0);
        assertFalse(volvo240.getCurrentSpeed() >0);
    }

    @Test
    public void setterTest(){
        // tests setters
        Color beforeS = saab95.getColor();
        saab95.setColor(Color.magenta);
        assertNotSame(beforeS, saab95.getColor());

        Color beforeV = volvo240.getColor();
        volvo240.setColor(Color.cyan);
        assertNotSame(beforeV, volvo240.getColor());
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

    @Test
    public void gas_And_brake(){
        System.out.println("___\nTests gas & brake:");
        volvo240.startEngine();
        volvo240.incrementSpeed(30);
        System.out.printf("Volvo240s speed before: %s.\n", volvo240.getCurrentSpeed());

        volvo240.gas(0.5);
        System.out.printf("Volvo240s speed after 1st gas call: %s.\n", volvo240.getCurrentSpeed());

        volvo240.gas(2);
        System.out.printf("Volvo240s speed after 2nd gas call: %s.\n", volvo240.getCurrentSpeed());

        volvo240.brake(4);
        System.out.printf("Volvo240s speed after 1st brake call: %s.\n", volvo240.getCurrentSpeed());

        volvo240.brake(0.3);
        System.out.printf("Volvo240s speed after 2nd brake call: %s.\n", volvo240.getCurrentSpeed());
    }
}


