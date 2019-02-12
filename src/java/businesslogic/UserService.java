/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import domainmodel.Mydepartment;
import domainmodel.Myuser;
import java.util.List;

/**
 *
 * @author hanzh
 */
public class UserService
{

    private final UserDB userDB;
    private final RoleDB roleDB;

    public UserService()
    {
        userDB = new UserDB();
        roleDB = new RoleDB();
    }

    public Myuser getUser(String username) throws Exception
    {
        return userDB.getUser(username);
    }

    public List<Myuser> getAllUsers() throws Exception
    {
        return userDB.getAllUsers();
    }

    public int delete(String username) throws Exception
    {
        Myuser deletedUser = userDB.getUser(username);

        return userDB.delete(deletedUser);
    }

    public int update(String username, String password, String email, boolean active, String firstname, String lastname, String phone) throws Exception
    {
        Myuser user = userDB.getUser(username);

        user.setPassword(password);
        user.setEmail(email);
        user.setActive(active);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPhone(phone);

        return userDB.update(user);

    }
    
    public int update(String username, Mydepartment department, boolean active) throws Exception
    {
        Myuser user = userDB.getUser(username);
        user.setDepartment(department);
        user.setActive(active);
        
        return userDB.update(user);
    }

    public int insert(String username, String password, String email, String phone, boolean active, String firstname, String lastname) throws Exception
    {
        Myuser user = new Myuser(username, password, email, active, firstname, lastname);
        user.setPhone(phone);
        user.setRole(roleDB.getRole(2));
        return userDB.insert(user);
    }
}
