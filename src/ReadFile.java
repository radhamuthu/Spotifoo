import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile extends Display {
    //all arrayList for song,artist,album,song file and png image are declared here
    static ArrayList<String> songList = new ArrayList<>();
    static ArrayList<String> artistList = new ArrayList<>();
    static ArrayList<String> albumList = new ArrayList<>();
    static ArrayList<String> genreList = new ArrayList<>();
    static ArrayList<String> songfileList = new ArrayList<>();
    static ArrayList<String> pngList = new ArrayList<>();
    // to read data.txt file
    public static void readNames() {
        var file = new File("assets/data.txt");
        try (Scanner sc = new Scanner(file)) {
            // read line by line until it has no nextline
            while (sc.hasNextLine()) {
                String readLine = sc.nextLine();
                setNames(readLine);
            }
        } catch (Exception e) {
            // file doesnot exist in the specific path
            System.out.println("File doesn't exist");
        }
    }
    public static void setNames(String rLine) {
        //  the read line  is separated with "," and add to specific arraylist
        String[] read = rLine.split(",");
        songList.add(read[0]);
        artistList.add(read[1]);
        albumList.add(read[2]);
        genreList.add(read[3]);
        songfileList.add(read[4]);
        pngList.add(read[5]);
    }



}