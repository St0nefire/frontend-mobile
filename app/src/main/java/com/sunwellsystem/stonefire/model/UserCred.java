package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.BufferedInputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

public class UserCred implements Serializable
{
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String providerName;
    private String providerId;
    private String about;
    private String profilePicture;
    private String rememberToken;
    private Date createdAt;
    private Date updatedAt;
    private List<Address> addressesList;
    private Tenant tenant;
    private UserType userType;

    public UserCred ()
    {
    }

    public UserCred (String id)
    {
        this.id = id;
    }

    public UserCred (String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
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

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getProviderName ()
    {
        return providerName;
    }

    public void setProviderName (String providerName)
    {
        this.providerName = providerName;
    }

    public String getProviderId ()
    {
        return providerId;
    }

    public void setProviderId (String providerId)
    {
        this.providerId = providerId;
    }

    public String getAbout ()
    {
        return about;
    }

    public void setAbout (String about)
    {
        this.about = about;
    }

    public String getProfilePicture ()
    {
        return profilePicture;
    }

    public void setProfilePicture (String profilePicture)
    {
        this.profilePicture = profilePicture;
    }

    public String getRememberToken ()
    {
        return rememberToken;
    }

    public void setRememberToken (String rememberToken)
    {
        this.rememberToken = rememberToken;
    }

    public List<Address> getAddressesList ()
    {
        return addressesList;
    }

    public void setAddressesList (List<Address> addressesList)
    {
        this.addressesList = addressesList;
    }

    public UserType getUserType ()
    {
        return userType;
    }

    public void setUserType (UserType userTypeId)
    {
        this.userType = userTypeId;
    }

    /**
     * @return the tenant
     */
    public Tenant getTenant ()
    {
        return tenant;
    }

    /**
     * @param tenant the tenant to set
     */
    public void setTenant (Tenant tenant)
    {
        this.tenant = tenant;
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
        if (!(object instanceof UserCred)) {
            return false;
        }
        UserCred other = (UserCred) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Users[ id=" + id + " ]";
    }

}