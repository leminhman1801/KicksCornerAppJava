/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

/**
 *
 * @author Asus
 */
public class Role {
    int roleID;
    String roleName;
    String permission;
    public Role(int roleID, String roleName, String permission){
        this.roleID = roleID;
        this.roleName = roleName;
        this.permission = permission;
    }
    public int getRoleID(){
        return roleID;
    }
    public String getRoleName(){
        return roleName;
    }
    public String getPermission(){
        return permission;
    }
}
