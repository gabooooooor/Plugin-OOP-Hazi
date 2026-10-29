/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin;

import java.util.Map;
import java.util.ServiceLoader;
import java.util.TreeMap;
/**
 *
 * Discovers plugins with ServiceLoader. The core never uses "new" on a concrete plugin.
 */
public class PluginBetolto {
    
    public Map<String, SzovegPlugin> betolt()
    {
        Map<String, SzovegPlugin> plugins = new TreeMap<>();
        ServiceLoader<SzovegPlugin> loader = ServiceLoader.load(SzovegPlugin.class);
        for(SzovegPlugin p : loader)
        {
            plugins.put(p.nev(), p);
        }
        return plugins;
    }
}
