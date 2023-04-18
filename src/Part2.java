// -----------------------------------------------------
// Assignment 3 Part 1
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * Part2 checks the input files for the semantic errors and then serializes the valid records in binary files
 *
 */
public class Part2 {
	/**
	 * The method reads the input files and checks for semantic errors such as invalid price, year, or ISBN. 
	 * Valid records are then written to their corresponding output files, which are named based on the genre of the books in the input files. 
	 * Invalid records are written to "semantic_error_file.txt".
	 */
    public static void do_part2() {
		
//Open the input files
		String[] inputFiles = {"Cartoons_Comics.csv.txt",
				"Hobbies_Collectibles.csv.txt",
				"Movies_TV_Books.csv.txt",
				"Music_Radio_Books.csv.txt",
				"Nostalgia_Eclectic_Books.csv.txt",
				"Old_Time_Radio_Books.csv.txt",
				"Sports_Sports_Memorabilia.csv.txt",
				"Trains_Planes_Automobiles.csv.txt"};
		
//Create the output files
		String[] outputFiles = {"Cartoons_Comics.csv.ser",
				"Hobbies_Collectibles.csv.ser",
				"Movies_TV_Books.csv.ser",
				"Music_Radio_Books.csv.ser",
				"Nostalgia_Eclectic_Books.csv.ser",
				"Old_Time_Radio_Books.csv.ser",
				"Sports_Sports_Memorabilia.csv.ser",
				"Trains_Planes_Automobiles.csv.ser"};
		
		ObjectOutputStream[] outputStreamArr= new ObjectOutputStream[outputFiles.length];
		PrintWriter errorOutput = null;
		for (int i = 0; i< outputFiles.length; i++) {
			try {
				ObjectOutputStream output = new ObjectOutputStream ( new FileOutputStream (outputFiles[i]));
				outputStreamArr[i] = output;
			}
			catch (IOException e) {
				System.out.println("Cannot creat the output file: " + e.getMessage());
			}
		}
		try {
			errorOutput = new PrintWriter( new FileOutputStream ("semantic_error_file.txt"));
		}
		catch (IOException e) {
            System.out.println("Cannot create output file: syntax_error_file.txt");
        }
		

//read from the input files and check for semantic errors: price: field isbn, year
//iterating thru a known number of input files
		for (int i = 0; i< inputFiles.length; i++) {
			
			String[] fields = new String[6];
			String line;
			Book book;
			ArrayList<Book> books= new ArrayList<Book>();
			
			try (BufferedReader inputStream = new BufferedReader (new FileReader(inputFiles[i]))){
//				System.out.println("****************\n");
//				System.out.println("Reading thru file: " + inputFiles[i]);
				//iterating thru an unknown number of lines in each input file 
				while ((line = inputStream.readLine()) != null) {
//					System.out.println("Reading line: " + line);
					if (line.startsWith("\"")) {
					    int closingQuoteIndex = line.indexOf("\"", 1); // find index of closing quote
					    String firstField = line.substring(1, closingQuoteIndex); // extract first field *****check to get rid of the ""
					    String restOfLine = line.substring(closingQuoteIndex + 2); // extract rest of line
					    String[] restOfLineFields = restOfLine.split(",", -1); // split rest of line by commas
					    fields = new String[restOfLineFields.length + 1]; // create new array with size increased by 1
					    fields[0] = firstField; // add first field to array
					    System.arraycopy(restOfLineFields, 0, fields, 1, restOfLineFields.length); // copy rest of fields to array
					} 
					else {
					    fields = line.split(",", -1); // split line by commas
					}
					//*******************************************************************************
					try {
					String[] isbnS = fields[3].split("");
					int[] isbn = new int[isbnS.length];
					
//					System.out.println(Arrays.toString(isbnS));
					
					for(int j = 0; j < isbnS.length; j++) {
						isbn[j] = Integer.parseInt(isbnS[j]);
					}
					
					book = new Book(fields[0], fields[1], Double.parseDouble(fields[2]), isbn, fields[4], Integer.parseInt(fields[5]));
					
					if (book.price<0) {
						throw new BadPriceException("Invalid price in record: \n" + line + "\n");
					}
					if ((book.year < 1995) || (book.year > 2010)){
						throw new BadYearException("Invalid year in record: \n" + line + "\n");
					}
					if ((book.isbn.length != 10)&&(book.isbn.length != 13)) {
						throw new BadIsbnLengthException ("Invalid ISBN length in record: \n" + line + "\n");
					}
//					System.out.println("The isbn is correct lenth. Now checking if it is valid");
					
					if ((book.isbn.length == 10) && !(isbn10Check(book.isbn))){
						throw new BadIsbn10Exception("Invalid ISBN10 in record: \n" + line + "\n");
						
					}
					else if ((book.isbn.length == 13) && !(isbn13Check(book.isbn))) {						
							throw new BadIsbn13Exception("Invalid ISBN13 in record: \n" + line + "\n");
					}
//					else {
//						System.out.println("The Isbn is valid");
//						if (book.isbn.length == 10) {
//							System.out.println("It has 10 digits");
//							System.out.println((isbn10Check(book.isbn)));
//						}
//						else {
//							System.out.println("It has 13 digits");
//							System.out.println((isbn13Check(book.isbn)));
//							}
//					}
					
					books.add(book);
					}
					catch(NumberFormatException e) {
						errorOutput.println("Semantic error in File: " + inputFiles[i]);
						errorOutput.println("=====================");
						errorOutput.println("Isbn exception " + e.getMessage() + ". Isbn contains a non-numeric charachter in record: \n" + line+ "\n");
					}
					catch (BadPriceException | BadYearException | BadIsbnLengthException | BadIsbn10Exception | BadIsbn13Exception e) {
		                errorOutput.println("Semantic error in File: " + inputFiles[i]);
		                errorOutput.println("=====================");
		                errorOutput.println(e.getMessage());
		            }
				}
				//now that we have the array of book objects containing valid records we serialize it into a binary file 
				outputStreamArr[i].writeObject(books.toArray(new Book[0]));
				//System.out.println("Array "+ Arrays.deepToString(books.toArray()) + "\n writen to file " + outputFiles[i]);
			}
			catch(IOException e) {
				System.out.println("There seems to be a problem with input or output from " + inputFiles[i]);
				errorOutput.println("=====================");
				 e.printStackTrace();
			}
		}
		for (int k = 0; k < outputFiles.length; k++) {
		    try {
		        if (outputStreamArr[k] != null) {
		            outputStreamArr[k].close();
		        }
		    } catch (IOException e) {
		        System.out.println("Error closing the output stream: " + e.getMessage());
		    }
		}
		errorOutput.close();
	}
    //returns true is the isbn 10 is valid
	public static boolean isbn10Check(int [] isbn) {
		int sum = 0;
		for (int i = 0; i<10; i++) {
			sum += (10-i)*isbn[i];
		}
//		System.out.println("The sum is: " + sum);
		return sum%11==0;
	}
	public static boolean isbn13Check(int[] isbn) {
		int sum = 0;
		for (int i = 0; i<13; i+=2) {
			sum += isbn[i];
		}
		for (int i = 1; i<13; i+=2) {
			sum += 3*isbn[i];
		}
//		System.out.println("The sum is: " + sum);
		return sum%10==0;
	}
}
