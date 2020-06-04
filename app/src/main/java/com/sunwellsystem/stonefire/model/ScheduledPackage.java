package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ScheduledPackage implements Serializable
{

    private Integer id;
    private String name;
    private String konten;
    private String memo;
    private boolean available;
    private double price;
    private String image;
    private Integer minOrder;
    private Tenant tenant;
    private List<ScheduledPackageMenu> menus;
    private List<MasterTag> tags;

    public ScheduledPackage ()
    {
    }

    public ScheduledPackage (Integer id)
    {
        this.id = id;
    }

    public ScheduledPackage (Tenant _t, String name, String konten, String _memo, double price, int minOrder, boolean isAvalaible, String image)
    {
        this.tenant = _t;
        this.name = name;
        this.konten = konten;
        this.available = isAvalaible;
        this.price = price;
        this.image = image;
        this.minOrder = minOrder;
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

    public boolean isAvailable ()
    {
        return available;
    }

    public void setAvailable (boolean isAvalaible)
    {
        this.available = isAvalaible;
    }

    public double getPrice ()
    {
        return price;
    }

    public void setPrice (double price)
    {
        this.price = price;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public Integer getMinOrder ()
    {
        return minOrder;
    }

    public void setMinOrder (Integer minOrder)
    {
        this.minOrder = minOrder;
    }


    public List<MasterTag> getTags ()
    {
        return tags;
    }

    public void setTags (List<MasterTag> masterTagScheduledPackageList)
    {
        this.tags = masterTagScheduledPackageList;
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
        if (!(object instanceof ScheduledPackage)) {
            return false;
        }
        ScheduledPackage other = (ScheduledPackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.ScheduledPackages[ id=" + id + " ]";
    }

    /**
     * @return the menus
     */
    public List<ScheduledPackageMenu> getMenus ()
    {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus (List<ScheduledPackageMenu> menus)
    {
        if(menus == null)
            return;

        for (ScheduledPackageMenu menu : menus) {
            menu.setScheduledPackage (this);
        }
        this.menus = menus;
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

}
