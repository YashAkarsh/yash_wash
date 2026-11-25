package org.junit.experimental.results;

import org.hamcrest.g;
import org.hamcrest.k;
import org.hamcrest.p;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    static class a extends p<org.junit.experimental.results.b> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f39788c;

        a(int i7) {
            this.f39788c = i7;
        }

        @Override // org.hamcrest.m
        public void b(g gVar) {
            gVar.d("has " + this.f39788c + " failures");
        }

        @Override // org.hamcrest.p
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean f(org.junit.experimental.results.b bVar) {
            return bVar.a() == this.f39788c;
        }
    }

    static class b extends org.hamcrest.b<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f39789a;

        b(String str) {
            this.f39789a = str;
        }

        @Override // org.hamcrest.m
        public void b(g gVar) {
            gVar.d("has single failure containing " + this.f39789a);
        }

        @Override // org.hamcrest.k
        public boolean c(Object obj) {
            return obj.toString().contains(this.f39789a) && c.a(1).c(obj);
        }
    }

    /* JADX INFO: renamed from: org.junit.experimental.results.c$c, reason: collision with other inner class name */
    static class C0532c extends org.hamcrest.b<org.junit.experimental.results.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f39790a;

        C0532c(String str) {
            this.f39790a = str;
        }

        @Override // org.hamcrest.m
        public void b(g gVar) {
            gVar.d("has failure containing " + this.f39790a);
        }

        @Override // org.hamcrest.k
        public boolean c(Object obj) {
            return obj.toString().contains(this.f39790a);
        }
    }

    public static k<org.junit.experimental.results.b> a(int i7) {
        return new a(i7);
    }

    public static k<org.junit.experimental.results.b> b(String str) {
        return new C0532c(str);
    }

    public static k<Object> c(String str) {
        return new b(str);
    }

    public static k<org.junit.experimental.results.b> d() {
        return a(0);
    }
}
