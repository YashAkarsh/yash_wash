package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
@c.t0(18)
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final b f6077a = new b();

    private b() {
    }

    @c.t
    @h5.l
    public static final void a(@a7.d Bundle bundle, @a7.d String key, @a7.e IBinder iBinder) {
        kotlin.jvm.internal.l0.p(bundle, "bundle");
        kotlin.jvm.internal.l0.p(key, "key");
        bundle.putBinder(key, iBinder);
    }
}
