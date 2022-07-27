import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;

//Process Class have  methods which is used for Artist ,Album and Genre ArrayList
public class Process {
    // new Arraylist  created without duplication from original ArrayList-- using HashSet
    public static void assignListHashset(ArrayList<String> processList) {
        ArrayList<String> processArrayListHashset = new ArrayList<>(new HashSet<>(processList));
        displayHashset(processArrayListHashset,processList);
    }

    //To display the new ArrayList without duplication to the console
    public static void displayHashset(ArrayList<String> processArrayListHashset,ArrayList<String> processList){

        int a = 1;// to  start the display with 1 in console
        for (String i : processArrayListHashset) {
            System.out.println("["+a +"]. " + i);
            a++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option :");
        boolean input = true;
        // the do- while block is to run repeatedly when the user input is not in the expected way
        do {
            try {
                Scanner userInput = new Scanner(System.in);
                String numberString = userInput.nextLine();
                // to check space or null or empty input from user and throw exception error
                if (numberString.trim().isEmpty()) throw new InputMismatchException();
                int number = Integer.parseInt(numberString) ;
                // to clear console
                validation.cls();
                // check userinput to return to main menu
                if (number == 0) {
                    Display.displaymain();

                }
                // userinput is checked based on their selection of displayed names in {Album or Artist or Genre}
                else if (number <= processArrayListHashset.size()) {
                    // temporary ArrayList created to store the value of the position
                    // where the  original ArrayList value match with HashSet 5
                    // ArrrayList
                    ArrayList<Integer> temp = new ArrayList<>();
                    number = number - 1;
                    String processName = processArrayListHashset.get(number);
                    for (int j = 0; j < processList.size(); j++) {
                        if (processList.get(j).equals(processName)) {
                            temp.add(j);
                        }
                    }
                    // to display the songs - specific to {Album or Artist or Genre}
                    displaySelectedSong(temp);



                }// userinput out of the ArrayList throw illegalArgument Exception error
                else throw  new IllegalArgumentException ();


            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.print("Invalid input. Please enter correct value :");
                input = false;
                // the catch block will show invalid message and ask for correct input
                // and makes do-while work by assgin loop input = false
            }

        } while (!input);// loop until userinput= true


    }
    //to display the songs corresponding to specifically selected  {Album or Artist or Genre} using temporary arrayList
    public static void displaySelectedSong(ArrayList<Integer> temp) {

        int a = 1;// to  start the display with 1
        System.out.println("The Songs available are ");
        //To display the songs by taking position of Original List from temporary ArrayList
        for (Integer integer : temp) {
            int j = integer;
            System.out.println("[" + a + "]. " + ReadFile.songList.get(j));
            a++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option : ");
        boolean input2 =true;
        // the do- while block is to run repeatedly when the user input is not in the expected way
        do {

            try {

                Scanner ui = new Scanner(System.in);
                String numberString = ui.nextLine();
                // to check space or null or empty input from user and throw exception error
                if (numberString.trim().isEmpty()) throw new InputMismatchException();
                int number = Integer.parseInt(numberString) ;
                // to clear console
                validation.cls();
                // check userinput to play the  selected song and also open image file respective to the song
                if (number > 0 && number <= temp.size()) {
                    number = number - 1;
                    number = temp.get(number);
                    String songfile = ReadFile.songfileList.get(number);
                    String pngfile = ReadFile.pngList.get(number);
                    songfile = songfile.toLowerCase();
                    pngfile = pngfile.toLowerCase();
                    pngfile = pngfile.replace(' ', '-');
                    songfile = songfile.replace(' ', '-');
                    Desktop d = Desktop.getDesktop();
                    if (songfile.contains(".mp3"))// to check if file exist but doesnot have mp3 format to open in music player
                    {
                        //read the path name and store the perfect filepath
                        File readsongfile = new File("assets/songs/" + songfile);
                        File readpngfile = new File("assets/albums/" + pngfile);
                        File defaultpngfile = new File("assets/no-picture.png");//default image file
                        if (readsongfile.exists()) {
                            d.open(readsongfile);
                            System.out.println("Enjoy Listening to the Song");

                            if (readpngfile.exists()) {
                                d.open(readpngfile);
                            } else if (defaultpngfile.exists())
                                d.open(defaultpngfile);

                        }
                    }  else {
                        // error message when .mp3 format not there to play the song and go to main menu
                        System.out.println("Sorry for inconvenience ,Can't play the song   ");
                        Display.displaymain();
                        input2=true;
                    }


                } else if (number == 0) {
                    Display.displaymain();


                } else throw new IllegalArgumentException();// if userinput is not in the required format

            } catch (IllegalArgumentException | InputMismatchException e) {
                // error message specific to user input not in desired format
                System.out.print("Invalid input,Please enter a correct number :");
                input2 =false;

            } catch (IOException e) {
                //error message specific to the files like songname.mp3 or image.png file not found the path
                // it takes to main menu
                System.out.println("Sorry for inconvenience. ");
                Display.displaymain();


            }

        } while (!input2);// loop until userinput= true
    }


}
