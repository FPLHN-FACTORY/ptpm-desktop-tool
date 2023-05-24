/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpl.ptpm.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Phong
 */
public final class JsonHelper {
    
    public static JsonNode get(URL url) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(url);
        } catch (IOException ex) {
            return null;
        }
    }
    
    public static <T> T get(URL url, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(url, type);
        } catch (IOException ex) {
            return null;
        }
    }
}
