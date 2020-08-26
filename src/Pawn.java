public class Pawn {
    public static String possibleP(int i) {
        String list = "";
        String oldPiece;
        int r = i / 8;
        int c = i % 8;

        for (int j = -1; j <= 1; j += 2) {

            //Capture
            try {
                if (Character.isLowerCase(Gameplay.tempBoard[r - 1][c + j].charAt(0)) && i >= 16) {
                    oldPiece = Gameplay.tempBoard[r - 1][c + j];
                    Gameplay.tempBoard[r][c] = " ";
                    Gameplay.tempBoard[r - 1][c + j] = "P";

                    if (KingSafetyC.kingSafe()) {
                        list = list + r + c + (r - 1) + (c + j) + oldPiece;
                    }

                    Gameplay.tempBoard[r][c] = "P";
                    Gameplay.tempBoard[r - 1][c + j] = oldPiece;
                }

            } catch (Exception e) {
            }
            //Upgrade with capture
            try {
                if (Character.isLowerCase(Gameplay.tempBoard[r - 1][c + j].charAt(0)) && i < 16) {
                    String[] temp = {"Q", "R", "B", "K"};
                    for (int k = 0; k < 4; k++) {
                        oldPiece = Gameplay.tempBoard[r - 1][c + j];
                        Gameplay.tempBoard[r][c] = " ";
                        Gameplay.tempBoard[r - 1][c + j] = temp[k];

                        if (KingSafetyC.kingSafe()) {
                            list = list + c + (c + j) + oldPiece + temp[k] + "P";
                        }

                        Gameplay.tempBoard[r][c] = "P";
                        Gameplay.tempBoard[r - 1][c + j] = oldPiece;
                    }

                }

            } catch (Exception e) {
            }

        }
        //move up one
        try {
            if (" ".equals(Gameplay.tempBoard[r - 1][c]) && i >= 16) {
                oldPiece = Gameplay.tempBoard[r - 1][c];
                Gameplay.tempBoard[r][c] = " ";
                Gameplay.tempBoard[r - 1][c] = "P";

                if (KingSafetyC.kingSafe()) {
                    list = list + r + c + (r - 1) + c + oldPiece;
                }

                Gameplay.tempBoard[r][c] = "P";
                Gameplay.tempBoard[r - 1][c] = oldPiece;


            }
        } catch (Exception e) {
        }
        //Upgrade with no capture
        try {
            if (" ".equals(Gameplay.tempBoard[r - 1][c]) && i < 16) {
                String[] temp = {"Q", "R", "B", "K"};
                for (int k = 0; k < 4; k++) {
                    oldPiece = Gameplay.tempBoard[r - 1][c];
                    Gameplay.tempBoard[r][c] = " ";
                    Gameplay.tempBoard[r - 1][c] = temp[k];

                    if (KingSafetyC.kingSafe()) {
                        list = list + c + c + oldPiece + temp[k] + "P";
                    }

                    Gameplay.tempBoard[r][c] = "P";
                    Gameplay.tempBoard[r - 1][c] = oldPiece;
                }

            }
        } catch (Exception e) {
        }

        //move up two
        try {
            if (" ".equals(Gameplay.tempBoard[r - 1][c]) && " ".equals(Gameplay.tempBoard[r - 2][c]) && i >= 48) {
                oldPiece = Gameplay.tempBoard[r - 2][c];
                Gameplay.tempBoard[r][c] = " ";
                Gameplay.tempBoard[r - 2][c] = "P";

                if (KingSafetyC.kingSafe()) {
                    list = list + r + c + (r - 2) + c + oldPiece;
                }

                Gameplay.tempBoard[r][c] = "P";
                Gameplay.tempBoard[r - 2][c] = oldPiece;


            }


        } catch (Exception e) {
        }

        return list;
    }

}