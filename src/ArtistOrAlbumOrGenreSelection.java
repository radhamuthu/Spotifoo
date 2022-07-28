import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;

// Class have  methods which is used for Artist ,Album and Genre ArrayList
public class ArtistOrAlbumOrGenreSelection {
    // new Arraylist  created without duplication from original ArrayList-- using HashSet
    public static void assignListHashset(ArrayList<String> userSelectedList) {
        ArrayList<String> userGivenHashList  = new ArrayList<>(new HashSet<>(userSelectedList));
        displayUserGivenHashList(userGivenHashList,userSelectedList);
    }

    //To display the new ArrayList without duplication to the console
    public static void displayUserGivenHashList(ArrayList<String> userGivenHashList,ArrayList<String> userSelectedList){

        int beginNumber = 1;// to  start the display with 1 in console
        for (String i : userGivenHashList) {
            System.out.println("["+beginNumber +"]. " + i);
            beginNumber++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option :");
        boolean validInput = true;
        // the do- while block is to run repeatedly when the user input is not in the expected way
        do {
            try {
                Scanner userInput = new Scanner(System.in);
                String userInputString = userInput.nextLine();
                // to check space or null or empty input from user and throw exception error
                if (userInputString.trim().isEmpty()) throw new InputMismatchException();
                int userInputNumber = Integer.parseInt(userInputString) ;
                // to clear console
                Helper.clearConsole();
                // check user input to return to main menu
                if (userInputNumber == 0) {
                    ConsoleMenu.MenuList();

                }
                // user input is checked based on their selection of displayed names in {Album or Artist or Genre}
                else if (userInputNumber <= userGivenHashList.size()) {
                    // temporary ArrayList created to store the position of the specific selected name in the given arrayList
                    // which matches with console displayed given Hash list
                    ArrayList<Integer> temporaryList = new ArrayList<>();
                    userInputNumber = userInputNumber - 1;
                    String nameSelection = userGivenHashList.get(userInputNumber);
                    for (int j = 0; j < userSelectedList.size(); j++) {
                        if (userSelectedList.get(j).equals(nameSelection)) {
                            temporaryList.add(j);
                        }
                    }
                    // to display the songs - specific to {Album or Artist or Genre}
                    displaySelectedSong(temporaryList);



                }// user input out of the ArrayList throw illegalArgument Exception error
                else throw  new IllegalArgumentException ();


            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.print("Invalid input. Please enter correct value :");
                validInput = false;
                // the catch block will show invalid input message and ask for valid input by do-while

            }

        } while (!validInput);// loop until user input= true


    }
    //to display the songs corresponding to specifically selected  {Album or Artist or Genre} using temporary arrayList
    public static void displaySelectedSong(ArrayList<Integer> temporaryList) {

        int beginNumber = 1;// to  start the display with 1
        System.out.println("The Songs available are ");
        //To display the songs by taking position of Original List from temporary ArrayList
        for (Integer integer : temporaryList) {
            int j = integer;
            System.out.println("[" + beginNumber + "]. " + AssetsFolderReader.songList.get(j));
            beginNumber++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option : ");
        boolean validInput2;
        // the do- while block is to run repeatedly when the user input is not valid
        do {
            validInput2 =true;
            try {

                Scanner userInput = new Scanner(System.in);
                String userInputString = userInput.nextLine();
                // to check space or null or empty input from user and throw exception error
                if (userInputString.trim().isEmpty()) throw new InputMismatchException();
                int userInputNumber = Integer.parseInt(userInputString) ;
                 // check user input to play the  selected song and also open image file respective to the song
                if (userInputNumber > 0 && userInputNumber <= temporaryList.size()) {
                    userInputNumber = userInputNumber - 1;// to access the array
                    userInputNumber = temporaryList.get(userInputNumber);
                    String songName = AssetsFolderReader.songFileList.get(userInputNumber);
                    String imageName= AssetsFolderReader.imageList.get(userInputNumber);
                    Desktop d = Desktop.getDesktop();
                    if (songName.contains(".mp3"))// to check if file exist but does not have mp3 format to open in music player
                    {
                        //read the path name and store the perfect filepath
                        File songPathFile = new File("assets/songs/" + songName);
                        File imagePathFile = new File("assets/albums/" + imageName);
                        File defaultImageFile = new File("assets/no-picture.png");//default image file
                        if (songPathFile.exists()) {
                            d.open(songPathFile);
                            System.out.println("Enjoy listening to the Song");
                            if (imagePathFile.exists()) {
                                d.open(imagePathFile);
                            } else if (defaultImageFile.exists())
                                d.open(defaultImageFile);

                        }
                    }  else {
                        // error message when .mp3 format not there to play the song and go to main menu
                        System.out.println("Sorry for inconvenience ,Can't play the song...   ");
                        ConsoleMenu.MenuList();

                    }


                } else if (userInputNumber == 0) {
                    ConsoleMenu.MenuList();


                } else throw new IllegalArgumentException();// if user input is not in the required format

            } catch (IllegalArgumentException | InputMismatchException e) {
                // error message specific to user input not in desired format
                System.out.print("Invalid input,Please enter a correct number : ");
                validInput2 =false;

            } catch (IOException e) {
                //error message specific to the files like song or image file not found in the path
                // it takes to main menu
                System.out.println("Sorry for inconvenience....");
                ConsoleMenu.MenuList();


            }

        } while (!validInput2);// loop until user gives valid input as true
    }


}
