package kotlin.reflect;

import kotlin.a1;
import kotlin.g1;
import kotlin.j0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.1")
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final a f35078c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final u f35079d = new u(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final v f35080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final s f35081b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a1
        public static /* synthetic */ void d() {
        }

        @a7.d
        @h5.l
        public final u a(@a7.d s type) {
            l0.p(type, "type");
            return new u(v.IN, type);
        }

        @a7.d
        @h5.l
        public final u b(@a7.d s type) {
            l0.p(type, "type");
            return new u(v.OUT, type);
        }

        @a7.d
        public final u c() {
            return u.f35079d;
        }

        @a7.d
        @h5.l
        public final u e(@a7.d s type) {
            l0.p(type, "type");
            return new u(v.INVARIANT, type);
        }

        private a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35082a;

        static {
            int[] iArr = new int[v.values().length];
            iArr[v.INVARIANT.ordinal()] = 1;
            iArr[v.IN.ordinal()] = 2;
            iArr[v.OUT.ordinal()] = 3;
            f35082a = iArr;
        }
    }

    public u(@a7.e v vVar, @a7.e s sVar) {
        String str;
        this.f35080a = vVar;
        this.f35081b = sVar;
        if ((vVar == null) == (sVar == null)) {
            return;
        }
        if (vVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + vVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @a7.d
    @h5.l
    public static final u c(@a7.d s sVar) {
        return f35078c.a(sVar);
    }

    public static /* synthetic */ u e(u uVar, v vVar, s sVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            vVar = uVar.f35080a;
        }
        if ((i7 & 2) != 0) {
            sVar = uVar.f35081b;
        }
        return uVar.d(vVar, sVar);
    }

    @a7.d
    @h5.l
    public static final u f(@a7.d s sVar) {
        return f35078c.b(sVar);
    }

    @a7.d
    @h5.l
    public static final u i(@a7.d s sVar) {
        return f35078c.e(sVar);
    }

    @a7.e
    public final v a() {
        return this.f35080a;
    }

    @a7.e
    public final s b() {
        return this.f35081b;
    }

    @a7.d
    public final u d(@a7.e v vVar, @a7.e s sVar) {
        return new u(vVar, sVar);
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f35080a == uVar.f35080a && l0.g(this.f35081b, uVar.f35081b);
    }

    @a7.e
    public final s g() {
        return this.f35081b;
    }

    @a7.e
    public final v h() {
        return this.f35080a;
    }

    public int hashCode() {
        v vVar = this.f35080a;
        int iHashCode = (vVar == null ? 0 : vVar.hashCode()) * 31;
        s sVar = this.f35081b;
        return iHashCode + (sVar != null ? sVar.hashCode() : 0);
    }

    @a7.d
    public String toString() {
        v vVar = this.f35080a;
        int i7 = vVar == null ? -1 : b.f35082a[vVar.ordinal()];
        if (i7 == -1) {
            return "*";
        }
        if (i7 == 1) {
            return String.valueOf(this.f35081b);
        }
        if (i7 == 2) {
            return "in " + this.f35081b;
        }
        if (i7 != 3) {
            throw new j0();
        }
        return "out " + this.f35081b;
    }
}
