/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * Runs plugins in order. A failing plugin is logged and skipped
 */
public class Lanc implements SzovegPlugin{
    
    private final List<SzovegPlugin> plugins = new ArrayList<>();
    
    public Lanc(List<SzovegPlugin> plugins)
    {
        this.plugins.addAll(plugins);
    }
    
    @Override
    public String nev()
    {
        return "lanc";
    }
    
    @Override
    public String leiras()
    {
        return "Runs the given plugins in order; a failing plugin is skipped";
    }
    
    @Override
    public String feldolgoz(String bemenet)
    {
        String current = bemenet;
        for(SzovegPlugin p : plugins)
        {
            try
            {
                if(!p.tamogatja(current))
                {
                    System.err.println("Skipped " + p.nev() + ": input not supported");
                    continue;
                }
                current = p.feldolgoz(current);
            }
            catch(Exception e)
            {
                System.err.println("Plugin " + p.nev() + " failed and was skipped: " + e);
            }
        }
        return current;
    }
}
