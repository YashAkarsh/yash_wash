package com.realsil.sdk.core.bluetooth.profile;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import f4.k;
import g4.c;
import java.util.Iterator;
import java.util.List;
import k4.b;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothA2dpManager extends c<BluetoothA2dp> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static BluetoothA2dpManager f33160h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BtBroadcastReceiver f33161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BluetoothProfile.ServiceListener f33162g;

    public class BtBroadcastReceiver extends BroadcastReceiver {
        public BtBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            action.hashCode();
            if (!action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                if (action.equals("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (intExtra == 10) {
                        b.e("A2DP_PLAYING_STATE: STATE_PLAYING");
                        return;
                    }
                    if (intExtra == 11) {
                        b.e("A2DP_PLAYING_STATE: STATE_NOT_PLAYING");
                        return;
                    }
                    b.e("A2DP_PLAYING_STATE: " + intExtra2 + " > " + intExtra);
                    return;
                }
                return;
            }
            int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
            if (intExtra3 == 2) {
                b.e("A2DP_CONNECTION_STATE: STATE_CONNECTED");
            } else if (intExtra3 == 0) {
                b.e("A2DP_CONNECTION_STATE: STATE_DISCONNECTED");
            } else if (intExtra3 == 1) {
                b.e("A2DP_CONNECTION_STATE: STATE_CONNECTING");
            } else {
                b.e("A2DP_CONNECTION_STATE: " + intExtra4 + " > " + intExtra3);
            }
            List<g4.b> list = BluetoothA2dpManager.this.f34033d;
            if (list != null) {
                Iterator<g4.b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(bluetoothDevice, intExtra3);
                }
            }
        }
    }

    public class a implements BluetoothProfile.ServiceListener {
        public a() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i7, BluetoothProfile bluetoothProfile) {
            b.k(d4.a.p(i7) + " profile");
            if (i7 == 2) {
                BluetoothA2dpManager.this.g((BluetoothA2dp) bluetoothProfile);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i7) {
            b.k(d4.a.p(i7) + " profile");
            if (i7 == 2) {
                BluetoothA2dpManager.this.g(null);
            }
        }
    }

    public BluetoothA2dpManager(Context context) {
        super(context);
        this.f33161f = null;
        a aVar = new a();
        this.f33162g = aVar;
        BluetoothAdapter bluetoothAdapter = this.f34031b;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.getProfileProxy(this.f34032c, aVar, 2);
        }
        this.f33161f = new BtBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        this.f34032c.registerReceiver(this.f33161f, intentFilter);
    }

    public static BluetoothA2dpManager m() {
        return f33160h;
    }

    public static void n(Context context) {
        if (f33160h == null) {
            synchronized (BluetoothA2dpManager.class) {
                if (f33160h == null) {
                    f33160h = new BluetoothA2dpManager(context);
                }
            }
        }
    }

    public boolean h(String str) {
        BluetoothAdapter bluetoothAdapter = this.f34031b;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            b.s("BT not enabled");
            return false;
        }
        BluetoothDevice remoteDevice = this.f34031b.getRemoteDevice(str);
        BP bp = this.f34034e;
        if (bp == 0) {
            b.s("A2DP not initialized");
            return false;
        }
        if (((BluetoothA2dp) bp).getConnectionState(remoteDevice) == 2) {
            b.s("a2dp already connected");
            return true;
        }
        b.e("a2dpSrcConnect: " + str);
        k.g(this.f34034e, remoteDevice, 100);
        return k.a(this.f34034e, remoteDevice);
    }

    public boolean i(byte[] bArr) {
        return h(d4.a.b(bArr));
    }

    public boolean j(String str) {
        BluetoothAdapter bluetoothAdapter = this.f34031b;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            b.s("BT not enabled");
            return false;
        }
        BluetoothDevice remoteDevice = this.f34031b.getRemoteDevice(str);
        if (remoteDevice == null) {
            b.s("device is null");
            return false;
        }
        BP bp = this.f34034e;
        if (bp == 0) {
            b.s("A2DP not initialized");
            return false;
        }
        if (((BluetoothA2dp) bp).getConnectionState(remoteDevice) != 2) {
            b.s("A2DP already disconnected");
            return false;
        }
        b.e("a2dpSrcDisconnect" + str);
        k.g(this.f34034e, remoteDevice, 100);
        return k.c(this.f34034e, remoteDevice);
    }

    public boolean k(byte[] bArr) {
        return j(d4.a.b(bArr));
    }

    public void l() {
        b.e("close()");
        Context context = this.f34032c;
        if (context != null) {
            try {
                context.unregisterReceiver(this.f33161f);
            } catch (Exception e8) {
                b.h(e8.toString());
            }
        }
    }
}
