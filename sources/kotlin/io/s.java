package kotlin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
final class s implements kotlin.sequences.m<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final BufferedReader f34803a;

    public static final class a implements Iterator<String>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.e
        private String f34804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f34805b;

        a() {
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f34804a;
            this.f34804a = null;
            l0.m(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.f34804a == null && !this.f34805b) {
                String line = s.this.f34803a.readLine();
                this.f34804a = line;
                if (line == null) {
                    this.f34805b = true;
                }
            }
            return this.f34804a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public s(@a7.d BufferedReader reader) {
        l0.p(reader, "reader");
        this.f34803a = reader;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<String> iterator() {
        return new a();
    }
}
