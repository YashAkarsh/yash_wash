package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class a implements v.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f9302i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f9303j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final boolean f9304k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f9305l = "AHT";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.core.util.v.a<b> f9306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f9307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<b> f9308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final InterfaceC0121a f9309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Runnable f9310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f9311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final v f9312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9313h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0121a {
        void a(int i7, int i8);

        void b(b bVar);

        void c(int i7, int i8, Object obj);

        void d(b bVar);

        RecyclerView.d0 e(int i7);

        void f(int i7, int i8);

        void g(int i7, int i8);

        void h(int i7, int i8);
    }

    static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f9314e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f9315f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f9316g = 4;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f9317h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f9318i = 30;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f9321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9322d;

        b(int i7, int i8, int i9, Object obj) {
            this.f9319a = i7;
            this.f9320b = i8;
            this.f9322d = i9;
            this.f9321c = obj;
        }

        String a() {
            int i7 = this.f9319a;
            if (i7 == 1) {
                return "add";
            }
            if (i7 == 2) {
                return "rm";
            }
            if (i7 != 4) {
                return i7 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i7 = this.f9319a;
            if (i7 != bVar.f9319a) {
                return false;
            }
            if (i7 == 8 && Math.abs(this.f9322d - this.f9320b) == 1 && this.f9322d == bVar.f9320b && this.f9320b == bVar.f9322d) {
                return true;
            }
            if (this.f9322d != bVar.f9322d || this.f9320b != bVar.f9320b) {
                return false;
            }
            Object obj2 = this.f9321c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f9321c)) {
                    return false;
                }
            } else if (bVar.f9321c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f9319a * 31) + this.f9320b) * 31) + this.f9322d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f9320b + "c:" + this.f9322d + ",p:" + this.f9321c + "]";
        }
    }

    a(InterfaceC0121a interfaceC0121a) {
        this(interfaceC0121a, false);
    }

    private int A(int i7, int i8) {
        int i9;
        int i10;
        for (int size = this.f9308c.size() - 1; size >= 0; size--) {
            b bVar = this.f9308c.get(size);
            int i11 = bVar.f9319a;
            if (i11 == 8) {
                int i12 = bVar.f9320b;
                int i13 = bVar.f9322d;
                if (i12 < i13) {
                    i10 = i12;
                    i9 = i13;
                } else {
                    i9 = i12;
                    i10 = i13;
                }
                if (i7 < i10 || i7 > i9) {
                    if (i7 < i12) {
                        if (i8 == 1) {
                            bVar.f9320b = i12 + 1;
                            bVar.f9322d = i13 + 1;
                        } else if (i8 == 2) {
                            bVar.f9320b = i12 - 1;
                            bVar.f9322d = i13 - 1;
                        }
                    }
                } else if (i10 == i12) {
                    if (i8 == 1) {
                        bVar.f9322d = i13 + 1;
                    } else if (i8 == 2) {
                        bVar.f9322d = i13 - 1;
                    }
                    i7++;
                } else {
                    if (i8 == 1) {
                        bVar.f9320b = i12 + 1;
                    } else if (i8 == 2) {
                        bVar.f9320b = i12 - 1;
                    }
                    i7--;
                }
            } else {
                int i14 = bVar.f9320b;
                if (i14 <= i7) {
                    if (i11 == 1) {
                        i7 -= bVar.f9322d;
                    } else if (i11 == 2) {
                        i7 += bVar.f9322d;
                    }
                } else if (i8 == 1) {
                    bVar.f9320b = i14 + 1;
                } else if (i8 == 2) {
                    bVar.f9320b = i14 - 1;
                }
            }
        }
        for (int size2 = this.f9308c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f9308c.get(size2);
            if (bVar2.f9319a == 8) {
                int i15 = bVar2.f9322d;
                if (i15 == bVar2.f9320b || i15 < 0) {
                    this.f9308c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f9322d <= 0) {
                this.f9308c.remove(size2);
                a(bVar2);
            }
        }
        return i7;
    }

    private void d(b bVar) {
        w(bVar);
    }

    private void e(b bVar) {
        w(bVar);
    }

    private void g(b bVar) {
        boolean z7;
        byte b8;
        int i7 = bVar.f9320b;
        int i8 = bVar.f9322d + i7;
        byte b9 = -1;
        int i9 = i7;
        int i10 = 0;
        while (i9 < i8) {
            if (this.f9309d.e(i9) != null || i(i9)) {
                if (b9 == 0) {
                    l(b(2, i7, i10, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                b8 = 1;
            } else {
                if (b9 == 1) {
                    w(b(2, i7, i10, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                b8 = 0;
            }
            if (z7) {
                i9 -= i10;
                i8 -= i10;
                i10 = 1;
            } else {
                i10++;
            }
            i9++;
            b9 = b8;
        }
        if (i10 != bVar.f9322d) {
            a(bVar);
            bVar = b(2, i7, i10, null);
        }
        if (b9 == 0) {
            l(bVar);
        } else {
            w(bVar);
        }
    }

    private void h(b bVar) {
        int i7 = bVar.f9320b;
        int i8 = bVar.f9322d + i7;
        int i9 = 0;
        byte b8 = -1;
        int i10 = i7;
        while (i7 < i8) {
            if (this.f9309d.e(i7) != null || i(i7)) {
                if (b8 == 0) {
                    l(b(4, i10, i9, bVar.f9321c));
                    i10 = i7;
                    i9 = 0;
                }
                b8 = 1;
            } else {
                if (b8 == 1) {
                    w(b(4, i10, i9, bVar.f9321c));
                    i10 = i7;
                    i9 = 0;
                }
                b8 = 0;
            }
            i9++;
            i7++;
        }
        if (i9 != bVar.f9322d) {
            Object obj = bVar.f9321c;
            a(bVar);
            bVar = b(4, i10, i9, obj);
        }
        if (b8 == 0) {
            l(bVar);
        } else {
            w(bVar);
        }
    }

    private boolean i(int i7) {
        int size = this.f9308c.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = this.f9308c.get(i8);
            int i9 = bVar.f9319a;
            if (i9 == 8) {
                if (o(bVar.f9322d, i8 + 1) == i7) {
                    return true;
                }
            } else if (i9 == 1) {
                int i10 = bVar.f9320b;
                int i11 = bVar.f9322d + i10;
                while (i10 < i11) {
                    if (o(i10, i8 + 1) == i7) {
                        return true;
                    }
                    i10++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void l(b bVar) {
        int i7;
        int i8 = bVar.f9319a;
        if (i8 == 1 || i8 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iA = A(bVar.f9320b, i8);
        int i9 = bVar.f9320b;
        int i10 = bVar.f9319a;
        if (i10 == 2) {
            i7 = 0;
        } else {
            if (i10 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i7 = 1;
        }
        int i11 = 1;
        for (int i12 = 1; i12 < bVar.f9322d; i12++) {
            int iA2 = A(bVar.f9320b + (i7 * i12), bVar.f9319a);
            int i13 = bVar.f9319a;
            if (i13 == 2 ? iA2 == iA : i13 == 4 && iA2 == iA + 1) {
                i11++;
            } else {
                b bVarB = b(i13, iA, i11, bVar.f9321c);
                m(bVarB, i9);
                a(bVarB);
                if (bVar.f9319a == 4) {
                    i9 += i11;
                }
                i11 = 1;
                iA = iA2;
            }
        }
        Object obj = bVar.f9321c;
        a(bVar);
        if (i11 > 0) {
            b bVarB2 = b(bVar.f9319a, iA, i11, obj);
            m(bVarB2, i9);
            a(bVarB2);
        }
    }

    private void w(b bVar) {
        this.f9308c.add(bVar);
        int i7 = bVar.f9319a;
        if (i7 == 1) {
            this.f9309d.g(bVar.f9320b, bVar.f9322d);
            return;
        }
        if (i7 == 2) {
            this.f9309d.f(bVar.f9320b, bVar.f9322d);
            return;
        }
        if (i7 == 4) {
            this.f9309d.c(bVar.f9320b, bVar.f9322d, bVar.f9321c);
        } else {
            if (i7 == 8) {
                this.f9309d.a(bVar.f9320b, bVar.f9322d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    @Override // androidx.recyclerview.widget.v.a
    public void a(b bVar) {
        if (this.f9311f) {
            return;
        }
        bVar.f9321c = null;
        this.f9306a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.v.a
    public b b(int i7, int i8, int i9, Object obj) {
        b bVarB = this.f9306a.b();
        if (bVarB == null) {
            return new b(i7, i8, i9, obj);
        }
        bVarB.f9319a = i7;
        bVarB.f9320b = i8;
        bVarB.f9322d = i9;
        bVarB.f9321c = obj;
        return bVarB;
    }

    a c(b... bVarArr) {
        Collections.addAll(this.f9307b, bVarArr);
        return this;
    }

    public int f(int i7) {
        int size = this.f9307b.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = this.f9307b.get(i8);
            int i9 = bVar.f9319a;
            if (i9 != 1) {
                if (i9 == 2) {
                    int i10 = bVar.f9320b;
                    if (i10 <= i7) {
                        int i11 = bVar.f9322d;
                        if (i10 + i11 > i7) {
                            return -1;
                        }
                        i7 -= i11;
                    } else {
                        continue;
                    }
                } else if (i9 == 8) {
                    int i12 = bVar.f9320b;
                    if (i12 == i7) {
                        i7 = bVar.f9322d;
                    } else {
                        if (i12 < i7) {
                            i7--;
                        }
                        if (bVar.f9322d <= i7) {
                            i7++;
                        }
                    }
                }
            } else if (bVar.f9320b <= i7) {
                i7 += bVar.f9322d;
            }
        }
        return i7;
    }

    void j() {
        int size = this.f9308c.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f9309d.d(this.f9308c.get(i7));
        }
        y(this.f9308c);
        this.f9313h = 0;
    }

    void k() {
        j();
        int size = this.f9307b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f9307b.get(i7);
            int i8 = bVar.f9319a;
            if (i8 == 1) {
                this.f9309d.d(bVar);
                this.f9309d.g(bVar.f9320b, bVar.f9322d);
            } else if (i8 == 2) {
                this.f9309d.d(bVar);
                this.f9309d.h(bVar.f9320b, bVar.f9322d);
            } else if (i8 == 4) {
                this.f9309d.d(bVar);
                this.f9309d.c(bVar.f9320b, bVar.f9322d, bVar.f9321c);
            } else if (i8 == 8) {
                this.f9309d.d(bVar);
                this.f9309d.a(bVar.f9320b, bVar.f9322d);
            }
            Runnable runnable = this.f9310e;
            if (runnable != null) {
                runnable.run();
            }
        }
        y(this.f9307b);
        this.f9313h = 0;
    }

    void m(b bVar, int i7) {
        this.f9309d.b(bVar);
        int i8 = bVar.f9319a;
        if (i8 == 2) {
            this.f9309d.h(i7, bVar.f9322d);
        } else {
            if (i8 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f9309d.c(i7, bVar.f9322d, bVar.f9321c);
        }
    }

    int n(int i7) {
        return o(i7, 0);
    }

    int o(int i7, int i8) {
        int size = this.f9308c.size();
        while (i8 < size) {
            b bVar = this.f9308c.get(i8);
            int i9 = bVar.f9319a;
            if (i9 == 8) {
                int i10 = bVar.f9320b;
                if (i10 == i7) {
                    i7 = bVar.f9322d;
                } else {
                    if (i10 < i7) {
                        i7--;
                    }
                    if (bVar.f9322d <= i7) {
                        i7++;
                    }
                }
            } else {
                int i11 = bVar.f9320b;
                if (i11 > i7) {
                    continue;
                } else if (i9 == 2) {
                    int i12 = bVar.f9322d;
                    if (i7 < i11 + i12) {
                        return -1;
                    }
                    i7 -= i12;
                } else if (i9 == 1) {
                    i7 += bVar.f9322d;
                }
            }
            i8++;
        }
        return i7;
    }

    boolean p(int i7) {
        return (i7 & this.f9313h) != 0;
    }

    boolean q() {
        return this.f9307b.size() > 0;
    }

    boolean r() {
        return (this.f9308c.isEmpty() || this.f9307b.isEmpty()) ? false : true;
    }

    boolean s(int i7, int i8, Object obj) {
        if (i8 < 1) {
            return false;
        }
        this.f9307b.add(b(4, i7, i8, obj));
        this.f9313h |= 4;
        return this.f9307b.size() == 1;
    }

    boolean t(int i7, int i8) {
        if (i8 < 1) {
            return false;
        }
        this.f9307b.add(b(1, i7, i8, null));
        this.f9313h |= 1;
        return this.f9307b.size() == 1;
    }

    boolean u(int i7, int i8, int i9) {
        if (i7 == i8) {
            return false;
        }
        if (i9 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f9307b.add(b(8, i7, i8, null));
        this.f9313h |= 8;
        return this.f9307b.size() == 1;
    }

    boolean v(int i7, int i8) {
        if (i8 < 1) {
            return false;
        }
        this.f9307b.add(b(2, i7, i8, null));
        this.f9313h |= 2;
        return this.f9307b.size() == 1;
    }

    void x() {
        this.f9312g.b(this.f9307b);
        int size = this.f9307b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f9307b.get(i7);
            int i8 = bVar.f9319a;
            if (i8 == 1) {
                d(bVar);
            } else if (i8 == 2) {
                g(bVar);
            } else if (i8 == 4) {
                h(bVar);
            } else if (i8 == 8) {
                e(bVar);
            }
            Runnable runnable = this.f9310e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f9307b.clear();
    }

    void y(List<b> list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            a(list.get(i7));
        }
        list.clear();
    }

    void z() {
        y(this.f9307b);
        y(this.f9308c);
        this.f9313h = 0;
    }

    a(InterfaceC0121a interfaceC0121a, boolean z7) {
        this.f9306a = new androidx.core.util.v.b(30);
        this.f9307b = new ArrayList<>();
        this.f9308c = new ArrayList<>();
        this.f9313h = 0;
        this.f9309d = interfaceC0121a;
        this.f9311f = z7;
        this.f9312g = new v(this);
    }
}
