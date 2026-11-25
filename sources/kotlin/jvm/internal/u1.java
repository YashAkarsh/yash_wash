package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.4")
public final class u1 implements kotlin.reflect.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    public static final a f34929f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Object f34930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final String f34931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final kotlin.reflect.v f34932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f34933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private volatile List<? extends kotlin.reflect.s> f34934e;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.jvm.internal.u1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0434a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f34935a;

            static {
                int[] iArr = new int[kotlin.reflect.v.values().length];
                iArr[kotlin.reflect.v.INVARIANT.ordinal()] = 1;
                iArr[kotlin.reflect.v.IN.ordinal()] = 2;
                iArr[kotlin.reflect.v.OUT.ordinal()] = 3;
                f34935a = iArr;
            }
        }

        public /* synthetic */ a(w wVar) {
            this();
        }

        @a7.d
        public final String a(@a7.d kotlin.reflect.t typeParameter) {
            l0.p(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i7 = C0434a.f34935a[typeParameter.p().ordinal()];
            if (i7 == 2) {
                sb.append("in ");
            } else if (i7 == 3) {
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            String string = sb.toString();
            l0.o(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        private a() {
        }
    }

    public u1(@a7.e Object obj, @a7.d String name, @a7.d kotlin.reflect.v variance, boolean z7) {
        l0.p(name, "name");
        l0.p(variance, "variance");
        this.f34930a = obj;
        this.f34931b = name;
        this.f34932c = variance;
        this.f34933d = z7;
    }

    public static /* synthetic */ void a() {
    }

    public final void c(@a7.d List<? extends kotlin.reflect.s> upperBounds) {
        l0.p(upperBounds, "upperBounds");
        if (this.f34934e == null) {
            this.f34934e = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof u1) {
            u1 u1Var = (u1) obj;
            if (l0.g(this.f34930a, u1Var.f34930a) && l0.g(getName(), u1Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.t
    @a7.d
    public String getName() {
        return this.f34931b;
    }

    @Override // kotlin.reflect.t
    @a7.d
    public List<kotlin.reflect.s> getUpperBounds() {
        List list = this.f34934e;
        if (list != null) {
            return list;
        }
        List<kotlin.reflect.s> listL = kotlin.collections.x.l(l1.n(Object.class));
        this.f34934e = listL;
        return listL;
    }

    public int hashCode() {
        Object obj = this.f34930a;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.t
    public boolean l() {
        return this.f34933d;
    }

    @Override // kotlin.reflect.t
    @a7.d
    public kotlin.reflect.v p() {
        return this.f34932c;
    }

    @a7.d
    public String toString() {
        return f34929f.a(this);
    }
}
