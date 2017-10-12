package by.tc.task01.dao.command;

/**
 *
 * @author Nastya
 */
public class Parser {
    public static boolean tryParseInteger(String text) {
            try {
                Integer.parseInt(text);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        public static boolean tryParseDouble(String text) {
            try {
                Double.parseDouble(text);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
}
