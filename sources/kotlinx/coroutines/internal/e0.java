package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.a3;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final e0 f36973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f36974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final a3 f36975c;

    static {
        e0 e0Var = new e0();
        f36973a = e0Var;
        f36974b = t0.e("kotlinx.coroutines.fast.service.loader", true);
        f36975c = e0Var.a();
    }

    private e0() {
    }

    private final a3 a() {
        Object next;
        try {
            List<d0> listD = f36974b ? o.f37010a.d() : kotlin.sequences.u.c3(kotlin.sequences.s.e(ServiceLoader.load(d0.class, d0.class.getClassLoader()).iterator()));
            Iterator<T> it = listD.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((d0) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((d0) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            d0 d0Var = (d0) next;
            a3 a3VarF = d0Var == null ? null : f0.f(d0Var, listD);
            return a3VarF == null ? f0.b(null, null, 3, null) : a3VarF;
        } catch (Throwable th) {
            return f0.b(th, null, 2, null);
        }
    }
}
