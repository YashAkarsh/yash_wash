package com.haier.hailicommontlib.mvp.model.utils;

import java.util.HashMap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static String a(int i7) {
        char[] cArr = new char[20];
        int i8 = 0;
        while (true) {
            int i9 = i7 / 16;
            int i10 = i7 % 16;
            if (i10 == 15) {
                cArr[i8] = 'F';
            } else if (i10 == 14) {
                cArr[i8] = 'E';
            } else if (i10 == 13) {
                cArr[i8] = 'D';
            } else if (i10 == 12) {
                cArr[i8] = 'C';
            } else if (i10 == 11) {
                cArr[i8] = 'B';
            } else if (i10 == 10) {
                cArr[i8] = 'A';
            } else {
                cArr[i8] = (char) (i10 + 48);
            }
            i8++;
            if (i9 == 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cArr, 0, i8);
                stringBuffer.reverse();
                return new String("0x") + stringBuffer.toString();
            }
            i7 = i9;
        }
    }

    public static int b(int i7) {
        char[] cArr = new char[20];
        int i8 = 0;
        while (true) {
            int i9 = i7 / 16;
            int i10 = i7 % 16;
            if (i10 == 15) {
                cArr[i8] = 'F';
            } else if (i10 == 14) {
                cArr[i8] = 'E';
            } else if (i10 == 13) {
                cArr[i8] = 'D';
            } else if (i10 == 12) {
                cArr[i8] = 'C';
            } else if (i10 == 11) {
                cArr[i8] = 'B';
            } else if (i10 == 10) {
                cArr[i8] = 'A';
            } else {
                cArr[i8] = (char) (i10 + 48);
            }
            i8++;
            if (i9 == 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cArr, 0, i8);
                stringBuffer.reverse();
                return Integer.valueOf(new String("0x") + stringBuffer.toString(), 16).intValue();
            }
            i7 = i9;
        }
    }

    public static String c(int i7) {
        char[] cArr = new char[100];
        int i8 = 0;
        while (true) {
            int i9 = i7 / 16;
            int i10 = i7 % 16;
            if (i10 == 15) {
                cArr[i8] = 'F';
            } else if (i10 == 14) {
                cArr[i8] = 'E';
            } else if (i10 == 13) {
                cArr[i8] = 'D';
            } else if (i10 == 12) {
                cArr[i8] = 'C';
            } else if (i10 == 11) {
                cArr[i8] = 'B';
            } else if (i10 == 10) {
                cArr[i8] = 'A';
            } else {
                cArr[i8] = (char) (i10 + 48);
            }
            i8++;
            if (i9 == 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cArr, 0, i8);
                stringBuffer.reverse();
                return stringBuffer.toString();
            }
            i7 = i9;
        }
    }

    public static int d(byte b8) {
        String hexString = Integer.toHexString(b8 & 255);
        if (hexString.length() == 1) {
            hexString = '0' + hexString;
        }
        return Integer.parseInt("" + hexString.toUpperCase(), 16);
    }

    public static int e(byte b8) {
        String hexString = Integer.toHexString(b8 & 255);
        if (hexString.length() == 1) {
            hexString = '0' + hexString;
        }
        return Integer.parseInt("" + hexString.toUpperCase(), 16);
    }

    public static String f(byte b8) {
        String hexString = Integer.toHexString(b8 & 255);
        if (hexString.length() == 1) {
            hexString = '0' + hexString;
        }
        return "" + hexString.toUpperCase();
    }

    public static String g(byte[] bArr) {
        String str = "";
        for (byte b8 : bArr) {
            String hexString = Integer.toHexString(b8 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    private static byte h(char c8) {
        return (byte) "0123456789ABCDEF".indexOf(c8);
    }

    public static int i(Byte b8) {
        int iIntValue = -1;
        if (b8 == null) {
            return -1;
        }
        String upperCase = f(b8.byteValue()).toUpperCase();
        if (upperCase.split("X").length == 2) {
            upperCase = upperCase.split("X")[1];
        }
        String[] strArr = {"A", "B", "C", "D", "E", "F"};
        HashMap map = new HashMap();
        for (int i7 = 0; i7 <= 9; i7++) {
            map.put(i7 + "", Integer.valueOf(i7));
        }
        for (int i8 = 10; i8 < 16; i8++) {
            map.put(strArr[i8 - 10], Integer.valueOf(i8));
        }
        int length = upperCase.length();
        String[] strArr2 = new String[length];
        int i9 = 0;
        while (i9 < length) {
            int i10 = i9 + 1;
            strArr2[i9] = upperCase.substring(i9, i10);
            i9 = i10;
        }
        for (int i11 = 0; i11 < length; i11++) {
            try {
                iIntValue = (int) (((double) iIntValue) + (((double) ((Integer) map.get(strArr2[i11])).intValue()) * Math.pow(16.0d, (length - 1) - i11)));
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("进制转换--参数异常:" + upperCase);
            }
        }
        return iIntValue;
    }

    public static int j(String str) {
        int iIntValue = -1;
        if (str == null) {
            return -1;
        }
        String upperCase = str.toUpperCase();
        if (upperCase.split("X").length == 2) {
            upperCase = upperCase.split("X")[1];
        }
        String[] strArr = {"A", "B", "C", "D", "E", "F"};
        HashMap map = new HashMap();
        for (int i7 = 0; i7 <= 9; i7++) {
            map.put(i7 + "", Integer.valueOf(i7));
        }
        for (int i8 = 10; i8 < 16; i8++) {
            map.put(strArr[i8 - 10], Integer.valueOf(i8));
        }
        int length = upperCase.length();
        String[] strArr2 = new String[length];
        int i9 = 0;
        while (i9 < length) {
            int i10 = i9 + 1;
            strArr2[i9] = upperCase.substring(i9, i10);
            i9 = i10;
        }
        for (int i11 = 0; i11 < length; i11++) {
            try {
                iIntValue = (int) (((double) iIntValue) + (((double) ((Integer) map.get(strArr2[i11])).intValue()) * Math.pow(16.0d, (length - 1) - i11)));
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("进制转换--参数异常:" + upperCase);
            }
        }
        return iIntValue;
    }

    public static int k(byte... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b8 : bArr) {
            sb.append(f(b8));
        }
        return j(sb.toString());
    }

    public static int[] l(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i7 = 0; bArr.length > 0 && i7 < bArr.length; i7++) {
            iArr[i7] = bArr[i7] & 255;
        }
        return iArr;
    }

    public static byte[] m(String str) {
        if (str == null || str.equals("") || str.length() % 2 != 0) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = upperCase.toCharArray();
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * 2;
            bArr[i7] = (byte) (h(charArray[i8 + 1]) | (h(charArray[i8]) << 4));
        }
        return bArr;
    }

    public static byte[] n(String str) {
        if (str == null || str.equals("") || str.length() % 2 != 0) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = upperCase.toCharArray();
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * 2;
            bArr[i7] = (byte) (h(charArray[i8 + 1]) | (h(charArray[i8]) << 4));
        }
        return bArr;
    }

    public static byte o(int i7) {
        if (i7 >= 0) {
            return Integer.valueOf(i7).byteValue();
        }
        return (byte) 0;
    }

    public static int p(int i7) {
        return Integer.parseInt(i7 + "", 10);
    }

    public static boolean q(Object obj) {
        if (obj == null) {
            return false;
        }
        return !(obj instanceof String) || ((String) obj).length() > 0;
    }

    public static String r(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        int length = bArr.length - 1;
        if (length == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i7 = 0;
        while (true) {
            sb.append(a(c.f(bArr[i7])));
            if (i7 == length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            i7++;
        }
    }
}
