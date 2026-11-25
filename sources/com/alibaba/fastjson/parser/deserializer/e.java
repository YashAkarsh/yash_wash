package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements e1 {
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        return (T) f(bVar, type, obj, null, 0);
    }

    public abstract <T> T f(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, String str, int i7);
}
