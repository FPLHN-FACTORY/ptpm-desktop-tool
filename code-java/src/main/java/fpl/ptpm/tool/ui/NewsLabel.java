/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpl.ptpm.tool.ui;

import fpl.ptpm.tool.model.News;
import fpl.ptpm.utility.HyperlinkOpener;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Phong
 */
public class NewsLabel extends JLabel {

    public NewsLabel(News news) {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>")
                .append("[").append(news.getDate()).append("]")
                .append(" ")
                .append(news.getStartTime()).append(" - ").append(news.getEndTime())
                .append(" ")
                .append(news.getName())
                .append("</html>")
                ;

        String content = builder.toString();

        this.setText(content);
        this.setFont(CommonUI.FONT_NEWS_CONTENT);
        
        this.setToolTipText(news.getLink());
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HyperlinkOpener.open(news.getLink());
            }
        });

    }
}
