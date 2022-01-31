package czatjava;

interface UserStatusListener {
    public void online(String login);
    public void offline(String login);
}