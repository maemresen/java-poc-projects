package com.maemresen.hobbyprojects.footballsim;

public class Player {
    Team a;
    String name;
    int goals;
    int assists;
    int vote;

    public Player(String m) {
        name = m;
        goals = 0;

    }

    public void score() {
        goals++;

    }

    public void assist() {
        assists++;
    }

    public Team showPlayersTeam(){

        return a;
    }
    void playersTeam(Team t) {

        a = t;
    }
    public void scoredgoalsnasists() {
        System.out.println(name + "\t" + goals + " " + assists);
    }


    public void vote() {
        vote++;

    }

}