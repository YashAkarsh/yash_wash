package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Object> f13497a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Map<String, Object>> f13498b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f13499c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f13500d = new AtomicInteger();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private x f13501e;

    public z(x xVar) {
        this.f13501e = xVar;
    }

    public final Object a(Method method, Object[] objArr) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        boolean z7 = method.getAnnotation(ResetCookie.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        ThreadLocal<Object> threadLocal = f13497a;
        threadLocal.set(null);
        ThreadLocal<Map<String, Object>> threadLocal2 = f13498b;
        threadLocal2.set(null);
        if (operationType == null) {
            throw new IllegalStateException("OperationType must be set.");
        }
        String strValue = operationType.value();
        int iIncrementAndGet = this.f13500d.incrementAndGet();
        try {
            if (this.f13499c == 0) {
                com.alipay.android.phone.mrpc.core.a.e eVar = new com.alipay.android.phone.mrpc.core.a.e(iIncrementAndGet, strValue, objArr);
                if (threadLocal2.get() != null) {
                    eVar.a(threadLocal2.get());
                }
                byte[] bArr = (byte[]) new j(this.f13501e.a(), method, iIncrementAndGet, strValue, eVar.a(), z7).a();
                threadLocal2.set(null);
                Object objA = new com.alipay.android.phone.mrpc.core.a.d(genericReturnType, bArr).a();
                if (genericReturnType != Void.TYPE) {
                    threadLocal.set(objA);
                }
            }
            return threadLocal.get();
        } catch (RpcException e8) {
            e8.setOperationType(strValue);
            throw e8;
        }
    }
}
