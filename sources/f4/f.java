package f4;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import c.w0;
import com.facebook.internal.AnalyticsEvents;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33925a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33926b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f33927c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f33928d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f33929e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f33930f = 6;

    public static boolean a(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("cancelBondProcess", null);
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            return ((Boolean) method.invoke(bluetoothDevice, null)).booleanValue();
        } catch (Exception e8) {
            k4.b.s("An exception occurred while cancelBondProcess : " + e8.getMessage());
            return false;
        }
    }

    public static boolean b(BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) bluetoothDevice.getClass().getMethod("cancelPairingUserInput", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    @SuppressLint({"NewApi"})
    public static boolean c(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.createBond();
    }

    public static boolean d(BluetoothDevice bluetoothDevice, int i7) {
        if (bluetoothDevice == null) {
            return false;
        }
        try {
            bluetoothDevice.getClass().getMethod("createBond", Integer.TYPE).invoke(bluetoothDevice, Integer.valueOf(i7));
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return false;
    }

    @w0("android.permission.BLUETOOTH")
    public static boolean e(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        try {
            Method declaredMethod = BluetoothDevice.class.getDeclaredMethod("isConnected", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(bluetoothDevice, null)).booleanValue();
        } catch (Exception e8) {
            e8.printStackTrace();
            return true;
        }
    }

    public static String f(int i7) {
        switch (i7) {
            case 0:
                return "PAIRING_VARIANT_PIN";
            case 1:
                return "PAIRING_VARIANT_PASSKEY";
            case 2:
                return "PAIRING_VARIANT_PASSKEY_CONFIRMATION";
            case 3:
                return "PAIRING_VARIANT_CONSENT";
            case 4:
                return "PAIRING_VARIANT_DISPLAY_PASSKEY";
            case 5:
                return "PAIRING_VARIANT_DISPLAY_PIN";
            case 6:
                return "PAIRING_VARIANT_OOB_CONSENT";
            default:
                return "UNKNOWN";
        }
    }

    public static String g(int i7) {
        if (i7 == 1) {
            return "BR/EDR";
        }
        if (i7 != 2) {
            return i7 != 3 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "DUAL(BR/EDR/LE)";
        }
        return "LE";
    }

    public static boolean h(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("removeBond", null);
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            return ((Boolean) method.invoke(bluetoothDevice, null)).booleanValue();
        } catch (Exception e8) {
            k4.b.s("An exception occurred while removing bond information: " + e8.getMessage());
            return false;
        }
    }

    public static boolean i(BluetoothDevice bluetoothDevice, int i7) {
        try {
            k4.b.h("returnValue=" + ((Boolean) bluetoothDevice.getClass().getDeclaredMethod("setPasskey", Integer.TYPE).invoke(bluetoothDevice, Integer.valueOf(i7))));
        } catch (IllegalArgumentException e8) {
            e8.printStackTrace();
        } catch (SecurityException e9) {
            e9.printStackTrace();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return true;
    }
}
