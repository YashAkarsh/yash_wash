package com.haier.uhome.usdk.bind.entity;

import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<uSDKDevice> f31549a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<DeviceWithError> f31550b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private uSDKError f31551c;

    public List<uSDKDevice> a() {
        return this.f31549a;
    }

    public List<DeviceWithError> b() {
        return this.f31550b;
    }

    public uSDKError c() {
        return this.f31551c;
    }

    public String toString() {
        return "CellularResp{success=" + this.f31549a + ", failed=" + this.f31550b + '}';
    }

    public void a(List<uSDKDevice> list) {
        this.f31549a = list;
    }

    public void b(List<DeviceWithError> list) {
        this.f31550b = list;
    }

    public void a(uSDKError usdkerror) {
        this.f31551c = usdkerror;
    }
}
