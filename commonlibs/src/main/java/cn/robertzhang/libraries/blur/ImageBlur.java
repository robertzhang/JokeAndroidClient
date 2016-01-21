package cn.robertzhang.libraries.blur;

import android.graphics.Bitmap;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class ImageBlur {

    static {
        System.loadLibrary("ImageBlur");
    }

    public static native void blurIntArray(int[] pixelArray, int width, int height, int radius);

    public static native void blurBitMap(Bitmap bitmap, int radius);
}
