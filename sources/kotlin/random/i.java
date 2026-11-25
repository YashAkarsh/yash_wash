package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends f implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    private static final a f35002i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    private static final long f35003j = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f35005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f35006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f35007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f35008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f35009h;

    private static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private a() {
        }
    }

    public i(int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f35004c = i7;
        this.f35005d = i8;
        this.f35006e = i9;
        this.f35007f = i10;
        this.f35008g = i11;
        this.f35009h = i12;
        int i13 = i7 | i8 | i9 | i10 | i11;
        if (!(i13 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i14 = 0; i14 < 64; i14++) {
            l();
        }
    }

    @Override // kotlin.random.f
    public int b(int i7) {
        return g.j(l(), i7);
    }

    @Override // kotlin.random.f
    public int l() {
        int i7 = this.f35004c;
        int i8 = i7 ^ (i7 >>> 2);
        this.f35004c = this.f35005d;
        this.f35005d = this.f35006e;
        this.f35006e = this.f35007f;
        int i9 = this.f35008g;
        this.f35007f = i9;
        int i10 = ((i8 ^ (i8 << 1)) ^ i9) ^ (i9 << 4);
        this.f35008g = i10;
        int i11 = this.f35009h + 362437;
        this.f35009h = i11;
        return i10 + i11;
    }

    public i(int i7, int i8) {
        this(i7, i8, 0, 0, ~i7, (i7 << 10) ^ (i8 >>> 4));
    }
}
