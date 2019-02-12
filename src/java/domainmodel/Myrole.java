/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "myrole")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Myrole.findAll", query = "SELECT m FROM Myrole m")
    , @NamedQuery(name = "Myrole.findByRoleID", query = "SELECT m FROM Myrole m WHERE m.roleID = :roleID")
    , @NamedQuery(name = "Myrole.findByRoleName", query = "SELECT m FROM Myrole m WHERE m.roleName = :roleName")
})
public class Myrole implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RoleID")
    private Integer roleID;
    @Basic(optional = false)
    @Column(name = "RoleName")
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Myuser> myuserList;

    public Myrole()
    {
    }

    public Myrole(Integer roleID)
    {
        this.roleID = roleID;
    }

    public Myrole(Integer roleID, String roleName)
    {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public Integer getRoleID()
    {
        return roleID;
    }

    public void setRoleID(Integer roleID)
    {
        this.roleID = roleID;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
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
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Myrole))
        {
            return false;
        }
        Myrole other = (Myrole) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domainmodel.Myrole[ roleID=" + roleID + " ]";
    }
    
}
