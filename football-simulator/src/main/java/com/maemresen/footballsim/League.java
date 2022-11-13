package com.maemresen.footballsim;

public class League {

    String name;
    Team[] teams;
    Team[][] teams2;

    Match[] fixture;

    int nofp;
    int noft;
    Player lplayers[];

    public void wr(String c) {
        System.out.println(c);
    }

    public League(String nm, int n, int m) {
        name = nm;
        noft = n;
        nofp = m;
        lplayers = new Player[nofp * noft];
        teams = new Team[n];
        teams2 = new Team[teams.length / 2][teams.length / 2];

        fixture = new Match[n * (n - 1)];

    }

    void addTeam(Team a, int b) {
        teams[b] = a;

    }

    public void addPlayersToLeague() {

        int temp = 0;
        for (int i = 0; i < noft; i++) {

            for (int j = 0; j < nofp; j++) {
                lplayers[temp] = teams[i].teamsheet[j];
                temp++;
            }

        }

    }

    public boolean isBestScorer(int a, int b) {

        if (lplayers[a].goals == lplayers[b].goals) {
            return lplayers[a].vote > lplayers[b].vote;
        }
        return lplayers[a].goals > lplayers[b].goals;
    }

    public boolean isBestAsister(int a, int b) {

        if (lplayers[a].assists == lplayers[b].assists) {
            return lplayers[a].vote > lplayers[b].vote;
        }
        return lplayers[a].assists > lplayers[b].assists;
    }

    public boolean isBestPlayer(int a, int b) {
        return lplayers[a].vote > lplayers[b].vote;
    }

