package kotlin.ranges;

import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Iterable<Character>, j5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final C0437a f35010d = new C0437a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f35011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f35012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35013c;

    /* JADX INFO: renamed from: kotlin.ranges.a$a, reason: collision with other inner class name */
    public static final class C0437a {
        public /* synthetic */ C0437a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final a a(char c8, char c9, int i7) {
            return new a(c8, c9, i7);
        }

        private C0437a() {
        }
    }

    public a(char c8, char c9, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f35011a = c8;
        this.f35012b = (char) kotlin.internal.n.c(c8, c9, i7);
        this.f35013c = i7;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f35011a != aVar.f35011a || this.f35012b != aVar.f35012b || this.f35013c != aVar.f35013c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char g() {
        return this.f35011a;
    }

    public final char h() {
        return this.f35012b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f35011a * 31) + this.f35012b) * 31) + this.f35013c;
    }

    public boolean isEmpty() {
        if (this.f35013c > 0) {
            if (l0.t(this.f35011a, this.f35012b) > 0) {
                return true;
            }
        } else if (l0.t(this.f35011a, this.f35012b) < 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.f35013c;
    }

    @Override // java.lang.Iterable
    @a7.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public kotlin.collections.u iterator() {
        return new b(this.f35011a, this.f35012b, this.f35013c);
    }

    @a7.d
    public String toString() {
        StringBuilder sb;
        int i7;
        if (this.f35013c > 0) {
            sb = new StringBuilder();
            sb.append(this.f35011a);
            sb.append("..");
            sb.append(this.f35012b);
            sb.append(" step ");
            i7 = this.f35013c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f35011a);
            sb.append(" downTo ");
            sb.append(this.f35012b);
            sb.append(" step ");
            i7 = -this.f35013c;
        }
        sb.append(i7);
        return sb.toString();
    }
}
