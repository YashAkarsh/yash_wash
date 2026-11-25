package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class q extends d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final boolean f2933q = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    k f2934p;

    q(String str) {
        this.f2787a = str;
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i7 = 0;
        while (iIndexOf2 != -1) {
            dArr[i7] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i7++;
        }
        dArr[i7] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        this.f2934p = e(Arrays.copyOf(dArr, i7 + 1));
    }

    private static k d(String str) {
        String[] strArrSplit = str.split("\\s+");
        int length = strArrSplit.length;
        double[] dArr = new double[length];
        for (int i7 = 0; i7 < length; i7++) {
            dArr[i7] = Double.parseDouble(strArrSplit[i7]);
        }
        return e(dArr);
    }

    private static k e(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d8 = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i7 = 0; i7 < dArr.length; i7++) {
            double d9 = dArr[i7];
            int i8 = i7 + length2;
            dArr2[i8][0] = d9;
            double d10 = ((double) i7) * d8;
            dArr3[i8] = d10;
            if (i7 > 0) {
                int i9 = (length2 * 2) + i7;
                dArr2[i9][0] = d9 + 1.0d;
                dArr3[i9] = d10 + 1.0d;
                int i10 = i7 - 1;
                dArr2[i10][0] = (d9 - 1.0d) - d8;
                dArr3[i10] = (d10 - 1.0d) - d8;
            }
        }
        k kVar = new k(dArr3, dArr2);
        System.out.println(" 0 " + kVar.c(0.0d, 0));
        System.out.println(" 1 " + kVar.c(1.0d, 0));
        return kVar;
    }

    @Override // androidx.constraintlayout.core.motion.utils.d
    public double a(double d8) {
        return this.f2934p.c(d8, 0);
    }

    @Override // androidx.constraintlayout.core.motion.utils.d
    public double b(double d8) {
        return this.f2934p.f(d8, 0);
    }
}
