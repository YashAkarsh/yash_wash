package com.haier.uhome.usdk.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<com.haier.uhome.usdk.api.interfaces.c> f30467a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f30468a = new c();

        private a() {
        }
    }

    protected void a(com.haier.uhome.usdk.api.interfaces.c cVar) {
        if (cVar != null) {
            this.f30467a.add(cVar);
        }
    }

    public void b(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().b(usdkdevice, list);
        }
    }

    public void c(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().c(usdkdevice, list);
        }
    }

    private c() {
        this.f30467a = new CopyOnWriteArrayList();
    }

    public static c a() {
        return a.f30468a;
    }

    public void a(uSDKDevice usdkdevice, List<uSDKDeviceEvent> list) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().a(usdkdevice, list);
        }
    }

    public void b(String str, String str2) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().b(str, str2);
        }
    }

    public void a(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().a(usdkdevice, usdkdevicestatusconst, i7);
        }
    }

    public void b(String str) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().b(str);
        }
    }

    protected void a(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        e3.a.o("notifySubDevListChange---" + arrayList.size(), new Object[0]);
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().a(usdkdevice, arrayList);
        }
    }

    public void b() {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f30467a.clear();
    }

    public void a(ArrayList<uSDKDevice> arrayList) {
        ArrayList<uSDKDeviceTypeConst> interestedDeviceTypes = uSDKDeviceManager.getSingleInstance().getInterestedDeviceTypes();
        ArrayList<uSDKDevice> arrayListA = z.a(arrayList, interestedDeviceTypes);
        if (arrayListA != null && !arrayListA.isEmpty()) {
            Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
            while (it.hasNext()) {
                it.next().a(arrayListA);
            }
            return;
        }
        e3.a.h("try to notify device add,but no suitable devices for %s", interestedDeviceTypes);
    }

    public void a(ArrayList<uSDKDevice> arrayList, uSDKDeviceTypeConst... usdkdevicetypeconstArr) {
        ArrayList<uSDKDeviceTypeConst> interestedDeviceTypes = uSDKDeviceManager.getSingleInstance().getInterestedDeviceTypes();
        ArrayList<uSDKDevice> arrayListA = z.a(arrayList, interestedDeviceTypes);
        if (arrayListA != null && !arrayListA.isEmpty()) {
            Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
            while (it.hasNext()) {
                it.next().b(arrayListA);
            }
            return;
        }
        e3.a.h("try to notify device remove,but no suitable devices for %s", interestedDeviceTypes);
    }

    public void a(List<uSDKDevice> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
            while (it.hasNext()) {
                it.next().c(list);
            }
            return;
        }
        e3.a.h("try to notify device base info change,but device list is:%s ", list);
    }

    public void a(String str, String str2) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
    }

    public void a(String str) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    public void a(uSDKCloudConnectionState usdkcloudconnectionstate) {
        Iterator<com.haier.uhome.usdk.api.interfaces.c> it = this.f30467a.iterator();
        while (it.hasNext()) {
            it.next().a(usdkcloudconnectionstate);
        }
    }
}
