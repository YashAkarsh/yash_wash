package com.haier.library.json.parser;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j extends h3.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f26760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h3.f f26761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f26762e;

    public j(m mVar, Class<?> cls, i3.a aVar) {
        super(cls, aVar, 14);
        Type type = aVar.f34168h;
        Class<?> cls2 = aVar.f34167g;
        if (type instanceof ParameterizedType) {
            this.f26760c = ((ParameterizedType) type).getActualTypeArguments()[0];
            this.f26762e = false;
        } else if (cls2.isArray()) {
            this.f26760c = cls2.getComponentType();
            this.f26762e = true;
        } else {
            this.f26760c = Object.class;
            this.f26762e = false;
        }
    }

    @Override // h3.d
    public void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        List arrayList;
        com.haier.library.json.b bVar2;
        Object array;
        if (bVar.f26664e.f26705a == 8) {
            f(obj, null);
            bVar.f26664e.x();
            return;
        }
        if (this.f26762e) {
            com.haier.library.json.b bVar3 = new com.haier.library.json.b();
            bVar3.S0(this.f26760c);
            bVar2 = bVar3;
            arrayList = bVar3;
        } else {
            arrayList = new ArrayList();
            bVar2 = null;
        }
        l lVar = bVar.f26665f;
        bVar.V0(lVar, obj, this.f34042a.f34161a);
        g(bVar, type, arrayList);
        bVar.Y0(lVar);
        Object obj2 = arrayList;
        if (this.f26762e) {
            array = arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f26760c, arrayList.size()));
            bVar2.T0(array);
        }
        if (obj == null) {
            obj2 = array;
            map.put(this.f34042a.f34161a, obj2);
        } else {
            obj2 = array;
            f(obj, obj2);
        }
    }

    final void g(b bVar, Type type, Collection collection) {
        int i7;
        Type type2 = this.f26760c;
        h3.f fVarC = this.f26761d;
        if ((type2 instanceof TypeVariable) && (type instanceof ParameterizedType)) {
            TypeVariable typeVariable = (TypeVariable) type2;
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
            if (cls == null) {
                i7 = -1;
                break;
            }
            int length = cls.getTypeParameters().length;
            i7 = 0;
            while (true) {
                if (i7 >= length) {
                    i7 = -1;
                    break;
                } else if (cls.getTypeParameters()[i7].getName().equals(typeVariable.getName())) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 != -1) {
                type2 = parameterizedType.getActualTypeArguments()[i7];
                if (!type2.equals(this.f26760c)) {
                    fVarC = bVar.f26661b.c(type2);
                }
            }
        }
        e eVar = bVar.f26664e;
        if (eVar.f26705a != 14) {
            String str = "exepct '[', but " + f.a(eVar.f26705a);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new com.haier.library.json.d(str);
        }
        if (fVarC == null) {
            fVarC = bVar.f26661b.c(type2);
            this.f26761d = fVarC;
        }
        char c8 = eVar.f26710f;
        if (c8 == '[') {
            int i8 = eVar.f26711g + 1;
            eVar.f26711g = i8;
            eVar.f26710f = i8 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i8);
            eVar.f26705a = 14;
        } else if (c8 == '{') {
            int i9 = eVar.f26711g + 1;
            eVar.f26711g = i9;
            eVar.f26710f = i9 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i9);
            eVar.f26705a = 12;
        } else if (c8 == '\"') {
            eVar.R();
        } else if (c8 == ']') {
            int i10 = eVar.f26711g + 1;
            eVar.f26711g = i10;
            eVar.f26710f = i10 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i10);
            eVar.f26705a = 15;
        } else {
            eVar.x();
        }
        int i11 = 0;
        while (true) {
            int i12 = eVar.f26705a;
            if (i12 == 16) {
                if ((d.AllowArbitraryCommas.f26696a & eVar.f26707c) != 0) {
                    eVar.x();
                }
            }
            if (i12 == 15) {
                break;
            }
            collection.add(fVarC.a(bVar, type2, Integer.valueOf(i11)));
            if (bVar.f26669j == 1) {
                bVar.e(collection);
            }
            if (eVar.f26705a == 16) {
                char c9 = eVar.f26710f;
                if (c9 == '[') {
                    int i13 = eVar.f26711g + 1;
                    eVar.f26711g = i13;
                    eVar.f26710f = i13 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i13);
                    eVar.f26705a = 14;
                } else if (c9 == '{') {
                    int i14 = eVar.f26711g + 1;
                    eVar.f26711g = i14;
                    eVar.f26710f = i14 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i14);
                    eVar.f26705a = 12;
                } else if (c9 == '\"') {
                    eVar.R();
                } else {
                    eVar.x();
                }
            }
            i11++;
        }
        if (eVar.f26710f != ',') {
            eVar.x();
            return;
        }
        int i15 = eVar.f26711g + 1;
        eVar.f26711g = i15;
        eVar.f26710f = i15 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i15);
        eVar.f26705a = 16;
    }
}
