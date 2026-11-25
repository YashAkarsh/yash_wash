package com.haier.uhome.control.base.a;

import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f28726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MeshNetKey f28727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MeshAppKey f28728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f28729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, a> f28731f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, b> f28732g = new ConcurrentHashMap();

    public b a(b bVar) {
        if (bVar != null && bVar.a() != null) {
            return this.f28732g.put(bVar.a(), bVar);
        }
        e3.a.v("addDevice with " + bVar, new Object[0]);
        return null;
    }

    public b b(b bVar) {
        if (bVar != null && bVar.a() != null) {
            return this.f28732g.remove(bVar.a());
        }
        e3.a.v("addDevice with " + bVar, new Object[0]);
        return null;
    }

    public MeshAppKey c() {
        return this.f28728c;
    }

    public long d() {
        return this.f28729d;
    }

    public int e() {
        return this.f28730e;
    }

    public String toString() {
        return "MeshNetInfo{netId=" + this.f28726a + ", netKey=" + this.f28727b + ", appKey=" + this.f28728c + ", ivIndex=" + this.f28729d + ", elementAddr=" + this.f28730e + ", deviceMap=" + this.f28731f + ", groupMap=" + this.f28732g + '}';
    }

    public a a(a aVar) {
        if (aVar != null && aVar.a() != null) {
            return this.f28731f.put(aVar.a(), aVar);
        }
        e3.a.v("addDevice with " + aVar, new Object[0]);
        return null;
    }

    public a b(a aVar) {
        if (aVar != null && aVar.a() != null) {
            return this.f28731f.remove(aVar.a());
        }
        e3.a.v("rmDevice with " + aVar, new Object[0]);
        return null;
    }

    public long a() {
        return this.f28726a;
    }

    public MeshNetKey b() {
        return this.f28727b;
    }

    public void a(long j7) {
        this.f28726a = j7;
    }

    public void b(long j7) {
        this.f28729d = j7;
    }

    public void a(MeshNetKey meshNetKey) {
        this.f28727b = meshNetKey;
    }

    public void a(MeshAppKey meshAppKey) {
        this.f28728c = meshAppKey;
    }

    public void a(int i7) {
        this.f28730e = i7;
    }
}
