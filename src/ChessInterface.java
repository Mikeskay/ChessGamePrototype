import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessInterface extends JPanel implements MouseListener, MouseMotionListener{

    static int mouseX, mouseY, newMouseX, newMouseY;
    static int squareSize = 32;

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.setOpaque(false);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        for (int i=0; i<64; i+=2){
            graphics.setColor(new Color(255,200,100));
            graphics.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
            graphics.setColor(new Color(150,50,30));
            graphics.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
        }

        
     
        Image chessPiecesImage;
        chessPiecesImage = new ImageIcon("ChessPieces.png").getImage();
        for (int i=0; i<64; i++){
            int j = -1, k = -1;
            switch (Gameplay.tempBoard[i/8][i%8]){
                case "P": j=5; k=0;
                break;
                case "p": j=5; k=1;
                break;
                case "R": j=2; k=0;
                break;
                case "r": j=2; k=1;
                break;
                case "K": j=4; k=0;
                break;
                case "k": j=4; k=1;
                break;
                case "B": j=3; k=0;
                break;
                case "b": j=3; k=1;
                break;
                case "Q": j=1; k=0;
                break;
                case "q": j=1; k=1;
                break;
                case "A": j=0; k=0;
                break;
                case "a": j=0; k=1;
                break;
            }
            if (j!=-1 && k!=-1){
                graphics.drawImage(chessPiecesImage, (i%8)*squareSize, (i/8)*squareSize, 
                (i%8+1)*squareSize, (i/8+1)*squareSize, j*64, k*64, (j+1)*64, (k+1)*64, this);
            }
        }      

    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX()<8 * squareSize && e.getY()<8*squareSize){
            mouseX = e.getX();
            mouseY = e.getY();
            repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX()<8*squareSize && e.getY()<8*squareSize){
            newMouseX = e.getX();
            newMouseY = e.getY();
            if (e.getButton() == MouseEvent.BUTTON1){
                String dragMove;
                if (newMouseY/squareSize == 0 && mouseY/squareSize == 1 && 
                "P".equals(Gameplay.tempBoard[mouseY/squareSize][mouseX/squareSize])){
                    //Pawn upgrade
                    dragMove = ""+mouseX/squareSize+newMouseX/squareSize+
                            Gameplay.tempBoard[newMouseY/squareSize][newMouseX/squareSize]+"QP";
                }
                    //Normal Move
                else{
                    dragMove = ""+mouseY/squareSize+mouseX/squareSize+
                    newMouseY/squareSize+newMouseX/squareSize+Gameplay.tempBoard[newMouseY/squareSize][newMouseX/squareSize];
                }
                String userPosibilities = PossibleMoves.possibleMoves();
                if (userPosibilities.replaceAll(dragMove, "").length() < userPosibilities.length()){
                    //if valid move
                    Moves.makeMove(dragMove);
                    Flip.flipBoard();
                    Moves.makeMove(Algorithm.alphaBeta(Board.globalDepth, 1000000, -1000000, "", 0));
                    Flip.flipBoard();
                    repaint();
                }
            }
            
            repaint();
        }
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}