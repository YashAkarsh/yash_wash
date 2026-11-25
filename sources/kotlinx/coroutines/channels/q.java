package kotlinx.coroutines.channels;

import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ n a(int i7) {
        return d(i7, null, null, 6, null);
    }

    @a7.d
    public static final <E> n<E> b(int i7, @a7.d m mVar, @a7.e i5.l<? super E, l2> lVar) {
        if (i7 == -2) {
            return new h(mVar == m.SUSPEND ? n.f35616t0.a() : 1, mVar, lVar);
        }
        if (i7 == -1) {
            if ((mVar != m.SUSPEND ? 0 : 1) != 0) {
                return new a0(lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i7 == 0) {
            return mVar == m.SUSPEND ? new k0(lVar) : new h(1, mVar, lVar);
        }
        if (i7 != Integer.MAX_VALUE) {
            return (i7 == 1 && mVar == m.DROP_OLDEST) ? new a0(lVar) : new h(i7, mVar, lVar);
        }
        return new d0(lVar);
    }

    public static /* synthetic */ n c(int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        return a(i7);
    }

    public static /* synthetic */ n d(int i7, m mVar, i5.l lVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        if ((i8 & 2) != 0) {
            mVar = m.SUSPEND;
        }
        if ((i8 & 4) != 0) {
            lVar = null;
        }
        return b(i7, mVar, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T e(@a7.d Object obj, @a7.d i5.l<? super Throwable, ? extends T> lVar) {
        return obj instanceof r.c ? lVar.z(r.f(obj)) : obj;
    }

    @a7.d
    public static final <T> Object f(@a7.d Object obj, @a7.d i5.l<? super Throwable, l2> lVar) {
        if (obj instanceof r.a) {
            lVar.z(r.f(obj));
        }
        return obj;
    }

    @a7.d
    public static final <T> Object g(@a7.d Object obj, @a7.d i5.l<? super Throwable, l2> lVar) {
        if (obj instanceof r.c) {
            lVar.z(r.f(obj));
        }
        return obj;
    }

    @a7.d
    public static final <T> Object h(@a7.d Object obj, @a7.d i5.l<? super T, l2> lVar) {
        if (!(obj instanceof r.c)) {
            lVar.z(obj);
        }
        return obj;
    }
}
