/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szovegplugin;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author ministar
 */
public class Main {
    
    public static void main(String[] args) throws IOException
    {
        Map<String, SzovegPlugin> plugins = new PluginBetolto().betolt();
        String pluginNames = null;
        String inFile = null;
        String outFile = null;
        
        for(int i=0; i< args.length; i++)
        {
            if(args[i].equals("--list"))
            {
                for(SzovegPlugin p : plugins.values())
                {
                    System.out.println(p.nev() + " - " + p.leiras());
                }
                return;
            }
            else if(args[i].equals("--plugin") && i + 1 < args.length)
            {
                pluginNames = args[++i];
            }
            else if(args[i].equals("--in") && i + 1 < args.length)
            {
                inFile = args[++i];
            }
            else if(args[i].equals("--out") && i + 1 < args.length)
            {
                outFile = args[++i];
            }
        }
        
        if(pluginNames == null)
        {
            System.err.println("Usage: --plugin a,b,c [--in file] [--out file] | --list");
            return;
        }
        
        List<SzovegPlugin> chain = new ArrayList<>();
        for(String name : pluginNames.split(","))
        {
            SzovegPlugin p = plugins.get(name.trim());
            if(p == null)
            {
                System.err.println("Unknown plugin: " + name);
            }
            else
            {
                chain.add(p);
            }
        }
        
        String input;
        if(inFile != null)
        {
            input = new String(Files.readAllBytes(Paths.get(inFile)), StandardCharsets.UTF_8);
        }
        else
        {
            Scanner sc = new Scanner(System.in, "UTF-8").useDelimiter("\\A");
            input = sc.hasNext() ? sc.next() : "";
        }
        
        String result = new Lanc(chain).feldolgoz(input);
        
        if(outFile != null)
        {
            Files.write(Paths.get(outFile), result.getBytes(StandardCharsets.UTF_8));
        }
        else
        {
            System.out.println(result);
        }
    }
}
