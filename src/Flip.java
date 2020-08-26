public class Flip {

    public static void flipBoard(){
        String temp;

        for (int i=0; i<32; i++){
            int r=i/8, c=i%8;
            if (Character.isUpperCase(Gameplay.tempBoard[r][c].charAt(0))){
                temp = Gameplay.tempBoard[r][c].toLowerCase();
            }
            else {
                temp = Gameplay.tempBoard[r][c].toUpperCase();
            } 
            if (Character.isUpperCase(Gameplay.tempBoard[7-r][7-c].charAt(0))){
                Gameplay.tempBoard[r][c]=Gameplay.tempBoard[7-r][7-c].toLowerCase();
            }
            else {
                Gameplay.tempBoard[r][c]=Gameplay.tempBoard[7-r][7-c].toUpperCase();
            }
            Gameplay.tempBoard[7-r][7-c] = temp;
        }

        int kingTemp = Gameplay.tempKingPositionC;
        Gameplay.tempKingPositionC = 63 - Gameplay.tempKingPositionL;
        Gameplay.tempKingPositionL = 63 - kingTemp;


    }

    
    
}