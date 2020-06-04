package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MenuIndividualMenu implements Serializable
{

    private MasterMenu masterMenu;
    private MenuIndividual menuIndividual;


    public MenuIndividualMenu ()
    {
    }

    public MasterMenu getMasterMenu ()
    {
        return masterMenu;
    }

    public void setMasterMenu (MasterMenu masterMenuId)
    {
        this.masterMenu = masterMenuId;
    }

    public MenuIndividual getMenuIndividual ()
    {
        return menuIndividual;
    }

    public void setMenuIndividual (MenuIndividual _mi)
    {
        this.menuIndividual = _mi;
    }

}