package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    public a(char[] cArr) {
        super(cArr);
    }

    public static c z(char[] cArr) {
        return new a(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String v(int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        String strW = w();
        if (i8 > 0 || strW.length() + i7 >= c.f3188f) {
            sb.append("[\n");
            boolean z7 = true;
            for (c cVar : this.f3187h) {
                if (z7) {
                    z7 = false;
                } else {
                    sb.append(",\n");
                }
                a(sb, c.f3189g + i7);
                sb.append(cVar.v(c.f3189g + i7, i8 - 1));
            }
            sb.append("\n");
            a(sb, i7);
            sb.append("]");
        } else {
            sb.append(strW);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String w() {
        StringBuilder sb = new StringBuilder(f() + "[");
        boolean z7 = true;
        for (int i7 = 0; i7 < this.f3187h.size(); i7++) {
            if (z7) {
                z7 = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.f3187h.get(i7).w());
        }
        return ((Object) sb) + "]";
    }
}
