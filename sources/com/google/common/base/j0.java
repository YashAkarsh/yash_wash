package com.google.common.base;

import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
@s1.c
final class j0 extends e.v {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f19431f = 1023;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f19432g = -862048943;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f19433h = 461845907;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final double f19434i = 0.5d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f19435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19437e;

    private j0(char[] cArr, long j7, boolean z7, String str) {
        super(str);
        this.f19435c = cArr;
        this.f19437e = j7;
        this.f19436d = z7;
    }

    private boolean Y(int i7) {
        return 1 == ((this.f19437e >> i7) & 1);
    }

    @s1.d
    static int Z(int i7) {
        if (i7 == 1) {
            return 2;
        }
        int iHighestOneBit = Integer.highestOneBit(i7 - 1) << 1;
        while (((double) iHighestOneBit) * f19434i < i7) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    static e a0(BitSet bitSet, String str) {
        int i7;
        int iCardinality = bitSet.cardinality();
        boolean z7 = bitSet.get(0);
        int iZ = Z(iCardinality);
        char[] cArr = new char[iZ];
        int i8 = iZ - 1;
        int iNextSetBit = bitSet.nextSetBit(0);
        long j7 = 0;
        while (iNextSetBit != -1) {
            long j8 = (1 << iNextSetBit) | j7;
            int iB0 = b0(iNextSetBit);
            while (true) {
                i7 = iB0 & i8;
                if (cArr[i7] == 0) {
                    break;
                }
                iB0 = i7 + 1;
            }
            cArr[i7] = (char) iNextSetBit;
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
            j7 = j8;
        }
        return new j0(cArr, j7, z7, str);
    }

    static int b0(int i7) {
        return Integer.rotateLeft(i7 * f19432g, 15) * f19433h;
    }

    @Override // com.google.common.base.e
    public boolean B(char c8) {
        if (c8 == 0) {
            return this.f19436d;
        }
        if (!Y(c8)) {
            return false;
        }
        int length = this.f19435c.length - 1;
        int iB0 = b0(c8) & length;
        int i7 = iB0;
        do {
            char c9 = this.f19435c[i7];
            if (c9 == 0) {
                return false;
            }
            if (c9 == c8) {
                return true;
            }
            i7 = (i7 + 1) & length;
        } while (i7 != iB0);
        return false;
    }

    @Override // com.google.common.base.e
    void Q(BitSet bitSet) {
        if (this.f19436d) {
            bitSet.set(0);
        }
        for (char c8 : this.f19435c) {
            if (c8 != 0) {
                bitSet.set(c8);
            }
        }
    }
}
