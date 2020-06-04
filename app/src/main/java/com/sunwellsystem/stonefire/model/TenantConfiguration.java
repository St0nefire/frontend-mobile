package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Benny
 */

public class TenantConfiguration implements Serializable
{


    private String id;
    private Tenant parent;
    private String currency;
    private String formatNoInvoice;
    private Double defaultMiscChargeValue;
    private Integer defaultMiscChargeType;
    private String defaultMiscChargeMemo;
    private Boolean vatInclusive;
    private Double defaultVatValue;

    /**
     * @return the id
     */
    public String getId ()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId (String id)
    {
        this.id = id;
    }

    /**
     * @return the parent
     */
    public Tenant getParent ()
    {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent (Tenant parent)
    {
        this.parent = parent;
    }

    /**
     * @return the currency
     */
    public String getCurrency ()
    {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    /**
     * @return the formatNoInvoice
     */
    public String getFormatNoInvoice ()
    {
        return formatNoInvoice;
    }

    /**
     * @param formatNoInvoice the formatNoInvoice to set
     */
    public void setFormatNoInvoice (String formatNoInvoice)
    {
        this.formatNoInvoice = formatNoInvoice;
    }

    /**
     * @return the defaultMiscChargeValue
     */
    public Double getDefaultMiscChargeValue ()
    {
        return defaultMiscChargeValue;
    }

    /**
     * @param defaultMiscChargeValue the defaultMiscChargeValue to set
     */
    public void setDefaultMiscChargeValue (Double defaultMiscChargeValue)
    {
        this.defaultMiscChargeValue = defaultMiscChargeValue;
    }

    /**
     * @return the defaultMiscChargeType
     */
    public Integer getDefaultMiscChargeType ()
    {
        return defaultMiscChargeType;
    }

    /**
     * @param defaultMiscChargeType the defaultMiscChargeType to set
     */
    public void setDefaultMiscChargeType (Integer defaultMiscChargeType)
    {
        this.defaultMiscChargeType = defaultMiscChargeType;
    }

    /**
     * @return the defaultMiscChargeMemo
     */
    public String getDefaultMiscChargeMemo ()
    {
        return defaultMiscChargeMemo;
    }

    /**
     * @param defaultMiscChargeMemo the defaultMiscChargeMemo to set
     */
    public void setDefaultMiscChargeMemo (String defaultMiscChargeMemo)
    {
        this.defaultMiscChargeMemo = defaultMiscChargeMemo;
    }

    /**
     * @return the vatInclusive
     */
    public Boolean getVatInclusive ()
    {
        return vatInclusive;
    }

    /**
     * @param vatInclusive the vatInclusive to set
     */
    public void setVatInclusive (Boolean vatInclusive)
    {
        this.vatInclusive = vatInclusive;
    }

    /**
     * @return the defaultVatValue
     */
    public Double getDefaultVatValue ()
    {
        return defaultVatValue;
    }

    /**
     * @param defaultVatValue the defaultVatValue to set
     */
    public void setDefaultVatValue (Double defaultVatValue)
    {
        this.defaultVatValue = defaultVatValue;
    }
    private static final long serialVersionUID = 1L;


}