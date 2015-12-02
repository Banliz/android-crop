package com.soundcloud.android.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class BitmapUtil {
    private BitmapUtil() {

    }

    public static Bitmap getMatrixBitmap(Bitmap bm, int w, int h, boolean needRecycle) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        boolean isCompress = (width > w && height > h) && (w != 0 && h != 0);
        if (isCompress) {
            float scaleWidth = ((float) w) / width;
            float scaleHeight = ((float) h) / height;
            float scale = Math.max(scaleWidth, scaleHeight);
            Matrix matrix = new Matrix();
            matrix.postScale(scale, scale);
            Bitmap bitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
            if (needRecycle && bm != null && bm != bitmap) {
                bm.recycle();
            }
            return bitmap;
        }else {
            return bm;
        }

    }
}
