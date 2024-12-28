package com.example.demo1;

public class User {
    private String name;
    private String password;

    // Parametresiz constructor (default constructor)
    public User() {
        // Varsayılan constructor, Jackson için gereklidir
    }

    // Parametreli constructor, isim ve şifre ile kullanıcı oluşturulabilir
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getter ve Setter metodları

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
