
public class Algorithm {
   public static String alphaBeta (int depth, int beta, int alpha, String move, int player){
           String list = PossibleMoves.possibleMoves();
        
        if (depth==0 || list.length()==0){         
            return move+(Rating.rating(list.length(), depth) * (player*2-1));      
        }
         list = Sort.sorting(list);
            player = 1 - player;

            for (int i=0; i<list.length(); i+=5){
                Moves.makeMove(list.substring(i, i+5));
                Flip.flipBoard();  
                String returnString = alphaBeta(depth -1, beta, alpha, list.substring(i, i+5), player);
                int value = Integer.valueOf(returnString.substring(5));
                Flip.flipBoard();
                Moves.undoMove(list.substring(i,i+5));         
                
                if (player==0){
                    if (value<=beta){
                        beta=value;
                        if (depth==Board.globalDepth){
                            move = returnString.substring(0,5);
                        }
                    } 
                }
                    else {
                        if (value > alpha){
                            alpha = value;
                            if (depth==Board.globalDepth){
                                move = returnString.substring(0,5);  
                            }
                        }
                    }                   
                    if (alpha>=beta){
                        if (player==0) {
                            return move + beta;
                        }
                        else{
                            return move + alpha;
                        }

                    }
            }
                            if (player==0){                  
                                return move+beta;
                            }
                            else {
                                return move + alpha;
                            }
    }
    
}