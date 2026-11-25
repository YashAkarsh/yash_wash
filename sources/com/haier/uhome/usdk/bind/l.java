package com.haier.uhome.usdk.bind;

import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.bind.l.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l<B extends a> {
    private TraceNode mCsNode;
    private int mTimeout;

    protected l(TraceNode traceNode, int i7) {
        this.mCsNode = traceNode;
        this.mTimeout = i7;
    }

    protected TraceNode getAppCsNode() {
        return this.mCsNode;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public abstract B rebuild();

    /* JADX INFO: Access modifiers changed from: protected */
    public static abstract class a<B, I extends l> {
        TraceNode mCsNode;
        int mTimeout;

        protected a() {
            this.mTimeout = 90;
            this.mCsNode = null;
        }

        public abstract I build();

        /* JADX WARN: Multi-variable type inference failed */
        public B csNode(TraceNode traceNode) {
            this.mCsNode = traceNode;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B timeout(int i7) {
            this.mTimeout = i7;
            return this;
        }

        protected a(I i7) {
            this.mTimeout = i7.getTimeout();
            this.mCsNode = i7.getAppCsNode();
        }
    }
}
