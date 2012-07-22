package permissions.components;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Scott
 */
public class Group {
    
    protected ArrayList<String> parents, children, members, perms, owners = null;
    protected String name = null;
    
    public Group (ArrayList parents, ArrayList children, String name) {
        this.parents = parents;
        this.children = children;
        this.name = name;
    }
    
    public ArrayList getParents () {
        return parents;
    }
    
    public ArrayList getChildren () {
        return children;
    }
    
    public String getName () {
        return name;
    }
    
    public ArrayList<String> getMembers () {
        return members;
    }
    
    public void setName (String name){
        this.name = name;
    }
    
    public boolean addMember (String u){
        if (!members.contains(u)){
            members.add(u);
            return true;
        }
        return false;
    }
    
    public void removeMember (String u){
        if (members.contains(u)){
            members.remove(u);
        }
    }
    
    public void addMembers (String[] us){
        for (int x = 0; x < us.length; x++){
            if (!members.contains(us[x])){
                members.add(us[x]);
            }
        }
    }
    
    public void removeMembers (String[] us){
        for (int x = 0; x < us.length; x++){
            if (members.contains(us[x])){
                members.remove(us[x]);
            }
        }
    }
    
    /* 
     * This area will be used for PermissionsManager tools.
     * Do not add Groups-based methods to this area.
     */
    
    public void setMembers (ArrayList<String> members){
        this.members = members;
    }
    
    public void setOwners(ArrayList<String> owners){
        this.owners = owners;
    }
    
    public void setPerms(ArrayList<String> perms){
        this.perms = perms;
    }
}
