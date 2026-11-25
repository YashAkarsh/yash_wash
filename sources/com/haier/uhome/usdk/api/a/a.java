package com.haier.uhome.usdk.api.a;

import com.haier.uhome.usdk.api.interfaces.IProgressCallback;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uSDKDevice f30363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IProgressCallback<uSDKDevice, Void> f30364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f30365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CountDownLatch f30366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f30367e = new AtomicBoolean(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lock f30368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Condition f30369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f30370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f30371i;

    a(uSDKDevice usdkdevice) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f30368f = reentrantLock;
        this.f30369g = reentrantLock.newCondition();
        this.f30363a = usdkdevice;
    }

    private void e() {
        Method method;
        if (this.f30370h == -1 || this.f30371i == null) {
            e3.a.e("Task processing quite!", new Object[0]);
            return;
        }
        Method[] declaredMethods = getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                method = null;
                break;
            }
            method = declaredMethods[i7];
            k kVar = (k) method.getAnnotation(k.class);
            if (kVar != null && kVar.a() == this.f30370h) {
                break;
            } else {
                i7++;
            }
        }
        if (method != null) {
            try {
                method.setAccessible(true);
                method.invoke(this, this.f30371i);
            } catch (Exception e8) {
                e3.a.g("Target method invoked error", e8);
            }
        }
    }

    void a(IProgressCallback<uSDKDevice, Void> iProgressCallback) {
        this.f30364b = iProgressCallback;
    }

    protected int b() {
        int elementAddr = this.f30363a.getElementAddr();
        if (elementAddr < 0) {
            e3.a.v("Mesh group: device<%s> elementAddr=%s", this.f30363a.getDeviceId(), Integer.valueOf(elementAddr));
        }
        return elementAddr;
    }

    protected abstract void c();

    uSDKDevice d() {
        return this.f30363a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                c();
                while (this.f30367e.get()) {
                    this.f30368f.lock();
                    try {
                        this.f30369g.await();
                        e();
                        this.f30368f.unlock();
                    } catch (Throwable th) {
                        this.f30368f.unlock();
                        throw th;
                    }
                }
            } catch (Exception e8) {
                if (e8 instanceof com.haier.uhome.usdk.base.b.a) {
                    a(((com.haier.uhome.usdk.base.b.a) e8).a());
                } else {
                    a(ErrorConst.ERR_INTERNAL.toError());
                }
                a(false);
            }
            this.f30366d.countDown();
        } catch (Throwable th2) {
            this.f30366d.countDown();
            throw th2;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    void a(j jVar) {
        this.f30365c = jVar;
    }

    void a(CountDownLatch countDownLatch) {
        this.f30366d = countDownLatch;
    }

    void a() {
        this.f30368f.lock();
        try {
            this.f30371i = null;
            this.f30370h = -1;
            this.f30367e.set(false);
            this.f30369g.signal();
        } finally {
            this.f30368f.unlock();
        }
    }

    void a(Object obj) {
        a(1, obj);
    }

    void a(int i7, Object obj) {
        this.f30368f.lock();
        try {
            this.f30370h = i7;
            this.f30371i = obj;
            this.f30369g.signal();
        } finally {
            this.f30368f.unlock();
        }
    }

    void a(uSDKError usdkerror) {
        this.f30364b.onProgress(this.f30363a, usdkerror);
    }

    void a(boolean z7) {
        this.f30365c.operateComplete(this.f30363a, z7);
    }

    static com.haier.uhome.control.base.api.a a(uSDKDevice usdkdevice) {
        List<com.haier.uhome.control.base.api.a> listSortByPriority = usdkdevice.sortByPriority();
        if (listSortByPriority != null && !listSortByPriority.isEmpty()) {
            com.haier.uhome.control.base.api.a aVarA = a(listSortByPriority);
            if (aVarA != null) {
                return aVarA;
            }
            throw new com.haier.uhome.usdk.base.b.a(ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL.toError());
        }
        throw new com.haier.uhome.usdk.base.b.a(ErrorConst.ERR_INTERNAL.toError());
    }

    private static com.haier.uhome.control.base.api.a a(List<com.haier.uhome.control.base.api.a> list) {
        Iterator<com.haier.uhome.control.base.api.a> it = list.iterator();
        while (it.hasNext()) {
            com.haier.uhome.control.base.api.a next = it.next();
            if ((next instanceof com.haier.uhome.control.local.api.h) || (next instanceof com.haier.uhome.control.local.api.i)) {
                return next;
            }
            if ((next instanceof com.haier.uhome.control.local.api.d) && uSDKDeviceManager.getSingleInstance().b().d()) {
                return next;
            }
        }
        return null;
    }

    static String a(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            return "";
        }
        if (aVar instanceof com.haier.uhome.control.local.api.i) {
            com.haier.uhome.control.local.api.h hVarS = ((com.haier.uhome.control.local.api.i) aVar).S();
            return hVarS != null ? hVarS.X() : "";
        }
        return aVar.X();
    }
}
