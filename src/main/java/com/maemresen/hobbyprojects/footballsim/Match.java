package com.maemresen.hobbyprojects.footballsim;

import java.util.Random;

public class Match {

    Team home;
    Team away;
    String hscorer, ascorer, hasister, aasister;
    int hGoals;
    int aGoals;
    int hsayac, asayac;
    int hGoalmin, aGoalmin, hGoalsec, aGoalsec;
    int i = 1, e = 1, is = 1, es = 1;
    int homescorer, awayscorer, homeasister, awayassister;
    int homesgoalsinmatch = 0, awaysgoalsinmatch = 0;
    int hcaptain = 1, acaptain = 1;
    String mof;
    Team rev;

    public Match(Team h, Team a) {

        home = h;
        away = a;
        hGoals = 0;
        aGoals = 0;

    }
    void revMatch(Team a, Team h){

        home =a;
        away = h;
        hGoals = 0;
        aGoals = 0;

    }

    public void play() {

        hGoals = 0;
        aGoals = 0;

        System.out.println("Good luck for each teams" + "\n"
                + "-------------------------------------------------");
        Random rand;
        rand = new Random();

        hsayac = rand.nextInt(4);
        asayac = rand.nextInt(3);
        if (hsayac == 0) {
            hcaptain = 0;
        } else {
        }
        if (asayac == 0) {
            acaptain = 0;
        }

        //home team goals
        while (hGoals < hsayac) {
            hGoals++;
            hGoalmin = rand.nextInt(90 - i) + i;
            hGoalsec = rand.nextInt(60 - is) + is;
            i = hGoalmin;
            is = hGoalsec;
            homescorer = rand.nextInt(home.teamsheet.length-2) + 1;

            hscorer = home.teamsheet[homescorer].name;
            home.teamsheet[homescorer].score();
            homesgoalsinmatch++;
            do {

                homeasister = rand.nextInt(home.teamsheet.length*2) + 1;

            } while (homescorer == homeasister);
            if (homeasister < home.teamsheet.length) {
                hasister = home.teamsheet[homeasister].name;
                home.teamsheet[homeasister].assist();
                System.out.println("Goool!" + "" + hscorer + " from " + home.name + " scored  " + hGoalmin + "'" + hGoalsec + " assist "
                        + hasister);
            } else {

                System.out.println("Goool!" + "" + hscorer + " from " + home.name + " scored  " + hGoalmin + "'" + hGoalsec);

            }

        };

        //away team goals
        while (aGoals < asayac) {
            aGoals++;
            aGoalmin = rand.nextInt(90 - e) + e;
            aGoalsec = rand.nextInt(60 - es) + es;
            e = aGoalmin;
            es = aGoalsec;
            awayscorer = rand.nextInt(away.teamsheet.length-2) + 1;

            ascorer = away.teamsheet[awayscorer].name;
            away.teamsheet[awayscorer].score();
            awaysgoalsinmatch++;
            do {

                awayassister = rand.nextInt(away.teamsheet.length*2) + 1;

            } while (awayscorer == awayassister);
            if (awayassister < away.teamsheet.length) {
                aasister = away.teamsheet[awayassister].name;
                away.teamsheet[awayassister].assist();

                System.out.println("Goool!" + "" + ascorer + " from " + away.name + " scored  " + aGoalmin + "'" + aGoalsec + " assist "
                        + aasister);
            } else {
                awaysgoalsinmatch++;
                System.out.println("Goool!" + "" + ascorer + " from " + away.name + " scored  " + aGoalmin + "'" + aGoalsec);

            }
        }

        home.played++;
        away.played++;
        home.scored += hGoals;
        away.scored += aGoals;
        home.conceded += aGoals;
        away.conceded += hGoals;
        if (hGoals > aGoals) {
            home.wins++;
            away.losses++;
            home.points += 3;

            System.out.println(hscorer + " says:We play well today and im happy to scored ");
            mof = hscorer;
            home.teamsheet[homescorer].vote();

            if (acaptain == 0) {
                System.out.println(away.teamsheet[0].name + " says:We could not do what we want and could not scored today."
                        + "We forget this match and look forward.");

            } else {

                System.out.println(ascorer + " says:First of all Congratulations all "
                        + "of my team friends im happy to scored  "
                        + "but it is not enough for win");
                System.out.println("Man of the match is:" + hscorer);
            }
        } else if (hGoals < aGoals) {
            away.wins++;
            home.losses++;
            away.points += 3;

            System.out.println(ascorer + " says:We are away from home but"
                    + " we play well today and im happy to scored ");
            mof = ascorer;
            away.teamsheet[awayscorer].vote();
            if (hcaptain == 0) {
                System.out.println(home.teamsheet[0].name + " says:We apologize to fans we work hard together");
            } else {
                System.out.println(hscorer + " says:We could not do what we want im happy to scored today but "
                        + "it is not enough for win we look forward");
            }

        } else {
            home.draws++;
            away.draws++;
            home.points++;
            away.points++;
            if (hcaptain == 0) {
                System.out.println(home.teamsheet[0].name + " says:Two teams fight for win but anyone scored but we should won this match");

            } else {
                System.out.println(hscorer + " says:Our oppenets play well im happy to scored today but i wish we won.");
            }
            if (acaptain == 0) {
                System.out.println(away.teamsheet[0].name + " says:Two teams play well draw is not bad for us because we are away from home");

            } else {
                System.out.println(ascorer + " says:First of all i am happy to scored today 1 point is not bad for us."
                        + "i miss some positions im sorry for this");
            }

            mof = "There is no man of the match";
        }

        System.out.println(home.name + " " + hGoals + ":" + aGoals + " " + away.name);
        System.out.println("Man of the match is:" + mof);
        System.out.println("-------------------------------------------------");
    }
}