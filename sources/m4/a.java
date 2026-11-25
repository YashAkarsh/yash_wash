package m4;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr != null) {
            for (byte b8 : bArr) {
                String hexString = Integer.toHexString(b8 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
        }
        return sb.toString().toUpperCase().trim();
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr != null) {
            for (byte b8 : bArr) {
                String hexString = Integer.toHexString(b8 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
                sb.append(" ");
            }
        }
        return sb.toString().toUpperCase().trim();
    }

    public static String c(byte[] bArr) {
        int length = bArr.length;
        String str = "";
        for (byte b8 : bArr) {
            str = str + ((char) b8);
        }
        return str;
    }

    public static void d(InputStream inputStream, OutputStream outputStream, int i7) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr = new byte[i7];
        while (true) {
            int i8 = inputStream.read(bArr);
            if (i8 < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i8);
            }
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() < 3) {
            return str;
        }
        return str.charAt(0) + "⋯" + str.charAt(str.length() - 1);
    }

    public static boolean f(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static byte[] g(String str) {
        int length = str.length();
        int i7 = length / 2;
        byte[] bArr = new byte[i7];
        String upperCase = str.toUpperCase();
        char[] charArray = upperCase.toCharArray();
        if (length % 2 == 1) {
            return null;
        }
        for (int i8 = 0; i8 < length; i8++) {
            char c8 = charArray[i8];
            if ((c8 < '0' || c8 > '9') && (c8 < 'A' || c8 > 'F')) {
                return null;
            }
        }
        for (int i9 = 0; i9 < length; i9 += 2) {
            bArr[(i7 - (i9 / 2)) - 1] = (byte) ((Character.digit(upperCase.charAt(i9), 16) << 4) + Character.digit(upperCase.charAt(i9 + 1), 16));
        }
        return bArr;
    }

    public static byte[] h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            String upperCase = str.toUpperCase();
            char[] charArray = upperCase.toCharArray();
            if (length % 2 == 1) {
                return null;
            }
            for (int i7 = 0; i7 < length; i7++) {
                char c8 = charArray[i7];
                if ((c8 < '0' || c8 > '9') && (c8 < 'A' || c8 > 'F')) {
                    return null;
                }
            }
            for (int i8 = 0; i8 < length; i8 += 2) {
                bArr[i8 / 2] = (byte) ((Character.digit(upperCase.charAt(i8), 16) << 4) + Character.digit(upperCase.charAt(i8 + 1), 16));
            }
            return bArr;
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static String i(String str) {
        String upperCase = str.toUpperCase();
        char[] charArray = upperCase.toCharArray();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        if (upperCase.length() % 2 == 1) {
            return "";
        }
        for (int i7 = 0; i7 < upperCase.length(); i7++) {
            char c8 = charArray[i7];
            if ((c8 < '0' || c8 > '9') && (c8 < 'A' || c8 > 'F')) {
                return "";
            }
        }
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 * 2;
            bArr[i8] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i9]) * 16) + "0123456789ABCDEF".indexOf(charArray[i9 + 1])) & 255);
        }
        return new String(bArr);
    }

    public static int j(byte[] bArr) {
        int length = bArr.length;
        int iR = 0;
        if (length == 0) {
            return 0;
        }
        for (int i7 = length - 1; i7 >= 0; i7--) {
            iR += r(bArr[i7]) << (i7 * 8);
        }
        return iR;
    }

    public static byte[] k(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i7 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr2[i7] = bArr[length];
            i7++;
        }
        return bArr2;
    }

    public static void l(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable th) {
                k4.b.e("Error closing stream: " + th.toString());
            }
        }
    }

    public static void m(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable th) {
                k4.b.e("Error closing stream: " + th.toString());
            }
        }
    }

    public static byte[] n(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Argument str ( String ) is null! ");
        }
        byte[] bArr = new byte[str.length() / 2];
        try {
            return str.getBytes(CharEncoding.US_ASCII);
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
            return bArr;
        }
    }

    public static String o(String str) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (byte b8 : str.getBytes()) {
            sb.append(charArray[(b8 & 240) >> 4]);
            sb.append(charArray[b8 & com.google.common.base.c.f19317q]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public static String p(String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            String hexString = Integer.toHexString(cCharAt);
            if (cCharAt > 128) {
                sb.append("\\u" + hexString);
            } else {
                sb.append("\\u00" + hexString);
            }
        }
        return sb.toString();
    }

    public static String q(String str) {
        int length = str.length() / 6;
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 * 6;
            i7++;
            String strSubstring = str.substring(i8, i7 * 6);
            sb.append(new String(Character.toChars(Integer.valueOf(strSubstring.substring(2, 4) + "00", 16).intValue() + Integer.valueOf(strSubstring.substring(4), 16).intValue())));
        }
        return sb.toString();
    }

    public static int r(byte b8) {
        return b8 & 255;
    }
}
