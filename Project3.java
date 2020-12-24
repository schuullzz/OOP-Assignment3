import java.util.*;

public class Project3 {
    public static void main (String args[])
    {
        //Creates a scanner object to take in user input.
        
        Scanner input = new Scanner (System.in);
        
        int numberOfShips;
        int shipType;
        String shipName;
        int buildYear;
        int x;
        int y;
        int cargo;
        int booty;
        int shipChoice;
        int choice;
        int moveX;
        int moveY;
        int breaker = 0;
        
        //Creates the space map [0-9] [0-9]
        
        String [][] spaceCoordinate = new String [10][10];
        
        //Creates an Arraylist of the data type AbstractClassSpaceShip.
        
        ArrayList<AbstractClassSpaceShip> ship = new ArrayList<>();
        
        //Fills up the space matrix with empty spaces |**|
        
        for (int z = 0; z < spaceCoordinate.length; z++)
        {
            for (int i = 0; i < spaceCoordinate[0].length; i++)
            {
                spaceCoordinate[z][i] = "|**|";
            }
        }
        
        //This do-while loop makes sure the user only enters a number 1-9.
        
        do
        {
            System.out.println("Enter how many ships you would like (1-9).");
            numberOfShips = input.nextInt();
            
        }while(numberOfShips < 1 || numberOfShips > 9);
        
        //This for loop creates instances of CargoShip and PirateShip 
        //depending on user input.
        
        for(int z = 1; z <= numberOfShips; z++)
        {
            //This do-while makes sure user choice of type of ship is 
            //either cargo or pirate.
            
            do
            {
                System.out.println("What would you like ship " + z +
                        " to be? (1.Cargo or 2.Pirate)");
                shipType = input.nextInt();
            
            }while( shipType <= 0 || shipType >= 3);
            
            //If user choice is a Cargo ship then the user is asked for the
            //ships name, build year, x coordinate, y coordinate, and makes
            //sure that no other ship is at the coordinate.
            
            if(shipType == 1)
            {
                System.out.println("What the ships name?");
                shipName = input.next();
                
                System.out.println("What year was this ship built?");
                buildYear = input.nextInt();
                
                //This do-while loop makes sure that the coordinates are 
                //within the bounds of the matrix and that there is not
                //another ship in that coordinate.
                
                do
                {
                    breaker = 0;
                    do
                    {
                        System.out.println("What is the x coordinate? (1-10)");
                        x = input.nextInt();
                        x = x - 1;
                    }while(x < 0 || x > 10);
                
                    do
                    {
                        System.out.println("What is the y coordinate? (1-10)");
                        y = input.nextInt();
                        y = y - 1;
                    }while(y < 0 || y > 10);
                    
                    if (!spaceCoordinate[x][y].equals("|**|"))
                    {
                        System.out.println("There is already a ship there." +
                                "Pick new coordinates.");
                        breaker = 1;
                    }
                    
                }while(breaker ==1);
                
                //Asks user to enter amount of cargo.
                
                System.out.println("How much cargo does the ship have?");
                cargo = input.nextInt();
                
                System.out.print("\n");
                  
                //adds the new instance of cargo ship and feeds the required 
                //information to the CargoShip class constructor.
                
                ship.add(new CargoShip(shipName, buildYear, x, y, cargo,
                shipType));
               
                //Places ship on the space map.
                
                spaceCoordinate = placement(ship, spaceCoordinate);
                
                //Calls this method to display the space map.
                
                display(spaceCoordinate);
                
                //Calls the method to display the ships attributes.
                
                displayShipStats(ship);
            }
            
            //If user choice is a Pirate ship then the user is asked for the
            //ships name, build year, x coordinate, y coordinate, and makes
            //sure that no other ship is at the coordinate.
            
            else if (shipType == 2)
            {
                //This do-while makes sure user choice of type of ship is 
                //either cargo or pirate.
                
                System.out.println("What the ships name?");
                shipName = input.next();
                
                System.out.println("What year was this ship built?");
                buildYear = input.nextInt();
                
                //If user choice is a Pirate ship then the user is asked for the
                //ships name, build year, x coordinate, y coordinate, and makes
                //sure that no other ship is at the coordinate.
                
                do
                {
                    breaker = 0;
                    do
                    {
                        System.out.println("What is the x coordinate? (1-10)");
                        x = input.nextInt();
                        x = x - 1;
                    }while(x < 0 || x > 10);
                
                    do
                    {
                        System.out.println("What is the y coordinate? (1-10)");
                        y = input.nextInt();
                        y = y - 1;
                    }while(y < 0 || y > 10);
                    
                    if (!spaceCoordinate[x][y].equals("|**|"))
                    {
                        System.out.println("There is already a ship there. " +
                                "Pick new coordinates.");
                        breaker = 1;
                    }
                    
                }while(breaker ==1);
                 
                //Asks user for the amount of booty.
                
                System.out.println("How much booty does the ship have?");
                booty = input.nextInt();
                
                System.out.print("\n");
                
                //adds the new instance of cargo ship and feeds the required 
                //information to the CargoShip class constructor.
                
                ship.add(new PirateShip(shipName, buildYear, x, y, booty,
                shipType));
                
                //Places the new ship on the space map.
                
                spaceCoordinate = placement(ship, spaceCoordinate);
                
                //method displays where the ship is on the map.
                
                display(spaceCoordinate);
                
                //method displays the ships attributes.
                
                displayShipStats(ship);
                
            }
        }
        
        //Prompts user what ship they would like to control through a method.
        
        shipChoice = shipControl(ship);
        
        System.out.print("\n");
        
        //do-while that exits out when users chooses option 4 (exit).
        
        do
        {
            //displays the menu and retrieves users choice.
            
            choice = displayMenuChoice();
            
                switch (choice) {
                case 1:
                    do
                    {
                        breaker = 0;
                        
                        //do-while loop that makes sure the user enters a
                        //coordinates within the matrix.
                        
                        do
                        {
                            System.out.println("What would you like the x "
                                    + "coordinate to be? (1-10)");
                            moveX = input.nextInt();
                            
                        }while(moveX < 1 || moveX > 10);
                        
                        do
                        {
                            System.out.println("What would you like the y" +
                                    "coordinate to be? (1-10)");
                            moveY = input.nextInt();
                            
                        }while(moveY < 1 || moveY > 10);
                        
                        //Adapts the users input to fit the range [0-9] [0-9].
                        
                        moveX = moveX - 1;
                        moveY = moveY - 1;
                        
                        //Makes sure there is not already a ship at user 
                        //input location.
                        
                        if (!spaceCoordinate[moveX][moveY].equals("|**|"))
                        {
                            System.out.println("There is already a ship "
                                    + "there. Pick new coordinates.");
                            breaker = 1;
                        }
                        
                    }while(breaker == 1);
                    
                    //If the ship is a Cargo ship.
                    
                    if(ship.get(shipChoice).type == 1)
                    {
                        //Replaces where the ship was to vacant space.
                        
                        spaceCoordinate [ship.get(shipChoice).x]
                                [ship.get(shipChoice).y] = "|**|";
                        
                        //Uses the interface to move the ships location.
                        
                        ship.get(shipChoice).moveShip(moveX, moveY);
                        
                        //Puts the ship in the new coordinate on the space
                        //map
                        
                        spaceCoordinate = placement(ship, spaceCoordinate);
                        
                        //Displays map of space.
                        
                        display(spaceCoordinate);
                        
                        //Displays the attributes of the ships.
                        
                        displayShipStats(ship);
                    }
                    
                    //If the ship is Pirate Ship.
                    
                    else if(ship.get(shipChoice).type == 2)
                    {
                        //Replaces where the ship was with vacant space.
                        
                        spaceCoordinate [ship.get(shipChoice).x]
                                [ship.get(shipChoice).y] = "|**|";
                        
                        //Uses the interface to move the ships location.
                        
                        ship.get(shipChoice).moveShip(moveX, moveY);
                        
                        //Puts the ship in the new coordinate on the space
                        //map.
                        
                        spaceCoordinate = placement(ship, spaceCoordinate);
                        
                        //Displays the space map.
                        
                        display(spaceCoordinate);
                        
                        //Displays ships attributes.
                        
                        displayShipStats(ship);
                    }       break;
                    
                //Changes which ship the user controls.
                    
                case 2:
                    //Retrieves the users ship choice.
                    
                    shipChoice = shipControl(ship);
                    
                    //Displays the space map.
                    
                    display(spaceCoordinate);
                    
                    //Displays the ships attributes.
                    
                    displayShipStats(ship);
                    break;
                case 3:
                    
                    //Replaces where the ship was with empty spaces.
                    
                    spaceCoordinate [ship.get(shipChoice).x]
                            [ship.get(shipChoice).y] = "|**|";
                    
                    //If ship is Cargo ship then it is turned into a Pirate ship.
                    
                    if (ship.get(shipChoice).type == 1)
                    {
                        //Asks user to enter the ships name and the year it
                        //was built.
                        
                        System.out.println("What the ships name?");
                        shipName = input.next();
                        
                        System.out.println("What year was this ship built?");
                        buildYear = input.nextInt();
                        
                        //Do-while loops that make sure both x and y coordinates
                        //are in correct range.
                        
                        do{
                            breaker = 0;
                            
                            do
                            {
                                System.out.println("What is the x " +
                                    "coordinate? (1-10)");
                                x = input.nextInt();
                                x = x - 1;
                            }while(x < 0 || x > 10);
                        
                            do
                            {
                                System.out.println("What is the y " +
                                    "coordinate? (1-10)");
                                y = input.nextInt();
                                y= y -1;
                            }while(y < 0 || y > 10);
                            
                            if (!spaceCoordinate[x][y].equals("|**|"))
                            {
                                System.out.println("There is already a ship "
                                    + "there. Pick new coordinates.");
                                breaker = 1;
                            }
                            
                        }while(breaker == 1);
                        
                        //Asks user for the amount of booty the ship has.
                        
                        System.out.println("How much booty does the "
                                + "ship have?");
                        booty = input.nextInt();
                        
                        //removes the previous ship.
                        
                        ship.remove(shipChoice);
                        
                        //adds a new pirate ship to the array list.
                        
                        ship.add(shipChoice, new PirateShip(shipName, 
                                buildYear, x, y,booty, 2));
                    }
                    
                    //If the ship is a pirate ship it is changed to Cargo.
                    
                    else if (ship.get(shipChoice).type == 2)
                    {
                        //Asks user what the ships name is and the year it
                        //was built.
                        
                        System.out.println("What the ships name?");
                        shipName = input.next();
                        
                        System.out.println("What year was this ship built?");
                        buildYear = input.nextInt();
                        
                        //do-while loops make sure that the coordinates 
                        //fall within the right ranges.
                        
                        do{
                            breaker = 0;
                            
                            do
                            {
                                System.out.println("What is the x " +
                                    "coordinate? (1-10)");
                                x = input.nextInt();
                                x = x - 1;
                            }while(x < 0 || x > 10);
                        
                            do
                            {
                                System.out.println("What is the y " +
                                    "coordinate? (1-10)");
                                y = input.nextInt();
                                y= y -1;
                            }while(y < 0 || y > 10);
                            
                            if (!spaceCoordinate[x][y].equals("|**|"))
                            {
                                System.out.println("There is already a ship "
                                    + "there. Pick new coordinates.");
                                breaker = 1;
                            }
                            
                        }while(breaker == 1);
                        
                        //Asks user how much cargo the ship has.
                        
                        System.out.println("How much cargo does the "
                                + "ship have?");
                        cargo = input.nextInt();
                        
                        //Removes previous ship.
                        
                        ship.remove(shipChoice);
                        
                        //Adds the new pirate ship to the array list.
                        
                        ship.add(shipChoice, new CargoShip(shipName, buildYear,
                                x, y, cargo, 1));
                    }       
                    
                    //Places the ship in the space map.
                    
                    spaceCoordinate = placement(ship, spaceCoordinate);
                    
                    //Displays the space map.
                    
                    display(spaceCoordinate);
                    
                    //Displays the ships attributes.
                    
                    displayShipStats(ship);
                    break;
                default:
                    break;
            }
      }while(choice != 4);
    }
    
