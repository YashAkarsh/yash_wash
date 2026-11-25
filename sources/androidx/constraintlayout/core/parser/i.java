package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class i extends c {
    public i(char[] cArr) {
        super(cArr);
    }

    public static c x(char[] cArr) {
        return new i(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String v(int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        a(sb, i7);
        sb.append("'");
        sb.append(b());
        sb.append("'");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String w() {
        return "'" + b() + "'";
    }
}
