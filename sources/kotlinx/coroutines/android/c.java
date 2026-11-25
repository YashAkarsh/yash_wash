package kotlinx.coroutines.android;

import kotlin.coroutines.g;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.l2;
import kotlin.m;
import kotlinx.coroutines.a3;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.q1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a3 implements f1 {
    public /* synthetic */ c(w wVar) {
        this();
    }

    @a7.d
    public q1 p0(long j7, @a7.d Runnable runnable, @a7.d g gVar) {
        return f1.a.b(this, j7, runnable, gVar);
    }

    @a7.d
    public abstract c q1();

    @Override // kotlinx.coroutines.f1
    @k(level = m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @a7.e
    public Object s0(long j7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return f1.a.a(this, j7, dVar);
    }

    private c() {
    }
}
