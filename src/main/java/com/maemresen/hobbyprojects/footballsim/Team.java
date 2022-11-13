package com.maemresen.hobbyprojects.footballsim;

public class Team {


    String ist;
    String name;
    int played;
    int wins;
    int draws;
    int losses;
    int scored;
    int conceded;
    int points;
    int assist;
    int goaldifference;
    Player[] teamsheet;

    public Team(String nm, int n) {
        name = nm;
        teamsheet = new Player[n];

    }

    void addPlayer(Player a, int b, Team h) {
        teamsheet[b] = a;
        a.playersTeam(h);

    }



    public int Goaldifference() {
        return scored - conceded;
    }

    public String teamStatistics() {
        return name + "\t" + played + " "
                + wins + " "
                + draws + " "
                + losses + " "
                + scored + ":"
                + conceded + "\t"
                + points + "\t"
                + Goaldifference();

    }
}
