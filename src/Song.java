import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Song {


    private static void playSong() {
        boolean input= true;
        do{

         input = true;
        try {


            Scanner play = new Scanner(System.in);

            int number;
            number = play.nextInt();

            if (number <=ReadFile.songList.size() && number > 0)  {
                number = number - 1;// to acess array
                String songfile = ReadFile.songfileList.get(number);
                String pngfile = ReadFile.pngList.get(number);
                songfile = songfile.toLowerCase();
                pngfile = pngfile.toLowerCase();
                pngfile = pngfile.replace(' ', '-');
                songfile = songfile.replace(' ', '-');
                Desktop d = Desktop.getDesktop();
                if(songfile.contains(".mp3"))
                {
                    //public void browseFileDirectory(File )
                    File readsongfile = new File("assets/songs/" + songfile);

                    File readpngfile = new File("assets/albums/" + pngfile);
                    File defaultpngfile = new File("assets/no-picture.png");
                    if (readsongfile.exists()) {
                        d.open(readsongfile);
                        if (readpngfile.exists()) {
                            d.open(readpngfile);
                        } else if (defaultpngfile.exists()) {
                            d.open(defaultpngfile);
                        } input = true;
                    }
                } else {
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
            System.out.print("Invalid input,Please enter a correct number :");
            input= false;
        }
        } while(!input);
    }
        public static void songName(){
        int a = 1;// to  start the display with 1
        for (String i : ReadFile.songList) {
            System.out.println(a + "." + i);
            a++;
        }
        System.out.println("0. To go back to main menu ");
        System.out.print("Enter your option  :");
        playSong();

    }
}
