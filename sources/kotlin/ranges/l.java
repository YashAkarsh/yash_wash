package kotlin.ranges;

import kotlin.collections.v0;

/* JADX INFO: loaded from: classes2.dex */
public class l implements Iterable<Long>, j5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final a f35036d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f35038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35039c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final l a(long j7, long j8, long j9) {
            return new l(j7, j8, j9);
        }

        private a() {
        }
    }

    public l(long j7, long j8, long j9) {
        if (j9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j9 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f35037a = j7;
        this.f35038b = kotlin.internal.n.d(j7, j8, j9);
        this.f35039c = j9;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (this.f35037a != lVar.f35037a || this.f35038b != lVar.f35038b || this.f35039c != lVar.f35039c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f35037a;
    }

    public final long h() {
        return this.f35038b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j7 = 31;
        long j8 = this.f35037a;
        long j9 = this.f35038b;
        long j10 = j7 * (((j8 ^ (j8 >>> 32)) * j7) + (j9 ^ (j9 >>> 32)));
        long j11 = this.f35039c;
        return (int) (j10 + (j11 ^ (j11 >>> 32)));
    }

    public boolean isEmpty() {
        long j7 = this.f35039c;
        long j8 = this.f35037a;
        long j9 = this.f35038b;
        if (j7 > 0) {
            if (j8 > j9) {
                return true;
            }
        } else if (j8 < j9) {
            return true;
        }
        return false;
    }

    public final long j() {
        return this.f35039c;
    }

    @Override // java.lang.Iterable
    @a7.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public v0 iterator() {
        return new m(this.f35037a, this.f35038b, this.f35039c);
    }

    @a7.d
    public String toString() {
        StringBuilder sb;
        long j7;
        if (this.f35039c > 0) {
            sb = new StringBuilder();
            sb.append(this.f35037a);
            sb.append("..");
            sb.append(this.f35038b);
            sb.append(" step ");
            j7 = this.f35039c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f35037a);
            sb.append(" downTo ");
            sb.append(this.f35038b);
            sb.append(" step ");
            j7 = -this.f35039c;
        }
        sb.append(j7);
        return sb.toString();
    }
}
