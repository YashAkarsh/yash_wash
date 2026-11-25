package com.haier.uhome.usdk.api;

import com.haier.uhome.smart.api.SmartDevicePair;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f31028a = Pattern.compile("([A-Fa-f0-9]{2}:){5}[A-Fa-f0-9]{2}");

    private z() {
    }

    public static ArrayList<uSDKDevice> a(ArrayList<uSDKDevice> arrayList, final ArrayList<uSDKDeviceTypeConst> arrayList2) {
        return (arrayList == null || arrayList2 == null || arrayList2.isEmpty() || arrayList2.contains(uSDKDeviceTypeConst.ALL_TYPE)) ? arrayList : com.haier.library.common.util.u.b(arrayList, new com.haier.library.common.util.u.c() { // from class: com.haier.uhome.usdk.api.m6
            @Override // com.haier.library.common.util.u.c
            public final boolean a(Object obj) {
                return z.a(arrayList2, (uSDKDevice) obj);
            }
        });
    }

    public static ArrayList<q> b(List<SmartDevicePair> list) {
        if (list == null) {
            list = new ArrayList<>(0);
        }
        ArrayList<q> arrayList = new ArrayList<>(list.size());
        for (SmartDevicePair smartDevicePair : list) {
            arrayList.add(new q(smartDevicePair.getName(), smartDevicePair.getValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(ArrayList arrayList, uSDKDevice usdkdevice) {
        return arrayList.contains(usdkdevice.getType());
    }

    public static ArrayList<SmartDevicePair> a(List<q> list) {
        if (list == null) {
            list = new ArrayList<>(0);
        }
        ArrayList<SmartDevicePair> arrayList = new ArrayList<>(list.size());
        arrayList.addAll(list);
        return arrayList;
    }

    public static String b(String str) {
        if (com.haier.library.common.util.c.m(str)) {
            return null;
        }
        return f31028a.matcher(str).matches() ? str.replaceAll(":", "") : str;
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i7 = 0;
        while (i7 < charArray.length) {
            sb.append(charArray[i7]);
            i7++;
            if (i7 % 2 == 0) {
                sb.append(":");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
