package b3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        String str = "";
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            String str2 = (String) arrayList.get(i7);
            String str3 = map.get(str2);
            str = i7 == arrayList.size() - 1 ? str + str2 + "=" + str3 : str + str2 + "=" + str3 + m0.a.f37445e;
        }
        return str;
    }

    public static SortedMap<String, String> b(Map<String, String> map) {
        if (map.containsKey("tokenId")) {
            map.remove("tokenId");
        }
        TreeMap treeMap = new TreeMap();
        if (map.size() <= 0) {
            return treeMap;
        }
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 != null && !str2.equals("")) {
                treeMap.put(str, str2);
            }
        }
        return treeMap;
    }
}
