package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private Object[] f36934a = new Object[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36936c;

    private final void c() {
        Object[] objArr = this.f36934a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        kotlin.collections.o.l1(objArr, objArr2, 0, this.f36935b, 0, 10, null);
        Object[] objArr3 = this.f36934a;
        int length2 = objArr3.length;
        int i7 = this.f36935b;
        kotlin.collections.o.l1(objArr3, objArr2, length2 - i7, 0, i7, 4, null);
        this.f36934a = objArr2;
        this.f36935b = 0;
        this.f36936c = length;
    }

    public final void a(@a7.d T t7) {
        Object[] objArr = this.f36934a;
        int i7 = this.f36936c;
        objArr[i7] = t7;
        int length = (objArr.length - 1) & (i7 + 1);
        this.f36936c = length;
        if (length == this.f36935b) {
            c();
        }
    }

    public final void b() {
        this.f36935b = 0;
        this.f36936c = 0;
        this.f36934a = new Object[this.f36934a.length];
    }

    public final boolean d() {
        return this.f36935b == this.f36936c;
    }

    @a7.e
    public final T e() {
        int i7 = this.f36935b;
        if (i7 == this.f36936c) {
            return null;
        }
        Object[] objArr = this.f36934a;
        T t7 = (T) objArr[i7];
        objArr[i7] = null;
        this.f36935b = (i7 + 1) & (objArr.length - 1);
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
