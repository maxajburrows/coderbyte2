import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KatasTest {

    Katas outputter = new Katas();

    @Test
    public void kata1() {
        String output = outputter.ArrayAddition(new int[] {5,7,16,1,2});

        assertEquals("false", output);
    }

    @Test
    public void kata2() {
        String output = outputter.ClosestEnemyII(new String[] {"000", "100", "200"});

        assertEquals("1", output);
    }

    @Test
    public void kata2SecondTest() {
        String output = outputter.ClosestEnemyII(new String[] {"0000", "2010", "0000", "2002"});

        assertEquals("2", output);
    }

    @Test
    public void kata2ThirdTest() {
        String output = outputter.ClosestEnemyII(new String[] {"0000", "1000", "0002", "0002"});

        assertEquals("2", output);
    }

    @Test
    public void kata2FourthTest() {
        String output = outputter.ClosestEnemyII(new String[] {"10", "02"});

        assertEquals("2", output);
    }

    @Test
    public void kata2FifthTest() {
        String output = outputter.ClosestEnemyII(new String[] {"01000", "00020", "00000", "00002", "02002"});

        assertEquals("1", output);
    }

    @Test
    public void kata2SixthTest() {
        String output = outputter.ClosestEnemyII(new String[] {"01200", "00020", "00000", "00002", "02002"} );

        assertEquals("1", output);
    }

    @Test
    public void kata2SeventhTest() {
        String output = outputter.ClosestEnemyII(new String[] {"00000", "10000", "00000", "00002", "02002"});

        assertEquals("3", output);
    }

    @Test
    public void kata2EigthTest() {
        String output = outputter.ClosestEnemyII(new String[] {"0000000", "0001000", "0000000", "0000000", "0000000", "2000000", "0000000"});

        assertEquals("6", output);
    }

    @Test
    public void kata3() {
        String output = outputter.NumberSearch("H3ello9-9");

        assertEquals("4", output);
    }

    @Test
    public void kata3SecondTest() {
        String output = outputter.NumberSearch("H3ello9-9");

        assertEquals("4", output);
    }

    @Test
    public void kata3ThirdTest() {
        String output = outputter.NumberSearch("i love cake 9 8 7");

        assertEquals("3", output);
    }

    @Test
    public void kata3FourthTest() {
        String output = outputter.NumberSearch("3ko6");

        assertEquals("5", output);
    }

    @Test
    public void kata3FifthTest() {
        String output = outputter.NumberSearch("1p2ol5e ** 6");

        assertEquals("4", output);
    }
}