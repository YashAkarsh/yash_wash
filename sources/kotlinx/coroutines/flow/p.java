package kotlinx.coroutines.flow;

import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class p {
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ i a(i iVar, int i7) {
        return d(iVar, i7, null, 2, null);
    }

    @a7.d
    public static final <T> i<T> b(@a7.d i<? extends T> iVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        int i8;
        kotlinx.coroutines.channels.m mVar2;
        boolean z7 = true;
        if (!(i7 >= 0 || i7 == -2 || i7 == -1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", Integer.valueOf(i7)).toString());
        }
        if (i7 == -1 && mVar != kotlinx.coroutines.channels.m.SUSPEND) {
            z7 = false;
        }
        if (!z7) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i7 == -1) {
            mVar2 = kotlinx.coroutines.channels.m.DROP_OLDEST;
            i8 = 0;
        } else {
            i8 = i7;
            mVar2 = mVar;
        }
        return iVar instanceof kotlinx.coroutines.flow.internal.r ? kotlinx.coroutines.flow.internal.r.a.a((kotlinx.coroutines.flow.internal.r) iVar, null, i8, mVar2, 1, null) : new kotlinx.coroutines.flow.internal.i(iVar, null, i8, mVar2, 2, null);
    }

    public static /* synthetic */ i c(i iVar, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = -2;
        }
        return a(iVar, i7);
    }

    public static /* synthetic */ i d(i iVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = -2;
        }
        if ((i8 & 2) != 0) {
            mVar = kotlinx.coroutines.channels.m.SUSPEND;
        }
        return k.o(iVar, i7, mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T> i<T> e(@a7.d i<? extends T> iVar) {
        return iVar instanceof c ? iVar : new d(iVar);
    }

    private static final void f(kotlin.coroutines.g gVar) {
        if (!(gVar.get(o2.f37103s0) == null)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("Flow context cannot contain job in it. Had ", gVar).toString());
        }
    }

    @a7.d
    public static final <T> i<T> g(@a7.d i<? extends T> iVar) {
        return d(iVar, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T> i<T> h(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar) {
        f(gVar);
        if (kotlin.jvm.internal.l0.g(gVar, kotlin.coroutines.i.f34682a)) {
            return iVar;
        }
        return iVar instanceof kotlinx.coroutines.flow.internal.r ? kotlinx.coroutines.flow.internal.r.a.a((kotlinx.coroutines.flow.internal.r) iVar, gVar, 0, null, 6, null) : new kotlinx.coroutines.flow.internal.i(iVar, gVar, 0, null, 12, null);
    }
}
