package com.cg.drinkdelight.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String addressLine;
    private String city;
    private String state;
    private String pincode;
    
 
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId", nullable = false)
    private User userid;
    

    public Address(int id, String addressLine, String city, String state, String pincode) {
        super();
        this.id = id;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public Address() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

//	public String getUserid() {
//		return userid;
//	}
//
//	public void setUserid(String userid) {
//		this.userid = userid;
//	}

}
