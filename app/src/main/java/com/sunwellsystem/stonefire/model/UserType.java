package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserType
{

    public static final Integer USER_TYPE_ADMIN = 1;
    public static final Integer USER_TYPE_TENANT = 2;
    public static final Integer USER_TYPE_USER = 3;

    private Integer id;
    private String name;

    public UserType ()
    {
    }

    public UserType (Integer id)
    {
        this.id = id;
    }

    public UserType (Integer id, String typeName)
    {
        this.id = id;
        this.name = typeName;
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

    public void setTypeName (String name)
    {
        this.name = name;
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
        if (!(object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.UserType[ id=" + id + " ]";
    }

}