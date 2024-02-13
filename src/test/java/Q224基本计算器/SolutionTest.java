package Q224基本计算器;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void calculate() {
        System.out.println(solution.calculate(" 2-1 + 2 "));
    }

    @Test
    void convertToRPN() {
        System.out.println(solution.convertToRPN("(1+(4+5+2)-3)+(6+8)"));
    }

    @Test
    void evaluateRPN() {
    }

    @Test
    void getPriority() {
    }
}