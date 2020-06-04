package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Regency
{

    private Integer id;
    private String name;
    private Province province;

    public Regency ()
    {
    }

    public Regency (Integer id)
    {
        this.id = id;
    }

    public Regency (Integer id, String name)
    {
        this.id = id;
        this.name = name;
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


    public Province getProvince ()
    {
        return province;
    }

    public void setProvince (Province province)
    {
        this.province = province;
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
        if (!(object instanceof Regency)) {
            return false;
        }
        Regency other = (Regency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Kotas[ id=" + id + " ]";
    }

}