    public void bestScorer() {
        Player p;
        for (int i = 1; i < lplayers.length; i++) {
            for (int j = 0; j < lplayers.length - i; j++) {
                if (isBestScorer(j, j + 1)) {
                    p = lplayers[j];
                    lplayers[j] = lplayers[j + 1];
                    lplayers[j + 1] = p;
                }
            }
        }
        System.out.println("-----------Best 10 Scorers-----------------");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + ". " + lplayers[lplayers.length - 1 - i].name + ": "
                    + lplayers[lplayers.length - 1 - i].goals);
        }
    }

    public void bestAsister() {
        Player p;
        for (int i = 1; i < lplayers.length; i++) {
            for (int j = 0; j < lplayers.length - i; j++) {
                if (isBestAsister(j, j + 1)) {
                    p = lplayers[j];
                    lplayers[j] = lplayers[j + 1];
                    lplayers[j + 1] = p;
                }
            }
        }
        System.out.println("-----------Best 10 Assist com.maemresen.footballsim.Player-----------");

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + ". " + lplayers[lplayers.length - 1 - i].name + ": "
                    + lplayers[lplayers.length - 1 - i].assists);
        }
    }

    public void bestPlayers() {

        Player p;
        for (int i = 1; i < lplayers.length; i++) {
            for (int j = 0; j < lplayers.length - i; j++) {
                if (isBestPlayer(j, j + 1)) {
                    p = lplayers[j];
                    lplayers[j] = lplayers[j + 1];
                    lplayers[j + 1] = p;
                }
            }
        }
        System.out.println("------------------Votes--------------------");

        for (int i = 0; i < lplayers.length; i++) {
            System.out.println(i + 1 + ". " + lplayers[lplayers.length - 1 - i].name + " with "
                    + lplayers[lplayers.length - 1 - i].vote + " vote");
            if (lplayers[lplayers.length - 2 - i].vote == 0) {
                break;
            }
        }
        System.out.println("*******************************************");
        System.out.println("-----------Best VI of THE SEASON-----------");
        System.out.println("*******************************************");
        for (int i = 0; i < 6; i++) {

            System.out.println(i + 1 + ". " + lplayers[lplayers.length - 1 - i].name + " with "
                    + lplayers[lplayers.length - 1 - i].vote + " vote");
        }
    }

    public void playerStatictics() {

        System.out.println("---------------------------");

        for (int j = 0; j < noft; j++) {
            System.out.println(teams[j].name + "'s Players Scores/Assists");
            System.out.println("---------------------------");
            for (int i = 0; i < teams[j].teamsheet.length; i++) {
                teams[j].teamsheet[i].scoredgoalsnasists();

            }

            System.out.println("---------------------------");
        }
    }

    public void createFixture() {

        for (int j = 0; j < teams.length; j++) {
            if (j < teams.length / 2) {
                teams2[0][j] = teams[j];
            } else {
                teams2[1][teams.length - 1 - j] = teams[j];
            }

        }
        for (int i = 0; i < teams2[0].length; i++) {
            fixture[i] = new Match(teams2[0][i], teams2[1][i]);
        }

        int week = teams2[0].length;
        int a = 1, b;

        Team temp;

        //create fixture
        //first leg
        for (int k = 0; k < teams.length - 2; k++) {

            temp = teams2[0][teams2[0].length - 1];
            for (int i = teams2[0].length - 1; i > 1; i--) {
                teams2[0][i] = teams2[0][i - 1];
            }
            teams2[0][1] = teams2[1][0];
            for (int i = 0; i < teams2[0].length - 1; i++) {
                teams2[1][i] = teams2[1][i + 1];
            }
            teams2[1][teams2[0].length - 1] = temp;

            for (int i = 0; i < teams2[0].length; i++) {
                fixture[week] = new Match(teams2[0][i], teams2[1][i]);
                week++;
            }

        }

        //second leg
        for (int k = 0; k < teams.length - 1; k++) {

            temp = teams2[0][teams2[0].length - 1];
            for (int i = teams2[0].length - 1; i > 1; i--) {
                teams2[0][i] = teams2[0][i - 1];
            }
            teams2[0][1] = teams2[1][0];
            for (int i = 0; i < teams2[0].length - 1; i++) {
                teams2[1][i] = teams2[1][i + 1];
            }
            teams2[1][teams2[0].length - 1] = temp;

            for (int i = 0; i < teams2[0].length; i++) {
                fixture[week] = new Match(teams2[1][i], teams2[0][i]);
                week++;
            }

        }



    }


    void playWeeks(int start,int end) {
        System.out.println("--------------Sportoto Super Lig-----------------");

        int week=start;
        for (int i = (start-1)*(teams.length/2); i < end*(teams.length/2); i = i + teams.length / 2) {
            System.out.println("---------------------"+week+". week---------------");
            for (int j = i; j < i + teams.length / 2; j++) {
                fixture[j].play();

            }
            week ++;
            showTable();
        }

        champion();
    }

    public void showTable() {

        String tl, ti;

        tl = "-------------------------------------------------";
        ti = "com.maemresen.footballsim.Team\t\tP W D L S:C\tP\tDif";
        wr(tl);
        wr(ti);

        //ranking of teams
        int var;
        Team vart;
        for (int i = 1; i < teams.length; i++) {

            for (int j = 0; j < teams.length - i; j++) {

                if (isBest(j, j + 1)) {

                    vart = teams[j];
                    teams[j] = teams[j + 1];
                    teams[j + 1] = vart;

                }

            }
        }
        for (int a = teams.length - 1; a > -1; a--) {
            System.out.println(teams[a].teamStatistics());

        }

        wr(tl);
    }

    public boolean isBest(int a, int b) {

        if (teams[a].points == teams[b].points) {
            return teams[a].Goaldifference() > teams[b].Goaldifference();
        }
        return teams[a].points > teams[b].points;
    }

    public void champion() {
        if (teams[teams.length - 2].points < teams[teams.length - 1].points) {

            System.out.println("* The Champion is " + teams[teams.length - 1].name + " *");
            System.out.println("-------------------------------------------------");

        } else {

            System.out.println("Friendship Wins");
            System.out.println("-------------------------------------------------");

        }

    }

}//class
