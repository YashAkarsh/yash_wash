package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class k0 implements Map, Serializable, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final k0 f34549a = new k0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f34550b = 8246714829545688274L;

    private k0() {
    }

    private final Object readResolve() {
        return f34549a;
    }

    public boolean a(@a7.d Void value) {
        kotlin.jvm.internal.l0.p(value, "value");
        return false;
    }

    @Override // java.util.Map
    @a7.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void get(@a7.e Object obj) {
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(@a7.e Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    @a7.d
    public Set<Map.Entry> d() {
        return l0.f34558a;
    }

    @a7.d
    public Set<Object> e() {
        return l0.f34558a;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(@a7.e Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public int f() {
        return 0;
    }

    @a7.d
    public Collection g() {
        return j0.f34539a;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    public Void i(Object obj, Void r7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return e();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    @a7.d
    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return g();
    }
}
