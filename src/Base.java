public class Base implements BaseFunction {
    User[] users = new User[5];
    private int size = 0;

    @Override
    public void createBase(User user) {
        if (size >= users.length) {
            User[] newUseres = new User[users.length * 2];
            for (int i = 0; i < size; i++) {
                newUseres[i] = users[i];
            }
            users = newUseres;
        }
        users[size] = user;
        size++;
    }

    @Override
    public void addUser(User user) {
        if (checkExisting(user)) {
            createBase(user);
        } else {
            System.out.println("Такой пользователь существует");
        }
    }

    @Override
    public boolean checkExisting(User user) {
        for (int i = 0; i < size; i++) {
            if (users[i].getLogin().equals(user.getLogin())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void signln(String login, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getLogin().equals(login) && users[i].getPassword().equals(password)) {
                Calculator calculator = new Calculator();
                System.out.println("Доступ пользавателю " + users[i].getLogin() + " разрешен");
                calculator.start();
                return;
            }
        }
        System.out.println("Пользователь не найден");
    }

    @Override
    public void showUsers() {
        System.out.println("Список пользователей: ");
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    @Override
    public void deleteUsers() {
        size = 0;
        users = new User[5];

    }

    @Override
    public void removeByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            users[i] = users[i + 1];
        }
        size--;
    }

    @Override
    public void remove(String user) {
        for (int i = 0; i < size; i++) {
            if (users[i].getLogin().equals(user)) {
                removeByIndex(i);
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public User getUser(int index) {
        return users[index];
    }
}


