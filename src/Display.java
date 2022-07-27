import java.util.*;

public  class Display {
        public static void displaymain() {
        boolean input = true;
        do {

        validation.cls();
        System.out.println("The Main menus are ");
        System.out.println("1.Songs");
        System.out.println("2.Artists");
        System.out.println("3.Albums");
        System.out.println("4.Genre");
        System.out.println("5.Search");
        System.out.println("6.Exit");
        System.out.print("Please choose the option : ");


            try {
                Scanner ui = new Scanner(System.in);
                String numberString = ui.nextLine();
                if (numberString.trim().isEmpty()) throw new InputMismatchException();
                int user = Integer.parseInt(numberString) ;
                //validation.cls();
                if (user > 0 && user <= 6 && user!=0) {
                    switch (user) {
                        case 1:
                            System.out.println("The Song names are");

                            Song.songName();
                            input=false;
                            break;
                        case 2:
                            System.out.println("The Artist names are");
                            Process.assignListHashset(ReadFile.artistList);
                            input =false;
                            break;
                        case 3:
                            System.out.println("The Album names are");
                            Process.assignListHashset(ReadFile.albumList);
                            input =false;
                            break;
                        case 4:
                            System.out.println("The Genre are");
                            Process.assignListHashset(ReadFile.genreList);
                            input =false;
                            break;

                        case 5:
                            Search.readInput();
                            input =false;
                            break;
                        case 6:
                            System.out.println("Thanks for choosing Spotifoo");
                            System.exit(1);
                            break;
                    }

                } else {
                    System.out.println ("Please enter number from 1 to 6 from the menu list");
                    input = false;
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Invalid input.Please enter number from 1 to 6 from the menu list ");
                input = false;

            }
        } while (!input);

    }




}

