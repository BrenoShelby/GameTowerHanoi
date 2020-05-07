package game;

import tad.Stack;

public class GameHanoi {

    //stack begin (Tower 1)
    private Stack stack0;
    //stack mid (Tower 2)
    private Stack stack1;
    //stack extreme (ToWer 3)
    private Stack stack2;

    //Atributes of the game
    private int numberPlays;
    private int numberDisks;
    
    //Constructor
    public GameHanoi() {}
    public GameHanoi(int numberDisks) {
        //instancing the towers/stacks
        stack0 = new Stack();
        stack1 = new Stack();
        stack2 = new Stack();
        this.numberDisks = numberDisks;
        this.numberPlays = 0;

        //Method to fill the stack0 with the data
        createTower(numberDisks);
    }
    
    //Methods to return stack data and number of the disks
    public Stack getStack0() {
        return stack0;
    }

    public Stack getStack1() {
        return stack1;
    }

    public Stack getStack2() {
        return stack2;
    }

    public int getNumberDisks() {
        return numberDisks;
    }

    //Method to move the data of the tower origin to tower destiny
    public boolean makePlay(Stack towerOrigin, Stack towerDestiny) {
        //Verify if the tower origin is empty, if it's empty throwing a exception
        if (towerOrigin.isEmpty()) {
            throw new RuntimeException("Tower origin is empty!");
        }
        
        //Verify if the tower destiny is empty, if it isn't the data from the tower
        //origin is unstacked and stacked on the tower destiny
        if (towerDestiny.isEmpty()) {
            towerDestiny.push(towerOrigin.pop());
            //the plays counter is incremented
            numberPlays++;
            //the method returns true
            return true;
        }
        //If the tower origin isn't empty, the top from the tower is checked
        //if is higher than the top from the tower destiny
        else {
            if (towerOrigin.peek() > towerDestiny.peek()) {
                //If the top from the tower origin is higher than the top from
                //the tower destiny, is throwing an exception, because that it's
                //against the rules a data with a larger number overlapping a smaller number
                throw new RuntimeException("ERROR: disk origin larger than disk destiny");
            }
            //If the top from the tower origin isn't larger than the top from the
            //tower destiny, then the data from the tower origin is unstacked and
            //stacked on tower destiny
            towerDestiny.push(towerOrigin.pop());
            //the counter plays is incremented
            numberPlays++;
            //method returns true
            return true;
        }
    }
    
    //Method to check whether the game is over or not, for this, the stack0 and stack1 must
    //be empty
    public boolean isFinish() {
        return stack0.isEmpty() && stack1.isEmpty();
    }
    
    //Method override to return the data each stack
    @Override
    public String toString() {
        return "Tower 1: \n" + stack0.toString() + "-----------------------------\n"
                + "Tower 2: \n" + stack1.toString() + "\n-----------------------------\n"
                + "Tower 3: \n" + stack2.toString();
    }
    
    //Method to return the number plays
    public int getNumberPlays() {
        return this.numberPlays;
    }
    
    //Method to return the minimum number plays
    public int getMinimumPlays() {
        return (int) (Math.pow(2, numberDisks) - 1);
    }
    
    //método que preenche a pilha principal, ou seja, a stack0, com os dados
    //que vão de qtd de discos até 1
    
    //Method to fill the stack0 with the data
    private void createTower(int numberDisks) {
        //The data goes from number plays to 1
        for (int i = numberDisks; i >= 1; i--) {
            stack0.push(i);
        }
    }

}
