import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParenthesisCheckerTest {

    @Test
    public void passesForEmptyString(){
        String testString = "";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesWithOnePair(){
        String testString = "()";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsIfOnlyOpening(){
        String testString = "(";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void failsIfOnlyClosing(){
        String testString = ")";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesIfNested(){
        String testString = "(())";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsIfOnePairLeftOpen(){
        String testString = "(()";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void failsIfOnePairNotOpened(){
        String testString = "())";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesForMatchedParenthesesInText(){
        String testString = "test (for parentheses)";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsIfNoClosingBracketInText(){
        String testString = "test (for unclosed parentheses ";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void failsIfNoOpeningBracketInText(){
        String testString = "test for unopened parenthesis)";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesForMultipleParenthesesInText(){
        String testString = "test (for multiple) opening (and closing) brackets";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsIfOneBracketLeftOpen(){
        String testString = "test (for multiple) opening (and closing brackets";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void failsIfOneBracketNotOpened(){
        String testString = "test (for multiple) opening and closing) brackets";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesForNestedBracketsInText(){
        String testString = "test for (lots of (nested)) brackets";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesForBraces(){
        String testString = "test {braces}";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsForSingleOpeningBrace(){
        String testString = "test {braces";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void failsForSingleClosingBrace(){
        String testString = "test braces}";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesForMultipleBraces(){
        String testString = "test {multiple} {braces}";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesForNestedBraces(){
        String testString = "test { nested {braces}}";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesForBrackets(){
        String testString = "test [brackets]";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsForSingleOpeningBracket(){
        String testString = "test [brackets";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void failsForSingleClosingBracket(){
        String testString = "test brackets}";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesForMultipleBrackets(){
        String testString = "test [multiple] [brackets]";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesForNestedBrackets(){
        String testString = "test [ nested [braces]]";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesForAngleBrackets(){
        String testString = "test <angle brackets>";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsForSingleAngleBracket(){
        String testString = "test <angle brackets";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void failsForSingleClosingAngleBracket(){
        String testString = "test angle brackets>";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesForMultipleAngleBrackets(){
        String testString = "test <multiple> <angle brackets>";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesForNestedAngleBrackets(){
        String testString = "test < nested <angle brackets>>";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void passesForCheckNestedMixedBrackets(){
        String testString = "(nested {mixture})";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsForWronglyOrderedMixedBrackets(){
        String testString = "(nested {mixture)}";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

    @Test
    public void passesForMixedEmptyBrackets(){
        String testString = "({})";
        assertThat(ParenthesisChecker.check(testString)).isTrue();
    }

    @Test
    public void failsForWronglyOrderedMixedEmptyBrackets(){
        String testString = "({)}";
        assertThat(ParenthesisChecker.check(testString)).isFalse();
    }

}
