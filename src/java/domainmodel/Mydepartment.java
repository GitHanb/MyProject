/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hanzh
 */
@Entity
@Table(name = "mydepartment")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Mydepartment.findAll", query = "SELECT m FROM Mydepartment m")
    , @NamedQuery(name = "Mydepartment.findByDepartmentID", query = "SELECT m FROM Mydepartment m WHERE m.departmentID = :departmentID")
    , @NamedQuery(name = "Mydepartment.findByDepartmentName", query = "SELECT m FROM Mydepartment m WHERE m.departmentName = :departmentName")
})
public class Mydepartment implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DepartmentID")
    private Integer departmentID;
    @Basic(optional = false)
    @Column(name = "DepartmentName")
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private List<Myuser> myuserList;

    public Mydepartment()
    {
    }

    public Mydepartment(Integer departmentID)
    {
        this.departmentID = departmentID;
    }

    public Mydepartment(Integer departmentID, String departmentName)
    {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentID()
    {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID)
    {
        this.departmentID = departmentID;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }

    @XmlTransient
    public List<Myuser> getMyuserList()
    {
        return myuserList;
    }

    public void setMyuserList(List<Myuser> myuserList)
    {
        this.myuserList = myuserList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mydepartment))
        {
            return false;
        }
        Mydepartment other = (Mydepartment) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domainmodel.Mydepartment[ departmentID=" + departmentID + " ]";
    }
    
}
