import java.awt.*;

public class Car implements Movable {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model
    public Point coordinates; // Car coordinates
    private int state = 1;

    // getter-function that returns the number of doors a car has
    public int getNrDoors(){
        return nrDoors;
    }

    // getter-function that returns the engine power of the car
    public double getEnginePower(){
        return enginePower;
    }

    // getter-function that returns the current speed of the car
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    // getter-function that returns the color of the car
    public Color getColor(){
        return color;
    }

    // setter-function to set the color of the car
    public void setColor(Color clr){
        color = clr;
    }

    // function that starts the engine of the car
    public void startEngine(){
        currentSpeed = 0.1;
    }

    // function that stops the engine of the car
    public void stopEngine(){
        currentSpeed = 0;
    }

    // interface
    // potential changes are expected for these methods
    public void move() {
        switch(state){
            case 1:
                coordinates.y += currentSpeed;
            case 2:
                coordinates.x += currentSpeed;
            case 3:
                coordinates.y -= currentSpeed;
            case 4:
                coordinates.x -= currentSpeed;
        }
    }
    public void turnLeft() {
        if(state < 1){
            state = 4;
        }
        else{
            state -= 1;
        }
    }
    public void turnRight() {
        if (state > 4){
            state = 1;
        }
        else {
            state += 1;
        }
    }

}
