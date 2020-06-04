package com.sunwellsystem.stonefire.model;

/**
 * Created by sunwell on 10/4/17.
 */

//import aegwyn.core.web.util.Util;
import java.io.BufferedInputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

public class Tenant implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String city;
    private String province;
    private String country;
    private String description;
    private String phoneNumber;
    private String memo;
    private String news;
    private String logo;
    private String profilePicture;
    private TenantCategory category;
    private List<TenantConfiguration> tenantConfigurations;

    public Tenant ()
    {
    }

    public Tenant (String id)
    {
        this.id = id;
    }

    public Tenant (String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = getChecksumOf (password);
    }

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePicture ()
    {
        return profilePicture;
    }

    public void setProfilePicture (String profilePicture)
    {
        this.profilePicture = profilePicture;
    }


    /**
     * @return the memo
     */
    public String getMemo ()
    {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo (String memo)
    {
        this.memo = memo;
    }

    /**
     * @return the news
     */
    public String getNews ()
    {
        return news;
    }

    /**
     * @param news the news to set
     */
    public void setNews (String news)
    {
        this.news = news;
    }

    /**
     * @return the logo
     */
    public String getLogo ()
    {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo (String logo)
    {
        this.logo = logo;
    }

    /**
     * @return the address
     */
    public String getAddress ()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress (String address)
    {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity ()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity (String city)
    {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince ()
    {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince (String province)
    {
        this.province = province;
    }

    /**
     * @return the country
     */
    public String getCountry ()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry (String country)
    {
        this.country = country;
    }

    /**
     * @return the description
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription (String description)
    {
        this.description = description;
    }

    /**
     * @return the category
     */
    public TenantCategory getCategory ()
    {
        return category;
    }

    /**
     * @param tenantCategory the category to set
     */
    public void setCategory (TenantCategory tenantCategory)
    {
        this.category = tenantCategory;
    }

    /**
     * @return the tenantConfigurations
     */
    public List<TenantConfiguration> getTenantConfigurations ()
    {
        return tenantConfigurations;
    }

    /**
     * @param tenantConfigurations the tenantConfigurations to set
     */
    public void setTenantConfigurations (List<TenantConfiguration> tenantConfigurations)
    {
        this.tenantConfigurations = tenantConfigurations;
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
        if (!(object instanceof Tenant)) {
            return false;
        }
        Tenant other = (Tenant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Users[ id=" + id + " ]";
    }

    public String getChecksumOf(String _strToCheck)
    {


        try {
            StringBuffer buf = new StringBuffer();
            byte[] digestBuffer = new byte[8];
            byte[] digest = null;
            BufferedInputStream bis;
            MessageDigest md5;
            int i;
            md5 = MessageDigest.getInstance("MD5");
            md5.update(_strToCheck.getBytes());
            digest = md5.digest();
            int len = digest.length;
            for (int j = 0; j < len; j++) {
                byte2hex(digest[j], buf);
            }

            return buf.toString().toLowerCase ();
        }
        catch (Exception e) {
            e.printStackTrace (System.out);
        }
        return null;
    }

    private void byte2hex(byte b, StringBuffer buf)
    {
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int high = (b & 0xf0) >> 4;
        int low = b & 0x0f;
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }

}