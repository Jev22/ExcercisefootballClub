package com.company;

import java.util.*;

public class Main {

    static List<MemberPlayer> allPlayerList = new LinkedList<>();
    static CustomLinkedList testList = new CustomLinkedList();
    public static void main(String[] args) {
        //generatePlayerList();
        generateCustomPlayerList();
        runMainSwitchMenu();
    }

    private static void generatePlayerList() {
        allPlayerList.add(new MemberPlayer( "Jesper", "Nielsen", 32, 1));
        allPlayerList.add(new MemberPlayer( "Biggus","Dickus",34,1));
        allPlayerList.add(new MemberPlayer( "John","John",34,1));
        allPlayerList.add(new MemberPlayer("Thor","Andersen",22,1));
        allPlayerList.add(new MemberPlayer("Hans", "Clausen", 34, 1));
        allPlayerList.add(new MemberPlayer("Henning", "John", 25, 2));
        allPlayerList.add(new MemberPlayer("Jens", "Mogensen", 22, 2));
        allPlayerList.add(new MemberPlayer("Vanilla", "Ice", 17, 2));
        allPlayerList.add(new MemberPlayer("Roberto", "Carlos", 34, 1));

        //team.add(new memberPlayer();
    }
    private static void generateCustomPlayerList() {
        testList.add(new MemberPlayer( "Jesper", "Nielsen", 32, 1));
        testList.add(new MemberPlayer( "Biggus","Dickus",34,1));
        testList.add(new MemberPlayer( "John","John",34,1));
        testList.add(new MemberPlayer("Thor","Andersen",22,1));
        testList.add(new MemberPlayer("Hans", "Clausen", 34, 1));
        testList.add(new MemberPlayer("Henning", "John", 25, 2));
        testList.add(new MemberPlayer("Jens", "Mogensen", 22, 2));
        testList.add(new MemberPlayer("Vanilla", "Ice", 17, 2));
        testList.add(new MemberPlayer("Roberto", "Carlos", 34, 1));

        //testList.add(new memberPlayer();
        System.out.print(testList);
        System.out.println("Player count: "+testList.size()+"\n");
    }
    private static void runMainSwitchMenu() {
        Scanner input = new Scanner(System.in);
        boolean runMainMenu=true;
        while(runMainMenu) {
            mainSwitchMenuText();
            int myChoice = input.nextInt();
            switch (myChoice){
                case 1:
                    testList.add(createNewPlayer());
                    break;
                case 2:
                    printTeamListMenu();
                    break;
                case 3:
                    deletePlayer();
                    break;
                case 0:
                    runMainMenu = false;
                    break;
            }
        }

    }

    private static void printTeamListMenu() {

        Scanner input = new Scanner(System.in);
        boolean runSortMenu = true;
        while (runSortMenu){
            showPrintMenuText();
            int menuChoice = input.nextInt();

            switch (menuChoice){
                case 1:
                    System.out.println("Sorted by first name");
                    printSortedList(1);
                    break;
                case 2:
                    System.out.println("Sorted by last name");
                    printSortedList(2);
                    break;
                case 3:
                    System.out.println("Sorted by age");
                    printSortedList(3);
                    break;
                case 4:
                    System.out.println("Sorted by team");
                    printSortedList(4);
                    break;
                case 0:
                    runSortMenu = false;
            }

        }

    }

    private static void printSortedList(int sortByChoice) {
        //det her er nyt
        CustomLinkedList sortedTestList = new CustomLinkedList();
        sortedTestList.addAll(testList);
        MemberPlayer.sortBy = sortByChoice;

        //det her er det gamle
        List<MemberPlayer> sortedList = new ArrayList<>();
        sortedList.addAll(allPlayerList);//den er ny
        MemberPlayer.sortBy = sortByChoice;
        Collections.sort(sortedList);

        printList(sortedList);
        System.out.println();
    }

// Sorter efter fornavn i omvendt rækkefølge (test)
//    private static void sortByFirstNamePrint() {
//        List<memberPlayer> byFirstNameList = new ArrayList<>();
//
//        for(memberPlayer fnPlayer: allPlayerList){
//            fnPlayer.sortBy = 1;
//            byFirstNameList.add(fnPlayer);
//        }
//        Collections.sort(byFirstNameList, Collections.reverseOrder());
//        printList(byFirstNameList);
//    }
//

    private static void deletePlayer() {
        printList(allPlayerList);
        System.out.println("Write the first name of the player you want to delete");
        Scanner input = new Scanner(System.in);
        String chosenPlayer = input.next();
        for(MemberPlayer player:allPlayerList){
           if (player.firstName.equalsIgnoreCase(chosenPlayer)) {
               allPlayerList.remove(player);
               break;
            }

        }
        printList(allPlayerList);

    }

    private static void printList(List<MemberPlayer> listInput) {
        for(MemberPlayer player:listInput){
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
        System.out.println("3. Delete player");
        System.out.println("0. Exit Menu");
    }

    public static MemberPlayer createNewPlayer(){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Enter player age: ");
        int age = input.nextInt();
        System.out.println("Place player on team (1 or 2): ");
        int team = input.nextInt();

        return new MemberPlayer(firstName, lastName, age, team);

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