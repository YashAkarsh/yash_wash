package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.4")
public final class v1 implements kotlin.reflect.s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f34938e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f34939f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f34940g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f34941h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.reflect.g f34942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final List<kotlin.reflect.u> f34943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private final kotlin.reflect.s f34944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f34945d;

    public static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34946a;

        static {
            int[] iArr = new int[kotlin.reflect.v.values().length];
            iArr[kotlin.reflect.v.INVARIANT.ordinal()] = 1;
            iArr[kotlin.reflect.v.IN.ordinal()] = 2;
            iArr[kotlin.reflect.v.OUT.ordinal()] = 3;
            f34946a = iArr;
        }
    }

    static final class c extends n0 implements i5.l<kotlin.reflect.u, CharSequence> {
        c() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence z(@a7.d kotlin.reflect.u it) {
            l0.p(it, "it");
            return v1.this.p(it);
        }
    }

    @kotlin.g1(version = i2.a.f34096f)
    public v1(@a7.d kotlin.reflect.g classifier, @a7.d List<kotlin.reflect.u> arguments, @a7.e kotlin.reflect.s sVar, int i7) {
        l0.p(classifier, "classifier");
        l0.p(arguments, "arguments");
        this.f34942a = classifier;
        this.f34943b = arguments;
        this.f34944c = sVar;
        this.f34945d = i7;
    }

    @kotlin.g1(version = i2.a.f34096f)
    public static /* synthetic */ void B() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(kotlin.reflect.u uVar) {
        String strValueOf;
        if (uVar.h() == null) {
            return "*";
        }
        kotlin.reflect.s sVarG = uVar.g();
        v1 v1Var = sVarG instanceof v1 ? (v1) sVarG : null;
        if (v1Var == null || (strValueOf = v1Var.s(true)) == null) {
            strValueOf = String.valueOf(uVar.g());
        }
        int i7 = b.f34946a[uVar.h().ordinal()];
        if (i7 == 1) {
            return strValueOf;
        }
        if (i7 == 2) {
            return "in " + strValueOf;
        }
        if (i7 != 3) {
            throw new kotlin.j0();
        }
        return "out " + strValueOf;
    }

    private final String s(boolean z7) {
        String name;
        kotlin.reflect.g gVarC0 = c0();
        kotlin.reflect.d dVar = gVarC0 instanceof kotlin.reflect.d ? (kotlin.reflect.d) gVarC0 : null;
        Class<?> clsE = dVar != null ? h5.a.e(dVar) : null;
        if (clsE == null) {
            name = c0().toString();
        } else if ((this.f34945d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsE.isArray()) {
            name = v(clsE);
        } else if (z7 && clsE.isPrimitive()) {
            kotlin.reflect.g gVarC1 = c0();
            l0.n(gVarC1, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = h5.a.g((kotlin.reflect.d) gVarC1).getName();
        } else {
            name = clsE.getName();
        }
        String str = name + (d().isEmpty() ? "" : kotlin.collections.g0.h3(d(), ", ", "<", ">", 0, null, new c(), 24, null)) + (w() ? "?" : "");
        kotlin.reflect.s sVar = this.f34944c;
        if (!(sVar instanceof v1)) {
            return str;
        }
        String strS = ((v1) sVar).s(true);
        if (l0.g(strS, str)) {
            return str;
        }
        if (l0.g(strS, str + '?')) {
            return str + '!';
        }
        return '(' + str + ".." + strS + ')';
    }

    private final String v(Class<?> cls) {
        if (l0.g(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (l0.g(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (l0.g(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (l0.g(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (l0.g(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (l0.g(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (l0.g(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        return l0.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    @kotlin.g1(version = i2.a.f34096f)
    public static /* synthetic */ void z() {
    }

    @a7.e
    public final kotlin.reflect.s A() {
        return this.f34944c;
    }

    @Override // kotlin.reflect.s
    @a7.d
    public kotlin.reflect.g c0() {
        return this.f34942a;
    }

    @Override // kotlin.reflect.s
    @a7.d
    public List<kotlin.reflect.u> d() {
        return this.f34943b;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof v1) {
            v1 v1Var = (v1) obj;
            if (l0.g(c0(), v1Var.c0()) && l0.g(d(), v1Var.d()) && l0.g(this.f34944c, v1Var.f34944c) && this.f34945d == v1Var.f34945d) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.b
    @a7.d
    public List<Annotation> getAnnotations() {
        return kotlin.collections.y.F();
    }

    public int hashCode() {
        return (((c0().hashCode() * 31) + d().hashCode()) * 31) + Integer.valueOf(this.f34945d).hashCode();
    }

    @a7.d
    public String toString() {
        return s(false) + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.reflect.s
    public boolean w() {
        return (this.f34945d & 1) != 0;
    }

    public final int y() {
        return this.f34945d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v1(@a7.d kotlin.reflect.g classifier, @a7.d List<kotlin.reflect.u> arguments, boolean z7) {
        this(classifier, arguments, null, z7 ? 1 : 0);
        l0.p(classifier, "classifier");
        l0.p(arguments, "arguments");
    }
}
