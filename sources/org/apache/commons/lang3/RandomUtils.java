package org.apache.commons.lang3;

import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static byte[] nextBytes(int i7) {
        Validate.isTrue(i7 >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i7];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d8, double d9) {
        Validate.isTrue(d9 >= d8, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d8 >= 0.0d, "Both range values must be non-negative.", new Object[0]);
        return d8 == d9 ? d8 : d8 + ((d9 - d8) * RANDOM.nextDouble());
    }

    public static float nextFloat(float f8, float f9) {
        Validate.isTrue(f9 >= f8, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f8 >= 0.0f, "Both range values must be non-negative.", new Object[0]);
        return f8 == f9 ? f8 : f8 + ((f9 - f8) * RANDOM.nextFloat());
    }

    public static int nextInt(int i7, int i8) {
        Validate.isTrue(i8 >= i7, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(i7 >= 0, "Both range values must be non-negative.", new Object[0]);
        return i7 == i8 ? i7 : i7 + RANDOM.nextInt(i8 - i7);
    }

    public static long nextLong(long j7, long j8) {
        Validate.isTrue(j8 >= j7, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(j7 >= 0, "Both range values must be non-negative.", new Object[0]);
        return j7 == j8 ? j7 : (long) nextDouble(j7, j8);
    }
}
