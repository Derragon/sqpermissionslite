/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package permissions.components;

import java.util.ArrayList;

/**
 *
 * @author Scott
 */
public class User {
    protected ArrayList<String> groups = new ArrayList();
    protected ArrayList<String> perms = new ArrayList();
    protected String name, mainGroup;
    
    public User (String... params) {
        if (params.length == 1){
            this.name = params[0];
        } else if (params.length == 2){
            this.name = params[0];
            this.mainGroup = params[1];
        } else if (params.length > 2){
            this.name = params[0];
            this.mainGroup = params[1];
            for (int x = 2; x < params.length; x++){
                this.groups.add(params[x]);
            }
        }
    }
    
    public String getName () {
        return this.name;
    }
    
    public String getMainGroup () {
        return mainGroup;
    }
    
    public ArrayList getGroups () {
        return groups;
    }
    
    public void setName (String name){
        this.name = name;
    }
    
    public void setMainGroup(String mainGroup){
        this.mainGroup = mainGroup;
    }
    
    public void addToGroup (String group){
        if (!this.groups.contains(group)){
            this.groups.add(group);
        } else {
            System.err.println("User was already in group.");
        }
    }
    
    public void removeFromGroup(String group){
        if (this.groups.contains(group)){
            this.groups.remove(group);
        } else {
            System.err.println("User was not in group.");
        }
    }
    
    /* 
     * This area will be used for PermissionsManager tools.
     * Do not add Groups-based methods to this area.
     */
    
    public void setPerms(ArrayList<String> perms){
        this.perms = perms;
    }
    
    public void setGroups(ArrayList<String> groups){
        this.groups = groups;
    }
}
