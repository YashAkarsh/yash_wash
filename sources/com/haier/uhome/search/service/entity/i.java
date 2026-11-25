package com.haier.uhome.search.service.entity;

import com.haier.uhome.search.json.notify.UnconnectedDevInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<UnconnectedDevInfo> f29921c;

    public String a() {
        return this.f29919a;
    }

    public int b() {
        return this.f29920b;
    }

    public List<UnconnectedDevInfo> c() {
        return this.f29921c;
    }

    public String toString() {
        return "UnConnDevDto{ip='" + this.f29919a + "', errNo=" + this.f29920b + ", infos=" + this.f29921c + '}';
    }

    public void a(String str) {
        this.f29919a = str;
    }

    public void a(int i7) {
        this.f29920b = i7;
    }

    public void a(List<UnconnectedDevInfo> list) {
        this.f29921c = list;
    }
}
