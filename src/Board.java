import javax.swing.*;
import java.util.*;

public class Board {  
    static int kingPositionC, kingPositionL;
    static int PlayerAsWhite = -1; // -1 =  white. 0 = black
    static int globalDepth = 4; 
    
   
   
    String chessBoard[][]={
        {"r","k","b","q","a","b","k","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"P","P","P","P","P","P","P","P"},
        {"R","K","B","Q","A","B","K","R"}
    };

     public int kingPosC(){
                //Locate King piece
                while (!"A".equals(chessBoard[kingPositionC/8][kingPositionC%8])){
                    kingPositionC++;
                }    
            return kingPositionC;
     
    }
     public int kingPosL(){
                //Locate King piece
            while (!"a".equals(chessBoard[kingPositionL/8][kingPositionL%8])){
           
                 kingPositionL++;
            }

            return kingPositionL;
     
}

public String[][] copyArray(){

    String tempBoard[][] = new String[chessBoard.length][];

   for (int i = 0; i < chessBoard.length; i++) {
       tempBoard[i] = Arrays.copyOf(chessBoard[i], chessBoard[i].length);
  }

  return tempBoard;

}

public void playerAnnouncements(){

    String list = PossibleMoves.possibleMoves();

if (!KingSafetyC.kingSafe() && list.length() > 0 ) { //Check
            
         
    JOptionPane.showMessageDialog(null, "Check!");


    

}
else if  (PossibleMoves.possibleMoves().length() == 0) { // this is to announce checkmate or stalemate
    if (!KingSafetyC.kingSafe()) {
        JOptionPane.showMessageDialog(null, "Checkmate!! You Lose");



         
    } else { // this is to announce checkmate  
        JOptionPane.showMessageDialog(null, "Stalemate!!");


    }

}

}
    public void computerAnnouncements(){

        String list = PossibleMoves.possibleMoves();

        if (!KingSafetyL.kingSafe() && list.length() > 0 ) { //Check


            JOptionPane.showMessageDialog(null, "Check!");

        }
        else if  (PossibleMoves.possibleMoves().length() == 0) { // this is to announce checkmate or stalemate
            if (!KingSafetyL.kingSafe()) {
                JOptionPane.showMessageDialog(null, "Checkmate!! You Win");



            } else { // this is to announce checkmate
                JOptionPane.showMessageDialog(null, "Stalemate!!");


            }

        }

    }



}


