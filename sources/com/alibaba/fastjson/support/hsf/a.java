package com.alibaba.fastjson.support.hsf;

import com.alibaba.fastjson.parser.e;
import com.alibaba.fastjson.parser.i;
import com.alibaba.fastjson.parser.k;
import com.alibaba.fastjson.util.l;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final k f13194a = new k(1024);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final char[] f13195b = "\"argsTypes\"".toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final char[] f13196c = "\"argsObjs\"".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final char[] f13197d = "\"@type\":".toCharArray();

    public static Object[] a(String str, b bVar) {
        com.alibaba.fastjson.parser.b bVar2 = new com.alibaba.fastjson.parser.b(str);
        e eVar = (e) bVar2.h0();
        Object[] objArr = null;
        i iVarZ1 = bVar2.Z1(null, null);
        int iL0 = eVar.L0();
        int i7 = 0;
        if (iL0 != 12) {
            if (iL0 != 14) {
                return null;
            }
            String[] strArrA2 = eVar.A2(null, -1, f13194a);
            eVar.q1();
            char cD1 = eVar.d1();
            if (cD1 != ']') {
                if (cD1 == ',') {
                    eVar.next();
                    eVar.q1();
                }
                eVar.Q(14);
                Object[] objArrA1 = bVar2.a1(bVar.a(strArrA2).getGenericParameterTypes());
                eVar.close();
                return objArrA1;
            }
            Type[] genericParameterTypes = bVar.a(null).getGenericParameterTypes();
            Object[] objArr2 = new Object[strArrA2.length];
            while (i7 < strArrA2.length) {
                Type type = genericParameterTypes[i7];
                String str2 = strArrA2[i7];
                if (type != String.class) {
                    objArr2[i7] = l.g(str2, type, bVar2.u());
                } else {
                    objArr2[i7] = str2;
                }
                i7++;
            }
            return objArr2;
        }
        char[] cArr = f13195b;
        k kVar = f13194a;
        String[] strArrA3 = eVar.A2(cArr, -1, kVar);
        if (strArrA3 == null && eVar.f12931n == -2 && "com.alibaba.fastjson.JSONObject".equals(eVar.y2(f13197d))) {
            strArrA3 = eVar.A2(cArr, -1, kVar);
        }
        Method methodA = bVar.a(strArrA3);
        if (methodA == null) {
            eVar.close();
            com.alibaba.fastjson.e eVarH = com.alibaba.fastjson.a.H(str);
            Method methodA2 = bVar.a((String[]) eVarH.t1("argsTypes", String[].class));
            com.alibaba.fastjson.b bVarO1 = eVarH.o1("argsObjs");
            if (bVarO1 == null) {
                return null;
            }
            Type[] genericParameterTypes2 = methodA2.getGenericParameterTypes();
            Object[] objArr3 = new Object[genericParameterTypes2.length];
            while (i7 < genericParameterTypes2.length) {
                objArr3[i7] = bVarO1.y1(i7, genericParameterTypes2[i7]);
                i7++;
            }
            return objArr3;
        }
        Type[] genericParameterTypes3 = methodA.getGenericParameterTypes();
        eVar.q1();
        if (eVar.d1() == ',') {
            eVar.next();
        }
        if (eVar.e2(f13196c)) {
            eVar.E();
            i iVarY1 = bVar2.Y1(iVarZ1, null, "argsObjs");
            Object[] objArrA2 = bVar2.a1(genericParameterTypes3);
            iVarY1.f12965a = objArrA2;
            bVar2.b(13);
            bVar2.s0(null);
            objArr = objArrA2;
        }
        bVar2.close();
        return objArr;
    }
}
