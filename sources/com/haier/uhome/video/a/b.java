package com.haier.uhome.video.a;

import com.haier.uhome.video.bean.DeviceImgReqBean;
import com.haier.uhome.video.bean.DeviceImgRespBean;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static byte[] a(int i7, int i8) {
        byte[] bArr = new byte[i8];
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.asIntBuffer().put(i7);
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = 4 - i8;
            if (i9 < i10) {
                byteBufferAllocate.get();
            } else {
                bArr[i9 - i10] = byteBufferAllocate.get();
            }
        }
        return bArr;
    }

    public static DeviceImgRespBean b(byte[] bArr) {
        DeviceImgRespBean deviceImgRespBean = new DeviceImgRespBean();
        if (a(a(bArr, 0, 2)) != 256) {
            System.out.println("protocolVers error");
            return null;
        }
        if (a(a(bArr, 2, 2)) != 258) {
            System.out.println("messageType error");
            return null;
        }
        a(a(bArr, 4, 4));
        a(a(bArr, 8, 4));
        if (a(a(bArr, 12, 4)) != bArr.length - 16) {
            System.out.println("messageType error");
            return null;
        }
        deviceImgRespBean.imgID = a(a(bArr, 16, 4));
        deviceImgRespBean.sn = a(a(bArr, 20, 4));
        deviceImgRespBean.errorCode = a(a(bArr, 24, 4));
        deviceImgRespBean.imgSize = a(a(bArr, 28, 4));
        deviceImgRespBean.segmentNum = a(a(bArr, 32, 2));
        deviceImgRespBean.segmentId = a(a(bArr, 34, 2));
        int iA = a(a(bArr, 36, 4));
        deviceImgRespBean.segmentLen = iA;
        deviceImgRespBean.segment = a(bArr, 40, iA);
        return deviceImgRespBean;
    }

    public static int a(byte[] bArr) {
        if (bArr == null || bArr.length == 0 || bArr.length > 4) {
            return 0;
        }
        int length = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            length |= (bArr[i7] & 255) << (((bArr.length - i7) - 1) * 8);
        }
        return length;
    }

    public static String a(byte[] bArr, boolean z7) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b8 : bArr) {
            String hexString = Integer.toHexString(b8 & 255);
            if (z7) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static byte a(char c8) {
        return (byte) "0123456789ABCDEF".indexOf(c8);
    }

    public static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * 2;
            bArr[i7] = (byte) (a(charArray[i8 + 1]) | (a(charArray[i8]) << 4));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, int i7, int i8) {
        if (i7 + i8 > bArr.length && (i8 = bArr.length - i7) <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            bArr2[i9] = bArr[i9 + i7];
        }
        return bArr2;
    }

    public static void a(byte[] bArr, int i7, byte[] bArr2, int i8) {
        if (bArr != null && i7 + i8 <= bArr.length) {
            if (bArr2 == null) {
                for (int i9 = 0; i9 < i8; i9++) {
                    bArr[i9 + i7] = 0;
                }
                return;
            }
            for (int i10 = 0; i10 < i8; i10++) {
                if (i10 >= bArr2.length) {
                    bArr[i10 + i7] = 0;
                } else {
                    bArr[i10 + i7] = bArr2[i10];
                }
            }
        }
    }

    public static byte[] a(DeviceImgReqBean deviceImgReqBean) {
        byte[] bArr = new byte[30];
        a(bArr, 0, a(256, 2), 2);
        a(bArr, 2, a(257, 2), 2);
        a(bArr, 4, a(0, 4), 4);
        a(bArr, 8, a(0, 4), 4);
        a(bArr, 12, a(14, 4), 4);
        a(bArr, 16, a(deviceImgReqBean.imgID, 4), 4);
        a(bArr, 20, a(deviceImgReqBean.sn, 4), 4);
        a(bArr, 24, a(deviceImgReqBean.segmentLenMax, 4), 4);
        a(bArr, 28, a(deviceImgReqBean.segmentId, 2), 2);
        return bArr;
    }
}
