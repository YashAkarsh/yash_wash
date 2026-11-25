package com.google.gson;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.i<String, l> f23246a = new com.google.gson.internal.i<>();

    public void A(String str, l lVar) {
        com.google.gson.internal.i<String, l> iVar = this.f23246a;
        if (lVar == null) {
            lVar = n.f23245a;
        }
        iVar.put(str, lVar);
    }

    public void B(String str, Boolean bool) {
        A(str, bool == null ? n.f23245a : new r(bool));
    }

    public void D(String str, Character ch) {
        A(str, ch == null ? n.f23245a : new r(ch));
    }

    public void F(String str, Number number) {
        A(str, number == null ? n.f23245a : new r(number));
    }

    public void G(String str, String str2) {
        A(str, str2 == null ? n.f23245a : new r(str2));
    }

    @Override // com.google.gson.l
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public o a() {
        o oVar = new o();
        for (Map.Entry<String, l> entry : this.f23246a.entrySet()) {
            oVar.A(entry.getKey(), entry.getValue().a());
        }
        return oVar;
    }

    public l I(String str) {
        return this.f23246a.get(str);
    }

    public i J(String str) {
        return (i) this.f23246a.get(str);
    }

    public o K(String str) {
        return (o) this.f23246a.get(str);
    }

    public r L(String str) {
        return (r) this.f23246a.get(str);
    }

    public boolean M(String str) {
        return this.f23246a.containsKey(str);
    }

    public Set<String> N() {
        return this.f23246a.keySet();
    }

    public l O(String str) {
        return this.f23246a.remove(str);
    }

    public Set<Map.Entry<String, l>> entrySet() {
        return this.f23246a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f23246a.equals(this.f23246a));
    }

    public int hashCode() {
        return this.f23246a.hashCode();
    }

    public int size() {
        return this.f23246a.size();
    }
}
