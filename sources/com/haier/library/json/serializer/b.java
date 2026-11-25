package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26812a = new b();

    private b() {
    }

    private <T> T c(com.haier.library.json.parser.b bVar, Class<?> cls, com.haier.library.json.b bVar2) {
        if (bVar2 == null) {
            return null;
        }
        int size = bVar2.size();
        T t7 = (T) Array.newInstance(cls, size);
        for (int i7 = 0; i7 < size; i7++) {
            Object objA = bVar2.get(i7);
            if (objA == bVar2) {
                Array.set(t7, i7, t7);
            } else {
                if (!cls.isArray()) {
                    objA = i3.d.a(objA, cls, bVar.f26661b);
                } else if (!cls.isInstance(objA)) {
                    objA = c(bVar, cls, (com.haier.library.json.b) objA);
                }
                Array.set(t7, i7, objA);
            }
        }
        bVar2.T0(t7);
        bVar2.S0(cls);
        return t7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 8) {
            eVar.y(16);
            return null;
        }
        if (type != char[].class) {
            if (iD0 == 4) {
                T t7 = (T) eVar.a();
                eVar.y(16);
                return t7;
            }
            Class<?> componentType = ((Class) type).getComponentType();
            com.haier.library.json.b bVar2 = new com.haier.library.json.b();
            bVar.h0(componentType, bVar2, obj);
            return (T) c(bVar, componentType, bVar2);
        }
        if (iD0 == 4) {
            String strA0 = eVar.a0();
            eVar.y(16);
            return (T) strA0.toCharArray();
        }
        if (iD0 != 2) {
            return (T) com.haier.library.json.a.Z(bVar.G()).toCharArray();
        }
        Number numberP = eVar.p();
        eVar.y(16);
        return (T) numberP.toString().toCharArray();
    }

    @Override // com.haier.library.json.serializer.t
    public final void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            if ((zVar.f26874c & a0.WriteNullListAsEmpty.f26811a) != 0) {
                zVar.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                zVar.H();
                return;
            }
        }
        int length = objArr.length;
        int i7 = length - 1;
        if (i7 == -1) {
            zVar.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        w wVar = mVar.f26843m;
        int i8 = 0;
        mVar.t(wVar, obj, obj2, 0);
        try {
            zVar.write(91);
            if ((zVar.f26874c & a0.PrettyFormat.f26811a) != 0) {
                mVar.p();
                mVar.q();
                while (i8 < length) {
                    if (i8 != 0) {
                        zVar.write(44);
                        mVar.q();
                    }
                    mVar.y(objArr[i8]);
                    i8++;
                }
                mVar.e();
                mVar.q();
                zVar.write(93);
                return;
            }
            Class<?> cls = null;
            t tVarA = null;
            while (i8 < i7) {
                Object obj3 = objArr[i8];
                if (obj3 == null) {
                    zVar.append("null,");
                } else {
                    IdentityHashMap<Object, w> identityHashMap = mVar.f26842l;
                    if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            tVarA.b(mVar, obj3, null, null);
                        } else {
                            tVarA = mVar.f26831a.a(cls2);
                            tVarA.b(mVar, obj3, null, null);
                            cls = cls2;
                        }
                    } else {
                        mVar.B(obj3);
                    }
                    zVar.write(44);
                }
                i8++;
            }
            Object obj4 = objArr[i7];
            if (obj4 == null) {
                zVar.append("null]");
            } else {
                IdentityHashMap<Object, w> identityHashMap2 = mVar.f26842l;
                if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                    mVar.C(obj4, Integer.valueOf(i7));
                } else {
                    mVar.B(obj4);
                }
                zVar.write(93);
            }
        } finally {
            mVar.f26843m = wVar;
        }
    }
}
