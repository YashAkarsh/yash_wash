package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.j;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f39778d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f39779a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f39780b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f39781c;

    private final class b extends org.junit.runner.notification.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f39782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<org.junit.runner.c, Long> f39783b;

        private b() {
            this.f39782a = System.currentTimeMillis();
            this.f39783b = new HashMap();
        }

        @Override // org.junit.runner.notification.b
        public void b(org.junit.runner.notification.a aVar) throws Exception {
            c.this.h(aVar.a(), this.f39782a);
        }

        @Override // org.junit.runner.notification.b
        public void c(org.junit.runner.c cVar) throws Exception {
            c.this.g(cVar, System.nanoTime() - this.f39783b.get(cVar).longValue());
        }

        @Override // org.junit.runner.notification.b
        public void e(j jVar) throws Exception {
            c.this.j();
        }

        @Override // org.junit.runner.notification.b
        public void g(org.junit.runner.c cVar) throws Exception {
            this.f39783b.put(cVar, Long.valueOf(System.nanoTime()));
        }
    }

    /* JADX INFO: renamed from: org.junit.experimental.max.c$c, reason: collision with other inner class name */
    private class C0531c implements Comparator<org.junit.runner.c> {
        private C0531c() {
        }

        private Long b(org.junit.runner.c cVar) {
            Long lC = c.this.c(cVar);
            if (lC == null) {
                return 0L;
            }
            return lC;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(org.junit.runner.c cVar, org.junit.runner.c cVar2) {
            if (c.this.e(cVar)) {
                return -1;
            }
            if (c.this.e(cVar2)) {
                return 1;
            }
            int iCompareTo = b(cVar2).compareTo(b(cVar));
            return iCompareTo != 0 ? iCompareTo : c.this.d(cVar).compareTo(c.this.d(cVar2));
        }
    }

    private c(File file) {
        this.f39781c = file;
    }

    public static c b(File file) {
        if (file.exists()) {
            try {
                return i(file);
            } catch (org.junit.experimental.max.a e8) {
                e8.printStackTrace();
                file.delete();
            }
        }
        return new c(file);
    }

    private static c i(File file) throws org.junit.experimental.max.a {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    c cVar = (c) objectInputStream.readObject();
                    objectInputStream.close();
                    fileInputStream.close();
                    return cVar;
                } catch (Throwable th) {
                    objectInputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        } catch (Exception e8) {
            throw new org.junit.experimental.max.a(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f39781c));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    Long c(org.junit.runner.c cVar) {
        return this.f39780b.get(cVar.toString());
    }

    Long d(org.junit.runner.c cVar) {
        return this.f39779a.get(cVar.toString());
    }

    boolean e(org.junit.runner.c cVar) {
        return !this.f39779a.containsKey(cVar.toString());
    }

    public org.junit.runner.notification.b f() {
        return new b();
    }

    void g(org.junit.runner.c cVar, long j7) {
        this.f39779a.put(cVar.toString(), Long.valueOf(j7));
    }

    void h(org.junit.runner.c cVar, long j7) {
        this.f39780b.put(cVar.toString(), Long.valueOf(j7));
    }

    public Comparator<org.junit.runner.c> k() {
        return new C0531c();
    }
}
