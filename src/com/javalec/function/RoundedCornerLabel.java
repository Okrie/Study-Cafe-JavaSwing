package com.javalec.function;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;


// 사용방법
//RoundedCornerLabel label = new RoundedCornerLabel("내부 텍스트", 20);

public class RoundedCornerLabel extends JLabel {

    private int cornerRadius;

    public RoundedCornerLabel(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
        super.paintComponent(g2);
        g2.dispose();
    }
}
