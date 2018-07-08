package driver;

import myTree.BSTBuilder;
import util.Results;

public class Driver{

	public static void main(String[] args) {

		String inputFile = null;
		String deleteFile = null;
		String output = null;
		String output1 = null;
		String output2 = null;

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
			output = args[2];
			if (!(output.equals("output1.txt"))) {
				System.out.println("No Output File found, please check!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check");
			System.exit(0);
		}
		try {
			output1 = args[3];
			if (!(output1.equals("output2.txt"))) {
				System.out.println("Output File not found, please check");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check!");
			System.exit(0);
		}
		try {
			output2 = args[4];
			if (!(output2.equals("output3.txt"))) {
				System.out.println("Output File not found, please check");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check");
			System.exit(0);
		}

	}

//


}
