package com.dodou.liwh.rsa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class TestRSA {

    public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCONBgWwR50ve7K4ZICyVto5HPRZhkhx/LtA9We9IVjvkTmb/ypb6eZEIOGjsppWd0mn43ii+Q9X6nnHmrjYGMJswF/vSlAdv9ft65nXBKSWJcEZJF8ZgL6Cl+in0zFWcim3R1zZoLNOhvlhXjh/5WRxndNJYunNaRlblfx4xmfwQIDAQAB";
    public static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI40GBbBHnS97srhkgLJW2jkc9FmGSHH8u0D1Z70hWO+ROZv/Klvp5kQg4aOymlZ3SafjeKL5D1fqeceauNgYwmzAX+9KUB2/1+3rmdcEpJYlwRkkXxmAvoKX6KfTMVZyKbdHXNmgs06G+WFeOH/lZHGd00li6c1pGVuV/HjGZ/BAgMBAAECgYByzh/8juE1wvl8lew5j7La1kWi8tiray/2pjfa4vKl+kDKAfNsH5ahfrGQ+srzjvd6bSoxklssKYWT7/y/oVuSiAZqc00lZ0K1TUBR4EwWcawQn804U9FQ/4xSqpNQIalqWYAVA6Wrbje3Dw3+bkMpjfT39OdrEJGAw0POjwTFGQJBAOvkKHPBdTOW4TWRvddpNOtCVDe0HmUN/bHwE/IlCQJi11X9FyIQt3z/0ddpCz0zctHrQF7iaS8bVAvGtKIyL5sCQQCaU2Sww/FeXgLvgpec9dFduDtqXwumKUP9BbEmiBMZVTSHqo1tR0nyFaygu1fvDawbAAvWhkBHwR6FvWK/RtnTAkASDBSkNorW9ZYpWQsjLeNklGCJGniw1o8wS+PaxMaZriI3a/OXIZxILfJJ/rljZ0pDkTINkFjnx7l4ZS1ws1I9AkAV84q9AgIRNDoiq2a5ctXHCO+an85eYjxDf03Fd1GQJuiD66SWSK+h+adGbZ+CZ2V1qboFV69JBZU73MZxArj1AkEAvUd/EpIjDiFtSQKkJIvZZ+36lY+Ni7LRmQHhFKZyzaNwDOuD85kFEN9ryyI8CMMjk5BlWLwv9MkY/kSHSGzZvg==";

    private static String algorithm = "RSA";
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static String data = "Hello Rsa Demo";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, IOException {
        String test = testEncrypt(privateKey, data);
        System.out.println(test);
        String testDecrypt = testDecrypt(publicKey, test);
        System.out.println(testDecrypt);

    }


    /**
     * 加密
     *
     * @param key
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws IOException
     */
    public static String testEncrypt(String key, String data) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, IOException {
        byte[] decode = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decode);
        KeyFactory kf = KeyFactory.getInstance(algorithm);
        PrivateKey generatePrivate = kf.generatePrivate(pkcs8EncodedKeySpec);
        Cipher ci = Cipher.getInstance(algorithm);
        ci.init(Cipher.ENCRYPT_MODE, generatePrivate);

        byte[] bytes = data.getBytes();
        int inputLen = bytes.length;
        int offLen = 0;//偏移量
        int i = 0;
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        while (inputLen - offLen > 0) {
            byte[] cache;
            if (inputLen - offLen > 117) {
                cache = ci.doFinal(bytes, offLen, 117);
            } else {
                cache = ci.doFinal(bytes, offLen, inputLen - offLen);
            }
            bops.write(cache);
            i++;
            offLen = 117 * i;
        }
        bops.close();
        byte[] encryptedData = bops.toByteArray();
        String encodeToString = Base64.getEncoder().encodeToString(encryptedData);
        return encodeToString;
    }


    /**
     * 解密
     *
     * @param key
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws InvalidKeySpecException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    public static String testDecrypt(String key, String data) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] decode = Base64.getDecoder().decode(key);
//		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decode); //java底层 RSA公钥只支持X509EncodedKeySpec这种格式
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decode);
        KeyFactory kf = KeyFactory.getInstance(algorithm);
        PublicKey generatePublic = kf.generatePublic(x509EncodedKeySpec);
        Cipher ci = Cipher.getInstance(algorithm);
        ci.init(Cipher.DECRYPT_MODE, generatePublic);

        byte[] bytes = Base64.getDecoder().decode(data);
        int inputLen = bytes.length;
        int offLen = 0;
        int i = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (inputLen - offLen > 0) {
            byte[] cache;
            if (inputLen - offLen > 128) {
                cache = ci.doFinal(bytes, offLen, 128);
            } else {
                cache = ci.doFinal(bytes, offLen, inputLen - offLen);
            }
            byteArrayOutputStream.write(cache);
            i++;
            offLen = 128 * i;

        }
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return new String(byteArray);
    }


}
