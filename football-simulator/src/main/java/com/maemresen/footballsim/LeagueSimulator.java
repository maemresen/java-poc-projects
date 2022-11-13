package com.maemresen.footballsim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LeagueSimulator {

    public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {
        URL resource = LeagueSimulator.class.getClassLoader().getResource("players_db.txt");
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        }
        File playerlist = new File(resource.toURI());

        FileReader fr = new FileReader(playerlist);
        BufferedReader br = new BufferedReader(fr);

        League msl = new League(br.readLine(), 20, 11);
        for (int j = 0; j < msl.noft; j++) {
            msl.addTeam(new Team(br.readLine(), msl.nofp), j);
            for (int i = 0; i < msl.nofp; i++) {
                msl.teams[j].addPlayer(new Player(br.readLine()), i, msl.teams[j]);
            }
            br.readLine();
        }
        br.close();
        msl.createFixture();
        msl.addPlayersToLeague();

        int fweek, lweek;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the first week: ");
//        fweek = scan.nextInt();

//        System.out.println("Enter the last week: ");
//        lweek = scan.nextInt();
//        if (lweek > (msl.noft - 1) * 2) {
//            System.out.println("You have'nt got " + lweek + " weeks");
//            lweek = (msl.noft - 1) * 2;
//        }
//        msl.playWeeks(fweek, lweek);
        msl.playWeeks(1, (msl.noft - 1) * 2);

        msl.playerStatictics();
        msl.bestScorer();
        msl.bestAsister();
        msl.bestPlayers();
    }
}
