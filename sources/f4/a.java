package f4;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothA2dp;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    @TargetApi(19)
    public static void a(BluetoothA2dp bluetoothA2dp, int i7) {
        if (bluetoothA2dp == null) {
            return;
        }
        try {
            bluetoothA2dp.getClass().getMethod("setAvrcpAbsoluteVolume", Integer.TYPE).invoke(bluetoothA2dp, Integer.valueOf(i7));
        } catch (IllegalAccessException e8) {
            e = e8;
            k4.b.s("Could not execute method 'connect' in profile " + bluetoothA2dp.getClass().getName() + ", ignoring request." + e.toString());
        } catch (NoSuchMethodException unused) {
            k4.b.s("No connect method in the " + bluetoothA2dp.getClass().getName() + " class, ignoring request.");
        } catch (InvocationTargetException e9) {
            e = e9;
            k4.b.s("Could not execute method 'connect' in profile " + bluetoothA2dp.getClass().getName() + ", ignoring request." + e.toString());
        }
    }
}
