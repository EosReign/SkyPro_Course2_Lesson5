import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regex = "\\w+[a-zA-Z_0-9]";
    private static final Pattern pattern = Pattern.compile(regex);
    public static void main(String[] args) {
        check("safsfaf", "fskfjsf", "sfanksf");
    }
    private static void check(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password);
            checkConfirmPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.err.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Проверка вводных данных завершена");
        }
    }
    private static void checkLogin(String login) throws WrongLoginException {
        Matcher matcher = pattern.matcher(login);

        if (login == null || login.isEmpty() || login.length() >= 20) {
            throw new WrongLoginException("Длина логина не соответствует требованиям") ;
        } else if (!matcher.matches()) {
            throw new WrongLoginException("Символы логина не соответствуют требованиям");
        }
    }
    private static void checkPassword(String password) throws WrongPasswordException {
        Matcher matcher = pattern.matcher(password);

        if (password == null || password.isEmpty() || password.length() >= 20) {
            throw new WrongPasswordException("Длина пороля не соответствует требованиям");
        } else if (!matcher.matches()) {
            throw new WrongPasswordException("Символы пороля не соответствуют требованиям");
        }
    }
    private static void checkConfirmPassword(String password, String confirmPassword) throws WrongPasswordException{
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пороль не совпадает");
        }
    }
}
