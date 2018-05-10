package com.starwayne.databinding.bean;


import java.net.URL;

public class User {
    private String displayName;
    private String firstName;
    private String lastName;
    private String country;
    private URL avatarUrl;
    private boolean hidden;
    private boolean vip;


    public User() {
        this(null, null, null);
    }

    public User(String firstName , String lastName){
        this(firstName, lastName, null);
    }

    public User(String firstName, String lastName, String displayName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public URL getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(URL avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean getVip() {
        return vip;
    }

    public void setVip(boolean VIP) {
        vip = VIP;
    }
}
