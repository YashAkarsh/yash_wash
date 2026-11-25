package com.haier.uhome.usdk.base.json;

import android.os.Handler;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.l;
import com.haier.uhome.usdk.base.api.m;
import com.haier.uhome.usdk.base.c.f;
import g3.b;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicReq extends OutGoing {

    @b(serialize = false)
    private Handler handler;

    @b(serialize = false)
    private String mContent;

    @b(serialize = false)
    private Class<?> mReqClass;

    @b(serialize = false)
    private l respCallback;

    @b(serialize = false)
    private BasicResp response;

    @b(name = "sn")
    private int sn = f.a().c();

    @b(serialize = false)
    private AtomicBoolean respEd = new AtomicBoolean(false);

    protected BasicReq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timeout() {
        if (this.respCallback != null && this.respEd.compareAndSet(false, true)) {
            Class<BasicResp> responseClass = ProtocolProcessor.getResponseClass(this.mReqClass);
            e3.a.h("sendRequest [%d] timeout ", Integer.valueOf(getSn()));
            try {
                this.respCallback.onResp(ProtocolProcessor.createResponseByErrorConst(responseClass, ErrorConst.ERR_USDK_TIMEOUT));
            } catch (Exception e8) {
                e3.a.h("timeout error<%s>!!! protocol req: %s -resp: %s", e8.getMessage(), this.mReqClass, responseClass);
            }
        }
    }

    @Override // com.haier.uhome.usdk.base.json.OutGoing
    public final String buildJson() {
        HashMap map = new HashMap(1);
        map.put(protocol(), this);
        return com.haier.library.json.a.Z(map);
    }

    public String getContent() {
        return this.mContent;
    }

    public int getSn() {
        return this.sn;
    }

    public void handle() {
        f.a().a(this);
    }

    public void init() {
        this.mContent = buildJson();
    }

    public void prepare(Handler handler, long j7, l lVar) {
        this.respCallback = lVar;
        this.handler = handler;
        this.mReqClass = getClass();
        handler.postDelayed(new a(this), j7);
    }

    protected abstract String protocol();

    public void setResponse(BasicResp basicResp) {
        if (this.respCallback == null) {
            return;
        }
        this.response = basicResp;
        if (this.respEd.compareAndSet(false, true)) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacks(new a(this));
            }
            Class<BasicResp> responseClass = ProtocolProcessor.getResponseClass(getClass());
            e3.a.e("sendRequest [%d] ok,return [%s]", Integer.valueOf(getSn()), this.response);
            try {
                BasicResp basicResp2 = this.response;
                if (basicResp2 == null || !responseClass.equals(basicResp2.getClass())) {
                    this.respCallback.onResp(ProtocolProcessor.createResponseByErrorConst(responseClass, ErrorConst.ERR_USDK_TIMEOUT));
                } else {
                    this.respCallback.onResp(this.response);
                }
            } catch (Exception e8) {
                e3.a.h("response error<%s>!!! protocol req: %s -resp: %s", e8.getMessage(), this.mReqClass, responseClass);
            }
        }
        if (this.respCallback instanceof m) {
            Class<BasicResp> responseClass2 = ProtocolProcessor.getResponseClass(getClass());
            e3.a.e("sendRequest [%d] ok, true return [%s]", Integer.valueOf(getSn()), this.response);
            try {
                m mVar = (m) this.respCallback;
                BasicResp basicResp3 = this.response;
                if (basicResp3 != null && responseClass2 == basicResp3.getClass()) {
                    mVar.a(this.response);
                }
            } catch (Exception e9) {
                e3.a.h("onTrueResp error<%s>!!! protocol req: %s -resp: %s", e9.getMessage(), this.mReqClass, responseClass2);
            }
        }
    }

    public String toString() {
        return "BasicReq{sn=" + this.sn + '}';
    }

    public void triggerTimeout() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(new a(this));
        }
        timeout();
    }
}
