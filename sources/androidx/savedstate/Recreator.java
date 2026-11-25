package androidx.savedstate;

import android.os.Bundle;
import androidx.core.app.l2;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes.dex */
@i0(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0002\f\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/o;", "", "className", "Lkotlin/l2;", "h", "Landroidx/lifecycle/q;", ShareConstants.FEED_SOURCE_PARAM, "Landroidx/lifecycle/m$b;", l2.f5216t0, "g", "Landroidx/savedstate/d;", "a", "Landroidx/savedstate/d;", "owner", "<init>", "(Landroidx/savedstate/d;)V", "b", "savedstate_release"}, k = 1, mv = {1, 6, 0})
public final class Recreator implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f9752b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final String f9753c = "classes_to_restore";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final String f9754d = "androidx.savedstate.Restarter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d f9755a;

    public static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements androidx.savedstate.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Set<String> f9756a;

        public b(@a7.d androidx.savedstate.b registry) {
            l0.p(registry, "registry");
            this.f9756a = new LinkedHashSet();
            registry.j(Recreator.f9754d, this);
        }

        @Override // androidx.savedstate.b.c
        @a7.d
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(Recreator.f9753c, new ArrayList<>(this.f9756a));
            return bundle;
        }

        public final void b(@a7.d String className) {
            l0.p(className, "className");
            this.f9756a.add(className);
        }
    }

    public Recreator(@a7.d d owner) {
        l0.p(owner, "owner");
        this.f9755a = owner;
    }

    private final void h(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(androidx.savedstate.b.a.class);
            l0.o(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                    l0.o(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((androidx.savedstate.b.a) objNewInstance).a(this.f9755a);
                } catch (Exception e8) {
                    throw new RuntimeException("Failed to instantiate " + str, e8);
                }
            } catch (NoSuchMethodException e9) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e9);
            }
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Class " + str + " wasn't found", e10);
        }
    }

    @Override // androidx.lifecycle.o
    public void g(@a7.d q source, @a7.d m.b event) {
        l0.p(source, "source");
        l0.p(event, "event");
        if (event != m.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().c(this);
        Bundle bundleB = this.f9755a.getSavedStateRegistry().b(f9754d);
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList(f9753c);
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }
}
