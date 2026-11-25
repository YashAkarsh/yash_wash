package com.google.common.eventbus;

import com.google.common.base.e0;
import com.google.common.collect.wd;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
abstract class d {

    private static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f21546a = new b();

        private b() {
        }

        @Override // com.google.common.eventbus.d
        void a(Object obj, Iterator<g> it) {
            e0.E(obj);
            while (it.hasNext()) {
                it.next().e(obj);
            }
        }
    }

    private static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConcurrentLinkedQueue<a> f21547a;

        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f21548a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final g f21549b;

            private a(Object obj, g gVar) {
                this.f21548a = obj;
                this.f21549b = gVar;
            }
        }

        private c() {
            this.f21547a = wd.f();
        }

        @Override // com.google.common.eventbus.d
        void a(Object obj, Iterator<g> it) {
            e0.E(obj);
            while (it.hasNext()) {
                this.f21547a.add(new a(obj, it.next()));
            }
            while (true) {
                a aVarPoll = this.f21547a.poll();
                if (aVarPoll == null) {
                    return;
                } else {
                    aVarPoll.f21549b.e(aVarPoll.f21548a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.google.common.eventbus.d$d, reason: collision with other inner class name */
    private static final class C0265d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadLocal<Queue<c>> f21550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ThreadLocal<Boolean> f21551b;

        /* JADX INFO: renamed from: com.google.common.eventbus.d$d$a */
        class a extends ThreadLocal<Queue<c>> {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Queue<c> initialValue() {
                return wd.d();
            }
        }

        /* JADX INFO: renamed from: com.google.common.eventbus.d$d$b */
        class b extends ThreadLocal<Boolean> {
            b() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean initialValue() {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: renamed from: com.google.common.eventbus.d$d$c */
        private static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f21554a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Iterator<g> f21555b;

            private c(Object obj, Iterator<g> it) {
                this.f21554a = obj;
                this.f21555b = it;
            }
        }

        private C0265d() {
            this.f21550a = new a();
            this.f21551b = new b();
        }

        @Override // com.google.common.eventbus.d
        void a(Object obj, Iterator<g> it) {
            e0.E(obj);
            e0.E(it);
            Queue<c> queue = this.f21550a.get();
            queue.offer(new c(obj, it));
            if (this.f21551b.get().booleanValue()) {
                return;
            }
            this.f21551b.set(Boolean.TRUE);
            while (true) {
                try {
                    c cVarPoll = queue.poll();
                    if (cVarPoll == null) {
                        this.f21551b.remove();
                        this.f21550a.remove();
                        return;
                    } else {
                        while (cVarPoll.f21555b.hasNext()) {
                            ((g) cVarPoll.f21555b.next()).e(cVarPoll.f21554a);
                        }
                    }
                } catch (Throwable th) {
                    this.f21551b.remove();
                    this.f21550a.remove();
                    throw th;
                }
            }
        }
    }

    d() {
    }

    static d b() {
        return b.f21546a;
    }

    static d c() {
        return new c();
    }

    static d d() {
        return new C0265d();
    }

    abstract void a(Object obj, Iterator<g> it);
}
