package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37064a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f37065b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f37066c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f37067d = 3;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a<T> extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super T>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f37068e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f37069f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i5.a<T> f37070g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(i5.a<? extends T> aVar, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f37070g = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<kotlin.l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f37070g, dVar);
            aVar.f37069f = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.coroutines.intrinsics.d.h();
            if (this.f37068e != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.e1.n(obj);
            return k2.d(((v0) this.f37069f).D(), this.f37070g);
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super T> dVar) {
            return ((a) D(v0Var, dVar)).R(kotlin.l2.f34958a);
        }
    }

    @a7.e
    public static final <T> Object b(@a7.d kotlin.coroutines.g gVar, @a7.d i5.a<? extends T> aVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return j.h(gVar, new a(aVar, null), dVar);
    }

    public static /* synthetic */ Object c(kotlin.coroutines.g gVar, i5.a aVar, kotlin.coroutines.d dVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        return b(gVar, aVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T d(kotlin.coroutines.g gVar, i5.a<? extends T> aVar) throws Throwable {
        try {
            y3 y3Var = new y3(s2.B(gVar));
            y3Var.f();
            try {
                return aVar.invoke();
            } finally {
                y3Var.b();
            }
        } catch (InterruptedException e8) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e8);
        }
    }
}
