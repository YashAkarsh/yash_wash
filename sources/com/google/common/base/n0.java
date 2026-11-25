package com.google.common.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@s1.b(emulated = true)
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s0 f19500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f19502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19503d;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19504a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f19504a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19504a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19504a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19504a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19504a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19504a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19504a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    n0() {
        this.f19500a = s0.b();
    }

    private static String a(TimeUnit timeUnit) {
        switch (a.f19504a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private static TimeUnit b(long j7) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j7, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j7, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j7, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j7, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j7, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j7, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static n0 c() {
        return new n0().l();
    }

    public static n0 d(s0 s0Var) {
        return new n0(s0Var).l();
    }

    public static n0 e() {
        return new n0();
    }

    public static n0 f(s0 s0Var) {
        return new n0(s0Var);
    }

    private long i() {
        return this.f19501b ? (this.f19500a.a() - this.f19503d) + this.f19502c : this.f19502c;
    }

    public long g(TimeUnit timeUnit) {
        return timeUnit.convert(i(), TimeUnit.NANOSECONDS);
    }

    @s1.c
    public Duration h() {
        return Duration.ofNanos(i());
    }

    public boolean j() {
        return this.f19501b;
    }

    @u1.a
    public n0 k() {
        this.f19502c = 0L;
        this.f19501b = false;
        return this;
    }

    @u1.a
    public n0 l() {
        e0.h0(!this.f19501b, "This stopwatch is already running.");
        this.f19501b = true;
        this.f19503d = this.f19500a.a();
        return this;
    }

    @u1.a
    public n0 m() {
        long jA = this.f19500a.a();
        e0.h0(this.f19501b, "This stopwatch is already stopped.");
        this.f19501b = false;
        this.f19502c += jA - this.f19503d;
        return this;
    }

    public String toString() {
        long jI = i();
        TimeUnit timeUnitB = b(jI);
        return d0.c(jI / TimeUnit.NANOSECONDS.convert(1L, timeUnitB)) + " " + a(timeUnitB);
    }

    n0(s0 s0Var) {
        this.f19500a = (s0) e0.F(s0Var, "ticker");
    }
}
