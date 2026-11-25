package com.google.common.reflect;

import com.google.common.base.e0;
import com.google.common.collect.ck;
import com.google.common.collect.d7;
import com.google.common.collect.h5;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class g implements AnnotatedElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<?, ?> f22448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m<?> f22450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d7<Annotation> f22451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnnotatedType f22452e;

    g(e<?, ?> eVar, int i7, m<?> mVar, Annotation[] annotationArr, AnnotatedType annotatedType) {
        this.f22448a = eVar;
        this.f22449b = i7;
        this.f22450c = mVar;
        this.f22451d = d7.u(annotationArr);
        this.f22452e = annotatedType;
    }

    public AnnotatedType a() {
        return this.f22452e;
    }

    public e<?, ?> b() {
        return this.f22448a;
    }

    public m<?> c() {
        return this.f22450c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f22449b == gVar.f22449b && this.f22448a.equals(gVar.f22448a);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        e0.E(cls);
        ck<Annotation> it = this.f22451d.iterator();
        while (it.hasNext()) {
            Annotation next = it.next();
            if (cls.isInstance(next)) {
                return cls.cast(next);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        e0.E(cls);
        return (A) h5.v(this.f22451d).r(cls).s().k();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        d7<Annotation> d7Var = this.f22451d;
        return (Annotation[]) d7Var.toArray(new Annotation[d7Var.size()]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) ((Annotation[]) h5.v(this.f22451d).r(cls).I(cls));
    }

    public int hashCode() {
        return this.f22449b;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public String toString() {
        return this.f22450c + " arg" + this.f22449b;
    }
}
