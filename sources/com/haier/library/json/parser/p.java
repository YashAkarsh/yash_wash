package com.haier.library.json.parser;

import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class p extends g {
    public p(m mVar, Class<?> cls) {
        super(mVar, cls, cls);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0031  */
    /* JADX WARN: Code duplicated, block: B:96:0x0176  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r7v3 */
    @Override // com.haier.library.json.parser.g, h3.f
    public <T> T a(b bVar, Type type, Object obj) {
        Class<?> clsC;
        Object objA0;
        Object obj2;
        String str;
        Throwable th;
        Object obj3;
        e eVar = bVar.f26664e;
        int i7 = eVar.f26705a;
        Type type2 = null;
        if (i7 == 8) {
            eVar.x();
            return null;
        }
        if (bVar.f26669j == 2) {
            bVar.f26669j = 0;
        } else if (i7 != 12) {
            throw new com.haier.library.json.d("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsC = null;
        } else {
            clsC = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsC)) {
                clsC = null;
            }
        }
        HashMap map = new HashMap();
        Throwable th2 = null;
        Object obj4 = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strT = eVar.T(bVar.f26660a);
            if (strT == null) {
                int i8 = eVar.f26705a;
                if (i8 == 13) {
                    eVar.y(16);
                    str = obj4;
                    break;
                }
                if (i8 != 16 || (eVar.f26707c & d.AllowArbitraryCommas.f26696a) == 0) {
                }
                obj4 = obj4;
            }
            eVar.z(':');
            if (!com.haier.library.json.a.f26646c.equals(strT)) {
                if (ShareConstants.WEB_DIALOG_PARAM_MESSAGE.equals(strT)) {
                    int i9 = eVar.f26705a;
                    if (i9 == 8) {
                        objA0 = type2;
                    } else {
                        if (i9 != 4) {
                            throw new com.haier.library.json.d("syntax error");
                        }
                        objA0 = eVar.a0();
                    }
                    eVar.x();
                    obj2 = objA0;
                } else if ("cause".equals(strT)) {
                    th2 = (Throwable) a(bVar, type2, "cause");
                    obj4 = obj4;
                } else if ("stackTrace".equals(strT)) {
                    stackTraceElementArr = (StackTraceElement[]) bVar.v0(StackTraceElement[].class);
                    obj4 = obj4;
                } else {
                    map.put(strT, bVar.G());
                    obj4 = obj4;
                }
                if (eVar.f26705a == 13) {
                    eVar.y(16);
                    str = obj4;
                    break;
                }
                type2 = null;
                obj4 = obj4;
            } else {
                if (eVar.f26705a != 4) {
                    throw new com.haier.library.json.d("syntax error");
                }
                clsC = i3.d.C(eVar.a0(), bVar.f26661b.f26771c);
                eVar.y(16);
                obj2 = obj4;
            }
            obj4 = obj2;
            if (eVar.f26705a == 13) {
                eVar.y(16);
                str = obj4;
                break;
            }
            type2 = null;
            obj4 = obj4;
        }
        if (clsC == null) {
            obj3 = (T) new Exception(str, th2);
        } else {
            try {
                Constructor<?>[] constructors = clsC.getConstructors();
                int length = constructors.length;
                Type type3 = type2;
                Type type4 = type3;
                Constructor constructor = type4;
                int i10 = 0;
                Constructor constructor2 = type3;
                Constructor constructor3 = type4;
                while (i10 < length) {
                    Constructor<?> constructor4 = constructors[i10];
                    if (constructor4.getParameterTypes().length == 0) {
                        constructor = constructor4;
                    } else if (constructor4.getParameterTypes().length == 1 && constructor4.getParameterTypes()[0] == String.class) {
                        constructor3 = constructor4;
                    } else if (constructor4.getParameterTypes().length == 2 && constructor4.getParameterTypes()[0] == String.class && constructor4.getParameterTypes()[1] == Throwable.class) {
                        constructor2 = constructor4;
                    }
                    i10++;
                    constructor2 = constructor2;
                    constructor3 = constructor3;
                    constructor = constructor;
                }
                if (constructor2 != 0) {
                    th = (Throwable) constructor2.newInstance(str, th2);
                } else if (constructor3 != 0) {
                    th = (Throwable) constructor3.newInstance(str);
                } else {
                    th = constructor != 0 ? (Throwable) constructor.newInstance(new Object[0]) : null;
                }
                obj3 = th == null ? (T) new Exception(str, th2) : (T) th;
            } catch (Exception e8) {
                throw new com.haier.library.json.d("create instance error", e8);
            }
        }
        if (stackTraceElementArr != null) {
            ((Throwable) obj3).setStackTrace(stackTraceElementArr);
        }
        return (T) obj3;
    }
}
