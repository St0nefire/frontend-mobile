package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class TenantCategory implements Serializable
{

    private String id;
    private String name;


    public TenantCategory ()
    {
    }

    public TenantCategory (String id)
    {
        this.id = id;
    }

    public TenantCategory (String id, String name, String email)
    {
        this.id = id;
        this.name = name;
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
}