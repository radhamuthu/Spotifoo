import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public  class Display {
    static ArrayList<String> songList = new ArrayList<>();
    static ArrayList<String> albumList = new ArrayList<>();
    static ArrayList<String> artistList = new ArrayList<>();
    static ArrayList<String> genreList = new ArrayList<>();
    static ArrayList<String> mp3List = new ArrayList<>();
    static ArrayList<String> pngList = new ArrayList<>();
    //to see remove duplication

    public static void displaymain() {

        boolean input = true;
        //to display the mainlist
        System.out.println("1.Songs");
        System.out.println("2.Artists");
        System.out.println("3.Albums");
        System.out.println("4.Genre");
        System.out.println("5.Search");
        System.out.println("Please choose the option :");
        do {
            try {
                Scanner ui = new Scanner(System.in);
                int user = ui.nextInt();
                if (user > 0 && user < 6 && user!=0) {
                    switch (user) {
                        case 1:
                            int a=1;// to  start the display with 1
                            for (String i : songList) {
                                System.out.println(a + "." + i);
                                a++;
                            }
                            playSong();
                            break;
                        case 2:
                            assignArtistListHashset();

                            break;
                        case 3:
                            assignAlbumListHashset();
                            break;
                        case 4:
                            assignGenreListHashset();
                            break;
                        case 5:
                            System.out.println("enter search string");
                            break;

                    }

                } else {
                    System.out.println("Please enter number from 1 to 5:");
                    input = false;
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Invalid input.Please enter number from 1 to 5:");
                input = false;

            }
        } while (!input);

    }

    private static void assignGenreListHashset() {
        //to avoid duplication using HashSet
        List<String> genreArrayList = new ArrayList<>(genreList);
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
            int number = genre.nextInt();
            if (number == 0) {
                displaymain();
            } else if (number <= genreArrayListHashset.size()) {

                ArrayList<Integer> temp = new ArrayList<>();
                int i = 0;
                number = number - 1;
                String genreName = genreArrayListHashset.get(number);
                for (int j = 0; j < genreList.size(); j++) {
                    if (genreList.get(j).equals(genreName)) {
                        temp.add(j);
                    }
                }
                displaySelectedSong(temp);
            }
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");
            //assignArtistListHashset();
        }
    }
    private static void  assignAlbumListHashset() {
        //to avoid duplication using HashSet
        List<String> albumArrayList = new ArrayList<>(albumList);
        List<String> albumArrayListHashset = new ArrayList<>(new LinkedHashSet<>(albumArrayList));
        System.out.println("The album available are");
        int a = 1;// to start the display with 1
        for (String i : albumArrayListHashset) {
            System.out.println(a + "." + i);
            a++;
        }

        try {
            System.out.println("0. To go back to main menu");
            Scanner album = new Scanner(System.in);
            int number = album.nextInt();
            if (number == 0) {
                displaymain();
            } else if (number <= albumArrayListHashset.size()) {

                ArrayList<Integer> temp = new ArrayList<>();
                int i = 0;
                number = number - 1;
                String albumName = albumArrayListHashset.get(number);
                for (int j = 0; j < albumList.size(); j++) {
                    if (albumList.get(j).equals(albumName)) {
                        temp.add(j);
                    }
                }
                displaySelectedSong(temp);
            }
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");
            //assignArtistListHashset();
        }
    }

    private static void  assignArtistListHashset() {
        //to avoid duplication using HashSet
        List<String> artistArrayList = new ArrayList<>(artistList);
        List<String> artistArrayListHashset = new ArrayList<>(new LinkedHashSet<>(artistArrayList));
        System.out.println("The artists names are");
        int a=1;// to  start the display with 1
        for (String i:artistArrayListHashset){
            System.out.println(a +"."+i);
            a++;
        }
        try {
            System.out.println("0. To go back to main menu");
            Scanner artist = new Scanner(System.in);
            int number = artist.nextInt();
            if (number == 0) {
                displaymain();
            } else if (number <= artistArrayListHashset.size()) {

                ArrayList temp = new ArrayList<Integer> ();
                int i = 0;
                number = number - 1;
                String artistName = artistArrayListHashset.get(number);
                for (int j = 0; j < artistList.size(); j++) {
                    if (artistList.get(j).equals(artistName)) {
                        temp.add(j);
                    }
                }
                displaySelectedSong(temp);


            }
        }catch(IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");
            //assignArtistListHashset();
        }

    }

    private static void displaySelectedSong(ArrayList temp) {
        int a=1;// to  start the display with 1
        for (int i =0; i < temp.size();i++) {
                            int j= (int)temp.get(i);
                            System.out.println(a + "." + songList.get(j));
                            a++;
                        }
        try {
            System.out.println("0. To go back to main menu");
            Scanner ui = new Scanner(System.in);
            int number = ui.nextInt();

                if (number >0 && number <= temp.size() ){
                    number =number -1;
                    number = (int) temp.get(number);
                String song = songList.get(number);
                String png = albumList.get(number);
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
                displaymain();

            } else {
                System.out.println("Invalid input,Please enter a correct number");
                playSong();
            }

        } catch (IOException e) {
            System.out.println("Sorry for inconvenience ,Can't play the song");
            displaymain();// to go back to main menu
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");
            playSong();
        }

    }


    private static void playSong() {

        try {
            System.out.println("0. To go back to main menu");
            Scanner play = new Scanner(System.in);
            int number = play.nextInt();

            if (number < 21 && number > 0) {
                number = number - 1;// to acess array
                String song = songList.get(number);
                String png = albumList.get(number);
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
                displaymain();

            } else {
                System.out.println("Invalid input,Please enter a correct number");
                playSong();
            }

        } catch (IOException e) {
            System.out.println("Sorry for inconvenience ,Can't play the song");
            displaymain();// to go back to main menu
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Invalid input,Please enter a correct number");
            playSong();
        }

    }

}

