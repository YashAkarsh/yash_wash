package p5;

import h5.h;
import java.time.Duration;
import kotlin.g1;
import kotlin.internal.f;
import kotlin.jvm.internal.l0;
import kotlin.q2;
import kotlin.time.g;
import kotlin.time.k;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "DurationConversionsJDK8Kt")
public final class d {
    @g1(version = i2.a.f34096f)
    @q2(markerClass = {k.class})
    @f
    private static final Duration a(long j7) {
        Duration durationOfSeconds = Duration.ofSeconds(kotlin.time.d.L(j7), kotlin.time.d.P(j7));
        l0.o(durationOfSeconds, "toJavaDuration-LRDsOJo");
        return durationOfSeconds;
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {k.class})
    @f
    private static final long b(Duration duration) {
        l0.p(duration, "<this>");
        return kotlin.time.d.d0(kotlin.time.f.n0(duration.getSeconds(), g.SECONDS), kotlin.time.f.m0(duration.getNano(), g.NANOSECONDS));
    }
}
