package m5;

import a7.d;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends kotlin.random.a {
    @Override // kotlin.random.f
    public double i(double d8) {
        return ThreadLocalRandom.current().nextDouble(d8);
    }

    @Override // kotlin.random.f
    public int n(int i7, int i8) {
        return ThreadLocalRandom.current().nextInt(i7, i8);
    }

    @Override // kotlin.random.f
    public long p(long j7) {
        return ThreadLocalRandom.current().nextLong(j7);
    }

    @Override // kotlin.random.f
    public long q(long j7, long j8) {
        return ThreadLocalRandom.current().nextLong(j7, j8);
    }

    @Override // kotlin.random.a
    @d
    public Random r() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        l0.o(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
