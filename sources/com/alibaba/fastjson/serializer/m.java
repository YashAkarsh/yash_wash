package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public class m implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f13136a = new m();

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        if (bVar.f12789f.L0() == 8) {
            bVar.f12789f.Q(16);
            return null;
        }
        com.alibaba.fastjson.b bVar2 = new com.alibaba.fastjson.b();
        bVar.V0(bVar2);
        int i7 = 0;
        if (type == AtomicIntegerArray.class) {
            ?? r7 = (T) new AtomicIntegerArray(bVar2.size());
            while (i7 < bVar2.size()) {
                r7.set(i7, bVar2.s1(i7).intValue());
                i7++;
            }
            return r7;
        }
        ?? r8 = (T) new AtomicLongArray(bVar2.size());
        while (i7 < bVar2.size()) {
            r8.set(i7, bVar2.v1(i7).longValue());
            i7++;
        }
        return r8;
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj instanceof AtomicInteger) {
            j1Var.N1(((AtomicInteger) obj).get());
            return;
        }
        if (obj instanceof AtomicLong) {
            j1Var.W1(((AtomicLong) obj).get());
            return;
        }
        if (obj instanceof AtomicBoolean) {
            j1Var.append(((AtomicBoolean) obj).get() ? "true" : com.paytm.pgsdk.d.G);
            return;
        }
        if (obj == null) {
            j1Var.Z1(k1.WriteNullListAsEmpty);
            return;
        }
        int i8 = 0;
        if (obj instanceof AtomicIntegerArray) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            int length = atomicIntegerArray.length();
            j1Var.write(91);
            while (i8 < length) {
                int i9 = atomicIntegerArray.get(i8);
                if (i8 != 0) {
                    j1Var.write(44);
                }
                j1Var.N1(i9);
                i8++;
            }
            j1Var.write(93);
            return;
        }
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        int length2 = atomicLongArray.length();
        j1Var.write(91);
        while (i8 < length2) {
            long j7 = atomicLongArray.get(i8);
            if (i8 != 0) {
                j1Var.write(44);
            }
            j1Var.W1(j7);
            i8++;
        }
        j1Var.write(93);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 14;
    }
}
