/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.DepartmentDB;
import domainmodel.Mydepartment;
import java.util.List;

/**
 *
 * @author hanzh
 */
public class DepartmentService
{
    private final DepartmentDB departmentDB;
    
    public DepartmentService()
    {
        departmentDB = new DepartmentDB();
    }
    
    public List<Mydepartment> getAll() throws Exception
    {
        return departmentDB.getAll();
    }
    
    public Mydepartment getDepartment(String departmentName) throws Exception
    {
        return departmentDB.getDepartment(departmentName);
    }
    
    public Mydepartment getDepartment(Integer departmentID) throws Exception
    {
        return departmentDB.getDepartment(departmentID);
    }
}
