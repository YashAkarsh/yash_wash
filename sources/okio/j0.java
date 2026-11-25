package okio;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f38465h = 8192;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f38466i = 1024;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f38467j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final byte[] f38468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public int f38469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h5.e
    public int f38470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h5.e
    public boolean f38471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @h5.e
    public boolean f38472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @h5.e
    @a7.e
    public j0 f38473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @h5.e
    @a7.e
    public j0 f38474g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    public j0() {
        this.f38468a = new byte[8192];
        this.f38472e = true;
        this.f38471d = false;
    }

    public final void a() {
        j0 j0Var = this.f38474g;
        int i7 = 0;
        if (!(j0Var != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        kotlin.jvm.internal.l0.m(j0Var);
        if (j0Var.f38472e) {
            int i8 = this.f38470c - this.f38469b;
            j0 j0Var2 = this.f38474g;
            kotlin.jvm.internal.l0.m(j0Var2);
            int i9 = 8192 - j0Var2.f38470c;
            j0 j0Var3 = this.f38474g;
            kotlin.jvm.internal.l0.m(j0Var3);
            if (!j0Var3.f38471d) {
                j0 j0Var4 = this.f38474g;
                kotlin.jvm.internal.l0.m(j0Var4);
                i7 = j0Var4.f38469b;
            }
            if (i8 > i9 + i7) {
                return;
            }
            j0 j0Var5 = this.f38474g;
            kotlin.jvm.internal.l0.m(j0Var5);
            g(j0Var5, i8);
            b();
            k0.d(this);
        }
    }

    @a7.e
    public final j0 b() {
        j0 j0Var = this.f38473f;
        if (j0Var == this) {
            j0Var = null;
        }
        j0 j0Var2 = this.f38474g;
        kotlin.jvm.internal.l0.m(j0Var2);
        j0Var2.f38473f = this.f38473f;
        j0 j0Var3 = this.f38473f;
        kotlin.jvm.internal.l0.m(j0Var3);
        j0Var3.f38474g = this.f38474g;
        this.f38473f = null;
        this.f38474g = null;
        return j0Var;
    }

    @a7.d
    public final j0 c(@a7.d j0 segment) {
        kotlin.jvm.internal.l0.p(segment, "segment");
        segment.f38474g = this;
        segment.f38473f = this.f38473f;
        j0 j0Var = this.f38473f;
        kotlin.jvm.internal.l0.m(j0Var);
        j0Var.f38474g = segment;
        this.f38473f = segment;
        return segment;
    }

    @a7.d
    public final j0 d() {
        this.f38471d = true;
        return new j0(this.f38468a, this.f38469b, this.f38470c, true, false);
    }

    @a7.d
    public final j0 e(int i7) {
        j0 j0VarE;
        if (!(i7 > 0 && i7 <= this.f38470c - this.f38469b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i7 >= 1024) {
            j0VarE = d();
        } else {
            j0VarE = k0.e();
            byte[] bArr = this.f38468a;
            byte[] bArr2 = j0VarE.f38468a;
            int i8 = this.f38469b;
            kotlin.collections.o.f1(bArr, bArr2, 0, i8, i8 + i7, 2, null);
        }
        j0VarE.f38470c = j0VarE.f38469b + i7;
        this.f38469b += i7;
        j0 j0Var = this.f38474g;
        kotlin.jvm.internal.l0.m(j0Var);
        j0Var.c(j0VarE);
        return j0VarE;
    }

    @a7.d
    public final j0 f() {
        byte[] bArr = this.f38468a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new j0(bArrCopyOf, this.f38469b, this.f38470c, false, true);
    }

    public final void g(@a7.d j0 sink, int i7) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (!sink.f38472e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i8 = sink.f38470c;
        if (i8 + i7 > 8192) {
            if (sink.f38471d) {
                throw new IllegalArgumentException();
            }
            int i9 = sink.f38469b;
            if ((i8 + i7) - i9 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f38468a;
            kotlin.collections.o.f1(bArr, bArr, 0, i9, i8, 2, null);
            sink.f38470c -= sink.f38469b;
            sink.f38469b = 0;
        }
        byte[] bArr2 = this.f38468a;
        byte[] bArr3 = sink.f38468a;
        int i10 = sink.f38470c;
        int i11 = this.f38469b;
        kotlin.collections.o.W0(bArr2, bArr3, i10, i11, i11 + i7);
        sink.f38470c += i7;
        this.f38469b += i7;
    }

    public j0(@a7.d byte[] data, int i7, int i8, boolean z7, boolean z8) {
        kotlin.jvm.internal.l0.p(data, "data");
        this.f38468a = data;
        this.f38469b = i7;
        this.f38470c = i8;
        this.f38471d = z7;
        this.f38472e = z8;
    }
}
