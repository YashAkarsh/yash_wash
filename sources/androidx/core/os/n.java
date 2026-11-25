package androidx.core.os;

import android.os.Handler;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<l2> f6093a;

        public a(i5.a<l2> aVar) {
            this.f6093a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6093a.invoke();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<l2> f6094a;

        public b(i5.a<l2> aVar) {
            this.f6094a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6094a.invoke();
        }
    }

    @a7.d
    public static final Runnable a(@a7.d Handler handler, long j7, @a7.e Object obj, @a7.d i5.a<l2> action) {
        kotlin.jvm.internal.l0.p(handler, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        a aVar = new a(action);
        handler.postAtTime(aVar, obj, j7);
        return aVar;
    }

    public static /* synthetic */ Runnable b(Handler handler, long j7, Object obj, i5.a action, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            obj = null;
        }
        kotlin.jvm.internal.l0.p(handler, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        a aVar = new a(action);
        handler.postAtTime(aVar, obj, j7);
        return aVar;
    }

    @a7.d
    public static final Runnable c(@a7.d Handler handler, long j7, @a7.e Object obj, @a7.d i5.a<l2> action) {
        kotlin.jvm.internal.l0.p(handler, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        b bVar = new b(action);
        if (obj == null) {
            handler.postDelayed(bVar, j7);
        } else {
            l.d(handler, bVar, obj, j7);
        }
        return bVar;
    }

    public static /* synthetic */ Runnable d(Handler handler, long j7, Object obj, i5.a action, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            obj = null;
        }
        kotlin.jvm.internal.l0.p(handler, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        b bVar = new b(action);
        if (obj == null) {
            handler.postDelayed(bVar, j7);
        } else {
            l.d(handler, bVar, obj, j7);
        }
        return bVar;
    }
}
