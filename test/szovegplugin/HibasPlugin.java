/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin;

/**
 *
 * Test plugin that always fails, to check that the chain survives
 */
public class HibasPlugin implements SzovegPlugin{
    
    @Override
    public String nev()
    {
        return "hibas";
    }
    
    @Override
    public String leiras()
    {
        return "Always throws an exception (for testing)";
    }
    
    @Override
    public String feldolgoz(String bemenet)
    {
        throw new IllegalStateException("intentional failure");
    }
}
