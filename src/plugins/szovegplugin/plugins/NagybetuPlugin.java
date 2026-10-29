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
public class NagybetuPlugin implements SzovegPlugin{
    
    @Override
    public String nev()
    {
        return "nagybetu";
    }
    
    @Override
    public String leiras()
    {
        return "Converts the text to upper case";
    }
    
    @Override
    public String feldolgoz(String bemenet)
    {
        return bemenet.toUpperCase();
    }
}
