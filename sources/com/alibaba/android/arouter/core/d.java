package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/arouter/service/interceptor")
public class d implements InterceptorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f12441c = new Object();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Postcard f12442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterceptorCallback f12443b;

        a(Postcard postcard, InterceptorCallback interceptorCallback) {
            this.f12442a = postcard;
            this.f12443b = interceptorCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.android.arouter.thread.a aVar = new com.alibaba.android.arouter.thread.a(f.f12459f.size());
            try {
                d.c(0, aVar, this.f12442a);
                aVar.await(this.f12442a.getTimeout(), TimeUnit.SECONDS);
                if (aVar.getCount() > 0) {
                    this.f12443b.onInterrupt(new d0.a("The interceptor processing timed out."));
                } else if (this.f12442a.getTag() != null) {
                    this.f12443b.onInterrupt(new d0.a(this.f12442a.getTag().toString()));
                } else {
                    this.f12443b.onContinue(this.f12442a);
                }
            } catch (Exception e8) {
                this.f12443b.onInterrupt(e8);
            }
        }
    }

    static class b implements InterceptorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.alibaba.android.arouter.thread.a f12445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Postcard f12447c;

        b(com.alibaba.android.arouter.thread.a aVar, int i7, Postcard postcard) {
            this.f12445a = aVar;
            this.f12446b = i7;
            this.f12447c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            this.f12445a.countDown();
            d.c(this.f12446b + 1, this.f12445a, postcard);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th) {
            this.f12447c.setTag(th == null ? new d0.a("No message.") : th.getMessage());
            this.f12445a.a();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12448a;

        c(Context context) {
            this.f12448a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.alibaba.android.arouter.utils.d.b(f.f12458e)) {
                Iterator<Map.Entry<Integer, Class<? extends IInterceptor>>> it = f.f12458e.entrySet().iterator();
                while (it.hasNext()) {
                    Class<? extends IInterceptor> value = it.next().getValue();
                    try {
                        IInterceptor iInterceptorNewInstance = value.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iInterceptorNewInstance.init(this.f12448a);
                        f.f12459f.add(iInterceptorNewInstance);
                    } catch (Exception e8) {
                        throw new d0.a("ARouter::ARouter init interceptor error! name = [" + value.getName() + "], reason = [" + e8.getMessage() + "]");
                    }
                }
                boolean unused = d.f12440b = true;
                com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "ARouter interceptors init over.");
                synchronized (d.f12441c) {
                    d.f12441c.notifyAll();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i7, com.alibaba.android.arouter.thread.a aVar, Postcard postcard) {
        if (i7 < f.f12459f.size()) {
            f.f12459f.get(i7).process(postcard, new b(aVar, i7, postcard));
        }
    }

    private static void g() {
        synchronized (f12441c) {
            while (!f12440b) {
                try {
                    f12441c.wait(RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
                } catch (InterruptedException e8) {
                    throw new d0.a("ARouter::Interceptor init cost too much time error! reason = [" + e8.getMessage() + "]");
                }
            }
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.InterceptorService
    public void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback) {
        List<IInterceptor> list = f.f12459f;
        if (list == null || list.size() <= 0) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        g();
        if (f12440b) {
            e.f12451b.execute(new a(postcard, interceptorCallback));
        } else {
            interceptorCallback.onInterrupt(new d0.a("Interceptors initialization takes too much time."));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        e.f12451b.execute(new c(context));
    }
}
