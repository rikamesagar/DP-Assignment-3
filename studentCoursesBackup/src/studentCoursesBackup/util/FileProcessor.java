package util;



public class FileProcessor {

	Scanner in;
	public String ReadLine(String inputFile) {
		String file = inputFile;
		try {
			if (in == null) {
				in = new Scanner(new File(file));
			}

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				if (br.readLine() == null) {
					System.out.println("No errors, and file empty");
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
			System.out.println("File not found");
		}
		return null;
	}
}
