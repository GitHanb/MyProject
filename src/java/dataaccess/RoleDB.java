/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Myrole;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author hanzh
 */
public class RoleDB
{

    public Myrole getRole(Integer roleID) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try
        {
            Myrole role = em.find(Myrole.class, roleID);
            return role;
        } catch (Exception ex)
        {
            Logger.getLogger(Myrole.class.getName()).log(Level.SEVERE, "Cannot read role", ex);
            throw new Exception("Error getting role");
        } finally
        {
            em.close();
        }
    }
}
