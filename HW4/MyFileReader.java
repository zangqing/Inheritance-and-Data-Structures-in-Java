import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to read lines from a file.
 */
public class MyFileReader {

	/**
	 * Name of file being read.
	 */
	private String filename;

	/**
	 * Creates MyFileReader with given filename to read.
	 * @param filename to read
	 */
	public MyFileReader(String filename) {
		this.filename = filename;
	}

	/**
	 * Opens the file specified by filename and reads the text line by line.
	 * Cleans up each line by trimming whitespace from the beginning and end of each line.
	 * Adds each line to an ArrayList<String> which is returned from the method.
	 * If a line is empty (does not contain any text), it's skipped and is not added to the ArrayList<String>.
	 * 
	 * Example:
	 * - Calling getCleanContent() will open and read the file, clean up the text line by line,
	 * add each line containing text to an ArrayList<String>, and return the ArrayList<String> from the method.
	 *   If there is a line "nice to meet you     ", it will become "nice to meet you"
	 *   If there is a line "    hello world    ", it will become "hello world"
	 *   If there is a line "today is a nice day", it will remain "today is a nice day"
	 *   If there is a line " ", it will be skipped and not added to the ArrayList<String>
	 * 
	 * @return list of lines with no empty spaces at the beginning or end of each line
	 */
	public ArrayList<String> getCleanContent() {

		ArrayList<String> lines = new ArrayList<String>();
		
		//TODO Implement method
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(this.filename);
            br = new BufferedReader(fr);

            String cleanedLines;

            while((cleanedLines = br.readLine()) != null){
                cleanedLines = cleanedLines.trim();
                if(!cleanedLines.isEmpty())
                    lines.add(cleanedLines);
            }
        } catch(FileNotFoundException e){
            //gets and prints filename
			System.out.println("Sorry, " + this.filename + " not found.");
        } catch(IOException e){
            //prints the error message and info about which line
			e.printStackTrace();
        } finally {
            //regardless, close file objects
            try{
                fr.close();
                br.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }

		return lines;
	}
}