package f4;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.os.Build;
import c.w0;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f33934a = "+IPHONEACCEV";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33935b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f33936c = "+XEVENT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f33937d = "BATTERY";

    public static int a(String str, Object[] objArr) {
        str.hashCode();
        if (str.equals(f33936c)) {
            return c(objArr);
        }
        if (str.equals(f33934a)) {
            return b(objArr);
        }
        return -1;
    }

    public static int b(Object[] objArr) {
        int iIntValue;
        if (objArr.length == 0) {
            k4.b.s("empty arguments");
            return -1;
        }
        int i7 = 0;
        Object obj = objArr[0];
        if (!(obj instanceof Integer)) {
            k4.b.s("error parsing number of arguments");
            return -1;
        }
        int iIntValue2 = ((Integer) obj).intValue();
        if (objArr.length != (iIntValue2 * 2) + 1) {
            k4.b.s("number of arguments does not match");
            return -1;
        }
        while (true) {
            if (i7 >= iIntValue2) {
                iIntValue = -1;
                break;
            }
            int i8 = i7 * 2;
            Object obj2 = objArr[i8 + 1];
            if (!(obj2 instanceof Integer)) {
                k4.b.s("error parsing indicator type");
                return -1;
            }
            if (((Integer) obj2).intValue() == 1) {
                Object obj3 = objArr[i8 + 2];
                if (obj3 instanceof Integer) {
                    iIntValue = ((Integer) obj3).intValue();
                    break;
                }
                k4.b.s("error parsing indicator value");
                return -1;
            }
            i7++;
        }
        if (iIntValue < 0 || iIntValue > 9) {
            return -1;
        }
        return (iIntValue + 1) * 10;
    }

    public static int c(Object[] objArr) {
        if (objArr.length == 0) {
            k4.b.s("empty arguments");
            return -1;
        }
        Object obj = objArr[0];
        if (!(obj instanceof String)) {
            k4.b.s("error parsing event name");
            return -1;
        }
        String str = (String) obj;
        if (!str.equals(f33937d)) {
            k4.b.s("skip none BATTERY event: " + str);
            return -1;
        }
        if (objArr.length != 5) {
            k4.b.s("wrong battery level event length: " + String.valueOf(objArr.length));
            return -1;
        }
        Object obj2 = objArr[1];
        if (!(obj2 instanceof Integer) || !(objArr[2] instanceof Integer)) {
            k4.b.s("error parsing event values");
            return -1;
        }
        int iIntValue = ((Integer) obj2).intValue();
        int iIntValue2 = ((Integer) objArr[2]).intValue();
        if (iIntValue >= 0 && iIntValue2 > 1 && iIntValue <= iIntValue2) {
            return (iIntValue * 100) / (iIntValue2 - 1);
        }
        k4.b.s("wrong event value, batteryLevel=" + String.valueOf(iIntValue) + ", numberOfLevels=" + String.valueOf(iIntValue2));
        return -1;
    }

    @w0("android.permission.BLUETOOTH_ADMIN")
    public static boolean d(BluetoothHeadset bluetoothHeadset) {
        if (bluetoothHeadset == null) {
            return false;
        }
        try {
            return ((Boolean) bluetoothHeadset.getClass().getMethod("startScoUsingVirtualVoiceCall", new Class[0]).invoke(bluetoothHeadset, new Object[0])).booleanValue();
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public static boolean e(BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (Build.VERSION.SDK_INT >= 28) {
            return d(bluetoothHeadset);
        }
        if (bluetoothHeadset == null) {
            return false;
        }
        try {
            return ((Boolean) bluetoothHeadset.getClass().getMethod("startScoUsingVirtualVoiceCall", BluetoothDevice.class).invoke(bluetoothHeadset, bluetoothDevice)).booleanValue();
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    @w0("android.permission.BLUETOOTH_ADMIN")
    public static boolean f(BluetoothHeadset bluetoothHeadset) {
        if (bluetoothHeadset == null) {
            return false;
        }
        try {
            return ((Boolean) bluetoothHeadset.getClass().getMethod("stopScoUsingVirtualVoiceCall", new Class[0]).invoke(bluetoothHeadset, new Object[0])).booleanValue();
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public static boolean g(BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (Build.VERSION.SDK_INT >= 28) {
            return f(bluetoothHeadset);
        }
        if (bluetoothHeadset == null) {
            return false;
        }
        try {
            return ((Boolean) bluetoothHeadset.getClass().getMethod("stopScoUsingVirtualVoiceCall", BluetoothDevice.class).invoke(bluetoothHeadset, bluetoothDevice)).booleanValue();
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }
}
