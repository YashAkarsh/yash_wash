package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import i5.l;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.g;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import kotlin.time.f;
import kotlinx.coroutines.d3;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.q;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.s2;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c implements f1 {

    @a7.e
    private volatile b _immediate;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final Handler f35505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private final String f35506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f35507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final b f35508e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f35509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f35510b;

        public a(q qVar, b bVar) {
            this.f35509a = qVar;
            this.f35510b = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f35509a.N(this.f35510b, l2.f34958a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.android.b$b, reason: collision with other inner class name */
    static final class C0444b extends n0 implements l<Throwable, l2> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f35512b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0444b(Runnable runnable) {
            super(1);
            this.f35512b = runnable;
        }

        public final void b(@a7.e Throwable th) {
            b.this.f35505b.removeCallbacks(this.f35512b);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    private b(Handler handler, String str, boolean z7) {
        super(null);
        this.f35505b = handler;
        this.f35506c = str;
        this.f35507d = z7;
        this._immediate = z7 ? this : null;
        b bVar = this._immediate;
        if (bVar == null) {
            bVar = new b(handler, str, true);
            this._immediate = bVar;
        }
        this.f35508e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(b bVar, Runnable runnable) {
        bVar.f35505b.removeCallbacks(runnable);
    }

    private final void z1(g gVar, Runnable runnable) {
        s2.f(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        n1.c().T0(gVar, runnable);
    }

    @Override // kotlinx.coroutines.android.c
    @a7.d
    /* JADX INFO: renamed from: A1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b q1() {
        return this.f35508e;
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d g gVar, @a7.d Runnable runnable) {
        if (this.f35505b.post(runnable)) {
            return;
        }
        z1(gVar, runnable);
    }

    @Override // kotlinx.coroutines.o0
    public boolean Y0(@a7.d g gVar) {
        return (this.f35507d && l0.g(Looper.myLooper(), this.f35505b.getLooper())) ? false : true;
    }

    public boolean equals(@a7.e Object obj) {
        return (obj instanceof b) && ((b) obj).f35505b == this.f35505b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f35505b);
    }

    @Override // kotlinx.coroutines.android.c, kotlinx.coroutines.f1
    @a7.d
    public q1 p0(long j7, @a7.d final Runnable runnable, @a7.d g gVar) {
        if (this.f35505b.postDelayed(runnable, kotlin.ranges.q.v(j7, f.f35465c))) {
            return new q1() { // from class: kotlinx.coroutines.android.a
                @Override // kotlinx.coroutines.q1
                public final void F() {
                    b.B1(this.f35503a, runnable);
                }
            };
        }
        z1(gVar, runnable);
        return d3.f35894a;
    }

    @Override // kotlinx.coroutines.f1
    public void s(long j7, @a7.d q<? super l2> qVar) {
        a aVar = new a(qVar, this);
        if (this.f35505b.postDelayed(aVar, kotlin.ranges.q.v(j7, f.f35465c))) {
            qVar.i0(new C0444b(aVar));
        } else {
            z1(qVar.d(), aVar);
        }
    }

    @Override // kotlinx.coroutines.a3, kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        String strI1 = i1();
        if (strI1 != null) {
            return strI1;
        }
        String string = this.f35506c;
        if (string == null) {
            string = this.f35505b.toString();
        }
        return this.f35507d ? l0.C(string, ".immediate") : string;
    }

    public /* synthetic */ b(Handler handler, String str, int i7, w wVar) {
        this(handler, (i7 & 2) != 0 ? null : str);
    }

    public b(@a7.d Handler handler, @a7.e String str) {
        this(handler, str, false);
    }
}
