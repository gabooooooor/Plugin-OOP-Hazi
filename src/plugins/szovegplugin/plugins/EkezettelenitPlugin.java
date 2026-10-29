/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin.plugins;

import java.text.Normalizer;
import szovegplugin.SzovegPlugin;
/**
 *
 * @author ministar
 */
public class EkezettelenitPlugin implements SzovegPlugin{
    
    @Override
    public String nev()
    {
        return "ekezettelen";
    }
    
    @Override
    public String leiras()
    {
        return "Removes accents from the text";
    }
    
    @Override
    public String feldolgoz(String bemenet)
    {
        String normalized = Normalizer.normalize(bemenet, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }
}
