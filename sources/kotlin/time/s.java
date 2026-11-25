package kotlin.time;

import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    @g1(version = "1.3")
    @kotlin.k(level = kotlin.m.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @k
    @kotlin.internal.f
    private static final int a(q qVar, q other) {
        l0.p(qVar, "<this>");
        l0.p(other, "other");
        throw new Error("Operation is disallowed.");
    }

    @g1(version = "1.3")
    @kotlin.k(level = kotlin.m.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @k
    @kotlin.internal.f
    private static final long b(q qVar, q other) {
        l0.p(qVar, "<this>");
        l0.p(other, "other");
        throw new Error("Operation is disallowed.");
    }
}
