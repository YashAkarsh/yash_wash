package com.haier.uhome.usdk.base.utils;

import android.os.Looper;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.s;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static <T> void a(final ICallback<T> iCallback, final T t7) {
        if (iCallback == null) {
            e3.a.v("CallbackUtils.successCallback %s with null callback", a());
            return;
        }
        if (t7 == null) {
            e3.a.v("CallbackUtils.successCallback %s with null result", a());
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.base.utils.j
                @Override // java.lang.Runnable
                public final void run() {
                    iCallback.onSuccess(t7);
                }
            });
        } else {
            iCallback.onSuccess(t7);
        }
    }

    public static <R> void b(ICallback<R> iCallback, R r7) {
        if (iCallback == null) {
            e3.a.v("CallbackUtils.onSuccess with null callback", new Object[0]);
        } else {
            iCallback.onSuccess(r7);
        }
    }

    public static void b(ICallback iCallback, uSDKError usdkerror) {
        if (iCallback == null) {
            e3.a.v("CallbackUtils.onFailure with null callback stack", new Object[0]);
        } else {
            iCallback.onFailure(usdkerror);
        }
    }

    public static <T> void a(final ICallback<T> iCallback, final uSDKError usdkerror) {
        if (iCallback == null) {
            e3.a.v("CallbackUtils.failureCallback %s with null callback", a());
            return;
        }
        if (usdkerror == null) {
            e3.a.v("CallbackUtils.failureCallback %s with null error", a());
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.base.utils.l
                @Override // java.lang.Runnable
                public final void run() {
                    iCallback.onFailure(usdkerror);
                }
            });
        } else {
            iCallback.onFailure(usdkerror);
        }
    }

    public static void b(o oVar, ErrorConst errorConst) {
        if (oVar == null) {
            e3.a.v("CallbackUtils.simpleCallback with null callback", new Object[0]);
        } else {
            oVar.onCallback(errorConst);
        }
    }

    public static void a(final o oVar, final ErrorConst errorConst) {
        if (oVar == null) {
            e3.a.v("CallbackUtils.simpleCallback %s with null callback", a());
            return;
        }
        if (errorConst == null) {
            e3.a.v("CallbackUtils.simpleCallback %s with null error", a());
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.base.utils.h
            @Override // java.lang.Runnable
            public final void run() {
                oVar.onCallback(errorConst);
            }
        });
    }

    public static void a(final s sVar, final uSDKError usdkerror) {
        if (sVar == null) {
            e3.a.v("CallbackUtils.simpleCallback %s with null callback", a());
            return;
        }
        if (usdkerror == null) {
            e3.a.v("CallbackUtils.simpleCallback %s with null error", a());
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.base.utils.k
            @Override // java.lang.Runnable
            public final void run() {
                sVar.onCallback(usdkerror);
            }
        });
    }

    protected static String a() {
        return e3.a.k(5);
    }

    public static <T> T a(final Object obj, Class<?> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.haier.uhome.usdk.base.utils.g
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) {
                return b.a(obj, obj2, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(final Object obj, Object obj2, final Method method, final Object[] objArr) throws Throwable {
        if (obj == null) {
            e3.a.v("Target callback is null, proxy method: %s, args: %s", method.getName(), objArr);
            return null;
        }
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(obj, objArr);
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return method.invoke(obj, objArr);
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.base.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                b.a(method, obj, objArr);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Method method, Object obj, Object[] objArr) {
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e8) {
            e8.printStackTrace();
        } catch (InvocationTargetException e9) {
            e9.printStackTrace();
        }
    }

    public static <T> ICallback<T> a(final s sVar) {
        return new ICallback<T>() { // from class: com.haier.uhome.usdk.base.utils.b.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                sVar.onCallback(usdkerror);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onSuccess(T t7) {
                sVar.onCallback(ErrorConst.RET_USDK_OK.toError());
            }
        };
    }
}
