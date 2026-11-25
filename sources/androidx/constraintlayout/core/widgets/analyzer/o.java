package androidx.constraintlayout.core.widgets.analyzer;

import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f3495g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static int f3496h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3498b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f3500d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<androidx.constraintlayout.core.widgets.e> f3497a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f3499c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<a> f3501e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3502f = -1;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<androidx.constraintlayout.core.widgets.e> f3503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f3506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3507e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3508f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f3509g;

        public a(androidx.constraintlayout.core.widgets.e eVar, androidx.constraintlayout.core.e eVar2, int i7) {
            this.f3503a = new WeakReference<>(eVar);
            this.f3504b = eVar2.O(eVar.Q);
            this.f3505c = eVar2.O(eVar.R);
            this.f3506d = eVar2.O(eVar.S);
            this.f3507e = eVar2.O(eVar.T);
            this.f3508f = eVar2.O(eVar.U);
            this.f3509g = i7;
        }

        public void a() {
            androidx.constraintlayout.core.widgets.e eVar = this.f3503a.get();
            if (eVar != null) {
                eVar.p1(this.f3504b, this.f3505c, this.f3506d, this.f3507e, this.f3508f, this.f3509g);
            }
        }
    }

    public o(int i7) {
        int i8 = f3496h;
        f3496h = i8 + 1;
        this.f3498b = i8;
        this.f3500d = i7;
    }

    private boolean e(androidx.constraintlayout.core.widgets.e eVar) {
        return this.f3497a.contains(eVar);
    }

    private String h() {
        int i7 = this.f3500d;
        if (i7 == 0) {
            return "Horizontal";
        }
        if (i7 == 1) {
            return "Vertical";
        }
        return i7 == 2 ? "Both" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    private int k(int i7, androidx.constraintlayout.core.widgets.e eVar) {
        androidx.constraintlayout.core.widgets.e.b bVarZ = eVar.z(i7);
        if (bVarZ == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT || bVarZ == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT || bVarZ == androidx.constraintlayout.core.widgets.e.b.FIXED) {
            return i7 == 0 ? eVar.m0() : eVar.D();
        }
        return -1;
    }

    private int q(androidx.constraintlayout.core.e eVar, ArrayList<androidx.constraintlayout.core.widgets.e> arrayList, int i7) {
        int iO;
        int iO2;
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) arrayList.get(0).U();
        eVar.Y();
        fVar.g(eVar, false);
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            arrayList.get(i8).g(eVar, false);
        }
        if (i7 == 0 && fVar.M1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(fVar, eVar, arrayList, 0);
        }
        if (i7 == 1 && fVar.N1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(fVar, eVar, arrayList, 1);
        }
        try {
            eVar.T();
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        this.f3501e = new ArrayList<>();
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            this.f3501e.add(new a(arrayList.get(i9), eVar, i7));
        }
        if (i7 == 0) {
            iO = eVar.O(fVar.Q);
            iO2 = eVar.O(fVar.S);
            eVar.Y();
        } else {
            iO = eVar.O(fVar.R);
            iO2 = eVar.O(fVar.T);
            eVar.Y();
        }
        return iO2 - iO;
    }

    public boolean a(androidx.constraintlayout.core.widgets.e eVar) {
        if (this.f3497a.contains(eVar)) {
            return false;
        }
        this.f3497a.add(eVar);
        return true;
    }

    public void b() {
        if (this.f3501e != null && this.f3499c) {
            for (int i7 = 0; i7 < this.f3501e.size(); i7++) {
                this.f3501e.get(i7).a();
            }
        }
    }

    public void c(ArrayList<o> arrayList) {
        int size = this.f3497a.size();
        if (this.f3502f != -1 && size > 0) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                o oVar = arrayList.get(i7);
                if (this.f3502f == oVar.f3498b) {
                    m(this.f3500d, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void d() {
        this.f3497a.clear();
    }

    public int f() {
        return this.f3498b;
    }

    public int g() {
        return this.f3500d;
    }

    public boolean i(o oVar) {
        for (int i7 = 0; i7 < this.f3497a.size(); i7++) {
            if (oVar.e(this.f3497a.get(i7))) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        return this.f3499c;
    }

    public int l(androidx.constraintlayout.core.e eVar, int i7) {
        if (this.f3497a.size() == 0) {
            return 0;
        }
        return q(eVar, this.f3497a, i7);
    }

    public void m(int i7, o oVar) {
        for (androidx.constraintlayout.core.widgets.e eVar : this.f3497a) {
            oVar.a(eVar);
            if (i7 == 0) {
                eVar.S0 = oVar.f();
            } else {
                eVar.T0 = oVar.f();
            }
        }
        this.f3502f = oVar.f3498b;
    }

    public void n(boolean z7) {
        this.f3499c = z7;
    }

    public void o(int i7) {
        this.f3500d = i7;
    }

    public int p() {
        return this.f3497a.size();
    }

    public String toString() {
        String str = h() + " [" + this.f3498b + "] <";
        Iterator<androidx.constraintlayout.core.widgets.e> it = this.f3497a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().y();
        }
        return str + " >";
    }
}
