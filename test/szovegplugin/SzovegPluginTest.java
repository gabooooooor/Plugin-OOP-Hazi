/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import szovegplugin.plugins.*;
/**
 *
 * @author ministar
 */
public class SzovegPluginTest {
    
    @Test
    public void nagybetuConvertsToUpperCase() {
        assertEquals("HELLO", new NagybetuPlugin().feldolgoz("hello"));
    }

    @Test
    public void szamlalCountsWords() {
        assertEquals("3", new SzamlalPlugin().feldolgoz("one two  three"));
    }

    @Test
    public void ekezettelenRemovesAccents() {
        assertEquals("Arvizturo", new EkezettelenitPlugin().feldolgoz("Árvíztűrő"));
    }

    @Test
    public void palindromDetectsPalindrome() {
        assertEquals("palindrome", new PalindromPlugin().feldolgoz("A man, a plan, a canal: Panama"));
    }

    @Test
    public void caesarShiftsByThree() {
        assertEquals("Khoor", new CaesarPlugin().feldolgoz("Hello"));
    }

    @Test
    public void chainRunsPluginsInOrder() {
        Lanc chain = new Lanc(Arrays.asList(new EkezettelenitPlugin(), new NagybetuPlugin()));
        assertEquals("ARVIZTURO", chain.feldolgoz("Árvíztűrő"));
    }

    @Test
    public void chainSkipsFailingPlugin() {
        Lanc chain = new Lanc(Arrays.asList(new NagybetuPlugin(), new HibasPlugin(), new SzamlalPlugin()));
        assertEquals("2", chain.feldolgoz("a b"));
    }

    @Test
    public void loaderFindsAllFivePlugins() {
        Map<String, SzovegPlugin> plugins = new PluginBetolto().betolt();
        assertEquals(5, plugins.size());
        assertTrue(plugins.containsKey("caesar"));
    }
}
