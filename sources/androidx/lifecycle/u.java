package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class u<T> extends w<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.arch.core.internal.b<LiveData<?>, a<?>> f8354m = new androidx.arch.core.internal.b<>();

    private static class a<V> implements x<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final LiveData<V> f8355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final x<? super V> f8356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f8357c = -1;

        a(LiveData<V> liveData, x<? super V> xVar) {
            this.f8355a = liveData;
            this.f8356b = xVar;
        }

        @Override // androidx.lifecycle.x
        public void a(@c.o0 V v7) {
            if (this.f8357c != this.f8355a.g()) {
                this.f8357c = this.f8355a.g();
                this.f8356b.a(v7);
            }
        }

        void b() {
            this.f8355a.k(this);
        }

        void c() {
            this.f8355a.o(this);
        }
    }

    @Override // androidx.lifecycle.LiveData
    @c.i
    protected void l() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f8354m.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    @Override // androidx.lifecycle.LiveData
    @c.i
    protected void m() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f8354m.iterator();
        while (it.hasNext()) {
            it.next().getValue().c();
        }
    }

    @c.j0
    public <S> void r(@c.m0 LiveData<S> liveData, @c.m0 x<? super S> xVar) {
        a<?> aVar = new a<>(liveData, xVar);
        a<?> aVarH = this.f8354m.h(liveData, aVar);
        if (aVarH != null && aVarH.f8356b != xVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (aVarH == null && h()) {
            aVar.b();
        }
    }

    @c.j0
    public <S> void s(@c.m0 LiveData<S> liveData) {
        a<?> aVarJ = this.f8354m.j(liveData);
        if (aVarJ != null) {
            aVarJ.c();
        }
    }
}
