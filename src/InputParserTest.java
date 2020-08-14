import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private InputParser parser = new InputParser();

    @Test
    void postFix() {
        String raw1 = "3+  4";
        String raw2 = "3 + 4 * 2 /( 1 - 5)";
        String raw3 = "5+ (30*  2.2) / (1 - (5,5*2))";

        String[] r1 = new String[]{"3","4","+"};
        String[] r2 = new String[]{"3", "4", "2" ,"*", "1", "5", "-", "/", "+"};
        String[] r3 = new String[]{"5", "30", "2.2" ,"*", "1", "5.5", "2" , "*", "-", "/", "+"};

        assertArrayEquals(parser.postFix(raw1), r1);
        assertArrayEquals(parser.postFix(raw2), r2);
        assertArrayEquals(parser.postFix(raw3), r3);
    }


}