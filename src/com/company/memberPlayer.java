package com.company;

public class MemberPlayer implements Comparable<MemberPlayer>{
    int playerID;
    String firstName;
    String lastName;
    int age;
    int team;
    static int sortBy;
    static int nextID = 1;

    public MemberPlayer(String firstName, String lastName, int age, int team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
        playerID = nextID;
        nextID++;

    }

    public String toString(){
        return playerID+ ". " +firstName +" "+ lastName +", age: "+ age +", plays on team " + team + ".";
    }

    @Override
    public int compareTo(MemberPlayer otherPlayer) {

        switch(sortBy){
            case 1:
                return firstName.compareTo(otherPlayer.firstName);
            case 2:
                return lastName.compareTo(otherPlayer.lastName);
            case 3:
                return age - otherPlayer.age;
            case 4:
                return team - otherPlayer.team;
            default:
                return 0;
        }

    }
}
