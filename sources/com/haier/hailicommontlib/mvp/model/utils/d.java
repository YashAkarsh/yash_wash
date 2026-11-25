package com.haier.hailicommontlib.mvp.model.utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void a(Activity activity, String str, int i7, NavCallback navCallback, z2.a... aVarArr) {
        Postcard postcardC = com.alibaba.android.arouter.launcher.a.i().c(str);
        if (aVarArr != null && aVarArr.length > 0) {
            for (z2.a aVar : aVarArr) {
                if (aVar.b() instanceof Integer) {
                    postcardC.withInt(aVar.a(), ((Integer) aVar.b()).intValue());
                } else if (aVar.b() instanceof Short) {
                    postcardC.withShort(aVar.a(), ((Short) aVar.b()).shortValue());
                } else if (aVar.b() instanceof Long) {
                    postcardC.withLong(aVar.a(), ((Long) aVar.b()).longValue());
                } else if (aVar.b() instanceof Byte) {
                    postcardC.withByte(aVar.a(), ((Byte) aVar.b()).byteValue());
                } else if (aVar.b() instanceof Double) {
                    postcardC.withDouble(aVar.a(), ((Double) aVar.b()).doubleValue());
                } else if (aVar.b() instanceof Float) {
                    postcardC.withFloat(aVar.a(), ((Float) aVar.b()).floatValue());
                } else if (aVar.b() instanceof String) {
                    postcardC.withString(aVar.a(), (String) aVar.b());
                } else if (aVar.b() instanceof Character) {
                    postcardC.withChar(aVar.a(), ((Character) aVar.b()).charValue());
                } else if (aVar.b() instanceof Boolean) {
                    postcardC.withBoolean(aVar.a(), ((Boolean) aVar.b()).booleanValue());
                } else if (aVar.b() instanceof Bundle) {
                    postcardC.withBundle(aVar.a(), (Bundle) aVar.b());
                } else if (aVar.b() instanceof Serializable) {
                    postcardC.withSerializable(aVar.a(), (Serializable) aVar.b());
                } else if (aVar.b() instanceof Parcelable) {
                    postcardC.withParcelable(aVar.a(), (Parcelable) aVar.b());
                }
            }
        }
        if (activity == null) {
            postcardC.navigation();
            return;
        }
        if (i7 > -1) {
            if (navCallback != null) {
                postcardC.navigation(activity, i7, navCallback);
                return;
            } else {
                postcardC.navigation(activity, i7);
                return;
            }
        }
        if (navCallback != null) {
            postcardC.navigation(activity, navCallback);
        } else {
            postcardC.navigation(activity);
        }
    }

    public static <T> void b(Activity activity, String str, NavCallback navCallback, z2.a... aVarArr) {
        a(activity, str, -1, navCallback, aVarArr);
    }

    public static <T> void c(Activity activity, String str, z2.a... aVarArr) {
        b(activity, str, null, aVarArr);
    }

    public static <T> void d(String str, z2.a... aVarArr) {
        c(null, str, aVarArr);
    }
}
