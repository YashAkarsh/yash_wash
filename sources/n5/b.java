package n5;

import a7.d;
import h5.h;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "TimingKt")
public final class b {
    public static final long a(@d i5.a<l2> block) {
        l0.p(block, "block");
        long jNanoTime = System.nanoTime();
        block.invoke();
        return System.nanoTime() - jNanoTime;
    }

    public static final long b(@d i5.a<l2> block) {
        l0.p(block, "block");
        long jCurrentTimeMillis = System.currentTimeMillis();
        block.invoke();
        return System.currentTimeMillis() - jCurrentTimeMillis;
    }
}
