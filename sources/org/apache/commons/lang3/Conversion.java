package org.apache.commons.lang3;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.fastjson.asm.j;
import com.haier.uhome.ble.a;
import f4.d;
import java.util.UUID;
import kotlin.g2;
import okhttp3.internal.ws.g;

/* JADX INFO: loaded from: classes3.dex */
public class Conversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean[] TTTT = {true, true, true, true};
    private static final boolean[] FTTT = {false, true, true, true};
    private static final boolean[] TFTT = {true, false, true, true};
    private static final boolean[] FFTT = {false, false, true, true};
    private static final boolean[] TTFT = {true, true, false, true};
    private static final boolean[] FTFT = {false, true, false, true};
    private static final boolean[] TFFT = {true, false, false, true};
    private static final boolean[] FFFT = {false, false, false, true};
    private static final boolean[] TTTF = {true, true, true, false};
    private static final boolean[] FTTF = {false, true, true, false};
    private static final boolean[] TFTF = {true, false, true, false};
    private static final boolean[] FFTF = {false, false, true, false};
    private static final boolean[] TTFF = {true, true, false, false};
    private static final boolean[] FTFF = {false, true, false, false};
    private static final boolean[] TFFF = {true, false, false, false};
    private static final boolean[] FFFF = {false, false, false, false};

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        return binaryBeMsb0ToHexDigit(zArr, 0);
    }

    public static byte binaryToByte(boolean[] zArr, int i7, byte b8, int i8, int i9) {
        if ((zArr.length == 0 && i7 == 0) || i9 == 0) {
            return b8;
        }
        if ((i9 - 1) + i8 >= 8) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 8");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = i10 + i8;
            b8 = (byte) ((b8 & (~(1 << i11))) | ((zArr[i10 + i7] ? 1 : 0) << i11));
        }
        return b8;
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        return binaryToHexDigit(zArr, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        return binaryToHexDigitMsb0_4bits(zArr, 0);
    }

    public static int binaryToInt(boolean[] zArr, int i7, int i8, int i9, int i10) {
        if ((zArr.length == 0 && i7 == 0) || i10 == 0) {
            return i8;
        }
        if ((i10 - 1) + i9 >= 32) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 32");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 + i9;
            i8 = (i8 & (~(1 << i12))) | ((zArr[i11 + i7] ? 1 : 0) << i12);
        }
        return i8;
    }

    public static long binaryToLong(boolean[] zArr, int i7, long j7, int i8, int i9) {
        if ((zArr.length == 0 && i7 == 0) || i9 == 0) {
            return j7;
        }
        if ((i9 - 1) + i8 >= 64) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = i10 + i8;
            j7 = (j7 & (~(1 << i11))) | ((zArr[i10 + i7] ? 1L : 0L) << i11);
        }
        return j7;
    }

    public static short binaryToShort(boolean[] zArr, int i7, short s7, int i8, int i9) {
        if ((zArr.length == 0 && i7 == 0) || i9 == 0) {
            return s7;
        }
        if ((i9 - 1) + i8 >= 16) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 16");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = i10 + i8;
            s7 = (short) ((s7 & (~(1 << i11))) | ((zArr[i10 + i7] ? 1 : 0) << i11));
        }
        return s7;
    }

    public static int byteArrayToInt(byte[] bArr, int i7, int i8, int i9, int i10) {
        if ((bArr.length == 0 && i7 == 0) || i10 == 0) {
            return i8;
        }
        if (((i10 - 1) * 8) + i9 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 32");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = (i11 * 8) + i9;
            i8 = (i8 & (~(255 << i12))) | ((bArr[i11 + i7] & 255) << i12);
        }
        return i8;
    }

    public static long byteArrayToLong(byte[] bArr, int i7, long j7, int i8, int i9) {
        if ((bArr.length == 0 && i7 == 0) || i9 == 0) {
            return j7;
        }
        if (((i9 - 1) * 8) + i8 >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 8) + i8;
            j7 = (j7 & (~(255 << i11))) | ((((long) bArr[i10 + i7]) & 255) << i11);
        }
        return j7;
    }

    public static short byteArrayToShort(byte[] bArr, int i7, short s7, int i8, int i9) {
        if ((bArr.length == 0 && i7 == 0) || i9 == 0) {
            return s7;
        }
        if (((i9 - 1) * 8) + i8 >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 16");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 8) + i8;
            s7 = (short) ((s7 & (~(255 << i11))) | ((bArr[i10 + i7] & 255) << i11));
        }
        return s7;
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i7) {
        if (bArr.length - i7 >= 16) {
            return new UUID(byteArrayToLong(bArr, i7, 0L, 0, 8), byteArrayToLong(bArr, i7 + 8, 0L, 0, 8));
        }
        throw new IllegalArgumentException("Need at least 16 bytes for UUID");
    }

    public static boolean[] byteToBinary(byte b8, int i7, boolean[] zArr, int i8, int i9) {
        if (i9 == 0) {
            return zArr;
        }
        if ((i9 - 1) + i7 >= 8) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 8");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = i8 + i10;
            boolean z7 = true;
            if (((b8 >> (i10 + i7)) & 1) == 0) {
                z7 = false;
            }
            zArr[i11] = z7;
        }
        return zArr;
    }

    public static String byteToHex(byte b8, int i7, String str, int i8, int i9) {
        if (i9 == 0) {
            return str;
        }
        if (((i9 - 1) * 4) + i7 >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 8");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (b8 >> ((i10 * 4) + i7)) & 15;
            int i12 = i8 + i10;
            if (i12 == length) {
                length++;
                sb.append(intToHexDigit(i11));
            } else {
                sb.setCharAt(i12, intToHexDigit(i11));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    /* JADX WARN: Code duplicated, block: B:13:0x0040  */
    /* JADX WARN: Code duplicated, block: B:15:0x0049  */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    public static boolean[] hexDigitMsb0ToBinary(char c8) {
        switch (c8) {
            case ConstraintLayout.LayoutParams.a.W /* 48 */:
                return (boolean[]) FFFF.clone();
            case '1':
                return (boolean[]) FFFT.clone();
            case '2':
                return (boolean[]) FFTF.clone();
            case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                return (boolean[]) FFTT.clone();
            case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                return (boolean[]) FTFF.clone();
            case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                return (boolean[]) FTFT.clone();
            case '6':
                return (boolean[]) FTTF.clone();
            case '7':
                return (boolean[]) FTTT.clone();
            case j.f12626t /* 56 */:
                return (boolean[]) TFFF.clone();
            case j.f12627u /* 57 */:
                return (boolean[]) TFFT.clone();
            default:
                switch (c8) {
                    case 'A':
                        return (boolean[]) TFTF.clone();
                    case 'B':
                        return (boolean[]) TFTT.clone();
                    case ConstraintLayout.LayoutParams.a.f4583h0 /* 67 */:
                        return (boolean[]) TTFF.clone();
                    case d.f33912b /* 68 */:
                        return (boolean[]) TTFT.clone();
                    case d.f33916f /* 69 */:
                        return (boolean[]) TTTF.clone();
                    case d.f33913c /* 70 */:
                        return (boolean[]) TTTT.clone();
                    default:
                        switch (c8) {
                            case 'a':
                                return (boolean[]) TFTF.clone();
                            case 'b':
                                return (boolean[]) TFTT.clone();
                            case a.f28150x /* 99 */:
                                return (boolean[]) TTFF.clone();
                            case 'd':
                                return (boolean[]) TTFT.clone();
                            case 'e':
                                return (boolean[]) TTTF.clone();
                            case 'f':
                                return (boolean[]) TTTT.clone();
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c8 + "' as a hexadecimal digit");
                        }
                }
        }
    }

    public static int hexDigitMsb0ToInt(char c8) {
        switch (c8) {
            case ConstraintLayout.LayoutParams.a.W /* 48 */:
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                return 12;
            case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                return 2;
            case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                return 10;
            case '6':
                return 6;
            case '7':
                return 14;
            case j.f12626t /* 56 */:
                return 1;
            case j.f12627u /* 57 */:
                return 9;
            default:
                switch (c8) {
                    case 'A':
                        return 5;
                    case 'B':
                        return 13;
                    case ConstraintLayout.LayoutParams.a.f4583h0 /* 67 */:
                        return 3;
                    case d.f33912b /* 68 */:
                        return 11;
                    case d.f33916f /* 69 */:
                        return 7;
                    case d.f33913c /* 70 */:
                        return 15;
                    default:
                        switch (c8) {
                            case 'a':
                                return 5;
                            case 'b':
                                return 13;
                            case a.f28150x /* 99 */:
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c8 + "' as a hexadecimal digit");
                        }
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    /* JADX WARN: Code duplicated, block: B:13:0x0040  */
    /* JADX WARN: Code duplicated, block: B:15:0x0049  */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    public static boolean[] hexDigitToBinary(char c8) {
        switch (c8) {
            case ConstraintLayout.LayoutParams.a.W /* 48 */:
                return (boolean[]) FFFF.clone();
            case '1':
                return (boolean[]) TFFF.clone();
            case '2':
                return (boolean[]) FTFF.clone();
            case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                return (boolean[]) TTFF.clone();
            case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                return (boolean[]) FFTF.clone();
            case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                return (boolean[]) TFTF.clone();
            case '6':
                return (boolean[]) FTTF.clone();
            case '7':
                return (boolean[]) TTTF.clone();
            case j.f12626t /* 56 */:
                return (boolean[]) FFFT.clone();
            case j.f12627u /* 57 */:
                return (boolean[]) TFFT.clone();
            default:
                switch (c8) {
                    case 'A':
                        return (boolean[]) FTFT.clone();
                    case 'B':
                        return (boolean[]) TTFT.clone();
                    case ConstraintLayout.LayoutParams.a.f4583h0 /* 67 */:
                        return (boolean[]) FFTT.clone();
                    case d.f33912b /* 68 */:
                        return (boolean[]) TFTT.clone();
                    case d.f33916f /* 69 */:
                        return (boolean[]) FTTT.clone();
                    case d.f33913c /* 70 */:
                        return (boolean[]) TTTT.clone();
                    default:
                        switch (c8) {
                            case 'a':
                                return (boolean[]) FTFT.clone();
                            case 'b':
                                return (boolean[]) TTFT.clone();
                            case a.f28150x /* 99 */:
                                return (boolean[]) FFTT.clone();
                            case 'd':
                                return (boolean[]) TFTT.clone();
                            case 'e':
                                return (boolean[]) FTTT.clone();
                            case 'f':
                                return (boolean[]) TTTT.clone();
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c8 + "' as a hexadecimal digit");
                        }
                }
        }
    }

    public static int hexDigitToInt(char c8) {
        int iDigit = Character.digit(c8, 16);
        if (iDigit >= 0) {
            return iDigit;
        }
        throw new IllegalArgumentException("Cannot interpret '" + c8 + "' as a hexadecimal digit");
    }

    public static byte hexToByte(String str, int i7, byte b8, int i8, int i9) {
        if (i9 == 0) {
            return b8;
        }
        if (((i9 - 1) * 4) + i8 >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 8");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 4) + i8;
            b8 = (byte) ((b8 & (~(15 << i11))) | ((hexDigitToInt(str.charAt(i10 + i7)) & 15) << i11));
        }
        return b8;
    }

    public static int hexToInt(String str, int i7, int i8, int i9, int i10) {
        if (i10 == 0) {
            return i8;
        }
        if (((i10 - 1) * 4) + i9 >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 32");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = (i11 * 4) + i9;
            i8 = (i8 & (~(15 << i12))) | ((hexDigitToInt(str.charAt(i11 + i7)) & 15) << i12);
        }
        return i8;
    }

    public static long hexToLong(String str, int i7, long j7, int i8, int i9) {
        if (i9 == 0) {
            return j7;
        }
        if (((i9 - 1) * 4) + i8 >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 4) + i8;
            j7 = (j7 & (~(15 << i11))) | ((((long) hexDigitToInt(str.charAt(i10 + i7))) & 15) << i11);
        }
        return j7;
    }

    public static short hexToShort(String str, int i7, short s7, int i8, int i9) {
        if (i9 == 0) {
            return s7;
        }
        if (((i9 - 1) * 4) + i8 >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 16");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 4) + i8;
            s7 = (short) ((s7 & (~(15 << i11))) | ((hexDigitToInt(str.charAt(i10 + i7)) & 15) << i11));
        }
        return s7;
    }

    public static long intArrayToLong(int[] iArr, int i7, long j7, int i8, int i9) {
        if ((iArr.length == 0 && i7 == 0) || i9 == 0) {
            return j7;
        }
        if (((i9 - 1) * 32) + i8 >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+dstPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 32) + i8;
            j7 = (j7 & (~(4294967295 << i11))) | ((((long) iArr[i10 + i7]) & 4294967295L) << i11);
        }
        return j7;
    }

    public static boolean[] intToBinary(int i7, int i8, boolean[] zArr, int i9, int i10) {
        if (i10 == 0) {
            return zArr;
        }
        if ((i10 - 1) + i8 >= 32) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 32");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i9 + i11;
            boolean z7 = true;
            if (((i7 >> (i11 + i8)) & 1) == 0) {
                z7 = false;
            }
            zArr[i12] = z7;
        }
        return zArr;
    }

    public static byte[] intToByteArray(int i7, int i8, byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return bArr;
        }
        if (((i10 - 1) * 8) + i8 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 32");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i9 + i11] = (byte) ((i7 >> ((i11 * 8) + i8)) & 255);
        }
        return bArr;
    }

    public static String intToHex(int i7, int i8, String str, int i9, int i10) {
        if (i10 == 0) {
            return str;
        }
        if (((i10 - 1) * 4) + i8 >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 32");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = (i7 >> ((i11 * 4) + i8)) & 15;
            int i13 = i9 + i11;
            if (i13 == length) {
                length++;
                sb.append(intToHexDigit(i12));
            } else {
                sb.setCharAt(i13, intToHexDigit(i12));
            }
        }
        return sb.toString();
    }

    public static char intToHexDigit(int i7) {
        char cForDigit = Character.forDigit(i7, 16);
        if (cForDigit != 0) {
            return cForDigit;
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + i7);
    }

    public static char intToHexDigitMsb0(int i7) {
        switch (i7) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return '4';
            case 3:
                return 'c';
            case 4:
                return '2';
            case 5:
                return 'a';
            case 6:
                return '6';
            case 7:
                return 'e';
            case 8:
                return '1';
            case 9:
                return '9';
            case 10:
                return '5';
            case 11:
                return 'd';
            case 12:
                return '3';
            case 13:
                return 'b';
            case 14:
                return '7';
            case 15:
                return 'f';
            default:
                throw new IllegalArgumentException("nibble value not between 0 and 15: " + i7);
        }
    }

    public static short[] intToShortArray(int i7, int i8, short[] sArr, int i9, int i10) {
        if (i10 == 0) {
            return sArr;
        }
        if (((i10 - 1) * 16) + i8 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 32");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            sArr[i9 + i11] = (short) ((i7 >> ((i11 * 16) + i8)) & 65535);
        }
        return sArr;
    }

    public static boolean[] longToBinary(long j7, int i7, boolean[] zArr, int i8, int i9) {
        if (i9 == 0) {
            return zArr;
        }
        if ((i9 - 1) + i7 >= 64) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            zArr[i8 + i10] = (1 & (j7 >> (i10 + i7))) != 0;
        }
        return zArr;
    }

    public static byte[] longToByteArray(long j7, int i7, byte[] bArr, int i8, int i9) {
        if (i9 == 0) {
            return bArr;
        }
        if (((i9 - 1) * 8) + i7 >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[i8 + i10] = (byte) (255 & (j7 >> ((i10 * 8) + i7)));
        }
        return bArr;
    }

    public static String longToHex(long j7, int i7, String str, int i8, int i9) {
        if (i9 == 0) {
            return str;
        }
        if (((i9 - 1) * 4) + i7 >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 64");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (int) ((j7 >> ((i10 * 4) + i7)) & 15);
            int i12 = i8 + i10;
            if (i12 == length) {
                length++;
                sb.append(intToHexDigit(i11));
            } else {
                sb.setCharAt(i12, intToHexDigit(i11));
            }
        }
        return sb.toString();
    }

    public static int[] longToIntArray(long j7, int i7, int[] iArr, int i8, int i9) {
        if (i9 == 0) {
            return iArr;
        }
        if (((i9 - 1) * 32) + i7 >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+srcPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            iArr[i8 + i10] = (int) ((-1) & (j7 >> ((i10 * 32) + i7)));
        }
        return iArr;
    }

    public static short[] longToShortArray(long j7, int i7, short[] sArr, int i8, int i9) {
        if (i9 == 0) {
            return sArr;
        }
        if (((i9 - 1) * 16) + i7 >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            sArr[i8 + i10] = (short) (g.f38386s & (j7 >> ((i10 * 16) + i7)));
        }
        return sArr;
    }

    public static int shortArrayToInt(short[] sArr, int i7, int i8, int i9, int i10) {
        if ((sArr.length == 0 && i7 == 0) || i10 == 0) {
            return i8;
        }
        if (((i10 - 1) * 16) + i9 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 32");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = (i11 * 16) + i9;
            i8 = (i8 & (~(65535 << i12))) | ((sArr[i11 + i7] & g2.f34732d) << i12);
        }
        return i8;
    }

    public static long shortArrayToLong(short[] sArr, int i7, long j7, int i8, int i9) {
        if ((sArr.length == 0 && i7 == 0) || i9 == 0) {
            return j7;
        }
        if (((i9 - 1) * 16) + i8 >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 64");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 16) + i8;
            j7 = (j7 & (~(g.f38386s << i11))) | ((((long) sArr[i10 + i7]) & g.f38386s) << i11);
        }
        return j7;
    }

    public static boolean[] shortToBinary(short s7, int i7, boolean[] zArr, int i8, int i9) {
        if (i9 == 0) {
            return zArr;
        }
        if ((i9 - 1) + i7 >= 16) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 16");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = i8 + i10;
            boolean z7 = true;
            if (((s7 >> (i10 + i7)) & 1) == 0) {
                z7 = false;
            }
            zArr[i11] = z7;
        }
        return zArr;
    }

    public static byte[] shortToByteArray(short s7, int i7, byte[] bArr, int i8, int i9) {
        if (i9 == 0) {
            return bArr;
        }
        if (((i9 - 1) * 8) + i7 >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 16");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[i8 + i10] = (byte) ((s7 >> ((i10 * 8) + i7)) & 255);
        }
        return bArr;
    }

    public static String shortToHex(short s7, int i7, String str, int i8, int i9) {
        if (i9 == 0) {
            return str;
        }
        if (((i9 - 1) * 4) + i7 >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 16");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (s7 >> ((i10 * 4) + i7)) & 15;
            int i12 = i8 + i10;
            if (i12 == length) {
                length++;
                sb.append(intToHexDigit(i11));
            } else {
                sb.setCharAt(i12, intToHexDigit(i11));
            }
        }
        return sb.toString();
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i7, int i8) {
        if (i8 == 0) {
            return bArr;
        }
        if (i8 > 16) {
            throw new IllegalArgumentException("nBytes is greather than 16");
        }
        longToByteArray(uuid.getMostSignificantBits(), 0, bArr, i7, i8 > 8 ? 8 : i8);
        if (i8 >= 8) {
            longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i7 + 8, i8 - 8);
        }
        return bArr;
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i7) {
        if (zArr.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int length = ((zArr.length - 1) - i7) + 1;
        int iMin = Math.min(4, length);
        boolean[] zArr2 = new boolean[4];
        System.arraycopy(zArr, length - iMin, zArr2, 4 - iMin, iMin);
        if (zArr2[0]) {
            if (zArr2[1]) {
                if (zArr2[2]) {
                    return zArr2[3] ? 'f' : 'e';
                }
                return zArr2[3] ? 'd' : 'c';
            }
            if (zArr2[2]) {
                return zArr2[3] ? 'b' : 'a';
            }
            return zArr2[3] ? '9' : '8';
        }
        if (zArr2[1]) {
            if (zArr2[2]) {
                return zArr2[3] ? '7' : '6';
            }
            return zArr2[3] ? '5' : '4';
        }
        if (zArr2[2]) {
            return zArr2[3] ? '3' : '2';
        }
        return zArr2[3] ? '1' : '0';
    }

    public static char binaryToHexDigit(boolean[] zArr, int i7) {
        if (zArr.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int i8 = i7 + 3;
        if (zArr.length <= i8 || !zArr[i8]) {
            int i9 = i7 + 2;
            if (zArr.length <= i9 || !zArr[i9]) {
                int i10 = i7 + 1;
                if (zArr.length <= i10 || !zArr[i10]) {
                    return zArr[i7] ? '1' : '0';
                }
                return zArr[i7] ? '3' : '2';
            }
            int i11 = i7 + 1;
            if (zArr.length <= i11 || !zArr[i11]) {
                return zArr[i7] ? '5' : '4';
            }
            return zArr[i7] ? '7' : '6';
        }
        int i12 = i7 + 2;
        if (zArr.length <= i12 || !zArr[i12]) {
            int i13 = i7 + 1;
            if (zArr.length <= i13 || !zArr[i13]) {
                return zArr[i7] ? '9' : '8';
            }
            return zArr[i7] ? 'b' : 'a';
        }
        int i14 = i7 + 1;
        if (zArr.length <= i14 || !zArr[i14]) {
            return zArr[i7] ? 'd' : 'c';
        }
        return zArr[i7] ? 'f' : 'e';
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i7) {
        if (zArr.length > 8) {
            throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
        }
        if (zArr.length - i7 < 4) {
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i7);
        }
        if (zArr[i7 + 3]) {
            if (zArr[i7 + 2]) {
                if (zArr[i7 + 1]) {
                    return zArr[i7] ? 'f' : '7';
                }
                return zArr[i7] ? 'b' : '3';
            }
            if (zArr[i7 + 1]) {
                return zArr[i7] ? 'd' : '5';
            }
            return zArr[i7] ? '9' : '1';
        }
        if (zArr[i7 + 2]) {
            if (zArr[i7 + 1]) {
                return zArr[i7] ? 'e' : '6';
            }
            return zArr[i7] ? 'a' : '2';
        }
        if (zArr[i7 + 1]) {
            return zArr[i7] ? 'c' : '4';
        }
        return zArr[i7] ? '8' : '0';
    }
}
