package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MasterTag implements Serializable
{

    private Integer id;
    private String name;
    private String picture;

    public MasterTag ()
    {
    }

    public MasterTag (Integer id)
    {
        this.id = id;
    }

    public MasterTag (Integer id, String tagName)
    {
        this.id = id;
        this.name = tagName;
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

    public void setName (String tagName)
    {
        this.name = tagName;
    }

    public String getPicture ()
    {
        return picture;
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
        if (!(object instanceof MasterTag)) {
            return false;
        }
        MasterTag other = (MasterTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.MasterTags[ id=" + id + " ]";
    }

}