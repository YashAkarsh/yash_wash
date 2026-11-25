package com.haier.uhome.usdk.base.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.haier.library.common.thread.l;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.BasicResp;
import com.haier.uhome.usdk.base.json.InComing;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class f implements com.haier.uhome.usdk.base.a.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f31265h = -22005;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Queue<InComing> f31266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<BasicReq> f31267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l f31268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Callable<Object> f31269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Callable<Object> f31270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.uhome.usdk.base.a.a f31271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f31272g;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f31273a = new f();

        private a() {
        }
    }

    public Handler b() {
        return this.f31272g;
    }

    synchronized BasicReq c() {
        return this.f31267b.poll();
    }

    public synchronized InComing d() {
        return this.f31266a.poll();
    }

    public void e() {
        com.haier.uhome.usdk.base.c.f.a().b();
    }

    @Override // com.haier.uhome.usdk.base.a.b
    public void onReceive(String str) {
        try {
            Iterator<InComing> it = ProtocolProcessor.parser(str).iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e8) {
            com.haier.uhome.usdk.base.a.a aVar = this.f31271f;
            if (aVar != null) {
                aVar.a(str);
            }
            e3.a.h("receive InComing [%s] exception,Exception [%s]", str, e8);
        }
    }

    private f() {
        this.f31266a = new LinkedList();
        this.f31267b = new LinkedList();
        this.f31268c = new l();
        this.f31269d = new h(this);
        this.f31270e = new g(this);
        this.f31271f = new b();
        HandlerThread handlerThread = new HandlerThread("MessageCommunication", -2);
        handlerThread.start();
        this.f31272g = new Handler(handlerThread.getLooper());
    }

    public static f a() {
        return a.f31273a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BasicReq basicReq, int i7, com.haier.uhome.usdk.base.api.l lVar) {
        basicReq.prepare(this.f31272g, ((long) i7) * 1000, lVar);
        basicReq.handle();
        try {
            b(basicReq);
        } catch (Exception e8) {
            a(basicReq, e8);
        }
    }

    public void a(final BasicReq basicReq, final int i7, final com.haier.uhome.usdk.base.api.l lVar) {
        e3.a.e("send request: %s, timeout = %d", basicReq.buildJson(), Integer.valueOf(i7));
        this.f31272g.post(new Runnable() { // from class: com.haier.uhome.usdk.base.d.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f31276a.b(basicReq, i7, lVar);
            }
        });
    }

    private void a(BasicReq basicReq, Throwable th) {
        com.haier.uhome.usdk.base.a.a aVar = this.f31271f;
        if (aVar != null) {
            aVar.b(basicReq);
        }
        e3.a.h("sendRequest [%s] exception, Exception [%s]", basicReq, th);
    }

    boolean b(BasicReq basicReq) {
        com.haier.uhome.usdk.base.a.a aVar;
        if (basicReq != null) {
            e nativeSender = basicReq.getNativeSender();
            if (nativeSender != null) {
                e3.a.e("%s sendReq <%d> ", nativeSender.getClass().getName(), Integer.valueOf(basicReq.getSn()));
                int iSendReq = nativeSender.sendReq(basicReq);
                e3.a.e("%s sendReq <%d> ret %d", nativeSender.getClass().getName(), Integer.valueOf(basicReq.getSn()), Integer.valueOf(iSendReq));
                if (iSendReq == 0 && (aVar = this.f31271f) != null) {
                    aVar.a(basicReq);
                } else if (iSendReq == f31265h && this.f31271f != null) {
                    String strA = a(basicReq, iSendReq);
                    e3.a.o("submit request return error<%d>! so create resp self<%s>", Integer.valueOf(iSendReq), strA);
                    if (strA != null) {
                        onReceive(strA);
                    }
                } else {
                    e3.a.h("submit request error,JNI send error <%d>!", Integer.valueOf(iSendReq));
                    throw new IllegalArgumentException("JNI send error");
                }
                return true;
            }
            e3.a.h("submit request error,sender is null !", new Object[0]);
            throw new IllegalArgumentException("sender is null");
        }
        e3.a.h("submit request error,request is null !", new Object[0]);
        throw new IllegalArgumentException("request is null");
    }

    public synchronized void a(BasicReq basicReq) {
        if (basicReq != null) {
            if (!TextUtils.isEmpty(basicReq.getContent())) {
                if (this.f31268c != null) {
                    this.f31267b.offer(basicReq);
                    e3.a.e("add queue offer request " + basicReq.getContent(), new Object[0]);
                    this.f31268c.a(this.f31269d);
                } else {
                    e3.a.h("add request error,singleExecutor is null!", new Object[0]);
                    throw new RuntimeException("singleExecutor is null!");
                }
            }
        }
        e3.a.h("add request error,request is null!", new Object[0]);
        throw new RuntimeException("request is null!");
    }

    private String a(BasicReq basicReq, int i7) {
        Class<BasicResp> responseClass = ProtocolProcessor.getResponseClass(basicReq.getClass());
        if (responseClass == null || TextUtils.isEmpty(ProtocolProcessor.getProtocol(responseClass))) {
            return null;
        }
        try {
            BasicResp basicRespNewInstance = responseClass.newInstance();
            basicRespNewInstance.setErrNo(i7);
            basicRespNewInstance.setSn(basicReq.getSn());
            com.haier.library.json.e eVar = new com.haier.library.json.e();
            eVar.put(ProtocolProcessor.getProtocol(responseClass), basicRespNewInstance);
            return eVar.k();
        } catch (IllegalAccessException e8) {
            e8.printStackTrace();
            return null;
        } catch (InstantiationException e9) {
            e9.printStackTrace();
            return null;
        }
    }

    public void b(InComing inComing) {
        e3.a.e("handlerInComing inComing <%s>!", inComing);
        com.haier.uhome.usdk.base.a.a aVar = this.f31271f;
        if (aVar != null) {
            aVar.a(inComing);
        }
    }

    public synchronized void a(InComing inComing) {
        try {
            if (inComing != null) {
                if (this.f31268c != null) {
                    this.f31266a.offer(inComing);
                    e3.a.e("addInComing inComing to mReceiveQueue <%s>!", inComing);
                    this.f31268c.a(this.f31270e);
                } else {
                    e3.a.e("receive inComing error,singleExecutor is null!", new Object[0]);
                    throw new RuntimeException("singleExecutor is null!");
                }
            } else {
                e3.a.e("receive inComing error,inComing is null !", new Object[0]);
                throw new RuntimeException("inComing is null!");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
