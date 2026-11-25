package com.haier.hailicommontlib.mvp.model.utils;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static int a(int i7) {
        return Integer.parseInt("" + i7, 16);
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
                return Integer.valueOf(stringBuffer.toString(), 16).intValue();
            }
            i7 = i9;
        }
    }

    public static String c(int i7) {
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

    public static String d(int i7) {
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

    public static int e(byte... bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return 0;
        }
        for (byte b8 : bArr) {
            String hexString = Integer.toHexString(b8 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString);
        }
        return Integer.valueOf(sb.toString(), 16).intValue();
    }

    public static int f(byte b8) {
        String hexString = Integer.toHexString(b8 & 255);
        if (hexString.length() == 1) {
            hexString = '0' + hexString;
        }
        return Integer.parseInt("" + hexString.toUpperCase(), 16);
    }

    public static int g(byte[] bArr) {
        return Integer.parseInt(new String(bArr));
    }

    private static byte h(char c8) {
        return (byte) "0123456789ABCDEF".indexOf(c8);
    }

    public static int[] i(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i7 = 0; bArr.length > 0 && i7 < bArr.length; i7++) {
            iArr[i7] = bArr[0] & 255;
        }
        return iArr;
    }

    public static int j(byte b8, int i7) {
        return (b8 >> i7) & 1;
    }

    public static byte[] k(int[] iArr) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (iArr != null) {
            bArr = new byte[iArr.length];
            for (int i7 = 0; i7 < iArr.length; i7++) {
                bArr[i7] = l(iArr[i7]);
            }
        }
        return bArr;
    }

    public static byte l(int i7) {
        if (i7 >= 0) {
            return Integer.valueOf(i7).byteValue();
        }
        return (byte) 0;
    }

    public static byte[] m(int i7) {
        byte[] bArr = new byte[4];
        for (int i8 = 0; i8 < 4; i8++) {
            bArr[i8] = (byte) (i7 >> (24 - (i8 * 8)));
        }
        return bArr;
    }
}
