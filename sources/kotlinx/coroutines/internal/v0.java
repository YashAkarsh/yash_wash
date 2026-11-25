package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v0 {
    public static final int a(@a7.d String str, int i7, int i8, int i9) {
        return (int) t0.c(str, i7, i8, i9);
    }

    public static final long b(@a7.d String str, long j7, long j8, long j9) {
        String strD = t0.d(str);
        if (strD == null) {
            return j7;
        }
        Long lZ0 = kotlin.text.a0.Z0(strD);
        if (lZ0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lZ0.longValue();
        boolean z7 = false;
        if (j8 <= jLongValue && jLongValue <= j9) {
            z7 = true;
        }
        if (z7) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j8 + ".." + j9 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final boolean c(@a7.d String str, boolean z7) {
        String strD = t0.d(str);
        return strD == null ? z7 : Boolean.parseBoolean(strD);
    }

    public static /* synthetic */ int d(String str, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i8 = 1;
        }
        if ((i10 & 8) != 0) {
            i9 = Integer.MAX_VALUE;
        }
        return t0.b(str, i7, i8, i9);
    }

    public static /* synthetic */ long e(String str, long j7, long j8, long j9, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            j8 = 1;
        }
        long j10 = j8;
        if ((i7 & 8) != 0) {
            j9 = Long.MAX_VALUE;
        }
        return t0.c(str, j7, j10, j9);
    }
}
