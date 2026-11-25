package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.i;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import c.j0;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f583i = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f584j = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f585k = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f586l = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f587m = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f588n = "ActivityResultRegistry";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f589o = 65536;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Random f590a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f591b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<String, Integer> f592c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, d> f593d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<String> f594e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient Map<String, c<?>> f595f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Map<String, Object> f596g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Bundle f597h = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    class a<I> extends androidx.activity.result.c<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f603b;

        a(String str, b.a aVar) {
            this.f602a = str;
            this.f603b = aVar;
        }

        @Override // androidx.activity.result.c
        @m0
        public b.a<I, ?> a() {
            return this.f603b;
        }

        @Override // androidx.activity.result.c
        public void c(I i7, @o0 i iVar) throws Exception {
            Integer num = ActivityResultRegistry.this.f592c.get(this.f602a);
            if (num != null) {
                ActivityResultRegistry.this.f594e.add(this.f602a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f603b, i7, iVar);
                    return;
                } catch (Exception e8) {
                    ActivityResultRegistry.this.f594e.remove(this.f602a);
                    throw e8;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f603b + " and input " + i7 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void d() {
            ActivityResultRegistry.this.l(this.f602a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    class b<I> extends androidx.activity.result.c<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f606b;

        b(String str, b.a aVar) {
            this.f605a = str;
            this.f606b = aVar;
        }

        @Override // androidx.activity.result.c
        @m0
        public b.a<I, ?> a() {
            return this.f606b;
        }

        @Override // androidx.activity.result.c
        public void c(I i7, @o0 i iVar) throws Exception {
            Integer num = ActivityResultRegistry.this.f592c.get(this.f605a);
            if (num != null) {
                ActivityResultRegistry.this.f594e.add(this.f605a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f606b, i7, iVar);
                    return;
                } catch (Exception e8) {
                    ActivityResultRegistry.this.f594e.remove(this.f605a);
                    throw e8;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f606b + " and input " + i7 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void d() {
            ActivityResultRegistry.this.l(this.f605a);
        }
    }

    private static class c<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.activity.result.a<O> f608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b.a<?, O> f609b;

        c(androidx.activity.result.a<O> aVar, b.a<?, O> aVar2) {
            this.f608a = aVar;
            this.f609b = aVar2;
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final m f610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<o> f611b = new ArrayList<>();

        d(@m0 m mVar) {
            this.f610a = mVar;
        }

        void a(@m0 o oVar) {
            this.f610a.a(oVar);
            this.f611b.add(oVar);
        }

        void b() {
            Iterator<o> it = this.f611b.iterator();
            while (it.hasNext()) {
                this.f610a.c(it.next());
            }
            this.f611b.clear();
        }
    }

    private void a(int i7, String str) {
        this.f591b.put(Integer.valueOf(i7), str);
        this.f592c.put(str, Integer.valueOf(i7));
    }

    private <O> void d(String str, int i7, @o0 Intent intent, @o0 c<O> cVar) {
        if (cVar == null || cVar.f608a == null || !this.f594e.contains(str)) {
            this.f596g.remove(str);
            this.f597h.putParcelable(str, new ActivityResult(i7, intent));
        } else {
            cVar.f608a.a(cVar.f609b.c(i7, intent));
            this.f594e.remove(str);
        }
    }

    private int e() {
        int iNextInt = this.f590a.nextInt(2147418112);
        while (true) {
            int i7 = iNextInt + 65536;
            if (!this.f591b.containsKey(Integer.valueOf(i7))) {
                return i7;
            }
            iNextInt = this.f590a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (this.f592c.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    @j0
    public final boolean b(int i7, int i8, @o0 Intent intent) {
        String str = this.f591b.get(Integer.valueOf(i7));
        if (str == null) {
            return false;
        }
        d(str, i8, intent, this.f595f.get(str));
        return true;
    }

    @j0
    public final <O> boolean c(int i7, @SuppressLint({"UnknownNullness"}) O o7) {
        androidx.activity.result.a<?> aVar;
        String str = this.f591b.get(Integer.valueOf(i7));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f595f.get(str);
        if (cVar == null || (aVar = cVar.f608a) == null) {
            this.f597h.remove(str);
            this.f596g.put(str, o7);
            return true;
        }
        if (!this.f594e.remove(str)) {
            return true;
        }
        aVar.a(o7);
        return true;
    }

    @j0
    public abstract <I, O> void f(int i7, @m0 b.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i8, @o0 i iVar);

    public final void g(@o0 Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f583i);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(f584j);
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f594e = bundle.getStringArrayList(f585k);
        this.f590a = (Random) bundle.getSerializable(f587m);
        this.f597h.putAll(bundle.getBundle(f586l));
        for (int i7 = 0; i7 < stringArrayList.size(); i7++) {
            String str = stringArrayList.get(i7);
            if (this.f592c.containsKey(str)) {
                Integer numRemove = this.f592c.remove(str);
                if (!this.f597h.containsKey(str)) {
                    this.f591b.remove(numRemove);
                }
            }
            a(integerArrayList.get(i7).intValue(), stringArrayList.get(i7));
        }
    }

    public final void h(@m0 Bundle bundle) {
        bundle.putIntegerArrayList(f583i, new ArrayList<>(this.f592c.values()));
        bundle.putStringArrayList(f584j, new ArrayList<>(this.f592c.keySet()));
        bundle.putStringArrayList(f585k, new ArrayList<>(this.f594e));
        bundle.putBundle(f586l, (Bundle) this.f597h.clone());
        bundle.putSerializable(f587m, this.f590a);
    }

    @m0
    public final <I, O> androidx.activity.result.c<I> i(@m0 final String str, @m0 q qVar, @m0 final b.a<I, O> aVar, @m0 final androidx.activity.result.a<O> aVar2) {
        m lifecycle = qVar.getLifecycle();
        if (lifecycle.b().a(m.c.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + qVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = this.f593d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new o() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.o
            public void g(@m0 q qVar2, @m0 m.b bVar) {
                if (!m.b.ON_START.equals(bVar)) {
                    if (m.b.ON_STOP.equals(bVar)) {
                        ActivityResultRegistry.this.f595f.remove(str);
                        return;
                    } else {
                        if (m.b.ON_DESTROY.equals(bVar)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f595f.put(str, new c<>(aVar2, aVar));
                if (ActivityResultRegistry.this.f596g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f596g.get(str);
                    ActivityResultRegistry.this.f596g.remove(str);
                    aVar2.a(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f597h.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f597h.remove(str);
                    aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
                }
            }
        });
        this.f593d.put(str, dVar);
        return new a(str, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m0
    public final <I, O> androidx.activity.result.c<I> j(@m0 String str, @m0 b.a<I, O> aVar, @m0 androidx.activity.result.a<O> aVar2) {
        k(str);
        this.f595f.put(str, new c<>(aVar2, aVar));
        if (this.f596g.containsKey(str)) {
            Object obj = this.f596g.get(str);
            this.f596g.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f597h.getParcelable(str);
        if (activityResult != null) {
            this.f597h.remove(str);
            aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
        }
        return new b(str, aVar);
    }

    @j0
    final void l(@m0 String str) {
        Integer numRemove;
        if (!this.f594e.contains(str) && (numRemove = this.f592c.remove(str)) != null) {
            this.f591b.remove(numRemove);
        }
        this.f595f.remove(str);
        if (this.f596g.containsKey(str)) {
            Log.w(f588n, "Dropping pending result for request " + str + ": " + this.f596g.get(str));
            this.f596g.remove(str);
        }
        if (this.f597h.containsKey(str)) {
            Log.w(f588n, "Dropping pending result for request " + str + ": " + this.f597h.getParcelable(str));
            this.f597h.remove(str);
        }
        d dVar = this.f593d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f593d.remove(str);
        }
    }
}
