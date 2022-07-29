package com.radha.spotifoo.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * all arrayList for song,artist,album,song file and png image are declared here
 * and data.txt file is read and stored in separate array list
 *
 */

public class AssetsFolderReader {

    public static ArrayList<String> songList = new ArrayList<>();
    public static ArrayList<String> artistList = new ArrayList<>();
    public static ArrayList<String> albumList = new ArrayList<>();
    public static ArrayList<String> genreList = new ArrayList<>();
    public static ArrayList<String> songFileList = new ArrayList<>();
    public static ArrayList<String> imageList = new ArrayList<>();

    /**
     * to read data.txt file from Assets folder
     *
     */
    public static void assetsDataFile() {
        var dataFile = new File("assets/data.txt");
        try (Scanner scanner = new Scanner(dataFile)) {
            // read line by line until it has no next line
            while (scanner.hasNextLine()) {
                String readLine = scanner.nextLine();
                storeNamesInArray(readLine);
            }
        } catch (Exception e) {
            // file does not exist in the specific path
            System.out.println("Data File doesn't exist");
        }
        // to close the scanner

    }

    /**
     *
     * @param rLine read the string line from data.txt and
     *             we store each specific word in the specific array list using comma separation
     *
     */
    public static void storeNamesInArray(String rLine) {
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