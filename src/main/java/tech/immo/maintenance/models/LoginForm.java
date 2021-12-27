package tech.immo.maintenance.models;

public class LoginForm {

    private String userName;
    private String passWord;

    public LoginForm() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        this.passWord= password;
    }
}
