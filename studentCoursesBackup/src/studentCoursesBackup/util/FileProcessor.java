/**
 *Class to read the input text files line by line using the method readLine()
 */


/**
 *Declaring the package
 */
package util;

/**
 *Importing the required java classes
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileProcessor {

	Scanner in;

    /**
     *Method to read the text file line by line
     */
	public String ReadLine(String inputFile) {
		String file = inputFile;
		try {
			if (in == null) {
				in = new Scanner(new File(file));
			}

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				if (br.readLine() == null) {
					System.out.println("File is empty, Please check!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (in.hasNext()) {
				String curr;
				curr = in.nextLine();
				return curr;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found, Please check!");
		}
		return null;
	}
}
