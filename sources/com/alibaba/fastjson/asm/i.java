package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    i f12590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c f12591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f12596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f12597h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12599j;

    public i(c cVar, int i7, String str, String str2, String str3, String[] strArr) {
        if (cVar.f12562r == null) {
            cVar.f12562r = this;
        } else {
            cVar.f12563s.f12590a = this;
        }
        cVar.f12563s = this;
        this.f12591b = cVar;
        this.f12592c = i7;
        this.f12593d = cVar.h(str);
        this.f12594e = cVar.h(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f12595f = length;
        this.f12596g = new int[length];
        for (int i8 = 0; i8 < this.f12595f; i8++) {
            this.f12596g[i8] = cVar.b(strArr[i8]).f12568a;
        }
    }

    @Override // com.alibaba.fastjson.asm.h
    public void a(int i7, int i8) {
        this.f12597h.d(132).b(i7, i8);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void b(int i7, f fVar) {
        if ((fVar.f12577a & 2) != 0 && fVar.f12578b - this.f12597h.f12538b < -32768) {
            throw new UnsupportedOperationException();
        }
        this.f12597h.d(i7);
        a aVar = this.f12597h;
        fVar.b(this, aVar, aVar.f12538b - 1);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void c(int i7, String str) {
        this.f12597h.c(i7, this.f12591b.b(str).f12568a);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void d(int i7, String str, String str2, String str3) {
        this.f12597h.c(i7, this.f12591b.d(str, str2, str3).f12568a);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void e(int i7, int i8) {
        this.f12597h.b(i7, i8);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void f(int i7) {
        this.f12597h.d(i7);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void g(int i7, int i8) {
        this.f12598i = i7;
        this.f12599j = i8;
    }

    @Override // com.alibaba.fastjson.asm.h
    public void h(int i7, int i8) {
        if (i8 < 4 && i7 != 169) {
            this.f12597h.d((i7 < 54 ? ((i7 - 21) << 2) + 26 : ((i7 - 54) << 2) + 59) + i8);
        } else if (i8 >= 256) {
            this.f12597h.d(196).c(i7, i8);
        } else {
            this.f12597h.b(i7, i8);
        }
    }

    @Override // com.alibaba.fastjson.asm.h
    public void i(int i7, String str, String str2, String str3) {
        boolean z7 = i7 == 185;
        e eVarE = this.f12591b.e(str, str2, str3, z7);
        int iB = eVarE.f12570c;
        if (!z7) {
            this.f12597h.c(i7, eVarE.f12568a);
            return;
        }
        if (iB == 0) {
            iB = k.b(str3);
            eVarE.f12570c = iB;
        }
        this.f12597h.c(j.Z, eVarE.f12568a).b(iB >> 2, 0);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void j() {
    }

    @Override // com.alibaba.fastjson.asm.h
    public void k(Object obj) {
        e eVarC = this.f12591b.c(obj);
        int i7 = eVarC.f12568a;
        int i8 = eVarC.f12569b;
        if (i8 == 5 || i8 == 6) {
            this.f12597h.c(20, i7);
        } else if (i7 >= 256) {
            this.f12597h.c(19, i7);
        } else {
            this.f12597h.b(18, i7);
        }
    }

    @Override // com.alibaba.fastjson.asm.h
    public void l(f fVar) {
        a aVar = this.f12597h;
        fVar.c(this, aVar.f12538b, aVar.f12537a);
    }

    final int m() {
        int i7;
        if (this.f12597h.f12538b > 0) {
            this.f12591b.h("Code");
            i7 = this.f12597h.f12538b + 18 + 0 + 8;
        } else {
            i7 = 8;
        }
        if (this.f12595f <= 0) {
            return i7;
        }
        this.f12591b.h("Exceptions");
        return i7 + (this.f12595f * 2) + 8;
    }

    final void n(a aVar) {
        aVar.g(this.f12592c & (-393217)).g(this.f12593d).g(this.f12594e);
        int i7 = this.f12597h.f12538b > 0 ? 1 : 0;
        if (this.f12595f > 0) {
            i7++;
        }
        aVar.g(i7);
        int i8 = this.f12597h.f12538b;
        if (i8 > 0) {
            aVar.g(this.f12591b.h("Code")).f(i8 + 12 + 0);
            aVar.g(this.f12598i).g(this.f12599j);
            a aVarF = aVar.f(this.f12597h.f12538b);
            a aVar2 = this.f12597h;
            aVarF.e(aVar2.f12537a, 0, aVar2.f12538b);
            aVar.g(0);
            aVar.g(0);
        }
        if (this.f12595f > 0) {
            aVar.g(this.f12591b.h("Exceptions")).f((this.f12595f * 2) + 2);
            aVar.g(this.f12595f);
            for (int i9 = 0; i9 < this.f12595f; i9++) {
                aVar.g(this.f12596g[i9]);
            }
        }
    }
}
