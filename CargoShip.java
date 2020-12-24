//Subclass of AbstractClassSpaceShip and implements interface canMove.

public class CargoShip extends AbstractClassSpaceShip implements canMove
{
    //contains both the amount of cargo and the type of ship.
    
    protected int cargo;
    protected String typeName = "Cargo Ship";
    
    //Constructor that accepts name of ship, year built, x and y coordinates,
    //and the amount of cargo. This constructor first calls super class 
    //super class.
    
    public CargoShip(String name, int built, int x, int y, int cargo,
            int type)
    {
        super(name, built, x, y, type);
        this.cargo = cargo;
    }
    
    //override of an abstract method from the superclass. This method 
    //returns the ship type.
    
    @Override
    public int getType()
    {
        return super.type;
    }
    
    //override of an abstract method from the superclass. This method
    //returns the x coordinate.
    
    @Override
    public int getX ()
    {
        return super.x;
    }
    
    //override of an abstract method from the superclass. This method
    //returns the y coordinate.
    
    @Override
    public int getY ()
    {
        return super.y;
    }
    
    //override of an abstract method from the superclass. This method
    //sets the x coordinate.
    
    @Override
    public void setX (int x)
    {
        super.x = x;
    }
    
    //override of an abstract method from the superclass. This method
    //sets the y coordinate.
    
    @Override
    public void setY (int Y)
    {
        super.y = y;
    }
    
    //override of the the to String method. Shows the data of each 
    //instance of an object. 
    
    @Override
    public String toString ()
    {
       String response = "Type: " + this.typeName + "\n" + 
               "Name: " + super.name + "\n" + "Build: " + 
               super.built + "\n" + "X and Y Coordinate:(" + (super.x + 1) + 
               "," + (super.y + 1) + ")\n" + "Cargo: " + this.cargo + "\n";
       return response;
    }
    
    //override of the moveShip method from the canMove interface. 
    //Changes the ships coordinate.
    
    @Override
    public void moveShip(int x, int y) {
        super.x = x;
        super.y = y;
    }
    
}
