package com.realsil.sdk.core.bluetooth.profile;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import f4.e;
import f4.j;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothInputDeviceManager extends g4.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static BluetoothInputDeviceManager f33165m;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BluetoothDevice f33166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f33167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RCUReconnectReceiver f33168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f33169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BluetoothProfile.ServiceListener f33170l;

    public class RCUReconnectReceiver extends BroadcastReceiver {
        public RCUReconnectReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            k4.b.k("RCUReconnectReceiver " + action);
            if ("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                if (intExtra == 0) {
                    k4.b.k(" Braodcast: RCU Disconnected!");
                    if (BluetoothInputDeviceManager.this.f33169k != null) {
                        BluetoothInputDeviceManager.this.f33169k.a(false);
                    }
                    BluetoothInputDeviceManager.this.f33169k = null;
                    BluetoothInputDeviceManager.this.f33166h = null;
                    return;
                }
                if (intExtra == 1) {
                    k4.b.k(" Braodcast: RCU Connecting!");
                    return;
                }
                if (intExtra != 2) {
                    if (intExtra != 3) {
                        return;
                    }
                    k4.b.k(" Braodcast: RCU Disconnecting!");
                    return;
                } else {
                    k4.b.k(" Braodcast: RCU Connected!");
                    if (BluetoothInputDeviceManager.this.f33169k != null) {
                        BluetoothInputDeviceManager.this.f33169k.a(true);
                    }
                    BluetoothInputDeviceManager.this.f33169k = null;
                    BluetoothInputDeviceManager.this.f33166h = null;
                    return;
                }
            }
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED" == action) {
                switch (intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE)) {
                    case 10:
                        k4.b.k(" Braodcast: RCU unpaired!");
                        if (!BluetoothInputDeviceManager.this.f33167i) {
                            if (BluetoothInputDeviceManager.this.f33169k != null) {
                                BluetoothInputDeviceManager.this.f33169k.a(false);
                            }
                            BluetoothInputDeviceManager.this.f33169k = null;
                            BluetoothInputDeviceManager.this.f33166h = null;
                        } else {
                            BluetoothInputDeviceManager.this.f33167i = false;
                            BluetoothInputDeviceManager.this.f33166h.createBond();
                        }
                        break;
                    case 11:
                        k4.b.k(" Braodcast: RCU BONDING!");
                        break;
                    case 12:
                        k4.b.k(" Braodcast: RCU BONDED!");
                        if (BluetoothInputDeviceManager.this.f33166h != null) {
                            BluetoothInputDeviceManager bluetoothInputDeviceManager = BluetoothInputDeviceManager.this;
                            bluetoothInputDeviceManager.k(bluetoothInputDeviceManager.f33166h);
                        }
                        break;
                }
            }
        }

        public /* synthetic */ RCUReconnectReceiver(BluetoothInputDeviceManager bluetoothInputDeviceManager, a aVar) {
            this();
        }
    }

    public class a implements BluetoothProfile.ServiceListener {
        public a() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i7, BluetoothProfile bluetoothProfile) {
            if (4 == i7) {
                try {
                    BluetoothInputDeviceManager.this.f34028f = bluetoothProfile.getClass().asSubclass(Class.forName(j.f33964a));
                } catch (ClassNotFoundException e8) {
                    e8.printStackTrace();
                }
                BluetoothInputDeviceManager.this.f34029g = bluetoothProfile;
                k4.b.k("get Bluetooth input device proxy");
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i7) {
            if (4 == i7) {
                BluetoothInputDeviceManager bluetoothInputDeviceManager = BluetoothInputDeviceManager.this;
                bluetoothInputDeviceManager.f34028f = null;
                bluetoothInputDeviceManager.f34029g = null;
                k4.b.k("close Bluetooth input device proxy");
            }
        }
    }

    public static abstract class b {
        public void a(boolean z7) {
        }
    }

    public BluetoothInputDeviceManager(Context context) {
        super(context);
        a aVar = new a();
        this.f33170l = aVar;
        BluetoothAdapter bluetoothAdapter = this.f34024b;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.getProfileProxy(context, aVar, 4);
        }
        this.f33168j = new RCUReconnectReceiver(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        this.f34025c.registerReceiver(this.f33168j, intentFilter);
    }

    public static BluetoothInputDeviceManager u() {
        return f33165m;
    }

    public static void v(Context context) {
        k4.b.p("initial");
        f33165m = new BluetoothInputDeviceManager(context);
    }

    public static boolean w(BluetoothDevice bluetoothDevice) {
        return e.b(bluetoothDevice.getBluetoothClass());
    }

    public final boolean k(BluetoothDevice bluetoothDevice) {
        try {
            Method method = this.f34028f.getMethod("connect", BluetoothDevice.class);
            if (method != null) {
                boolean zBooleanValue = ((Boolean) method.invoke(this.f34029g, bluetoothDevice)).booleanValue();
                k4.b.e("connect(): connect result: " + zBooleanValue);
                return zBooleanValue;
            }
        } catch (Exception e8) {
            k4.b.h("connect(): An exception occured while connect device, e = " + e8);
        }
        return false;
    }

    public final boolean l(BluetoothDevice bluetoothDevice, b bVar) {
        k4.b.e("connect()");
        this.f33169k = bVar;
        this.f33166h = bluetoothDevice;
        this.f33167i = false;
        if (!q()) {
            return false;
        }
        if (bluetoothDevice.getBondState() != 12) {
            k4.b.k("connect with not bond device, bond first, current state: " + bluetoothDevice.getBondState());
            bluetoothDevice.createBond();
            return false;
        }
        try {
            k4.b.e("connect with bonded device, remove bond first.");
            Method method = bluetoothDevice.getClass().getMethod("removeBond", new Class[0]);
            if (method != null) {
                boolean zBooleanValue = ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
                if (!zBooleanValue) {
                    return k(bluetoothDevice);
                }
                this.f33167i = zBooleanValue;
                k4.b.e("removeBond(): result: " + zBooleanValue);
                return zBooleanValue;
            }
        } catch (Exception e8) {
            k4.b.h("removeBond(): An exception occured, e = " + e8);
        }
        return k(bluetoothDevice);
    }

    public boolean q() {
        if (this.f34028f != null) {
            return true;
        }
        k4.b.e("checkProfileConnect(): profile not connect");
        return false;
    }

    public void r() {
        if (this.f34028f != null) {
            this.f34024b.closeProfileProxy(4, this.f34029g);
        }
        if (this.f34025c != null && this.f33168j != null) {
            try {
                k4.b.e("unregisterReceiver");
                this.f34025c.unregisterReceiver(this.f33168j);
            } catch (Exception e8) {
                k4.b.h(e8.toString());
            }
        }
        this.f33169k = null;
    }

    public boolean s(String str, b bVar) {
        return l(this.f34024b.getRemoteDevice(str), bVar);
    }

    public int t(String str) {
        return c(this.f34024b.getRemoteDevice(str));
    }

    public boolean x(String str) {
        return w(this.f34024b.getRemoteDevice(str));
    }

    public boolean y(BluetoothDevice bluetoothDevice) {
        return c(bluetoothDevice) == 2;
    }

    public boolean z(String str) {
        return t(str) == 2;
    }
}
