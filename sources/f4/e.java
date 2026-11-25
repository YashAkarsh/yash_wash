package f4;

import android.bluetooth.BluetoothClass;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33921a = 1280;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f33922b = 1344;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f33923c = 1408;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f33924d = 1472;
    }

    public static boolean a(BluetoothClass bluetoothClass) {
        if (bluetoothClass == null) {
            return false;
        }
        k4.b.p(String.format("getDeviceClass: 0x%04X", Integer.valueOf(bluetoothClass.getDeviceClass())));
        switch (bluetoothClass.getDeviceClass()) {
            case 1024:
            case 1028:
            case 1032:
            case 1040:
            case 1044:
            case 1048:
            case 1052:
            case 1056:
            case 1060:
            case 1064:
            case 1068:
            case 1072:
            case 1076:
            case 1080:
            case 1084:
            case 1088:
            case 1096:
                return true;
            default:
                return false;
        }
    }

    public static boolean b(BluetoothClass bluetoothClass) {
        if (bluetoothClass == null) {
            return false;
        }
        int deviceClass = bluetoothClass.getDeviceClass();
        boolean z7 = deviceClass == 1344 || deviceClass == 1408 || deviceClass == 1472;
        k4.b.p(String.format("getDeviceClass: 0x%04X, isHid=%b", Integer.valueOf(bluetoothClass.getDeviceClass()), Boolean.valueOf(z7)));
        return z7;
    }
}
