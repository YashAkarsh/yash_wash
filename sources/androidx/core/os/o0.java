package androidx.core.os;

import android.os.PersistableBundle;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {
    @a7.d
    @c.t0(21)
    public static final PersistableBundle a() {
        return m0.a(0);
    }

    @a7.d
    @c.t0(21)
    public static final PersistableBundle b(@a7.d kotlin.u0<String, ? extends Object>... pairs) {
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        PersistableBundle persistableBundleA = m0.a(pairs.length);
        for (kotlin.u0<String, ? extends Object> u0Var : pairs) {
            m0.b(persistableBundleA, u0Var.a(), u0Var.b());
        }
        return persistableBundleA;
    }

    @a7.d
    @c.t0(21)
    public static final PersistableBundle c(@a7.d Map<String, ? extends Object> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        PersistableBundle persistableBundleA = m0.a(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            m0.b(persistableBundleA, entry.getKey(), entry.getValue());
        }
        return persistableBundleA;
    }
}
