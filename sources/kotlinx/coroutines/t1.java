package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class t1 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f37301a;

    public t1(boolean z7) {
        this.f37301a = z7;
    }

    @Override // kotlinx.coroutines.h2
    @a7.e
    public b3 D() {
        return null;
    }

    @Override // kotlinx.coroutines.h2
    public boolean b() {
        return this.f37301a;
    }

    @a7.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(b() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
