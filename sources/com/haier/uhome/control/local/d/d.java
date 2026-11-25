package com.haier.uhome.control.local.d;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.handler.ControlBaseNotifier;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, a> f29388a;

    /* JADX INFO: renamed from: com.haier.uhome.control.local.d.d$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f29390a;

        static {
            int[] iArr = new int[DeviceStatus.values().length];
            f29390a = iArr;
            try {
                iArr[DeviceStatus.STATUS_OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29390a[DeviceStatus.STATUS_UNCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29390a[DeviceStatus.STATUS_CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.haier.uhome.control.local.api.h f29392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<c> f29393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<Integer, DeviceStatus> f29394d;

        private a(com.haier.uhome.control.local.api.h hVar) {
            this.f29392b = hVar;
            this.f29393c = new CopyOnWriteArrayList();
            this.f29394d = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(c cVar) {
            this.f29393c.remove(cVar);
            d.this.f29397c.b(cVar, this.f29392b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i7, DeviceStatus deviceStatus) {
            this.f29394d.put(Integer.valueOf(i7), deviceStatus);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(DeviceStatus deviceStatus) {
            int i7 = AnonymousClass2.f29390a[deviceStatus.ordinal()];
            if (i7 == 1 || i7 == 2) {
                a();
            } else {
                if (i7 != 3) {
                    return;
                }
                this.f29392b.a((ICallback<Void>) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            this.f29393c.add(cVar);
            d.this.f29397c.a(cVar, this.f29392b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Iterator<c> it = this.f29393c.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f29395a = new d();

        private b() {
        }
    }

    void b() {
        ControlBaseNotifier.getInstance().addNotifier(new com.haier.uhome.control.local.d.b() { // from class: com.haier.uhome.control.local.d.d.1
            @Override // com.haier.uhome.control.local.d.b, com.haier.uhome.control.base.handler.f
            public void a(String str, String str2, int i7, DeviceStatus deviceStatus, int i8) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                str.hashCode();
                if (str.equals("local")) {
                    d.this.a(str2, deviceStatus, i8);
                } else if (str.equals(com.haier.uhome.usdk.base.a.at)) {
                    d.this.a(str2, i7, deviceStatus, i8);
                }
            }
        });
    }

    private d() {
        this.f29388a = new HashMap();
        this.f29396b = new ConcurrentHashMap();
        b();
    }

    public static d a() {
        return b.f29395a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DeviceStatus deviceStatus, int i7) {
        a aVar = this.f29388a.get(str);
        if (aVar == null) {
            return;
        }
        e3.a.e("handleLocalDeviceStateChange devId<%s> status<%s>", str, deviceStatus);
        aVar.a(deviceStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i7, DeviceStatus deviceStatus, int i8) {
        a aVar = this.f29388a.get(str);
        if (aVar == null) {
            e3.a.o("notifyDevStateChange %d gateway to %d, but gateway device not find", str, Integer.valueOf(i7));
            return;
        }
        e3.a.e("<%s> gateway to <%d> status <%s>", str, Integer.valueOf(i7), deviceStatus);
        c cVar = new c();
        cVar.a(i7);
        cVar.a(str);
        aVar.a(i7, deviceStatus);
        if (deviceStatus != DeviceStatus.STATUS_OFFLINE) {
            aVar.a(cVar);
        } else {
            aVar.b(cVar);
        }
    }

    public DeviceStatus a(String str, int i7) {
        a aVar = this.f29388a.get(str);
        if (aVar != null) {
            DeviceStatus deviceStatus = (DeviceStatus) aVar.f29394d.get(Integer.valueOf(i7));
            return deviceStatus == null ? DeviceStatus.STATUS_OFFLINE : deviceStatus;
        }
        return DeviceStatus.STATUS_OFFLINE;
    }

    public void a(String str) {
        if (str == null) {
            e3.a.v("rmGatewayDevice with null deviceId", new Object[0]);
            return;
        }
        a aVarRemove = this.f29388a.remove(str);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
    }

    public void a(com.haier.uhome.control.local.api.h hVar) {
        if (hVar == null) {
            e3.a.v("addGatewayDevice with null", new Object[0]);
        } else if (this.f29388a.get(hVar.X()) == null) {
            this.f29388a.put(hVar.X(), new a(hVar));
        }
    }
}
