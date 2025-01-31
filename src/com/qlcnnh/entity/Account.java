
package com.qlcnnh.entity;

/**
 *
 * @author T14
 */
public class Account {

    private int idAcount;

    private int idUser;
    private String UserName;
    private String PassWord;

    public Account() {
    }
    

    public Account(int idAcount, String UserName, String PassWord) {
        this.idAcount = idAcount;
        this.UserName = UserName;
        this.PassWord = PassWord;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    
    public int getIdAcount() {
        return idAcount;
    }

    public void setIdAcount(int idAcount) {
        this.idAcount = idAcount;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
}