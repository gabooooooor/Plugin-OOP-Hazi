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
public class PalindromPlugin implements SzovegPlugin{
    
    @Override
    public String nev()
    {
        return "palindrom";
    }
    
    @Override
    public String leiras()
    {
        return "Checks whether the text is a palindrome";
    }
    
    @Override
    public String feldolgoz(String bemenet)
    {
        String clean = bemenet.replaceAll("[^\\p{L}\\p{N}]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed) ? "palindrome" : "not a palindrome";
    }
}
