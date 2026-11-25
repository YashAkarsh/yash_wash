package com.haier.uhome.ble.hal.a.a;

import android.os.Bundle;
import com.haier.library.common.util.u;
import com.haier.uhome.ble.hal.a.a.a.h;
import com.haier.uhome.ble.hal.a.a.a.i;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f28158e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28159f = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f28160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28161b = a.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.haier.uhome.ble.hal.a.a.a.a> f28162c = new LinkedList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.ble.hal.a.a.a.a f28163d;

    private a(String str) {
        this.f28160a = new d(str);
        com.haier.uhome.usdk.base.d.c.a().a(this);
    }

    public static a a(String str) {
        return new a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ICallback iCallback) {
        if (iCallback != null) {
            iCallback.onSuccess(null);
        }
    }

    public void b(final ICallback<Bundle> iCallback) {
        com.haier.uhome.ble.hal.a.a.a.a aVar = this.f28163d;
        if (aVar != null) {
            aVar.c();
            this.f28163d = null;
        }
        Iterator<com.haier.uhome.ble.hal.a.a.a.a> it = this.f28162c.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f28162c.clear();
        this.f28160a.a(false);
        com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.a.g
            @Override // java.lang.Runnable
            public final void run() {
                a.c(iCallback);
            }
        });
    }

    public void a(ICallback<Bundle> iCallback) {
        b(new com.haier.uhome.ble.hal.a.a.a.b(iCallback));
    }

    public void c(String str, String str2, ICallback<Bundle> iCallback) {
        b(new com.haier.uhome.ble.hal.a.a.a.c(str, str2, false, iCallback));
    }

    public void a(String str, String str2, ICallback<Bundle> iCallback) {
        b(new com.haier.uhome.ble.hal.a.a.a.d(str, str2, iCallback));
    }

    public void a(String str, String str2, byte[] bArr, ICallback<Bundle> iCallback) {
        b(new h(str, str2, bArr, iCallback));
    }

    public void a(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        b(new com.haier.uhome.ble.hal.a.a.a.e(str, str2, str3, iCallback));
    }

    public void a(String str, String str2, String str3, byte[] bArr, ICallback<Bundle> iCallback) {
        b(new i(str, str2, str3, bArr, iCallback));
    }

    public void a(com.haier.uhome.ble.hal.a.a.a.a aVar) {
        com.haier.uhome.ble.hal.a.a.a.a aVar2 = this.f28163d;
        if (aVar2 != null && aVar != aVar2) {
            e3.a.v("request not match, current = %s, completed = %s", aVar2, aVar);
        }
        this.f28163d = null;
        a(10);
    }

    public void b(String str, String str2, byte[] bArr, ICallback<Bundle> iCallback) {
        b(new com.haier.uhome.ble.hal.a.a.a.g(str, str2, bArr, iCallback));
    }

    public void b(String str, String str2, ICallback<Bundle> iCallback) {
        b(new com.haier.uhome.ble.hal.a.a.a.c(str, str2, true, iCallback));
    }

    private void a(int i7) {
        com.haier.uhome.usdk.base.d.c.a().a(new com.haier.uhome.usdk.base.d.d(this.f28161b, 32), i7);
    }

    private void b(com.haier.uhome.ble.hal.a.a.a.a aVar) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "addNewRequest = %s .", aVar);
        if (this.f28162c.size() < 16) {
            aVar.a(this.f28160a);
            this.f28162c.add(aVar);
        } else {
            aVar.b(ErrorConst.ERR_INTERNAL);
        }
        a(10);
    }

    private void a() {
        if (this.f28163d == null && !u.h(this.f28162c)) {
            com.haier.uhome.ble.hal.a.a.a.a aVarRemove = this.f28162c.remove(0);
            this.f28163d = aVarRemove;
            aVarRemove.a(this);
        }
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.usdk.base.d.d dVar) {
        if (dVar != null && this.f28161b.equals(dVar.f31262a) && dVar.f31263b == 32) {
            a();
        }
    }
}
