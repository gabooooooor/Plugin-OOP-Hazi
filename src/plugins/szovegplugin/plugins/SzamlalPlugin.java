/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin.plugins;

import szovegplugin.SzovegPlugin;
/**
 *
 * @author ministar
 */
public class SzamlalPlugin implements SzovegPlugin{
    
    @Override
    public String nev()
    {
        return "szamlal";
    }
    
    @Override
    public String leiras()
    {
        return "Counts the number of the words";
    }
    
    @Override
    public String feldolgoz(String bemenet)
    {
        String trimmed = bemenet.trim();
        int count = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
        return String.valueOf(count);
    }
}
