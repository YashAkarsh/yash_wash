package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final kotlinx.coroutines.internal.r0 f36434a = new kotlinx.coroutines.internal.r0("NO_VALUE");

    @a7.d
    public static final <T> d0<T> a(int i7, int i8, @a7.d kotlinx.coroutines.channels.m mVar) {
        boolean z7 = true;
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("replay cannot be negative, but was ", Integer.valueOf(i7)).toString());
        }
        if (!(i8 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("extraBufferCapacity cannot be negative, but was ", Integer.valueOf(i8)).toString());
        }
        if (i7 <= 0 && i8 <= 0 && mVar != kotlinx.coroutines.channels.m.SUSPEND) {
            z7 = false;
        }
        if (!z7) {
            throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ", mVar).toString());
        }
        int i9 = i8 + i7;
        if (i9 < 0) {
            i9 = Integer.MAX_VALUE;
        }
        return new j0(i7, i9, mVar);
    }

    public static /* synthetic */ d0 b(int i7, int i8, kotlinx.coroutines.channels.m mVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            mVar = kotlinx.coroutines.channels.m.SUSPEND;
        }
        return a(i7, i8, mVar);
    }

    @a7.d
    public static final <T> i<T> e(@a7.d i0<? extends T> i0Var, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return ((i7 == 0 || i7 == -3) && mVar == kotlinx.coroutines.channels.m.SUSPEND) ? i0Var : new kotlinx.coroutines.flow.internal.i(i0Var, gVar, i7, mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j7) {
        return objArr[((int) j7) & (objArr.length - 1)];
    }

    public static /* synthetic */ void g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Object[] objArr, long j7, Object obj) {
        objArr[((int) j7) & (objArr.length - 1)] = obj;
    }
}
