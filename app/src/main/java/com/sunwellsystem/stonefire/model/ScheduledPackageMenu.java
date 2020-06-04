package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
public class ScheduledPackageMenu implements Serializable
{
    private MasterMenu masterMenu;
    private ScheduledPackage scheduledPackage;
    private int date;
    public ScheduledPackageMenu ()
    {
    }

    public int getDate ()
    {
        return date;
    }

    public void setDate (int date)
    {
        this.date = date;
    }


    public MasterMenu getMasterMenu ()
    {
        return masterMenu;
    }

    public void setMasterMenu (MasterMenu masterMenuId)
    {
        this.masterMenu = masterMenuId;
    }

    public ScheduledPackage getScheduledPackage ()
    {
        return scheduledPackage;
    }

    public void setScheduledPackage (ScheduledPackage scheduledPackageId)
    {
        this.scheduledPackage = scheduledPackageId;
    }

}