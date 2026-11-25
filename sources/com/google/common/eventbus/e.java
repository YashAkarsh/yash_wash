package com.google.common.eventbus;

import com.google.common.base.e0;
import com.google.common.base.x;
import com.google.common.util.concurrent.v1;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f21556f = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f21558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f21559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f21560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f21561e;

    static final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f21562a = new a();

        a() {
        }

        private static Logger b(h hVar) {
            return Logger.getLogger(e.class.getName() + com.alibaba.android.arouter.utils.b.f12515h + hVar.b().c());
        }

        private static String c(h hVar) {
            Method methodD = hVar.d();
            return "Exception thrown by subscriber method " + methodD.getName() + '(' + methodD.getParameterTypes()[0].getName() + ") on subscriber " + hVar.c() + " when dispatching event: " + hVar.a();
        }

        @Override // com.google.common.eventbus.i
        public void a(Throwable th, h hVar) {
            Logger loggerB = b(hVar);
            Level level = Level.SEVERE;
            if (loggerB.isLoggable(level)) {
                loggerB.log(level, c(hVar), th);
            }
        }
    }

    public e() {
        this("default");
    }

    final Executor a() {
        return this.f21558b;
    }

    void b(Throwable th, h hVar) {
        e0.E(th);
        e0.E(hVar);
        try {
            this.f21559c.a(th, hVar);
        } catch (Throwable th2) {
            f21556f.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th2, th), th2);
        }
    }

    public final String c() {
        return this.f21557a;
    }

    public void d(Object obj) {
        Iterator<g> itF = this.f21560d.f(obj);
        if (itF.hasNext()) {
            this.f21561e.a(obj, itF);
        } else {
            if (obj instanceof c) {
                return;
            }
            d(new c(this, obj));
        }
    }

    public void e(Object obj) {
        this.f21560d.h(obj);
    }

    public void f(Object obj) {
        this.f21560d.i(obj);
    }

    public String toString() {
        return x.c(this).p(this.f21557a).toString();
    }

    public e(String str) {
        this(str, v1.c(), d.d(), a.f21562a);
    }

    public e(i iVar) {
        this("default", v1.c(), d.d(), iVar);
    }

    e(String str, Executor executor, d dVar, i iVar) {
        this.f21560d = new j(this);
        this.f21557a = (String) e0.E(str);
        this.f21558b = (Executor) e0.E(executor);
        this.f21561e = (d) e0.E(dVar);
        this.f21559c = (i) e0.E(iVar);
    }
}
