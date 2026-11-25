package com.google.common.reflect;

import com.google.common.base.e0;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
class c extends AccessibleObject implements Member {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibleObject f22439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Member f22440b;

    <M extends AccessibleObject & Member> c(M m7) {
        e0.E(m7);
        this.f22439a = m7;
        this.f22440b = m7;
    }

    public m<?> a() {
        return m.V(getDeclaringClass());
    }

    public final boolean b() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean c() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean d() {
        return Modifier.isNative(getModifiers());
    }

    public final boolean e() {
        return (f() || h() || g()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return a().equals(cVar.a()) && this.f22440b.equals(cVar.f22440b);
    }

    public final boolean f() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean g() {
        return Modifier.isProtected(getModifiers());
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f22439a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f22439a.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f22439a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.f22440b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f22440b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f22440b.getName();
    }

    public final boolean h() {
        return Modifier.isPublic(getModifiers());
    }

    public int hashCode() {
        return this.f22440b.hashCode();
    }

    public final boolean i() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.f22439a.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f22439a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f22440b.isSynthetic();
    }

    public final boolean j() {
        return Modifier.isSynchronized(getModifiers());
    }

    final boolean k() {
        return Modifier.isTransient(getModifiers());
    }

    final boolean l() {
        return Modifier.isVolatile(getModifiers());
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z7) throws SecurityException {
        this.f22439a.setAccessible(z7);
    }

    public String toString() {
        return this.f22440b.toString();
    }
}
