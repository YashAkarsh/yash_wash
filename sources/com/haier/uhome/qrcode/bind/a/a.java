package com.haier.uhome.qrcode.bind.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f29538a = "APP_ID";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f29539b = "APP_KEY";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f29540c = "18120";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f29541d = "18810";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f29542e = "A0004";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f29543f = "00000";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f29544g = "-1";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f29545h = "a";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f29546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f29547j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static Bundle a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Build.SERIAL);
        stringBuffer.append(Build.BOARD);
        stringBuffer.append(Build.BRAND);
        stringBuffer.append(Build.DEVICE);
        stringBuffer.append(Build.HARDWARE);
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append(Build.PRODUCT);
        stringBuffer.append(Build.MODEL);
        return a(stringBuffer.toString().toUpperCase());
    }

    public static String a(Context context, String str) {
        Bundle bundleA = a(context);
        if (bundleA == null) {
            return "";
        }
        Object obj = bundleA.get(str);
        return (String) (obj != null ? obj : "");
    }

    public static String a() {
        return "" + System.currentTimeMillis();
    }

    public static String a(String str) {
        return a(str, "MD5");
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str : a(str.getBytes(Charset.forName("utf-8")), str2);
    }

    public static String a(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return a(messageDigest.digest());
            } catch (NoSuchAlgorithmException e8) {
                Log.e(f29545h, "Encrypt error", e8);
                return null;
            }
        }
        Log.e(f29545h, "Encrypt null data");
        return null;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            for (byte b8 : bArr) {
                String hexString = Integer.toHexString(b8 & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
        }
        return sb.toString();
    }
}
