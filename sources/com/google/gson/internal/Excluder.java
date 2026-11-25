package com.google.gson.internal;

import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Excluder implements y, Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final double f23010g = -1.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Excluder f23011h = new Excluder();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23015d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f23012a = f23010g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23013b = 136;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23014c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<com.google.gson.b> f23016e = Collections.emptyList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.google.gson.b> f23017f = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private x<T> f23018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f23019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f23020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.gson.f f23021d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.gson.reflect.a f23022e;

        a(boolean z7, boolean z8, com.google.gson.f fVar, com.google.gson.reflect.a aVar) {
            this.f23019b = z7;
            this.f23020c = z8;
            this.f23021d = fVar;
            this.f23022e = aVar;
        }

        private x<T> j() {
            x<T> xVar = this.f23018a;
            if (xVar != null) {
                return xVar;
            }
            x<T> xVarR = this.f23021d.r(Excluder.this, this.f23022e);
            this.f23018a = xVarR;
            return xVarR;
        }

        @Override // com.google.gson.x
        public T e(com.google.gson.stream.a aVar) throws IOException {
            if (!this.f23019b) {
                return j().e(aVar);
            }
            aVar.q1();
            return null;
        }

        @Override // com.google.gson.x
        public void i(com.google.gson.stream.d dVar, T t7) throws IOException {
            if (this.f23020c) {
                dVar.g0();
            } else {
                j().i(dVar, t7);
            }
        }
    }

    private boolean j(Class<?> cls) {
        if (this.f23012a == f23010g || s((w1.d) cls.getAnnotation(w1.d.class), (w1.e) cls.getAnnotation(w1.e.class))) {
            return (!this.f23014c && o(cls)) || n(cls);
        }
        return true;
    }

    private boolean k(Class<?> cls, boolean z7) {
        Iterator<com.google.gson.b> it = (z7 ? this.f23016e : this.f23017f).iterator();
        while (it.hasNext()) {
            if (it.next().b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean n(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean o(Class<?> cls) {
        return cls.isMemberClass() && !p(cls);
    }

    private boolean p(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean q(w1.d dVar) {
        return dVar == null || dVar.value() <= this.f23012a;
    }

    private boolean r(w1.e eVar) {
        return eVar == null || eVar.value() > this.f23012a;
    }

    private boolean s(w1.d dVar, w1.e eVar) {
        return q(dVar) && r(eVar);
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.f fVar, com.google.gson.reflect.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zJ = j(rawType);
        boolean z7 = zJ || k(rawType, true);
        boolean z8 = zJ || k(rawType, false);
        if (z7 || z8) {
            return new a(z8, z7, fVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e8) {
            throw new AssertionError(e8);
        }
    }

    public Excluder h() {
        Excluder excluderClone = clone();
        excluderClone.f23014c = false;
        return excluderClone;
    }

    public boolean i(Class<?> cls, boolean z7) {
        return j(cls) || k(cls, z7);
    }

    public boolean l(Field field, boolean z7) {
        w1.a aVar;
        if ((this.f23013b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f23012a != f23010g && !s((w1.d) field.getAnnotation(w1.d.class), (w1.e) field.getAnnotation(w1.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f23015d && ((aVar = (w1.a) field.getAnnotation(w1.a.class)) == null || (!z7 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f23014c && o(field.getType())) || n(field.getType())) {
            return true;
        }
        List<com.google.gson.b> list = z7 ? this.f23016e : this.f23017f;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.c cVar = new com.google.gson.c(field);
        Iterator<com.google.gson.b> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(cVar)) {
                return true;
            }
        }
        return false;
    }

    public Excluder m() {
        Excluder excluderClone = clone();
        excluderClone.f23015d = true;
        return excluderClone;
    }

    public Excluder t(com.google.gson.b bVar, boolean z7, boolean z8) {
        Excluder excluderClone = clone();
        if (z7) {
            ArrayList arrayList = new ArrayList(this.f23016e);
            excluderClone.f23016e = arrayList;
            arrayList.add(bVar);
        }
        if (z8) {
            ArrayList arrayList2 = new ArrayList(this.f23017f);
            excluderClone.f23017f = arrayList2;
            arrayList2.add(bVar);
        }
        return excluderClone;
    }

    public Excluder u(int... iArr) {
        Excluder excluderClone = clone();
        excluderClone.f23013b = 0;
        for (int i7 : iArr) {
            excluderClone.f23013b = i7 | excluderClone.f23013b;
        }
        return excluderClone;
    }

    public Excluder v(double d8) {
        Excluder excluderClone = clone();
        excluderClone.f23012a = d8;
        return excluderClone;
    }
}
