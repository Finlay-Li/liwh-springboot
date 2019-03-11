package com.dodou.liwh.qrcode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

/**
 * @author: Lwh
 * @ClassName: ResolveQRCodeHandler
 * @Description:
 * @version: 1.0.0
 * @date: 2019-02-27 4:53 PM
 */
public class ResolveQRCodeHandler implements QRCodeImage {

    public ResolveQRCodeHandler() {
    }

    BufferedImage bufferedImage;

    public ResolveQRCodeHandler(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    @Override
    public int getPixel(int i, int i1) {
        return bufferedImage.getRGB(i, i1);//颜色
    }
}
