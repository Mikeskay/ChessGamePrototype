public class KingSafetyL {
    public static boolean kingSafe(){
        //bishop/queen
        int temp = 1;
        for (int i=-1; i<=1; i+=2){
            for (int j=-1; j<=1; j+=2){
                try {
                    while(" ".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+temp*i][Gameplay.tempKingPositionL%8+temp*j])){
                        temp++;
                    }
                    if ("B".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+temp*i][Gameplay.tempKingPositionL%8+temp*j])||

                            "Q".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+temp*i][Gameplay.tempKingPositionL%8+temp*j])){

                        return false;

                    }

                }catch (Exception e){}

                temp = 1;

            }
        }

        //rook/queen
        for (int i=-1; i<=1; i+=2){
            try {
                while(" ".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8][Gameplay.tempKingPositionL % 8 + temp * i])){
                    temp++;
                }
                if ("R".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8][Gameplay.tempKingPositionL%8+temp*i])||

                        "Q".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8][Gameplay.tempKingPositionL%8+temp*i])){

                    return false;

                }

            }catch (Exception e){}

            temp = 1;

            try {
                while(" ".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+temp*i][Gameplay.tempKingPositionL % 8])){
                    temp++;
                }
                if ("R".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+temp*i][Gameplay.tempKingPositionL % 8])||

                        "Q".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+temp*i][Gameplay.tempKingPositionL % 8])){

                    return false;

                }
            }catch (Exception e){}

            temp = 1;

        }

        //knight
        for (int i=-1; i<=1; i+=2){
            for (int j=-1; j<=1; j+=2){
                try {
                    if ("K".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+i][Gameplay.tempKingPositionL%8+j*2])){
                        return false;

                    }

                }catch (Exception e){}
                try {
                    if ("K".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+i*2][Gameplay.tempKingPositionL%8+j])){
                        return false;

                    }

                }catch (Exception e){}
                temp = 1;

            }
        }

        //pawn
        if(Board.kingPositionL >= 16){
            try{
                if ("P".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8-1][Gameplay.tempKingPositionL % 8 - 1])){
                    return false;
                }
            }catch (Exception e){}
            try {
                if ("P".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8-1][Gameplay.tempKingPositionL% 8 + 1])){
                    return false;
                }

            }catch (Exception e){}




        }

        //King
        for (int i=-1; i<=1; i++){
            for (int j=-1; j<=1; j++){
                if (i!=0 || j!=0){
                    try{
                        if ("A".equals(Gameplay.tempBoard[Gameplay.tempKingPositionL/8+i][Gameplay.tempKingPositionL%8+j])){
                            return false;
                        }

                    }catch (Exception e){}




                }
            }
        }
        return true;
    }
}