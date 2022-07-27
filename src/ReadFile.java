import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile extends Display {
    static ArrayList<String> songList = new ArrayList<>();
    static ArrayList<String> artistList = new ArrayList<>();
    static ArrayList<String> albumList = new ArrayList<>();
    static ArrayList<String> genreList = new ArrayList<>();
    static ArrayList<String> songfileList = new ArrayList<>();
    static ArrayList<String> pngList = new ArrayList<>();

    public static void readNames() {
        var file = new File("assets/data.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String readLine = sc.nextLine();
                setNames(readLine);
            }
        } catch (Exception e) {
            System.out.println("File doesn't exist");
        }
    }
    public static void setNames(String rLine) {
        String[] read = rLine.split(",");
        songList.add(read[0]);
        artistList.add(read[1]);
        albumList.add(read[2]);
        genreList.add(read[3]);
        songfileList.add(read[4]);
        pngList.add(read[5]);
    }



}