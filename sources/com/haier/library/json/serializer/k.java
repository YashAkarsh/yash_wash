package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f26830a = new k();

    private k() {
    }

    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        T t7;
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 8) {
            eVar.y(16);
            return null;
        }
        if (iD0 == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t7 = (T) Long.valueOf(eVar.t());
            } else {
                try {
                    t7 = (T) Integer.valueOf(eVar.o());
                } catch (NumberFormatException e8) {
                    throw new com.haier.library.json.d("int value overflow, field : " + obj, e8);
                }
            }
            eVar.y(16);
            return t7;
        }
        if (iD0 == 3) {
            BigDecimal bigDecimalI = eVar.i();
            eVar.y(16);
            return (type == Long.TYPE || type == Long.class) ? (T) Long.valueOf(bigDecimalI.longValue()) : (T) Integer.valueOf(bigDecimalI.intValue());
        }
        T t8 = (T) bVar.G();
        try {
            t8 = (type == Long.TYPE || type == Long.class) ? (T) i3.d.q(t8) : (T) i3.d.n(t8);
            return t8;
        } catch (Exception e9) {
            throw new com.haier.library.json.d("cast error, field : " + obj + ", value " + t8, e9);
        }
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        Number number = (Number) obj;
        if (number == null) {
            if ((zVar.f26874c & a0.WriteNullNumberAsZero.f26811a) != 0) {
                zVar.write(48);
                return;
            } else {
                zVar.H();
                return;
            }
        }
        if (obj instanceof Long) {
            zVar.G(number.longValue());
        } else {
            zVar.C(number.intValue());
        }
        if ((zVar.f26874c & a0.WriteClassName.f26811a) != 0) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                zVar.write(66);
                return;
            }
            if (cls == Short.class) {
                zVar.write(83);
                return;
            }
            if (cls == Long.class) {
                long jLongValue = number.longValue();
                if (jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class) {
                    return;
                }
                zVar.write(76);
            }
        }
    }
}
