package com.dodou.liwh.qrcode.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.validation.Path;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.HashMap;

/**
 * @author: Lwh
 * @ClassName: QrServiceImpl
 * @Description:
 * @Version: V1.0.0
 * @Date: 2018/10/23 17:20
 */
public class QrServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(QrServiceImpl.class);

    public static void main(String[] args) {
        String s = create("aaaaaa....VOM..com////:..sdfsfafddfafd..哈啊发放的", 300, 300);
        System.out.println(s);
        res(s);
    }

    public static String create(String qrData, Integer width, Integer height) {
        String base64;
         final String DATA_PREFIX = "data:image/";
         final String DATA_SUFFIX = ";base64,";
        //1、定义二维码参数
        HashMap hints = new HashMap<>();
        //编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //错误等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //白边距控制
        hints.put(EncodeHintType.MARGIN, 0);
        try {
            //构建二维码实体类
            BitMatrix bitMatrix = new MultiFormatWriter().encode(qrData, BarcodeFormat.QR_CODE, width, height, hints);
            //生成二维码
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", os);
            os.flush();
            //使用toByteArray()方法转换成字节数组
            byte[] imageInByte = os.toByteArray();
            os.close();
//            base64 = DATA_PREFIX + Base64.getEncoder().encodeToString(imageInByte);
            StringBuilder result = new StringBuilder();
            result.append(DATA_PREFIX);
            result.append("png");
            result.append(DATA_SUFFIX);
            result.append(Base64.getEncoder().encodeToString(imageInByte));
            base64 = result.toString();
        } catch (Exception e) {
            throw new RuntimeException("生成二维码错误：" + e.getMessage(), e);
        }
        return base64;
    }


    /*参数未知，不晓得是base64还是图片，请自己实现*/
    public static void res(String imageStr) {
        String base64Str = StringUtils.substringAfterLast(imageStr, ";base64,");
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        byte[] decode = Base64.getDecoder().decode(base64Str);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(decode);
        try {
            BufferedImage read = ImageIO.read(inputStream);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(read)));
            //1、定义二维码参数
            HashMap hints = new HashMap<>();
            //编码
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

            Result result = multiFormatReader.decode(binaryBitmap, hints);
            System.out.println(result.getBarcodeFormat());
            System.out.println(result.getText());
        } catch (Exception e) {

        }

    }
}