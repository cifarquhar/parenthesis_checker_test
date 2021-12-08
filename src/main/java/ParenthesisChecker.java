import java.util.HashMap;
import java.util.Stack;

public class ParenthesisChecker {

    public static boolean check(String inputString){

        Stack<Character> foundBrackets = new Stack<>();

        HashMap<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        matchingBrackets.put('>', '<');

        char[] letters = inputString.toCharArray();

        for (Character character : letters) {
            if (character.equals('(') || character.equals('[') || character.equals('{') || character.equals('<')){
                foundBrackets.push(character);
            }
            else if (character.equals(')') || character.equals(']') || character.equals('}') || character.equals('>')){
                Character openingBracket = matchingBrackets.get(character);

                if (foundBrackets.isEmpty() || !foundBrackets.peek().equals(openingBracket)){
                    return false;
                }
                else {
                    foundBrackets.pop();
                }
            }
        }

        return foundBrackets.isEmpty();
    }

}
