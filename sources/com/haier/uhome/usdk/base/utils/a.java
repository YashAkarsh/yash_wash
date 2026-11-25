package com.haier.uhome.usdk.base.utils;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(18)
public class a {
    public static BluetoothAdapter a() {
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            e3.a.h("getBluetoothAdapter ret null, context is null", new Object[0]);
            return null;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) contextB.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            return null;
        }
        return bluetoothManager.getAdapter();
    }

    public static boolean b() {
        try {
            Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
            return contextB != null && contextB.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        } catch (Exception e8) {
            e3.a.h("isBluetoothLeSupported catch excp: %s", e8.getMessage());
            return false;
        }
    }

    public static boolean c() {
        BluetoothAdapter bluetoothAdapterA;
        if (!b() || (bluetoothAdapterA = a()) == null) {
            return false;
        }
        try {
            return bluetoothAdapterA.isEnabled();
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public static boolean d() {
        return true;
    }
}
