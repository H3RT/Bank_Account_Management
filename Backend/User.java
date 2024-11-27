public class User {   
private String name;
private String surname;
private int IdNumber;
private String password;
private int accountNumber;

    public User(int IdNumber, int accountNumber, String name, String password, String surname) {
        this.IdNumber = IdNumber;
        this.accountNumber = accountNumber;
        this.name = name;
        this.password = password;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(int IdNumber) {
        this.IdNumber = IdNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }


}
