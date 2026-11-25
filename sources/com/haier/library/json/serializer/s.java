package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class s implements h3.f, t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f26853b = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DecimalFormat f26854a;

    private s() {
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [T, java.lang.Number, java.math.BigDecimal] */
    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strA = eVar.A();
                eVar.y(16);
                return (T) Double.valueOf(Double.parseDouble(strA));
            }
            if (type == Float.TYPE || type == Float.class) {
                String strA2 = eVar.A();
                eVar.y(16);
                return (T) Float.valueOf(Float.parseFloat(strA2));
            }
            long jT = eVar.t();
            eVar.y(16);
            if (type == Short.TYPE || type == Short.class) {
                return (T) Short.valueOf((short) jT);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return (T) Byte.valueOf((byte) jT);
            }
            return (jT < -2147483648L || jT > 2147483647L) ? (T) Long.valueOf(jT) : (T) Integer.valueOf((int) jT);
        }
        if (iD0 != 3) {
            Object objG = bVar.G();
            if (objG == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return (T) i3.d.k(objG);
            }
            if (type == Float.TYPE || type == Float.class) {
                return (T) i3.d.m(objG);
            }
            if (type == Short.TYPE || type == Short.class) {
                return (T) i3.d.r(objG);
            }
            return (type == Byte.TYPE || type == Byte.class) ? (T) i3.d.g(objG) : (T) i3.d.d(objG);
        }
        if (type == Double.TYPE || type == Double.class) {
            String strA3 = eVar.A();
            eVar.y(16);
            return (T) Double.valueOf(Double.parseDouble(strA3));
        }
        if (type == Float.TYPE || type == Float.class) {
            String strA4 = eVar.A();
            eVar.y(16);
            return (T) Float.valueOf(Float.parseFloat(strA4));
        }
        ?? r8 = (T) eVar.i();
        eVar.y(16);
        if (type == Short.TYPE || type == Short.class) {
            return (T) Short.valueOf(r8.shortValue());
        }
        return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r8.byteValue()) : r8;
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        String string;
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
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (Float.isNaN(fFloatValue)) {
                zVar.H();
                return;
            }
            if (Float.isInfinite(fFloatValue)) {
                zVar.H();
                return;
            }
            String string2 = Float.toString(fFloatValue);
            if (string2.endsWith(".0")) {
                string2 = string2.substring(0, string2.length() - 2);
            }
            zVar.write(string2);
            if ((zVar.f26874c & a0.WriteClassName.f26811a) != 0) {
                zVar.write(70);
                return;
            }
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue)) {
            zVar.H();
            return;
        }
        if (Double.isInfinite(dDoubleValue)) {
            zVar.H();
            return;
        }
        DecimalFormat decimalFormat = this.f26854a;
        if (decimalFormat == null) {
            string = Double.toString(dDoubleValue);
            if (string.endsWith(".0")) {
                string = string.substring(0, string.length() - 2);
            }
        } else {
            string = decimalFormat.format(dDoubleValue);
        }
        zVar.append(string);
        if ((zVar.f26874c & a0.WriteClassName.f26811a) != 0) {
            zVar.write(68);
        }
    }

    public s(DecimalFormat decimalFormat) {
        this.f26854a = decimalFormat;
    }

    public s(String str) {
        this(new DecimalFormat(str));
    }
}
