package kotlin.properties;

import kotlin.jvm.internal.l0;
import kotlin.reflect.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<V> implements f<Object, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private V f34984a;

    public c(V v7) {
        this.f34984a = v7;
    }

    @Override // kotlin.properties.f, kotlin.properties.e
    public V a(@a7.e Object obj, @a7.d o<?> property) {
        l0.p(property, "property");
        return this.f34984a;
    }

    @Override // kotlin.properties.f
    public void b(@a7.e Object obj, @a7.d o<?> property, V v7) {
        l0.p(property, "property");
        V v8 = this.f34984a;
        if (d(property, v8, v7)) {
            this.f34984a = v7;
            c(property, v8, v7);
        }
    }

    protected void c(@a7.d o<?> property, V v7, V v8) {
        l0.p(property, "property");
    }

    protected boolean d(@a7.d o<?> property, V v7, V v8) {
        l0.p(property, "property");
        return true;
    }
}
