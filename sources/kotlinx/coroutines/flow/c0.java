package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.b1;
import kotlin.e1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.LintKt$retry$1", f = "Lint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<Throwable, kotlin.coroutines.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36236e;

        public a(kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            return new a(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.coroutines.intrinsics.d.h();
            if (this.f36236e != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1.n(obj);
            return kotlin.coroutines.jvm.internal.b.a(true);
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d Throwable th, @a7.e kotlin.coroutines.d<? super Boolean> dVar) {
            return ((a) D(th, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @b1(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    public static final void a(@a7.d j<?> jVar, @a7.e CancellationException cancellationException) {
        k.b1();
        throw new kotlin.y();
    }

    public static /* synthetic */ void b(j jVar, CancellationException cancellationException, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            cancellationException = null;
        }
        a(jVar, cancellationException);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @b1(expression = "this", imports = {}))
    public static final <T> i<T> c(@a7.d i0<? extends T> i0Var) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @b1(expression = "this", imports = {}))
    @kotlin.internal.f
    private static final <T> i<T> d(i0<? extends T> i0Var, i5.q<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return k.u(i0Var, qVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @b1(expression = "this", imports = {}))
    public static final <T> i<T> e(@a7.d t0<? extends T> t0Var) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @kotlin.internal.f
    private static final <T> Object f(i0<? extends T> i0Var, kotlin.coroutines.d<? super Integer> dVar) {
        kotlin.jvm.internal.i0.e(0);
        Object objZ = k.Z(i0Var, dVar);
        kotlin.jvm.internal.i0.e(1);
        return objZ;
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @b1(expression = "this", imports = {}))
    public static final <T> i<T> g(@a7.d t0<? extends T> t0Var) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @b1(expression = "this", imports = {}))
    public static final <T> i<T> h(@a7.d i0<? extends T> i0Var, @a7.d kotlin.coroutines.g gVar) {
        k.b1();
        throw new kotlin.y();
    }

    @a7.d
    public static final kotlin.coroutines.g i(@a7.d j<?> jVar) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @b1(expression = "currentCoroutineContext()", imports = {}))
    public static /* synthetic */ void j(j jVar) {
    }

    public static final boolean k(@a7.d j<?> jVar) {
        k.b1();
        throw new kotlin.y();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @b1(expression = "currentCoroutineContext().isActive", imports = {}))
    public static /* synthetic */ void l(j jVar) {
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @b1(expression = "this", imports = {}))
    @kotlin.internal.f
    private static final <T> i<T> m(i0<? extends T> i0Var, long j7, i5.p<? super Throwable, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return k.v1(i0Var, j7, pVar);
    }

    static /* synthetic */ i n(i0 i0Var, long j7, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            j7 = Long.MAX_VALUE;
        }
        if ((i7 & 2) != 0) {
            pVar = new a(null);
        }
        return k.v1(i0Var, j7, pVar);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @b1(expression = "this", imports = {}))
    @kotlin.internal.f
    private static final <T> i<T> o(i0<? extends T> i0Var, i5.r<? super j<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> rVar) {
        return k.x1(i0Var, rVar);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @kotlin.internal.f
    private static final <T> Object p(i0<? extends T> i0Var, kotlin.coroutines.d<? super List<? extends T>> dVar) {
        kotlin.jvm.internal.i0.e(0);
        Object objC = o.c(i0Var, null, dVar, 1, null);
        kotlin.jvm.internal.i0.e(1);
        return objC;
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @kotlin.internal.f
    private static final <T> Object q(i0<? extends T> i0Var, kotlin.coroutines.d<? super Set<? extends T>> dVar) {
        kotlin.jvm.internal.i0.e(0);
        Object objE = o.e(i0Var, null, dVar, 1, null);
        kotlin.jvm.internal.i0.e(1);
        return objE;
    }
}
