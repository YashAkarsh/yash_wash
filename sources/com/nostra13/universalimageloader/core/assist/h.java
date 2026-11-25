package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public enum h {
    FIT_INSIDE,
    CROP;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32679a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f32679a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32679a[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32679a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32679a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32679a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32679a[ImageView.ScaleType.MATRIX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32679a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32679a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static h a(ImageView imageView) {
        int i7 = a.f32679a[imageView.getScaleType().ordinal()];
        return (i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4 || i7 == 5) ? FIT_INSIDE : CROP;
    }
}
