package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;


public class Address implements Serializable
{

    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private Regency regency;

    public Address ()
    {
    }

    public Address (Integer id)
    {
        this.id = id;
    }

    public Address (Integer id, String name, String address, String phoneNumber)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId ()
    {
        return id;
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Regency getRegency ()
    {
        return regency;
    }

    public void setRegency (Regency regency)
    {
        this.regency = regency;
    }

    @Override
    public int hashCode ()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode () : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Addresses[ id=" + id + " ]";
    }

}
