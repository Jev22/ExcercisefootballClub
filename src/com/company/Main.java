package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<memberPlayer> allPlayerList = new ArrayList<>();

    public static void main(String[] args) {
        tempPlayerList();
        runMainSwitchMenu();
    }

    private static void tempPlayerList() {
        allPlayerList.add(new memberPlayer( "Jesper", "Nielsen", 32, 1));
        allPlayerList.add(new memberPlayer( "Biggus","Dickus",34,1));
        allPlayerList.add(new memberPlayer( "John","Dillermand",34,1));
        allPlayerList.add(new memberPlayer("Thor","Andersen",22,1));
        allPlayerList.add(new memberPlayer("Hans", "Clausen", 34, 1));
        allPlayerList.add(new memberPlayer("Henning", "Dillermand", 25, 2));
        allPlayerList.add(new memberPlayer("Jens", "Mogensen", 22, 2));
        allPlayerList.add(new memberPlayer("Ice", "Wallowcome", 17, 2));
        allPlayerList.add(new memberPlayer("Roberto", "Carlos", 34, 1));

        //team.add(new memberPlayer();
    }

    private static void runMainSwitchMenu() {
        Scanner input = new Scanner(System.in);
        boolean runMainMenu=true;
        while(runMainMenu) {
            mainSwitchMenuText();
            int myChoice = input.nextInt();
            switch (myChoice){
                case 1:
                    allPlayerList.add(createNewPlayer());
                    break;
                case 2:
                    runPrintPlayerMenu();
                    System.out.println("All Players: ");
                    for(memberPlayer player:allPlayerList){
                        System.out.println(player);
                    }
                    System.out.println();
                    break;
                case 0:
                    runMainMenu = false;
                    break;
            }
        }

    }

    private static void runPrintPlayerMenu() {

        Scanner input = new Scanner(System.in);
        boolean runSortMenu = true;
        while (runSortMenu){
            showPrintMenuText();
            int menuChoice = input.nextInt();

            switch (menuChoice){
                case 1:
                    System.out.println("Sorted by first name");
                    sortByFirstNamePrint();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Sorted by last name");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Sorted by age");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Sorted by team");
                    System.out.println();
                    break;
                case 0:
                    runSortMenu = false;

                default:
            }

        }


    }

    private static void sortByFirstNamePrint() {
        List<memberPlayer> byFirstNameList = new ArrayList<>();

        for(memberPlayer fnPlayer: allPlayerList){
            fnPlayer.sortBy = 1;
            byFirstNameList.add(fnPlayer);
        }
        Collections.sort(byFirstNameList);
        printList(byFirstNameList);
    }

    private static void printList(List<memberPlayer> listInput) {
        for(memberPlayer player:listInput){
            System.out.println(player);
        }
        System.out.println();

    }

    private static void showPrintMenuText() {
        System.out.println("Choose which list you want to print: ");
        System.out.println("1. Print sorted after first name.");
        System.out.println("2. Print sorted after last name.");
        System.out.println("3. Print sorted after age.");
        System.out.println("4. Print sorted after team.");
        System.out.println("0. To leave.");
    }

    private static void mainSwitchMenuText() {
        System.out.println("Main Menu - pick option:");
        System.out.println("1. Create new player");
        System.out.println("2. Print players");
        System.out.println("0. Exit Menu");
    }

    public static memberPlayer createNewPlayer(){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Enter player age: ");
        int age = input.nextInt();
        System.out.println("Place player on team (1 or 2): ");
        int team = input.nextInt();

        return new memberPlayer(firstName, lastName, age, team);

    }

    private static int nextPlayerId() {

        return 0;
    }
}


/*

1. Make a class representing a memberPlayer
    - Fields: String firstName, String lastName, int age, int team. (tjek)

2. make a main menu
    - create new memberPlayer object (Tjek)
    - Sort list object field:
        - firstName, lastName, age, team
    - Search for player (lastName)
    - Delete a player
    - Search and list for first team players
    - Search and list for second team players
    - Search within an age interval

3. Create all Methods

4. Create filehandling
    - Read players from file
    - safe created players to file.


5.

6. Compile, shout, fix, repeat.
 */