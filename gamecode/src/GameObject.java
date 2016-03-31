public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    int x;
    int y;

    //The direction of the object
    boolean facingRight;

    //Returns the x-coordinate
    public int getX(){
        return x;
    }

    //Returns the y-coordinate
    public int getY(){
        return y;
    }

    //Moves the object a set amount both along the y and x-axis
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
}
