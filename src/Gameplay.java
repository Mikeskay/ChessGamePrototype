
import java.util.*;
import javax.swing.*;

public class Gameplay {

    static Board board = new Board();
    static int tempKingPositionC = board.kingPosC();
    static int tempKingPositionL = board.kingPosL();
    static String tempBoard[][] = board.copyArray();



    public static void main(String[] args) {


        JFrame frame = new JFrame("Michael Kolawole: My Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChessInterface ui=new ChessInterface();
        frame.add(ui);
        frame.setSize(500, 500);
        frame.setVisible(true);

        Object[] option1 = {"Computer", "Player"};
       

        Board.PlayerAsWhite = JOptionPane.showOptionDialog(null, "Who should play as white?",
                        "Player Options", JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE, null, option1, option1[1]);
                         if (Board.PlayerAsWhite == 0){
                             long startTime = System.currentTimeMillis();
                            Moves.makeMove(Algorithm.alphaBeta(Board.globalDepth, 1000000, -1000000, "", 0));
                            long endTime = System.currentTimeMillis();
                            System.out.println("That took "+(endTime-startTime)+" millseconds");
                            Flip.flipBoard();
                            frame.repaint();
                         }
                       

    }
   

   


}
