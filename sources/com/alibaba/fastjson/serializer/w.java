package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class w implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f13181a = new w();

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        Object objX0 = bVar.x0();
        if (objX0 == null) {
            return null;
        }
        return (T) com.alibaba.fastjson.util.l.m(objX0);
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        Character ch = (Character) obj;
        if (ch == null) {
            j1Var.a2("");
        } else if (ch.charValue() == 0) {
            j1Var.a2("\u0000");
        } else {
            j1Var.a2(ch.toString());
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 4;
    }
}
