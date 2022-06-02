package model.OOP;

import java.io.Serializable;

import static model.Encryption.encrypt;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String created_at;

    public Account(int id, String name, String password, String email, String phone, String address, String created_at) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
    }

    public Account(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String name, String email, String password, String address) {

        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    //    password encryption;
    public String EncryptPassword() {
        return encrypt(this.password, this.email);
    }
}
