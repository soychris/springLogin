/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softek.jwtdemo.dto;

/**
 *
 * @author Chris
 */
public class User {
    
    private String user;
    private String pwd;
    private String tkn;

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the tkn
     */
    public String getTkn() {
        return tkn;
    }

    /**
     * @param tkn the tkn to set
     */
    public void setTkn(String tkn) {
        this.tkn = tkn;
    }
    
}
