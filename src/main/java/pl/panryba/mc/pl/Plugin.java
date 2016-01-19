/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.pl;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author PanRyba.pl
 */
public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();
        ConfigurationSection matConfig = config.getConfigurationSection("materials");
        
        Map<String, Object> entries = matConfig.getValues(false);
        
        DeclinationManager manager = DeclinationManager.getInstance();
        
        for(Entry<String, Object> entry : entries.entrySet()) {
            Material mat = Material.getMaterial(entry.getKey());
            
            ArrayList<String> values = (ArrayList<String>)entry.getValue();
            Declination decl = new Declination(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6));
            
            manager.setDeclination(mat, decl);
        }
    }
    
}
