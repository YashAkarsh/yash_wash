package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class se {

    static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f21069a;

        void a(T t7, int i7) {
            try {
                this.f21069a.set(t7, Integer.valueOf(i7));
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            }
        }

        void b(T t7, Object obj) {
            try {
                this.f21069a.set(t7, obj);
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            }
        }

        private b(Field field) {
            this.f21069a = field;
            field.setAccessible(true);
        }
    }

    private se() {
    }

    static <T> b<T> a(Class<T> cls, String str) {
        try {
            return new b<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e8) {
            throw new AssertionError(e8);
        }
    }

    static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i7) throws IOException, ClassNotFoundException {
        for (int i8 = 0; i8 < i7; i8++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    static <K, V> void d(tc<K, V> tcVar, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(tcVar, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void e(tc<K, V> tcVar, ObjectInputStream objectInputStream, int i7) throws IOException, ClassNotFoundException {
        for (int i8 = 0; i8 < i7; i8++) {
            Collection collection = tcVar.get(objectInputStream.readObject());
            int i9 = objectInputStream.readInt();
            for (int i10 = 0; i10 < i9; i10++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    static <E> void f(hd<E> hdVar, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(hdVar, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> void g(hd<E> hdVar, ObjectInputStream objectInputStream, int i7) throws IOException, ClassNotFoundException {
        for (int i8 = 0; i8 < i7; i8++) {
            hdVar.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static int h(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    static <K, V> void j(tc<K, V> tcVar, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(tcVar.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : tcVar.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    static <E> void k(hd<E> hdVar, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(hdVar.entrySet().size());
        for (hd.a<E> aVar : hdVar.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
