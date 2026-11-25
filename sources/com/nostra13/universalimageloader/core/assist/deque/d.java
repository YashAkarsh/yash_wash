package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class d<E> extends AbstractQueue<E> implements com.nostra13.universalimageloader.core.assist.deque.a<E>, Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f32648h = -387911632671998426L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    transient e<E> f32649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient e<E> f32650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient int f32651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final ReentrantLock f32653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Condition f32654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Condition f32655g;

    private abstract class b implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e<E> f32656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        E f32657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e<E> f32658c;

        b() {
            ReentrantLock reentrantLock = d.this.f32653e;
            reentrantLock.lock();
            try {
                e<E> eVarB = b();
                this.f32656a = eVarB;
                this.f32657b = eVarB == null ? null : eVarB.f32662a;
            } finally {
                reentrantLock.unlock();
            }
        }

        private e<E> d(e<E> eVar) {
            while (true) {
                e<E> eVarC = c(eVar);
                if (eVarC == null) {
                    return null;
                }
                if (eVarC.f32662a != null) {
                    return eVarC;
                }
                if (eVarC == eVar) {
                    return b();
                }
                eVar = eVarC;
            }
        }

        void a() {
            ReentrantLock reentrantLock = d.this.f32653e;
            reentrantLock.lock();
            try {
                e<E> eVarD = d(this.f32656a);
                this.f32656a = eVarD;
                this.f32657b = eVarD == null ? null : eVarD.f32662a;
            } finally {
                reentrantLock.unlock();
            }
        }

        abstract e<E> b();

        abstract e<E> c(e<E> eVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f32656a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            e<E> eVar = this.f32656a;
            if (eVar == null) {
                throw new NoSuchElementException();
            }
            this.f32658c = eVar;
            E e8 = this.f32657b;
            a();
            return e8;
        }

        @Override // java.util.Iterator
        public void remove() {
            e<E> eVar = this.f32658c;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            this.f32658c = null;
            ReentrantLock reentrantLock = d.this.f32653e;
            reentrantLock.lock();
            try {
                if (eVar.f32662a != null) {
                    d.this.d(eVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private class c extends d<E>.b {
        private c() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.d.b
        e<E> b() {
            return d.this.f32650b;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.d.b
        e<E> c(e<E> eVar) {
            return eVar.f32663b;
        }
    }

    /* JADX INFO: renamed from: com.nostra13.universalimageloader.core.assist.deque.d$d, reason: collision with other inner class name */
    private class C0398d extends d<E>.b {
        private C0398d() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.d.b
        e<E> b() {
            return d.this.f32649a;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.d.b
        e<E> c(e<E> eVar) {
            return eVar.f32664c;
        }
    }

    static final class e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        E f32662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<E> f32663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<E> f32664c;

        e(E e8) {
            this.f32662a = e8;
        }
    }

    public d() {
        this(Integer.MAX_VALUE);
    }

    private boolean a(e<E> eVar) {
        int i7 = this.f32651c;
        if (i7 >= this.f32652d) {
            return false;
        }
        e<E> eVar2 = this.f32649a;
        eVar.f32664c = eVar2;
        this.f32649a = eVar;
        if (this.f32650b == null) {
            this.f32650b = eVar;
        } else {
            eVar2.f32663b = eVar;
        }
        this.f32651c = i7 + 1;
        this.f32654f.signal();
        return true;
    }

    private boolean b(e<E> eVar) {
        int i7 = this.f32651c;
        if (i7 >= this.f32652d) {
            return false;
        }
        e<E> eVar2 = this.f32650b;
        eVar.f32663b = eVar2;
        this.f32650b = eVar;
        if (this.f32649a == null) {
            this.f32649a = eVar;
        } else {
            eVar2.f32664c = eVar;
        }
        this.f32651c = i7 + 1;
        this.f32654f.signal();
        return true;
    }

    private E f() {
        e<E> eVar = this.f32649a;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f32664c;
        E e8 = eVar.f32662a;
        eVar.f32662a = null;
        eVar.f32664c = eVar;
        this.f32649a = eVar2;
        if (eVar2 == null) {
            this.f32650b = null;
        } else {
            eVar2.f32663b = null;
        }
        this.f32651c--;
        this.f32655g.signal();
        return e8;
    }

    private E g() {
        e<E> eVar = this.f32650b;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f32663b;
        E e8 = eVar.f32662a;
        eVar.f32662a = null;
        eVar.f32663b = eVar;
        this.f32650b = eVar2;
        if (eVar2 == null) {
            this.f32649a = null;
        } else {
            eVar2.f32664c = null;
        }
        this.f32651c--;
        this.f32655g.signal();
        return e8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f32651c = 0;
        this.f32649a = null;
        this.f32650b = null;
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                add(object);
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.f32649a; eVar != null; eVar = eVar.f32664c) {
                objectOutputStream.writeObject(eVar.f32662a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean add(E e8) {
        addLast(e8);
        return true;
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public void addFirst(E e8) {
        if (!offerFirst(e8)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public void addLast(E e8) {
        if (!offerLast(e8)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f32649a;
            while (eVar != null) {
                eVar.f32662a = null;
                e<E> eVar2 = eVar.f32664c;
                eVar.f32663b = null;
                eVar.f32664c = null;
                eVar = eVar2;
            }
            this.f32650b = null;
            this.f32649a = null;
            this.f32651c = 0;
            this.f32655g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.f32649a; eVar != null; eVar = eVar.f32664c) {
                if (obj.equals(eVar.f32662a)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    void d(e<E> eVar) {
        e<E> eVar2 = eVar.f32663b;
        e<E> eVar3 = eVar.f32664c;
        if (eVar2 == null) {
            f();
            return;
        }
        if (eVar3 == null) {
            g();
            return;
        }
        eVar2.f32664c = eVar3;
        eVar3.f32663b = eVar2;
        eVar.f32662a = null;
        this.f32651c--;
        this.f32655g.signal();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public Iterator<E> descendingIterator() {
        return new c();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E element() {
        return getFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E getFirst() {
        E ePeekFirst = peekFirst();
        if (ePeekFirst != null) {
            return ePeekFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E getLast() {
        E ePeekLast = peekLast();
        if (ePeekLast != null) {
            return ePeekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public Iterator<E> iterator() {
        return new C0398d();
    }

    public boolean offer(E e8) {
        return offerLast(e8);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean offerFirst(E e8) {
        e8.getClass();
        e<E> eVar = new e<>(e8);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            return a(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean offerLast(E e8) {
        e8.getClass();
        e<E> eVar = new e<>(e8);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            return b(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E peek() {
        return peekFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E peekFirst() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f32649a;
            return eVar == null ? null : eVar.f32662a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E peekLast() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f32650b;
            return eVar == null ? null : eVar.f32662a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E poll() {
        return pollFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E pollFirst() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            return f();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E pollLast() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            return g();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E pop() {
        return removeFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public void push(E e8) {
        addFirst(e8);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public void put(E e8) throws InterruptedException {
        putLast(e8);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public void putFirst(E e8) throws InterruptedException {
        e8.getClass();
        e<E> eVar = new e<>(e8);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        while (!a(eVar)) {
            try {
                this.f32655g.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public void putLast(E e8) throws InterruptedException {
        e8.getClass();
        e<E> eVar = new e<>(e8);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        while (!b(eVar)) {
            try {
                this.f32655g.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            return this.f32652d - this.f32651c;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public E remove() {
        return removeFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E removeFirst() {
        E ePollFirst = pollFirst();
        if (ePollFirst != null) {
            return ePollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.f32649a; eVar != null; eVar = eVar.f32664c) {
                if (obj.equals(eVar.f32662a)) {
                    d(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    public E removeLast() {
        E ePollLast = pollLast();
        if (ePollLast != null) {
            return ePollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.f32650b; eVar != null; eVar = eVar.f32663b) {
                if (obj.equals(eVar.f32662a)) {
                    d(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public int size() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            return this.f32651c;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return takeFirst();
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        while (true) {
            try {
                E eF = f();
                if (eF != null) {
                    reentrantLock.unlock();
                    return eF;
                }
                this.f32654f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        while (true) {
            try {
                E eG = g();
                if (eG != null) {
                    reentrantLock.unlock();
                    return eG;
                }
                this.f32654f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f32651c];
            e<E> eVar = this.f32649a;
            int i7 = 0;
            while (eVar != null) {
                int i8 = i7 + 1;
                objArr[i7] = eVar.f32662a;
                eVar = eVar.f32664c;
                i7 = i8;
            }
            reentrantLock.unlock();
            return objArr;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            e<E> eVar = this.f32649a;
            if (eVar == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = eVar.f32662a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                eVar = eVar.f32664c;
                if (eVar == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public d(int i7) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f32653e = reentrantLock;
        this.f32654f = reentrantLock.newCondition();
        this.f32655g = reentrantLock.newCondition();
        if (i7 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f32652d = i7;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i7) {
        collection.getClass();
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            int iMin = Math.min(i7, this.f32651c);
            for (int i8 = 0; i8 < iMin; i8++) {
                collection.add(this.f32649a.f32662a);
                f();
            }
            reentrantLock.unlock();
            return iMin;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public boolean offer(E e8, long j7, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e8, j7, timeUnit);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue
    public E poll(long j7, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j7, timeUnit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public E pollFirst(long j7, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j7);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eF = f();
                if (eF != null) {
                    reentrantLock.unlock();
                    return eF;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.f32654f.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public E pollLast(long j7, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j7);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eG = g();
                if (eG != null) {
                    reentrantLock.unlock();
                    return eG;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.f32654f.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public boolean offerFirst(E e8, long j7, TimeUnit timeUnit) throws InterruptedException {
        e8.getClass();
        e<E> eVar = new e<>(e8);
        long nanos = timeUnit.toNanos(j7);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lockInterruptibly();
        while (!a(eVar)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.f32655g.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.a
    public boolean offerLast(E e8, long j7, TimeUnit timeUnit) throws InterruptedException {
        e8.getClass();
        e<E> eVar = new e<>(e8);
        long nanos = timeUnit.toNanos(j7);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lockInterruptibly();
        while (!b(eVar)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.f32655g.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public d(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            for (E e8 : collection) {
                if (e8 != null) {
                    if (!b(new e<>(e8))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f32653e;
        reentrantLock.lock();
        try {
            if (tArr.length < this.f32651c) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f32651c));
            }
            e<E> eVar = this.f32649a;
            int i7 = 0;
            while (eVar != null) {
                tArr[i7] = eVar.f32662a;
                eVar = eVar.f32664c;
                i7++;
            }
            if (tArr.length > i7) {
                tArr[i7] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }
}
