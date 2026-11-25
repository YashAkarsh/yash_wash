package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class h extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3215c;

    public h(String str, c cVar) {
        this.f3213a = str;
        if (cVar != null) {
            this.f3215c = cVar.m();
            this.f3214b = cVar.k();
        } else {
            this.f3215c = "unknown";
            this.f3214b = 0;
        }
    }

    public String a() {
        return this.f3213a + " (" + this.f3215c + " at line " + this.f3214b + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + a();
    }
}
