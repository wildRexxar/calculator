import java.util.Scanner;

public class Menu {
    Base base = new Base();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("1 - авторизация");
        System.out.println("2 - удаление пользователя");
        System.out.println("3 - удаление всех пользователей");
        System.out.println("4 - показать всех пользователей");
        System.out.println("5 - регисрация");
        System.out.println("6 - выход");
        choise();
    }

    public void choise() {
        char i = scanner.next().charAt(0);

        switch (i) {
            case '1': {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введи логин");
                String login = sc.nextLine();
                System.out.println("Введи пароль");
                String password = sc.nextLine();
                base.signln(login, password);
                start();
                break;
            }
            case '2': {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введи имя пользователя которого нужно удалить");
                String name = sc.nextLine();
                base.remove(name);
                start();
                break;
            }
            case '3': {
                base.deleteUsers();
                start();
                break;
            }
            case '4': {
                base.showUsers();
                start();
                break;
            }
            case '5': {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введи логин");
                String login = sc.nextLine();
                System.out.println("Введи пароль");
                String password = sc.nextLine();
                base.addUser(new User(login, password));
                start();
                break;
            }
            case '6': {
                System.out.println("Программа завершена");
                break;
            }
            default: {
                start();
            }
        }
    }
}