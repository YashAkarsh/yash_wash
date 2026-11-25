package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
import q0.e;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || o0.a.d(str) || o0.a.d(str2)) {
            return null;
        }
        try {
            String strA = e.a(context, str, str2, "");
            if (o0.a.d(strA)) {
                return null;
            }
            return p0.c.e(p0.c.a(), strA);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (o0.a.d(str) || o0.a.d(str2)) {
                return null;
            }
            try {
                String strA = q0.b.a(str);
                if (o0.a.d(strA)) {
                    return null;
                }
                String string = new JSONObject(strA).getString(str2);
                if (o0.a.d(string)) {
                    return null;
                }
                return p0.c.e(p0.c.a(), string);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (o0.a.d(str) || o0.a.d(str2) || context == null) {
            return;
        }
        try {
            String strB = p0.c.b(p0.c.a(), str3);
            HashMap map = new HashMap();
            map.put(str2, strB);
            e.b(context, str, map);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041 A[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #0 {all -> 0x0072, blocks: (B:9:0x0010, B:11:0x001f, B:14:0x002a, B:16:0x003b, B:18:0x0041, B:13:0x0025), top: B:35:0x0010, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x005a  */
    /* JADX WARN: Instruction removed from duplicated block: B:18:0x0041, please report this as an issue */
    public static void a(String str, String str2, String str3) {
        String str4;
        File file;
        synchronized (a.class) {
            if (o0.a.d(str) || o0.a.d(str2)) {
                return;
            }
            try {
                String strA = q0.b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (o0.a.g(strA)) {
                    try {
                        jSONObject = new JSONObject(strA);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put(str2, p0.c.b(p0.c.a(), str3));
                    jSONObject.toString();
                    try {
                        System.clearProperty(str);
                    } catch (Throwable unused2) {
                    }
                    if (q0.c.b()) {
                        str4 = ".SystemConfig" + File.separator + str;
                        if (q0.c.b()) {
                            file = new File(Environment.getExternalStorageDirectory(), str4);
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                        }
                    }
                } else {
                    jSONObject.put(str2, p0.c.b(p0.c.a(), str3));
                    jSONObject.toString();
                    System.clearProperty(str);
                    if (q0.c.b()) {
                        str4 = ".SystemConfig" + File.separator + str;
                        if (q0.c.b()) {
                            file = new File(Environment.getExternalStorageDirectory(), str4);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
