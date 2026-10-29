/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package szovegplugin;

/**
 *
 * A text-processing plugin. The core depends only on this interface.
 */
public interface SzovegPlugin {
    
    String nev();
    
    String leiras();
    
    String feldolgoz(String bemenet);
    
    default boolean tamogatja(String bemenet)
    {
        return bemenet != null;
    }
}
