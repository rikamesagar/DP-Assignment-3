/**
 *This file contains the main method
 *It creates the instance of TreeBuilder and Results
 */

package driver;

/**
 *Importing TreeBuilder and Results from respective packages
 */
import util.TreeBuilder;
import util.Results;

public class Driver{

	public static void main(String[] args) {


        /**
         *String Variables for the files red from the command line arguments
         */
		String inputFile = null;
		String deleteFile = null;
		String output1;
		String output2;
		String output3;

        /**
         *Code to check the files if/ if not passed through arguments
         */
		try {
			inputFile = args[0];
			if (!(inputFile.equals("input.txt"))) {
				System.out.println("Input File not found, please check!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not Found, please check!");
			System.exit(0);
		}
		try {
			deleteFile = args[1];
			if (!(deleteFile.equals("delete.txt"))) {
				System.out.println("Delete File not found, please check!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("No file present to delete values from Nodes");
			System.exit(0);
		}
		try {
			output1 = args[2];
			if (!(output1.equals("output1.txt"))) {
				System.out.println("No Output File found, please check!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check");
			System.exit(0);
		}
		try {
			output2 = args[3];
			if (!(output2.equals("output2.txt"))) {
				System.out.println("Output File not found, please check");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check!");
			System.exit(0);
		}
		try {
			output3 = args[4];
			if (!(output3.equals("output3.txt"))) {
				System.out.println("Output File not found, please check");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check");
			System.exit(0);
		}

        /**
         *TreeBuilder and Results objects created and respective methods called
         */
		TreeBuilder builder = new TreeBuilder();
		builder.create(inputFile);
		Results res = new Results();

		res.printToStdout("Printing elements of the Main Node");
		res.printToFile("Printing elements of the Main Node");

		res.printToStdout("___________________________________");
		res.printToFile("__________________________________");

		builder.printInOrder();

		builder.deleteCreateValue(deleteFile);

	}
}
