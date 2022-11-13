# Football Simulator
Introduction to Computer Engineering Course (CSE101) project

An example project which simulates a whole season of given football league over console.
(creating random fixture for season, simulate each match, take statistics etc.).

You could see a player database file ([see](./src/main/resources/players_db.txt)).
It is pre-initialized with Premier League.

When you start Main Class ([see](./src/main/java/com/maemresen/footballsim/LeagueSimulator.java))
1. The program parse txt file to get teams and players
2. Generates **random** fixture
3. Simulate each match one by one and print scoreboard for each week
4. At the end of the season, determine the season champion and other stats (top scorer, assist leader etc.)

**NOTE** You can update database file with appropriate format to add different