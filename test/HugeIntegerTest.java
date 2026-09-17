import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HugeIntegerTest {

    @Test
    public void testParseAndToString() {
        HugeInteger number = new HugeInteger();

        number.parse("123456789");

        assertEquals("123456789", number.toString());
    }
    @Test
    public void testAdd(){
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("123456789");
        number2.parse("987654321");

        HugeInteger result = number1.add(number2);

        assertEquals("1111111110", result.toString());
    }
    @Test
    public void testParsedoesntpass40Digits() {
        HugeInteger number = new HugeInteger();

        number.parse("1234567890123456789012345678901234567890");

        assertEquals("1234567890123456789012345678901234567890", number.toString());
    }
    @Test
    public void testDivide() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("100");
        number2.parse("4");

        HugeInteger result = number1.divide(number2);

        assertEquals("25", result.toString());
    }
    @Test
    void testSubtract() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("1000");
        number2.parse("1");

        HugeInteger result = number1.subtract(number2);

        assertEquals("999", result.toString());
    }

    @Test
    void testMultiply() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("12");
        number2.parse("5");

        HugeInteger result = number1.multiply(number2);

        assertEquals("60", result.toString());
    }

    @Test
    void testIsZero() {
        HugeInteger number = new HugeInteger();

        number.parse("0");

        assertTrue(number.isZero());
    }

    @Test
    void testIsNotZero() {
        HugeInteger number = new HugeInteger();

        number.parse("123");

        assertFalse(number.isZero());
    }

    @Test
  public  void testIsGreaterThan() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("500");
        number2.parse("100");

        assertTrue(number1.isGreaterThan(number2));
    }

    @Test
    public void testIsLessThan() {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        number1.parse("100");
        number2.parse("500");

        assertTrue(number1.isLessThan(number2));
    }












}
