package com.haier.uhome.trace.api;

import android.text.TextUtils;
import com.haier.uhome.trace.b.c;
import com.haier.uhome.trace.b.e;
import com.haier.uhome.usdk.base.api.ErrorConst;

/* JADX INFO: loaded from: classes2.dex */
public class Trace {
    private static final int TRACE_ID_LENGTH = 32;
    private c mTraceImpl;

    private Trace(c cVar) {
        this.mTraceImpl = cVar;
        e3.a.e("createTrace ok", new Object[0]);
    }

    public static Trace createDITrace() {
        e3.a.e("createDITrace", new Object[0]);
        c cVarA = c.a();
        if (cVarA != null) {
            return new Trace(cVarA);
        }
        e3.a.h("createDITrace error, trace not enable!", new Object[0]);
        return null;
    }

    public static Trace createTrace(String str) {
        e3.a.e("createTrace with %s", str);
        if (TextUtils.isEmpty(str)) {
            e3.a.h("createTrace error, businessId is null or empty!", new Object[0]);
            return null;
        }
        c cVarA = c.a(str);
        if (cVarA != null) {
            return new Trace(cVarA);
        }
        e3.a.h("createTrace error, trace not enable!", new Object[0]);
        return null;
    }

    public int addDITraceNode(DITraceNode dITraceNode) {
        c cVar = this.mTraceImpl;
        if (cVar != null) {
            return cVar.a((String) null, dITraceNode).getErrorId();
        }
        e3.a.h("addDITraceNode error, TraceImpl is null!", new Object[0]);
        return ErrorConst.ERR_USDK_TRACE_IS_NOT_STARTED.getErrorId();
    }

    public int addTraceNode(TraceNode traceNode) {
        c cVar = this.mTraceImpl;
        if (cVar != null) {
            return cVar.a(traceNode, e.APP).getErrorId();
        }
        e3.a.h("addSendRequestTraceNode error, TraceImpl is null!", new Object[0]);
        return ErrorConst.ERR_USDK_TRACE_IS_NOT_STARTED.getErrorId();
    }

    public String getTraceId() {
        return this.mTraceImpl.b();
    }

    public int addDITraceNode(String str, DITraceNode dITraceNode) {
        if (this.mTraceImpl == null) {
            e3.a.h("addDITraceNode error, TraceImpl is null!", new Object[0]);
            return ErrorConst.ERR_USDK_TRACE_IS_NOT_STARTED.getErrorId();
        }
        if (TextUtils.isEmpty(str)) {
            e3.a.h("createTrace error, trace is null or length illegal", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM.getErrorId();
        }
        return this.mTraceImpl.a(str, dITraceNode).getErrorId();
    }

    public static Trace createTrace(String str, String str2) {
        e3.a.e("createTrace with %s", str2);
        if (TextUtils.isEmpty(str2)) {
            e3.a.h("createTrace error, businessId is null or empty!", new Object[0]);
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            e3.a.h("createTrace error, trace is null or length illegal", new Object[0]);
            return null;
        }
        c cVarA = c.a(str, str2);
        if (cVarA == null) {
            e3.a.h("createTrace error, trace not enable!", new Object[0]);
            return null;
        }
        return new Trace(cVarA);
    }
}
