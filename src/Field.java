public class Field {
    private int height;
    private int width;
    private char[][] field;

    public Field (int h, int w){
        height = h;
        width = w;
        field = new char[height][width];
        for (int i = 0; i < height; i++){
            for(int j = 0; j < width; j++) {
                field[i][j] = '-';
            }
        }
    }

    /*
    public void printfield(){
        System.out.println();
        for (int i = 0; i < height; i++){
            for( int j = 0; j < width; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
     */

    public void addX (int c , int r) {
        if (field[c][r] == '-') field[c][r] = 'X';
    }

    public void addO (int c , int r) {
        if (field[c][r] == '-') field[c][r] = 'O';
    }

    public void clear (int c , int r) {
        if (field[c][r] != '-') field[c][r] = '-';
    }

    public int findMax (char symb) {
        int counter = 0;
        int answerHor = 0;
        int answerVer = 0;
        int temp = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (field[y][x] == symb) {
                    counter++;
                } else {
                    counter = 0;
                    continue;
                }
                if (temp < counter) temp = counter;
            }
            if (answerHor < Math.max(counter, temp)) {
                answerHor = Math.max(counter, temp);
            }
            counter = 0;
            temp = 0;
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (field[y][x] == symb) {
                    counter++;
                } else {
                    counter = 0;
                    continue;
                }
                if (temp < counter) temp = counter;
            }
            if (answerHor < Math.max(counter, temp)) {
                answerHor = Math.max(counter, temp);
            }
            counter = 0;
            temp = 0;
        }

        int i = 0;
        int counter2 = 0;
        int temp2 = 0;
        int temp3 = 0;
        for (int xy = 0; xy < width; xy++) {
            if (field[xy][xy] == symb) {
                counter++;
            } else {
                counter = 0;
                continue;
            }
            if (temp2 < counter) temp2 = counter;
        }

        for (int xy = 0; xy < width; xy++) {
            i++;
            if (field[xy][width - i] == symb) {
                counter2++;
            } else {
                counter2 = 0;
                continue;
            }
            if (temp3 < counter2) temp3 = counter2;
        }

        int answer1 = Math.max(answerHor,answerVer);
        int answer2 = Math.max(temp2,temp3);
        return Math.max(answer1,answer2);
    }

    public char getCell(int c, int r) {
        return field[c][r];
    }

}