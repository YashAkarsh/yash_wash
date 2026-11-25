package kotlin;

import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.1")
public final class a0 implements Comparable<a0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f34440f = 255;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f34442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f34445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f34439e = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final a0 f34441g = b0.a();

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        private a() {
        }
    }

    public a0(int i7, int i8, int i9) {
        this.f34442a = i7;
        this.f34443b = i8;
        this.f34444c = i9;
        this.f34445d = g(i7, i8, i9);
    }

    private final int g(int i7, int i8, int i9) {
        boolean z7 = false;
        if (new kotlin.ranges.k(0, 255).m(i7) && new kotlin.ranges.k(0, 255).m(i8) && new kotlin.ranges.k(0, 255).m(i9)) {
            z7 = true;
        }
        if (z7) {
            return (i7 << 16) + (i8 << 8) + i9;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR + i8 + ClassUtils.PACKAGE_SEPARATOR_CHAR + i9).toString());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@a7.d a0 other) {
        kotlin.jvm.internal.l0.p(other, "other");
        return this.f34445d - other.f34445d;
    }

    public final int b() {
        return this.f34442a;
    }

    public final int c() {
        return this.f34443b;
    }

    public final int d() {
        return this.f34444c;
    }

    public final boolean e(int i7, int i8) {
        int i9 = this.f34442a;
        return i9 > i7 || (i9 == i7 && this.f34443b >= i8);
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        a0 a0Var = obj instanceof a0 ? (a0) obj : null;
        return a0Var != null && this.f34445d == a0Var.f34445d;
    }

    public final boolean f(int i7, int i8, int i9) {
        int i10;
        int i11 = this.f34442a;
        return i11 > i7 || (i11 == i7 && ((i10 = this.f34443b) > i8 || (i10 == i8 && this.f34444c >= i9)));
    }

    public int hashCode() {
        return this.f34445d;
    }

    @a7.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f34442a);
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb.append(this.f34443b);
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb.append(this.f34444c);
        return sb.toString();
    }

    public a0(int i7, int i8) {
        this(i7, i8, 0);
    }
}
