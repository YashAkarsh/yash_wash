package com.bumptech.glide.load.model;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final l f14464d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class, Map<Class, m>> f14465a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class, Map<Class, l>> f14466b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f14467c;

    static class a implements l {
        a() {
        }

        @Override // com.bumptech.glide.load.model.l
        public com.bumptech.glide.load.data.c a(Object obj, int i7, int i8) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    public c(Context context) {
        this.f14467c = context.getApplicationContext();
    }

    private <T, Y> void c(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        Map<Class, l> map = this.f14466b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f14466b.put(cls, map);
        }
        map.put(cls2, lVar);
    }

    private <T, Y> void d(Class<T> cls, Class<Y> cls2) {
        c(cls, cls2, f14464d);
    }

    private <T, Y> l<T, Y> e(Class<T> cls, Class<Y> cls2) {
        Map<Class, l> map = this.f14466b.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> m<T, Y> f(Class<T> cls, Class<Y> cls2) {
        Map<Class, m> map;
        Map<Class, m> map2 = this.f14465a.get(cls);
        m mVar = map2 != null ? map2.get(cls2) : null;
        if (mVar == null) {
            for (Class cls3 : this.f14465a.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.f14465a.get(cls3)) != null && (mVar = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return mVar;
    }

    public synchronized <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2) {
        l<T, Y> lVarE = e(cls, cls2);
        if (lVarE != null) {
            if (f14464d.equals(lVarE)) {
                return null;
            }
            return lVarE;
        }
        m<T, Y> mVarF = f(cls, cls2);
        if (mVarF != null) {
            lVarE = mVarF.b(this.f14467c, this);
            c(cls, cls2, lVarE);
        } else {
            d(cls, cls2);
        }
        return lVarE;
    }

    @Deprecated
    public synchronized <T, Y> l<T, Y> b(Class<T> cls, Class<Y> cls2, Context context) {
        return a(cls, cls2);
    }

    public synchronized <T, Y> m<T, Y> g(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> mVarPut;
        this.f14466b.clear();
        Map<Class, m> map = this.f14465a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f14465a.put(cls, map);
        }
        mVarPut = map.put(cls2, mVar);
        if (mVarPut != null) {
            Iterator<Map<Class, m>> it = this.f14465a.values().iterator();
            while (it.hasNext()) {
                if (it.next().containsValue(mVarPut)) {
                    mVarPut = null;
                    break;
                }
            }
        }
        return mVarPut;
    }

    public synchronized <T, Y> m<T, Y> h(Class<T> cls, Class<Y> cls2) {
        Map<Class, m> map;
        this.f14466b.clear();
        map = this.f14465a.get(cls);
        return map != null ? map.remove(cls2) : null;
    }
}
