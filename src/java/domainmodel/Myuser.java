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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hanzh
 */
@Entity
@Table(name = "myuser")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Myuser.findAll", query = "SELECT m FROM Myuser m")
    , @NamedQuery(name = "Myuser.findByUsername", query = "SELECT m FROM Myuser m WHERE m.username = :username")
    , @NamedQuery(name = "Myuser.findByPassword", query = "SELECT m FROM Myuser m WHERE m.password = :password")
    , @NamedQuery(name = "Myuser.findByEmail", query = "SELECT m FROM Myuser m WHERE m.email = :email")
    , @NamedQuery(name = "Myuser.findByPhone", query = "SELECT m FROM Myuser m WHERE m.phone = :phone")
    , @NamedQuery(name = "Myuser.findByActive", query = "SELECT m FROM Myuser m WHERE m.active = :active")
    , @NamedQuery(name = "Myuser.findByFirstname", query = "SELECT m FROM Myuser m WHERE m.firstname = :firstname")
    , @NamedQuery(name = "Myuser.findByLastname", query = "SELECT m FROM Myuser m WHERE m.lastname = :lastname")
    , @NamedQuery(name = "Myuser.findByResetPasswordUUID", query = "SELECT m FROM Myuser m WHERE m.resetPasswordUUID = :resetPasswordUUID")
})
public class Myuser implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "Active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "ResetPasswordUUID")
    private String resetPasswordUUID;
    @JoinColumn(name = "Department", referencedColumnName = "DepartmentID")
    @ManyToOne
    private Mydepartment department;
    @JoinColumn(name = "Role", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private Myrole role;

    public Myuser()
    {
    }

    public Myuser(String username)
    {
        this.username = username;
    }

    public Myuser(String username, String password, String email, boolean active, String firstname, String lastname)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public boolean getActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getResetPasswordUUID()
    {
        return resetPasswordUUID;
    }

    public void setResetPasswordUUID(String resetPasswordUUID)
    {
        this.resetPasswordUUID = resetPasswordUUID;
    }

    public Mydepartment getDepartment()
    {
        return department;
    }

    public void setDepartment(Mydepartment department)
    {
        this.department = department;
    }

    public Myrole getRole()
    {
        return role;
    }

    public void setRole(Myrole role)
    {
        this.role = role;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Myuser))
        {
            return false;
        }
        Myuser other = (Myuser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domainmodel.Myuser[ username=" + username + " ]";
    }
    
}
