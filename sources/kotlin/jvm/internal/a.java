package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.4")
public class a implements e0, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Object f34819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f34820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f34821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f34822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f34823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f34824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f34825g;

    public a(int i7, Class cls, String str, String str2, int i8) {
        this(i7, q.f34893g, cls, str, str2, i8);
    }

    public kotlin.reflect.h b() {
        Class cls = this.f34820b;
        if (cls == null) {
            return null;
        }
        return this.f34823e ? l1.g(cls) : l1.d(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f34823e == aVar.f34823e && this.f34824f == aVar.f34824f && this.f34825g == aVar.f34825g && l0.g(this.f34819a, aVar.f34819a) && l0.g(this.f34820b, aVar.f34820b) && this.f34821c.equals(aVar.f34821c) && this.f34822d.equals(aVar.f34822d);
    }

    @Override // kotlin.jvm.internal.e0
    public int getArity() {
        return this.f34824f;
    }

    public int hashCode() {
        Object obj = this.f34819a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.f34820b;
        return ((((((((((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.f34821c.hashCode()) * 31) + this.f34822d.hashCode()) * 31) + (this.f34823e ? 1231 : 1237)) * 31) + this.f34824f) * 31) + this.f34825g;
    }

    public String toString() {
        return l1.w(this);
    }

    public a(int i7, Object obj, Class cls, String str, String str2, int i8) {
        this.f34819a = obj;
        this.f34820b = cls;
        this.f34821c = str;
        this.f34822d = str2;
        this.f34823e = (i8 & 1) == 1;
        this.f34824f = i7;
        this.f34825g = i8 >> 1;
    }
}
