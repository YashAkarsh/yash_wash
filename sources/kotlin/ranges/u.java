package kotlin.ranges;

import java.util.Iterator;
import kotlin.a2;
import kotlin.g1;
import kotlin.o2;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.5")
@q2(markerClass = {kotlin.t.class})
public class u implements Iterable<a2>, j5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final a f35056d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f35058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35059c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final u a(long j7, long j8, long j9) {
            return new u(j7, j8, j9, null);
        }

        private a() {
        }
    }

    public /* synthetic */ u(long j7, long j8, long j9, kotlin.jvm.internal.w wVar) {
        this(j7, j8, j9);
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof u) {
            if (!isEmpty() || !((u) obj).isEmpty()) {
                u uVar = (u) obj;
                if (this.f35057a != uVar.f35057a || this.f35058b != uVar.f35058b || this.f35059c != uVar.f35059c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f35057a;
    }

    public final long h() {
        return this.f35058b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j7 = this.f35057a;
        int iH = ((int) a2.h(j7 ^ a2.h(j7 >>> 32))) * 31;
        long j8 = this.f35058b;
        int iH2 = (iH + ((int) a2.h(j8 ^ a2.h(j8 >>> 32)))) * 31;
        long j9 = this.f35059c;
        return iH2 + ((int) ((j9 >>> 32) ^ j9));
    }

    public boolean isEmpty() {
        long j7 = this.f35059c;
        long j8 = this.f35057a;
        long j9 = this.f35058b;
        if (j7 > 0) {
            if (o2.g(j8, j9) > 0) {
                return true;
            }
        } else if (o2.g(j8, j9) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @a7.d
    public final Iterator<a2> iterator() {
        return new v(this.f35057a, this.f35058b, this.f35059c, null);
    }

    public final long j() {
        return this.f35059c;
    }

    @a7.d
    public String toString() {
        StringBuilder sb;
        long j7;
        if (this.f35059c > 0) {
            sb = new StringBuilder();
            sb.append((Object) a2.b0(this.f35057a));
            sb.append("..");
            sb.append((Object) a2.b0(this.f35058b));
            sb.append(" step ");
            j7 = this.f35059c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) a2.b0(this.f35057a));
            sb.append(" downTo ");
            sb.append((Object) a2.b0(this.f35058b));
            sb.append(" step ");
            j7 = -this.f35059c;
        }
        sb.append(j7);
        return sb.toString();
    }

    private u(long j7, long j8, long j9) {
        if (j9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j9 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f35057a = j7;
        this.f35058b = kotlin.internal.r.c(j7, j8, j9);
        this.f35059c = j9;
    }
}
