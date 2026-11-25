package com.google.auto.common;

import java.util.Optional;
import java.util.function.Function;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    private j() {
    }

    @Deprecated
    public static Optional<com.squareup.javapoet.a> e(Elements elements, Class<?> cls) {
        return i(elements, cls).map(new i());
    }

    @Deprecated
    public static Optional<com.squareup.javapoet.a> f(Elements elements, Class<?> cls, final String str) {
        return i(elements, cls).map(new Function() { // from class: com.google.auto.common.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return j.k(str, (com.squareup.javapoet.a.b) obj);
            }
        });
    }

    public static Optional<com.squareup.javapoet.a> g(Elements elements, SourceVersion sourceVersion, Class<?> cls) {
        return j(elements, sourceVersion, cls).map(new i());
    }

    public static Optional<com.squareup.javapoet.a> h(Elements elements, SourceVersion sourceVersion, Class<?> cls, final String str) {
        return j(elements, sourceVersion, cls).map(new Function() { // from class: com.google.auto.common.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return j.l(str, (com.squareup.javapoet.a.b) obj);
            }
        });
    }

    private static Optional<com.squareup.javapoet.a.b> i(Elements elements, final Class<?> cls) {
        return l.a(elements).map(new Function() { // from class: com.google.auto.common.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return j.m(cls, (TypeElement) obj);
            }
        });
    }

    private static Optional<com.squareup.javapoet.a.b> j(Elements elements, SourceVersion sourceVersion, final Class<?> cls) {
        return l.b(elements, sourceVersion).map(new Function() { // from class: com.google.auto.common.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return j.n(cls, (TypeElement) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.squareup.javapoet.a k(String str, com.squareup.javapoet.a.b bVar) {
        return bVar.d("comments", "$S", str).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.squareup.javapoet.a l(String str, com.squareup.javapoet.a.b bVar) {
        return bVar.d("comments", "$S", str).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.squareup.javapoet.a.b m(Class cls, TypeElement typeElement) {
        return com.squareup.javapoet.a.a(com.squareup.javapoet.c.y(typeElement)).d("value", "$S", cls.getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.squareup.javapoet.a.b n(Class cls, TypeElement typeElement) {
        return com.squareup.javapoet.a.a(com.squareup.javapoet.c.y(typeElement)).d("value", "$S", cls.getCanonicalName());
    }
}
