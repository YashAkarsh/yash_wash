package com.google.android.gms.common.data;

import c.m0;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e implements d, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet<d> f15554a = new HashSet<>();

    @Override // com.google.android.gms.common.data.d
    public void a(int i7, int i8) {
        Iterator<d> it = this.f15554a.iterator();
        while (it.hasNext()) {
            it.next().a(i7, i8);
        }
    }

    @Override // com.google.android.gms.common.data.d
    public void b(int i7, int i8, int i9) {
        Iterator<d> it = this.f15554a.iterator();
        while (it.hasNext()) {
            it.next().b(i7, i8, i9);
        }
    }

    @Override // com.google.android.gms.common.data.d
    public void c(int i7, int i8) {
        Iterator<d> it = this.f15554a.iterator();
        while (it.hasNext()) {
            it.next().c(i7, i8);
        }
    }

    @Override // com.google.android.gms.common.data.d
    public void d(int i7, int i8) {
        Iterator<d> it = this.f15554a.iterator();
        while (it.hasNext()) {
            it.next().d(i7, i8);
        }
    }

    @Override // com.google.android.gms.common.data.d.a
    public void e(@m0 d dVar) {
        this.f15554a.remove(dVar);
    }

    @Override // com.google.android.gms.common.data.d.a
    public void f(@m0 d dVar) {
        this.f15554a.add(dVar);
    }

    @Override // com.google.android.gms.common.data.d
    public void g() {
        Iterator<d> it = this.f15554a.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    public void h() {
        this.f15554a.clear();
    }

    public boolean i() {
        return !this.f15554a.isEmpty();
    }
}
