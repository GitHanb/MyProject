/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.UserDB;
import domainmodel.Myuser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanzh
 */
public class AccountService
{

    public int loginHandler(String username, String password)
    {
        UserDB userDB = new UserDB();
        Myuser user = null;
        try
        {
            user = userDB.getUser(username);
        } catch (Exception ex)
        {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (user == null)
        {
            return 0;
        }
        if (!user.getPassword().equals(password))
        {
            return 1;
        }
        return 2;
    }
}
