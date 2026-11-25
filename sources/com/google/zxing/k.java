package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<e, ?> f23741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p[] f23742b;

    private r c(c cVar) throws m {
        p[] pVarArr = this.f23742b;
        if (pVarArr != null) {
            for (p pVar : pVarArr) {
                try {
                    return pVar.a(cVar, this.f23741a);
                } catch (q unused) {
                }
            }
        }
        throw m.a();
    }

    @Override // com.google.zxing.p
    public r a(c cVar, Map<e, ?> map) throws m {
        e(map);
        return c(cVar);
    }

    @Override // com.google.zxing.p
    public r b(c cVar) throws m {
        e(null);
        return c(cVar);
    }

    public r d(c cVar) throws m {
        if (this.f23742b == null) {
            e(null);
        }
        return c(cVar);
    }

    public void e(Map<e, ?> map) {
        this.f23741a = map;
        boolean z7 = true;
        boolean z8 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z7 = false;
            }
            if (z7 && !z8) {
                arrayList.add(new com.google.zxing.oned.p(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new com.google.zxing.qrcode.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new b2.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new z1.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new e2.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new c2.a());
            }
            if (z7 && z8) {
                arrayList.add(new com.google.zxing.oned.p(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z8) {
                arrayList.add(new com.google.zxing.oned.p(map));
            }
            arrayList.add(new com.google.zxing.qrcode.a());
            arrayList.add(new b2.a());
            arrayList.add(new z1.b());
            arrayList.add(new e2.b());
            arrayList.add(new c2.a());
            if (z8) {
                arrayList.add(new com.google.zxing.oned.p(map));
            }
        }
        this.f23742b = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // com.google.zxing.p
    public void reset() {
        p[] pVarArr = this.f23742b;
        if (pVarArr != null) {
            for (p pVar : pVarArr) {
                pVar.reset();
            }
        }
    }
}
