package com.fileprocess;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {


		int cardsPage = 16;
		int totalPages = 42;
		
		int heightCard = 512;
		int widthCard = 388;
		
		int controlX = 72;
		int controlY = 69;

		
		for(int i = 1; i<=totalPages; i++) {

			String input = "./workfiles/" + String.format("%02d" , i) + ".jpg";
			System.out.println("INPUT FILE:::" + input);
			final BufferedImage source = ImageIO.read(new File(input));
			int cardNumberControl = 1;
			
			for(int y = 1; y <= cardsPage; y++) {
				
				try {
					
					//Dynamic extract cards
					ImageIO.write(source.getSubimage(controlX, controlY, widthCard, heightCard), "JPG", new File("./workfiles/output/" +"AAA"+i+"_"+cardNumberControl+".jpg"));
					
					controlX += 389;
					
					if(y == 4 || y == 8 || y == 12) {
						System.out.println("extracting stickers page "+ i +".jpg...");
						controlY += 517;
						controlX = 72;
					}
					
				} catch (Exception e) {
					
					System.out.println("ERRO::: " + e.getMessage());
				}
				
				cardNumberControl++;
			}
			
			controlX = 71;
			controlY = 69;
		}
	}
}
