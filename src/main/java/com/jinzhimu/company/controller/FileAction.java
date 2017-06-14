package com.jinzhimu.company.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinzhimu.company.params.GlobalParams;
import com.jinzhimu.company.util.DebugLog;
import com.jinzhimu.company.util.FileUtil;

@RestController
@RequestMapping("file")
public class FileAction {
	private final static Logger logger = Logger.getLogger(FileAction.class);
	private final static String ENCODING = "utf-8";

	static{

	}

	@RequestMapping("imgUpload")
	public void imageUpload(HttpServletRequest request,HttpServletResponse response){
		//创建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置缓冲区的大小
		factory.setSizeThreshold(1024*1024*1024*5);
		String result = "";
		//本地服务器真实路径
		String imgPath = request.getSession().getServletContext().getRealPath(File.separator+"extimg");
		//上传时生成的临时文件保存目录
		String tempPath = request.getSession().getServletContext().getRealPath(File.separator+"temp");
		//设置上传文件临时文件的保存路径
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			//创建临时目录
			tmpFile.mkdir();
		}
		factory.setRepository(tmpFile);
		try {
			//创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setProgressListener(new ProgressListener() {
				@Override
				public void update(long pBytesRead, long pContentLength, int arg2) {
					DebugLog.logger.info("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
				}
			});
			//设置编码格式 
			upload.setHeaderEncoding(ENCODING);
			//判断是否是表单提交
			if(!ServletFileUpload.isMultipartContent(request)){
				DebugLog.logger.info("不正确的文件格式");
				//				result = GsonUtil.objectToString(new ImagePath("-1", "不正确的文件格式"));
				result = "error|不支持的类型";
				response.getOutputStream().write(result.getBytes(ENCODING));
				return;
			}
			//设置图片最大限制
			upload.setFileSizeMax(1024*1024*1024);
			//使用解析器对上传的文件进行解析
			Part part = request.getPart("imageUploadName");// myFileName是文件域的name属性值
			// 文件类型限制
			String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
			boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
			if (!allowed) {
				response.getWriter().write("error|不支持的类型");
				return;
			}
			// 图片大小限制
			if (part.getSize() > 5 * 1024 * 1024) {
				response.getWriter().write("error|图片大小不能超过5M");
				return;
			}
			// 包含原始文件名的字符串
			String fi = part.getHeader("content-disposition");
			// 提取文件拓展名
			String fileExtName = fi.substring(fi.indexOf(".")+1, fi.length() - 1);
			DebugLog.logger.debug("上传的文件的扩展名是："+fileExtName);
			boolean allowCount = false;
			//获取item上传的输入流
			//获取唯一名，随机生成
			String saveFileName= FileUtil.makeFileName(fileExtName);
			//根据文件名记性hash生成文件夹
			String filePath = FileUtil.makePath(saveFileName, "");
			String realFilePath = imgPath + filePath;
			//用于url生成
			String otherFilePath = request.getContextPath() + File.separator + "extimg" + filePath;
			//创建文件夹
			File filePathFile = new File(realFilePath);
			if (!filePathFile.exists()) {
				filePathFile.mkdirs();
			}
			//创建文件
			File file = new File(filePathFile,saveFileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			DebugLog.logger.debug("本地创建的文件路径："+file.getAbsolutePath());
			part.write(file.getPath());
			//						otherFilePath = "http://" + Utility.getIP() + GlobalParams.SERVER_URL + otherFilePath + File.separator + saveFileName;
			otherFilePath = request.getContextPath() + otherFilePath + File.separator + saveFileName;
			otherFilePath =  otherFilePath.replace('\\', '/');
			DebugLog.logger.debug("生成的图片url为:"+otherFilePath);
			result = otherFilePath;
			//				result = GsonUtil.objectToString(new ImagePath(imageLists));
			response.getOutputStream().write(result.getBytes(ENCODING));
		} catch (UnsupportedEncodingException e) {
			DebugLog.logger.error("不支持的编码格式", e);
		} catch (IOException e) {
			DebugLog.logger.error("文件读写失败", e);
		} catch (Exception e) {
			DebugLog.logger.error("文件上传未知异常", e);
		}finally{
		}
	}
}
