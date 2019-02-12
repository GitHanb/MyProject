/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Myuser;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author hanzh
 */
public class UserDB
{

    public Myuser getUser(String username) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try
        {
            Myuser user = em.find(Myuser.class, username);
            return user;
        } catch (Exception ex)
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new Exception("Error getting Users");
        } finally
        {
            em.close();
        }
    }

    public List<Myuser> getAllUsers() throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try
        {
            List<Myuser> users = em.createNamedQuery("Myuser.findAll", Myuser.class).getResultList();
            return users;
        } catch (Exception ex)
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new Exception("Error getting Users");
        } finally
        {
            em.close();
        }

    }

    public int delete(Myuser user) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try
        {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();
            return 1;
        } catch (Exception ex)
        {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + user.toString(), ex);
            throw new Exception("Error deleting user");
        } finally
        {
            em.close();
        }
    }

    public int update(Myuser user) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try
        {
            trans.begin();
            em.merge(user);
            trans.commit();
            return 1;
        } catch (Exception ex)
        {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot update " + user.toString(), ex);
            throw new Exception("Error updating user");
        } finally
        {
            em.close();
        }
    }

    public int insert(Myuser user) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try
        {
            trans.begin();
            em.persist(user);
            trans.commit();
            return 1;
        } catch (Exception ex)
        {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
            throw new Exception("Error inserting user");
        } finally
        {
            em.close();
        }
    }
}
