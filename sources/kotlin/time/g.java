package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.g1;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = i2.a.f34096f)
@q2(markerClass = {k.class})
public enum g {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final TimeUnit f35475a;

    g(TimeUnit timeUnit) {
        this.f35475a = timeUnit;
    }

    @a7.d
    public final TimeUnit b() {
        return this.f35475a;
    }
}
