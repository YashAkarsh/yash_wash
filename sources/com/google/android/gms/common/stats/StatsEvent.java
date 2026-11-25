package com.google.android.gms.common.stats;

import c.m0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @c1.a
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c1.a
        public static final int f15959a = 7;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c1.a
        public static final int f15960b = 8;
    }

    public abstract int K();

    public abstract long Q();

    public abstract long p0();

    @m0
    public abstract String r0();

    @m0
    public final String toString() {
        long jP0 = p0();
        int iK = K();
        long jQ = Q();
        String strR0 = r0();
        StringBuilder sb = new StringBuilder(strR0.length() + 53);
        sb.append(jP0);
        sb.append("\t");
        sb.append(iK);
        sb.append("\t");
        sb.append(jQ);
        sb.append(strR0);
        return sb.toString();
    }
}
