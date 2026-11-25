package kotlinx.coroutines.internal;

import kotlin.l2;
import kotlinx.coroutines.a3;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.q1;

/* JADX INFO: loaded from: classes3.dex */
final class g0 extends a3 implements f1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final Throwable f36984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private final String f36985c;

    public /* synthetic */ g0(Throwable th, String str, int i7, kotlin.jvm.internal.w wVar) {
        this(th, (i7 & 2) != 0 ? null : str);
    }

    private final Void s1() {
        String strC;
        if (this.f36984b == null) {
            f0.e();
            throw new kotlin.y();
        }
        String str = this.f36985c;
        String str2 = "";
        if (str != null && (strC = kotlin.jvm.internal.l0.C(". ", str)) != null) {
            str2 = strC;
        }
        throw new IllegalStateException(kotlin.jvm.internal.l0.C("Module with the Main dispatcher had failed to initialize", str2), this.f36984b);
    }

    @Override // kotlinx.coroutines.o0
    public boolean Y0(@a7.d kotlin.coroutines.g gVar) {
        s1();
        throw new kotlin.y();
    }

    @Override // kotlinx.coroutines.a3, kotlinx.coroutines.o0
    @a7.d
    public kotlinx.coroutines.o0 a1(int i7) {
        s1();
        throw new kotlin.y();
    }

    @Override // kotlinx.coroutines.a3
    @a7.d
    public a3 e1() {
        return this;
    }

    @Override // kotlinx.coroutines.f1
    @a7.d
    public q1 p0(long j7, @a7.d Runnable runnable, @a7.d kotlin.coroutines.g gVar) {
        s1();
        throw new kotlin.y();
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public Void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        s1();
        throw new kotlin.y();
    }

    @Override // kotlinx.coroutines.f1
    @a7.e
    public Object s0(long j7, @a7.d kotlin.coroutines.d<?> dVar) {
        s1();
        throw new kotlin.y();
    }

    @Override // kotlinx.coroutines.a3, kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.f36984b;
        sb.append(th != null ? kotlin.jvm.internal.l0.C(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.f1
    @a7.d
    /* JADX INFO: renamed from: w1, reason: merged with bridge method [inline-methods] */
    public Void s(long j7, @a7.d kotlinx.coroutines.q<? super l2> qVar) {
        s1();
        throw new kotlin.y();
    }

    public g0(@a7.e Throwable th, @a7.e String str) {
        this.f36984b = th;
        this.f36985c = str;
    }
}
