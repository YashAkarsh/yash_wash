package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class e implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f26819a = new e();

    private e() {
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.math.BigDecimal] */
    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 2) {
            String strA = eVar.A();
            eVar.y(16);
            return type == BigInteger.class ? (T) new BigInteger(strA) : (T) new BigDecimal(strA);
        }
        if (iD0 == 3) {
            ?? r7 = (T) eVar.i();
            eVar.y(16);
            return type == BigInteger.class ? (T) r7.toBigInteger() : r7;
        }
        Object objG = bVar.G();
        if (objG == null) {
            return null;
        }
        return type == BigInteger.class ? (T) i3.d.e(objG) : (T) i3.d.d(objG);
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        if (obj == null) {
            if ((zVar.f26874c & a0.WriteNullNumberAsZero.f26811a) != 0) {
                zVar.write(48);
                return;
            } else {
                zVar.H();
                return;
            }
        }
        if (obj instanceof BigInteger) {
            zVar.write(((BigInteger) obj).toString());
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        zVar.write(bigDecimal.toString());
        if ((zVar.f26874c & a0.WriteClassName.f26811a) == 0 || type == BigDecimal.class || bigDecimal.scale() != 0) {
            return;
        }
        zVar.write(46);
    }
}
