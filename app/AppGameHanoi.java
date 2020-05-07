package app;

import game.GameHanoi;
import java.util.Scanner;
import tad.Stack;

public class AppGameHanoi {

    public static void main(String[] args) {
        //Class for data enter
        Scanner enter = new Scanner(System.in);
        //Game class reference
        GameHanoi game;
        //variable to store data enter
        int numberDisks;
        //Stack class reference
        Stack towerOrigin;
        Stack towerDestiny;
        
        //Begin of the Game
        System.out.println("**************GAME TOWER OF HANOI**************\n");
        
        //Loop for the game doesn't finish while it doesn't have been finished
        do{
            //Number of the disks enter that user wants
            System.out.println("How many disks do you want to start the game? ");
            numberDisks = enter.nextInt();
            
            //If it's less or equals to 0, throws a warning
            if(numberDisks < 3)
                System.out.println("The number of the disks must not less than 3!\n");
            
        }while(numberDisks < 3);
        
        //Instancing a game class
        game = new GameHanoi(numberDisks);
        //variables who will store, in this case on number, the tower origin and the tower destiny
        int origin;
        int destiny;

        do {
            //visualization of the towers
            System.out.println("************************************************");
            System.out.println(game);
            
            do {
                //Destiny tower and origin tower enter
                System.out.println("Enter which tower (1, 2 or 3) you want to unstack and then the tower will be stacked: ");
                origin = enter.nextInt();
                destiny = enter.nextInt();
                
                //If the data enter doesn't get between 1 and 3, throws a warning
                if ((origin > 3 || origin <= 0) || (destiny > 3 || destiny <= 0))
                    System.out.println("Tower(s) invalid(s)!\n");

            } while ((origin > 3 || origin <= 0) || (destiny > 3 || destiny <= 0));
            
            //Method returns the stack corresponding to the tower that user typed
            towerOrigin = enumereteTower(origin, game);
            towerDestiny = enumereteTower(destiny, game);
            
            //catch the exception throws by method makePlay of the class GameHanoi
            try {
                //If the play to be successfully done
                if (game.makePlay(towerOrigin, towerDestiny))
                    System.out.println("Successfully done move!\n");
                //If the play to be invalid
                else
                    System.out.println("Invalid move!\n");
            } catch (RuntimeException e) {
                System.out.println("ERROR: Tower origin empty or movement invalid!\n");;
            }
            
            //Game progress description
            System.out.println("Number of the disks: " + game.getNumberDisks());
            System.out.println("Number of the plays: " + game.getNumberPlays());
            System.out.println("Minimum number of the plays: " + game.getMinimumPlays());
            
        } while (!game.isFinish());
        
        //Method to throws a warning to the user, if he has finished the game
        messageWinner(game);
    }
    
    //Methd to enumerete towers
    public static Stack enumereteTower(int tower, GameHanoi game) {
        switch (tower) {
            case 1:
                //Tower 1
                return game.getStack0();
            case 2:
                //Tower 2
                return game.getStack1();
            case 3:
                //Tower 3
                return game.getStack2();
        }
        
        return null;
    }
    
    public static void messageWinner(GameHanoi game){
        //If the number of the plays to be equals to minimum number of the plays,
        //according to the quantity of the disks, will be throws this message
        if(game.getMinimumPlays() == game.getNumberPlays())
            System.out.println("\nCongratulations, you have successfully solved the Tower of Hanoi with " + game.getNumberPlays() + " plays!");
        else
            //If this number doesn't equal, the user will receive an information
            //that he isn't catched up the minimum number of the plays
            System.out.println("\nCongratulations, you have successfully solved the Tower of Hanoi with " + game.getNumberPlays() + " plays, but you can improve!"
                    + " The minimum number of the plays is " + game.getMinimumPlays());
    }
}
