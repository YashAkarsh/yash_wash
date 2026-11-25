package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class v implements com.alibaba.fastjson.parser.deserializer.e1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T c(com.alibaba.fastjson.parser.b bVar) {
        boolean z7;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 4) {
            String strX0 = dVar.x0();
            dVar.Q(16);
            return (T) strX0.toCharArray();
        }
        if (dVar.L0() == 2) {
            Number numberG0 = dVar.G0();
            dVar.Q(16);
            return (T) numberG0.toString().toCharArray();
        }
        Object objX0 = bVar.x0();
        if (objX0 instanceof String) {
            return (T) ((String) objX0).toCharArray();
        }
        if (!(objX0 instanceof Collection)) {
            if (objX0 == null) {
                return null;
            }
            return (T) com.alibaba.fastjson.a.y0(objX0).toCharArray();
        }
        Collection collection = (Collection) objX0;
        Iterator it = collection.iterator();
        while (true) {
            z7 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if ((next instanceof String) && ((String) next).length() != 1) {
                z7 = false;
                break;
            }
        }
        if (!z7) {
            throw new com.alibaba.fastjson.d("can not cast to char[]");
        }
        char[] cArr = new char[collection.size()];
        Iterator it2 = collection.iterator();
        int i7 = 0;
        while (it2.hasNext()) {
            cArr[i7] = ((String) it2.next()).charAt(0);
            i7++;
        }
        return cArr;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        return (T) c(bVar);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 4;
    }
}
