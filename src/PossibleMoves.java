public class PossibleMoves {
    public static String possibleMoves() {
        String list = "";
        for (int i = 0; i < 64; i++) {

            switch (Gameplay.tempBoard[i / 8][i % 8]) {
                case "P":
                    list += Pawn.possibleP(i);
                    break;
                case "R":
                    list += Rook.possibleR(i);
                    break;
                case "K":
                    list += Knight.possibleK(i);
                    break;
                case "B":
                    list += Bishop.possibleB(i);
                    break;
                case "Q":
                    list += Queen.possibleQ(i);
                    break;
                case "A":
                    list += King.possibleA(i);
                    break;
            }

        }
        return list;
    }


}
