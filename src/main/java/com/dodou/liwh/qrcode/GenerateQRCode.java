package com.dodou.liwh.qrcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author: Lwh
 * @ClassName: CreateQRCode
 * @Description: 原理：依靠java gui的画图工具，如以前的坦克大战
 * @version: 1.0.0
 * @date: 2019-02-27 3:58 PM
 */
public class GenerateQRCode {
    public static void main(String[] args) throws IOException {

//        Integer width = 67 + 12 * (7 - 1);//这个7是版本号！并且一定要定义好再传进去，否则达不到预期效果
//        Integer height = 67 + 12 * (7 - 1);//而且，宽高，67，否则这个公式就没用了，估计其他的宽高公式要自己去找咯
        String qrData = "哈喽QRCode.。。。。com...xin..cn....aaaaaaa...nnvnvnvnvn...aaa/////////saaa"; //二维码内容
        Integer width = 362;
        Integer height = 362;
        Qrcode x = new Qrcode();//核心二维码类，设置二维码属性
        x.setQrcodeErrorCorrect('M');//错误纠正等级
        x.setQrcodeEncodeMode('B');//N 代表数字,A代表a-Z,B代表其他字符，如汉字
        x.setQrcodeVersion(7);//版本，共1-40个版本

        //定义缓冲区
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//默认就是RGB；颜色
        //使用java gui的画图工具
        Graphics2D graphics = bufferedImage.createGraphics();
        //设置画板
        graphics.setBackground(Color.WHITE);
        graphics.setColor(Color.BLACK);
        //清理多余的部分，比如空白部分
        graphics.clearRect(0, 0, width, height);

//        byte[] d = qrData.getBytes(); 如果有汉字的话，要gb2312 类型
        byte[] d = qrData.getBytes("gb2312");

        //定义偏移量，这个必须要，否则可能生成，解析都会出错；还记得RSA不！
        Integer offLen = 1;
        // 限制最大字节数为119
        if (d.length > 0 && d.length < 120) {
            boolean[][] s = x.calQrcode(d);//计算内容，并填充进 s 二维数组

            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        //
                        graphics.fillRect(j * 8 + offLen, i * 8 + offLen, 8, 8);
//                        graphics.fillRect(j * 2, i * 2, 2, 2);
                    }
                }
            }
        }

        //关闭
        graphics.dispose();
        bufferedImage.flush();

        //输出：要指定文件名哦
        ImageIO.write(bufferedImage, "png", new File("/Users/liwenhui/Documents/QRCode/first.png"));
//        ImageIO.write(bufferedImage, "png", new File("/Users/liwenhui/Documents/QRCode/second.png"));
    }
}
