package com.radha.spotifoo.main;

import java.util.*;

public  class ConsoleMenu {
    /**
     * Menu list is displayed to console and allow to the user  to select what they want to do
     */

    public static void MenuList() {
        Helper.clearConsole();// to clear the console
        boolean validInput;
        do {
            validInput =true;
            System.out.println("The Main menus are ");
            System.out.println("[1]. Songs");
            System.out.println("[2]. Artists");
            System.out.println("[3]. Albums");
            System.out.println("[4]. Genre");
            System.out.println("[5]. Search");
            System.out.println("[6]. Exit");
            System.out.print("Please choose the option : ");

            try {
                Scanner ui = new Scanner(System.in);
               int user= Helper.scanUserInput(ui.nextLine());
                if (user > 0 && user <= 6) {
                    switch (user) {
                        case 1:
                            Helper.clearConsole();// clear console
                            System.out.println("The Song names are");
                            SongSelection.displaySongNameInConsole();
                            validInput=false;
                            Helper.clearConsole();
                            break;
                        case 2:
                            Helper.clearConsole();// clear console
                            System.out.println("The Artist names are");
                            SpotifooSelector.assignListHashset(AssetsFolderReader.artistList);
                            validInput =false;
                            Helper.clearConsole();
                            break;
                        case 3:
                            Helper.clearConsole();// clear console
                            System.out.println("The Album names are");
                            SpotifooSelector.assignListHashset(AssetsFolderReader.albumList);
                            validInput =false;
                            Helper.clearConsole();
                            break;
                        case 4:
                            Helper.clearConsole();// clear console
                            System.out.println("The Genre are");
                            SpotifooSelector.assignListHashset(AssetsFolderReader.genreList);
                            validInput =false;
                            Helper.clearConsole();
                            break;

                        case 5:
                            Helper.clearConsole();// clear console
                            WordSearch.getSearchWordInput();
                            validInput =false;
                            Helper.clearConsole();
                            break;
                        case 6:
                            Helper.clearConsole();// clear console
                            validInput= true;
                            ui.close(); // closes the scanner
                            System.out.println("Thanks for choosing Spotifoo! Have a wonderful Day!!");
                            System.exit(1);
                            break;
                    }

                } else {
                    System.out.println ("Please enter number from 1 to 6 from the menu list");
                    validInput = false;
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Invalid input.Please enter number from 1 to 6 from the menu list ");
            validInput = false;

            }
        } while (!validInput);// loops until user enters a valid input

    }




}

