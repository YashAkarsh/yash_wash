package com.haier.uhome.control.base.handler;

import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.control.base.json.entity.DeviceBleAdvEpp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ControlBaseNotifier extends com.haier.uhome.usdk.base.c.d {
    private final List<f> mNotifiers;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ControlBaseNotifier f28981a = new ControlBaseNotifier();

        private a() {
        }
    }

    public static ControlBaseNotifier getInstance() {
        return a.f28981a;
    }

    private List<f> getNotifierList() {
        return this.mNotifiers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyBleAdvEpp$5(DeviceBleAdvEpp deviceBleAdvEpp) {
        Iterator<f> it = getNotifierList().iterator();
        while (it.hasNext()) {
            it.next().a(deviceBleAdvEpp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyBleUpdateProgress$4(RouterSsidPasswordEvent routerSsidPasswordEvent) {
        Iterator<f> it = getNotifierList().iterator();
        while (it.hasNext()) {
            it.next().a(routerSsidPasswordEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDevAlarmChange$1(String str, String str2, int i7, List list, List list2) {
        Iterator<f> it = getNotifierList().iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, i7, (List<Integer>) list, (List<com.haier.uhome.control.base.api.b>) list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDevAttrChange$2(String str, String str2, int i7, List list, List list2) {
        Iterator<f> it = getNotifierList().iterator();
        while (it.hasNext()) {
            it.next().b(str, str2, i7, list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDevEventChange$0(String str, String str2, List list) {
        Iterator<f> it = getNotifierList().iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDevStateChange$3(String str, String str2, int i7, DeviceStatus deviceStatus, int i8) {
        Iterator<f> it = getNotifierList().iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, i7, deviceStatus, i8);
        }
    }

    public void addNotifier(f fVar) {
        if (fVar == null) {
            return;
        }
        this.mNotifiers.add(fVar);
    }

    public void notifyBleAdvEpp(final DeviceBleAdvEpp deviceBleAdvEpp) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.base.handler.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f29010a.lambda$notifyBleAdvEpp$5(deviceBleAdvEpp);
            }
        });
    }

    public void notifyBleUpdateProgress(final RouterSsidPasswordEvent routerSsidPasswordEvent) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.base.handler.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f29008a.lambda$notifyBleUpdateProgress$4(routerSsidPasswordEvent);
            }
        });
    }

    public void notifyDevAlarmChange(final String str, final String str2, final int i7, final List<Integer> list, final List<com.haier.uhome.control.base.api.b> list2) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.base.handler.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f28986a.lambda$notifyDevAlarmChange$1(str, str2, i7, list, list2);
            }
        });
    }

    public void notifyDevAttrChange(final String str, final String str2, final int i7, final List<Integer> list, final List<com.haier.uhome.control.base.api.d> list2) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.base.handler.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f29002a.lambda$notifyDevAttrChange$2(str, str2, i7, list, list2);
            }
        });
    }

    public void notifyDevEventChange(final String str, final String str2, final List<com.haier.uhome.control.base.api.e> list) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.base.handler.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f28998a.lambda$notifyDevEventChange$0(str, str2, list);
            }
        });
    }

    public void notifyDevStateChange(final String str, final String str2, final int i7, final DeviceStatus deviceStatus, final int i8) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.base.handler.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f28992a.lambda$notifyDevStateChange$3(str, str2, i7, deviceStatus, i8);
            }
        });
    }

    public void rmNotifier(f fVar) {
        if (fVar == null) {
            return;
        }
        this.mNotifiers.remove(fVar);
    }

    private ControlBaseNotifier() {
        this.mNotifiers = new CopyOnWriteArrayList();
    }
}
