package com.haier.uhome.usdk.smartdev.bind;

import com.haier.uhome.trace.api.TraceNode;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TraceNode f32091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32092b;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.smartdev.bind.a$a, reason: collision with other inner class name */
    protected static abstract class AbstractC0385a<B extends AbstractC0385a<B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32093a = 90;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TraceNode f32094b = null;

        public B a(int i7) {
            this.f32093a = i7;
            return this;
        }

        public B a(TraceNode traceNode) {
            this.f32094b = traceNode;
            return this;
        }
    }

    public a(TraceNode traceNode, int i7) {
        this.f32091a = traceNode;
        this.f32092b = i7;
    }

    protected TraceNode a() {
        return this.f32091a;
    }

    public int b() {
        return this.f32092b;
    }
}
