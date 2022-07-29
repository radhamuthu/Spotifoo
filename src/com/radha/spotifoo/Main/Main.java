package com.radha.spotifoo.Main;

/**
 * Main Class  do clear console and call to read files from  folder and then to print the menu in console
 */
public class Main {
    public static void main(String[] args) {
        Helper.clearConsole();
        AssetsFolderReader.AssetsDataFile();
        ConsoleMenu.MenuList();

    }
}