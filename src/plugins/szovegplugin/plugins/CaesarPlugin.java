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
public class CaesarPlugin implements SzovegPlugin{
    
    @Override
    public String nev()
    {
        return "caesar";
    }
    
    @Override
    public String leiras()
    {
        return "Shifts the letters by 3 positions (Caesar cipher)";
    }
    
    @Override
    public String feldolgoz(String bemenet)
    {
        StringBuilder sb = new StringBuilder();
        for(char c : bemenet.toCharArray())
        {
            if(c >= 'a' && c <= 'z')
            {
                sb.append((char) ('a' + (c - 'a' + 3) % 26));
            }
            else if(c >= 'A' && c <= 'Z')
            {
                sb.append((char) ('A' + (c - 'A' + 3) % 26));
            }
            else 
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
