package d4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.provider.Settings;
import com.facebook.internal.AnalyticsEvents;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33451a = 6;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33452b = 16;

    public static byte[] a(String str) {
        byte[] bArr = new byte[6];
        if (str != null) {
            bArr[0] = (byte) ((Character.digit(str.charAt(15), 16) * 16) + Character.digit(str.charAt(16), 16));
            bArr[1] = (byte) ((Character.digit(str.charAt(12), 16) * 16) + Character.digit(str.charAt(13), 16));
            bArr[2] = (byte) ((Character.digit(str.charAt(9), 16) * 16) + Character.digit(str.charAt(10), 16));
            bArr[3] = (byte) ((Character.digit(str.charAt(6), 16) * 16) + Character.digit(str.charAt(7), 16));
            bArr[4] = (byte) ((Character.digit(str.charAt(3), 16) * 16) + Character.digit(str.charAt(4), 16));
            bArr[5] = (byte) ((Character.digit(str.charAt(0), 16) * 16) + Character.digit(str.charAt(1), 16));
        } else {
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[4] = 0;
            bArr[5] = 0;
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (bArr == null || bArr.length < 5) {
            return null;
        }
        if ((bArr[5] & 255) <= 15) {
            str = "0" + Integer.toHexString(bArr[5] & 255).toUpperCase() + ":";
        } else {
            str = Integer.toHexString(bArr[5] & 255).toUpperCase() + ":";
        }
        if ((bArr[4] & 255) <= 15) {
            str2 = str + "0" + Integer.toHexString(bArr[4] & 255).toUpperCase() + ":";
        } else {
            str2 = str + Integer.toHexString(bArr[4] & 255).toUpperCase() + ":";
        }
        if ((bArr[3] & 255) <= 15) {
            str3 = str2 + "0" + Integer.toHexString(bArr[3] & 255).toUpperCase() + ":";
        } else {
            str3 = str2 + Integer.toHexString(bArr[3] & 255).toUpperCase() + ":";
        }
        if ((bArr[2] & 255) <= 15) {
            str4 = str3 + "0" + Integer.toHexString(bArr[2] & 255).toUpperCase() + ":";
        } else {
            str4 = str3 + Integer.toHexString(bArr[2] & 255).toUpperCase() + ":";
        }
        if ((bArr[1] & 255) <= 15) {
            str5 = str4 + "0" + Integer.toHexString(bArr[1] & 255).toUpperCase() + ":";
        } else {
            str5 = str4 + Integer.toHexString(bArr[1] & 255).toUpperCase() + ":";
        }
        if ((bArr[0] & 255) > 15) {
            return str5 + Integer.toHexString(bArr[0] & 255).toUpperCase();
        }
        return str5 + "0" + Integer.toHexString(bArr[0] & 255).toUpperCase();
    }

    public static void c() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            defaultAdapter.enable();
        }
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length < 6) {
            return null;
        }
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X", Byte.valueOf(bArr[5]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[0]));
    }

    public static String e(byte[] bArr) {
        if (bArr == null || bArr.length < 6) {
            return null;
        }
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]));
    }

    public static String f(Context context, BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter != null) {
            Class<?> cls = bluetoothAdapter.getClass();
            try {
                Class<?> cls2 = Class.forName("android.bluetooth.IBluetooth");
                Field declaredField = cls.getDeclaredField("mService");
                declaredField.setAccessible(true);
                Method method = cls2.getMethod("getAddress", new Class[0]);
                method.setAccessible(true);
                return (String) method.invoke(declaredField.get(bluetoothAdapter), new Object[0]);
            } catch (Exception e8) {
                k4.b.h(e8.toString());
            }
        } else if (context != null) {
            return Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
        }
        return null;
    }

    public static List<BluetoothDevice> g() {
        ArrayList arrayList = new ArrayList();
        try {
            for (BluetoothDevice bluetoothDevice : BluetoothAdapter.getDefaultAdapter().getBondedDevices()) {
                if (f4.f.e(bluetoothDevice)) {
                    k4.b.p("connected:" + bluetoothDevice.getName() + ", addr=" + bluetoothDevice.getAddress());
                    arrayList.add(bluetoothDevice);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return arrayList;
    }

    public static String h(int i7) {
        return f4.g.c(i7);
    }

    public static String i(int i7) {
        return f4.g.d(i7);
    }

    public static List<BluetoothDevice> j() {
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            Method declaredMethod = BluetoothAdapter.class.getDeclaredMethod("getConnectionState", null);
            declaredMethod.setAccessible(true);
            if (((Integer) declaredMethod.invoke(defaultAdapter, null)).intValue() == 2) {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (f4.f.e(bluetoothDevice)) {
                        k4.b.p("connected:" + bluetoothDevice.getName() + ", addr=" + bluetoothDevice.getAddress());
                        arrayList.add(bluetoothDevice);
                    }
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return arrayList;
    }

    public static List<BluetoothDevice> k(int i7) {
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            if (defaultAdapter.getProfileConnectionState(i7) == 2) {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (f4.f.e(bluetoothDevice)) {
                        k4.b.p("connected:" + bluetoothDevice.getName() + ", addr=" + bluetoothDevice.getAddress());
                        arrayList.add(bluetoothDevice);
                    }
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return arrayList;
    }

    public static String l(int i7) {
        return f4.g.e(i7);
    }

    public static boolean m() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static boolean n(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static String o(int i7) {
        return f4.f.g(i7);
    }

    public static String p(int i7) {
        if (i7 == 16) {
            return "HEADSET_CLIENT";
        }
        if (i7 == 17) {
            return "PBAP_CLIENT";
        }
        switch (i7) {
            case 1:
                return "HEADSET";
            case 2:
                return "A2DP";
            case 3:
                return "HEALTH";
            case 4:
                return "HID_HOST";
            case 5:
                return "PAN";
            case 6:
                return "PBAP";
            case 7:
                return "GATT";
            case 8:
                return "GATT_SERVER";
            case 9:
                return "MAP";
            case 10:
                return "SAP";
            case 11:
                return "A2DP_SINK";
            case 12:
                return "AVRCP_CONTROLLER";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static String q(int i7) {
        if (i7 == 0) {
            return "0-BluetoothProfile.STATE_DISCONNECTED";
        }
        if (i7 == 1) {
            return "1-BluetoothProfile.STATE_CONNECTING";
        }
        if (i7 == 2) {
            return "2-BluetoothProfile.STATE_CONNECTED";
        }
        if (i7 == 3) {
            return "3-BluetoothProfile.STATE_DISCONNECTING";
        }
        return "UNKNOWN (" + i7 + ")";
    }

    public static List<String> r(int i7) {
        return f4.g.f(i7);
    }

    public static String s(int i7) {
        return f4.g.g(i7);
    }
}
