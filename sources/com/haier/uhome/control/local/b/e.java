package com.haier.uhome.control.local.b;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29362a = "e_";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f29365d;

    public e() {
    }

    public static String a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return str.startsWith(f29362a) ? str.replace(f29362a, "") : str;
    }

    private int[] e(String str) {
        String strA = a(str);
        if (strA == null) {
            return null;
        }
        String[] strArrSplit = strA.split("\\.");
        int[] iArr = new int[strArrSplit.length];
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            iArr[i7] = Integer.valueOf(strArrSplit[i7]).intValue();
        }
        return iArr;
    }

    public void b(String str) {
        this.f29363b = str;
    }

    public void c(String str) {
        this.f29364c = str;
    }

    public int d(String str) {
        int[] iArrE = e(str);
        if (iArrE == null || this.f29365d.length != iArrE.length) {
            return -2;
        }
        int i7 = 0;
        while (true) {
            int[] iArr = this.f29365d;
            if (i7 >= iArr.length) {
                return 0;
            }
            int i8 = iArrE[i7];
            int i9 = iArr[i7];
            if (i8 > i9) {
                return 1;
            }
            if (i8 < i9) {
                return -1;
            }
            i7++;
        }
    }

    public String toString() {
        return "OtaInfo{otaTargetVer='" + this.f29363b + "', otaFilePath='" + this.f29364c + "', softVersionArray=" + Arrays.toString(this.f29365d) + '}';
    }

    public e(String str, String str2) {
        this.f29363b = str;
        this.f29364c = str2;
        this.f29365d = e(str);
    }

    public String b() {
        return this.f29364c;
    }

    public int[] c() {
        return this.f29365d;
    }

    public String a() {
        return this.f29363b;
    }

    public void a(int[] iArr) {
        this.f29365d = iArr;
    }
}
