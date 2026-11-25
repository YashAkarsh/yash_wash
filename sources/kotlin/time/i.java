package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.g1;
import kotlin.j0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35476a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            iArr[TimeUnit.SECONDS.ordinal()] = 4;
            iArr[TimeUnit.MINUTES.ordinal()] = 5;
            iArr[TimeUnit.HOURS.ordinal()] = 6;
            iArr[TimeUnit.DAYS.ordinal()] = 7;
            f35476a = iArr;
        }
    }

    @g1(version = "1.3")
    public static final double a(double d8, @a7.d g sourceUnit, @a7.d g targetUnit) {
        l0.p(sourceUnit, "sourceUnit");
        l0.p(targetUnit, "targetUnit");
        long jConvert = targetUnit.b().convert(1L, sourceUnit.b());
        return jConvert > 0 ? d8 * jConvert : d8 / sourceUnit.b().convert(1L, targetUnit.b());
    }

    @g1(version = "1.5")
    public static final long b(long j7, @a7.d g sourceUnit, @a7.d g targetUnit) {
        l0.p(sourceUnit, "sourceUnit");
        l0.p(targetUnit, "targetUnit");
        return targetUnit.b().convert(j7, sourceUnit.b());
    }

    @g1(version = "1.5")
    public static final long c(long j7, @a7.d g sourceUnit, @a7.d g targetUnit) {
        l0.p(sourceUnit, "sourceUnit");
        l0.p(targetUnit, "targetUnit");
        return targetUnit.b().convert(j7, sourceUnit.b());
    }

    @a7.d
    @g1(version = i2.a.f34096f)
    @k
    public static final g d(@a7.d TimeUnit timeUnit) {
        l0.p(timeUnit, "<this>");
        switch (a.f35476a[timeUnit.ordinal()]) {
            case 1:
                return g.NANOSECONDS;
            case 2:
                return g.MICROSECONDS;
            case 3:
                return g.MILLISECONDS;
            case 4:
                return g.SECONDS;
            case 5:
                return g.MINUTES;
            case 6:
                return g.HOURS;
            case 7:
                return g.DAYS;
            default:
                throw new j0();
        }
    }

    @a7.d
    @g1(version = i2.a.f34096f)
    @k
    public static final TimeUnit e(@a7.d g gVar) {
        l0.p(gVar, "<this>");
        return gVar.b();
    }
}
