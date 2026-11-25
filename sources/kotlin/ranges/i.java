package kotlin.ranges;

import kotlin.collections.u0;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Iterable<Integer>, j5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final a f35026d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35029c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final i a(int i7, int i8, int i9) {
            return new i(i7, i8, i9);
        }

        private a() {
        }
    }

    public i(int i7, int i8, int i9) {
        if (i9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i9 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f35027a = i7;
        this.f35028b = kotlin.internal.n.c(i7, i8, i9);
        this.f35029c = i9;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (this.f35027a != iVar.f35027a || this.f35028b != iVar.f35028b || this.f35029c != iVar.f35029c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f35027a;
    }

    public final int h() {
        return this.f35028b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f35027a * 31) + this.f35028b) * 31) + this.f35029c;
    }

    public boolean isEmpty() {
        if (this.f35029c > 0) {
            if (this.f35027a > this.f35028b) {
                return true;
            }
        } else if (this.f35027a < this.f35028b) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.f35029c;
    }

    @Override // java.lang.Iterable
    @a7.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public u0 iterator() {
        return new j(this.f35027a, this.f35028b, this.f35029c);
    }

    @a7.d
    public String toString() {
        StringBuilder sb;
        int i7;
        if (this.f35029c > 0) {
            sb = new StringBuilder();
            sb.append(this.f35027a);
            sb.append("..");
            sb.append(this.f35028b);
            sb.append(" step ");
            i7 = this.f35029c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f35027a);
            sb.append(" downTo ");
            sb.append(this.f35028b);
            sb.append(" step ");
            i7 = -this.f35029c;
        }
        sb.append(i7);
        return sb.toString();
    }
}
