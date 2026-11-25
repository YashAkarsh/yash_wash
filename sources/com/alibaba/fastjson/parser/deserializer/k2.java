package com.alibaba.fastjson.parser.deserializer;

import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k2 extends n {
    public k2(com.alibaba.fastjson.parser.j jVar, Class<?> cls) {
        super(jVar, cls, cls);
    }

    private Throwable y(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    @Override // com.alibaba.fastjson.parser.deserializer.n, com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) throws Throwable {
        Class<?> clsF;
        Object obj2;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        n nVar = null;
        if (dVar.L0() == 8) {
            dVar.E();
            return null;
        }
        if (bVar.o0() == 2) {
            bVar.e2(0);
        } else if (dVar.L0() != 12) {
            throw new com.alibaba.fastjson.d("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsF = null;
        } else {
            clsF = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsF)) {
                clsF = null;
            }
        }
        HashMap map = null;
        Throwable th = null;
        String strX0 = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strT0 = dVar.T0(bVar.r0());
            if (strT0 == null) {
                if (dVar.L0() == 13) {
                    dVar.Q(16);
                    break;
                }
                if (dVar.L0() != 16 || !dVar.G(com.alibaba.fastjson.parser.c.AllowArbitraryCommas)) {
                }
            }
            dVar.v0(4);
            if (com.alibaba.fastjson.a.f12529c.equals(strT0)) {
                if (dVar.L0() != 4) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                clsF = bVar.u().f(dVar.x0(), Throwable.class, dVar.V0());
                dVar.Q(16);
            } else if (ShareConstants.WEB_DIALOG_PARAM_MESSAGE.equals(strT0)) {
                if (dVar.L0() == 8) {
                    strX0 = null;
                } else {
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("syntax error");
                    }
                    strX0 = dVar.x0();
                }
                dVar.E();
            } else if ("cause".equals(strT0)) {
                th = (Throwable) b(bVar, null, "cause");
            } else if ("stackTrace".equals(strT0)) {
                stackTraceElementArr = (StackTraceElement[]) bVar.s1(StackTraceElement[].class);
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(strT0, bVar.x0());
            }
            if (dVar.L0() == 13) {
                dVar.Q(16);
                break;
            }
        }
        if (clsF == null) {
            obj2 = (T) new Exception(strX0, th);
        } else {
            if (!Throwable.class.isAssignableFrom(clsF)) {
                throw new com.alibaba.fastjson.d("type not match, not Throwable. " + clsF.getName());
            }
            try {
                obj2 = (T) y(strX0, th, clsF);
                if (obj2 == null) {
                    obj2 = (T) new Exception(strX0, th);
                }
            } catch (Exception e8) {
                throw new com.alibaba.fastjson.d("create instance error", e8);
            }
        }
        if (stackTraceElementArr != null) {
            ((Throwable) obj2).setStackTrace(stackTraceElementArr);
        }
        if (map != null) {
            if (clsF != null) {
                if (clsF == this.f12904c) {
                    nVar = this;
                } else {
                    e1 e1VarN = bVar.u().n(clsF);
                    if (e1VarN instanceof n) {
                        nVar = (n) e1VarN;
                    }
                }
            }
            if (nVar != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    k kVarK = nVar.k(str);
                    if (kVarK != null) {
                        kVarK.e(obj2, value);
                    }
                }
            }
        }
        return (T) obj2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.n, com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }
}
