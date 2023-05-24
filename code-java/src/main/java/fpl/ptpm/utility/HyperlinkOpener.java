/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpl.ptpm.utility;

import java.awt.Desktop;
import java.net.URL;

/**
 *
 * @author Phong
 */
public class HyperlinkOpener {
    
    public static void open(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception ex) {
            
        }
    }
    
}
