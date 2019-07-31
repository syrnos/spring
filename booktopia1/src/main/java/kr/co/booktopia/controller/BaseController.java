package kr.co.booktopia.controller;

import java.io.File;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class BaseController {
	
	@RequestMapping("/goods/thumbnail")
	public void thumbnail(String fname, String goods_id, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String imgPath = req.getSession().getServletContext().getRealPath("/")+"/resources/goods";
		
		OutputStream out = resp.getOutputStream();
		String filePath = imgPath + "/" + goods_id + "/" + fname;
		
		File file = new File(filePath);
		
		if(file.exists()) {
			// 썸네일 크기 및 형식 지정
			Thumbnails.of(file).forceSize(121,154).outputFormat("png").toOutputStream(out);
		}
		
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
		
		
	}
	
}
