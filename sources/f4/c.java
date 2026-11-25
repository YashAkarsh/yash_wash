package f4;

import android.bluetooth.BluetoothAdapter;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f33909a = "android.bluetooth.adapter.action.BLE_ACL_CONNECTED";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f33910b = "android.bluetooth.adapter.action.BLE_ACL_DISCONNECTED";

    public static boolean b(BluetoothAdapter bluetoothAdapter, int i7, int i8) {
        if (bluetoothAdapter == null) {
            k4.b.s("BT is not enabled");
            return false;
        }
        k4.b.p(String.format(Locale.US, "mode=%d, duration=%d", Integer.valueOf(i7), Integer.valueOf(i8)));
        try {
            Class<?> cls = bluetoothAdapter.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("setScanMode", cls2, cls2);
            method.setAccessible(true);
            return ((Boolean) method.invoke(bluetoothAdapter, Integer.valueOf(i7), Integer.valueOf(i8))).booleanValue();
        } catch (Exception e8) {
            e8.printStackTrace();
            return true;
        }
    }

    public int a(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null) {
            k4.b.s("BT is not enabled");
            return 0;
        }
        try {
            Method method = bluetoothAdapter.getClass().getMethod("getConnectionState", null);
            method.setAccessible(true);
            return ((Integer) method.invoke(bluetoothAdapter, null)).intValue();
        } catch (Exception e8) {
            e8.printStackTrace();
            return 0;
        }
    }
}
