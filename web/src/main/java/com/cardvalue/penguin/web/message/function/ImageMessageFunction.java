package com.cardvalue.penguin.web.message.function;


import com.cardvalue.penguin.dto.WeChatMessage;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

@Component("ImageMessageFunction")
public class ImageMessageFunction {

	public String queryCreditLineByMid(WeChatMessage message){
		try {
			//将用户发送的图片保存到本地
			URL url = new URL(message.getPicUrl());
			File outFile = new File("c:\\"+message.getMediaId()+".jpg");
			OutputStream os = new FileOutputStream(outFile);
			InputStream is = url.openStream();
			byte[] buff = new byte[1024];
			while (true) {
			    int readed = is.read(buff);
			    if (readed == -1) {
			        break;
			    }
			    byte[] temp = new byte[readed];
			    System.arraycopy(buff, 0, temp, 0, readed);
			    os.write(temp);
			}
			is.close();
			os.close();
			return message.getMediaId()+".jpg";
		} catch (Exception e) {
			return null;
		}
	}
	
}
