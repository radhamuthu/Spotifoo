import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;


public class Process {
    public static void assignListHashset(ArrayList processList) {
        //to avoid duplication using HashSet
        //ArrayList<String> processArrayList = new ArrayList<>(processList);
        ArrayList<String> processArrayListHashset = new ArrayList<>(new HashSet<>(processList));
        displayHashset(processArrayListHashset,processList);
    }
    public static void displayHashset(ArrayList<String> processArrayListHashset,ArrayList<String> processList){

        int a = 1;// to  start the display with 1
        for (String i : processArrayListHashset) {
            System.out.println(a + "." + i);
            a++;
        }
        System.out.println("0. To go back to main menu");
        System.out.print("Please choose the option :");
        boolean input = true;
        do {
            try {


                Scanner userInput = new Scanner(System.in);
                String numberString = userInput.nextLine();
                if (numberString.trim().isEmpty()) throw new InputMismatchException();
                int number = Integer.parseInt(numberString) ;

                validation.cls();
                if (number == 0) {
                    Display.displaymain();
                }
                else if (number <= processArrayListHashset.size()) {

                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    int i = 0;
                    number = number - 1;
                    String processName = processArrayListHashset.get(number);
                    for (int j = 0; j < processList.size(); j++) {
                        if (processList.get(j).equals(processName)) {
                            temp.add(j);
                        }
                    }
                    displaySelectedSong(temp);
                    input = true;


                } else throw  new IllegalArgumentException ();


            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.print("Invalid input. Please enter correct value :");
                input = false;

            }

        } while (!input);


    }

    public static void displaySelectedSong(ArrayList<Integer> temp) {

        int a = 1;// to  start the display with 1
        System.out.println("The Songs available are ");
        for (int i = 0; i < temp.size(); i++) {
            int j = (int) temp.get(i);
            System.out.println(a + "." + ReadFile.songList.get(j));
            a++;
        }
        System.out.println("0. To go back to main menu");
        System.out.print("Please choose the option :");
        boolean input2 = true;
        do {
            input2 = true;
            try {

                Scanner ui = new Scanner(System.in);
                String numberString = ui.nextLine();
                if (numberString.trim().isEmpty()) throw new InputMismatchException();
                int number = Integer.parseInt(numberString) ;
                validation.cls();
                if (number > 0 && number <= temp.size()) {
                    number = number - 1;
                    number = (int) temp.get(number);
                    String songfile = ReadFile.songfileList.get(number);
                    String pngfile = ReadFile.pngList.get(number);
                    songfile = songfile.toLowerCase();
                    pngfile = pngfile.toLowerCase();
                    pngfile = pngfile.replace(' ', '-');
                    songfile = songfile.replace(' ', '-');
                    Desktop d = Desktop.getDesktop();
                    if (songfile.contains(".mp3"))
                    {
                        //public void browseFileDirectory(File )
                        File readsongfile = new File("assets/songs/" + songfile);
                        File readpngfile = new File("assets/albums/" + pngfile);
                        File defaultpngfile = new File("assets/no-picture.png");
                        if (readsongfile.exists()) {
                            d.open(readsongfile);
                            if (readpngfile.exists()) {
                                d.open(readpngfile);
                            } else if (defaultpngfile.exists())
                                d.open(defaultpngfile);

                        }
                        input2 = true;
                    }  else {
                        System.out.println("Sorry for inconvenience ,Can't play the song");
                        Display.displaymain();
                    }


                } else if (number == 0) {
                    Display.displaymain();

                } else throw new IllegalArgumentException();

            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.print("Invalid input,Please enter a correct number :");
                input2 =false;
            } catch (IOException e) {
                System.out.println("Sorry for inconvenience. ");
                Display.displaymain();
            }

        } while (!input2);
    }


}
