package m4;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static String a(int i7) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i7; i8++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return sb.toString();
    }

    public static String b(long j7) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < j7; i7++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return sb.toString();
    }

    public static String c(int i7) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i7; i8++) {
            sb.append("0123456789".charAt(random.nextInt(10)));
        }
        return sb.toString();
    }
}
