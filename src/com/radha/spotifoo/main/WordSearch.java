package com.radha.spotifoo.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Word search class have methods corresponding to get search word and
 * identify the songs which matches and display un console for user selection to play the corresponding song
 */
public class WordSearch {
    /**
     * method is used to clear the console and ask for user input to search song and validate the input string is empty or not
     */

    public static void getSearchWordInput() {
        String searchWordInput;
        System.out.print("Enter search words :");
        try (Scanner scanInput = new Scanner(System.in)){
            searchWordInput = scanInput.nextLine();
            if (searchWordInput.trim().isEmpty()) throw new InputMismatchException();
            searchWordInput = searchWordInput.trim().toLowerCase();
            ArrayList<Integer> temporarySearchList = new ArrayList<>();
            // the input word is searched in songArrayList and stored in temporary Search arraylist
            for (int i = 0; i < AssetsFolderReader.songList.size(); i++) {
                String toCheck = AssetsFolderReader.songList.get(i).toLowerCase();
                if (toCheck.contains(searchWordInput)) {
                    temporarySearchList.add(i);
                }
            }
            //to check if there is any song matched with the search word or else it will say no song
            if (temporarySearchList.size() > 0) {
                System.out.println("The Searched songs available are");
                displaySearchedSongAndPlay(temporarySearchList);// to display the search matched song names by calling method

            } else {
                System.out.println("There is no song based on your search.");
                ConsoleMenu.MenuList();
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid input. Please enter search words :");
        }

    }

    /**
     *
     * @param temporaryList - carries the position of every selected songs from searched word
     * display the names of songs  which matched the search words
     *   play the song if user selected any song from the displayed song names
     * */

    public static void displaySearchedSongAndPlay(ArrayList<Integer> temporaryList) {
        Helper.displayInConsoleSong(temporaryList);
        Helper.playTheSelectedSong(temporaryList);
    }
}