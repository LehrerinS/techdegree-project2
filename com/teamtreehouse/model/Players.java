package com.teamtreehouse.model;

import com.teamtreehouse.model.Player;

import java.util.HashSet;
import java.util.Set;

public class Players {

    public static Set<Player> load() {
        Set<Player> player = new HashSet<Player>();
        Player player1 = new Player("Joe", "Smith", 42, true);
        player.add(player1);
        Player player2 = new Player("Jill", "Tanner", 36, true);
        player.add(player2);
        Player player3 = new Player("Bill", "Bon", 43, true);
        player.add(player3);
        Player player4 = new Player("Eva", "Gordon", 45, false);
        player.add(player4);
        Player player5 = new Player("Matt", "Gill", 40, false);
        player.add(player5);
        Player player6 = new Player("Kimmy", "Stein", 41, false);
        player.add(player6);
        Player player7 = new Player("Sammy", "Adams", 45, false);
        player.add(player7);
        Player player8 = new Player("Karl", "Saygan", 42, true);
        player.add(player8);
        Player player9 = new Player("Suzane", "Greenberg", 44, true);
        player.add(player9);
        Player player10 = new Player("Sal", "Dali", 41, false);
        player.add(player10);
        Player player11 = new Player("Joe", "Kavalier", 39, false);
        player.add(player11);
        Player player12 = new Player("Ben", "Finkelstein", 44, false);
        player.add(player12);
        Player player13 = new Player("Diego", "Soto", 41, true);
        player.add(player13);
        Player player14 = new Player("Chloe", "Alaska", 47, false);
        player.add(player14);
        Player player15 = new Player("Arfalseld", "Willis", 43, false);
        player.add(player15);
        Player player16 = new Player("Phillip", "Helm", 44, true);
        player.add(player16);
        Player player17 = new Player("Les", "Clay", 42, true);
        player.add(player17);
        Player player18 = new Player("Herschel", "Krustofski", 45, true);
        player.add(player18);
        Player player19 = new Player("Andrew", "Chalklerz", 42, true);
        player.add(player19);
        Player player20 = new Player("Pasan", "Membrane", 36, true);
        player.add(player20);
        Player player21 = new Player("Kenny", "Lovins", 35, true);
        player.add(player21);
        Player player22 = new Player("Alena", "Sketchings", 45, false);
        player.add(player22);
        Player player23 = new Player("Carling", "Seacharpet", 40, false);
        player.add(player23);
        Player player24 = new Player("Joseph", "Freely", 41, false);
        player.add(player24);
        Player player25 = new Player("Gabe", "Listmaker", 45, false);
        player.add(player25);
        Player player26 = new Player("Jeremy", "Smith", 42, true);
        player.add(player26);
        Player player27 = new Player("Ben", "Droid", 44, true);
        player.add(player27);
        Player player28 = new Player("James", "Dothnette", 41, false);
        player.add(player28);
        Player player29 = new Player("Nick", "Grande", 39, false);
        player.add(player29);
        Player player30 = new Player("Will", "Guyam", 44, false);
        player.add(player30);
        Player player31 = new Player("Jason", "Seaver", 41, true);
        player.add(player31);
        Player player32 = new Player("Johnny", "Thunder", 47, false);
        player.add(player32);
        Player player33 = new Player("Ryan", "Creedson", 43, false);
        player.add(player33);
        Player player34 = new Player("Ryan", "Creedson", 43, false);
        player.add(player34);
        Player player35 = new Player("Johnny", "Thunder", 47, false);
        player.add(player35);
        return player;
    }

}

