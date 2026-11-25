package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class j1<T> extends c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final List<T> f34541b;

    /* JADX WARN: Multi-variable type inference failed */
    public j1(@a7.d List<? extends T> delegate) {
        kotlin.jvm.internal.l0.p(delegate, "delegate");
        this.f34541b = delegate;
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int a() {
        return this.f34541b.size();
    }

    @Override // kotlin.collections.c, java.util.List
    public T get(int i7) {
        return this.f34541b.get(e0.Y0(this, i7));
    }
}
