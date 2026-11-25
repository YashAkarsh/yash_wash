package androidx.core.os;

import android.os.PersistableBundle;

/* JADX INFO: loaded from: classes.dex */
@c.t0(22)
final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final n0 f6095a = new n0();

    private n0() {
    }

    @c.t
    @h5.l
    public static final void a(@a7.d PersistableBundle persistableBundle, @a7.e String str, boolean z7) {
        kotlin.jvm.internal.l0.p(persistableBundle, "persistableBundle");
        persistableBundle.putBoolean(str, z7);
    }

    @c.t
    @h5.l
    public static final void b(@a7.d PersistableBundle persistableBundle, @a7.e String str, @a7.d boolean[] value) {
        kotlin.jvm.internal.l0.p(persistableBundle, "persistableBundle");
        kotlin.jvm.internal.l0.p(value, "value");
        persistableBundle.putBooleanArray(str, value);
    }
}
