package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.a3;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final String f36980a = "kotlinx.coroutines.fast.service.loader";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f36981b = true;

    private static final g0 a(Throwable th, String str) throws Throwable {
        if (f36981b) {
            return new g0(th, str);
        }
        if (th != null) {
            throw th;
        }
        e();
        throw new kotlin.y();
    }

    static /* synthetic */ g0 b(Throwable th, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            th = null;
        }
        if ((i7 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    private static /* synthetic */ void c() {
    }

    @j2
    public static final boolean d(@a7.d a3 a3Var) {
        return a3Var.e1() instanceof g0;
    }

    @a7.d
    public static final Void e() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @a7.d
    @j2
    public static final a3 f(@a7.d d0 d0Var, @a7.d List<? extends d0> list) {
        try {
            return d0Var.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, d0Var.hintOnError());
        }
    }
}
