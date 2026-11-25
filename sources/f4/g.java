package f4;

import android.bluetooth.BluetoothGatt;
import android.text.TextUtils;
import c.t0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, String> f33931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<Integer, String> f33932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashMap<Integer, String> f33933c;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        f33931a = map;
        map.put(0, "UNKNOW");
        f33931a.put(1, "READ");
        f33931a.put(2, "READ_ENCRYPTED");
        f33931a.put(4, "READ_ENCRYPTED_MITM");
        f33931a.put(16, "WRITE");
        f33931a.put(32, "WRITE_ENCRYPTED");
        f33931a.put(64, "WRITE_ENCRYPTED_MITM");
        f33931a.put(128, "WRITE_SIGNED");
        f33931a.put(256, "WRITE_SIGNED_MITM");
        HashMap<Integer, String> map2 = new HashMap<>();
        f33932b = map2;
        map2.put(1, "BROADCAST");
        f33932b.put(128, "EXTENDED_PROPS");
        f33932b.put(32, "INDICATE");
        f33932b.put(16, "NOTIFY");
        f33932b.put(2, "READ");
        f33932b.put(64, "SIGNED_WRITE");
        f33932b.put(8, "WRITE");
        f33932b.put(4, "WRITE_NO_RESPONSE");
        HashMap<Integer, String> map3 = new HashMap<>();
        f33933c = map3;
        map3.put(0, "UNKNOW");
        f33933c.put(1, "READ");
        f33933c.put(2, "READ_ENCRYPTED");
        f33933c.put(4, "READ_ENCRYPTED_MITM");
        f33933c.put(16, "WRITE");
        f33933c.put(32, "WRITE_ENCRYPTED");
        f33933c.put(64, "WRITE_ENCRYPTED_MITM");
        f33933c.put(128, "WRITE_SIGNED");
        f33933c.put(256, "WRITE_SIGNED_MITM");
    }

    public static String a(HashMap<Integer, String> map, int i7) {
        String str = map.get(Integer.valueOf(i7));
        if (TextUtils.isEmpty(str)) {
            List<Integer> listB = b(i7);
            str = "";
            for (int i8 = 0; i8 < listB.size(); i8++) {
                str = str + map.get(listB.get(i8)) + "|";
            }
        }
        return str;
    }

    public static List<Integer> b(int i7) {
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < 32; i8++) {
            int i9 = 1 << i8;
            if ((i7 & i9) > 0) {
                arrayList.add(Integer.valueOf(i9));
            }
        }
        return arrayList;
    }

    public static String c(int i7) {
        return a(f33931a, i7);
    }

    public static String d(int i7) {
        return a(f33932b, i7);
    }

    public static String e(int i7) {
        return a(f33933c, i7);
    }

    public static List<String> f(int i7) {
        ArrayList arrayList = new ArrayList();
        if ((i7 & 1) == 1) {
            arrayList.add("BROADCAST");
        }
        if ((i7 & 2) == 2) {
            arrayList.add("READ");
        }
        if ((i7 & 4) == 4) {
            arrayList.add("WRITE_NO_RESPONSE");
        }
        if ((i7 & 8) == 8) {
            arrayList.add("WRITE");
        }
        return arrayList;
    }

    public static String g(int i7) {
        StringBuilder sb = new StringBuilder();
        List<String> listF = f(i7);
        if (listF != null && listF.size() > 0) {
            Iterator<String> it = listF.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        return sb.toString();
    }

    @t0(api = 18)
    public static void h(BluetoothGatt bluetoothGatt) {
        try {
            Method method = bluetoothGatt.getClass().getMethod(com.alipay.sdk.widget.j.f13873s, new Class[0]);
            if (method != null) {
                k4.b.p("clears the internal cache");
                k4.b.e("refreshDevice: " + ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue());
            }
        } catch (Exception e8) {
            k4.b.h("An exception occured while refreshing device" + e8.toString());
        }
    }

    @t0(api = 18)
    public static void i(BluetoothGatt bluetoothGatt, boolean z7) {
        if (z7 || bluetoothGatt.getDevice().getBondState() == 10) {
            h(bluetoothGatt);
        }
    }
}
