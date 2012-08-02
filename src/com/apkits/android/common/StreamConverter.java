package com.apkits.android.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/**
 * </br><b>name : </b>		StreamConverter
 * </br><b>description :</b>流转换器
 * </br>@author : 			桥下一粒砂
 * </br><b>e-mail : </b>	chenyoca@gmail.com
 * </br><b>weibo : </b>		@桥下一粒砂
 * </br><b>date : </b>		2012-7-8
 *
 */
public class StreamConverter {
	
	/**
	 * </br><b>title : </b>		将InputStream流转换成BitmapDrawable。
	 * </br><b>description :</b>BitmapDrawable是Drawable的直接子类，可用于Drawable对象
	 * @param is InputStream对象
	 * @return BitmapDrawable对象
	 * @throws IOException 
	 */
	public static BitmapDrawable converToBitmapDrawable(InputStream is) throws IOException{
		BitmapDrawable bitmapDrawable = new BitmapDrawable(is);
		is.close();
		return bitmapDrawable;
	}
	
	/**
	 * </br><b>title : </b>		将InputStream流转换成Bitmap对象。
	 * </br><b>description :</b>将InputStream流转换成Bitmap对象。
	 * @param is InputStream对象
	 * @return Bitmap对象
	 * @throws IOException 
	 */
	public static Bitmap convertBitmap(InputStream is) throws IOException{
		return converToBitmapDrawable(is).getBitmap();
	}
	
	/**
	 * </br><b>title : </b>		将InputStream转换成StringBuffer对象
	 * </br><b>description :</b>将InputStream转换成StringBuffer对象。
	 * @param is InputStream对象
	 * @return StringBuffer对象
	 * @throws IOException 
	 */
	public static StringBuffer convertToStringBuffer(InputStream is) throws IOException{
		StringBuffer buffer = new StringBuffer();
		byte[] cache = new byte[ 1 * 1024 ];
		for (int i; (i = is.read(cache)) != -1;) {
			buffer.append(new String(cache, 0, i));
		}
		is.close();
		return buffer;
	}
	
	/**
	 * </br><b>title : </b>		将InputStream转换成String对象
	 * </br><b>description :</b>将InputStream转换成String对象。
	 * @param is InputStream对象
	 * @return String对象。如果读取
	 * @throws IOException 
	 */
	public static String converToString(InputStream is) throws IOException{
		return convertToStringBuffer(is).toString();
	}
	
	/**
	 * </br><b>title : </b>		将InputStream转换成字节数组
	 * </br><b>description :</b>将InputStream转换成字节数组。
	 * @param is InputStream对象
	 * @return 字节数组
	 * @throws IOException 
	 */
	public static byte[] convertToByteArray(InputStream is) throws IOException{
		byte[] cache = new byte[1 * 1024];
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int length = 0;
		while ((length = is.read(cache)) != -1) {
			buffer.write(cache, 0, length);
		}
		is.close();
		return buffer.toByteArray();
	}
}