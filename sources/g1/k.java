package g1;

import android.os.SystemClock;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f33991a = new k();

    private k() {
    }

    @c1.a
    @m0
    public static g e() {
        return f33991a;
    }

    @Override // g1.g
    public final long a() {
        return System.nanoTime();
    }

    @Override // g1.g
    public final long b() {
        return System.currentTimeMillis();
    }

    @Override // g1.g
    public final long c() {
        return SystemClock.currentThreadTimeMillis();
    }

    @Override // g1.g
    public final long d() {
        return SystemClock.elapsedRealtime();
    }
}
