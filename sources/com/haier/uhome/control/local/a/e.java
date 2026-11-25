package com.haier.uhome.control.local.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.haier.uhome.usdk.base.c.d implements com.haier.uhome.control.local.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.haier.uhome.control.local.api.e> f29274a = new CopyOnWriteArrayList();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static e f29275a = new e();

        private a() {
        }
    }

    public static e a() {
        return a.f29275a;
    }

    @Override // com.haier.uhome.control.local.api.b
    public void a(final String str, final int i7, final int i8, final byte[] bArr) {
        final com.haier.uhome.control.local.api.b bVarA = a(str);
        if (bVarA == null) {
            return;
        }
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.local.a.h
            @Override // java.lang.Runnable
            public final void run() {
                bVarA.a(str, i7, i8, bArr);
            }
        });
    }

    public void b(com.haier.uhome.control.local.api.e eVar) {
        this.f29274a.remove(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, float f8, int i8, String str2) {
        Iterator<com.haier.uhome.control.local.api.e> it = this.f29274a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7, f8, i8, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, int i8, int i9) {
        Iterator<com.haier.uhome.control.local.api.e> it = this.f29274a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i7, i8, i9);
        }
    }

    @Override // com.haier.uhome.control.local.api.b
    public void a(final String str, final byte[] bArr) {
        final com.haier.uhome.control.local.api.b bVarA = a(str);
        if (bVarA == null) {
            return;
        }
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.control.local.a.i
            @Override // java.lang.Runnable
            public final void run() {
                bVarA.a(str, bArr);
            }
        });
    }

    private com.haier.uhome.control.local.api.b a(String str) {
        com.haier.uhome.control.local.api.g gVar = (com.haier.uhome.control.local.api.g) com.haier.uhome.control.local.e.b.l().b(str);
        if (gVar == null) {
            e3.a.v("getBleDeviceListener with null LocalBLEDevice", new Object[0]);
            return null;
        }
        com.haier.uhome.control.local.api.b bVarO = gVar.O();
        if (bVarO != null) {
            return bVarO;
        }
        e3.a.v("getBleDeviceListener with LocalBLEDevice no BleDeviceListener", new Object[0]);
        return null;
    }

    public void a(com.haier.uhome.control.local.api.e eVar) {
        synchronized (this.f29274a) {
            if (!this.f29274a.contains(eVar)) {
                this.f29274a.add(eVar);
            }
        }
    }

    void a(String str, float f8) {
        a(str, -1, f8, -1, "");
    }

    void a(final String str, final int i7, final float f8, final int i8, final String str2) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.local.a.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f29289a.b(str, i7, f8, i8, str2);
            }
        });
    }

    void a(final String str, final int i7, final int i8, final int i9) {
        dispatchToThread(new Runnable() { // from class: com.haier.uhome.control.local.a.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f29276a.b(str, i7, i8, i9);
            }
        });
    }
}
