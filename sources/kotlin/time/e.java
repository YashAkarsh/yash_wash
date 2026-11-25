package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f35461a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final ThreadLocal<DecimalFormat>[] f35462b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i7 = 0; i7 < 4; i7++) {
            threadLocalArr[i7] = new ThreadLocal<>();
        }
        f35462b = threadLocalArr;
    }

    private static final DecimalFormat a(int i7) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i7 > 0) {
            decimalFormat.setMinimumFractionDigits(i7);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @a7.d
    public static final String b(double d8, int i7) {
        DecimalFormat decimalFormatA;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f35462b;
        if (i7 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i7];
            DecimalFormat decimalFormatA2 = threadLocal.get();
            if (decimalFormatA2 == null) {
                decimalFormatA2 = a(i7);
                threadLocal.set(decimalFormatA2);
            } else {
                l0.o(decimalFormatA2, "get() ?: default().also(this::set)");
            }
            decimalFormatA = decimalFormatA2;
        } else {
            decimalFormatA = a(i7);
        }
        String str = decimalFormatA.format(d8);
        l0.o(str, "format.format(value)");
        return str;
    }

    @a7.d
    public static final String c(double d8, int i7) {
        DecimalFormat decimalFormatA = a(0);
        decimalFormatA.setMaximumFractionDigits(i7);
        String str = decimalFormatA.format(d8);
        l0.o(str, "createFormatForDecimals(… }\n        .format(value)");
        return str;
    }

    public static final boolean d() {
        return f35461a;
    }
}
