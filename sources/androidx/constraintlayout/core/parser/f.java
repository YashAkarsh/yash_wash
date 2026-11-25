package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f extends b implements Iterable<d> {

    private class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        f f3197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3198b = 0;

        public a(f fVar) {
            this.f3197a = fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3198b < this.f3197a.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            d dVar = (d) this.f3197a.f3187h.get(this.f3198b);
            this.f3198b++;
            return dVar;
        }
    }

    public f(char[] cArr) {
        super(cArr);
    }

    public static f d0(char[] cArr) {
        return new f(cArr);
    }

    public String e0() {
        return v(0, 0);
    }

    @Override // java.lang.Iterable
    public Iterator<d> iterator() {
        return new a(this);
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String v(int i7, int i8) {
        StringBuilder sb = new StringBuilder(f());
        sb.append("{\n");
        boolean z7 = true;
        for (c cVar : this.f3187h) {
            if (z7) {
                z7 = false;
            } else {
                sb.append(",\n");
            }
            sb.append(cVar.v(c.f3189g + i7, i8 - 1));
        }
        sb.append("\n");
        a(sb, i7);
        sb.append(com.alipay.sdk.util.j.f13808d);
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String w() {
        StringBuilder sb = new StringBuilder(f() + "{ ");
        boolean z7 = true;
        for (c cVar : this.f3187h) {
            if (z7) {
                z7 = false;
            } else {
                sb.append(", ");
            }
            sb.append(cVar.w());
        }
        sb.append(" }");
        return sb.toString();
    }
}
