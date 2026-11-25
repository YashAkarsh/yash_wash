package androidx.constraintlayout.core.parser;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ArrayList<String> f3195i;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f3195i = arrayList;
        arrayList.add("ConstraintSets");
        f3195i.add("Variables");
        f3195i.add("Generate");
        f3195i.add("Transitions");
        f3195i.add("KeyFrames");
        f3195i.add("KeyAttributes");
        f3195i.add("KeyPositions");
        f3195i.add("KeyCycles");
    }

    public d(char[] cArr) {
        super(cArr);
    }

    public static c d0(String str, c cVar) {
        d dVar = new d(str.toCharArray());
        dVar.u(0L);
        dVar.s(str.length() - 1);
        dVar.i0(cVar);
        return dVar;
    }

    public static c z(char[] cArr) {
        return new d(cArr);
    }

    public String e0() {
        return b();
    }

    public c f0() {
        if (this.f3187h.size() > 0) {
            return this.f3187h.get(0);
        }
        return null;
    }

    public void i0(c cVar) {
        if (this.f3187h.size() > 0) {
            this.f3187h.set(0, cVar);
        } else {
            this.f3187h.add(cVar);
        }
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String v(int i7, int i8) {
        StringBuilder sb = new StringBuilder(f());
        a(sb, i7);
        String strB = b();
        if (this.f3187h.size() <= 0) {
            return strB + ": <> ";
        }
        sb.append(strB);
        sb.append(": ");
        if (f3195i.contains(strB)) {
            i8 = 3;
        }
        if (i8 > 0) {
            sb.append(this.f3187h.get(0).v(i7, i8 - 1));
        } else {
            String strW = this.f3187h.get(0).w();
            if (strW.length() + i7 < c.f3188f) {
                sb.append(strW);
            } else {
                sb.append(this.f3187h.get(0).v(i7, i8 - 1));
            }
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    protected String w() {
        if (this.f3187h.size() <= 0) {
            return f() + b() + ": <> ";
        }
        return f() + b() + ": " + this.f3187h.get(0).w();
    }
}
