package com.nostra13.universalimageloader.cache.disc;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends com.nostra13.universalimageloader.cache.disc.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f32596g = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f32597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<File, Long> f32599f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArrListFiles = c.this.f32594a.listFiles();
            if (fileArrListFiles != null) {
                int iF = 0;
                for (File file : fileArrListFiles) {
                    iF += c.this.f(file);
                    c.this.f32599f.put(file, Long.valueOf(file.lastModified()));
                }
                c.this.f32597d.set(iF);
            }
        }
    }

    public c(File file, int i7) {
        this(file, com.nostra13.universalimageloader.core.a.d(), i7);
    }

    private void e() {
        new Thread(new a()).start();
    }

    private int g() {
        File key;
        if (this.f32599f.isEmpty()) {
            return -1;
        }
        Set<Map.Entry<File, Long>> setEntrySet = this.f32599f.entrySet();
        synchronized (this.f32599f) {
            key = null;
            Long value = null;
            for (Map.Entry<File, Long> entry : setEntrySet) {
                if (key == null) {
                    key = entry.getKey();
                    value = entry.getValue();
                } else {
                    Long value2 = entry.getValue();
                    if (value2.longValue() < value.longValue()) {
                        key = entry.getKey();
                        value = value2;
                    }
                }
            }
        }
        if (key != null) {
            if (key.exists()) {
                int iF = f(key);
                if (!key.delete()) {
                    return iF;
                }
                this.f32599f.remove(key);
                return iF;
            }
            this.f32599f.remove(key);
        }
        return 0;
    }

    @Override // com.nostra13.universalimageloader.cache.disc.b
    public void a(String str, File file) {
        int iG;
        int iF = f(file);
        int iAddAndGet = this.f32597d.get();
        while (iAddAndGet + iF > this.f32598e && (iG = g()) != -1) {
            iAddAndGet = this.f32597d.addAndGet(-iG);
        }
        this.f32597d.addAndGet(iF);
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(lValueOf.longValue());
        this.f32599f.put(file, lValueOf);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.a, com.nostra13.universalimageloader.cache.disc.b
    public File c(String str) {
        File fileC = super.c(str);
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        fileC.setLastModified(lValueOf.longValue());
        this.f32599f.put(fileC, lValueOf);
        return fileC;
    }

    @Override // com.nostra13.universalimageloader.cache.disc.a, com.nostra13.universalimageloader.cache.disc.b
    public void clear() {
        this.f32599f.clear();
        this.f32597d.set(0);
        super.clear();
    }

    protected abstract int f(File file);

    public c(File file, x3.a aVar, int i7) {
        super(file, aVar);
        this.f32599f = Collections.synchronizedMap(new HashMap());
        this.f32598e = i7;
        this.f32597d = new AtomicInteger();
        e();
    }
}
