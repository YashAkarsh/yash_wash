package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class h<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f35120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final i5.l<T, Boolean> f35121c;

    public static final class a implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35123b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.e
        private T f35124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ h<T> f35125d;

        a(h<T> hVar) {
            this.f35125d = hVar;
            this.f35122a = ((h) hVar).f35119a.iterator();
        }

        private final void a() {
            while (this.f35122a.hasNext()) {
                T next = this.f35122a.next();
                if (((Boolean) ((h) this.f35125d).f35121c.z(next)).booleanValue() == ((h) this.f35125d).f35120b) {
                    this.f35124c = next;
                    this.f35123b = 1;
                    return;
                }
            }
            this.f35123b = 0;
        }

        @a7.d
        public final Iterator<T> b() {
            return this.f35122a;
        }

        @a7.e
        public final T d() {
            return this.f35124c;
        }

        public final int e() {
            return this.f35123b;
        }

        public final void f(@a7.e T t7) {
            this.f35124c = t7;
        }

        public final void g(int i7) {
            this.f35123b = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35123b == -1) {
                a();
            }
            return this.f35123b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f35123b == -1) {
                a();
            }
            if (this.f35123b == 0) {
                throw new NoSuchElementException();
            }
            T t7 = this.f35124c;
            this.f35124c = null;
            this.f35123b = -1;
            return t7;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@a7.d m<? extends T> sequence, boolean z7, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(sequence, "sequence");
        l0.p(predicate, "predicate");
        this.f35119a = sequence;
        this.f35120b = z7;
        this.f35121c = predicate;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }

    public /* synthetic */ h(m mVar, boolean z7, i5.l lVar, int i7, kotlin.jvm.internal.w wVar) {
        this(mVar, (i7 & 2) != 0 ? true : z7, lVar);
    }
}
