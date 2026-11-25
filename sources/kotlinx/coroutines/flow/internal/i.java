package kotlinx.coroutines.flow.internal;

import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class i<T> extends h<T, T> {
    public /* synthetic */ i(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.g gVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, kotlin.jvm.internal.w wVar) {
        this(iVar, (i8 & 2) != 0 ? kotlin.coroutines.i.f34682a : gVar, (i8 & 4) != 0 ? -3 : i7, (i8 & 8) != 0 ? kotlinx.coroutines.channels.m.SUSPEND : mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected e<T> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return new i(this.f36298d, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    public kotlinx.coroutines.flow.i<T> k() {
        return (kotlinx.coroutines.flow.i<T>) this.f36298d;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.internal.h
    @a7.e
    protected Object u(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objA = this.f36298d.a((kotlinx.coroutines.flow.j<? super S>) jVar, dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    public i(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(iVar, gVar, i7, mVar);
    }
}
