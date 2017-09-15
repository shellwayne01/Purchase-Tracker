package purchaseTracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileHandler {
		
		public void appendToFile(String fileName, String text){
			PrintWriter outStream = null;
			try {
				outStream = new PrintWriter(new FileOutputStream(fileName, true));
				outStream.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			finally{
				if(outStream !=null){
					outStream.close();
				}
				System.out.println("End of appendToFile method");
			}
		}		
}
