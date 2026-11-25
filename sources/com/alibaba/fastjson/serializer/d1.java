package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class d1 implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f13023a = new d1();

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object objW1 = bVar.w1(parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return (T) new AtomicReference(objW1);
        }
        if (rawType == WeakReference.class) {
            return (T) new WeakReference(objW1);
        }
        if (rawType == SoftReference.class) {
            return (T) new SoftReference(objW1);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        n0Var.S(obj instanceof AtomicReference ? ((AtomicReference) obj).get() : ((Reference) obj).get());
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }
}
