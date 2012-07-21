package permissions.main;

import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import permissions.components.Group;
import permissions.managers.PermissionsManager;

/**
 *
 * @author Scott Stevens
 */
public class Permissions extends JavaPlugin implements Listener {
    
    PermissionsManager gm;
    String fileLoc;
    
    Logger log = Logger.getLogger("Minecraft");
    
    public PermissionsManager getGroupManager () {
        return this.gm;
    }
    
    public HashMap<String, Group> getGroupList () {
        return gm.getGroups();
    }
    
    public void onEnable () {
        fileLoc = this.getDataFolder() + "/database.db";
        gm = new PermissionsManager(fileLoc);
    }
    
    public void onDisable () {
        
    }
    
    public boolean onPlayerCommand () {
        return false;
    }
    
}
