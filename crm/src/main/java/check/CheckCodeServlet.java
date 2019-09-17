package check;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/img")
public class CheckCodeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//step1　创建一个图片,创建一个内存映像对象
		BufferedImage image = new BufferedImage(60,20,BufferedImage.TYPE_INT_RGB);
		//得到画笔
		Graphics g = image.getGraphics();
		Random r = new Random();
		//设置画笔的颜色
		g.setColor(Color.white);
		//设置整个画板的背景颜色
		g.fillRect(0,0, 60, 20);
		//生成一个随机数
		//String number = r.nextInt(99999) + "";
		String number = getNumber(5);
		//将number绑订到session对象上。
		HttpSession session = request.getSession();
		session.setAttribute("number", number);
		g.setColor(new Color(0,0,0));
		g.drawString(number, 5, 15);
		//加一些干扰线
		for(int i=0;i<5;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(60),r.nextInt(20),r.nextInt(60),r.nextInt(20));
		}
		//step2 压缩图片，然后输出
		response.setContentType("image/jpeg");
		OutputStream output = response.getOutputStream();
		javax.imageio.ImageIO.write(image, "jpeg", output);
		
	}
	//随机从"A~Z","0~9"当中取出５个字符
	private String getNumber(int length) {
		Random r = new Random();
		char[] chars = {'A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N','O','P','Q',
				'R','S','T','U','V','W',	'X','Y','Z','0',
				'1','2','3','4','5','6','7','8','9'};
		String number = "";
		for(int i=0;i<length;i++){
			number += chars[r.nextInt(chars.length)];
		}
		return number;
	}
}