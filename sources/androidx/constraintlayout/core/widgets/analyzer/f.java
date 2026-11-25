package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f3452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3455g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f3449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3450b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3451c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    a f3453e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3456h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    g f3457i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3458j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    List<d> f3459k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    List<f> f3460l = new ArrayList();

    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f3452d = pVar;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        Iterator<f> it = this.f3460l.iterator();
        while (it.hasNext()) {
            if (!it.next().f3458j) {
                return;
            }
        }
        this.f3451c = true;
        d dVar2 = this.f3449a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f3450b) {
            this.f3452d.a(this);
            return;
        }
        f fVar = null;
        int i7 = 0;
        for (f fVar2 : this.f3460l) {
            if (!(fVar2 instanceof g)) {
                i7++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i7 == 1 && fVar.f3458j) {
            g gVar = this.f3457i;
            if (gVar != null) {
                if (!gVar.f3458j) {
                    return;
                } else {
                    this.f3454f = this.f3456h * gVar.f3455g;
                }
            }
            e(fVar.f3455g + this.f3454f);
        }
        d dVar3 = this.f3449a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f3459k.add(dVar);
        if (this.f3458j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f3460l.clear();
        this.f3459k.clear();
        this.f3458j = false;
        this.f3455g = 0;
        this.f3451c = false;
        this.f3450b = false;
    }

    public String d() {
        String str;
        String strY = this.f3452d.f3512b.y();
        a aVar = this.f3453e;
        if (aVar == a.LEFT || aVar == a.RIGHT) {
            str = strY + "_HORIZONTAL";
        } else {
            str = strY + "_VERTICAL";
        }
        return str + ":" + this.f3453e.name();
    }

    public void e(int i7) {
        if (this.f3458j) {
            return;
        }
        this.f3458j = true;
        this.f3455g = i7;
        for (d dVar : this.f3459k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3452d.f3512b.y());
        sb.append(":");
        sb.append(this.f3453e);
        sb.append("(");
        sb.append(this.f3458j ? Integer.valueOf(this.f3455g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f3460l.size());
        sb.append(":d=");
        sb.append(this.f3459k.size());
        sb.append(">");
        return sb.toString();
    }
}
