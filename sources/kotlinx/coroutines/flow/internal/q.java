package kotlinx.coroutines.flow.internal;

import kotlin.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    @a1
    public static final int a(int i7) {
        if (i7 >= 0) {
            return i7;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void b(@a7.d a aVar, @a7.d kotlinx.coroutines.flow.j<?> jVar) {
        if (aVar.a() != jVar) {
            throw aVar;
        }
    }
}
