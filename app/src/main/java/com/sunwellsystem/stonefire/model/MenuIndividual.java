package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MenuIndividual implements Serializable
{

    private Integer id;
    private String name;
    private String konten;
    private String memo;
    private boolean available;
    private double price;
    private String image;
    private Tenant tenant;
    private List<MasterTag> tags;
    private List<MenuIndividualMenu> menus;

    public MenuIndividual ()
    {
    }

    public MenuIndividual (Integer id)
    {
        this.id = id;
    }

    public MenuIndividual (Tenant _t, String name, String konten, String memo, Double price, String image)
    {
        this.tenant = _t;
        this.id = id;
        this.name = name;
        this.konten = konten;
        this.price = price;
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

    /**
     * @return the tags
     */
    public List<MasterTag> getTags ()
    {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags (List<MasterTag> tags)
    {
        this.tags = tags;
    }

    /**
     * @return the menus
     */
    public List<MenuIndividualMenu> getMenus ()
    {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus (List<MenuIndividualMenu> menus)
    {
        this.menus = menus;
    }

    /**
     * @return the tebant
     */
    public Tenant getTenant ()
    {
        return tenant;
    }

    /**
     * @param _t the tebant to set
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
        if (!(object instanceof MenuIndividual)) {
            return false;
        }
        MenuIndividual other = (MenuIndividual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.MenuIndividuals[ id=" + id + " ]";
    }

}
