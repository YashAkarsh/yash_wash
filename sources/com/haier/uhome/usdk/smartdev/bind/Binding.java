package com.haier.uhome.usdk.smartdev.bind;

import com.haier.uhome.smart.api.SmartDeviceManager;
import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class Binding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SmartDeviceManager f32089a = SmartDeviceManager.getInstance();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Binding f32090a = new Binding();

        private a() {
        }
    }

    @Keep
    public static Binding getSingleInstance() {
        return a.f32090a;
    }

    @Keep
    public void bindDeviceBySmartLink(com.haier.uhome.usdk.smartdev.bind.a aVar, b bVar) {
    }
}
