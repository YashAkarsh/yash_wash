package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* JADX INFO: loaded from: classes.dex */
@c.t0(21)
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final c f6078a = new c();

    private c() {
    }

    @c.t
    @h5.l
    public static final void a(@a7.d Bundle bundle, @a7.d String key, @a7.e Size size) {
        kotlin.jvm.internal.l0.p(bundle, "bundle");
        kotlin.jvm.internal.l0.p(key, "key");
        bundle.putSize(key, size);
    }

    @c.t
    @h5.l
    public static final void b(@a7.d Bundle bundle, @a7.d String key, @a7.e SizeF sizeF) {
        kotlin.jvm.internal.l0.p(bundle, "bundle");
        kotlin.jvm.internal.l0.p(key, "key");
        bundle.putSizeF(key, sizeF);
    }
}
