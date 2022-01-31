package czatjava;

interface MessageListener {
    abstract void onMessage(String fromLogin, String msgBody);
}