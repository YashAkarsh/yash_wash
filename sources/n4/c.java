package n4;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static byte[] a(byte b8) {
        byte[] bArr = new byte[b8];
        for (int i7 = 0; i7 < b8; i7++) {
            bArr[i7] = (byte) (Math.random() * 256.0d);
        }
        return bArr;
    }

    public static int b() {
        int iRandom = (int) (Math.random() * 100.0d);
        k4.b.e("randomUnicast = " + iRandom);
        return iRandom;
    }
}
