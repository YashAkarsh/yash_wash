package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class g implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f26821a = new g();

    private g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [T, com.haier.library.json.b, java.util.Collection] */
    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        Collection collection;
        Type type2 = null;
        if (bVar.f26664e.d0() == 8) {
            bVar.f26664e.y(16);
            return null;
        }
        if (type == com.haier.library.json.b.class) {
            ?? r8 = (T) new com.haier.library.json.b();
            bVar.l0(r8);
            return r8;
        }
        Type rawType = type;
        while (!(rawType instanceof Class)) {
            if (!(rawType instanceof ParameterizedType)) {
                throw new com.haier.library.json.d("TODO");
            }
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        Class cls = (Class) rawType;
        Type type3 = Object.class;
        if (cls == AbstractCollection.class || cls == Collection.class) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(HashSet.class)) {
            collection = (T) new HashSet();
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            collection = (T) new LinkedHashSet();
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            collection = (T) new TreeSet();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(EnumSet.class)) {
            collection = (T) EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : type3));
        } else {
            try {
                collection = (T) ((Collection) cls.newInstance());
            } catch (Exception unused) {
                throw new com.haier.library.json.d("create instane error, class " + cls.getName());
            }
        }
        if (type instanceof ParameterizedType) {
            type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (!cls2.getName().startsWith("java.")) {
                    Type genericSuperclass = cls2.getGenericSuperclass();
                    if (genericSuperclass instanceof ParameterizedType) {
                        type2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                    }
                }
            }
            if (type2 != null) {
                type3 = type2;
            }
        }
        bVar.h0(type3, collection, obj);
        return (T) collection;
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        if (obj == null) {
            if ((zVar.f26874c & a0.WriteNullListAsEmpty.f26811a) != 0) {
                zVar.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                zVar.H();
                return;
            }
        }
        int i7 = zVar.f26874c;
        a0 a0Var = a0.WriteClassName;
        int i8 = 0;
        Type type2 = ((i7 & a0Var.f26811a) == 0 || !(type instanceof ParameterizedType)) ? null : ((ParameterizedType) type).getActualTypeArguments()[0];
        Collection collection = (Collection) obj;
        w wVar = mVar.f26843m;
        mVar.t(wVar, obj, obj2, 0);
        if ((zVar.f26874c & a0Var.f26811a) != 0) {
            if (HashSet.class == collection.getClass()) {
                zVar.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                zVar.append("TreeSet");
            }
        }
        try {
            zVar.write(91);
            for (Object obj3 : collection) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    zVar.write(44);
                }
                if (obj3 == null) {
                    zVar.H();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        zVar.C(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        zVar.G(((Long) obj3).longValue());
                        if ((zVar.f26874c & a0.WriteClassName.f26811a) != 0) {
                            zVar.write(76);
                        }
                    } else {
                        mVar.f26831a.a(cls).b(mVar, obj3, Integer.valueOf(i9 - 1), type2);
                    }
                }
                i8 = i9;
            }
            zVar.write(93);
        } finally {
            mVar.f26843m = wVar;
        }
    }
}
