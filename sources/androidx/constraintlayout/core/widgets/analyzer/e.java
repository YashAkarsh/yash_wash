package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final boolean f3439j = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.f f3440a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.f f3443d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3441b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3442c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<p> f3444e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<m> f3445f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b.InterfaceC0040b f3446g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b.a f3447h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList<m> f3448i = new ArrayList<>();

    public e(androidx.constraintlayout.core.widgets.f fVar) {
        this.f3440a = fVar;
        this.f3443d = fVar;
    }

    private void a(f fVar, int i7, int i8, f fVar2, ArrayList<m> arrayList, m mVar) {
        p pVar = fVar.f3452d;
        if (pVar.f3513c == null) {
            androidx.constraintlayout.core.widgets.f fVar3 = this.f3440a;
            if (pVar == fVar3.f3608e || pVar == fVar3.f3610f) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar, i8);
                arrayList.add(mVar);
            }
            pVar.f3513c = mVar;
            mVar.a(pVar);
            for (d dVar : pVar.f3518h.f3459k) {
                if (dVar instanceof f) {
                    a((f) dVar, i7, 0, fVar2, arrayList, mVar);
                }
            }
            for (d dVar2 : pVar.f3519i.f3459k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i7, 1, fVar2, arrayList, mVar);
                }
            }
            if (i7 == 1 && (pVar instanceof n)) {
                for (d dVar3 : ((n) pVar).f3492k.f3459k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i7, 2, fVar2, arrayList, mVar);
                    }
                }
            }
            for (f fVar4 : pVar.f3518h.f3460l) {
                if (fVar4 == fVar2) {
                    mVar.f3486b = true;
                }
                a(fVar4, i7, 0, fVar2, arrayList, mVar);
            }
            for (f fVar5 : pVar.f3519i.f3460l) {
                if (fVar5 == fVar2) {
                    mVar.f3486b = true;
                }
                a(fVar5, i7, 1, fVar2, arrayList, mVar);
            }
            if (i7 == 1 && (pVar instanceof n)) {
                Iterator<f> it = ((n) pVar).f3492k.f3460l.iterator();
                while (it.hasNext()) {
                    a(it.next(), i7, 2, fVar2, arrayList, mVar);
                }
            }
        }
    }

    private boolean b(androidx.constraintlayout.core.widgets.f fVar) {
        int iM0;
        androidx.constraintlayout.core.widgets.e.b bVar;
        int iD;
        androidx.constraintlayout.core.widgets.e.b bVar2;
        androidx.constraintlayout.core.widgets.e.b bVar3;
        androidx.constraintlayout.core.widgets.e.b bVar4;
        for (androidx.constraintlayout.core.widgets.e eVar : fVar.A1) {
            androidx.constraintlayout.core.widgets.e.b[] bVarArr = eVar.f3603b0;
            androidx.constraintlayout.core.widgets.e.b bVar5 = bVarArr[0];
            androidx.constraintlayout.core.widgets.e.b bVar6 = bVarArr[1];
            if (eVar.l0() == 8) {
                eVar.f3600a = true;
            } else {
                if (eVar.B < 1.0f && bVar5 == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                    eVar.f3644w = 2;
                }
                if (eVar.E < 1.0f && bVar6 == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                    eVar.f3646x = 2;
                }
                if (eVar.A() > 0.0f) {
                    androidx.constraintlayout.core.widgets.e.b bVar7 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT || bVar6 == androidx.constraintlayout.core.widgets.e.b.FIXED)) {
                        eVar.f3644w = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT || bVar5 == androidx.constraintlayout.core.widgets.e.b.FIXED)) {
                        eVar.f3646x = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (eVar.f3644w == 0) {
                            eVar.f3644w = 3;
                        }
                        if (eVar.f3646x == 0) {
                            eVar.f3646x = 3;
                        }
                    }
                }
                androidx.constraintlayout.core.widgets.e.b bVar8 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && eVar.f3644w == 1 && (eVar.Q.f3558f == null || eVar.S.f3558f == null)) {
                    bVar5 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
                }
                androidx.constraintlayout.core.widgets.e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && eVar.f3646x == 1 && (eVar.R.f3558f == null || eVar.T.f3558f == null)) {
                    bVar6 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
                }
                androidx.constraintlayout.core.widgets.e.b bVar10 = bVar6;
                l lVar = eVar.f3608e;
                lVar.f3514d = bVar9;
                int i7 = eVar.f3644w;
                lVar.f3511a = i7;
                n nVar = eVar.f3610f;
                nVar.f3514d = bVar10;
                int i8 = eVar.f3646x;
                nVar.f3511a = i8;
                androidx.constraintlayout.core.widgets.e.b bVar11 = androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == androidx.constraintlayout.core.widgets.e.b.FIXED || bVar9 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == androidx.constraintlayout.core.widgets.e.b.FIXED || bVar10 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT)) {
                    int iM1 = eVar.m0();
                    if (bVar9 == bVar11) {
                        iM0 = (fVar.m0() - eVar.Q.f3559g) - eVar.S.f3559g;
                        bVar = androidx.constraintlayout.core.widgets.e.b.FIXED;
                    } else {
                        iM0 = iM1;
                        bVar = bVar9;
                    }
                    int iD2 = eVar.D();
                    if (bVar10 == bVar11) {
                        iD = (fVar.D() - eVar.R.f3559g) - eVar.T.f3559g;
                        bVar2 = androidx.constraintlayout.core.widgets.e.b.FIXED;
                    } else {
                        iD = iD2;
                        bVar2 = bVar10;
                    }
                    r(eVar, bVar, iM0, bVar2, iD);
                    eVar.f3608e.f3515e.e(eVar.m0());
                    eVar.f3610f.f3515e.e(eVar.D());
                    eVar.f3600a = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) || bVar10 == androidx.constraintlayout.core.widgets.e.b.FIXED)) {
                        if (i7 == 3) {
                            if (bVar10 == bVar4) {
                                r(eVar, bVar4, 0, bVar4, 0);
                            }
                            int iD3 = eVar.D();
                            int i9 = (int) ((iD3 * eVar.f3611f0) + 0.5f);
                            androidx.constraintlayout.core.widgets.e.b bVar12 = androidx.constraintlayout.core.widgets.e.b.FIXED;
                            r(eVar, bVar12, i9, bVar12, iD3);
                            eVar.f3608e.f3515e.e(eVar.m0());
                            eVar.f3610f.f3515e.e(eVar.D());
                            eVar.f3600a = true;
                        } else if (i7 == 1) {
                            r(eVar, bVar4, 0, bVar10, 0);
                            eVar.f3608e.f3515e.f3470m = eVar.m0();
                        } else if (i7 == 2) {
                            androidx.constraintlayout.core.widgets.e.b bVar13 = fVar.f3603b0[0];
                            androidx.constraintlayout.core.widgets.e.b bVar14 = androidx.constraintlayout.core.widgets.e.b.FIXED;
                            if (bVar13 == bVar14 || bVar13 == bVar11) {
                                r(eVar, bVar14, (int) ((eVar.B * fVar.m0()) + 0.5f), bVar10, eVar.D());
                                eVar.f3608e.f3515e.e(eVar.m0());
                                eVar.f3610f.f3515e.e(eVar.D());
                                eVar.f3600a = true;
                            }
                        } else {
                            androidx.constraintlayout.core.widgets.d[] dVarArr = eVar.Y;
                            if (dVarArr[0].f3558f == null || dVarArr[1].f3558f == null) {
                                r(eVar, bVar4, 0, bVar10, 0);
                                eVar.f3608e.f3515e.e(eVar.m0());
                                eVar.f3610f.f3515e.e(eVar.D());
                                eVar.f3600a = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) || bVar9 == androidx.constraintlayout.core.widgets.e.b.FIXED)) {
                        if (i8 == 3) {
                            if (bVar9 == bVar3) {
                                r(eVar, bVar3, 0, bVar3, 0);
                            }
                            int iM2 = eVar.m0();
                            float f8 = eVar.f3611f0;
                            if (eVar.B() == -1) {
                                f8 = 1.0f / f8;
                            }
                            androidx.constraintlayout.core.widgets.e.b bVar15 = androidx.constraintlayout.core.widgets.e.b.FIXED;
                            r(eVar, bVar15, iM2, bVar15, (int) ((iM2 * f8) + 0.5f));
                            eVar.f3608e.f3515e.e(eVar.m0());
                            eVar.f3610f.f3515e.e(eVar.D());
                            eVar.f3600a = true;
                        } else if (i8 == 1) {
                            r(eVar, bVar9, 0, bVar3, 0);
                            eVar.f3610f.f3515e.f3470m = eVar.D();
                        } else if (i8 == 2) {
                            androidx.constraintlayout.core.widgets.e.b bVar16 = fVar.f3603b0[1];
                            androidx.constraintlayout.core.widgets.e.b bVar17 = androidx.constraintlayout.core.widgets.e.b.FIXED;
                            if (bVar16 == bVar17 || bVar16 == bVar11) {
                                r(eVar, bVar9, eVar.m0(), bVar17, (int) ((eVar.E * fVar.D()) + 0.5f));
                                eVar.f3608e.f3515e.e(eVar.m0());
                                eVar.f3610f.f3515e.e(eVar.D());
                                eVar.f3600a = true;
                            }
                        } else {
                            androidx.constraintlayout.core.widgets.d[] dVarArr2 = eVar.Y;
                            if (dVarArr2[2].f3558f == null || dVarArr2[3].f3558f == null) {
                                r(eVar, bVar3, 0, bVar10, 0);
                                eVar.f3608e.f3515e.e(eVar.m0());
                                eVar.f3610f.f3515e.e(eVar.D());
                                eVar.f3600a = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i7 == 1 || i8 == 1) {
                            androidx.constraintlayout.core.widgets.e.b bVar18 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
                            r(eVar, bVar18, 0, bVar18, 0);
                            eVar.f3608e.f3515e.f3470m = eVar.m0();
                            eVar.f3610f.f3515e.f3470m = eVar.D();
                        } else if (i8 == 2 && i7 == 2) {
                            androidx.constraintlayout.core.widgets.e.b[] bVarArr2 = fVar.f3603b0;
                            androidx.constraintlayout.core.widgets.e.b bVar19 = bVarArr2[0];
                            androidx.constraintlayout.core.widgets.e.b bVar20 = androidx.constraintlayout.core.widgets.e.b.FIXED;
                            if (bVar19 == bVar20 && bVarArr2[1] == bVar20) {
                                r(eVar, bVar20, (int) ((eVar.B * fVar.m0()) + 0.5f), bVar20, (int) ((eVar.E * fVar.D()) + 0.5f));
                                eVar.f3608e.f3515e.e(eVar.m0());
                                eVar.f3610f.f3515e.e(eVar.D());
                                eVar.f3600a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(androidx.constraintlayout.core.widgets.f fVar, int i7) {
        int size = this.f3448i.size();
        long jMax = 0;
        for (int i8 = 0; i8 < size; i8++) {
            jMax = Math.max(jMax, this.f3448i.get(i8).b(fVar, i7));
        }
        return (int) jMax;
    }

    private void j() {
        Iterator<p> it = this.f3444e.iterator();
        String strM = "digraph {\n";
        while (it.hasNext()) {
            strM = m(it.next(), strM);
        }
        String str = strM + "\n}\n";
        System.out.println("content:<<\n" + str + "\n>>");
    }

    private void k(p pVar, int i7, ArrayList<m> arrayList) {
        for (d dVar : pVar.f3518h.f3459k) {
            if (dVar instanceof f) {
                a((f) dVar, i7, 0, pVar.f3519i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f3518h, i7, 0, pVar.f3519i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f3519i.f3459k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i7, 1, pVar.f3518h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f3519i, i7, 1, pVar.f3518h, arrayList, null);
            }
        }
        if (i7 == 1) {
            for (d dVar3 : ((n) pVar).f3492k.f3459k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i7, 2, null, arrayList, null);
                }
            }
        }
    }

    private String l(c cVar, String str) {
        int i7 = cVar.f3516f;
        StringBuilder sb = new StringBuilder("subgraph ");
        sb.append("cluster_");
        sb.append(cVar.f3512b.y());
        if (i7 == 0) {
            sb.append("_h");
        } else {
            sb.append("_v");
        }
        sb.append(" {\n");
        String strM = "";
        for (p pVar : cVar.f3437k) {
            sb.append(pVar.f3512b.y());
            if (i7 == 0) {
                sb.append("_HORIZONTAL");
            } else {
                sb.append("_VERTICAL");
            }
            sb.append(";\n");
            strM = m(pVar, strM);
        }
        sb.append("}\n");
        return str + strM + ((Object) sb);
    }

    private String m(p pVar, String str) {
        boolean z7;
        f fVar = pVar.f3518h;
        f fVar2 = pVar.f3519i;
        StringBuilder sb = new StringBuilder(str);
        if (!(pVar instanceof k) && fVar.f3459k.isEmpty() && (fVar2.f3459k.isEmpty() && fVar.f3460l.isEmpty()) && fVar2.f3460l.isEmpty()) {
            return str;
        }
        sb.append(t(pVar));
        boolean zQ = q(fVar, fVar2);
        String strN = n(fVar2, zQ, n(fVar, zQ, str));
        boolean z8 = pVar instanceof n;
        if (z8) {
            strN = n(((n) pVar).f3492k, zQ, strN);
        }
        if ((pVar instanceof l) || (((z7 = pVar instanceof c)) && ((c) pVar).f3516f == 0)) {
            androidx.constraintlayout.core.widgets.e.b bVarH = pVar.f3512b.H();
            if (bVarH == androidx.constraintlayout.core.widgets.e.b.FIXED || bVarH == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
                if (!fVar.f3460l.isEmpty() && fVar2.f3460l.isEmpty()) {
                    sb.append("\n");
                    sb.append(fVar2.d());
                    sb.append(" -> ");
                    sb.append(fVar.d());
                    sb.append("\n");
                } else if (fVar.f3460l.isEmpty() && !fVar2.f3460l.isEmpty()) {
                    sb.append("\n");
                    sb.append(fVar.d());
                    sb.append(" -> ");
                    sb.append(fVar2.d());
                    sb.append("\n");
                }
            } else if (bVarH == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && pVar.f3512b.A() > 0.0f) {
                sb.append("\n");
                sb.append(pVar.f3512b.y());
                sb.append("_HORIZONTAL -> ");
                sb.append(pVar.f3512b.y());
                sb.append("_VERTICAL;\n");
            }
        } else if (z8 || (z7 && ((c) pVar).f3516f == 1)) {
            androidx.constraintlayout.core.widgets.e.b bVarJ0 = pVar.f3512b.j0();
            if (bVarJ0 == androidx.constraintlayout.core.widgets.e.b.FIXED || bVarJ0 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
                if (!fVar.f3460l.isEmpty() && fVar2.f3460l.isEmpty()) {
                    sb.append("\n");
                    sb.append(fVar2.d());
                    sb.append(" -> ");
                    sb.append(fVar.d());
                    sb.append("\n");
                } else if (fVar.f3460l.isEmpty() && !fVar2.f3460l.isEmpty()) {
                    sb.append("\n");
                    sb.append(fVar.d());
                    sb.append(" -> ");
                    sb.append(fVar2.d());
                    sb.append("\n");
                }
            } else if (bVarJ0 == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && pVar.f3512b.A() > 0.0f) {
                sb.append("\n");
                sb.append(pVar.f3512b.y());
                sb.append("_VERTICAL -> ");
                sb.append(pVar.f3512b.y());
                sb.append("_HORIZONTAL;\n");
            }
        }
        return pVar instanceof c ? l((c) pVar, strN) : sb.toString();
    }

    private String n(f fVar, boolean z7, String str) {
        StringBuilder sb = new StringBuilder(str);
        for (f fVar2 : fVar.f3460l) {
            String str2 = ("\n" + fVar.d()) + " -> " + fVar2.d();
            if (fVar.f3454f > 0 || z7 || (fVar.f3452d instanceof k)) {
                String str3 = str2 + "[";
                if (fVar.f3454f > 0) {
                    str3 = str3 + "label=\"" + fVar.f3454f + "\"";
                    if (z7) {
                        str3 = str3 + ",";
                    }
                }
                if (z7) {
                    str3 = str3 + " style=dashed ";
                }
                if (fVar.f3452d instanceof k) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            sb.append(str2 + "\n");
        }
        return sb.toString();
    }

    private boolean q(f fVar, f fVar2) {
        Iterator<f> it = fVar.f3460l.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (it.next() != fVar2) {
                i7++;
            }
        }
        Iterator<f> it2 = fVar2.f3460l.iterator();
        int i8 = 0;
        while (it2.hasNext()) {
            if (it2.next() != fVar) {
                i8++;
            }
        }
        return i7 > 0 && i8 > 0;
    }

    private void r(androidx.constraintlayout.core.widgets.e eVar, androidx.constraintlayout.core.widgets.e.b bVar, int i7, androidx.constraintlayout.core.widgets.e.b bVar2, int i8) {
        b.a aVar = this.f3447h;
        aVar.f3427a = bVar;
        aVar.f3428b = bVar2;
        aVar.f3429c = i7;
        aVar.f3430d = i8;
        this.f3446g.b(eVar, aVar);
        eVar.c2(this.f3447h.f3431e);
        eVar.y1(this.f3447h.f3432f);
        eVar.x1(this.f3447h.f3434h);
        eVar.g1(this.f3447h.f3433g);
    }

    private String t(p pVar) {
        boolean z7 = pVar instanceof n;
        String strY = pVar.f3512b.y();
        StringBuilder sb = new StringBuilder(strY);
        androidx.constraintlayout.core.widgets.e eVar = pVar.f3512b;
        androidx.constraintlayout.core.widgets.e.b bVarH = !z7 ? eVar.H() : eVar.j0();
        m mVar = pVar.f3513c;
        if (z7) {
            sb.append("_VERTICAL");
        } else {
            sb.append("_HORIZONTAL");
        }
        sb.append(" [shape=none, label=<");
        sb.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        sb.append("  <TR>");
        if (z7) {
            sb.append("    <TD ");
            if (pVar.f3518h.f3458j) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
        } else {
            sb.append("    <TD ");
            if (pVar.f3518h.f3458j) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
        }
        sb.append("    <TD BORDER=\"1\" ");
        boolean z8 = pVar.f3515e.f3458j;
        if (z8 && !pVar.f3512b.f3600a) {
            sb.append(" BGCOLOR=\"green\" ");
        } else if (z8) {
            sb.append(" BGCOLOR=\"lightgray\" ");
        } else if (pVar.f3512b.f3600a) {
            sb.append(" BGCOLOR=\"yellow\" ");
        }
        if (bVarH == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
            sb.append("style=\"dashed\"");
        }
        sb.append(">");
        sb.append(strY);
        if (mVar != null) {
            sb.append(" [");
            sb.append(mVar.f3490f + 1);
            sb.append("/");
            sb.append(m.f3484k);
            sb.append("]");
        }
        sb.append(" </TD>");
        if (z7) {
            sb.append("    <TD ");
            if (((n) pVar).f3492k.f3458j) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
            sb.append("    <TD ");
            if (pVar.f3519i.f3458j) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
        } else {
            sb.append("    <TD ");
            if (pVar.f3519i.f3458j) {
                sb.append(" BGCOLOR=\"green\"");
            }
            sb.append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
        }
        sb.append("  </TR></TABLE>");
        sb.append(">];\n");
        return sb.toString();
    }

    public void c() {
        d(this.f3444e);
        this.f3448i.clear();
        m.f3484k = 0;
        k(this.f3440a.f3608e, 0, this.f3448i);
        k(this.f3440a.f3610f, 1, this.f3448i);
        this.f3441b = false;
    }

    public void d(ArrayList<p> arrayList) {
        arrayList.clear();
        this.f3443d.f3608e.f();
        this.f3443d.f3610f.f();
        arrayList.add(this.f3443d.f3608e);
        arrayList.add(this.f3443d.f3610f);
        HashSet hashSet = null;
        for (androidx.constraintlayout.core.widgets.e eVar : this.f3443d.A1) {
            if (eVar instanceof androidx.constraintlayout.core.widgets.h) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.B0()) {
                    if (eVar.f3604c == null) {
                        eVar.f3604c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f3604c);
                } else {
                    arrayList.add(eVar.f3608e);
                }
                if (eVar.D0()) {
                    if (eVar.f3606d == null) {
                        eVar.f3606d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f3606d);
                } else {
                    arrayList.add(eVar.f3610f);
                }
                if (eVar instanceof androidx.constraintlayout.core.widgets.j) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        for (p pVar : arrayList) {
            if (pVar.f3512b != this.f3443d) {
                pVar.d();
            }
        }
    }

    public void f(androidx.constraintlayout.core.widgets.e.b bVar, androidx.constraintlayout.core.widgets.e.b bVar2) {
        if (this.f3441b) {
            c();
            boolean z7 = false;
            for (androidx.constraintlayout.core.widgets.e eVar : this.f3440a.A1) {
                boolean[] zArr = eVar.f3612g;
                zArr[0] = true;
                zArr[1] = true;
                if (eVar instanceof androidx.constraintlayout.core.widgets.a) {
                    z7 = true;
                }
            }
            if (z7) {
                return;
            }
            for (m mVar : this.f3448i) {
                androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
                mVar.d(bVar == bVar3, bVar2 == bVar3);
            }
        }
    }

    public boolean g(boolean z7) {
        boolean z8;
        boolean z9 = true;
        boolean z10 = z7 & true;
        if (this.f3441b || this.f3442c) {
            for (androidx.constraintlayout.core.widgets.e eVar : this.f3440a.A1) {
                eVar.q();
                eVar.f3600a = false;
                eVar.f3608e.n();
                eVar.f3610f.n();
            }
            this.f3440a.q();
            androidx.constraintlayout.core.widgets.f fVar = this.f3440a;
            fVar.f3600a = false;
            fVar.f3608e.n();
            this.f3440a.f3610f.n();
            this.f3442c = false;
        }
        if (b(this.f3443d)) {
            return false;
        }
        this.f3440a.f2(0);
        this.f3440a.g2(0);
        androidx.constraintlayout.core.widgets.e.b bVarZ = this.f3440a.z(0);
        androidx.constraintlayout.core.widgets.e.b bVarZ2 = this.f3440a.z(1);
        if (this.f3441b) {
            c();
        }
        int iO0 = this.f3440a.o0();
        int iP0 = this.f3440a.p0();
        this.f3440a.f3608e.f3518h.e(iO0);
        this.f3440a.f3610f.f3518h.e(iP0);
        s();
        androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
        if (bVarZ == bVar || bVarZ2 == bVar) {
            if (z10) {
                Iterator<p> it = this.f3444e.iterator();
                while (it.hasNext()) {
                    if (!it.next().p()) {
                        z10 = false;
                        break;
                    }
                }
            }
            if (z10 && bVarZ == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
                this.f3440a.D1(androidx.constraintlayout.core.widgets.e.b.FIXED);
                androidx.constraintlayout.core.widgets.f fVar2 = this.f3440a;
                fVar2.c2(e(fVar2, 0));
                androidx.constraintlayout.core.widgets.f fVar3 = this.f3440a;
                fVar3.f3608e.f3515e.e(fVar3.m0());
            }
            if (z10 && bVarZ2 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
                this.f3440a.Y1(androidx.constraintlayout.core.widgets.e.b.FIXED);
                androidx.constraintlayout.core.widgets.f fVar4 = this.f3440a;
                fVar4.y1(e(fVar4, 1));
                androidx.constraintlayout.core.widgets.f fVar5 = this.f3440a;
                fVar5.f3610f.f3515e.e(fVar5.D());
            }
        }
        androidx.constraintlayout.core.widgets.f fVar6 = this.f3440a;
        androidx.constraintlayout.core.widgets.e.b bVar2 = fVar6.f3603b0[0];
        androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT) {
            int iM0 = fVar6.m0() + iO0;
            this.f3440a.f3608e.f3519i.e(iM0);
            this.f3440a.f3608e.f3515e.e(iM0 - iO0);
            s();
            androidx.constraintlayout.core.widgets.f fVar7 = this.f3440a;
            androidx.constraintlayout.core.widgets.e.b bVar4 = fVar7.f3603b0[1];
            if (bVar4 == bVar3 || bVar4 == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT) {
                int iD = fVar7.D() + iP0;
                this.f3440a.f3610f.f3519i.e(iD);
                this.f3440a.f3610f.f3515e.e(iD - iP0);
            }
            s();
            z8 = true;
        } else {
            z8 = false;
        }
        for (p pVar : this.f3444e) {
            if (pVar.f3512b != this.f3440a || pVar.f3517g) {
                pVar.e();
            }
        }
        for (p pVar2 : this.f3444e) {
            if (z8 || pVar2.f3512b != this.f3440a) {
                if (!pVar2.f3518h.f3458j || ((!pVar2.f3519i.f3458j && !(pVar2 instanceof j)) || (!pVar2.f3515e.f3458j && !(pVar2 instanceof c) && !(pVar2 instanceof j)))) {
                    z9 = false;
                    break;
                }
            }
        }
        this.f3440a.D1(bVarZ);
        this.f3440a.Y1(bVarZ2);
        return z9;
    }

    public boolean h(boolean z7) {
        if (this.f3441b) {
            for (androidx.constraintlayout.core.widgets.e eVar : this.f3440a.A1) {
                eVar.q();
                eVar.f3600a = false;
                l lVar = eVar.f3608e;
                lVar.f3515e.f3458j = false;
                lVar.f3517g = false;
                lVar.n();
                n nVar = eVar.f3610f;
                nVar.f3515e.f3458j = false;
                nVar.f3517g = false;
                nVar.n();
            }
            this.f3440a.q();
            androidx.constraintlayout.core.widgets.f fVar = this.f3440a;
            fVar.f3600a = false;
            l lVar2 = fVar.f3608e;
            lVar2.f3515e.f3458j = false;
            lVar2.f3517g = false;
            lVar2.n();
            n nVar2 = this.f3440a.f3610f;
            nVar2.f3515e.f3458j = false;
            nVar2.f3517g = false;
            nVar2.n();
            c();
        }
        if (b(this.f3443d)) {
            return false;
        }
        this.f3440a.f2(0);
        this.f3440a.g2(0);
        this.f3440a.f3608e.f3518h.e(0);
        this.f3440a.f3610f.f3518h.e(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c1  */
    public boolean i(boolean z7, int i7) {
        boolean z8;
        androidx.constraintlayout.core.widgets.e.b bVar;
        boolean z9 = true;
        boolean z10 = z7 & true;
        androidx.constraintlayout.core.widgets.e.b bVarZ = this.f3440a.z(0);
        androidx.constraintlayout.core.widgets.e.b bVarZ2 = this.f3440a.z(1);
        int iO0 = this.f3440a.o0();
        int iP0 = this.f3440a.p0();
        if (z10 && (bVarZ == (bVar = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) || bVarZ2 == bVar)) {
            for (p pVar : this.f3444e) {
                if (pVar.f3516f == i7 && !pVar.p()) {
                    z10 = false;
                    break;
                }
            }
            if (i7 == 0) {
                if (z10 && bVarZ == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
                    this.f3440a.D1(androidx.constraintlayout.core.widgets.e.b.FIXED);
                    androidx.constraintlayout.core.widgets.f fVar = this.f3440a;
                    fVar.c2(e(fVar, 0));
                    androidx.constraintlayout.core.widgets.f fVar2 = this.f3440a;
                    fVar2.f3608e.f3515e.e(fVar2.m0());
                }
            } else if (z10 && bVarZ2 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
                this.f3440a.Y1(androidx.constraintlayout.core.widgets.e.b.FIXED);
                androidx.constraintlayout.core.widgets.f fVar3 = this.f3440a;
                fVar3.y1(e(fVar3, 1));
                androidx.constraintlayout.core.widgets.f fVar4 = this.f3440a;
                fVar4.f3610f.f3515e.e(fVar4.D());
            }
        }
        if (i7 == 0) {
            androidx.constraintlayout.core.widgets.f fVar5 = this.f3440a;
            androidx.constraintlayout.core.widgets.e.b bVar2 = fVar5.f3603b0[0];
            if (bVar2 == androidx.constraintlayout.core.widgets.e.b.FIXED || bVar2 == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT) {
                int iM0 = fVar5.m0() + iO0;
                this.f3440a.f3608e.f3519i.e(iM0);
                this.f3440a.f3608e.f3515e.e(iM0 - iO0);
                z8 = true;
            } else {
                z8 = false;
            }
        } else {
            androidx.constraintlayout.core.widgets.f fVar6 = this.f3440a;
            androidx.constraintlayout.core.widgets.e.b bVar3 = fVar6.f3603b0[1];
            if (bVar3 == androidx.constraintlayout.core.widgets.e.b.FIXED || bVar3 == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT) {
                int iD = fVar6.D() + iP0;
                this.f3440a.f3610f.f3519i.e(iD);
                this.f3440a.f3610f.f3515e.e(iD - iP0);
                z8 = true;
            } else {
                z8 = false;
            }
        }
        s();
        for (p pVar2 : this.f3444e) {
            if (pVar2.f3516f == i7 && (pVar2.f3512b != this.f3440a || pVar2.f3517g)) {
                pVar2.e();
            }
        }
        for (p pVar3 : this.f3444e) {
            if (pVar3.f3516f == i7 && (z8 || pVar3.f3512b != this.f3440a)) {
                if (!pVar3.f3518h.f3458j || !pVar3.f3519i.f3458j || (!(pVar3 instanceof c) && !pVar3.f3515e.f3458j)) {
                    z9 = false;
                    break;
                }
            }
        }
        this.f3440a.D1(bVarZ);
        this.f3440a.Y1(bVarZ2);
        return z9;
    }

    public void o() {
        this.f3441b = true;
    }

    public void p() {
        this.f3442c = true;
    }

    public void s() {
        g gVar;
        for (androidx.constraintlayout.core.widgets.e eVar : this.f3440a.A1) {
            if (!eVar.f3600a) {
                androidx.constraintlayout.core.widgets.e.b[] bVarArr = eVar.f3603b0;
                boolean z7 = false;
                androidx.constraintlayout.core.widgets.e.b bVar = bVarArr[0];
                androidx.constraintlayout.core.widgets.e.b bVar2 = bVarArr[1];
                int i7 = eVar.f3644w;
                int i8 = eVar.f3646x;
                androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
                boolean z8 = bVar == bVar3 || (bVar == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && i7 == 1);
                if (bVar2 == bVar3 || (bVar2 == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && i8 == 1)) {
                    z7 = true;
                }
                g gVar2 = eVar.f3608e.f3515e;
                boolean z9 = gVar2.f3458j;
                g gVar3 = eVar.f3610f.f3515e;
                boolean z10 = gVar3.f3458j;
                if (z9 && z10) {
                    androidx.constraintlayout.core.widgets.e.b bVar4 = androidx.constraintlayout.core.widgets.e.b.FIXED;
                    r(eVar, bVar4, gVar2.f3455g, bVar4, gVar3.f3455g);
                    eVar.f3600a = true;
                } else if (z9 && z7) {
                    r(eVar, androidx.constraintlayout.core.widgets.e.b.FIXED, gVar2.f3455g, bVar3, gVar3.f3455g);
                    if (bVar2 == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                        eVar.f3610f.f3515e.f3470m = eVar.D();
                    } else {
                        eVar.f3610f.f3515e.e(eVar.D());
                        eVar.f3600a = true;
                    }
                } else if (z10 && z8) {
                    r(eVar, bVar3, gVar2.f3455g, androidx.constraintlayout.core.widgets.e.b.FIXED, gVar3.f3455g);
                    if (bVar == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                        eVar.f3608e.f3515e.f3470m = eVar.m0();
                    } else {
                        eVar.f3608e.f3515e.e(eVar.m0());
                        eVar.f3600a = true;
                    }
                }
                if (eVar.f3600a && (gVar = eVar.f3610f.f3493l) != null) {
                    gVar.e(eVar.t());
                }
            }
        }
    }

    public void u(b.InterfaceC0040b interfaceC0040b) {
        this.f3446g = interfaceC0040b;
    }
}
