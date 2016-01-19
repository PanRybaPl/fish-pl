/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.pl;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;

/**
 *
 * @author PanRyba.pl
 */
public class DeclinationManager {
    private static final DeclinationManager instance = new DeclinationManager();
    private final Map<Material, Declination> materialDeclinations;
    
    public DeclinationManager() {
        this.materialDeclinations = new HashMap<>();
    }
    
    public static DeclinationManager getInstance() {
        return DeclinationManager.instance;
    }
    
    public void setDeclination(Material material, Declination declination) {
        this.materialDeclinations.put(material, declination);
    }
    
    public Declination getDeclination(Material material) {
        Declination declination = this.materialDeclinations.get(material);
        
        if(declination == null) {
            String name = material.toString();
            declination = new Declination(name, name, name, name, name, name, name);
        }
        
        return declination;
    }

    public String getPossesiveCountDeclination(int count, Declination singular, Declination plural) {
        int absCount = Math.abs(count);
        
        if(absCount == 1)
            return singular.getBiernik();
        
        int absMod100 = absCount % 100;
        if(absMod100 >= 10 && absMod100 <= 20)
            return plural.getDopelniacz();
        
        int absMod10 = absCount % 10;
        if(absMod10 >= 2 && absMod10 <= 4)
            return plural.getBiernik();
        
        return plural.getDopelniacz();
    }
}
