/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Mydepartment;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author hanzh
 */
public class DepartmentDB
{

    /**
     *
     * @return @throws Exception
     */
    public List<Mydepartment> getAll() throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try
        {
            List<Mydepartment> departmentList = em.createNamedQuery("Mydepartment.findAll", Mydepartment.class).getResultList();
            return departmentList;
        } catch (Exception ex)
        {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, "Cannot read deparment list", ex);
            throw new Exception("Error getting companies");
        } finally
        {
            em.close();
        }
    }

    public Mydepartment getDepartment(String departmentName) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try
        {
            Mydepartment department = em.find(Mydepartment.class, departmentName);
            return department;
        } catch (Exception ex)
        {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, "Cannot read department", ex);
            throw new Exception("Error getting department");
        } finally
        {
            em.close();
        }
    }
    
    public Mydepartment getDepartment(Integer departmentID) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try
        {
            Mydepartment department = em.find(Mydepartment.class, departmentID);
            return department;
        } catch (Exception ex)
        {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, "Cannot read department", ex);
            throw new Exception("Error getting department");
        } finally
        {
            em.close();
        }
    }
}
