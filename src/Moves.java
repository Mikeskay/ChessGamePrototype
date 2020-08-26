public class Moves {
    public static void makeMove(String move){
        if (move.charAt(4)!='P'){
            Gameplay.tempBoard[Character.getNumericValue(move.charAt(2))]
            [Character.getNumericValue(move.charAt(3))] = Gameplay.tempBoard[Character.getNumericValue(move.charAt(0))]
            [Character.getNumericValue(move.charAt(1))];
            Gameplay.tempBoard[Character.getNumericValue(move.charAt(0))]
                [Character.getNumericValue(move.charAt(1))] = " ";

                if ("A".equals(Gameplay.tempBoard[Character.getNumericValue(move.charAt(2))]
                [Character.getNumericValue(move.charAt(3))])){
                    Gameplay.tempKingPositionC= 8 * Character.getNumericValue(move.charAt(2))+Character.getNumericValue(move.charAt(3));

                }    
        }
        else{
            Gameplay.tempBoard[1] [Character.getNumericValue(move.charAt(0))] = " ";
            Gameplay.tempBoard[0] [Character.getNumericValue(move.charAt(1))] = String.valueOf(move.charAt(3));
        }    


    }

    public static void undoMove(String move){
        if (move.charAt(4)!='P'){
            Gameplay.tempBoard[Character.getNumericValue(move.charAt(0))]
            [Character.getNumericValue(move.charAt(1))] = Gameplay.tempBoard[Character.getNumericValue(move.charAt(2))]
            [Character.getNumericValue(move.charAt(3))];
            Gameplay.tempBoard[Character.getNumericValue(move.charAt(2))]
                [Character.getNumericValue(move.charAt(3))] = String.valueOf(move.charAt(4));
        
                if ("A".equals(Gameplay.tempBoard[Character.getNumericValue(move.charAt(0))]
                [Character.getNumericValue(move.charAt(1))])){
                    Gameplay.tempKingPositionC = 8 * Character.getNumericValue(move.charAt(0))+Character.getNumericValue(move.charAt(1));

                }  
        
            }
        else{
            Gameplay.tempBoard[1] [Character.getNumericValue(move.charAt(0))] = "P";
            Gameplay.tempBoard[0] [Character.getNumericValue(move.charAt(1))] = String.valueOf(move.charAt(2));
        }    


        
    }
    
}