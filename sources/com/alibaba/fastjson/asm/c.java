package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f12546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a f12547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    e[] f12548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final e f12550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final e f12551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final e f12552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    e[] f12553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f12556l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f12557m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f12558n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f12559o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    d f12560p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    d f12561q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    i f12562r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    i f12563s;

    public c() {
        this(0);
    }

    private e a(e eVar) {
        e[] eVarArr = this.f12548d;
        e eVar2 = eVarArr[eVar.f12575h % eVarArr.length];
        while (eVar2 != null && (eVar2.f12569b != eVar.f12569b || !eVar.a(eVar2))) {
            eVar2 = eVar2.f12576i;
        }
        return eVar2;
    }

    private e g(String str) {
        this.f12551g.c(8, str, null, null);
        e eVarA = a(this.f12551g);
        if (eVarA != null) {
            return eVarA;
        }
        this.f12547c.c(8, h(str));
        int i7 = this.f12546b;
        this.f12546b = i7 + 1;
        e eVar = new e(i7, this.f12551g);
        i(eVar);
        return eVar;
    }

    private void i(e eVar) {
        if (this.f12546b > this.f12549e) {
            int length = this.f12548d.length;
            int i7 = (length * 2) + 1;
            e[] eVarArr = new e[i7];
            for (int i8 = length - 1; i8 >= 0; i8--) {
                e eVar2 = this.f12548d[i8];
                while (eVar2 != null) {
                    int i9 = eVar2.f12575h % i7;
                    e eVar3 = eVar2.f12576i;
                    eVar2.f12576i = eVarArr[i9];
                    eVarArr[i9] = eVar2;
                    eVar2 = eVar3;
                }
            }
            this.f12548d = eVarArr;
            this.f12549e = (int) (((double) i7) * 0.75d);
        }
        int i10 = eVar.f12575h;
        e[] eVarArr2 = this.f12548d;
        int length2 = i10 % eVarArr2.length;
        eVar.f12576i = eVarArr2[length2];
        eVarArr2[length2] = eVar;
    }

    public e b(String str) {
        this.f12551g.c(7, str, null, null);
        e eVarA = a(this.f12551g);
        if (eVarA != null) {
            return eVarA;
        }
        this.f12547c.c(7, h(str));
        int i7 = this.f12546b;
        this.f12546b = i7 + 1;
        e eVar = new e(i7, this.f12551g);
        i(eVar);
        return eVar;
    }

    e c(Object obj) {
        if (!(obj instanceof Integer)) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            if (obj instanceof k) {
                k kVar = (k) obj;
                return b(kVar.f12642a == 10 ? kVar.f() : kVar.d());
            }
            throw new IllegalArgumentException("value " + obj);
        }
        int iIntValue = ((Integer) obj).intValue();
        this.f12550f.b(iIntValue);
        e eVarA = a(this.f12550f);
        if (eVarA != null) {
            return eVarA;
        }
        this.f12547c.d(3).f(iIntValue);
        int i7 = this.f12546b;
        this.f12546b = i7 + 1;
        e eVar = new e(i7, this.f12550f);
        i(eVar);
        return eVar;
    }

    e d(String str, String str2, String str3) {
        this.f12552h.c(9, str, str2, str3);
        e eVarA = a(this.f12552h);
        if (eVarA != null) {
            return eVarA;
        }
        int i7 = b(str).f12568a;
        this.f12547c.c(9, i7).g(f(str2, str3).f12568a);
        int i8 = this.f12546b;
        this.f12546b = i8 + 1;
        e eVar = new e(i8, this.f12552h);
        i(eVar);
        return eVar;
    }

    e e(String str, String str2, String str3, boolean z7) {
        int i7 = z7 ? 11 : 10;
        this.f12552h.c(i7, str, str2, str3);
        e eVarA = a(this.f12552h);
        if (eVarA != null) {
            return eVarA;
        }
        this.f12547c.c(i7, b(str).f12568a).g(f(str2, str3).f12568a);
        int i8 = this.f12546b;
        this.f12546b = i8 + 1;
        e eVar = new e(i8, this.f12552h);
        i(eVar);
        return eVar;
    }

    public e f(String str, String str2) {
        this.f12551g.c(12, str, str2, null);
        e eVarA = a(this.f12551g);
        if (eVarA != null) {
            return eVarA;
        }
        int iH = h(str);
        this.f12547c.c(12, iH).g(h(str2));
        int i7 = this.f12546b;
        this.f12546b = i7 + 1;
        e eVar = new e(i7, this.f12551g);
        i(eVar);
        return eVar;
    }

    public int h(String str) {
        this.f12550f.c(1, str, null, null);
        e eVarA = a(this.f12550f);
        if (eVarA == null) {
            this.f12547c.d(1).h(str);
            int i7 = this.f12546b;
            this.f12546b = i7 + 1;
            eVarA = new e(i7, this.f12550f);
            i(eVarA);
        }
        return eVarA.f12568a;
    }

    public byte[] j() {
        int iM = (this.f12558n * 2) + 24;
        int i7 = 0;
        for (d dVar = this.f12560p; dVar != null; dVar = dVar.f12564a) {
            i7++;
            iM += dVar.a();
        }
        int i8 = 0;
        for (i iVar = this.f12562r; iVar != null; iVar = iVar.f12590a) {
            i8++;
            iM += iVar.m();
        }
        a aVar = new a(iM + this.f12547c.f12538b);
        aVar.f(-889275714).f(this.f12545a);
        a aVarG = aVar.g(this.f12546b);
        a aVar2 = this.f12547c;
        aVarG.e(aVar2.f12537a, 0, aVar2.f12538b);
        aVar.g(this.f12554j & (-393217)).g(this.f12555k).g(this.f12557m);
        aVar.g(this.f12558n);
        for (int i9 = 0; i9 < this.f12558n; i9++) {
            aVar.g(this.f12559o[i9]);
        }
        aVar.g(i7);
        for (d dVar2 = this.f12560p; dVar2 != null; dVar2 = dVar2.f12564a) {
            dVar2.b(aVar);
        }
        aVar.g(i8);
        for (i iVar2 = this.f12562r; iVar2 != null; iVar2 = iVar2.f12590a) {
            iVar2.n(aVar);
        }
        aVar.g(0);
        return aVar.f12537a;
    }

    public void k(int i7, int i8, String str, String str2, String[] strArr) {
        this.f12545a = i7;
        this.f12554j = i8;
        this.f12555k = b(str).f12568a;
        this.f12556l = str;
        this.f12557m = str2 == null ? 0 : b(str2).f12568a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f12558n = length;
        this.f12559o = new int[length];
        for (int i9 = 0; i9 < this.f12558n; i9++) {
            this.f12559o[i9] = b(strArr[i9]).f12568a;
        }
    }

    private c(int i7) {
        this.f12546b = 1;
        this.f12547c = new a();
        e[] eVarArr = new e[256];
        this.f12548d = eVarArr;
        this.f12549e = (int) (((double) eVarArr.length) * 0.75d);
        this.f12550f = new e();
        this.f12551g = new e();
        this.f12552h = new e();
    }
}
