import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Song {


    private static void playSong() {

        try {
            System.out.println("0. To go back to main menu");
            System.out.println("Please choose the option:");
            Scanner play = new Scanner(System.in);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            int number = play.nextInt();

            if (number < 21 && number > 0) {
                number = number - 1;// to acess array
                String song = ReadFile.songList.get(number);
                String png = ReadFile.albumList.get(number);
                song = song.toLowerCase();
                png = png.toLowerCase();
                png = png.replace(' ', '-');
                song = song.replace(' ', '-');
                Desktop d = Desktop.getDesktop();
                //public void browseFileDirectory(File )
                File songfile = new File("assets/songs/" + song + ".mp3");
                File pngfile = new File("assets/albums/" + png + ".png");
                File imgfile = new File("assets/no-picture.png");
                if (songfile.exists()) {
                    d.open(songfile);
                    if (pngfile.exists()) {
                        d.open(pngfile);
                    } else if (imgfile.exists())
                        d.open(imgfile);

                } else {
                    throw new FileNotFoundException("Sorry for inconvenience ,Can't play the song");
                }
            } else if (number == 0) {
                Display.displaymain();

            }

        } catch (IOException e) {
            System.out.println("Sorry for inconvenience ,Can't play the song");
            //Display.displaymain();

        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");

        }
    }
    public static void songName(){
        int a = 1;// to  start the display with 1
        for (String i : ReadFile.songList) {
            System.out.println(a + "." + i);
            a++;
        }
        playSong();

    }
}
