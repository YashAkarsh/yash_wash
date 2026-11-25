package i3;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<V>[] f34175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34176b;

    protected static final class a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f34178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public V f34179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a<V> f34180d;

        public a(Type type, V v7, int i7, a<V> aVar) {
            this.f34178b = type;
            this.f34179c = v7;
            this.f34180d = aVar;
            this.f34177a = i7;
        }
    }

    public b(int i7) {
        this.f34176b = i7 - 1;
        this.f34175a = new a[i7];
    }

    public final V a(Type type) {
        for (a<V> aVar = this.f34175a[System.identityHashCode(type) & this.f34176b]; aVar != null; aVar = aVar.f34180d) {
            if (type == aVar.f34178b) {
                return aVar.f34179c;
            }
        }
        return null;
    }

    public boolean b(Type type, V v7) {
        int iIdentityHashCode = System.identityHashCode(type);
        int i7 = this.f34176b & iIdentityHashCode;
        for (a<V> aVar = this.f34175a[i7]; aVar != null; aVar = aVar.f34180d) {
            if (type == aVar.f34178b) {
                aVar.f34179c = v7;
                return true;
            }
        }
        this.f34175a[i7] = new a<>(type, v7, iIdentityHashCode, this.f34175a[i7]);
        return false;
    }
}
