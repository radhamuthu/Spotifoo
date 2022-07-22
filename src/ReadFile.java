import java.io.File;
import java.util.Scanner;

public class ReadFile extends Display {

    public static void readNames() {
        var file = new File("assets/data.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String readLine = sc.nextLine();
                setNames(readLine);
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    public static void setNames(String rLine){
        String [] read = rLine.split(",");
        songList.add(read[0]);
        artistList.add(read[1]);
        albumList.add(read[2]);
        genreList.add(read[3]);
        mp3List.add(read[4]);
        pngList.add(read[5]);

    }


}