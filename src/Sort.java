public class Sort {

    public static String sorting(String list){
        int [] score = new int [list.length()/5];
        for (int i=0; i<list.length(); i+=5){
            Moves.makeMove(list.substring(i, i + 5));
            score[i/5] = -Rating.rating(-1, 0);
            Moves.undoMove(list.substring(i, i+5));
        } 
        String newListA = "", newListB = list;

        for (int i = 0; i < Math.min(6, list.length()/5); i++){
            int max = -1000000, maxLocation = 0;
            for (int j = 0; j < list.length()/5; j++){
                if (score[j] > max){ max = score[j]; maxLocation = j;

                }
            }

                score[maxLocation] = -1000000;
                newListA += list.substring(maxLocation * 5, maxLocation * 5+5);
                newListB = newListB.replace(list.substring(maxLocation * 5, maxLocation * 5+5), "");
        }

        return newListA + newListB;
    }
    
}