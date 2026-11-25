package com.haier.uhome.usdk.base.api;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKError f31109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f31110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Object> f31111c;

    public c() {
    }

    public ErrorConst a() {
        uSDKError usdkerror = this.f31109a;
        if (usdkerror == null) {
            return null;
        }
        return ErrorConst.getErrorConstById(usdkerror.getCode());
    }

    public uSDKError b() {
        return this.f31109a;
    }

    public T c() {
        return this.f31110b;
    }

    public String toString() {
        return "CommonResult{ret=" + this.f31109a + ", data=" + this.f31110b + ", extraMap=" + this.f31111c + '}';
    }

    public c(uSDKError usdkerror) {
        this.f31109a = usdkerror;
    }

    public void a(ErrorConst errorConst) {
        if (errorConst == null) {
            return;
        }
        this.f31109a = errorConst.toError();
    }

    public c(uSDKError usdkerror, T t7) {
        this.f31109a = usdkerror;
        this.f31110b = t7;
    }

    public synchronized void a(String str, Object obj) {
        if (this.f31111c == null) {
            this.f31111c = new HashMap();
        }
        this.f31111c.put(str, obj);
    }

    public Object a(String str) {
        Map<String, Object> map = this.f31111c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public void a(uSDKError usdkerror) {
        this.f31109a = usdkerror;
    }

    public void a(T t7) {
        this.f31110b = t7;
    }
}
