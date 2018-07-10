/**
 *Class to print out the output to respective files
 */

package util;


/**
 *Importing the required Java classes
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 *Results class to write the output to the output files
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	PrintWriter printWriter;
	int counter = 0;
	private String[] array = new String[1000];
	public String mainarray;
	boolean flag = false;
	FileWriter f;
	static int i = 0;
	File f1 = new File("output1.txt");
	File f2 = new File("output2.txt");
	File f3 = new File("output3.txt");

	public void printToFile(String s) {
		mainarray = (String) (array[counter] = s);
		writeToFile(mainarray);
		counter++;
	}

	public void writeToFile(String s) {
		try {
			if (s.contains("Printing elements")) {
				if (i == 0) {
					f = new FileWriter(f1);
					i++;
				} else if (i == 1) {
					f = new FileWriter(f2);
					i++;
				} else if (i == 2) {
					f = new FileWriter(f3);
					i++;
				}

				if (i >= 3) {
					i = 2;
					Files.write(Paths.get("output" + i + ".txt"), s.getBytes(), StandardOpenOption.APPEND);
					Files.write(Paths.get("output" + i + ".txt"), "\n".getBytes(), StandardOpenOption.APPEND);
					i++;
				}

			}
			Files.write(Paths.get("output" + i + ".txt"), s.getBytes(), StandardOpenOption.APPEND);
			Files.write(Paths.get("output" + i + ".txt"), "\n".getBytes(), StandardOpenOption.APPEND);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
