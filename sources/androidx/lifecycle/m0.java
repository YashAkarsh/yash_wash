package androidx.lifecycle;

import android.app.Application;
import c.x0;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final p0 f8327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final b f8328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final v.a f8329c;

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        public static final a f8336a = a.f8337a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ a f8337a = new a();

            private a() {
            }

            @a7.d
            @h5.l
            public final b a(@a7.d v.g<?>... initializers) {
                kotlin.jvm.internal.l0.p(initializers, "initializers");
                return new v.b((v.g[]) Arrays.copyOf(initializers, initializers.length));
            }
        }

        @a7.d
        <T extends k0> T a(@a7.d Class<T> cls);

        @a7.d
        <T extends k0> T b(@a7.d Class<T> cls, @a7.d v.a aVar);
    }

    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.e
        private static c f8339c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public static final a f8338b = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public static final v.a.b<String> f8340d = a.C0102a.f8341a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.m0$c$a$a, reason: collision with other inner class name */
            private static final class C0102a implements v.a.b<String> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                @a7.d
                public static final C0102a f8341a = new C0102a();

                private C0102a() {
                }
            }

            public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
                this();
            }

            @h5.l
            public static /* synthetic */ void b() {
            }

            @a7.d
            @x0({x0.a.LIBRARY_GROUP})
            public final c a() {
                if (c.f8339c == null) {
                    c.f8339c = new c();
                }
                c cVar = c.f8339c;
                kotlin.jvm.internal.l0.m(cVar);
                return cVar;
            }

            private a() {
            }
        }

        @a7.d
        @x0({x0.a.LIBRARY_GROUP})
        public static final c e() {
            return f8338b.a();
        }

        @Override // androidx.lifecycle.m0.b
        @a7.d
        public <T extends k0> T a(@a7.d Class<T> modelClass) {
            kotlin.jvm.internal.l0.p(modelClass, "modelClass");
            try {
                T tNewInstance = modelClass.newInstance();
                kotlin.jvm.internal.l0.o(tNewInstance, "{\n                modelC…wInstance()\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e8);
            } catch (InstantiationException e9) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e9);
            }
        }

        @Override // androidx.lifecycle.m0.b
        public /* synthetic */ k0 b(Class cls, v.a aVar) {
            return n0.b(this, cls, aVar);
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static class d {
        public void c(@a7.d k0 viewModel) {
            kotlin.jvm.internal.l0.p(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @h5.i
    public m0(@a7.d p0 store, @a7.d b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.l0.p(store, "store");
        kotlin.jvm.internal.l0.p(factory, "factory");
    }

    @a7.d
    @c.j0
    public <T extends k0> T a(@a7.d Class<T> modelClass) {
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @a7.d
    @c.j0
    public <T extends k0> T b(@a7.d String key, @a7.d Class<T> modelClass) {
        T t7;
        kotlin.jvm.internal.l0.p(key, "key");
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        T viewModel = (T) this.f8327a.b(key);
        if (!modelClass.isInstance(viewModel)) {
            v.e eVar = new v.e(this.f8329c);
            eVar.c(c.f8340d, key);
            try {
                t7 = (T) this.f8328b.b(modelClass, eVar);
            } catch (AbstractMethodError unused) {
                t7 = (T) this.f8328b.a(modelClass);
            }
            this.f8327a.d(key, t7);
            return t7;
        }
        Object obj = this.f8328b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            kotlin.jvm.internal.l0.o(viewModel, "viewModel");
            dVar.c(viewModel);
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
    }

    public static class a extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @a7.d
        public static final String f8331g = "androidx.lifecycle.ViewModelProvider.DefaultKey";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @a7.e
        private static a f8332h;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.e
        private final Application f8334e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.d
        public static final C0100a f8330f = new C0100a(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @a7.d
        @h5.e
        public static final v.a.b<Application> f8333i = C0100a.C0101a.f8335a;

        /* JADX INFO: renamed from: androidx.lifecycle.m0$a$a, reason: collision with other inner class name */
        public static final class C0100a {

            /* JADX INFO: renamed from: androidx.lifecycle.m0$a$a$a, reason: collision with other inner class name */
            private static final class C0101a implements v.a.b<Application> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                @a7.d
                public static final C0101a f8335a = new C0101a();

                private C0101a() {
                }
            }

            public /* synthetic */ C0100a(kotlin.jvm.internal.w wVar) {
                this();
            }

            @a7.d
            public final b a(@a7.d q0 owner) {
                kotlin.jvm.internal.l0.p(owner, "owner");
                if (!(owner instanceof l)) {
                    return c.f8338b.a();
                }
                b defaultViewModelProviderFactory = ((l) owner).getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.l0.o(defaultViewModelProviderFactory, "owner.defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }

            @a7.d
            @h5.l
            public final a b(@a7.d Application application) {
                kotlin.jvm.internal.l0.p(application, "application");
                if (a.f8332h == null) {
                    a.f8332h = new a(application);
                }
                a aVar = a.f8332h;
                kotlin.jvm.internal.l0.m(aVar);
                return aVar;
            }

            private C0100a() {
            }
        }

        private a(Application application, int i7) {
            this.f8334e = application;
        }

        private final <T extends k0> T h(Class<T> cls, Application application) {
            if (!androidx.lifecycle.b.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                T tNewInstance = cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.l0.o(tNewInstance, "{\n                try {\n…          }\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            } catch (InstantiationException e9) {
                throw new RuntimeException("Cannot create an instance of " + cls, e9);
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            }
        }

        @a7.d
        @h5.l
        public static final a i(@a7.d Application application) {
            return f8330f.b(application);
        }

        @Override // androidx.lifecycle.m0.c, androidx.lifecycle.m0.b
        @a7.d
        public <T extends k0> T a(@a7.d Class<T> modelClass) {
            kotlin.jvm.internal.l0.p(modelClass, "modelClass");
            Application application = this.f8334e;
            if (application != null) {
                return (T) h(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.m0.c, androidx.lifecycle.m0.b
        @a7.d
        public <T extends k0> T b(@a7.d Class<T> modelClass, @a7.d v.a extras) {
            kotlin.jvm.internal.l0.p(modelClass, "modelClass");
            kotlin.jvm.internal.l0.p(extras, "extras");
            if (this.f8334e != null) {
                return (T) a(modelClass);
            }
            Application application = (Application) extras.a(f8333i);
            if (application != null) {
                return (T) h(modelClass, application);
            }
            if (androidx.lifecycle.b.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.a(modelClass);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@a7.d Application application) {
            this(application, 0);
            kotlin.jvm.internal.l0.p(application, "application");
        }
    }

    @h5.i
    public m0(@a7.d p0 store, @a7.d b factory, @a7.d v.a defaultCreationExtras) {
        kotlin.jvm.internal.l0.p(store, "store");
        kotlin.jvm.internal.l0.p(factory, "factory");
        kotlin.jvm.internal.l0.p(defaultCreationExtras, "defaultCreationExtras");
        this.f8327a = store;
        this.f8328b = factory;
        this.f8329c = defaultCreationExtras;
    }

    public /* synthetic */ m0(p0 p0Var, b bVar, v.a aVar, int i7, kotlin.jvm.internal.w wVar) {
        this(p0Var, bVar, (i7 & 4) != 0 ? v.a.C0550a.f40425b : aVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m0(@a7.d q0 owner) {
        kotlin.jvm.internal.l0.p(owner, "owner");
        p0 viewModelStore = owner.getViewModelStore();
        kotlin.jvm.internal.l0.o(viewModelStore, "owner.viewModelStore");
        this(viewModelStore, a.f8330f.a(owner), o0.a(owner));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m0(@a7.d q0 owner, @a7.d b factory) {
        kotlin.jvm.internal.l0.p(owner, "owner");
        kotlin.jvm.internal.l0.p(factory, "factory");
        p0 viewModelStore = owner.getViewModelStore();
        kotlin.jvm.internal.l0.o(viewModelStore, "owner.viewModelStore");
        this(viewModelStore, factory, o0.a(owner));
    }
}
