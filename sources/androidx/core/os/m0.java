package androidx.core.os;

import android.os.PersistableBundle;

/* JADX INFO: loaded from: classes.dex */
@c.t0(21)
final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final m0 f6092a = new m0();

    private m0() {
    }

    @a7.d
    @c.t
    @h5.l
    public static final PersistableBundle a(int i7) {
        return new PersistableBundle(i7);
    }

    @c.t
    @h5.l
    public static final void b(@a7.d PersistableBundle persistableBundle, @a7.e String str, @a7.e Object obj) {
        kotlin.jvm.internal.l0.p(persistableBundle, "persistableBundle");
        if (obj == null) {
            persistableBundle.putString(str, null);
            return;
        }
        if (obj instanceof Boolean) {
            n0.a(persistableBundle, str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Double) {
            persistableBundle.putDouble(str, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Integer) {
            persistableBundle.putInt(str, ((Number) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            persistableBundle.putLong(str, ((Number) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            persistableBundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            n0.b(persistableBundle, str, (boolean[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            persistableBundle.putDoubleArray(str, (double[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            persistableBundle.putIntArray(str, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            persistableBundle.putLongArray(str, (long[]) obj);
            return;
        }
        if (!(obj instanceof Object[])) {
            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str + kotlin.text.h0.f35376b);
        }
        Class<?> componentType = obj.getClass().getComponentType();
        kotlin.jvm.internal.l0.m(componentType);
        if (String.class.isAssignableFrom(componentType)) {
            persistableBundle.putStringArray(str, (String[]) obj);
            return;
        }
        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + kotlin.text.h0.f35376b);
    }
}
