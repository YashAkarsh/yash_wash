package r5;

import a7.e;
import i5.l;
import i5.p;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.c;
import kotlin.d1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final void a(d<?> dVar, Throwable th) throws Throwable {
        d1.a aVar = d1.f34719b;
        dVar.w(d1.b(e1.a(th)));
        throw th;
    }

    private static final void b(d<?> dVar, i5.a<l2> aVar) throws Throwable {
        try {
            aVar.invoke();
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    @j2
    public static final <T> void c(@a7.d l<? super d<? super T>, ? extends Object> lVar, @a7.d d<? super T> dVar) throws Throwable {
        try {
            d dVarD = c.d(c.b(lVar, dVar));
            d1.a aVar = d1.f34719b;
            m.g(dVarD, d1.b(l2.f34958a), null, 2, null);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static final <R, T> void d(@a7.d p<? super R, ? super d<? super T>, ? extends Object> pVar, R r7, @a7.d d<? super T> dVar, @e l<? super Throwable, l2> lVar) throws Throwable {
        try {
            d dVarD = c.d(c.c(pVar, r7, dVar));
            d1.a aVar = d1.f34719b;
            m.f(dVarD, d1.b(l2.f34958a), lVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static final void e(@a7.d d<? super l2> dVar, @a7.d d<?> dVar2) throws Throwable {
        try {
            d dVarD = c.d(dVar);
            d1.a aVar = d1.f34719b;
            m.g(dVarD, d1.b(l2.f34958a), null, 2, null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static /* synthetic */ void f(p pVar, Object obj, d dVar, l lVar, int i7, Object obj2) throws Throwable {
        if ((i7 & 4) != 0) {
            lVar = null;
        }
        d(pVar, obj, dVar, lVar);
    }
}
