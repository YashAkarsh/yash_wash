package kotlin.ranges;

import java.util.Iterator;
import kotlin.g1;
import kotlin.o2;
import kotlin.q2;
import kotlin.w1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.5")
@q2(markerClass = {kotlin.t.class})
public class r implements Iterable<w1>, j5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final a f35046d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35049c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final r a(int i7, int i8, int i9) {
            return new r(i7, i8, i9, null);
        }

        private a() {
        }
    }

    public /* synthetic */ r(int i7, int i8, int i9, kotlin.jvm.internal.w wVar) {
        this(i7, i8, i9);
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof r) {
            if (!isEmpty() || !((r) obj).isEmpty()) {
                r rVar = (r) obj;
                if (this.f35047a != rVar.f35047a || this.f35048b != rVar.f35048b || this.f35049c != rVar.f35049c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f35047a;
    }

    public final int h() {
        return this.f35048b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f35047a * 31) + this.f35048b) * 31) + this.f35049c;
    }

    public boolean isEmpty() {
        if (this.f35049c > 0) {
            if (o2.c(this.f35047a, this.f35048b) > 0) {
                return true;
            }
        } else if (o2.c(this.f35047a, this.f35048b) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @a7.d
    public final Iterator<w1> iterator() {
        return new s(this.f35047a, this.f35048b, this.f35049c, null);
    }

    public final int j() {
        return this.f35049c;
    }

    @a7.d
    public String toString() {
        StringBuilder sb;
        int i7;
        if (this.f35049c > 0) {
            sb = new StringBuilder();
            sb.append((Object) w1.b0(this.f35047a));
            sb.append("..");
            sb.append((Object) w1.b0(this.f35048b));
            sb.append(" step ");
            i7 = this.f35049c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) w1.b0(this.f35047a));
            sb.append(" downTo ");
            sb.append((Object) w1.b0(this.f35048b));
            sb.append(" step ");
            i7 = -this.f35049c;
        }
        sb.append(i7);
        return sb.toString();
    }

    private r(int i7, int i8, int i9) {
        if (i9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i9 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f35047a = i7;
        this.f35048b = kotlin.internal.r.d(i7, i8, i9);
        this.f35049c = i9;
    }
}
