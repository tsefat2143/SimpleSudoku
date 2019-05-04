import java.util.List;

class Main {
  public static void main(String[] args) throws Exception {
    //*********PUZZLE1*******
    Filereader file1 = new Filereader();
    List<String> list1 = file1.readFile("easy1.csv");
    
    Board puzzle1 = new Board(list1);
    System.out.println("Given Puzzle 1:");
    puzzle1.displayBoard();
    System.out.println();
    
    System.out.println("Answer:");
    if(puzzle1.solve()){
      puzzle1.displayBoard();
	  puzzle1.writeFile("easy1_solution.csv");
	  }
    else
      System.out.print("Can't solve");
    
    file1.close();

    System.out.println("_____________________");       System.out.println();

    //*********PUZZLE2*******
    Filereader file2 = new Filereader();
    List<String> list2 = file2.readFile("easy2.csv");
    
    Board puzzle2 = new Board(list2);
    System.out.println("Given Puzzle 2:");
    puzzle2.displayBoard();
    System.out.println();
    
    System.out.println("Answer:");
    if(puzzle2.solve()){
      puzzle2.displayBoard();
	    puzzle2.writeFile("easy2_solution.csv");
	  }
    else
      System.out.print("Can't solve");

    file2.close();
  }
}