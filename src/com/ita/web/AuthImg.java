package com.ita.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*; 

/**
 * Description:
 * <br/>嚙踝蕭桴: <a href="http://www.crazyit.org">嚙踝蕭嚙皚ava嚙踝蕭嚙踝蕭</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@WebServlet(urlPatterns={"/WEB-INF/content/authImg.jsp"})
public class AuthImg
	extends HttpServlet
{
	//嚙踝蕭嚙踝蕭芞嚙踝蕭嚙踝蕭痐嚙踝蕭嚙請鳴蕭嚙踝蕭嚙誰瘀蕭嚙踝蕭嚙踝蕭嚙?
	private final Font mFont =
		new Font("Arial Black", Font.PLAIN, 16);
	//嚙踝蕭嚙踝蕭芞嚙踝蕭嚙踝蕭痐嚙踝蕭譬嚙請?
	private final int IMG_WIDTH = 100;
	private final int IMG_HEIGTH = 18;
	//嚙踝蕭嚙踝蕭珨嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙褕恬蕭譟嚙踝蕭嚙?
	private Color getRandColor(int fc,int bc)
	{
		Random random = new Random();
		if(fc > 255) fc = 255;
		if(bc > 255) bc=255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		//嚙衛蛛蕭嚙踝蕭嚙踝蕭嚙褕?
		return new Color(r , g , b);
	}
	//嚙踝蕭迡service嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭伅埥芼嚙踝蕭佽嚙踝蕭嚙諉?
	public void service(HttpServletRequest request,
		HttpServletResponse response) 
		throws ServletException, IOException
	{
		//嚙踝蕭嚙衛踝蕭砦嚙踝蕭嚙踝蕭
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage
			(IMG_WIDTH , IMG_HEIGTH , BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200 , 250));
		//嚙踝蕭銆喉蕭嚙褕?
		g.fillRect(1, 1, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		//峈芞嚙踝蕭嚙踝蕭痐嚙踝蕭嚙踝蕭萷嚙?
		g.setColor(new Color(102 , 102 , 102));
		g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGTH - 1);
		g.setColor(getRandColor(160,200));
		//嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙?
		for (int i = 0 ; i < 80 ; i++)
		{
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g.drawLine(x , y , x + xl , y + yl);
		}
		g.setColor(getRandColor(160,200));
		//嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙?
		for (int i = 0 ; i < 80 ; i++)
		{
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGTH - 1);
			int xl = random.nextInt(12) + 1;
			int yl = random.nextInt(6) + 1;
			g.drawLine(x , y , x - xl , y - yl);
		}
		//嚙踝蕭嚙衛鳴蕭嚙踝蕭嚙誰瘀蕭嚙踝蕭嚙踝蕭嚙?
		g.setFont(mFont);
		//嚙踝蕭嚙誹梧蕭嚙踝蕭炵苀嚙踝蕭伂嚙踝蕭嚙踝蕭嚙誰瘀蕭
		String sRand = "";
		for (int i = 0 ; i < 6 ; i++)
		{
			String tmp = getRandomChar();
			sRand += tmp;
			//嚙踝蕭嚙踝蕭嚙踝蕭嚙褕?
			g.setColor(new Color(20 + random.nextInt(110)
				,20 + random.nextInt(110)
				,20 + random.nextInt(110)));
			//嚙踝蕭芞嚙誕鳴蕭嚙踝蕭炵苀嚙踝蕭伂嚙踝蕭嚙踝蕭嚙誰瘀蕭
			g.drawString(tmp , 15 * i + 10,15);
		}
		//嚙踝蕭HttpSesssion嚙踝蕭嚙踝蕭
		HttpSession session = request.getSession(true);
		//嚙踝蕭嚙踝蕭嚙踝蕭硊嚙踝蕭嚙踝蕭HttpSesssion嚙踝蕭嚙踝蕭嚙踝蕭 
		session.setAttribute("rand" , sRand);
		g.dispose();
		//嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭芞
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	//嚙踝蕭嚙踝蕭嚙褓∴蕭嚙踝蕭嚙誰瘀蕭嚙踝蕭
	private String getRandomChar()
	{
		//嚙踝蕭嚙課鳴蕭嚙?嚙踝蕭1嚙踝蕭2嚙踝蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙?
		int rand = (int)Math.round(Math.random() * 2);
		long itmp = 0;
		char ctmp = '\u0000';
		switch (rand)
		{
			//嚙踝蕭伝嚙請湛蕭嚙衝?
			case 1:
				itmp = Math.round(Math.random() * 25 + 65);
				ctmp = (char)itmp;
				return String.valueOf(ctmp);
			//嚙踝蕭嚙請－湛蕭嚙衝?
			case 2:
				itmp = Math.round(Math.random() * 25 + 97);
				ctmp = (char)itmp;
				return String.valueOf(ctmp);
			//嚙踝蕭嚙踝蕭嚙踝蕭嚙?
			default :
				itmp = Math.round(Math.random() * 9);
				return  itmp + "";
		}
	}
}