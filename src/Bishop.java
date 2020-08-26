
public class Bishop {

    public static String possibleB(int i) {

        String list = "";
        String oldPiece;
        int r = i/8;
        int c = i%8;
        int temp = 1;


        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    while (" ".equals(Gameplay.tempBoard[r + temp * j][c + temp * k])) {

                        oldPiece = Gameplay.tempBoard[r + temp * j][c + temp * k];
                        Gameplay.tempBoard[r][c] = " ";
                        Gameplay.tempBoard[r + temp * j][c + temp * k] = "B";

                        if (KingSafetyC.kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }

                        Gameplay.tempBoard[r][c] = "B";
                        Gameplay.tempBoard[r + temp * j][c + temp * k] = oldPiece;
                        temp++;
                    }

                    if (Character.isLowerCase(Gameplay.tempBoard[r + temp * j][c + temp * k].charAt(0))) {

                        oldPiece = Gameplay.tempBoard[r + temp * j][c + temp * k];
                        Gameplay.tempBoard[r][c] = " ";
                        Gameplay.tempBoard[r + temp * j][c + temp * k] = "B";

                        if (KingSafetyC.kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }

                        Gameplay.tempBoard[r][c] = "B";
                        Gameplay.tempBoard[r + temp * j][c + temp * k] = oldPiece;

                    }
                } catch (Exception e) {
                }

                temp = 1;
            }


        }
        return list;
    }

}