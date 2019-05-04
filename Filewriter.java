import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Filewriter {
  PrintWriter out;
  String fileName;
  
  public Filewriter(String fileName) {
    try {
      out = new PrintWriter(new FileWriter(fileName));
      this.fileName = fileName;
    } catch (IOException e) {
      System.out.println("Failed to open file " + fileName);
    }    
  }
  
  public void writeLine(int[][] sudokuBoard){
	  for(int r = 0; r < sudokuBoard.length; r++){
		  for(int c = 0; c < sudokuBoard[0].length; c++){
			  if(c == sudokuBoard[0].length - 1)
				  out.print(sudokuBoard[r][c]);
			  else
				  out.print(sudokuBoard[r][c] + ",");  
		  }
		  out.println();
	  }
  }

  public void close() {
    try {
      out.flush(); //In case something got stuck in the buffer
      out.close(); //Properlly close the file and release control
    } catch (NullPointerException np) {
      System.out.println("Must first initiate the file writer");
    }
  }
}