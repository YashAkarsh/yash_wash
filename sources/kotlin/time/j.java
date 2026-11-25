package kotlin.time;

import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class j extends i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35477a;

        static {
            int[] iArr = new int[g.values().length];
            iArr[g.NANOSECONDS.ordinal()] = 1;
            iArr[g.MICROSECONDS.ordinal()] = 2;
            iArr[g.MILLISECONDS.ordinal()] = 3;
            iArr[g.SECONDS.ordinal()] = 4;
            iArr[g.MINUTES.ordinal()] = 5;
            iArr[g.HOURS.ordinal()] = 6;
            iArr[g.DAYS.ordinal()] = 7;
            f35477a = iArr;
        }
    }

    @a7.d
    @g1(version = "1.5")
    public static final g f(char c8, boolean z7) {
        if (!z7) {
            if (c8 == 'D') {
                return g.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c8);
        }
        if (c8 == 'H') {
            return g.HOURS;
        }
        if (c8 == 'M') {
            return g.MINUTES;
        }
        if (c8 == 'S') {
            return g.SECONDS;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c8);
    }

    @a7.d
    @g1(version = "1.5")
    public static final g g(@a7.d String shortName) {
        l0.p(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return g.MICROSECONDS;
                                }
                            } else if (shortName.equals("ns")) {
                                return g.NANOSECONDS;
                            }
                        } else if (shortName.equals("ms")) {
                            return g.MILLISECONDS;
                        }
                    } else if (shortName.equals("s")) {
                        return g.SECONDS;
                    }
                } else if (shortName.equals("m")) {
                    return g.MINUTES;
                }
            } else if (shortName.equals("h")) {
                return g.HOURS;
            }
        } else if (shortName.equals("d")) {
            return g.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }

    @a7.d
    @g1(version = "1.3")
    public static final String h(@a7.d g gVar) {
        l0.p(gVar, "<this>");
        switch (a.f35477a[gVar.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new IllegalStateException(("Unknown unit: " + gVar).toString());
        }
    }
}
