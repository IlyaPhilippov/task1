public class Field {
    private int dementions;
    private SIGN[][] field;

    public enum SIGN {
        X, O, NULL
    }

    public Field(int dem) {
        dementions = dem;
        field = new SIGN[dementions][dementions];
        for (int i = 0; i < dementions; i++) {
            for (int j = 0; j < dementions; j++) {
                field[i][j] = SIGN.NULL;
            }
        }
    }


    /*public void printfield() {
        System.out.println();
        for (int i = 0; i < dementions; i++) {
            for (int j = 0; j < dementions; j++) {
                if (field[i][j] == SIGN.NULL) System.out.print("- ");
                else System.out.print(field[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

     */

    public void addX(int c, int r) {
        if (field[c][r] == SIGN.NULL) field[c][r] = SIGN.X;
    }

    public void addO(int c, int r) {
        if (field[c][r] == SIGN.NULL) field[c][r] = SIGN.O;
    }

    public void clear(int c, int r) {
        if (field[c][r] != SIGN.NULL) field[c][r] = SIGN.NULL;
    }

    public int findMax(SIGN symb) {
        int counter = 0;
        int answerHor = 0;
        int answerVer = 0;
        int counter2 = 0;
        int temp = 0;
        for (int y = 0; y < dementions; y++) {
            for (int x = 0; x < dementions; x++) {
                if (field[y][x] == symb) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (field[x][y] == symb) {
                    counter2++;
                } else {
                    counter2 = 0;
                    continue;
                }
                if (temp < Math.max(counter, counter2)) temp = Math.max(counter, counter2);
            }
            if (answerHor < Math.max(counter, temp)) {
                answerHor = Math.max(counter, temp);
            }
            if (answerVer < Math.max(counter2, temp)) {
                answerVer = Math.max(counter2, temp);
            }
            temp = 0;
            counter = 0;
            counter2 = 0;
        }
        int count = 1;
        int equal;
        int dementionsaver;
        int answerDiag = 0;
        int thistemp = 0;
        for (int m = 1; m < dementions; m++) {
            count++;
            equal = count;
            for (int j = 0; j < count; j++) {
                if (field[j][equal - 1] == symb) {
                    thistemp++;
                    equal -= 1;
                } else {
                    if (answerDiag < thistemp) answerDiag = thistemp;
                    thistemp = 0;
                }
            }
            if (answerDiag < thistemp) answerDiag = thistemp;
            thistemp = 0;
        }

        for (int j = 1; j < dementions - 1; j++) {
            dementionsaver = dementions;
            for (int m = j; m < dementions; m++) {
                if (field[m][dementionsaver - 1] == symb) {
                    thistemp++;
                    dementionsaver -= 1;
                } else {
                    if (answerDiag < thistemp) answerDiag = thistemp;
                    thistemp = 0;
                }
            }
            if (answerDiag < thistemp) answerDiag = thistemp;
            thistemp = 0;
        }
        int numd = 1 + (dementions - 2) * 2;
        int up = 0;
        int fieldC;
        int diagonalcount = 1;
        int fieldR;
        int dep;
        int tempResult2 = 0;
        int answerFinal = 0;
        for (int i = 1; i <= numd; i++) {
            diagonalcount++;
            fieldC = 0;
            dep = dementions - diagonalcount;
            if (i < dementions) {
                for (int j = 0; j < diagonalcount; j++) {
                    if (field[fieldC][dep] == symb) {
                        tempResult2++;
                        fieldC++;
                        dep++;
                    } else {
                        if (answerFinal < tempResult2) answerFinal = tempResult2;
                        tempResult2 = 0;
                    }
                }
            } else {
                up++;
                fieldR = 0;
                for (int m = up; m < dementions; m++) {
                    if (field[m][fieldR] == symb) {
                        tempResult2++;
                        fieldR += 1;
                    } else {
                        if (answerFinal < tempResult2) answerFinal = tempResult2;
                        tempResult2 = 0;
                    }
                }
            }
            if (answerFinal < tempResult2) answerFinal = tempResult2;
            tempResult2 = 0;
        }

        int answer1 = Math.max(answerHor, answerVer);
        int answer2 = Math.max(answerDiag, answerFinal);
        return Math.max(answer1, answer2);
    }

    public SIGN getCell(int c, int r) {
        return field[c][r];
    }

}