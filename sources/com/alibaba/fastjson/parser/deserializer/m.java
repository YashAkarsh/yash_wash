package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class m implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f12901a = new m();

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.alibaba.fastjson.f] */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        int iL0;
        com.alibaba.fastjson.parser.e eVar = (com.alibaba.fastjson.parser.e) bVar.h0();
        String strS0 = eVar.s0(bVar.r0());
        eVar.E();
        int iL1 = eVar.L0();
        if (iL1 == 25) {
            String strS1 = eVar.s0(bVar.r0());
            strS0 = (strS0 + com.alibaba.android.arouter.utils.b.f12515h) + strS1;
            eVar.E();
            iL1 = eVar.L0();
        }
        ?? r7 = (T) new com.alibaba.fastjson.f(strS0);
        if (iL1 != 10) {
            throw new com.alibaba.fastjson.d("illegal jsonp : " + eVar.e());
        }
        eVar.E();
        while (true) {
            r7.b(bVar.x0());
            iL0 = eVar.L0();
            if (iL0 != 16) {
                break;
            }
            eVar.E();
        }
        if (iL0 == 11) {
            eVar.E();
            if (eVar.L0() == 24) {
                eVar.E();
            }
            return r7;
        }
        throw new com.alibaba.fastjson.d("illegal jsonp : " + eVar.e());
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 0;
    }
}
