import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to write a list of words to a file.
 */
public class MyFileWriter {
	
	/**
	 * Name of file being written to.
	 */
	private String filename;
	
	/**
	 * Creates MyFileWriter with given filename to write to.
	 * @param filename to write to
	 */
	public MyFileWriter(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Opens the file specified by filename and writes each word in the given list of words to the file.
	 * Each word is written to a new line in the file.
	 *
	 * Example(s):
	 * - If the given list of words contains: "a", "he", "in", "of", "to"
	 * Calling writeToFile(ArrayList<String> words) will open the file, then write each word in the 
	 * given list of words to the file, in the following format:
	 * a
	 * he
	 * in
	 * of
	 * to
	 * 
	 * @param list of words to write to the file
	 */
	public void writeToFile(ArrayList<String> words) {
		
		//TODO Implement method
		FileWriter fw = null;
		BufferedWriter bw = null;

		try{
			fw = new FileWriter(this.filename);
			bw = new BufferedWriter(fw);

			for(String word : words){
				bw.write(word);
				bw.newLine();
			}

			bw.flush();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			try{
				fw.close();
				bw.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}