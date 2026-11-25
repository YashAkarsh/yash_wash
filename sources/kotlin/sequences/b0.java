package kotlin.sequences;

import java.util.Iterator;
import kotlin.a2;
import kotlin.g1;
import kotlin.g2;
import kotlin.jvm.internal.l0;
import kotlin.q2;
import kotlin.s1;
import kotlin.w1;

/* JADX INFO: loaded from: classes2.dex */
class b0 {
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfUByte")
    public static final int a(@a7.d m<s1> mVar) {
        l0.p(mVar, "<this>");
        Iterator<s1> it = mVar.iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH = w1.h(iH + w1.h(it.next().e0() & 255));
        }
        return iH;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfUInt")
    public static final int b(@a7.d m<w1> mVar) {
        l0.p(mVar, "<this>");
        Iterator<w1> it = mVar.iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH = w1.h(iH + it.next().g0());
        }
        return iH;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfULong")
    public static final long c(@a7.d m<a2> mVar) {
        l0.p(mVar, "<this>");
        Iterator<a2> it = mVar.iterator();
        long jH = 0;
        while (it.hasNext()) {
            jH = a2.h(jH + it.next().g0());
        }
        return jH;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfUShort")
    public static final int d(@a7.d m<g2> mVar) {
        l0.p(mVar, "<this>");
        Iterator<g2> it = mVar.iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH = w1.h(iH + w1.h(it.next().e0() & g2.f34732d));
        }
        return iH;
    }
}
