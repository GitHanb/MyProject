/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hanzh
 */
@Entity
@Table(name = "mygender")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Mygender.findAll", query = "SELECT m FROM Mygender m")
    , @NamedQuery(name = "Mygender.findByGenderID", query = "SELECT m FROM Mygender m WHERE m.genderID = :genderID")
    , @NamedQuery(name = "Mygender.findByGenderName", query = "SELECT m FROM Mygender m WHERE m.genderName = :genderName")
})
public class Mygender implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GenderID")
    private Integer genderID;
    @Basic(optional = false)
    @Column(name = "GenderName")
    private String genderName;

    public Mygender()
    {
    }

    public Mygender(Integer genderID)
    {
        this.genderID = genderID;
    }

    public Mygender(Integer genderID, String genderName)
    {
        this.genderID = genderID;
        this.genderName = genderName;
    }

    public Integer getGenderID()
    {
        return genderID;
    }

    public void setGenderID(Integer genderID)
    {
        this.genderID = genderID;
    }

    public String getGenderName()
    {
        return genderName;
    }

    public void setGenderName(String genderName)
    {
        this.genderName = genderName;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (genderID != null ? genderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mygender))
        {
            return false;
        }
        Mygender other = (Mygender) object;
        if ((this.genderID == null && other.genderID != null) || (this.genderID != null && !this.genderID.equals(other.genderID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domainmodel.Mygender[ genderID=" + genderID + " ]";
    }
    
}