    //Methods used in the program   
    
    //Takes in an arraylist and matrix. Returns matrix with the ship in the 
    //correct location on the map.
    
    public static String [][] placement(ArrayList<AbstractClassSpaceShip> ship,
            String [][] spaceCoordinate)
    {
        for(int w = 0; w < ship.size(); w++)
        {
            if(ship.get(w).type == 1)
            {
                spaceCoordinate[ship.get(w).getY()]
                    [ship.get(w).getX()] = "|C" + w + "|";
            }
            else if (ship.get(w).type == 2)
            {
                spaceCoordinate[ship.get(w).getY()]
                    [ship.get(w).getX()] = "|P" + w + "|";
            }
        }
        
        return spaceCoordinate;
    }
    
    //Takes in matrix and displays it.
    
    public static void display(String [][] spaceCoordinate)
    {
        for (int w = 0; w < spaceCoordinate.length; w++)
        {
            for (int i = 0; i < spaceCoordinate[0].length; i++)
            {
                System.out.print(spaceCoordinate[w][i]); 
            }
                    
            System.out.print("\n");
        }
    }
    
    //Takes in array list and displays the attributes of each of the ships.
    
    public static void displayShipStats(ArrayList<AbstractClassSpaceShip> ship)
    {
            System.out.print("\n");
            System.out.println("Space Ships: \n");
                
            for (int w = 0; w < ship.size(); w++)
            {
                System.out.println(ship.get(w).toString());
            }
    }
    
    //Takes in array list and changes what ship is being controlled by user.
    //It returns the users choice.
    
    public static int shipControl(ArrayList<AbstractClassSpaceShip> ship1)
    {
        Scanner input = new Scanner (System.in);
        String control;
        int breaker =0;
        int shipChoice = 0;
        
      //do-while loop that makes sure the user enters a name of a ship.  
      
      do
        {
            System.out.println("What ship would you like to control?");
            control = input.next();
            
            for(int w = 0; w < ship1.size(); w++)
            {
                if(control.equals(ship1.get(w).name))
                {
                  breaker = 1; 
                  shipChoice = w;
                }
            }
            
        }while(breaker == 0);
    
        return shipChoice;
    }
    
    //Display menu of possible choices. Returns users choice.
    
    public static int displayMenuChoice()
    {
        Scanner input = new Scanner (System.in);
        int choice;
        
       do
        {
            System.out.println("What action would you like to perform?");
            System.out.println("1. Move Ship" + "\n" + "2. Change Control" +
                    "\n" + "3. Change Ship Type" + "\n" + "4. Exit" + "\n");
            choice = input.nextInt();
            
        }while(choice > 4 || choice < 1); 
       
       return choice;
    }
    
}
        
        