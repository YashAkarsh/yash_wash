package androidx.constraintlayout.motion.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3813a = "CustomSupport";

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0042a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3814a;

        static {
            int[] iArr = new int[androidx.constraintlayout.widget.a.b.values().length];
            f3814a = iArr;
            try {
                iArr[androidx.constraintlayout.widget.a.b.INT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3814a[androidx.constraintlayout.widget.a.b.FLOAT_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3814a[androidx.constraintlayout.widget.a.b.COLOR_DRAWABLE_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3814a[androidx.constraintlayout.widget.a.b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3814a[androidx.constraintlayout.widget.a.b.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3814a[androidx.constraintlayout.widget.a.b.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3814a[androidx.constraintlayout.widget.a.b.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static int a(int c8) {
        int i7 = (c8 & (~(c8 >> 31))) - 255;
        return (i7 & (i7 >> 31)) + 255;
    }

    public static void b(androidx.constraintlayout.widget.a att, View view, float[] value) {
        Class<?> cls = view.getClass();
        String str = "set" + att.h();
        try {
            boolean z7 = true;
            switch (C0042a.f3814a[att.j().ordinal()]) {
                case 1:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((int) value[0]));
                    return;
                case 2:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(value[0]));
                    return;
                case 3:
                    Method method = cls.getMethod(str, Drawable.class);
                    int iA = (a((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (value[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(iA);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((a((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (value[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 5:
                    throw new RuntimeException("unable to interpolate strings " + att.h());
                case 6:
                    Method method2 = cls.getMethod(str, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (value[0] <= 0.5f) {
                        z7 = false;
                    }
                    objArr[0] = Boolean.valueOf(z7);
                    method2.invoke(view, objArr);
                    return;
                case 7:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(value[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e8) {
            Log.e(f3813a, "cannot access method " + str + " on View \"" + androidx.constraintlayout.motion.widget.c.k(view) + "\"");
            e8.printStackTrace();
        } catch (NoSuchMethodException e9) {
            Log.e(f3813a, "no method " + str + " on View \"" + androidx.constraintlayout.motion.widget.c.k(view) + "\"");
            e9.printStackTrace();
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }
}
