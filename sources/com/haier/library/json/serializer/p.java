package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements t {
    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        boolean z7;
        Object objR;
        Object objS;
        z zVar = mVar.f26832b;
        if (obj == null) {
            zVar.H();
            return;
        }
        Map treeMap = (Map) obj;
        Class<?> cls = treeMap.getClass();
        boolean z8 = (cls == com.haier.library.json.e.class || cls == HashMap.class || cls == LinkedHashMap.class) && treeMap.containsKey(com.haier.library.json.a.f26646c);
        if ((zVar.f26874c & a0.SortField.f26811a) != 0 && !(treeMap instanceof SortedMap) && !(treeMap instanceof LinkedHashMap)) {
            try {
                treeMap = new TreeMap(treeMap);
            } catch (Exception unused) {
            }
        }
        IdentityHashMap<Object, w> identityHashMap = mVar.f26842l;
        if (identityHashMap != null && identityHashMap.containsKey(obj)) {
            mVar.B(obj);
            return;
        }
        w wVar = mVar.f26843m;
        mVar.t(wVar, obj, obj2, 0);
        try {
            zVar.write(123);
            mVar.p();
            if ((zVar.f26874c & a0.WriteClassName.f26811a) == 0 || z8) {
                z7 = true;
            } else {
                zVar.v(mVar.f26831a.f26861b, false);
                zVar.K(obj.getClass().getName());
                z7 = false;
            }
            Class<?> cls2 = null;
            t tVar = null;
            for (Map.Entry entry : treeMap.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                if (mVar.b(obj, key) && mVar.a(obj, key, value) && ((objS = m.s(mVar, obj, (objR = mVar.r(obj, key, value)), value)) != null || (zVar.f26874c & a0.WriteMapNullValue.f26811a) != 0)) {
                    if (objR instanceof String) {
                        String str = (String) objR;
                        if (!z7) {
                            zVar.write(44);
                        }
                        if ((zVar.f26874c & a0.PrettyFormat.f26811a) != 0) {
                            mVar.q();
                        }
                        zVar.v(str, true);
                    } else {
                        if (!z7) {
                            zVar.write(44);
                        }
                        int i7 = zVar.f26874c;
                        if ((a0.BrowserCompatible.f26811a & i7) == 0 && (i7 & a0.WriteNonStringKeyAsString.f26811a) == 0) {
                            mVar.y(objR);
                        } else {
                            mVar.z(com.haier.library.json.a.Z(objR));
                        }
                        zVar.write(58);
                    }
                    if (objS == null) {
                        zVar.H();
                    } else {
                        Class<?> cls3 = objS.getClass();
                        if (cls3 == cls2) {
                            tVar.b(mVar, objS, objR, null);
                        } else {
                            t tVarA = mVar.f26831a.a(cls3);
                            tVarA.b(mVar, objS, objR, null);
                            tVar = tVarA;
                            cls2 = cls3;
                        }
                    }
                    z7 = false;
                }
            }
            mVar.f26843m = wVar;
            mVar.e();
            if ((zVar.f26874c & a0.PrettyFormat.f26811a) != 0 && treeMap.size() > 0) {
                mVar.q();
            }
            zVar.write(125);
        } catch (Throwable th) {
            mVar.f26843m = wVar;
            throw th;
        }
    }
}
