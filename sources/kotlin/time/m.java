package kotlin.time;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    @g1(version = "1.3")
    @k
    public static final long a(@a7.d i5.a<l2> block) {
        l0.p(block, "block");
        long jB = r.b.f35483b.b();
        block.invoke();
        return r.b.a.h(jB);
    }

    @g1(version = "1.7")
    @k
    public static final long b(@a7.d r.b bVar, @a7.d i5.a<l2> block) {
        l0.p(bVar, "<this>");
        l0.p(block, "block");
        long jB = bVar.b();
        block.invoke();
        return r.b.a.h(jB);
    }

    @g1(version = "1.3")
    @k
    public static final long c(@a7.d r rVar, @a7.d i5.a<l2> block) {
        l0.p(rVar, "<this>");
        l0.p(block, "block");
        q qVarA = rVar.a();
        block.invoke();
        return qVarA.c();
    }

    @a7.d
    @g1(version = "1.3")
    @k
    public static final <T> t<T> d(@a7.d i5.a<? extends T> block) {
        l0.p(block, "block");
        return new t<>(block.invoke(), r.b.a.h(r.b.f35483b.b()), null);
    }

    @a7.d
    @g1(version = "1.7")
    @k
    public static final <T> t<T> e(@a7.d r.b bVar, @a7.d i5.a<? extends T> block) {
        l0.p(bVar, "<this>");
        l0.p(block, "block");
        return new t<>(block.invoke(), r.b.a.h(bVar.b()), null);
    }

    @a7.d
    @g1(version = "1.3")
    @k
    public static final <T> t<T> f(@a7.d r rVar, @a7.d i5.a<? extends T> block) {
        l0.p(rVar, "<this>");
        l0.p(block, "block");
        return new t<>(block.invoke(), rVar.a().c(), null);
    }
}
