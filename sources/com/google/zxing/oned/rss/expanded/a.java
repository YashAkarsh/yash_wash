package com.google.zxing.oned.rss.expanded;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class a {
    private a() {
    }

    static com.google.zxing.common.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).d() == null) {
            size--;
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a(size * 12);
        int i7 = 0;
        int iB = list.get(0).d().b();
        for (int i8 = 11; i8 >= 0; i8--) {
            if (((1 << i8) & iB) != 0) {
                aVar.t(i7);
            }
            i7++;
        }
        for (int i9 = 1; i9 < list.size(); i9++) {
            b bVar = list.get(i9);
            int iB2 = bVar.c().b();
            for (int i10 = 11; i10 >= 0; i10--) {
                if (((1 << i10) & iB2) != 0) {
                    aVar.t(i7);
                }
                i7++;
            }
            if (bVar.d() != null) {
                int iB3 = bVar.d().b();
                for (int i11 = 11; i11 >= 0; i11--) {
                    if (((1 << i11) & iB3) != 0) {
                        aVar.t(i7);
                    }
                    i7++;
                }
            }
        }
        return aVar;
    }
}
