package permissions.managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import permissions.components.Group;
import permissions.components.User;

/**
 *
 * @author Scott Stevens
 */

public class PermissionsManager {
    protected HashMap<String, Group> groups;
    protected HashMap<String, User> users;
    protected String dbLoc;
    
    public PermissionsManager (String path) {
        System.out.println(path);
        this.dbLoc = path;
        try {
            this.loadDatabase();
        } catch (Exception e){
            System.err.println(e.getCause());
            System.err.println(e.getMessage());
        }
    }
    
    public HashMap getGroups () {
        return groups;
    }
    
    public boolean addUser () {
        return false;
    }
    
    public boolean createUser () {
        return false;
    }
    
    public boolean deleteUser () {
        return false;
    }
    
    public boolean addGroup (Group g){
        if (g.getName() != null && groups.containsKey(g.getName())){
            groups.put(g.getName(), g);
            if (groups.containsValue(g) && groups.containsKey(g.getName())){
                return true;
            }
        }
        return false;
    }
    
    public boolean removeGroup (String g){
        if (groups.containsKey(g) && groups.get(g).getName().equalsIgnoreCase(g)){
            
        }
        return false;
    }
    
    public void saveDatabase () throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection c = null;
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbLoc);
        
    }
    
    public void loadDatabase () throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection c = null;
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbLoc);
        Statement stat = conn.createStatement();
        stat.executeUpdate("create table if not exists people (username, maingroup, groups, perms);");
        
        conn.setAutoCommit(true);
        ResultSet rs = stat.executeQuery("select * from users;");
        User u = new User ();
        ArrayList<String> perms = new ArrayList();
        while (rs.next()) {
            
            u.setName(rs.getString("name"));
            u.setMainGroup(rs.getString("maingroup"));
            String[] permlist = rs.getString("perms").split(",");
            
            for (int x = 0; x < permlist.length; x++){
                perms.add(permlist[x]);
            }
            u.setPerms(perms);
            
            users.put(u.getName(), u);
            
            if (groups.containsKey(u.getMainGroup())){
                groups.get(u.getMainGroup()).addMember(u.getName());
            }
            
            u = null;
        }
        rs.close();
        conn.close();
    }
}
