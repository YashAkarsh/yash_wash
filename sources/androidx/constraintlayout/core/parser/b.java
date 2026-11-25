package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList<c> f3187h;

    public b(char[] cArr) {
        super(cArr);
        this.f3187h = new ArrayList<>();
    }

    public static c z(char[] cArr) {
        return new b(cArr);
    }

    public c A(int i7) throws h {
        if (i7 >= 0 && i7 < this.f3187h.size()) {
            return this.f3187h.get(i7);
        }
        throw new h("no element at index " + i7, this);
    }

    public c B(String str) throws h {
        Iterator<c> it = this.f3187h.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.b().equals(str)) {
                return dVar.f0();
            }
        }
        throw new h("no element for key <" + str + ">", this);
    }

    public a D(int i7) throws h {
        c cVarA = A(i7);
        if (cVarA instanceof a) {
            return (a) cVarA;
        }
        throw new h("no array at index " + i7, this);
    }

    public a F(String str) throws h {
        c cVarB = B(str);
        if (cVarB instanceof a) {
            return (a) cVarB;
        }
        throw new h("no array found for key <" + str + ">, found [" + cVarB.m() + "] : " + cVarB, this);
    }

    public a G(String str) {
        c cVarT = T(str);
        if (cVarT instanceof a) {
            return (a) cVarT;
        }
        return null;
    }

    public boolean H(int i7) throws h {
        c cVarA = A(i7);
        if (cVarA instanceof j) {
            return ((j) cVarA).z();
        }
        throw new h("no boolean at index " + i7, this);
    }

    public boolean I(String str) throws h {
        c cVarB = B(str);
        if (cVarB instanceof j) {
            return ((j) cVarB).z();
        }
        throw new h("no boolean found for key <" + str + ">, found [" + cVarB.m() + "] : " + cVarB, this);
    }

    public float J(int i7) throws h {
        c cVarA = A(i7);
        if (cVarA != null) {
            return cVarA.h();
        }
        throw new h("no float at index " + i7, this);
    }

    public float K(String str) throws h {
        c cVarB = B(str);
        if (cVarB != null) {
            return cVarB.h();
        }
        throw new h("no float found for key <" + str + ">, found [" + cVarB.m() + "] : " + cVarB, this);
    }

    public float L(String str) {
        c cVarT = T(str);
        if (cVarT instanceof e) {
            return cVarT.h();
        }
        return Float.NaN;
    }

    public int M(int i7) throws h {
        c cVarA = A(i7);
        if (cVarA != null) {
            return cVarA.j();
        }
        throw new h("no int at index " + i7, this);
    }

    public int N(String str) throws h {
        c cVarB = B(str);
        if (cVarB != null) {
            return cVarB.j();
        }
        throw new h("no int found for key <" + str + ">, found [" + cVarB.m() + "] : " + cVarB, this);
    }

    public f O(int i7) throws h {
        c cVarA = A(i7);
        if (cVarA instanceof f) {
            return (f) cVarA;
        }
        throw new h("no object at index " + i7, this);
    }

    public f P(String str) throws h {
        c cVarB = B(str);
        if (cVarB instanceof f) {
            return (f) cVarB;
        }
        throw new h("no object found for key <" + str + ">, found [" + cVarB.m() + "] : " + cVarB, this);
    }

    public f Q(String str) {
        c cVarT = T(str);
        if (cVarT instanceof f) {
            return (f) cVarT;
        }
        return null;
    }

    public c S(int i7) {
        if (i7 < 0 || i7 >= this.f3187h.size()) {
            return null;
        }
        return this.f3187h.get(i7);
    }

    public c T(String str) {
        Iterator<c> it = this.f3187h.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.b().equals(str)) {
                return dVar.f0();
            }
        }
        return null;
    }

    public String U(int i7) throws h {
        c cVarA = A(i7);
        if (cVarA instanceof i) {
            return cVarA.b();
        }
        throw new h("no string at index " + i7, this);
    }

    public String V(String str) throws h {
        c cVarB = B(str);
        if (cVarB instanceof i) {
            return cVarB.b();
        }
        throw new h("no string found for key <" + str + ">, found [" + (cVarB != null ? cVarB.m() : null) + "] : " + cVarB, this);
    }

    public String W(int i7) {
        c cVarS = S(i7);
        if (cVarS instanceof i) {
            return cVarS.b();
        }
        return null;
    }

    public String X(String str) {
        c cVarT = T(str);
        if (cVarT instanceof i) {
            return cVarT.b();
        }
        return null;
    }

    public boolean Y(String str) {
        for (c cVar : this.f3187h) {
            if ((cVar instanceof d) && ((d) cVar).b().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> Z() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (c cVar : this.f3187h) {
            if (cVar instanceof d) {
                arrayList.add(((d) cVar).b());
            }
        }
        return arrayList;
    }

    public void a0(String str, c cVar) {
        Iterator<c> it = this.f3187h.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.b().equals(str)) {
                dVar.i0(cVar);
                return;
            }
        }
        this.f3187h.add((d) d.d0(str, cVar));
    }

    public void b0(String str, float f8) {
        a0(str, new e(f8));
    }

    public void c0(String str) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f3187h) {
            if (((d) cVar).b().equals(str)) {
                arrayList.add(cVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f3187h.remove((c) it.next());
        }
    }

    public int size() {
        return this.f3187h.size();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (c cVar : this.f3187h) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cVar);
        }
        return super.toString() + " = <" + ((Object) sb) + " >";
    }

    public void x(c cVar) {
        this.f3187h.add(cVar);
        if (g.f3200d) {
            System.out.println("added element " + cVar + " to " + this);
        }
    }
}
