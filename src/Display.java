import java.util.*;

public  class Display {
        public static void displaymain() {

        boolean input = true;
        validation.cls();
        System.out.println("The Main menus are ");
        System.out.println("1.Songs");
        System.out.println("2.Artists");
        System.out.println("3.Albums");
        System.out.println("4.Genre");
        System.out.println("5.Search");
        System.out.println("6.Exit");
        System.out.print("Please choose the option :");
        do {
            input= true;
            try {
                Scanner ui = new Scanner(System.in);
                String numberString = ui.nextLine();
                if (numberString.trim().isEmpty()) throw new InputMismatchException();
                int user = Integer.parseInt(numberString) ;
                validation.cls();
                if (user > 0 && user <= 6 && user!=0) {
                    switch (user) {
                        case 1:
                             System.out.println("The Song names are");
                            Song.songName();
                            break;
                        case 2:
                            System.out.println("The Artist names are");
                            Process.assignListHashset(ReadFile.artistList);
                            break;
                        case 3:
                            System.out.println("The Album names are");
                            Process.assignListHashset(ReadFile.albumList);
                            break;
                        case 4:
                            System.out.println("The Genre are");
                            Process.assignListHashset(ReadFile.genreList);
                            break;

                        case 5:
                            Search.readInput();
                            break;
                        case 6:
                            input= true;
                            break;
                    }

                } else {
                    System.out.print ("Please enter number from 1 to 5:");
                    input = false;
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.print("Invalid input.Please enter number from 1 to 5:");
                input = false;

            }
        } while (!input);

    }




}

