import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AssetsFolderReader {
    //all arrayList for song,artist,album,song file and png image are declared here
    static ArrayList<String> songList = new ArrayList<>();
    static ArrayList<String> artistList = new ArrayList<>();
    static ArrayList<String> albumList = new ArrayList<>();
    static ArrayList<String> genreList = new ArrayList<>();
    static ArrayList<String> songFileList = new ArrayList<>();
    static ArrayList<String> imageList = new ArrayList<>();
    // to read data.txt file
    public static void AssetsDataFile() {
        var dataFile = new File("assets/data.txt");
        try (Scanner sc = new Scanner(dataFile)) {
            // read line by line until it has no next line
            while (sc.hasNextLine()) {
                String readLine = sc.nextLine();
                StoreNamesInArray(readLine);
            }
        } catch (Exception e) {
            // file does not exist in the specific path
            System.out.println("Data File doesn't exist");
        }
    }
    public static void StoreNamesInArray(String rLine) {
        //  the read line  is separated with "," and add to specific arraylist
        String[] read = rLine.split(",");
        songList.add(read[0]);
        artistList.add(read[1]);
        albumList.add(read[2]);
        genreList.add(read[3]);
        songFileList.add(read[4]);
        imageList.add(read[5]);
    }



}