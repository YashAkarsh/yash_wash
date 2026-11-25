package org.apache.commons.lang3.math;

import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes3.dex */
public class IEEE754rUtils {
    public static double max(double... dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
        double dMax = dArr[0];
        for (int i7 = 1; i7 < dArr.length; i7++) {
            dMax = max(dArr[i7], dMax);
        }
        return dMax;
    }

    public static double min(double... dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
        double dMin = dArr[0];
        for (int i7 = 1; i7 < dArr.length; i7++) {
            dMin = min(dArr[i7], dMin);
        }
        return dMin;
    }

    public static float max(float... fArr) {
        if (fArr != null) {
            Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
            float fMax = fArr[0];
            for (int i7 = 1; i7 < fArr.length; i7++) {
                fMax = max(fArr[i7], fMax);
            }
            return fMax;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float min(float... fArr) {
        if (fArr != null) {
            Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
            float fMin = fArr[0];
            for (int i7 = 1; i7 < fArr.length; i7++) {
                fMin = min(fArr[i7], fMin);
            }
            return fMin;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double max(double d8, double d9, double d10) {
        return max(max(d8, d9), d10);
    }

    public static double min(double d8, double d9, double d10) {
        return min(min(d8, d9), d10);
    }

    public static double max(double d8, double d9) {
        if (Double.isNaN(d8)) {
            return d9;
        }
        return Double.isNaN(d9) ? d8 : Math.max(d8, d9);
    }

    public static double min(double d8, double d9) {
        if (Double.isNaN(d8)) {
            return d9;
        }
        return Double.isNaN(d9) ? d8 : Math.min(d8, d9);
    }

    public static float max(float f8, float f9, float f10) {
        return max(max(f8, f9), f10);
    }

    public static float min(float f8, float f9, float f10) {
        return min(min(f8, f9), f10);
    }

    public static float max(float f8, float f9) {
        if (Float.isNaN(f8)) {
            return f9;
        }
        return Float.isNaN(f9) ? f8 : Math.max(f8, f9);
    }

    public static float min(float f8, float f9) {
        if (Float.isNaN(f8)) {
            return f9;
        }
        return Float.isNaN(f9) ? f8 : Math.min(f8, f9);
    }
}
