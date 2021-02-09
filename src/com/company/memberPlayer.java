package com.company;

public class memberPlayer implements Comparable<memberPlayer>{
    String firstName;
    String lastName;
    int age;
    int team;
    int sortBy = 1;

    public memberPlayer(String firstName, String lastName, int age, int team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;

    }

    public String toString(){
        return "Name: "+ firstName +" "+ lastName +", age: "+ age +", plays on team " + team + ".";
    }

    @Override
    public int compareTo(memberPlayer otherPlayer) {

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