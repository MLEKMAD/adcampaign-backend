package com.adcamaign.adcampaign.business;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Enter an email")
    @Column(unique = true)
    @Email(message = "Format is not correct")
    private String email;

    @Size(min = 5, message = "Your password should contain at least 5 characters")
    private String password;


    @Temporal(TemporalType.DATE)
    @NotNull(message = "enter your birthday!")
    @Past(message = "you are not born in the future!")
    private Date birthday;

    private Date subscriptionDate;


    public User() {
        subscriptionDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date dateDeNaissance) {
        this.birthday = dateDeNaissance;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date dateInscription) {
        this.subscriptionDate = dateInscription;
    }

}

