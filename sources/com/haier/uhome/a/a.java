package com.haier.uhome.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f28052a;

    static {
        HashMap map = new HashMap();
        f28052a = map;
        map.put("manager", "com.haier.uhome.cam.HCDevManager");
        map.put("hCResult", "com.haier.uhome.cam.model.HCResult");
        map.put("hCDevice", "com.haier.uhome.cam.model.HCDevice");
        map.put("deviceCallback", "com.haier.uhome.cam.interfaces.IHCBindDeviceCallback");
        map.put("ihcCallback", "com.haier.uhome.cam.interfaces.IHCCallback");
        map.put("errorResult", "com.haier.uhome.cam.constant.ErrorResult");
    }

    private a() {
    }

    public static Class<?> a(String str) throws ClassNotFoundException {
        return Class.forName(f28052a.get(str));
    }

    public static Class<?> a() {
        try {
            return a("manager");
        } catch (ClassNotFoundException unused) {
            System.err.println("getEntranceClass:can not found manager class in classpath.");
            return null;
        }
    }
}
