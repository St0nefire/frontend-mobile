package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class MasterMenu implements Serializable
{

    private Integer id;
    private String name;
    private String konten;
    private String memo;
    private boolean active;
    private String image;
    private Tenant tenant;

    public MasterMenu ()
    {
    }

    public MasterMenu (Integer id)
    {
        this.id = id;
    }

    public MasterMenu (Tenant _t, Integer id, String name, String konten, boolean isActive, String image)
    {
        this.tenant = _t;
        this.id = id;
        this.name = name;
        this.konten = konten;
        this.active = isActive;
        this.image = image;
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

    public String getKonten ()
    {
        return konten;
    }

    public void setKonten (String konten)
    {
        this.konten = konten;
    }

    public String getMemo ()
    {
        return memo;
    }

    public void setMemo (String memo)
    {
        this.memo = memo;
    }

    public boolean isActive ()
    {
        return active;
    }

    public void setActive (boolean isActive)
    {
        this.active = isActive;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    /**
     * @return the tenant
     */
    public Tenant getTenant ()
    {
        return tenant;
    }

    /**
     * @param _t the tenant to set
     */
    public void setTenant (Tenant _t)
    {
        this.tenant = _t;
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
        if (!(object instanceof MasterMenu)) {
            return false;
        }
        MasterMenu other = (MasterMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.MasterMenus[ id=" + id + " ]";
    }

}
