package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class e extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f3196h;

    public e(char[] cArr) {
        super(cArr);
        this.f3196h = Float.NaN;
    }

    public static c x(char[] cArr) {
        return new e(cArr);
    }

    public void A(float f8) {
        this.f3196h = f8;
    }

    @Override // androidx.constraintlayout.core.parser.c
    public float h() {
        if (Float.isNaN(this.f3196h)) {
            this.f3196h = Float.parseFloat(b());
        }
        return this.f3196h;
    }

    @Override // androidx.constraintlayout.core.parser.c
    public int j() {
        if (Float.isNaN(this.f3196h)) {
            this.f3196h = Integer.parseInt(b());
        }
        return (int) this.f3196h;
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String v(int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        a(sb, i7);
        float fH = h();
        int i9 = (int) fH;
        if (i9 == fH) {
            sb.append(i9);
        } else {
            sb.append(fH);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String w() {
        float fH = h();
        int i7 = (int) fH;
        if (i7 == fH) {
            return "" + i7;
        }
        return "" + fH;
    }

    public boolean z() {
        float fH = h();
        return ((float) ((int) fH)) == fH;
    }

    public e(float f8) {
        super(null);
        this.f3196h = f8;
    }
}
