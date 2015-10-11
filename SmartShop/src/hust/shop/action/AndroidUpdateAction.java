package hust.shop.action;

import hust.shop.pojo.Image;
import hust.shop.pojo.ProductPropertyValue;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.InputStreamUtil;
import com.smartcommunity.util.JSONUtil;
import com.smartcommunity.util.PathUtil;
import com.smartcommunity.util.UTIL;

public class AndroidUpdateAction extends BaseActionSupport<AndroidUpdteParams> {
	
	 private String    contentType;
	 private String filename;
	 private Integer contentLength;
	
	public String checkUpdate() {
		String version = parameters.getVersion();
		try {
			getLatestVersion();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/** 获取当前版本 */
	public String getLatestVersion() throws DocumentException {
		  String realpath = org.apache.struts2.ServletActionContext.
					getServletContext().getRealPath(UTIL.ANDROID_VERSION_PATH);

		 SAXReader sr = new SAXReader();
		  Document doc = sr.read(realpath);
		  
		  Element root = doc.getRootElement();
		 java.util.List<Element> elements=  root.elements();
		 // Attribute attribute = root.elementByID(UTIL.ANDROID_VERSION_VERSION).attribute(UTIL.ANDROID_VERSION_VALUE);
		 // System.out.println(attribute);
		 String latestVersion = null;
		 java.util.List<String> features = new java.util.ArrayList<>();
		  for (Element element : elements) {
			  if (element.getName().equals(UTIL.ANDROID_VERSION_VERSION)) {
				
			  Attribute attribute = element.attribute(UTIL.ANDROID_VERSION_VALUE);
				  latestVersion = attribute.getValue();
			  
			  }
			  if (element.getName().equals("feature")) {
				  Attribute attribute = element.attribute(UTIL.ANDROID_VERSION_VALUE);

				  features.add(attribute.getValue());
				  }

		  }
		  
		  JSONObject jsonObject = null;
		  if (latestVersion == null) {
			   jsonObject = JSONUtil.getJsonObject(false);
			  JSONUtil.putCause(jsonObject, "没有要查询的版本号");
		  } else {
			  jsonObject = JSONUtil.getJsonObject(true);
			  jsonObject.put(UTIL.ANDROID_VERSION_VERSION, latestVersion);
			  jsonObject.put("features", features);
		  }
		inputStream = InputStreamUtil.getInputStream(jsonObject);

		return SUCCESS;
	}
	 public Document getFeaturesXml(String version, java.util.List<String> features)
	 {
		  Document doc = DocumentHelper.createDocument();
		  doc.addProcessingInstruction("xml-stylesheet", "type='text/xsl href='features.xsl'"); 
		  Element root = doc.addElement("update");
		  root.addElement("version").addAttribute("value", version);
		  int i =1;
		  System.out.print(features);
		  for (String feature : features) {
			  root.addElement("feature").addAttribute("value", "" + (i ++) + " " + feature);
		  }
		  return doc;
		 
	 }
	 /** 下载 最新版本的 android 客户端 */
	 public String download() throws Exception {
	
		 String downloadPath = UTIL.ANDROID_DOWNLOAD_PATH;
		  filename= downloadPath.substring(downloadPath.lastIndexOf('/') +1); //保存文件时的名称
		     contentType="application/octet-stream";//强制下载
		     String realPath = ServletActionContext.getServletContext().getRealPath(downloadPath);
		     java.io.File file = new java.io.File(realPath);
		     contentLength = (int) file.length();
		     super.setInputStream(ServletActionContext.getServletContext().getResourceAsStream(downloadPath));
		     return SUCCESS;
		 }
	 public String upload() throws IOException, DocumentException {

			File updateApkFile = parameters.getFile();
//			if (updateApkFile == null) {
//				return setJSONObject(JSONUtil.getFalseJsonObject("没有要上传的文件 "));
//			}
		String path = PathUtil.getAbsPath(PathUtil.getApkPath());
		File apkFile = new File(path + "/latest.apk");
		File updateFile = new File(path + "/update.xml");
		String versionNumber = getVerionNumber();
		apkFile.renameTo(new File(PathUtil.getAbsPath(PathUtil.getApkLogPath()+"/" + versionNumber + ".apk")));
		File updateLogFile = new File(PathUtil.getAbsPath(PathUtil.getApkLogPath()+"/" + versionNumber + ".xml"));
		if (updateLogFile.exists()) {
			updateLogFile.delete();
		}
		updateFile.renameTo(updateLogFile);
		// 更新 apk 文件
		apkFile.createNewFile();
		java.nio.channels.FileChannel inChannel = new java.io.FileInputStream(updateApkFile).getChannel();
		java.nio.channels.FileChannel outChannel = new java.io.FileOutputStream(apkFile).getChannel();
		inChannel.transferTo(0, inChannel.size(), outChannel);
		inChannel.close();
		outChannel.close();
		
		updateFile.delete();
		Document document = getFeaturesXml(parameters.getVersion(), parameters.getFeatures());
			  OutputFormat format = new OutputFormat("\t", true);
			  format.setEncoding("utf-8");   
			  // 可以把System.out改为你要的流。
			  XMLWriter xmlWriter = new XMLWriter(new PrintWriter(new PrintStream(new File(updateFile.getAbsolutePath()))), format);   
			  xmlWriter.write(document);  
			  xmlWriter.close();  
		
		return setJSONObject(JSONUtil.getJsonObject(true));
//				/** 插入图片 */
//				if (images != null && imagesContentType != null
//						&& imagesFileName != null) {
//					Image image = new Image();
//					for (int i = 0; i < images.size(); i++) {
//						String imagename = productId + imagesFileName.get(i); // 图片的文件名
//						String imagepath = PathUtil.getProductPath(product.getName()); // 图片保存路径
//						String realpath = org.apache.struts2.ServletActionContext
//								.getServletContext().getRealPath(imagepath);
//						System.out.println(realpath);
//						/** 插入图片地址到数据库 */
//						image.setProductId(productId);
//						image.setUrl(imagepath + imagename);
//
//
//						int imageCount = imageMapper.insertSelective(image);// 插入数据库
//
//						if (imageCount > 0) {
//							System.out.println("图片写入数据库成功!");
//							/** 保存图片到本地 */
//							File saveFile = new File(new File(realpath), imagename);
//							if (!saveFile.getParentFile().exists())
//								saveFile.getParentFile().mkdirs();
//							try {
//								org.apache.commons.io.FileUtils.copyFile(
//										images.get(i), saveFile);
//								System.out.println("图片保存成功!地址为 "+saveFile.getAbsolutePath());
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								throw new RuntimeException("保存文件 "
//										+ saveFile.getPath() + "/"
//										+ saveFile.getName() + " 失败 : "
//										+ e.getMessage());
//							}
//						}
//					}
//				}
//				return JSONUtil.getJsonObject(true);
//			}
//			return null;
	 
	 }
	private String getVerionNumber() throws DocumentException  {
		  String realpath = org.apache.struts2.ServletActionContext.
					getServletContext().getRealPath(UTIL.ANDROID_VERSION_PATH);

		 SAXReader sr = new SAXReader();
		  Document doc = null;
			doc = sr.read(realpath);
		  
		  Element root = doc.getRootElement();
		 java.util.List<Element> elements=  root.elements();
		 // Attribute attribute = root.elementByID(UTIL.ANDROID_VERSION_VERSION).attribute(UTIL.ANDROID_VERSION_VALUE);
		 // System.out.println(attribute);
		 String latestVersion = "0.0.0";
		 java.util.List<String> features = new java.util.ArrayList<>();
		  for (Element element : elements) {
			  if (element.getName().equals(UTIL.ANDROID_VERSION_VERSION)) {
				
			  Attribute attribute = element.attribute(UTIL.ANDROID_VERSION_VALUE);
				 latestVersion = attribute.getValue();
			  break;
			  }
		  }
		  return latestVersion;


	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getContentLength() {
		return contentLength;
	}
	public void setContentLength(Integer contentLength) {
		this.contentLength = contentLength;
	}

}
