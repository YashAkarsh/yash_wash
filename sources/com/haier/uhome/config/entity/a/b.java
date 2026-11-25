package com.haier.uhome.config.entity.a;

import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshNetKey;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f28495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MeshNetKey f28496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MeshAppKey f28497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f28498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28499e;

    public long a() {
        return this.f28495a;
    }

    public MeshNetKey b() {
        return this.f28496b;
    }

    public MeshAppKey c() {
        return this.f28497c;
    }

    public long d() {
        return this.f28498d;
    }

    public int e() {
        return this.f28499e;
    }

    public String toString() {
        return "MeshNetInfoVo{netId=" + this.f28495a + ", netKey=" + this.f28496b + ", appKey=" + this.f28497c + ", ivIndex=" + this.f28498d + ", elementAddr=" + this.f28499e + '}';
    }

    public void a(long j7) {
        this.f28495a = j7;
    }

    public void b(long j7) {
        this.f28498d = j7;
    }

    public void a(MeshNetKey meshNetKey) {
        this.f28496b = meshNetKey;
    }

    public void a(MeshAppKey meshAppKey) {
        this.f28497c = meshAppKey;
    }

    public void a(int i7) {
        this.f28499e = i7;
    }
}
