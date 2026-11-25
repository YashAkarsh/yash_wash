package com.haier.uhome.ble.hal;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class BleServiceImpl extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28151a = BleServiceImpl.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IBinder f28152b = new a();

    /* JADX INFO: renamed from: com.haier.uhome.ble.hal.BleServiceImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f28153a;

        static {
            int[] iArr = new int[com.haier.uhome.ble.hal.a.a.a.f.a.values().length];
            f28153a = iArr;
            try {
                iArr[com.haier.uhome.ble.hal.a.a.a.f.a.SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.SEARCH_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.CONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.DISCONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.WRITE_CHARACTERISTIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.READ_CHARACTERISTIC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.WRITE_CHARACTERISTIC_NO_RSP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.WRITE_DESCRIPTOR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.READ_DESCRIPTOR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.ENABLE_NOTIFICATION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f28153a[com.haier.uhome.ble.hal.a.a.a.f.a.DISABLE_NOTIFICATION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public class a extends Binder {
        public a() {
        }

        public BleServiceImpl a() {
            return BleServiceImpl.this;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static BleServiceImpl f28155a = new BleServiceImpl();

        private b() {
        }
    }

    public BleServiceImpl() {
        com.haier.uhome.usdk.base.d.c.a().a(this);
    }

    public static BleServiceImpl a() {
        return b.f28155a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f28152b;
    }

    public void a(com.haier.uhome.ble.hal.a.a.a.f fVar) {
        com.haier.uhome.usdk.base.d.d dVar = new com.haier.uhome.usdk.base.d.d(this.f28151a);
        dVar.f31264c = fVar;
        com.haier.uhome.usdk.base.d.c.a().c(dVar);
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.usdk.base.d.d dVar) {
        if (dVar == null || !this.f28151a.equals(dVar.f31262a)) {
            return;
        }
        e3.a.e("handleMessage:" + dVar, new Object[0]);
        com.haier.uhome.ble.hal.a.a.a.f fVar = (com.haier.uhome.ble.hal.a.a.a.f) dVar.f31264c;
        com.haier.uhome.ble.hal.a.a.a.f.a aVarA = fVar.a();
        String strB = fVar.b();
        String strC = fVar.c();
        String strD = fVar.d();
        ICallback<Bundle> iCallbackG = fVar.g();
        switch (AnonymousClass1.f28153a[aVarA.ordinal()]) {
            case 1:
                com.haier.uhome.ble.hal.a.b.c.a().a(iCallbackG);
                break;
            case 2:
                com.haier.uhome.ble.hal.a.b.c.a().b(iCallbackG);
                break;
            case 3:
                com.haier.uhome.ble.hal.a.a.c.a().a(strB, iCallbackG);
                break;
            case 4:
                com.haier.uhome.ble.hal.a.a.c.a().b(strB, iCallbackG);
                break;
            case 5:
                com.haier.uhome.ble.hal.a.a.c.a().a(strB, strC, strD, fVar.f(), iCallbackG);
                break;
            case 6:
                com.haier.uhome.ble.hal.a.a.c.a().a(strB, strC, strD, iCallbackG);
                break;
            case 7:
                com.haier.uhome.ble.hal.a.a.c.a().b(strB, strC, strD, fVar.f(), iCallbackG);
                break;
            case 8:
                com.haier.uhome.ble.hal.a.a.c.a().a(strB, strC, strD, fVar.e(), fVar.f(), iCallbackG);
                break;
            case 9:
                com.haier.uhome.ble.hal.a.a.c.a().a(strB, strC, strD, fVar.e(), iCallbackG);
                break;
            case 10:
                com.haier.uhome.ble.hal.a.a.c.a().b(strB, strC, strD, iCallbackG);
                break;
            case 11:
                com.haier.uhome.ble.hal.a.a.c.a().c(strB, strC, strD, iCallbackG);
                break;
        }
    }
}
