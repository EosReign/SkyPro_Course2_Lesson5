public class Main {
    public static void main(String[] args) {
        check("", ")fskfjsf", "sfanksf");
    }
    public static void check(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
        } catch (WrongLoginException e) {
            System.err.println("Логин не соответствует требованиям");
        } finally {
            System.out.println("Проверка логина завершена");
        }
        try {
            checkPassword(password);
        } catch (WrongPasswordException e) {
            System.err.println("Пороль не соответствует требованиям");
        } finally {
            System.out.println("Проверка пороля завершена");
        }
        try {
            checkConfirmPassword(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.err.println("Пороль не совпадает");
        } finally {
            System.out.println("Проверка поролей на совпадение завершена");
        }
    }
    public static void checkLogin(String login) throws WrongLoginException{
        if (login.length() >= 20 || login == "" || login == null) {
            throw new WrongLoginException("Длина логина не соответствует требованиям") ;
        }
    }
    public static void checkPassword(String password) throws WrongPasswordException{
        if (password.length() >= 20) {
            throw new WrongPasswordException("Длина пороля не соответствует требованиям");
        }
    }
    public static void checkConfirmPassword(String password, String confirmPassword) throws WrongPasswordException{
        if (password != confirmPassword) {
            throw new WrongPasswordException("Пороль не совпадает");
        }
    }
}
//..
