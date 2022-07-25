import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Genre {




    private static void displaySelectedSong(ArrayList temp) {

        int a = 1;// to  start the display with 1
        for (int i = 0; i < temp.size(); i++) {
            int j = (int) temp.get(i);
            System.out.println(a + "." + ReadFile.songList.get(j));
            a++;
        }
        try {
            System.out.println("0. To go back to main menu");
            Scanner ui = new Scanner(System.in);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            int number = ui.nextInt();

            if (number > 0 && number <= temp.size()) {
                number = number - 1;
                number = (int) temp.get(number);
                String song = ReadFile.songList.get(number);
                String png =ReadFile.albumList.get(number);
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

            } else {
                System.out.println("Invalid input,Please enter a correct number");
                displaySelectedSong(temp);
            }

        } catch (IOException e) {
            System.out.println("Sorry for inconvenience ,Can't play the song");
            Display.displaymain();// to go back to main menu
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");
            displaySelectedSong(temp);
        }

    }
    public static void assignGenreListHashset() {
        //to avoid duplication using HashSet
        java.util.List<String> genreArrayList = new ArrayList<>(ReadFile.genreList);
        List<String> genreArrayListHashset = new ArrayList<>(new LinkedHashSet<>(genreArrayList));
        System.out.println("The Genre available here are :");
        int a=1;// to start the display with 1
        for (String i : genreArrayListHashset) {
            System.out.println(a + "." + i);
            a++;
        }

        try {
            System.out.println("0. To go back to main menu");
            Scanner genre = new Scanner(System.in);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            int number = genre.nextInt();
            if (number == 0) {
                Display.displaymain();
            } else if (number <= genreArrayListHashset.size()) {

                ArrayList<Integer> temp = new ArrayList<>();
                int i = 0;
                number = number - 1;
                String genreName = genreArrayListHashset.get(number);
                for (int j = 0; j < ReadFile.genreList.size(); j++) {
                    if (ReadFile.genreList.get(j).equals(genreName)) {
                        temp.add(j);
                    }
                }
                displaySelectedSong(temp);
            }
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");
            assignGenreListHashset();
        }
    }



}
