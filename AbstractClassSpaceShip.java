//Super class

public abstract class AbstractClassSpaceShip implements canMove{
    
    //Protected Variables.
    
    protected String name; 
    protected int built;
    protected int x;
    protected int y;
    protected int type;
    
    //Constructor that accepts ship name, the year it was built, the x
    //coordinate, and the type of ship.
    
    public AbstractClassSpaceShip(String name, int built, int x, int y,
            int type)
    {
        this.name = name;
        this.built = built;
        this.x = x;
        this.y = y;
        this.type = type;
        
    }
    
    //Abstract methods.
    
    abstract int getType();
    
    abstract int getX ();
    
    abstract int getY ();
    
    //takes an integer.
    
    abstract void setX (int x);
    
    //takes an integer.
    
    abstract void setY (int y);
    
    //Override of toString method.
    
    @Override
    public String toString()
    {
        String response;
        response = "Name: " + this.name + "\n" +
                "Built: " + this.built + "\n";
        return response;
    }
}
