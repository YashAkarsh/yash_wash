package com.haier.uhome.usdk.base.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.haier.library.common.util.o;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f31255a = 1024;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f31256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<a>> f31257c;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f31261a = new c();

        private b() {
        }
    }

    public static c a() {
        return b.f31261a;
    }

    private Map<Class<?>, List<a>> e(Object obj) {
        HashMap map = new HashMap(8);
        for (Method method : f(obj)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1) {
                e3.a.v("EventBus: parameter types length not support!", new Object[0]);
            } else {
                Class<?> cls = parameterTypes[0];
                List arrayList = (List) map.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(cls, arrayList);
                }
                arrayList.add(new a(method, obj, ((com.haier.uhome.usdk.base.annotation.d) method.getAnnotation(com.haier.uhome.usdk.base.annotation.d.class)).a()));
            }
        }
        return map;
    }

    private List<Method> f(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = g(obj).iterator();
        while (it.hasNext()) {
            for (Method method : it.next().getDeclaredMethods()) {
                if (method.isAnnotationPresent(com.haier.uhome.usdk.base.annotation.d.class) && !method.isSynthetic()) {
                    arrayList.add(method);
                }
            }
        }
        return arrayList;
    }

    private Set<Class<?>> g(Object obj) {
        HashSet hashSet = new HashSet();
        Class<?> cls = obj.getClass();
        hashSet.add(cls);
        a(hashSet, cls.getSuperclass());
        return hashSet;
    }

    private void h(Object obj) {
        if (this.f31257c.isEmpty()) {
            e3.a.v("EventBus: target list empty!", new Object[0]);
            return;
        }
        CopyOnWriteArraySet<a> copyOnWriteArraySet = this.f31257c.get(obj.getClass());
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            e3.a.v("EventBus: target object not register!", new Object[0]);
            return;
        }
        Iterator<a> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            it.next().a(obj);
        }
    }

    public void b(Object obj) {
        if (obj == null) {
            e3.a.v("EventBus: target object is null when unregister!", new Object[0]);
            return;
        }
        for (Map.Entry<Class<?>, List<a>> entry : e(obj).entrySet()) {
            Class<?> key = entry.getKey();
            List<a> value = entry.getValue();
            CopyOnWriteArraySet<a> copyOnWriteArraySet = this.f31257c.get(key);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(value)) {
                e3.a.v("EventBus: missing event subscriber for an annotated method. Is %s registered?", obj);
            } else if (copyOnWriteArraySet.isEmpty()) {
                this.f31257c.remove(key);
            }
        }
    }

    public void c(Object obj) {
        a(obj, 0L);
    }

    public void d(Object obj) {
        if (obj == null) {
            e3.a.v("EventBus: origin event is null!", new Object[0]);
        } else if (obj instanceof Runnable) {
            this.f31256b.removeCallbacks((Runnable) obj);
        } else {
            this.f31256b.removeMessages(1024, obj);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return false;
        }
        h(message.obj);
        return false;
    }

    private c() {
        this.f31257c = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread("#EventBus");
        handlerThread.start();
        this.f31256b = new Handler(handlerThread.getLooper(), this);
    }

    public void a(Object obj) {
        if (obj == null) {
            e3.a.v("EventBus: target object is null when register!", new Object[0]);
            return;
        }
        for (Map.Entry<Class<?>, List<a>> entry : e(obj).entrySet()) {
            Class<?> key = entry.getKey();
            List<a> value = entry.getValue();
            CopyOnWriteArraySet<a> copyOnWriteArraySet = this.f31257c.get(key);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet<a> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
                copyOnWriteArraySet = (CopyOnWriteArraySet) o.a(this.f31257c.putIfAbsent(key, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(value);
        }
    }

    private static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f31258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f31259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Integer f31260c;

        a(Method method, Object obj, int i7) {
            this.f31258a = method;
            this.f31259b = obj;
            this.f31260c = Integer.valueOf(i7);
        }

        void a(Object... objArr) {
            try {
                if (!this.f31258a.isAccessible()) {
                    this.f31258a.setAccessible(true);
                }
                this.f31258a.invoke(this.f31259b, objArr);
            } catch (Exception e8) {
                e3.a.h("EventBus: target = %s method = %s args = %s invoked error %s", this.f31259b, this.f31258a.getName(), objArr, e8.getMessage());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.f31258a, aVar.f31258a) && Objects.equals(this.f31259b, aVar.f31259b) && Objects.equals(this.f31260c, aVar.f31260c);
        }

        public int hashCode() {
            return Objects.hash(this.f31258a, this.f31259b, this.f31260c);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return a(aVar.f31260c.intValue(), this.f31260c.intValue());
        }

        static int a(int i7, int i8) {
            return Integer.compare(i7, i8);
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j7) {
        a(runnable, j7, TimeUnit.MILLISECONDS);
    }

    public void a(Runnable runnable, long j7, TimeUnit timeUnit) {
        this.f31256b.postDelayed(runnable, timeUnit.toMillis(j7));
    }

    public void a(Object obj, long j7) {
        a(obj, j7, TimeUnit.MILLISECONDS);
    }

    public void a(Object obj, long j7, TimeUnit timeUnit) {
        Message messageObtainMessage = this.f31256b.obtainMessage();
        messageObtainMessage.obj = obj;
        messageObtainMessage.what = 1024;
        this.f31256b.sendMessageDelayed(messageObtainMessage, timeUnit.toMillis(j7));
    }

    private void a(Set<Class<?>> set, Class<?> cls) {
        if (cls == null) {
            return;
        }
        set.add(cls);
        a(set, cls.getSuperclass());
    }
}
