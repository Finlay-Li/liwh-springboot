package com.dodou.liwh.rsa;


import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author: Lwh
 * @ClassName: RsaDemo
 * @Description:
 * @version: 1.0.0
 * @date: 2019-02-13 4:07 PM
 */
public class RsaDemo {

    private static final Logger logger = LoggerFactory.getLogger(RsaDemo.class);
    private static final String src = "Hello Rsa Demo";

    public static void main(String[] args) {
        jdkRsa();
    }

    public static void jdkRsa() {
        try {
            //1.初始化密钥
            //获取:密钥对生成者
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);//必须是64的整数倍
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            //获取公钥
            PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            //获取私钥
            PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            //Base64：把二进制转换成String
            byte[] publicKeyByte = publicKey.getEncoded();
            String encodePublicKey = Base64.encodeBase64String(publicKeyByte);
            logger.error("encodePublicKey : " + encodePublicKey);
            byte[] privateKeyByte = privateKey.getEncoded();
            String encodePrivateKey = Base64.encodeBase64String(privateKeyByte);
            logger.error("encodePrivateKey : " + encodePrivateKey);

            //2.私钥加密，公钥解密----加密
            //使用PKCS8EncodedKeySpec转换为可以适配的密钥
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyByte);
            //通过工厂生成
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey generatePrivate = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            //使用加密处理器进行处理
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, generatePrivate);
            byte[] bytes = src.getBytes();//BadPaddingException
            byte[] encryptResult = cipher.doFinal(bytes);
            //Base64：把二进制转换成String
            logger.error("私钥加密，公钥解密----加密结果：" + Base64.encodeBase64String(encryptResult));

            //3.私钥加密，公钥解密----解密
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyByte);//java底层 RSA公钥只支持X509EncodedKeySpec这种格式
            PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, generatePublic);
            byte[] decryptResult = cipher.doFinal(encryptResult);
            logger.error("私钥加密，公钥解密----解密结果：" + Base64.encodeBase64String(decryptResult));

            //4.私钥解密，公钥加密----加密----与上相反
            //5.私钥解密，公钥加密----解密----与上相反

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
