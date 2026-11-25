package kotlinx.coroutines.selects;

import i5.l;
import kotlin.jvm.internal.i0;
import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final Object f37221a = new r0("NOT_SELECTED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final Object f37222b = new r0("ALREADY_SELECTED");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final Object f37223c = new r0("UNDECIDED");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final Object f37224d = new r0("RESUMED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final i f37225e = new i();

    @a7.d
    public static final Object d() {
        return f37222b;
    }

    public static /* synthetic */ void e() {
    }

    @a7.d
    public static final Object f() {
        return f37221a;
    }

    public static /* synthetic */ void g() {
    }

    private static /* synthetic */ void h() {
    }

    private static /* synthetic */ void i() {
    }

    private static /* synthetic */ void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d2
    public static final <R> void k(@a7.d a<? super R> aVar, long j7, @a7.d l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
        aVar.Q(g1.e(j7), lVar);
    }

    @a7.e
    public static final <R> Object l(@a7.d l<? super a<? super R>, l2> lVar, @a7.d kotlin.coroutines.d<? super R> dVar) {
        b bVar = new b(dVar);
        try {
            lVar.z(bVar);
        } catch (Throwable th) {
            bVar.e1(th);
        }
        Object objD1 = bVar.d1();
        if (objD1 == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objD1;
    }

    private static final <R> Object m(l<? super a<? super R>, l2> lVar, kotlin.coroutines.d<? super R> dVar) {
        i0.e(0);
        b bVar = new b(dVar);
        try {
            lVar.z(bVar);
        } catch (Throwable th) {
            bVar.e1(th);
        }
        Object objD1 = bVar.d1();
        if (objD1 == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        i0.e(1);
        return objD1;
    }
}
