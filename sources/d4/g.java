package d4;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static int a(Intent intent) {
        return intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
    }

    public static int b(Intent intent) {
        return intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    }

    public static BluetoothDevice c(Intent intent) {
        return (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    }

    public static int d(Intent intent) {
        return intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
    }

    public static int e(Intent intent) {
        return intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
    }

    public static void f(Class cls) {
        try {
            Method[] methods = cls.getMethods();
            if (methods == null || methods.length <= 0) {
                k4.b.s("no method");
            } else {
                for (Method method : methods) {
                    k4.b.e(method.toString());
                }
            }
            Field[] fields = cls.getFields();
            if (fields == null || fields.length <= 0) {
                k4.b.s("no fields");
                return;
            }
            for (Field field : fields) {
                k4.b.e(field.toString());
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }
}
