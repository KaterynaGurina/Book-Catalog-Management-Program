// -----------------------------------------------------
// Assignment 3 Part 1
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Part1 reads input file names from "Part1_input_file_names.txt", 
 * creates 8 output files based on book genre and parses each input file. 
 * It checks for syntax errors and outputs the problematic lines to "syntax_error_file.txt". 
 * If an input file is not found, it's skipped. Output files are named after their genres, 
 * and populated with input file lines separated by a comma. Unrecognized genres are sent to "syntax_error_file.txt".
 */
public class Part1 {
	/**
	* The do_part1 method is the main method of Part1. It reads in a list of input file names from "Part1_input_file_names.txt",
	* creates the output files, and then reads and parses each input file.
	*/
    public static void do_part1() {
//read the input file names from Part1_input_file_names.txt to a String array
		File inputFile = new File("Part1_input_file_names.txt");
		Scanner input = null;
		try {
			input = new Scanner (new FileInputStream (inputFile));
		}
		catch(FileNotFoundException e) {
			System.out.print("Something went wrong, cannot read from this file");
		}
		
		int numOfNames = input.nextInt();
		input.nextLine();
		String [] fileNames = new String[numOfNames];
		
		while(input.hasNextLine()) {
			for (int i = 0; i < fileNames.length; i++) {
				fileNames[i] = input.nextLine();
			}
		}
		input.close();
		System.out.println(Arrays.toString(fileNames));
		
//Create the output files
		ArrayList<String> outputFilesCodes = new ArrayList<String> (Arrays.asList("CCB", "HCB", "MTV" ,"MRB", "NEB", "OTR", "SSM", "TPA"));
		
		String[] outputFiles = {"Cartoons_Comics.csv.txt",
				"Hobbies_Collectibles.csv.txt",
				"Movies_TV_Books.csv.txt",
				"Music_Radio_Books.csv.txt",
				"Nostalgia_Eclectic_Books.csv.txt",
				"Old_Time_Radio_Books.csv.txt",
				"Sports_Sports_Memorabilia.csv.txt",
				"Trains_Planes_Automobiles.csv.txt"};

        PrintWriter[] output = new PrintWriter[outputFiles.length];
        PrintWriter errorOutput = null;
		for (int i = 0; i<outputFiles.length; i++) {
            try {
                PrintWriter writer = new PrintWriter(new FileOutputStream( new File(outputFiles[i])));
                output[i] = writer;
            } 
            catch (IOException e) {
                System.out.println("Cannot create output file: " + outputFiles[i]);
            }
        }
		try {
			errorOutput = new PrintWriter( new FileOutputStream ("syntax_error_file.txt"));
		}
		catch (IOException e) {
            System.out.println("Cannot create output file: syntax_error_file.txt");
        }
		
		
		
//Loop through the fileNames and for each file, open it using a BufferedReader (using try with resources statement) and read each line of the file.
		
		for (int i = 0; i<fileNames.length; i++) {
			String[] fields;
			String line;
			String[] defaultFields = {"title", "authors", "price", "isbn", "genre", "year"};
			StingFieldsBook book;
			try (BufferedReader bufInput = new BufferedReader (new FileReader(fileNames[i]))){
				while ((line = bufInput.readLine()) != null) {
					
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
					
					if (fields.length!=6) {
						if (fields.length > 6) {
		                    throw new TooManyFieldsException("Too many fields in record: \n" + line + "\n");
		                } else {
		                    throw new TooFewFieldsException("Too few fields in record: \n" + line + "\n");
		                }
					}
					book = new StingFieldsBook(fields);
					for (int j = 0; j<fields.length; j++){
						if(fields[j].equals("")) {
							throw new MissingFieldException("Missing " + defaultFields[j] + " field in record: \n" + line + "\n");
						}
					}
						    
					if (!outputFilesCodes.contains(book.genre)) {
						throw new UnknownGenreException("Unknown genre in record: \n" + line + "\n");
					}
					//now that we finally checked for all the possible mistakes we can put this book in a record
					int index = outputFilesCodes.indexOf(book.genre);
					output[index].println(line);
					
				}	
			}
			catch(FileNotFoundException e) {
				System.out.println("File not found: " + fileNames[i]);
			}
			catch(TooManyFieldsException e) {
				errorOutput.println("Syntax error in File: " + fileNames[i]);
				errorOutput.println("=====================");
				errorOutput.println(e.getMessage());
				
			}
			catch(TooFewFieldsException e) {
				errorOutput.println("Syntax error in File: " + fileNames[i]);
				errorOutput.println("=====================");
				errorOutput.println(e.getMessage());
			}
			catch(MissingFieldException e) {
				errorOutput.println("Syntax error in File: " + fileNames[i]);
				errorOutput.println("=====================");
				errorOutput.println(e.getMessage());
			}
			catch(UnknownGenreException e) {
				errorOutput.println("Syntax error in File: " + fileNames[i]);
				errorOutput.println("=====================");
				errorOutput.println(e.getMessage());
			}
			catch(IOException e){
				System.out.print("Cannot read from this file " + fileNames[i]);
				errorOutput.println("=====================");
				 e.printStackTrace();
			}
		}
		for (PrintWriter writer : output) {
		    writer.close();
		}
		errorOutput.close();
	}
}
