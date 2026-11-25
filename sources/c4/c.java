package c4;

import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f11532a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedBlockingDeque<T> f11533b = new LinkedBlockingDeque<>();

    public void a(T t7) {
        synchronized (this.f11533b) {
            this.f11533b.add(t7);
        }
    }

    public void b(boolean z7) {
        this.f11532a = z7;
    }

    public void c() {
        synchronized (this.f11533b) {
            this.f11533b.clear();
        }
    }

    public boolean d() {
        return this.f11532a;
    }

    public T e() {
        T tPeek;
        synchronized (this.f11533b) {
            tPeek = this.f11533b.peek();
        }
        return tPeek;
    }

    public T f() {
        T tPoll;
        synchronized (this.f11533b) {
            tPoll = this.f11533b.poll();
        }
        return tPoll;
    }

    public void g(T t7) {
        synchronized (this.f11533b) {
            this.f11533b.push(t7);
        }
    }

    public T h() {
        try {
            return this.f11533b.take();
        } catch (InterruptedException e8) {
            e8.printStackTrace();
            return null;
        }
    }
}
