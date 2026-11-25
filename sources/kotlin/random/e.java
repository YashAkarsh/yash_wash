package kotlin.random;

import java.util.Random;
import kotlin.g1;
import kotlin.internal.m;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @a7.d
    @g1(version = "1.3")
    public static final Random a(@a7.d f fVar) {
        Random randomR;
        l0.p(fVar, "<this>");
        a aVar = fVar instanceof a ? (a) fVar : null;
        return (aVar == null || (randomR = aVar.r()) == null) ? new c(fVar) : randomR;
    }

    @a7.d
    @g1(version = "1.3")
    public static final f b(@a7.d Random random) {
        f fVarA;
        l0.p(random, "<this>");
        c cVar = random instanceof c ? (c) random : null;
        return (cVar == null || (fVarA = cVar.a()) == null) ? new d(random) : fVarA;
    }

    @kotlin.internal.f
    private static final f c() {
        return m.f34747a.b();
    }

    public static final double d(int i7, int i8) {
        return ((((long) i7) << 27) + ((long) i8)) / 9.007199254740992E15d;
    }
}
