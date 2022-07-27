import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Song {

// this method is used to select the song from the display of console and then user may have option to play or go to main menu
    private static void playSong() {
        // the do- while block is to run repeatedly when the user input is not in the expected way
        boolean input= true;
        do{

         input = true;
        try {
            Scanner play = new Scanner(System.in);
            int number;String songName;
            songName = play.nextLine();
            // to check space or null or empty input from user and throw exception error
            if (songName.trim().isEmpty()) throw new InputMismatchException();
            number = Integer.parseInt(songName) ;
            // to clear console
            validation.cls();
            // check userinput to play the  selected song and also open image file respective to the song
            if (number <=ReadFile.songList.size() && number > 0)  {
                number = number - 1;// to acess array
                String songfile = ReadFile.songfileList.get(number);
                String pngfile = ReadFile.pngList.get(number);
                songfile = songfile.toLowerCase();
                pngfile = pngfile.toLowerCase();
                pngfile = pngfile.replace(' ', '-');
                songfile = songfile.replace(' ', '-');
                Desktop d = Desktop.getDesktop();
                if(songfile.contains(".mp3"))// to check if file exist but doesnot have mp3 format to open in music player
                {
                    //read the path name and store the perfect filepath
                    File readsongfile = new File("assets/songs/" + songfile);

                    File readpngfile = new File("assets/albums/" + pngfile);
                    File defaultpngfile = new File("assets/no-picture.png");
                    if (readsongfile.exists()) {
                        d.open(readsongfile);
                        if (readpngfile.exists()) {
                            d.open(readpngfile);
                        } else if (defaultpngfile.exists()) {
                            d.open(defaultpngfile);
                        }
                    }
                } else {
                    // error message when .mp3 format not there to play the song and go to main menu
                    System.out.println("Sorry for inconvenience ,Can't play the song");
                    System.out.print("Select other song number :");
                    input = false;
                }
            } else if (number == 0) {
                Display.displaymain();

            } else if(number > ReadFile.songList.size()){
                System.out.print("Invalid input,Please enter a correct number :");
                input = false;
            }

        } catch (IOException e) {
            System.out.println("Sorry for inconvenience ,Can't play the song");
            System.out.print("Select other song number :");
            input =false;

        } catch (IllegalArgumentException | InputMismatchException e) {
            //if user enterd symbols or number more than arrayList size or negavtive integer
            System.out.print("Invalid input,Please enter a correct number :");
            input= false;
        }
        } while(!input);// loop until userinput= true
    }
        public static void songName(){
        int a = 1;// to  start the display with 1
        //To display the songname in console
            for (String i : ReadFile.songList) {
            System.out.println("["+a + "]. " + i);
            a++;
        }
        System.out.println("[0]. To go back to main menu ");
        System.out.print("Enter your option  :");
        playSong();// allow to select the song from the displayed list in console

    }
}
