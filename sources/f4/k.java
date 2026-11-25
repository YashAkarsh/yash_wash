package f4;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import c.w0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33966a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33967b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f33968c = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f33969d = 9;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f33970e = 11;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f33971f = 12;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f33972g = 13;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f33973h = 16;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f33974i = 17;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f33975j = 18;

    public static boolean a(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                k4.b.p("connectProfile :" + bluetoothDevice.getAddress());
                Method method = bluetoothProfile.getClass().getMethod("connect", BluetoothDevice.class);
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
            } catch (IllegalAccessException e8) {
                k4.b.s("Could not execute method 'connect' in profile " + bluetoothProfile.getClass().getName() + ", ignoring request." + e8.toString());
                return false;
            } catch (NoSuchMethodException unused) {
                k4.b.s("No connect method in the " + bluetoothProfile.getClass().getName() + " class, ignoring request.");
            } catch (InvocationTargetException e9) {
                k4.b.s("Could not execute method 'connect' in profile " + bluetoothProfile.getClass().getName() + ", ignoring request." + e9.toString());
                return false;
            }
        }
        return false;
    }

    public static boolean b(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                k4.b.p("connectProfile :" + bluetoothDevice.getAddress());
                Class<? extends U> clsAsSubclass = bluetoothProfile.getClass().asSubclass(Class.forName(str));
                if (clsAsSubclass != 0) {
                    Method method = clsAsSubclass.getMethod("connect", BluetoothDevice.class);
                    method.setAccessible(true);
                    return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
                }
                k4.b.s("no class found: " + str);
                return false;
            } catch (ClassNotFoundException e8) {
                k4.b.s("Could not find clas: " + str + ", ignoring request." + e8.toString());
                return false;
            } catch (IllegalAccessException e9) {
                k4.b.s("Could not execute method 'connect' in profile " + str + ", ignoring request." + e9.toString());
                return false;
            } catch (NoSuchMethodException unused) {
                k4.b.s("No connect method in the " + str + " class, ignoring request.");
            } catch (InvocationTargetException e10) {
                k4.b.s("Could not execute method 'connect' in profile " + str + ", ignoring request." + e10.toString());
                return false;
            }
        }
        return false;
    }

    public static boolean c(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                k4.b.p(String.format("disconnect : %s : %s", bluetoothProfile.getClass().getName(), bluetoothDevice.getAddress()));
                Method method = bluetoothProfile.getClass().getMethod("disconnect", BluetoothDevice.class);
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
            } catch (IllegalAccessException e8) {
                k4.b.h("Could not execute method 'disconnect' in profile , ignoring request." + e8.toString());
                return false;
            } catch (NoSuchMethodException unused) {
                k4.b.h("No disconnect method in the  class, ignoring request.");
            } catch (InvocationTargetException e9) {
                k4.b.h("Could not execute method 'disconnect' in profile , ignoring request." + e9.toString());
                return false;
            }
        }
        return false;
    }

    public static boolean d(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                k4.b.p(String.format("disconnect : %s : %s", str, bluetoothDevice.getAddress()));
                Method method = bluetoothProfile.getClass().asSubclass(Class.forName(str)).getMethod("disconnect", BluetoothDevice.class);
                method.setAccessible(true);
                return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
            } catch (ClassNotFoundException e8) {
                k4.b.s("Could not find clas: " + str + ", ignoring request." + e8.toString());
                return false;
            } catch (IllegalAccessException e9) {
                k4.b.h("Could not execute method 'disconnect' in profile " + str + ", ignoring request." + e9.toString());
                return false;
            } catch (NoSuchMethodException unused) {
                k4.b.h("No disconnect method in the " + str + " class, ignoring request.");
            } catch (InvocationTargetException e10) {
                k4.b.h("Could not execute method 'disconnect' in profile " + str + ", ignoring request." + e10.toString());
                return false;
            }
        }
        return false;
    }

    public static List<BluetoothDevice> e(BluetoothProfile bluetoothProfile, String str) {
        if (bluetoothProfile == null) {
            return null;
        }
        try {
            Method method = bluetoothProfile.getClass().asSubclass(Class.forName(str)).getMethod("getConnectedDevices", null);
            method.setAccessible(true);
            return (List) method.invoke(bluetoothProfile, null);
        } catch (ClassNotFoundException e8) {
            k4.b.s("Could not find clas: " + str + ", ignoring request." + e8.toString());
            return null;
        } catch (IllegalAccessException e9) {
            e = e9;
            k4.b.s("Could not execute method 'connect' in profile CLASS_NAME, ignoring request." + e.toString());
            return null;
        } catch (NoSuchMethodException unused) {
            k4.b.s("No connect method in the CLASS_NAME class, ignoring request.");
            return null;
        } catch (InvocationTargetException e10) {
            e = e10;
            k4.b.s("Could not execute method 'connect' in profile CLASS_NAME, ignoring request." + e.toString());
            return null;
        }
    }

    @w0("android.permission.BLUETOOTH")
    @TargetApi(19)
    public static int f(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null) {
            try {
                Method method = bluetoothProfile.getClass().asSubclass(Class.forName(str)).getMethod("getConnectionState", BluetoothDevice.class);
                method.setAccessible(true);
                return ((Integer) method.invoke(bluetoothProfile, bluetoothDevice)).intValue();
            } catch (ClassNotFoundException e8) {
                k4.b.s("Could not find clas: " + str + ", ignoring request." + e8.toString());
                return 0;
            } catch (IllegalAccessException e9) {
                e = e9;
                k4.b.s("Could not execute method 'connect' in profile CLASS_NAME, ignoring request." + e.toString());
                return 0;
            } catch (NoSuchMethodException unused) {
                k4.b.s("No connect method in the CLASS_NAME class, ignoring request.");
            } catch (InvocationTargetException e10) {
                e = e10;
                k4.b.s("Could not execute method 'connect' in profile CLASS_NAME, ignoring request." + e.toString());
                return 0;
            }
        }
        return 0;
    }

    public static void g(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice, int i7) {
        if (bluetoothProfile == null) {
            return;
        }
        try {
            bluetoothProfile.getClass().getMethod("setPriority", BluetoothDevice.class, Integer.TYPE).invoke(bluetoothProfile, bluetoothDevice, Integer.valueOf(i7));
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }
}
