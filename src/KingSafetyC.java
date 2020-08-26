public class KingSafetyC {
    public static boolean kingSafe(){
        //bishop/queen 
        int temp = 1;
        for (int i=-1; i<=1; i+=2){
            for (int j=-1; j<=1; j+=2){
                try {
                    while(" ".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+temp*i][Gameplay.tempKingPositionC%8+temp*j])){
                        temp++;
                    }
                    if ("b".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+temp*i][Gameplay.tempKingPositionC%8+temp*j])||
                    
                        "q".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+temp*i][Gameplay.tempKingPositionC%8+temp*j])){

                        return false;

                    }

                }catch (Exception e){}

                temp = 1;

                }
            }       

         //rook/queen
         for (int i=-1; i<=1; i+=2){
                 try {
                     while(" ".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8][Gameplay.tempKingPositionC%8+temp*i])){
                         temp++;
                     }
                     if ("r".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8][Gameplay.tempKingPositionC%8+temp*i])||
                            
                        "q".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8][Gameplay.tempKingPositionC%8+temp*i])){

                         return false;

                     }

                 }catch (Exception e){}

                 temp = 1;

                 try {
                    while(" ".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+temp*i][Gameplay.tempKingPositionC%8])){
                        temp++;
                    }
                    if ("r".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+temp*i][Gameplay.tempKingPositionC%8])||
                           
                       "q".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+temp*i][Gameplay.tempKingPositionC%8])){

                        return false;

                    }
                }catch (Exception e){}

                temp = 1;

        }

        //knight
          for (int i=-1; i<=1; i+=2){
            for (int j=-1; j<=1; j+=2){
                try {
                    if ("k".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+i][Gameplay.tempKingPositionC%8+j*2])){
                        return false;

                    }

                }catch (Exception e){}
                try {
                    if ("k".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+i*2][Gameplay.tempKingPositionC%8+j])){
                        return false;

                    }

                }catch (Exception e){}
                temp = 1;

                }
        } 
        
        //pawn
        if(Board.kingPositionC >= 16){
            try{
                if ("p".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8-1][Gameplay.tempKingPositionC%8-1])){
                    return false;
                }
            }catch (Exception e){}
            try {
                if ("p".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8-1][Gameplay.tempKingPositionC%8+1])){
                    return false;
                }

            }catch (Exception e){}
            



            }

        //King
        for (int i=-1; i<=1; i++){
            for (int j=-1; j<=1; j++){
              if (i!=0 || j!=0){
                  try{
                    if ("a".equals(Gameplay.tempBoard[Gameplay.tempKingPositionC/8+i][Gameplay.tempKingPositionC%8+j])){
                        return false;
                    }

                    }catch (Exception e){}
            
                


                }
            }
        }
    return true;   
  }
}