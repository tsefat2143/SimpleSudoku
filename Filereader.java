import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Filereader{
  BufferedReader in;
  String filename;
  StringTokenizer tokens;
  List<String> list = new ArrayList<>();

  public List<String> readFile(String filename) throws Exception {
    in = new BufferedReader(new FileReader(filename));
    String line = in.readLine();
    StringTokenizer tokens;
    while(line != null){
      tokens = new StringTokenizer(line,",");
      try{
        while(tokens.hasMoreTokens())
        list.add(tokens.nextToken());
      }
      catch(IllegalArgumentException e){
        System.out.println(e + ": " + line);
      }
	  line = in.readLine();
    }
    return list;
  }

 public void close() {
   try {
     in.close();
    } catch (Exception e) {
      System.out.println("Error closing reader " + filename);
    }
  }
}