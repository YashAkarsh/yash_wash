package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final boolean f3551j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f3552k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f3556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f3557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f3558f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    androidx.constraintlayout.core.i f3561i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet<d> f3553a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3559g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3560h = Integer.MIN_VALUE;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3562a;

        static {
            int[] iArr = new int[b.values().length];
            f3562a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3562a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3562a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3562a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3562a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3562a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3562a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3562a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3562a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f3556d = eVar;
        this.f3557e = bVar;
    }

    private boolean s(e eVar, HashSet<e> hashSet) {
        if (hashSet.contains(eVar)) {
            return false;
        }
        hashSet.add(eVar);
        if (eVar == i()) {
            return true;
        }
        ArrayList<d> arrayListS = eVar.s();
        int size = arrayListS.size();
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = arrayListS.get(i7);
            if (dVar.u(this) && dVar.p() && s(dVar.k().i(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public void A(int i7) {
        this.f3554b = i7;
        this.f3555c = true;
    }

    public void B(int i7) {
        if (p()) {
            this.f3560h = i7;
        }
    }

    public void C(int i7) {
        if (p()) {
            this.f3559g = i7;
        }
    }

    public boolean a(d dVar, int i7) {
        return b(dVar, i7, Integer.MIN_VALUE, false);
    }

    public boolean b(d dVar, int i7, int i8, boolean z7) {
        if (dVar == null) {
            x();
            return true;
        }
        if (!z7 && !v(dVar)) {
            return false;
        }
        this.f3558f = dVar;
        if (dVar.f3553a == null) {
            dVar.f3553a = new HashSet<>();
        }
        HashSet<d> hashSet = this.f3558f.f3553a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f3559g = i7;
        this.f3560h = i8;
        return true;
    }

    public void c(d dVar, HashMap<e, e> map) {
        HashSet<d> hashSet;
        d dVar2 = this.f3558f;
        if (dVar2 != null && (hashSet = dVar2.f3553a) != null) {
            hashSet.remove(this);
        }
        d dVar3 = dVar.f3558f;
        if (dVar3 != null) {
            this.f3558f = map.get(dVar.f3558f.f3556d).r(dVar3.l());
        } else {
            this.f3558f = null;
        }
        d dVar4 = this.f3558f;
        if (dVar4 != null) {
            if (dVar4.f3553a == null) {
                dVar4.f3553a = new HashSet<>();
            }
            this.f3558f.f3553a.add(this);
        }
        this.f3559g = dVar.f3559g;
        this.f3560h = dVar.f3560h;
    }

    public void d(int i7, ArrayList<androidx.constraintlayout.core.widgets.analyzer.o> arrayList, androidx.constraintlayout.core.widgets.analyzer.o oVar) {
        HashSet<d> hashSet = this.f3553a;
        if (hashSet != null) {
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.core.widgets.analyzer.i.a(it.next().f3556d, i7, arrayList, oVar);
            }
        }
    }

    public HashSet<d> e() {
        return this.f3553a;
    }

    public int f() {
        if (this.f3555c) {
            return this.f3554b;
        }
        return 0;
    }

    public int g() {
        d dVar;
        if (this.f3556d.l0() == 8) {
            return 0;
        }
        return (this.f3560h == Integer.MIN_VALUE || (dVar = this.f3558f) == null || dVar.f3556d.l0() != 8) ? this.f3559g : this.f3560h;
    }

    public final d h() {
        switch (a.f3562a[this.f3557e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f3556d.S;
            case 3:
                return this.f3556d.Q;
            case 4:
                return this.f3556d.T;
            case 5:
                return this.f3556d.R;
            default:
                throw new AssertionError(this.f3557e.name());
        }
    }

    public e i() {
        return this.f3556d;
    }

    public androidx.constraintlayout.core.i j() {
        return this.f3561i;
    }

    public d k() {
        return this.f3558f;
    }

    public b l() {
        return this.f3557e;
    }

    public boolean m() {
        HashSet<d> hashSet = this.f3553a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().h().p()) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        HashSet<d> hashSet = this.f3553a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean o() {
        return this.f3555c;
    }

    public boolean p() {
        return this.f3558f != null;
    }

    public boolean q(e eVar) {
        if (s(eVar, new HashSet<>())) {
            return false;
        }
        e eVarU = i().U();
        return eVarU == eVar || eVar.U() == eVarU;
    }

    public boolean r(e eVar, d dVar) {
        return q(eVar);
    }

    public boolean t() {
        switch (a.f3562a[this.f3557e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                throw new AssertionError(this.f3557e.name());
        }
    }

    public String toString() {
        return this.f3556d.y() + ":" + this.f3557e.toString();
    }

    public boolean u(d dVar) {
        b bVarL = dVar.l();
        b bVar = this.f3557e;
        if (bVarL == bVar) {
            return true;
        }
        switch (a.f3562a[bVar.ordinal()]) {
            case 1:
                return bVarL != b.BASELINE;
            case 2:
            case 3:
            case 7:
                return bVarL == b.LEFT || bVarL == b.RIGHT || bVarL == b.CENTER_X;
            case 4:
            case 5:
            case 6:
            case 8:
                return bVarL == b.TOP || bVarL == b.BOTTOM || bVarL == b.CENTER_Y || bVarL == b.BASELINE;
            case 9:
                return false;
            default:
                throw new AssertionError(this.f3557e.name());
        }
    }

    public boolean v(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarL = dVar.l();
        b bVar = this.f3557e;
        if (bVarL == bVar) {
            return bVar != b.BASELINE || (dVar.i().q0() && i().q0());
        }
        switch (a.f3562a[bVar.ordinal()]) {
            case 1:
                return (bVarL == b.BASELINE || bVarL == b.CENTER_X || bVarL == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z7 = bVarL == b.LEFT || bVarL == b.RIGHT;
                if (dVar.i() instanceof h) {
                    return z7 || bVarL == b.CENTER_X;
                }
                return z7;
            case 4:
            case 5:
                boolean z8 = bVarL == b.TOP || bVarL == b.BOTTOM;
                if (dVar.i() instanceof h) {
                    return z8 || bVarL == b.CENTER_Y;
                }
                return z8;
            case 6:
                return (bVarL == b.LEFT || bVarL == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f3557e.name());
        }
    }

    public boolean w() {
        switch (a.f3562a[this.f3557e.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 7:
                return false;
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
                return true;
            default:
                throw new AssertionError(this.f3557e.name());
        }
    }

    public void x() {
        HashSet<d> hashSet;
        d dVar = this.f3558f;
        if (dVar != null && (hashSet = dVar.f3553a) != null) {
            hashSet.remove(this);
            if (this.f3558f.f3553a.size() == 0) {
                this.f3558f.f3553a = null;
            }
        }
        this.f3553a = null;
        this.f3558f = null;
        this.f3559g = 0;
        this.f3560h = Integer.MIN_VALUE;
        this.f3555c = false;
        this.f3554b = 0;
    }

    public void y() {
        this.f3555c = false;
        this.f3554b = 0;
    }

    public void z(androidx.constraintlayout.core.c cVar) {
        androidx.constraintlayout.core.i iVar = this.f3561i;
        if (iVar == null) {
            this.f3561i = new androidx.constraintlayout.core.i(androidx.constraintlayout.core.i.b.UNRESTRICTED, (String) null);
        } else {
            iVar.h();
        }
    }
}
