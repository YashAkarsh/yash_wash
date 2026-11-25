package kotlin.ranges;

/* JADX INFO: loaded from: classes2.dex */
final class d implements f<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f35020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f35021b;

    public d(double d8, double d9) {
        this.f35020a = d8;
        this.f35021b = d9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.f, kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return c(((Number) comparable).doubleValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.f
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable, Comparable comparable2) {
        return h(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    public boolean c(double d8) {
        return d8 >= this.f35020a && d8 <= this.f35021b;
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Double f() {
        return Double.valueOf(this.f35021b);
    }

    public boolean equals(@a7.e Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (!isEmpty() || !((d) obj).isEmpty()) {
            d dVar = (d) obj;
            if (!(this.f35020a == dVar.f35020a)) {
                return false;
            }
            if (!(this.f35021b == dVar.f35021b)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.ranges.g
    @a7.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Double d() {
        return Double.valueOf(this.f35020a);
    }

    public boolean h(double d8, double d9) {
        return d8 <= d9;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.f35020a).hashCode() * 31) + Double.valueOf(this.f35021b).hashCode();
    }

    @Override // kotlin.ranges.f, kotlin.ranges.g
    public boolean isEmpty() {
        return this.f35020a > this.f35021b;
    }

    @a7.d
    public String toString() {
        return this.f35020a + ".." + this.f35021b;
    }
}
