package com.example.park_sure.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Entity
@Table(name="user_registration")
public class user_registration {

    @Id
    @Column(name="user_id")
    String user_id;

    @Column(name="user_name")
    String user_name;

    @Column(name="registered_on")
    Date registered_on;

    @Column(name="mobile_number")
    String mobile_number;

    @Column(name="email")
    String email;

    @Column(name="verified")
    boolean verified;

 /*   public user_registration(String user_id, String user_name, Date registered_on, String mobile_number, String email, boolean verified) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.registered_on = registered_on;
        this.mobile_number = mobile_number;
        this.email = email;
        this.verified = verified;
    }*/

    public user_registration() {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getRegistered_on() {
        return registered_on;
    }

    public void setRegistered_on(Date registered_on) {
        this.registered_on = registered_on;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "user_registration{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", registered_on=" + registered_on +
                ", mobile_number='" + mobile_number + '\'' +
                ", email='" + email + '\'' +
                ", verified=" + verified +
                '}';
    }
}
