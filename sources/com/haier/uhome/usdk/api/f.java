package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.api.interfaces.IProgressCallback;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<String, Object> f30521a = new WeakHashMap<>();

    f() {
    }

    private static <T> T a(String str, Class<T> cls) {
        String str2 = String.format("%s:%s", cls.getName(), str);
        WeakHashMap<String, Object> weakHashMap = f30521a;
        Object obj = (T) weakHashMap.get(str2);
        if (obj == null) {
            synchronized (weakHashMap) {
                Object obj2 = weakHashMap.get(str2);
                if (obj2 == null) {
                    Object objA = a(cls);
                    weakHashMap.put(str, objA);
                    obj = (T) objA;
                } else {
                    obj = obj2;
                }
            }
        }
        return (T) obj;
    }

    static void b(uSDKDevice usdkdevice, List<uSDKDevice> list, int i7, IProgressCallback<uSDKDevice, Void> iProgressCallback) {
        ((com.haier.uhome.usdk.api.a.i) a(usdkdevice.getDeviceId(), com.haier.uhome.usdk.api.a.i.class)).a(usdkdevice, list, i7, iProgressCallback);
    }

    static void b(uSDKDevice usdkdevice, ICallback<Void> iCallback) {
        ((com.haier.uhome.usdk.api.a.g) a(usdkdevice.getDeviceId(), com.haier.uhome.usdk.api.a.g.class)).a(usdkdevice, iCallback);
    }

    private static <T> T a(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    static void a(uSDKDevice usdkdevice, ICallback<List<uSDKDevice>> iCallback) {
        ((com.haier.uhome.usdk.api.a.h) a(usdkdevice.getDeviceId(), com.haier.uhome.usdk.api.a.h.class)).a(usdkdevice, iCallback);
    }

    static void a(uSDKDevice usdkdevice, int i7, ICallback<uSDKDevice> iCallback) {
        ((com.haier.uhome.usdk.api.a.f) a(usdkdevice.getDeviceId(), com.haier.uhome.usdk.api.a.f.class)).a(usdkdevice, i7, iCallback);
    }

    static void a(uSDKDevice usdkdevice, List<uSDKDevice> list, int i7, IProgressCallback<uSDKDevice, Void> iProgressCallback) {
        ((com.haier.uhome.usdk.api.a.e) a(usdkdevice.getDeviceId(), com.haier.uhome.usdk.api.a.e.class)).a(usdkdevice, list, i7, iProgressCallback);
    }
}
