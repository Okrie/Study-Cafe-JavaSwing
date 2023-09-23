package com.javalec.function;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

// 사용방법
//	ImageResize image = new ImageResize(900, 500, "1");
//	lbl.setIcon(image.resizeImage());

public class ImageResize {
	BufferedImage img;
	Image resizedImg;
	ImageIcon icon;
	int widthSize;
	int HeightSize;
	String fileName;
	
	public ImageResize() {
		// TODO Auto-generated constructor stub
	}
	
	public ImageResize(int widthSize, int heightSize, String fileName) {
		super();
		this.widthSize = widthSize;
		HeightSize = heightSize;
		this.fileName = fileName;
	}

	public ImageIcon resizeImage() {
		try {
			img = ImageIO.read(getClass().getResource("/com/javalec/images/" + fileName));
			resizedImg = img.getScaledInstance(widthSize, HeightSize, Image.SCALE_SMOOTH);
			icon = new ImageIcon(resizedImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return icon;
	}
}
