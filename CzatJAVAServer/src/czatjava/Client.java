package czatjava;

public class Client {
    private final String name;
    private final String login;
    private final String password;
    private final int age;

    public Client(String name, String login, String password, int age) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return name + " " + login + " " + age;
    }
}