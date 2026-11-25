package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    @a7.e
    public final Object f35998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @h5.e
    public final i5.l<Throwable, kotlin.l2> f35999b;

    /* JADX WARN: Multi-variable type inference failed */
    public f0(@a7.e Object obj, @a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        this.f35998a = obj;
        this.f35999b = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ f0 d(f0 f0Var, Object obj, i5.l lVar, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            obj = f0Var.f35998a;
        }
        if ((i7 & 2) != 0) {
            lVar = f0Var.f35999b;
        }
        return f0Var.c(obj, lVar);
    }

    @a7.e
    public final Object a() {
        return this.f35998a;
    }

    @a7.d
    public final i5.l<Throwable, kotlin.l2> b() {
        return this.f35999b;
    }

    @a7.d
    public final f0 c(@a7.e Object obj, @a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        return new f0(obj, lVar);
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return kotlin.jvm.internal.l0.g(this.f35998a, f0Var.f35998a) && kotlin.jvm.internal.l0.g(this.f35999b, f0Var.f35999b);
    }

    public int hashCode() {
        Object obj = this.f35998a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f35999b.hashCode();
    }

    @a7.d
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f35998a + ", onCancellation=" + this.f35999b + ')';
    }
}
