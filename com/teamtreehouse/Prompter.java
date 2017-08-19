package com.teamtreehouse;

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prompter {

    private BufferedReader mReader;
    private Team mTeam;
    private List<Team> mTeamList;
    private Map<String, String> mMenu;
    private Set<Player> mPlayer;
    private Set<Player> mPlayersInTeam;
    private int sizeOfLoadedPlayers;

    public Prompter() {
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mTeamList = new ArrayList<Team>();
        mPlayer = new HashSet<Player>(Players.load());
        sizeOfLoadedPlayers = mPlayer.size();
        mPlayersInTeam = new HashSet<Player>();
        mMenu = new HashMap<String, String>();
        mMenu.put("Create", "Create a new team.");
        mMenu.put("Add", "Add a player to a team.");
        mMenu.put("Remove", "Remove a player from a team.");
        mMenu.put("Report", "View a report of a team by height and experience.");
        mMenu.put("Roster", "View a report of all teams with list of players.");
        mMenu.put("Quit", "Exit the program.");
    }


    private String promptAction() throws IOException {
        System.out.printf("%nMenu: %n");
        for (Map.Entry<String, String> option : mMenu.entrySet()) {
            System.out.printf("%s - %s %n", option.getKey(), option.getValue());
        }
        String answer = mReader.readLine();
        return answer.trim().toLowerCase();
    }

    public void run() {
        String choice = "";
        do {
            try {
                choice = promptAction();
                switch (choice) {
                    case "create":
                        if (mTeamList.size() < sizeOfLoadedPlayers) {
                            String teamName = promptNewTeam();
                            String coachName = promptNewCoach();
                            Set<Player> collectionOfPlayers = new HashSet<Player>();
                            mTeam = new Team(teamName, coachName, collectionOfPlayers);
                            mTeamList.add(mTeam);
                            System.out.printf("New team is added to mTeam list");
                        } else
                            System.out.println("Number of teams becomes bigger than number of players. No more teams are allowed to be added.");
                        break;
                    case "add":
                        Team teamAdd = chooseTeam();
                        if (mPlayer.size()<=0){
                            System.out.println("No more players available");
                        } else if (teamAdd.getmCollectionOfPlayers().size() < 11) {
                            Set<Player> addPlayerToTeam = addPlayer(teamAdd);
                            System.out.println(addPlayerToTeam);
                        } else System.out.println("You already have max amount of players which is 11.");
                        break;
                    case "remove":
                        Team teamRemove = chooseTeam();
                        if (teamRemove.getmCollectionOfPlayers().size() > 0) {
                            Set<Player> removePlayerFromTeam = removePlayer(teamRemove);
                            System.out.println(removePlayerFromTeam);
                        } else System.out.println("This team has no more players, nothing to be removed."/**/);
                        break;
                    case "report":
                        Team tempTeam = reportTeam();
                        List<Player> reportPlayers = reportPlayer(tempTeam);
                        System.out.println("List of players by height:");
                        int i = 0;
                        int x = 0;
                        Map<String, Set<Player>> result = new HashMap<String, Set<Player>>();
                        Set<Player> tempPlayerList1 = new HashSet<Player>();
                        Set<Player> tempPlayerList2 = new HashSet<Player>();
                        Set<Player> tempPlayerList3 = new HashSet<Player>();
                        String s1 = "Height range 35-40";
                        String s2 = "Height range 41-60";
                        String s3 = "Height range 47-50";
                        for (Player player : reportPlayers) {
                            if (player.getHeightInInches() >= 35 && player.getHeightInInches() <= 40) {
                                tempPlayerList1.add(player);
                            } else if (player.getHeightInInches() >= 41 && player.getHeightInInches() <= 46) {
                                tempPlayerList2.add(player);
                            } else if (player.getHeightInInches() >= 47 && player.getHeightInInches() <= 50) {
                                tempPlayerList3.add(player);
                            }
                            if (player.isPreviousExperience()) {
                                i++;
                            }
                            int a = (int) Math.round((i * 100) / reportPlayers.size());
                            x = a;
                        }
                        result.put(s1, tempPlayerList1);
                        result.put(s2, tempPlayerList2);
                        result.put(s3, tempPlayerList3);
                        for (Map.Entry me : result.entrySet()) {
                            System.out.println(me.getKey());
                            System.out.println(me.getValue());
                            Set<Player> xxx = ((Set<Player>) me.getValue());
                            System.out.println("Number of players in this height group is: " + xxx.size());
                        }
                        // escape character for % in printf is %
                        // so %% will print %
                        System.out.printf("The average experience level for this team is %d%%. %n", x);
                        break;
                    case "roster":
                        for (Team blockTeam : mTeamList) {
                            List<Player> reportPlayers2 = reportPlayer(blockTeam);
                            System.out.println("Team " + blockTeam.getTeamName() + " coached by " + blockTeam.getCoachName() + " - " + reportPlayers2);
                        }
                        break;
                    case "quit":
                        System.out.println("You have chosen to exit program, thanks for playing.");
                        break;
                    default:
                        System.out.printf("Unknown choice: '%s'. Try again %n%n%n", choice);
                }
            } catch (IOException ioe) {
                System.out.println("Problem with input");
                ioe.printStackTrace();
            }
        } while (!choice.equals("quit"));
    }

    private String promptNewTeam() throws IOException {
        System.out.println("Enter new team name");
        String teamName = mReader.readLine();
        return teamName.trim().toLowerCase();
    }

    private String promptNewCoach() throws IOException {
        System.out.println("Enter new coach name");
        String coachName = mReader.readLine();
        return coachName.trim().toLowerCase();
    }

    private Team chooseTeam() throws IOException {
        int j = 1;
        for (Team blockTeam : mTeamList) {
            System.out.printf("%s.) %s", j, blockTeam.toString());
            j++;
        }
        System.out.println("Choose the team to which to add player:");
        String option1 = mReader.readLine();
        int option1Int = Integer.parseInt(option1.trim());
        Team[] array1 = mTeamList.toArray(new Team[0]);
        Team team = array1[option1Int - 1];
        return team;
    }

    private Set<Player> addPlayer(Team team) throws IOException {
        int i = 1;
        for (Player blockPlayer : mPlayer) {
            System.out.printf("%s.) %s %n", i, blockPlayer.toString());
            i++;
        }
        System.out.println("Select an option: ");
        String option = mReader.readLine();
        int optionInt = Integer.parseInt(option.trim());
        Player[] array = mPlayer.toArray(new Player[0]);
        Player x = array[optionInt - 1];
        team.addPlayerToTeam(x);
        mPlayer.remove(x);
        return team.addPlayerToTeam(x);
    }

    private Set<Player> removePlayer(Team team) throws IOException {
        mPlayersInTeam = team.getmCollectionOfPlayers();
        int i = 1;
        for (Player blockPlayer : mPlayersInTeam) {
            System.out.printf("%s.) %s %n", i, blockPlayer.toString());
            i++;
        }
        System.out.println("Select player number you want to remove: ");
        String option = mReader.readLine();
        int optionInt = Integer.parseInt(option.trim());
        Player[] array = mPlayersInTeam.toArray(new Player[0]);
        Player x = array[optionInt - 1];
        team.removePlayerFromTeam(x);
        mPlayer.add(x);
        return team.removePlayerFromTeam(x);
    }

    private Team reportTeam() throws IOException {
        int i = 1;
        List<Team> teams = mTeamList;
        teams.sort(new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1.getTeamName().compareTo(o2.getTeamName());
            }
        });
        for (Team blockTeam : teams) {
            System.out.printf("%s.) Team %s coached by %s %n", i, blockTeam.getTeamName(), blockTeam.getCoachName());
            i++;
        }
        System.out.println("Select an option: ");
        String option = mReader.readLine();
        int optionInt = Integer.parseInt(option.trim());
        Team[] array = mTeamList.toArray(new Team[0]);
        Team chosenTeam = array[optionInt - 1];
        return chosenTeam;
    }

    private List<Player> reportPlayer(Team team) throws IOException {
        Set<Player> playersInTeam = team.getmCollectionOfPlayers();
        List<Player> playerList = new ArrayList<Player>();
        playerList.addAll(playersInTeam);
        playerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.compareTo(o2);
            }
        });
        return playerList;
    }
}
