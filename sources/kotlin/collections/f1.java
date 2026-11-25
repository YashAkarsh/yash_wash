package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class f1<E> extends c<E> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final List<E> f34524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34526d;

    /* JADX WARN: Multi-variable type inference failed */
    public f1(@a7.d List<? extends E> list) {
        kotlin.jvm.internal.l0.p(list, "list");
        this.f34524b = list;
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int a() {
        return this.f34526d;
    }

    public final void b(int i7, int i8) {
        c.f34509a.d(i7, i8, this.f34524b.size());
        this.f34525c = i7;
        this.f34526d = i8 - i7;
    }

    @Override // kotlin.collections.c, java.util.List
    public E get(int i7) {
        c.f34509a.b(i7, this.f34526d);
        return this.f34524b.get(this.f34525c + i7);
    }
}
