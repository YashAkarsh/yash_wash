package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends l implements Iterable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l> f23009a;

    public i() {
        this.f23009a = new ArrayList();
    }

    public void A(l lVar) {
        if (lVar == null) {
            lVar = n.f23245a;
        }
        this.f23009a.add(lVar);
    }

    public void B(Boolean bool) {
        this.f23009a.add(bool == null ? n.f23245a : new r(bool));
    }

    public void D(Character ch) {
        this.f23009a.add(ch == null ? n.f23245a : new r(ch));
    }

    public void F(Number number) {
        this.f23009a.add(number == null ? n.f23245a : new r(number));
    }

    public void G(String str) {
        this.f23009a.add(str == null ? n.f23245a : new r(str));
    }

    public void H(i iVar) {
        this.f23009a.addAll(iVar.f23009a);
    }

    public boolean I(l lVar) {
        return this.f23009a.contains(lVar);
    }

    @Override // com.google.gson.l
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public i a() {
        if (this.f23009a.isEmpty()) {
            return new i();
        }
        i iVar = new i(this.f23009a.size());
        Iterator<l> it = this.f23009a.iterator();
        while (it.hasNext()) {
            iVar.A(it.next().a());
        }
        return iVar;
    }

    public l K(int i7) {
        return this.f23009a.get(i7);
    }

    public l L(int i7) {
        return this.f23009a.remove(i7);
    }

    public boolean M(l lVar) {
        return this.f23009a.remove(lVar);
    }

    public l N(int i7, l lVar) {
        return this.f23009a.set(i7, lVar);
    }

    @Override // com.google.gson.l
    public BigDecimal b() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public BigInteger d() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).d();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f23009a.equals(this.f23009a));
    }

    @Override // com.google.gson.l
    public boolean f() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).f();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public byte g() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).g();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public char h() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).h();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f23009a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f23009a.iterator();
    }

    @Override // com.google.gson.l
    public double j() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).j();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public float k() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).k();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public int l() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).l();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public long r() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).r();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public Number s() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).s();
        }
        throw new IllegalStateException();
    }

    public int size() {
        return this.f23009a.size();
    }

    @Override // com.google.gson.l
    public short t() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).t();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public String u() {
        if (this.f23009a.size() == 1) {
            return this.f23009a.get(0).u();
        }
        throw new IllegalStateException();
    }

    public i(int i7) {
        this.f23009a = new ArrayList(i7);
    }
}
