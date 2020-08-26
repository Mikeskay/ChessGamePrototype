public class Knight {

    public static String possibleK(int i) {
        String list = "";
        String oldPiece;
        int r = i/8;
        int c = i%8;

        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    if (Character.isLowerCase(Gameplay.tempBoard[r + j][c + k * 2].charAt(0)) || " ".equals(Gameplay.tempBoard[r + j][c + k * 2])) {

                        oldPiece = Gameplay.tempBoard[r + j][c + k * 2];
                        Gameplay.tempBoard[r][c] = " ";

                        if (KingSafetyC.kingSafe()) {
                            list = list + r + c + (r + j) + (c + k * 2) + oldPiece;
                        }

                        Gameplay.tempBoard[r][c] = "K";
                        Gameplay.tempBoard[r + j][c + k * 2] = oldPiece;
                    }

                } catch (Exception e) {
                }
                try {
                    if (Character.isLowerCase(Gameplay.tempBoard[r + j * 2][c + k].charAt(0)) || " ".equals(Gameplay.tempBoard[r + j * 2][c + k])) {

                        oldPiece = Gameplay.tempBoard[r + j * 2][c + k];
                        Gameplay.tempBoard[r][c] = " ";

                        if (KingSafetyC.kingSafe()) {
                            list = list + r + c + (r + j * 2) + (c + k) + oldPiece;
                        }

                        Gameplay.tempBoard[r][c] = "K";
                        Gameplay.tempBoard[r + j * 2][c + k] = oldPiece;
                    }

                } catch (Exception e) {
                }


            }

        }
        return list;
    }

}