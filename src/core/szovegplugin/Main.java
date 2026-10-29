/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin;

import java.util.Map;
/**
 *
 * @author ministar
 */
public class Main {
    
    public static void main(String[] args)
    {
        Map<String, SzovegPlugin> plugins = new PluginBetolto().betolt();
        for(SzovegPlugin p : plugins.values())
        {
            System.out.println(p.nev() + " - " + p.leiras());
        }
    }
}
