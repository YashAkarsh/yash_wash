package kotlin.properties;

import kotlin.jvm.internal.l0;
import kotlin.reflect.o;

/* JADX INFO: loaded from: classes2.dex */
final class b<T> implements f<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private T f34983a;

    @Override // kotlin.properties.f, kotlin.properties.e
    @a7.d
    public T a(@a7.e Object obj, @a7.d o<?> property) {
        l0.p(property, "property");
        T t7 = this.f34983a;
        if (t7 != null) {
            return t7;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @Override // kotlin.properties.f
    public void b(@a7.e Object obj, @a7.d o<?> property, @a7.d T value) {
        l0.p(property, "property");
        l0.p(value, "value");
        this.f34983a = value;
    }
}
