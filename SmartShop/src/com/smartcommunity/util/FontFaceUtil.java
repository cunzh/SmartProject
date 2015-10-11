package com.smartcommunity.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FontFaceUtil {
public static void main(String[] args) {
	String FileName="e:/typeface.css";
	File file = null;
	BufferedReader br = null;
	StringBuffer buffer = null;
	StringBuilder preData = new StringBuilder();
	//参数
	String fonttype="all";
	String typeface="Microsoft YaHei,YouYuan, FangSong , Tahoma, Helvetica, Arial, '\5b8b\4f53' , sans-serif";
	String color="helloword";
	String size="16px";
	String style="normal";
	String weight="normal";
	String decoration="none";
  try{
   file = new File(FileName);
   buffer = new StringBuffer();
   InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"utf-8");
   br = new BufferedReader(isr); 
   int s;
   while((s = br.read())!=-1){
    buffer.append((char)s);
   }
   preData.append(buffer);
   if(fonttype=="all")
	 changeAllContent(preData,typeface,style,weight,decoration,size,color);
   else
	 changeContent(preData,fonttype,typeface,style,weight,decoration,size,color);
   BufferedWriter output = new BufferedWriter(new FileWriter(file));
   output.write(preData.toString());
   output.close();
  }catch(Exception e){
   e.printStackTrace();
  }
}

	public static void changeContent(StringBuilder str,String fonttype,String typeface,String style,String weight,
			String decoration,String size,String color){
		if(fonttype!=""&&fonttype!=null)
		{
			Pattern p = Pattern.compile(fonttype+"\\s*\\{([^\\]]+?)\\}"); 
			Matcher m = p.matcher(str);
			m.find();
			String temp = m.group();
			if(typeface!=""&&typeface!=null)
			temp = temp.replaceAll("font-family"+":[\\s\\S]+?;", "font-family"+":"+typeface+";");
			if(style!=""&&style!=null)
			temp = temp.replaceAll("font-style"+":[\\s\\S]+?;", "font-style"+":"+style+";");
			if(weight!=""&&weight!=null)
			temp = temp.replaceAll("font-weight"+":[\\s\\S]+?;", "font-weight"+":"+weight+";");
			if(decoration!=""&&decoration!=null)
			temp = temp.replaceAll("text-decoration"+":[\\s\\S]+?;", "text-decoration"+":"+decoration+";");
			if(size!=""&&size!=null)
			temp = temp.replaceAll("font-size"+":[\\s\\S]+?;", "font-size"+":"+size+";");
			if(color!=""&&color!=null)
			temp = temp.replaceAll("color"+":[\\s\\S]+?;", "color"+":"+color+";");
			str.replace(str.indexOf(fonttype),1+str.indexOf("}", str.indexOf(fonttype+"{")),temp);
		}
	}
	public static void changeAllContent(StringBuilder str,String typeface,String style,String weight,
			String decoration,String size,String color){
		String temp = str.toString();
		if(typeface!=""&&typeface!=null)
		temp = temp.replaceAll("font-family"+":[\\s\\S]+?;", "font-family"+":"+typeface+";");
		if(style!=""&&style!=null)
		temp = temp.replaceAll("font-style"+":[\\s\\S]+?;", "font-style"+":"+style+";");
		if(weight!=""&&weight!=null)
		temp = temp.replaceAll("font-weight"+":[\\s\\S]+?;", "font-weight"+":"+weight+";");
		if(decoration!=""&&decoration!=null)
		temp = temp.replaceAll("text-decoration"+":[\\s\\S]+?;", "text-decoration"+":"+decoration+";");
		if(size!=""&&size!=null)
		temp = temp.replaceAll("font-size"+":[\\s\\S]+?;", "font-size"+":"+size+";");
		if(color!=""&&color!=null)
		temp = temp.replaceAll("color"+":[\\s\\S]+?;", "color"+":"+color+";");
		str.replace(0,str.length(),"");
		str.append(temp);
		}
	}