package com.bit.sts09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	@ResponseBody
	public void upload(@RequestParam("sabun") int sabun, MultipartFile file1) {
		logger.info("sabun="+sabun);
		logger.info("file:"+file1.getOriginalFilename());
		String path="C:\\Jworkspace\\sts2020-02\\upload\\";
		File file=null;
		file = new File(path+file1.getOriginalFilename());
		InputStream is= null;
		OutputStream os=null;
		try {
			is=file1.getInputStream();
			os=new FileOutputStream(file);
			int su=-1;
			while((su=is.read())!=-1) {
				os.write(su);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(is!=null)is.close();
					if(os!=null)os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
