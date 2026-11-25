package kotlinx.coroutines.internal;

import kotlinx.coroutines.t3;

/* JADX INFO: loaded from: classes3.dex */
final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlin.coroutines.g f36966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final Object[] f36967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final t3<Object>[] f36968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36969d;

    public c1(@a7.d kotlin.coroutines.g gVar, int i7) {
        this.f36966a = gVar;
        this.f36967b = new Object[i7];
        this.f36968c = new t3[i7];
    }

    public final void a(@a7.d t3<?> t3Var, @a7.e Object obj) {
        Object[] objArr = this.f36967b;
        int i7 = this.f36969d;
        objArr[i7] = obj;
        t3<Object>[] t3VarArr = this.f36968c;
        this.f36969d = i7 + 1;
        t3VarArr[i7] = t3Var;
    }

    public final void b(@a7.d kotlin.coroutines.g gVar) {
        int length = this.f36968c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i7 = length - 1;
            t3<Object> t3Var = this.f36968c[length];
            kotlin.jvm.internal.l0.m(t3Var);
            t3Var.v0(gVar, this.f36967b[length]);
            if (i7 < 0) {
                return;
            } else {
                length = i7;
            }
        }
    }
}
