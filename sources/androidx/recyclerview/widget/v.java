package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f9737a;

    interface a {
        void a(androidx.recyclerview.widget.a.b bVar);

        androidx.recyclerview.widget.a.b b(int i7, int i8, int i9, Object obj);
    }

    v(a aVar) {
        this.f9737a = aVar;
    }

    private int a(List<androidx.recyclerview.widget.a.b> list) {
        boolean z7 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f9319a != 8) {
                z7 = true;
            } else if (z7) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<androidx.recyclerview.widget.a.b> list, int i7, androidx.recyclerview.widget.a.b bVar, int i8, androidx.recyclerview.widget.a.b bVar2) {
        int i9 = bVar.f9322d;
        int i10 = bVar2.f9320b;
        int i11 = i9 < i10 ? -1 : 0;
        int i12 = bVar.f9320b;
        if (i12 < i10) {
            i11++;
        }
        if (i10 <= i12) {
            bVar.f9320b = i12 + bVar2.f9322d;
        }
        int i13 = bVar2.f9320b;
        if (i13 <= i9) {
            bVar.f9322d = i9 + bVar2.f9322d;
        }
        bVar2.f9320b = i13 + i11;
        list.set(i7, bVar2);
        list.set(i8, bVar);
    }

    private void d(List<androidx.recyclerview.widget.a.b> list, int i7, int i8) {
        androidx.recyclerview.widget.a.b bVar = list.get(i7);
        androidx.recyclerview.widget.a.b bVar2 = list.get(i8);
        int i9 = bVar2.f9319a;
        if (i9 == 1) {
            c(list, i7, bVar, i8, bVar2);
        } else if (i9 == 2) {
            e(list, i7, bVar, i8, bVar2);
        } else {
            if (i9 != 4) {
                return;
            }
            f(list, i7, bVar, i8, bVar2);
        }
    }

    void b(List<androidx.recyclerview.widget.a.b> list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    void e(List<androidx.recyclerview.widget.a.b> list, int i7, androidx.recyclerview.widget.a.b bVar, int i8, androidx.recyclerview.widget.a.b bVar2) {
        boolean z7;
        int i9 = bVar.f9320b;
        int i10 = bVar.f9322d;
        boolean z8 = false;
        if (i9 < i10) {
            if (bVar2.f9320b == i9 && bVar2.f9322d == i10 - i9) {
                z7 = false;
                z8 = true;
            } else {
                z7 = false;
            }
        } else if (bVar2.f9320b == i10 + 1 && bVar2.f9322d == i9 - i10) {
            z7 = true;
            z8 = true;
        } else {
            z7 = true;
        }
        int i11 = bVar2.f9320b;
        if (i10 < i11) {
            bVar2.f9320b = i11 - 1;
        } else {
            int i12 = bVar2.f9322d;
            if (i10 < i11 + i12) {
                bVar2.f9322d = i12 - 1;
                bVar.f9319a = 2;
                bVar.f9322d = 1;
                if (bVar2.f9322d == 0) {
                    list.remove(i8);
                    this.f9737a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i13 = bVar.f9320b;
        int i14 = bVar2.f9320b;
        androidx.recyclerview.widget.a.b bVarB = null;
        if (i13 <= i14) {
            bVar2.f9320b = i14 + 1;
        } else {
            int i15 = bVar2.f9322d;
            if (i13 < i14 + i15) {
                bVarB = this.f9737a.b(2, i13 + 1, (i14 + i15) - i13, null);
                bVar2.f9322d = bVar.f9320b - bVar2.f9320b;
            }
        }
        if (z8) {
            list.set(i7, bVar2);
            list.remove(i8);
            this.f9737a.a(bVar);
            return;
        }
        if (z7) {
            if (bVarB != null) {
                int i16 = bVar.f9320b;
                if (i16 > bVarB.f9320b) {
                    bVar.f9320b = i16 - bVarB.f9322d;
                }
                int i17 = bVar.f9322d;
                if (i17 > bVarB.f9320b) {
                    bVar.f9322d = i17 - bVarB.f9322d;
                }
            }
            int i18 = bVar.f9320b;
            if (i18 > bVar2.f9320b) {
                bVar.f9320b = i18 - bVar2.f9322d;
            }
            int i19 = bVar.f9322d;
            if (i19 > bVar2.f9320b) {
                bVar.f9322d = i19 - bVar2.f9322d;
            }
        } else {
            if (bVarB != null) {
                int i20 = bVar.f9320b;
                if (i20 >= bVarB.f9320b) {
                    bVar.f9320b = i20 - bVarB.f9322d;
                }
                int i21 = bVar.f9322d;
                if (i21 >= bVarB.f9320b) {
                    bVar.f9322d = i21 - bVarB.f9322d;
                }
            }
            int i22 = bVar.f9320b;
            if (i22 >= bVar2.f9320b) {
                bVar.f9320b = i22 - bVar2.f9322d;
            }
            int i23 = bVar.f9322d;
            if (i23 >= bVar2.f9320b) {
                bVar.f9322d = i23 - bVar2.f9322d;
            }
        }
        list.set(i7, bVar2);
        if (bVar.f9320b != bVar.f9322d) {
            list.set(i8, bVar);
        } else {
            list.remove(i8);
        }
        if (bVarB != null) {
            list.add(i7, bVarB);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    void f(List<androidx.recyclerview.widget.a.b> list, int i7, androidx.recyclerview.widget.a.b bVar, int i8, androidx.recyclerview.widget.a.b bVar2) {
        androidx.recyclerview.widget.a.b bVarB;
        int i9;
        int i10;
        int i11;
        int i12 = bVar.f9322d;
        int i13 = bVar2.f9320b;
        androidx.recyclerview.widget.a.b bVarB2 = null;
        if (i12 >= i13) {
            int i14 = bVar2.f9322d;
            if (i12 < i13 + i14) {
                bVar2.f9322d = i14 - 1;
                bVarB = this.f9737a.b(4, bVar.f9320b, 1, bVar2.f9321c);
            }
            i9 = bVar.f9320b;
            i10 = bVar2.f9320b;
            if (i9 <= i10) {
                bVar2.f9320b = i10 + 1;
            } else {
                i11 = bVar2.f9322d;
                if (i9 < i10 + i11) {
                    int i15 = (i10 + i11) - i9;
                    bVarB2 = this.f9737a.b(4, i9 + 1, i15, bVar2.f9321c);
                    bVar2.f9322d -= i15;
                }
            }
            list.set(i8, bVar);
            if (bVar2.f9322d > 0) {
                list.set(i7, bVar2);
            } else {
                list.remove(i7);
                this.f9737a.a(bVar2);
            }
            if (bVarB != null) {
                list.add(i7, bVarB);
            }
            if (bVarB2 != null) {
                list.add(i7, bVarB2);
            }
        }
        bVar2.f9320b = i13 - 1;
        bVarB = null;
        i9 = bVar.f9320b;
        i10 = bVar2.f9320b;
        if (i9 <= i10) {
            bVar2.f9320b = i10 + 1;
        } else {
            i11 = bVar2.f9322d;
            if (i9 < i10 + i11) {
                int i16 = (i10 + i11) - i9;
                bVarB2 = this.f9737a.b(4, i9 + 1, i16, bVar2.f9321c);
                bVar2.f9322d -= i16;
            }
        }
        list.set(i8, bVar);
        if (bVar2.f9322d > 0) {
            list.set(i7, bVar2);
        } else {
            list.remove(i7);
            this.f9737a.a(bVar2);
        }
        if (bVarB != null) {
            list.add(i7, bVarB);
        }
        if (bVarB2 != null) {
            list.add(i7, bVarB2);
        }
    }
}
