package h4;

import android.bluetooth.BluetoothAdapter;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static void a(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null || bluetoothAdapter.getState() != 12) {
            throw new IllegalStateException("BT Adapter is not turned ON");
        }
    }

    public static boolean b(SparseArray<byte[]> sparseArray, SparseArray<byte[]> sparseArray2) {
        if (sparseArray == sparseArray2) {
            return true;
        }
        if (sparseArray == null || sparseArray2 == null || sparseArray.size() != sparseArray2.size()) {
            return false;
        }
        for (int i7 = 0; i7 < sparseArray.size(); i7++) {
            if (sparseArray.keyAt(i7) != sparseArray2.keyAt(i7) || !Arrays.equals(sparseArray.valueAt(i7), sparseArray2.valueAt(i7))) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean c(Map<T, byte[]> map, Map<T, byte[]> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<T> setKeySet = map.keySet();
        if (!setKeySet.equals(map2.keySet())) {
            return false;
        }
        for (T t7 : setKeySet) {
            if (!Objects.deepEquals(map.get(t7), map2.get(t7))) {
                return false;
            }
        }
        return true;
    }

    public static String d(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i7 = 0; i7 < sparseArray.size(); i7++) {
            sb.append(sparseArray.keyAt(i7));
            sb.append("=");
            sb.append(Arrays.toString(sparseArray.valueAt(i7)));
        }
        sb.append('}');
        return sb.toString();
    }

    public static <T> String e(Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            T key = it.next().getKey();
            sb.append(key);
            sb.append("=");
            sb.append(Arrays.toString(map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
