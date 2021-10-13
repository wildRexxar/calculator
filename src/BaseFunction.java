public interface BaseFunction {
    void addUser(User user);

    void createBase(User user);

    boolean checkExisting(User user);

    void signln(String login, String password);

    void showUsers();

    void deleteUsers();

    void removeByIndex(int index);

    void remove(String user);

    int getSize();

    User getUser(int index);
}