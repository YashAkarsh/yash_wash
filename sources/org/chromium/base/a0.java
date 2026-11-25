package org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@NotThreadSafe
public class a0<E> implements Iterable<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f38760e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<E> f38761a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38764d;

    private class b implements c<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f38767c;

        private void a() {
            if (this.f38767c) {
                return;
            }
            this.f38767c = true;
            a0.this.k();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i7 = this.f38766b;
            while (i7 < this.f38765a && a0.this.l(i7) == null) {
                i7++;
            }
            if (i7 < this.f38765a) {
                return true;
            }
            a();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (true) {
                int i7 = this.f38766b;
                if (i7 >= this.f38765a || a0.this.l(i7) != null) {
                    break;
                }
                this.f38766b++;
            }
            int i8 = this.f38766b;
            if (i8 >= this.f38765a) {
                a();
                throw new NoSuchElementException();
            }
            a0 a0Var = a0.this;
            this.f38766b = i8 + 1;
            return (E) a0Var.l(i8);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // org.chromium.base.a0.c
        public void s0() {
            a();
            a0.this.n();
            this.f38765a = a0.this.h();
            this.f38767c = false;
            this.f38766b = 0;
        }

        private b() {
            a0.this.n();
            this.f38765a = a0.this.h();
        }
    }

    public interface c<E> extends Iterator<E> {
        void s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        return this.f38761a.size();
    }

    private void j() {
        for (int size = this.f38761a.size() - 1; size >= 0; size--) {
            if (this.f38761a.get(size) == null) {
                this.f38761a.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int i7 = this.f38762b - 1;
        this.f38762b = i7;
        if (i7 <= 0 && this.f38764d) {
            this.f38764d = false;
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E l(int i7) {
        return this.f38761a.get(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f38762b++;
    }

    public void clear() {
        this.f38763c = 0;
        if (this.f38762b == 0) {
            this.f38761a.clear();
            return;
        }
        int size = this.f38761a.size();
        this.f38764d |= size != 0;
        for (int i7 = 0; i7 < size; i7++) {
            this.f38761a.set(i7, null);
        }
    }

    public boolean g(E e8) {
        if (e8 == null || this.f38761a.contains(e8)) {
            return false;
        }
        this.f38761a.add(e8);
        this.f38763c++;
        return true;
    }

    public boolean isEmpty() {
        return this.f38763c == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new b();
    }

    public boolean m(E e8) {
        return this.f38761a.contains(e8);
    }

    public boolean o(E e8) {
        int iIndexOf;
        if (e8 == null || (iIndexOf = this.f38761a.indexOf(e8)) == -1) {
            return false;
        }
        if (this.f38762b == 0) {
            this.f38761a.remove(iIndexOf);
        } else {
            this.f38764d = true;
            this.f38761a.set(iIndexOf, null);
        }
        this.f38763c--;
        return true;
    }

    public c<E> p() {
        return new b();
    }

    public int size() {
        return this.f38763c;
    }
}
