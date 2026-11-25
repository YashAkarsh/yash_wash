package com.haier.library.common.util;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    private o() {
    }

    public static <T> T a(T t7, T t8) {
        if (t7 != null) {
            return t7;
        }
        if (t8 != null) {
            return t8;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static String b(Throwable th) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    String string = byteArrayOutputStream.toString();
                    printWriter.close();
                    byteArrayOutputStream.close();
                    return string;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        try {
                            printWriter.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                    throw th6;
                }
            }
        } catch (IOException e8) {
            Log.e("BeanUtil", "exception2String excp -> %s", e8);
            return "";
        }
    }

    public static void c(Object obj, String str, Object obj2) {
        Field declaredField;
        try {
            declaredField = obj.getClass().getDeclaredField(str);
        } catch (NoSuchFieldException e8) {
            e3.a.i(e8);
            declaredField = null;
        }
        if (declaredField == null) {
            return;
        }
        if (!declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        try {
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException e9) {
            e3.a.i(e9);
        }
    }
}
