import java.util.ArrayList;
import java.util.List;

public class Board{
  int [][] sudokuBoard;

  public Board(List<String> list){
    sudokuBoard = new int[9][9];
		String[] array = list.toArray(new String[0]);
    int i = 0;

    for(int r = 0; r < 9; r++){
      for(int c =0; c < 9; c++){
        sudokuBoard[r][c] = Integer.parseInt(list.get(i));
        i++;
      }
    }
  }

 public void displayBoard(){
   for(int r = 0; r < sudokuBoard.length; r++){
     for(int c = 0; c < sudokuBoard[0].length; c++){
       System.out.print(sudokuBoard[r][c] + " ");
     }
     System.out.println();
   }
 }

 public boolean checkRow(int row, int n){
   for(int i = 0; i < sudokuBoard.length; i++){
     if(sudokuBoard[row][i] == n)
       return true;
   }
   return false;
 }

 public boolean checkColumn(int col, int n){
   for(int i = 0; i < sudokuBoard[0].length; i++){
     if(sudokuBoard[i][col] == n)
      return true;
   }
   return false;
 }

 public boolean check3by3(int row, int col, int n){
   int subRow = row - (row % 3);
   int subCol = col -(col % 3);

   for(int i = subRow; i < subRow + 3; i++){
     for(int a = subCol; a < subCol + 3; a++){
       if(sudokuBoard[i][a] == n)
        return true;
     }
   }
   return false;
 }

 public boolean solve(){
   for (int r = 0; r < sudokuBoard.length; r++){
     for (int c = 0; c < sudokuBoard[0].length; c++){
       if (sudokuBoard[r][c] == 0){
         for(int n = 1; n <= 9; n++){
           if ((!checkRow(r,n)) && (!checkColumn(c,n)) && (!check3by3(r,c,n))){
             sudokuBoard[r][c] = n;
             if(solve()){
               return true;
             }
             else{
               sudokuBoard[r][c] = 0;
             }
           }
         }
         return false;
       }
     }
   }
   return true;
 }
 public void writeFile(String fileName){
	 Filewriter writer = new Filewriter(fileName);
	 writer.writeLine(sudokuBoard);
	 writer.close();
 }
}