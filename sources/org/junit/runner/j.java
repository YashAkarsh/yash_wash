package org.junit.runner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class j implements Serializable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f39973g = 1;
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(c.class).getFields();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f39974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f39975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList<org.junit.runner.notification.a> f39976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f39977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f39978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f39979f;

    @org.junit.runner.notification.b.a
    private class b extends org.junit.runner.notification.b {
        private b() {
        }

        @Override // org.junit.runner.notification.b
        public void a(org.junit.runner.notification.a aVar) {
        }

        @Override // org.junit.runner.notification.b
        public void b(org.junit.runner.notification.a aVar) throws Exception {
            j.this.f39976c.add(aVar);
        }

        @Override // org.junit.runner.notification.b
        public void c(org.junit.runner.c cVar) throws Exception {
            j.this.f39974a.getAndIncrement();
        }

        @Override // org.junit.runner.notification.b
        public void d(org.junit.runner.c cVar) throws Exception {
            j.this.f39975b.getAndIncrement();
        }

        @Override // org.junit.runner.notification.b
        public void e(j jVar) throws Exception {
            j.this.f39977d.addAndGet(System.currentTimeMillis() - j.this.f39978e.get());
        }

        @Override // org.junit.runner.notification.b
        public void f(org.junit.runner.c cVar) throws Exception {
            j.this.f39978e.set(System.currentTimeMillis());
        }
    }

    public j() {
        this.f39974a = new AtomicInteger();
        this.f39975b = new AtomicInteger();
        this.f39976c = new CopyOnWriteArrayList<>();
        this.f39977d = new AtomicLong();
        this.f39978e = new AtomicLong();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.f39979f = c.f(objectInputStream);
    }

    private Object readResolve() {
        return new j(this.f39979f);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        new c(this).g(objectOutputStream);
    }

    public org.junit.runner.notification.b f() {
        return new b();
    }

    public int g() {
        return this.f39976c.size();
    }

    public List<org.junit.runner.notification.a> h() {
        return this.f39976c;
    }

    public int i() {
        return this.f39975b.get();
    }

    public int j() {
        return this.f39974a.get();
    }

    public long k() {
        return this.f39977d.get();
    }

    public boolean l() {
        return g() == 0;
    }

    private static class c implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f39981f = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f39982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f39983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<org.junit.runner.notification.a> f39984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f39985d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f39986e;

        public c(j jVar) {
            this.f39982a = jVar.f39974a;
            this.f39983b = jVar.f39975b;
            this.f39984c = Collections.synchronizedList(new ArrayList(jVar.f39976c));
            this.f39985d = jVar.f39977d.longValue();
            this.f39986e = jVar.f39978e.longValue();
        }

        public static c f(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            return new c(objectInputStream.readFields());
        }

        public void g(ObjectOutputStream objectOutputStream) throws IOException {
            ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
            putFieldPutFields.put("fCount", this.f39982a);
            putFieldPutFields.put("fIgnoreCount", this.f39983b);
            putFieldPutFields.put("fFailures", this.f39984c);
            putFieldPutFields.put("fRunTime", this.f39985d);
            putFieldPutFields.put("fStartTime", this.f39986e);
            objectOutputStream.writeFields();
        }

        private c(ObjectInputStream.GetField getField) throws IOException {
            this.f39982a = (AtomicInteger) getField.get("fCount", (Object) null);
            this.f39983b = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.f39984c = (List) getField.get("fFailures", (Object) null);
            this.f39985d = getField.get("fRunTime", 0L);
            this.f39986e = getField.get("fStartTime", 0L);
        }
    }

    private j(c cVar) {
        this.f39974a = cVar.f39982a;
        this.f39975b = cVar.f39983b;
        this.f39976c = new CopyOnWriteArrayList<>(cVar.f39984c);
        this.f39977d = new AtomicLong(cVar.f39985d);
        this.f39978e = new AtomicLong(cVar.f39986e);
    }
}
