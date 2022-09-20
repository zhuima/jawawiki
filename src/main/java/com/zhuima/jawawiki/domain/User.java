package com.zhuima.jawawiki.domain;

import java.util.Date;

public class User {
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String contact;

    private Boolean state;

    private Date insertTime;

    private Date updateTime;

    private Date lastLoginTime;

    private Byte superManager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Byte getSuperManager() {
        return superManager;
    }

    public void setSuperManager(Byte superManager) {
        this.superManager = superManager;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", contact=").append(contact);
        sb.append(", state=").append(state);
        sb.append(", insertTime=").append(insertTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", superManager=").append(superManager);
        sb.append("]");
        return sb.toString();
    }
}