package okhttp3.internal.http2;

import kotlin.collections.o;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38205c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38206d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38207e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38208f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f38209g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f38210h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f38211i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f38212j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f38213k = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f38215b = new int[10];

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public final void a() {
        this.f38214a = 0;
        o.u2(this.f38215b, 0, 0, 0, 6, null);
    }

    public final int b(int i7) {
        return this.f38215b[i7];
    }

    public final boolean c(boolean z7) {
        if ((this.f38214a & 4) != 0) {
            return this.f38215b[2] == 1;
        }
        return z7;
    }

    public final int d() {
        if ((this.f38214a & 2) != 0) {
            return this.f38215b[1];
        }
        return -1;
    }

    public final int e() {
        if ((this.f38214a & 128) != 0) {
            return this.f38215b[7];
        }
        return 65535;
    }

    public final int f() {
        if ((this.f38214a & 16) != 0) {
            return this.f38215b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int g(int i7) {
        return (this.f38214a & 32) != 0 ? this.f38215b[5] : i7;
    }

    public final int h(int i7) {
        return (this.f38214a & 64) != 0 ? this.f38215b[6] : i7;
    }

    public final boolean i(int i7) {
        return ((1 << i7) & this.f38214a) != 0;
    }

    public final void j(@a7.d m other) {
        l0.p(other, "other");
        for (int i7 = 0; i7 < 10; i7++) {
            if (other.i(i7)) {
                k(i7, other.b(i7));
            }
        }
    }

    @a7.d
    public final m k(int i7, int i8) {
        if (i7 >= 0) {
            int[] iArr = this.f38215b;
            if (i7 < iArr.length) {
                this.f38214a = (1 << i7) | this.f38214a;
                iArr[i7] = i8;
            }
        }
        return this;
    }

    public final int l() {
        return Integer.bitCount(this.f38214a);
    }
}
