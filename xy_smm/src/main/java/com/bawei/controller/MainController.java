package com.bawei.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.entity.Stu;
import com.bawei.service.MainService;
import com.bawei.utils.Page;
import com.bawei.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @author Lenovo  焦某
 *
 */

@Controller
public class MainController {

	@Autowired
	private MainService ms;
	
	@RequestMapping("list")
	public String list(Model m,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="")String name) {
		PageHelper.startPage(pageNum, 2);
		List<Map> list =ms.list();
		PageInfo info=new PageInfo(list);
		String url="&name="+name;
		Page.fenye(m, info, url);
		System.out.println(list);
		m.addAttribute("list", list);
		return "listc";
	}
/*	@RequestMapping("listpic")
	public String listpic(@RequestParam(defaultValue="") String title,Model m,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="")String name) {
		PageHelper.startPage(pageNum, 2);
		List<Map> list =ms.list();
		System.err.println(list);
		PageInfo info=new PageInfo(list);
		String url="&name="+name;
		Page.fenye(m, info, url);
		System.out.println(list);
		m.addAttribute("list", list);
		 m.addAttribute("title", title);
		return "listc2";
	}*/
	
	@RequestMapping("listpic")
	public String listpic(  HttpServletRequest request,Model model ,@RequestParam( defaultValue="1") Integer page,  @RequestParam(defaultValue="") String title) {
		Integer pageSize =3;
	   //分页助手
		 PageHelper.startPage(page, pageSize);
		 List<Map> list = ms.selectList(title);
		 System.err.println(list+"dddddddddddddd>>>>>>>>>>>>>>>>>>>");
		 PageInfo info = new PageInfo<>(list);
		 
		 //调用分页工具类
		PageUtil.page(request, "/listpic?title="+title, pageSize, list, info.getTotal(), page);
		  
		 model.addAttribute("list", list);
		 
		 model.addAttribute("title", title);
		return "listc2";
		
	}

	
	@RequestMapping("toadd")
	 public String toadd(){
		return "add";
		
	}
	@RequestMapping("add")
	@ResponseBody
	 public int add(@RequestParam("file")MultipartFile file, Stu s) throws IllegalStateException, IOException {
		String path="E:/file/";
		
		
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			String newFileName = UUID.randomUUID()+ filename.substring(filename.lastIndexOf("."));
			File file2 = new File(path+newFileName);
			 
			//把文件写入硬盘
			file.transferTo(file2);
			s.setPic(newFileName);
			
			
		}
		int i =ms.add(s);
		return i;
	}
		
	@RequestMapping("updateid")
	public String updateid(int id,Model m) {
		System.err.println(id);
		Stu s =ms.updateid(id);
		System.out.println(s);
		m.addAttribute("s", s);
		return "update";
	}
	@RequestMapping("update")
	@ResponseBody
	public int update(Stu s) {
		int i =ms.update(s);
		return i;
	}
	
	@RequestMapping("delid")
	public String update(int id) {
		int i =ms.delid(id);
		if(i>0) {
			
			return "redirect:list";
		}else {
			return "err";
		}
	}
}
