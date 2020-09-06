import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class test {

    @Test
    public void addO() {
        Field tictactoe = new Field(5,5);
        tictactoe.addO(0,3);
        tictactoe.addO(2,1);
        tictactoe.addO(4,3);
        tictactoe.addO(0,2);
        tictactoe.addO(3,1);

        assertEquals('O', tictactoe.getCell(0,3));
        assertEquals('O', tictactoe.getCell(2,1));
        assertEquals('O', tictactoe.getCell(4,3));
        assertEquals('O', tictactoe.getCell(0,2));
        assertEquals('O', tictactoe.getCell(3,1));
    }

    @Test
    public void addX() {
        Field tictactoe = new Field(20,20);
        tictactoe.addX(10,15);
        tictactoe.addX(2,16);
        tictactoe.addX(12,5);
        tictactoe.addX(19,8);
        tictactoe.addX(18,0);

        assertEquals('X', tictactoe.getCell(10,15));
        assertEquals('X', tictactoe.getCell(2,16));
        assertEquals('X', tictactoe.getCell(12,5));
        assertEquals('X', tictactoe.getCell(19,8));
        assertEquals('X', tictactoe.getCell(18,0));
    }

    @Test
    public void clear() {
        Field tictactoe = new Field(12,12);
        tictactoe.addX(10,11);
        tictactoe.addX(10,1);
        tictactoe.addO(7,2);
        tictactoe.clear(10,11);
        tictactoe.clear(10,1);
        tictactoe.clear(7,2);
        assertEquals('-', tictactoe.getCell(10,11));
        assertEquals('-', tictactoe.getCell(10,1));
        assertEquals('-', tictactoe.getCell(7,2));
    }

    @Test
    public void findMax() {
        Field tictactoe = new Field(5,5);
        tictactoe.addX(0,0);
        tictactoe.addX(0,1);
        tictactoe.addX(0,3);
        tictactoe.addX(0,4);
        tictactoe.addO(1,0);
        tictactoe.addO(1,1);
        tictactoe.addO(2,2);
        tictactoe.addO(4,4);
        tictactoe.addO(2,0);
        tictactoe.addO(3,3);
        tictactoe.addO(4,2);
        int actual1 = tictactoe.findMax('O');
        int actual2 = tictactoe.findMax('X');
        assertEquals(4, actual1);
        assertEquals(2, actual2);
    }

    @Test
    public void getCell() {
        Field tictactoe = new Field(30,30);
        tictactoe.addO(0,29);
        tictactoe.addX(10,19);
        tictactoe.addX(5,23);
        char actual1 = tictactoe.getCell(0,29);
        char actual2 = tictactoe.getCell(10,19);
        char actual3 = tictactoe.getCell(5,23);
        char actual4 = tictactoe.getCell(11,16);
        assertEquals('O', actual1);
        assertEquals('X', actual2);
        assertEquals('X', actual3);
        assertEquals('-', actual4);
    }

}