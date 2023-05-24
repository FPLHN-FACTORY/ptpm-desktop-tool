/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpl.ptpm.tool.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import fpl.ptpm.common.CommonLink;
import fpl.ptpm.tool.model.News;
import java.net.URL;

/**
 *
 * @author Phong
 */
public class NewsReader {
    
    public News[] getAll() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL(CommonLink.LINK_NEWS);
            News[] news = mapper.readValue(url, News[].class);
            return news;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
