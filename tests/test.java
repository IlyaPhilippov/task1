import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class test {

    @Test
    public void addO() {
        Field tictactoe = new Field(5);
        tictactoe.addO(0,3);
        tictactoe.addO(2,1);
        tictactoe.addO(4,3);
        tictactoe.addO(0,2);
        tictactoe.addO(3,1);

        assertEquals(Field.SIGN.O, tictactoe.getCell(0,3));
        assertEquals(Field.SIGN.O, tictactoe.getCell(2,1));
        assertEquals(Field.SIGN.O, tictactoe.getCell(4,3));
        assertEquals(Field.SIGN.O, tictactoe.getCell(0,2));
        assertEquals(Field.SIGN.O, tictactoe.getCell(3,1));
    }

    @Test
    public void addX() {
        Field tictactoe = new Field(20);
        tictactoe.addX(10,15);
        tictactoe.addX(2,16);
        tictactoe.addX(12,5);
        tictactoe.addX(19,8);
        tictactoe.addX(18,0);

        assertEquals(Field.SIGN.X, tictactoe.getCell(10,15));
        assertEquals(Field.SIGN.X, tictactoe.getCell(2,16));
        assertEquals(Field.SIGN.X, tictactoe.getCell(12,5));
        assertEquals(Field.SIGN.X, tictactoe.getCell(19,8));
        assertEquals(Field.SIGN.X, tictactoe.getCell(18,0));
    }

    @Test
    public void clear() {
        Field tictactoe = new Field(12);
        tictactoe.addX(10,11);
        tictactoe.addX(10,1);
        tictactoe.addO(7,2);
        tictactoe.clear(10,11);
        tictactoe.clear(10,1);
        tictactoe.clear(7,2);
        assertEquals(Field.SIGN.NULL, tictactoe.getCell(10,11));
        assertEquals(Field.SIGN.NULL, tictactoe.getCell(10,1));
        assertEquals(Field.SIGN.NULL, tictactoe.getCell(7,2));
    }

    @Test
    public void findMax() {
        Field tictactoe = new Field(5);
        tictactoe.addX(0,0);
        tictactoe.addX(1,0);
        tictactoe.addX(2,0);
        tictactoe.addX(3,0);
        tictactoe.addX(4,0);
        tictactoe.addO(0,4);
        tictactoe.addO(1,3);
        tictactoe.addO(2,2);
        tictactoe.addO(3,1);
        int actual1 = tictactoe.findMax(Field.SIGN.O);
        int actual2 = tictactoe.findMax(Field.SIGN.X);
        assertEquals(4, actual1);
        assertEquals(5, actual2);
    }

    @Test
    public void getCell() {
        Field tictactoe = new Field(30);
        tictactoe.addO(0,29);
        tictactoe.addX(10,19);
        tictactoe.addX(5,23);
        Field.SIGN actual1 = tictactoe.getCell(0,29);
        Field.SIGN actual2 = tictactoe.getCell(10,19);
        Field.SIGN actual3 = tictactoe.getCell(5,23);
        Field.SIGN actual4 = tictactoe.getCell(11,16);
        assertEquals(Field.SIGN.O, actual1);
        assertEquals(Field.SIGN.X, actual2);
        assertEquals(Field.SIGN.X, actual3);
        assertEquals(Field.SIGN.NULL , actual4);
    }

}