import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyFileWriterTest {
	
	MyFileWriter myFileWriter1; 
	
	@BeforeEach
	void setUp() throws Exception {
		this.myFileWriter1 = new MyFileWriter("output_test.txt");  // test output file
	}
	
	@Test
	public void testWriteToFile() {
		
		// TODO write at least 1 test case using myFileWriter1
		// Hint(s):
		// - Create an ArrayList<String> to store a list of words to write to the test file "output_test.txt"
		// - Call writeToFile to write the list of words to the file
		// - Call readWrittenFile to read the written file and compare its contents to the defined ArrayList of words above
		ArrayList<String> actual = new ArrayList<String>();
        actual.add("Lines Other Info");
		actual.add("\"The Project Gutenberg EBook of War and Peace, by Leo Tolstoy\"");
		actual.add("Author: Leo Tolstoy");
		actual.add("CHAPTER I");
		actual.add("\"Well, Prince, so Genoa and Lucca are now just family estates of the\"");
		actual.add("\"Buonapartes. But I warn you, if you don't tell me that this means war,\"");
		actual.add("if you still try to defend the infamies and horrors perpetrated by that");

        this.myFileWriter1.writeToFile(actual);

        ArrayList<String> expected = readWrittenFile("output_test.txt");

        assertEquals(expected, actual);
	}
	
	/**
	 * Helper method for reading in the written file to check its contents.
	 * @param writtenFilename 
	 * @return an ArrayList of the lines from the written file
	 */
	public ArrayList<String> readWrittenFile(String writtenFilename) {
		ArrayList<String> expectedLines = new ArrayList<String>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(writtenFilename));
			String line = file.readLine();
			while (line != null) {
				expectedLines.add(line);
				line = file.readLine();
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return expectedLines;
	}
}