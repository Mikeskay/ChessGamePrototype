
public class King {

    public static String possibleA(int i) {

        String list = "";
        String oldPiece;
        int r = i/8;
        int c = i%8;


        for (int j = 0; j < 9; j++) {

            if (j != 4) {
                try {
                    if (Character.isLowerCase(Gameplay.tempBoard[r - 1 + j / 3][c - 1 + j % 3].charAt(0)) || " ".equals(Gameplay.tempBoard[r - 1 + j / 3][c - 1 + j % 3])) {

                        oldPiece = Gameplay.tempBoard[r - 1 + j / 3][c - 1 + j % 3];
                        Gameplay.tempBoard[r][c] = " ";
                        Gameplay.tempBoard[r - 1 + j / 3][c - 1 + j % 3] = "A";

                        int kingTemp = Gameplay.tempKingPositionC;
                        Gameplay.tempKingPositionC = i + (j / 3) * 8 + j % 3 - 9;
                        if (KingSafetyC.kingSafe()) {
                            list = list + r + c + (r - 1 + j / 3) + (c - 1 + j % 3) + oldPiece;
                        }

                        Gameplay.tempBoard[r][c] = "A";
                        Gameplay.tempBoard[r - 1 + j / 3][c - 1 + j % 3] = oldPiece;
                        Gameplay.tempKingPositionC = kingTemp;
                    }
                } catch (Exception e) {
                }
            }

        }

        return list;
    }
}