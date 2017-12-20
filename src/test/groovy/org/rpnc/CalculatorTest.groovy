package org.rpnc

import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static org.testng.Assert.assertEquals

@Test
class CalculatorTest {

    @Test(dataProvider = "calculations")
    void test(String formula, String result) {
        Calculator calc = new Calculator();

        long res = calc.calculate(formula);

        assertEquals(String.valueOf(res), result);
    }

    @DataProvider
    Object[][] calculations() {
        [
                // literal
                ['3', '3'],
                // simple operations
                ['3 2 +', '5'],
                ['3 2 + 5 /', '1'],
                ['5 3 2 + /', '1'],
                // print
                ['7 .', '7'],
                // dup
                ['7 dup *', '49'],
                ['3 7 * dup +', '42'],
                ['2 2 * dup dup +', '42'],
                // more tests
        ]
    }
}