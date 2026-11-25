package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.constraintlayout.core.motion.utils.w;
import c.g1;
import java.lang.reflect.InvocationTargetException;
import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.h;
import kotlin.d1;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.m;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f35514a = 4611686018427387903L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    @a7.e
    public static final c f35515b;

    @a7.e
    private static volatile Choreographer choreographer;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f35516a;

        public a(q qVar) {
            this.f35516a = qVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.l(this.f35516a);
        }
    }

    static {
        Object objB;
        try {
            d1.a aVar = d1.f34719b;
            objB = d1.b(new b(d(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            objB = d1.b(e1.a(th));
        }
        f35515b = (c) (d1.i(objB) ? null : objB);
    }

    @a7.d
    @g1
    public static final Handler d(@a7.d Looper looper, boolean z7) throws IllegalAccessException, InvocationTargetException {
        if (!z7) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }

    @a7.e
    public static final Object e(@a7.d kotlin.coroutines.d<? super Long> dVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            r rVar = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
            rVar.O();
            j(choreographer2, rVar);
            Object objZ = rVar.z();
            if (objZ == kotlin.coroutines.intrinsics.d.h()) {
                h.c(dVar);
            }
            return objZ;
        }
        r rVar2 = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar2.O();
        n1.e().T0(i.f34682a, new a(rVar2));
        Object objZ2 = rVar2.z();
        if (objZ2 == kotlin.coroutines.intrinsics.d.h()) {
            h.c(dVar);
        }
        return objZ2;
    }

    @a7.d
    @h5.i
    @h5.h(name = w.h.f3145c)
    public static final c f(@a7.d Handler handler) {
        return h(handler, null, 1, null);
    }

    @a7.d
    @h5.i
    @h5.h(name = w.h.f3145c)
    public static final c g(@a7.d Handler handler, @a7.e String str) {
        return new b(handler, str);
    }

    public static /* synthetic */ c h(Handler handler, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = null;
        }
        return g(handler, str);
    }

    @k(level = m.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Choreographer choreographer2, final q<? super Long> qVar) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.d
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j7) {
                e.k(qVar, j7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(q qVar, long j7) {
        qVar.N(n1.e(), Long.valueOf(j7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(q<? super Long> qVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            l0.m(choreographer2);
            choreographer = choreographer2;
        }
        j(choreographer2, qVar);
    }
}
