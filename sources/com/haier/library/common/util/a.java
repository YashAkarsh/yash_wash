package com.haier.library.common.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f26524a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f26525b = "AES";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f26526c = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f26527d = "AES/CBC/NoPadding";

    public static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f26525b);
            Cipher cipher = Cipher.getInstance(f26526c);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return k.b(cipher.doFinal(bArr2));
        } catch (Exception e8) {
            e3.a.g("aes error,%s", e8);
            return new String(bArr2);
        }
    }

    public static byte[] b(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            e3.a.v("File decipher data is null or empty!", new Object[0]);
            return null;
        }
        try {
            return c(str, str2, bArr);
        } catch (Exception e8) {
            e3.a.g("File decipher fail", e8);
            return null;
        }
    }

    private static byte[] c(String str, String str2, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(h(str), str2);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher cipher = Cipher.getInstance(f26527d);
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static String d(String str, String str2) {
        return TextUtils.isEmpty(str) ? str : f(str.getBytes(Charset.forName("utf-8")), str2);
    }

    public static String e(ByteBuffer byteBuffer, String str) {
        if (byteBuffer == null) {
            e3.a.h("encrypt null data", new Object[0]);
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(byteBuffer);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr = new char[32];
            int i7 = 0;
            for (int i8 = 0; i8 < 16; i8++) {
                byte b8 = bArrDigest[i8];
                int i9 = i7 + 1;
                char[] cArr2 = f26524a;
                cArr[i7] = cArr2[(b8 >>> 4) & 15];
                i7 = i9 + 1;
                cArr[i9] = cArr2[b8 & com.google.common.base.c.f19317q];
            }
            return new String(cArr);
        } catch (NoSuchAlgorithmException e8) {
            e3.a.g("encrypt error -> %s", e8);
            return null;
        }
    }

    public static String f(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            e3.a.h("Encrypt null data", new Object[0]);
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return c.a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e8) {
            e3.a.g("Encrypt error", e8);
            return null;
        }
    }

    public static String g(File file) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    String strE = e(fileInputStream2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()), "MD5");
                    try {
                        fileInputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    return strE;
                } catch (FileNotFoundException e9) {
                    e = e9;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return "";
                } catch (IOException e11) {
                    e = e11;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    return "";
                }
            } catch (Throwable unused2) {
            }
        } catch (FileNotFoundException e14) {
            e = e14;
        } catch (IOException e15) {
            e = e15;
        }
    }

    private static byte[] h(String str) {
        if (c.j(str)) {
            return new byte[0];
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i7 = 0; i7 < str.length() / 2; i7++) {
            int i8 = i7 * 2;
            bArr[i7] = (byte) Integer.parseInt(str.substring(i8, i8 + 2), 16);
        }
        return bArr;
    }

    public static String i(String str) {
        return d(str, "MD5");
    }

    public static String j(String str) {
        return d(str, "SHA-1");
    }

    public static String k(String str) {
        return d(str, "SHA-256");
    }

    public static String l(byte[] bArr) {
        return f(bArr, "SHA-256");
    }

    public static String m(File file, String str, String str2, int i7, String str3) {
        byte[] bArrB = b(r.f(file), str, str2);
        if (bArrB == null || bArrB.length == 0) {
            e3.a.v("File decipher data is null or empty!", new Object[0]);
            return null;
        }
        byte[] bArr = new byte[i7];
        System.arraycopy(bArrB, 0, bArr, 0, i7);
        return f(bArr, str3);
    }
}
