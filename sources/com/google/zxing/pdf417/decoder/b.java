package com.google.zxing.pdf417.decoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f23995a = new HashMap();

    b() {
    }

    Integer a(int i7) {
        return this.f23995a.get(Integer.valueOf(i7));
    }

    int[] b() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f23995a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return e2.a.c(arrayList);
    }

    void c(int i7) {
        Integer num = this.f23995a.get(Integer.valueOf(i7));
        if (num == null) {
            num = 0;
        }
        this.f23995a.put(Integer.valueOf(i7), Integer.valueOf(num.intValue() + 1));
    }
}
