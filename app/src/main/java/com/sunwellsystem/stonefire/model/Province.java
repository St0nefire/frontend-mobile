package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */




    import java.io.Serializable;
    import java.util.Date;
    import java.util.List;

public class Province implements Serializable
{

    private Integer id;
    private String name;
    private List<Regency> kotasList;

    public Province ()
    {
    }

    public Province (Integer id)
    {
        this.id = id;
    }

    public Province (Integer id, String provinceName)
    {
        this.id = id;
        this.name = provinceName;
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


    public List<Regency> getKotasList ()
    {
        return kotasList;
    }

    public void setKotasList (List<Regency> kotasList)
    {
        this.kotasList = kotasList;
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
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Provinsis[ id=" + id + " ]";
    }

}

