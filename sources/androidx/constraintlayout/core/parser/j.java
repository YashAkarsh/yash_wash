package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class j extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    b f3217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    char[] f3218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    char[] f3219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    char[] f3220l;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3221a;

        static {
            int[] iArr = new int[b.values().length];
            f3221a = iArr;
            try {
                iArr[b.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3221a[b.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3221a[b.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3221a[b.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    enum b {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public j(char[] cArr) {
        super(cArr);
        this.f3216h = 0;
        this.f3217i = b.UNKNOWN;
        this.f3218j = "true".toCharArray();
        this.f3219k = com.paytm.pgsdk.d.G.toCharArray();
        this.f3220l = "null".toCharArray();
    }

    public static c x(char[] cArr) {
        return new j(cArr);
    }

    public b A() {
        return this.f3217i;
    }

    public boolean B() throws h {
        if (this.f3217i == b.NULL) {
            return true;
        }
        throw new h("this token is not a null: <" + b() + ">", this);
    }

    public boolean D(char c8, long j7) {
        int i7 = a.f3221a[this.f3217i.ordinal()];
        boolean z7 = false;
        if (i7 == 1) {
            char[] cArr = this.f3218j;
            int i8 = this.f3216h;
            z7 = cArr[i8] == c8;
            if (z7 && i8 + 1 == cArr.length) {
                s(j7);
            }
        } else if (i7 == 2) {
            char[] cArr2 = this.f3219k;
            int i9 = this.f3216h;
            z7 = cArr2[i9] == c8;
            if (z7 && i9 + 1 == cArr2.length) {
                s(j7);
            }
        } else if (i7 == 3) {
            char[] cArr3 = this.f3220l;
            int i10 = this.f3216h;
            z7 = cArr3[i10] == c8;
            if (z7 && i10 + 1 == cArr3.length) {
                s(j7);
            }
        } else if (i7 == 4) {
            char[] cArr4 = this.f3218j;
            int i11 = this.f3216h;
            if (cArr4[i11] == c8) {
                this.f3217i = b.TRUE;
            } else if (this.f3219k[i11] == c8) {
                this.f3217i = b.FALSE;
            } else if (this.f3220l[i11] == c8) {
                this.f3217i = b.NULL;
            }
            z7 = true;
        }
        this.f3216h++;
        return z7;
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String v(int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        a(sb, i7);
        sb.append(b());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String w() {
        if (!g.f3200d) {
            return b();
        }
        return "<" + b() + ">";
    }

    public boolean z() throws h {
        b bVar = this.f3217i;
        if (bVar == b.TRUE) {
            return true;
        }
        if (bVar == b.FALSE) {
            return false;
        }
        throw new h("this token is not a boolean: <" + b() + ">", this);
    }
}
