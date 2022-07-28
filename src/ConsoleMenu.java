import java.util.*;

public  class ConsoleMenu {


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
                String numberString = ui.nextLine();
                if (numberString.trim().isEmpty()) throw new InputMismatchException();
                int user = Integer.parseInt(numberString) ;
                if (user > 0 && user <= 6) {
                    switch (user) {
                        case 1:
                            Helper.clearConsole();// clear console
                            System.out.println("The Song names are");
                            SongSelection.displaySongNameInConsole();
                            validInput=false;
                            break;
                        case 2:
                            Helper.clearConsole();// clear console
                            System.out.println("The Artist names are");
                            ArtistOrAlbumOrGenreSelection.assignListHashset(AssetsFolderReader.artistList);
                            validInput =false;
                            break;
                        case 3:
                            Helper.clearConsole();// clear console
                            System.out.println("The Album names are");
                            ArtistOrAlbumOrGenreSelection.assignListHashset(AssetsFolderReader.albumList);
                            validInput =false;
                            break;
                        case 4:
                            Helper.clearConsole();// clear console
                            System.out.println("The Genre are");
                            ArtistOrAlbumOrGenreSelection.assignListHashset(AssetsFolderReader.genreList);
                            validInput =false;
                            break;

                        case 5:
                            Helper.clearConsole();// clear console
                            WordSearch.getSearchWordInput();
                            validInput =false;
                            break;
                        case 6:
                            Helper.clearConsole();// clear console
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

