package d2;

import com.google.zxing.d;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.r;
import com.google.zxing.t;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f33447a;

    public a(p pVar) {
        this.f33447a = pVar;
    }

    private static void c(t[] tVarArr, int i7, int i8) {
        if (tVarArr != null) {
            for (int i9 = 0; i9 < tVarArr.length; i9++) {
                t tVar = tVarArr[i9];
                tVarArr[i9] = new t(tVar.c() + i7, tVar.d() + i8);
            }
        }
    }

    @Override // com.google.zxing.p
    public r a(com.google.zxing.c cVar, Map<e, ?> map) throws m, d, h {
        int iE = cVar.e() / 2;
        int iD = cVar.d() / 2;
        try {
            try {
                try {
                    try {
                        return this.f33447a.a(cVar.a(0, 0, iE, iD), map);
                    } catch (m unused) {
                        r rVarA = this.f33447a.a(cVar.a(0, iD, iE, iD), map);
                        c(rVarA.f(), 0, iD);
                        return rVarA;
                    }
                } catch (m unused2) {
                    r rVarA2 = this.f33447a.a(cVar.a(iE, iD, iE, iD), map);
                    c(rVarA2.f(), iE, iD);
                    return rVarA2;
                }
            } catch (m unused3) {
                int i7 = iE / 2;
                int i8 = iD / 2;
                r rVarA3 = this.f33447a.a(cVar.a(i7, i8, iE, iD), map);
                c(rVarA3.f(), i7, i8);
                return rVarA3;
            }
        } catch (m unused4) {
            r rVarA4 = this.f33447a.a(cVar.a(iE, 0, iE, iD), map);
            c(rVarA4.f(), iE, 0);
            return rVarA4;
        }
    }

    @Override // com.google.zxing.p
    public r b(com.google.zxing.c cVar) throws m, d, h {
        return a(cVar, null);
    }

    @Override // com.google.zxing.p
    public void reset() {
        this.f33447a.reset();
    }
}
