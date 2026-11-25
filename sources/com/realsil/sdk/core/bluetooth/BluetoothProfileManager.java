package com.realsil.sdk.core.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothHealth;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import b4.d;
import d4.b;
import f4.h;
import f4.i;
import f4.j;
import f4.k;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothProfileManager {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static BluetoothProfileManager f33118n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f33119o = 255;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f33120p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f33121q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f33122r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f33123s = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f33124t = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f33125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f33126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<b> f33127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothManager f33128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothAdapter f33129e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BluetoothHealth f33132h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BluetoothHeadset f33130f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BluetoothA2dp f33131g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BluetoothProfile f33133i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BluetoothProfile f33134j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BluetoothProfile f33135k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ProfileBroadcastReceiver f33136l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BluetoothProfile.ServiceListener f33137m = new a();

    public class ProfileBroadcastReceiver extends BroadcastReceiver {
        public ProfileBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @TargetApi(19)
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED":
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice != null) {
                        if (BluetoothProfileManager.this.f33125a) {
                            k4.b.e(String.format(Locale.US, "action=%s, device:%s(%s), state: %d->%d", action, bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(intExtra2), Integer.valueOf(intExtra)));
                        } else {
                            k4.b.p(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, bluetoothDevice.getName(), Integer.valueOf(intExtra2), Integer.valueOf(intExtra)));
                        }
                        if (BluetoothProfileManager.this.f33127c != null && BluetoothProfileManager.this.f33127c.size() > 0) {
                            Iterator it = BluetoothProfileManager.this.f33127c.iterator();
                            while (it.hasNext()) {
                                ((b) it.next()).c(bluetoothDevice, intExtra);
                            }
                        } else {
                            k4.b.p("no callback registed");
                        }
                        break;
                    }
                    break;
                case "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED":
                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice2 != null) {
                        if (BluetoothProfileManager.this.f33125a) {
                            k4.b.e(String.format(Locale.US, "action=%s, device:%s(%s), state: %d->%d", action, bluetoothDevice2.getName(), bluetoothDevice2.getAddress(), Integer.valueOf(intExtra4), Integer.valueOf(intExtra3)));
                        } else {
                            k4.b.p(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, bluetoothDevice2.getName(), Integer.valueOf(intExtra4), Integer.valueOf(intExtra3)));
                        }
                        if (BluetoothProfileManager.this.f33127c != null && BluetoothProfileManager.this.f33127c.size() > 0) {
                            Iterator it2 = BluetoothProfileManager.this.f33127c.iterator();
                            while (it2.hasNext()) {
                                ((b) it2.next()).e(bluetoothDevice2, intExtra3);
                            }
                        } else {
                            k4.b.p("no callback registed");
                        }
                        break;
                    }
                    break;
                case "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED":
                    BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra5 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra6 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice3 != null) {
                        if (BluetoothProfileManager.this.f33125a) {
                            k4.b.e(String.format(Locale.US, "action=%s, device:%s(%s), state: %d->%d", action, bluetoothDevice3.getName(), bluetoothDevice3.getAddress(), Integer.valueOf(intExtra6), Integer.valueOf(intExtra5)));
                        } else {
                            k4.b.p(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, bluetoothDevice3.getName(), Integer.valueOf(intExtra6), Integer.valueOf(intExtra5)));
                        }
                        if (BluetoothProfileManager.this.f33127c != null && BluetoothProfileManager.this.f33127c.size() > 0) {
                            Iterator it3 = BluetoothProfileManager.this.f33127c.iterator();
                            while (it3.hasNext()) {
                                ((b) it3.next()).a(bluetoothDevice3, intExtra5);
                            }
                        } else {
                            k4.b.p("no callback registed");
                        }
                        break;
                    }
                    break;
                case "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED":
                    BluetoothDevice bluetoothDevice4 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra7 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra8 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice4 != null) {
                        if (BluetoothProfileManager.this.f33125a) {
                            k4.b.e(String.format(Locale.US, "action=%s, device:%s(%s), state: %d->%d", action, bluetoothDevice4.getName(), bluetoothDevice4.getAddress(), Integer.valueOf(intExtra8), Integer.valueOf(intExtra7)));
                        } else {
                            k4.b.p(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, bluetoothDevice4.getName(), Integer.valueOf(intExtra8), Integer.valueOf(intExtra7)));
                        }
                        if (BluetoothProfileManager.this.f33127c != null && BluetoothProfileManager.this.f33127c.size() > 0) {
                            Iterator it4 = BluetoothProfileManager.this.f33127c.iterator();
                            while (it4.hasNext()) {
                                ((b) it4.next()).d(bluetoothDevice4, intExtra7);
                            }
                        } else {
                            k4.b.p("no callback registed");
                        }
                        break;
                    }
                    break;
                case "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED":
                    BluetoothDevice bluetoothDevice5 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra9 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra10 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice5 != null) {
                        if (BluetoothProfileManager.this.f33125a) {
                            k4.b.e(String.format(Locale.US, "action=%s, device:%s(%s), state: %d->%d", action, bluetoothDevice5.getName(), bluetoothDevice5.getAddress(), Integer.valueOf(intExtra10), Integer.valueOf(intExtra9)));
                        } else {
                            k4.b.p(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, bluetoothDevice5.getName(), Integer.valueOf(intExtra10), Integer.valueOf(intExtra9)));
                        }
                        if (BluetoothProfileManager.this.f33127c != null && BluetoothProfileManager.this.f33127c.size() > 0) {
                            Iterator it5 = BluetoothProfileManager.this.f33127c.iterator();
                            while (it5.hasNext()) {
                                ((b) it5.next()).b(bluetoothDevice5, intExtra9);
                            }
                        } else {
                            k4.b.p("no callback registed");
                        }
                        break;
                    }
                    break;
                case "android.bluetooth.avrcp-controller.profile.action.CONNECTION_STATE_CHANGED":
                    BluetoothDevice bluetoothDevice6 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra11 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra12 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice6 != null) {
                        if (!BluetoothProfileManager.this.f33125a) {
                            k4.b.p(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, bluetoothDevice6.getName(), Integer.valueOf(intExtra12), Integer.valueOf(intExtra11)));
                        } else {
                            k4.b.e(String.format(Locale.US, "action=%s, device:%s(%s), state: %d->%d", action, bluetoothDevice6.getName(), bluetoothDevice6.getAddress(), Integer.valueOf(intExtra12), Integer.valueOf(intExtra11)));
                        }
                        break;
                    }
                    break;
                case "android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT":
                    BluetoothProfileManager.this.f(intent);
                    break;
            }
        }
    }

    public class a implements BluetoothProfile.ServiceListener {
        public a() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i7, BluetoothProfile bluetoothProfile) {
            k4.b.e(d4.a.p(i7) + " profile connected");
            if (i7 == 11) {
                BluetoothProfileManager.this.f33134j = bluetoothProfile;
                return;
            }
            if (i7 == 12) {
                BluetoothProfileManager.this.f33135k = bluetoothProfile;
                return;
            }
            if (i7 == 1) {
                BluetoothProfileManager.this.f33130f = (BluetoothHeadset) bluetoothProfile;
                return;
            }
            if (i7 == 2) {
                BluetoothProfileManager.this.f33131g = (BluetoothA2dp) bluetoothProfile;
            } else if (i7 == 3) {
                BluetoothProfileManager.this.f33132h = (BluetoothHealth) bluetoothProfile;
            } else {
                if (i7 != 4) {
                    return;
                }
                BluetoothProfileManager.this.f33133i = bluetoothProfile;
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i7) {
            k4.b.e(d4.a.p(i7) + " profile disconnected");
            if (i7 == 1) {
                BluetoothProfileManager.this.f33130f = null;
                return;
            }
            if (i7 == 2) {
                BluetoothProfileManager.this.f33131g = null;
                return;
            }
            if (i7 == 3) {
                BluetoothProfileManager.this.f33132h = null;
                return;
            }
            if (i7 == 4) {
                BluetoothProfileManager.this.f33133i = null;
            } else if (i7 == 11) {
                BluetoothProfileManager.this.f33134j = null;
            } else if (i7 == 12) {
                BluetoothProfileManager.this.f33135k = null;
            }
        }
    }

    public BluetoothProfileManager(Context context) {
        this.f33125a = false;
        this.f33126b = context.getApplicationContext();
        this.f33125a = d.f11317b;
        h();
    }

    public static BluetoothProfileManager L() {
        return f33118n;
    }

    public static void P(Context context) {
        if (f33118n == null) {
            synchronized (BluetoothProfileManager.class) {
                if (f33118n == null) {
                    f33118n = new BluetoothProfileManager(context);
                }
            }
        }
    }

    public boolean A(int i7, BluetoothDevice bluetoothDevice) {
        if (i7 != 4) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? k.b(this.f33133i, i.f33938a, bluetoothDevice) : k.b(this.f33133i, j.f33964a, bluetoothDevice);
    }

    public boolean B(BluetoothDevice bluetoothDevice) {
        return Build.VERSION.SDK_INT >= 28 ? k.d(this.f33133i, i.f33938a, bluetoothDevice) : k.d(this.f33133i, j.f33964a, bluetoothDevice);
    }

    public boolean C(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            k4.b.s("device is null");
            return false;
        }
        BluetoothProfile bluetoothProfile = this.f33134j;
        if (bluetoothProfile == null) {
            k4.b.s("A2DP Sink not initialized");
            return false;
        }
        if (bluetoothProfile.getConnectionState(bluetoothDevice) != 2) {
            k4.b.s("A2DP Sink already disconnected");
            return false;
        }
        if (this.f33125a) {
            k4.b.e("disconnectA2dpSink" + bluetoothDevice.getAddress());
        }
        return k.d(this.f33134j, f4.b.f33904a, bluetoothDevice);
    }

    public boolean D(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            k4.b.s("device is null");
            return false;
        }
        BluetoothA2dp bluetoothA2dp = this.f33131g;
        if (bluetoothA2dp == null) {
            k4.b.s("A2DP not initialized");
            return false;
        }
        if (bluetoothA2dp.getConnectionState(bluetoothDevice) != 2) {
            k4.b.s("A2DP already disconnected");
            return false;
        }
        if (this.f33125a) {
            k4.b.e("disconnectA2dpSource" + bluetoothDevice.getAddress());
        }
        k.g(this.f33131g, bluetoothDevice, 100);
        return k.c(this.f33131g, bluetoothDevice);
    }

    public boolean E(String str) {
        return D(b(str));
    }

    public boolean F(byte[] bArr) {
        return E(d4.a.b(bArr));
    }

    public boolean G(String str) {
        BluetoothDevice remoteDevice = this.f33129e.getRemoteDevice(str);
        if (remoteDevice == null) {
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f33130f;
        if (bluetoothHeadset == null) {
            k4.b.s("BluetoothHeadset service is not connected");
            return false;
        }
        if (bluetoothHeadset.getConnectionState(remoteDevice) != 2) {
            k4.b.s("BluetoothHeadset profile is not connected");
            return false;
        }
        if (this.f33125a) {
            k4.b.p("hfpDisconnect: " + str);
        }
        return k.c(this.f33130f, remoteDevice);
    }

    public boolean H(byte[] bArr) {
        return G(d4.a.b(bArr));
    }

    public boolean I(int i7, BluetoothDevice bluetoothDevice) {
        if (i7 != 4) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? k.d(this.f33133i, i.f33938a, bluetoothDevice) : k.d(this.f33133i, j.f33964a, bluetoothDevice);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x003e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0044  */
    /* JADX WARN: Code duplicated, block: B:34:0x004b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0052  */
    /* JADX WARN: Code duplicated, block: B:39:0x005b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0062  */
    /* JADX WARN: Code duplicated, block: B:44:0x006b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0070  */
    public List<BluetoothDevice> J(int i7) {
        BluetoothProfile bluetoothProfile;
        BluetoothProfile bluetoothProfile2;
        BluetoothProfile bluetoothProfile3;
        BluetoothAdapter bluetoothAdapter = this.f33129e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT not enabled");
            return null;
        }
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 4) {
                    if (i7 != 11) {
                        if (i7 == 12) {
                        }
                        return null;
                    }
                    bluetoothProfile3 = this.f33135k;
                    if (bluetoothProfile3 != null) {
                        return bluetoothProfile3.getConnectedDevices();
                    }
                    k4.b.e("AVRCP profile not connected");
                    return null;
                }
                bluetoothProfile2 = this.f33134j;
                if (bluetoothProfile2 != null) {
                    return k.e(bluetoothProfile2, f4.b.f33904a);
                }
                k4.b.e("A2DP_SINK profile not connected");
                bluetoothProfile3 = this.f33135k;
                if (bluetoothProfile3 != null) {
                    return bluetoothProfile3.getConnectedDevices();
                }
                k4.b.e("AVRCP profile not connected");
                return null;
            }
            bluetoothProfile = this.f33133i;
            if (bluetoothProfile != null) {
                return Build.VERSION.SDK_INT >= 28 ? k.e(bluetoothProfile, i.f33938a) : k.e(bluetoothProfile, j.f33964a);
            }
            k4.b.e("HID_HOST profile not connected");
            bluetoothProfile2 = this.f33134j;
            if (bluetoothProfile2 != null) {
                return k.e(bluetoothProfile2, f4.b.f33904a);
            }
            k4.b.e("A2DP_SINK profile not connected");
            bluetoothProfile3 = this.f33135k;
            if (bluetoothProfile3 != null) {
                return bluetoothProfile3.getConnectedDevices();
            }
            k4.b.e("AVRCP profile not connected");
            return null;
        }
        BluetoothHeadset bluetoothHeadset = this.f33130f;
        if (bluetoothHeadset != null) {
            return bluetoothHeadset.getConnectedDevices();
        }
        k4.b.e("HEADSET profile not connected");
        BluetoothA2dp bluetoothA2dp = this.f33131g;
        if (bluetoothA2dp != null) {
            return bluetoothA2dp.getConnectedDevices();
        }
        k4.b.e("A2DP profile not connected");
        bluetoothProfile = this.f33133i;
        if (bluetoothProfile != null) {
            if (Build.VERSION.SDK_INT >= 28) {
            }
        }
        k4.b.e("HID_HOST profile not connected");
        bluetoothProfile2 = this.f33134j;
        if (bluetoothProfile2 != null) {
            return k.e(bluetoothProfile2, f4.b.f33904a);
        }
        k4.b.e("A2DP_SINK profile not connected");
        bluetoothProfile3 = this.f33135k;
        if (bluetoothProfile3 != null) {
            return bluetoothProfile3.getConnectedDevices();
        }
        k4.b.e("AVRCP profile not connected");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x003d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0043  */
    /* JADX WARN: Code duplicated, block: B:34:0x004a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0051  */
    /* JADX WARN: Code duplicated, block: B:39:0x005a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0061  */
    /* JADX WARN: Code duplicated, block: B:44:0x006a  */
    /* JADX WARN: Code duplicated, block: B:46:0x006f  */
    public int K(int i7, BluetoothDevice bluetoothDevice) {
        BluetoothProfile bluetoothProfile;
        BluetoothProfile bluetoothProfile2;
        BluetoothProfile bluetoothProfile3;
        BluetoothAdapter bluetoothAdapter = this.f33129e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.e("BT not enabled");
            return -1;
        }
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 4) {
                    if (i7 != 11) {
                        if (i7 != 12) {
                            return 0;
                        }
                    }
                    bluetoothProfile3 = this.f33135k;
                    if (bluetoothProfile3 != null) {
                        return bluetoothProfile3.getConnectionState(bluetoothDevice);
                    }
                    k4.b.e("AVRCP profile not connected");
                    return 0;
                }
                bluetoothProfile2 = this.f33134j;
                if (bluetoothProfile2 != null) {
                    return k.f(bluetoothProfile2, f4.b.f33904a, bluetoothDevice);
                }
                k4.b.e("A2DP_SINK profile not connected");
                bluetoothProfile3 = this.f33135k;
                if (bluetoothProfile3 != null) {
                    return bluetoothProfile3.getConnectionState(bluetoothDevice);
                }
                k4.b.e("AVRCP profile not connected");
                return 0;
            }
            bluetoothProfile = this.f33133i;
            if (bluetoothProfile != null) {
                return Build.VERSION.SDK_INT >= 28 ? k.f(bluetoothProfile, i.f33938a, bluetoothDevice) : k.f(bluetoothProfile, j.f33964a, bluetoothDevice);
            }
            k4.b.e("HID_HOST profile not connected");
            bluetoothProfile2 = this.f33134j;
            if (bluetoothProfile2 != null) {
                return k.f(bluetoothProfile2, f4.b.f33904a, bluetoothDevice);
            }
            k4.b.e("A2DP_SINK profile not connected");
            bluetoothProfile3 = this.f33135k;
            if (bluetoothProfile3 != null) {
                return bluetoothProfile3.getConnectionState(bluetoothDevice);
            }
            k4.b.e("AVRCP profile not connected");
            return 0;
        }
        BluetoothHeadset bluetoothHeadset = this.f33130f;
        if (bluetoothHeadset != null) {
            return bluetoothHeadset.getConnectionState(bluetoothDevice);
        }
        k4.b.e("HEADSET profile not connected");
        BluetoothA2dp bluetoothA2dp = this.f33131g;
        if (bluetoothA2dp != null) {
            return bluetoothA2dp.getConnectionState(bluetoothDevice);
        }
        k4.b.e("A2DP profile not connected");
        bluetoothProfile = this.f33133i;
        if (bluetoothProfile != null) {
            if (Build.VERSION.SDK_INT >= 28) {
            }
        }
        k4.b.e("HID_HOST profile not connected");
        bluetoothProfile2 = this.f33134j;
        if (bluetoothProfile2 != null) {
            return k.f(bluetoothProfile2, f4.b.f33904a, bluetoothDevice);
        }
        k4.b.e("A2DP_SINK profile not connected");
        bluetoothProfile3 = this.f33135k;
        if (bluetoothProfile3 != null) {
            return bluetoothProfile3.getConnectionState(bluetoothDevice);
        }
        k4.b.e("AVRCP profile not connected");
        return 0;
    }

    public BluetoothProfile M(int i7) {
        if (i7 == 1) {
            return this.f33130f;
        }
        if (i7 == 2) {
            return this.f33131g;
        }
        if (i7 == 4) {
            return this.f33133i;
        }
        if (i7 == 11) {
            return this.f33134j;
        }
        if (i7 != 12) {
            return null;
        }
        return this.f33135k;
    }

    public boolean N(int i7) {
        try {
            if (!this.f33129e.getProfileProxy(this.f33126b, this.f33137m, i7)) {
                k4.b.s(String.format(Locale.US, "getProfileProxy %d failed", Integer.valueOf(i7)));
                return false;
            }
            if (this.f33125a) {
                k4.b.p(String.format(Locale.US, "getProfileProxy %d success", Integer.valueOf(i7)));
            }
            return true;
        } catch (Exception e8) {
            k4.b.h(String.format(Locale.US, "getProfileProxy %d exception: %s", Integer.valueOf(i7), e8.toString()));
            return false;
        }
    }

    public int O(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        BluetoothAdapter bluetoothAdapter = this.f33129e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT not enabled");
            return -1;
        }
        if (bluetoothProfile != null) {
            return bluetoothProfile.getConnectionState(bluetoothDevice);
        }
        k4.b.e("profile is not supported");
        return -1;
    }

    public boolean Q(int i7) {
        if (i7 == 1) {
            return this.f33130f != null;
        }
        if (i7 == 2) {
            return this.f33131g != null;
        }
        if (i7 == 4) {
            return this.f33133i != null;
        }
        if (i7 != 11) {
            return i7 == 12 && this.f33135k != null;
        }
        return this.f33134j != null;
    }

    public void R(b bVar) {
        List<b> list = this.f33127c;
        if (list != null) {
            list.remove(bVar);
        }
    }

    public void S(int i7) {
        f4.a.a(this.f33131g, i7);
    }

    public boolean T(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            k4.b.s("can't find remote device.");
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f33130f;
        if (bluetoothHeadset != null) {
            return Build.VERSION.SDK_INT >= 28 ? h.d(bluetoothHeadset) : h.e(bluetoothHeadset, bluetoothDevice);
        }
        k4.b.s("BluetoothHeadset service is not connected");
        return false;
    }

    public boolean U(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            k4.b.s("can't find remote device.");
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f33130f;
        if (bluetoothHeadset != null) {
            return Build.VERSION.SDK_INT >= 28 ? h.f(bluetoothHeadset) : h.g(bluetoothHeadset, bluetoothDevice);
        }
        k4.b.s("BluetoothHeadset service is not connected");
        return false;
    }

    public final BluetoothDevice b(String str) {
        BluetoothAdapter bluetoothAdapter = this.f33129e;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            return this.f33129e.getRemoteDevice(str);
        }
        k4.b.s("BT not enabled");
        return null;
    }

    public final void f(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            k4.b.s("onVendorSpecificHeadsetEvent() remote device is null");
            return;
        }
        String stringExtra = intent.getStringExtra("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD");
        if (stringExtra == null) {
            k4.b.s("onVendorSpecificHeadsetEvent() command is null");
            return;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE", -1);
        if (intExtra != 0 || intExtra != 1 || intExtra != 2 || intExtra != 3 || intExtra != 4) {
            k4.b.s("onVendorSpecificHeadsetEvent() unknown command");
            return;
        }
        Object[] objArr = (Object[]) intent.getExtras().get("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS");
        List<b> list = this.f33127c;
        if (list == null || list.size() <= 0) {
            k4.b.p("no callback registed");
            return;
        }
        Iterator<b> it = this.f33127c.iterator();
        while (it.hasNext()) {
            it.next().f(bluetoothDevice, stringExtra, intExtra, objArr);
        }
    }

    public final boolean h() {
        Context context = this.f33126b;
        if (context == null) {
            k4.b.s("not intialized");
            return false;
        }
        if (this.f33129e == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
            this.f33128d = bluetoothManager;
            if (bluetoothManager == null) {
                k4.b.s("Unable to initialize BluetoothManager.");
                return false;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            this.f33129e = adapter;
            if (adapter == null) {
                k4.b.s("Unable to obtain a BluetoothAdapter.");
                return false;
            }
        }
        n();
        return true;
    }

    public final boolean i(int i7) {
        if (this.f33129e == null) {
            k4.b.s("mBluetoothAdapter == null");
            return false;
        }
        this.f33136l = new ProfileBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        if ((i7 & 1) == 1) {
            N(2);
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        }
        if ((i7 & 4) == 4) {
            N(1);
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT");
        }
        if ((i7 & 8) == 8) {
            N(4);
            intentFilter.addAction("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
        }
        if ((i7 & 2) == 2) {
            N(11);
            intentFilter.addAction(f4.b.f33905b);
            intentFilter.addAction(f4.b.f33906c);
        }
        if ((i7 & 16) == 16) {
            N(12);
            intentFilter.addAction(f4.d.f33911a);
        }
        this.f33126b.registerReceiver(this.f33136l, intentFilter);
        return true;
    }

    public void k(b bVar) {
        if (this.f33127c == null) {
            this.f33127c = new CopyOnWriteArrayList();
        }
        if (!this.f33127c.contains(bVar)) {
            this.f33127c.add(bVar);
        }
        k4.b.e("mManagerCallbacks.size=" + this.f33127c.size());
    }

    public final void n() {
        i(255);
    }

    public void p() {
        if (this.f33125a) {
            k4.b.p("close()");
        }
        Context context = this.f33126b;
        if (context != null) {
            try {
                context.unregisterReceiver(this.f33136l);
            } catch (Exception e8) {
                k4.b.h(e8.toString());
            }
        }
    }

    public void q(int i7) {
        BluetoothAdapter bluetoothAdapter = this.f33129e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT not enabled");
            return;
        }
        try {
            k4.b.p(String.format(Locale.US, "profile=%d", Integer.valueOf(i7)));
            if (i7 == 11) {
                this.f33129e.closeProfileProxy(i7, this.f33134j);
            } else if (i7 == 12) {
                this.f33129e.closeProfileProxy(i7, this.f33135k);
            } else if (i7 == 1) {
                this.f33129e.closeProfileProxy(i7, this.f33130f);
            } else if (i7 == 2) {
                this.f33129e.closeProfileProxy(i7, this.f33131g);
            } else if (i7 == 3) {
                this.f33129e.closeProfileProxy(i7, this.f33132h);
            } else if (i7 == 4) {
                this.f33129e.closeProfileProxy(i7, this.f33133i);
            }
        } catch (Exception e8) {
            k4.b.h(e8.toString());
        }
    }

    public boolean r(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            k4.b.s("can't find remote device.");
            return false;
        }
        BluetoothProfile bluetoothProfile = this.f33134j;
        if (bluetoothProfile == null) {
            k4.b.s("A2DP Sink not initialized");
            return false;
        }
        if (bluetoothProfile.getConnectionState(bluetoothDevice) == 2) {
            k4.b.s("A2DP Sink already connected");
            return true;
        }
        BluetoothAdapter bluetoothAdapter = this.f33129e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.e("BT not enabled");
            return false;
        }
        if (this.f33125a) {
            k4.b.p("connectA2dpSink: " + bluetoothDevice.getAddress());
        }
        return k.b(this.f33134j, f4.b.f33904a, bluetoothDevice);
    }

    public boolean s(String str) {
        return r(b(str));
    }

    public boolean t(byte[] bArr) {
        return v(d4.a.b(bArr));
    }

    public boolean u(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            k4.b.s("can't find remote device.");
            return false;
        }
        BluetoothA2dp bluetoothA2dp = this.f33131g;
        if (bluetoothA2dp == null) {
            k4.b.s("A2DP not initialized");
            return false;
        }
        if (bluetoothA2dp.getConnectionState(bluetoothDevice) == 2) {
            k4.b.s("a2dp already connected");
            return true;
        }
        BluetoothAdapter bluetoothAdapter = this.f33129e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT not enabled");
            return false;
        }
        k.g(this.f33131g, bluetoothDevice, 100);
        return k.a(this.f33131g, bluetoothDevice);
    }

    public boolean v(String str) {
        return u(b(str));
    }

    public boolean w(byte[] bArr) {
        return v(d4.a.b(bArr));
    }

    public boolean x(String str) {
        BluetoothDevice remoteDevice = this.f33129e.getRemoteDevice(str);
        if (remoteDevice == null) {
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f33130f;
        if (bluetoothHeadset == null) {
            k4.b.s("BluetoothHeadset service is not connected");
            return false;
        }
        if (bluetoothHeadset.getConnectionState(remoteDevice) == 2) {
            k4.b.s("BluetoothHeadset profile is already connected");
            return true;
        }
        if (this.f33125a) {
            k4.b.p("HfpAgConnect" + str);
        }
        return k.a(this.f33130f, remoteDevice);
    }

    public boolean y(byte[] bArr) {
        return x(d4.a.b(bArr));
    }

    public boolean z(BluetoothDevice bluetoothDevice) {
        return Build.VERSION.SDK_INT >= 28 ? k.b(this.f33133i, i.f33938a, bluetoothDevice) : k.b(this.f33133i, j.f33964a, bluetoothDevice);
    }
}
