public class Rook {


    public static String possibleR(int i) {

        String list = "";
        String oldPiece;
        int r = i/8;
        int c = i%8;
        int temp = 1;

        for (int j = -1; j <= 1; j += 2) {
            try {
                while (" ".equals(Gameplay.tempBoard[r][c + temp * j])) {

                    oldPiece = Gameplay.tempBoard[r][c + temp * j];
                    Gameplay.tempBoard[r][c] = " ";
                    Gameplay.tempBoard[r][c + temp * j] = "R";

                    if (KingSafetyC.kingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }

                    Gameplay.tempBoard[r][c] = "R";
                    Gameplay.tempBoard[r][c + temp * j] = oldPiece;
                    temp++;
                }

                if (Character.isLowerCase(Gameplay.tempBoard[r][c + temp * j].charAt(0))) {

                    oldPiece = Gameplay.tempBoard[r][c + temp * j];
                    Gameplay.tempBoard[r][c] = " ";
                    Gameplay.tempBoard[r][c + temp * j] = "R";

                    if (KingSafetyC.kingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }

                    Gameplay.tempBoard[r][c] = "R";
                    Gameplay.tempBoard[r][c + temp * j] = oldPiece;

                }
            } catch (Exception e) {
            }

            temp = 1;
            try {
                while (" ".equals(Gameplay.tempBoard[r + temp * j][c])) {

                    oldPiece = Gameplay.tempBoard[r + temp * j][c];
                    Gameplay.tempBoard[r][c] = " ";
                    Gameplay.tempBoard[r + temp * j][c] = "R";

                    if (KingSafetyC.kingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }

                    Gameplay.tempBoard[r][c] = "R";
                    Gameplay.tempBoard[r + temp * j][c] = oldPiece;
                    temp++;
                }

                if (Character.isLowerCase(Gameplay.tempBoard[r + temp * j][c].charAt(0))) {

                    oldPiece = Gameplay.tempBoard[r + temp * j][c];
                    Gameplay.tempBoard[r][c] = " ";
                    Gameplay.tempBoard[r + temp * j][c] = "R";

                    if (KingSafetyC.kingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }

                    Gameplay.tempBoard[r][c] = "R";
                    Gameplay.tempBoard[r + temp * j][c] = oldPiece;

                }

            } catch (Exception e) {
            }
            temp = 1;
        }

        return list;
    }


}