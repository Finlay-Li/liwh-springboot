package com.dodou.liwh.qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: ResolveQRCode
 * @Description:
 * @version: 1.0.0
 * @date: 2019-02-27 4:50 PM
 */
public class ResolveQRCode {
    public static void main(String[] args) throws IOException {
        //指定读取文件的路径
        File file = new File("/Users/liwenhui/Documents/QRCode/first.png");
        //读取图片
        BufferedImage bufferedImage = ImageIO.read(file);
        //使用QRCodeDecoder类进行解析二维码图片
        QRCodeDecoder decoder = new QRCodeDecoder();
        //QRCode内部没提供解析实现，它不知道我们的二维码是什么类型的，只提供了接口，自己实现
        ResolveQRCodeHandler resolveQRCodeHandler = new ResolveQRCodeHandler(bufferedImage);
        byte[] decode = decoder.decode(resolveQRCodeHandler);
        //输出内容
        String s = new String(decode, "gb2312");//中文字符集
        System.out.println(s);
    }
}
