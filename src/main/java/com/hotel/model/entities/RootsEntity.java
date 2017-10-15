package com.hotel.model.entities;

import java.io.Serializable;

public class RootsEntity implements Serializable {
    private int rootId;
    private String rootName;
    private String login;
    private String password;

    public RootsEntity() {
    }

    public RootsEntity(int rootId, String rootName, String login, String password) {
        this.rootId = rootId;
        this.rootName = rootName;
        this.login = login;
        this.password = password;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RootsEntity: " + rootId +
                " rootName: " + rootName +
                ", login: " + login +
                ", password: " + password;
    }
}
