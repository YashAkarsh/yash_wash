package kotlin.ranges;

/* JADX INFO: loaded from: classes2.dex */
final class e implements f<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f35022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f35023b;

    public e(float f8, float f9) {
        this.f35022a = f8;
        this.f35023b = f9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.f, kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return c(((Number) comparable).floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.f
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable, Comparable comparable2) {
        return h(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public boolean c(float f8) {
        return f8 >= this.f35022a && f8 <= this.f35023b;
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Float f() {
        return Float.valueOf(this.f35023b);
    }

    public boolean equals(@a7.e Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (!isEmpty() || !((e) obj).isEmpty()) {
            e eVar = (e) obj;
            if (!(this.f35022a == eVar.f35022a)) {
                return false;
            }
            if (!(this.f35023b == eVar.f35023b)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Float d() {
        return Float.valueOf(this.f35022a);
    }

    public boolean h(float f8, float f9) {
        return f8 <= f9;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.f35022a).hashCode() * 31) + Float.valueOf(this.f35023b).hashCode();
    }

    @Override // kotlin.ranges.f, kotlin.ranges.g
    public boolean isEmpty() {
        return this.f35022a > this.f35023b;
    }

    @a7.d
    public String toString() {
        return this.f35022a + ".." + this.f35023b;
    }
}
