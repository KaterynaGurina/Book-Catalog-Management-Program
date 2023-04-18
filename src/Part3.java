// -----------------------------------------------------
// Assignment 3 Part 1
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------
import java.io.*;
import java.util.*;
/**
 * This class provides functionality for viewing and selecting book data from a list of serialized book arrays.
 * The user is presented with a menu to select a file, view its contents, or exit the program.
 * The class also contains methods for displaying the contents of a selected file and for selecting a file from the list.
 */
public class Part3 {
	/**
	 * This method provides the main functionality of the Part3 class. The method creates an array list of Book arrays
	 * from serialized files, and then prompts the user to select a file to view. The method displays a menu with options
	 * to view the selected file, select a different file, or exit the program.
	 */
    public static void do_part3() {
        String[] filenames = {
            "Cartoons_Comics.csv.ser",
            "Hobbies_Collectibles.csv.ser",
            "Movies_TV_Books.csv.ser",
            "Music_Radio_Books.csv.ser",
            "Nostalgia_Eclectic_Books.csv.ser",
            "Old_Time_Radio_Books.csv.ser",
            "Sports_Sports_Memorabilia.csv.ser",
            "Trains_Planes_Automobiles.csv.ser"
        };

        ArrayList<Book[]> bookArrays = new ArrayList<>();

        for (String filename : filenames) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                bookArrays.add((Book[]) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        Scanner scanner = new Scanner(System.in);
        int selectedIndex = 0;
        String input;

        do {
            System.out.println("-----------------------------");
            System.out.println("Main Menu");
            System.out.println("-----------------------------");
            System.out.println("v View the selected file: " + filenames[selectedIndex] + " (" + bookArrays.get(selectedIndex).length + " records)");
            System.out.println("s Select a file to view");
            System.out.println("x Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter Your Choice: ");
            input = scanner.nextLine().toLowerCase();

            if ("v".equals(input)) {
            	System.out.println("Viewving: " + filenames[selectedIndex]);
                viewFile(bookArrays.get(selectedIndex));
            } 
            else if ("s".equals(input)) {
                selectedIndex = selectFile(scanner, filenames, bookArrays) - 1;
            }
        } while (!"x".equals(input));
    }
    /**
     * This method displays the contents of a given book array to the console. The method prompts the user to enter a
     * number, and then displays that many records from the array, starting from the current index. The current index is
     * updated based on the user input, and the method continues prompting the user until the user enters 0.
     * If the user enters a positive number n, the method displays the next n records from the current index. If there
     * are not enough records left in the array, the method displays all the remaining records.
     * If the user enters a negative number -n, the method displays the previous n records from the current index. If
     * there are not enough records before the current index, the method displays all the records up to the beginning
     * of the array.
     * If the user enters 0, the method exits and returns to the main menu.
     *
     * @param books the array of books to be displayed
     */   
    //So confused 
    public static void viewFile(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        int currentIndex = 0;
        int input;

        do {
            System.out.print("Enter your number: ");
            input = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            if (input > 0) {
                for (int i = 0; i < input && currentIndex + i < books.length; i++) {
                    System.out.println(books[currentIndex + i]);
                }
                currentIndex += Math.min(input - 1, books.length - currentIndex - 1);
                if (currentIndex == books.length - 1) {
                    System.out.println("EOF has been reached");
                }
            } else if (input < 0) {
                for (int i = input + 1; i <= 0 && currentIndex + i >= 0; i++) {
                    System.out.println(books[currentIndex + i]);
                }
                currentIndex += Math.max(input + 1, -currentIndex);
            }
        } while (input != 0);
    }
    /**
     * This method displays a submenu of available files to the console and prompts the user to select one. The method
     * reads the user's input from the console and returns the index of the selected file.
     *
     * @param scanner the Scanner object used to read user input from the console
     * @param filenames an array of filenames to display in the submenu
     * @param bookArrays a list of arrays of Book objects corresponding to the filenames
     * @return the index of the selected file in the filenames array (1-indexed), or 9 if the user chooses to exit
     */
    
    public static int selectFile(Scanner scanner, String[] filenames, List<Book[]> bookArrays) {
        System.out.println("------------------------------");
        System.out.println("File Sub-Menu");
        System.out.println("------------------------------");

        for (int i = 0; i < filenames.length; i++) {
            System.out.println((i + 1) + " " + filenames[i] + " (" + bookArrays.get(i).length + " records)");
        }

        System.out.println("9 Exit");
        System.out.println("------------------------------");
        System.out.print("Enter Your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        return choice;
    }
}