package permissions.components;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Scott
 */
public class Group {
    
    protected ArrayList<String> parents, children = null;
    protected ArrayList<String> members = null;
    protected ArrayList<String> perms = null;
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
    
    public boolean addMember (String u){
        if (!members.contains(u)){
            members.add(u);
            return true;
        }
        return false;
    }
}
