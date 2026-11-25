package androidx.core.transition;

import android.annotation.SuppressLint;
import android.transition.Transition;
import c.t0;
import i5.l;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class a {

    /* JADX INFO: renamed from: androidx.core.transition.a$a, reason: collision with other inner class name */
    public static final class C0075a extends n0 implements l<Transition, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0075a f6329a = new C0075a();

        public C0075a() {
            super(1);
        }

        public final void b(@a7.d Transition it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Transition transition) {
            b(transition);
            return l2.f34958a;
        }
    }

    public static final class b extends n0 implements l<Transition, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6330a = new b();

        public b() {
            super(1);
        }

        public final void b(@a7.d Transition it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Transition transition) {
            b(transition);
            return l2.f34958a;
        }
    }

    public static final class c extends n0 implements l<Transition, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6331a = new c();

        public c() {
            super(1);
        }

        public final void b(@a7.d Transition it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Transition transition) {
            b(transition);
            return l2.f34958a;
        }
    }

    public static final class d extends n0 implements l<Transition, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6332a = new d();

        public d() {
            super(1);
        }

        public final void b(@a7.d Transition it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Transition transition) {
            b(transition);
            return l2.f34958a;
        }
    }

    public static final class e extends n0 implements l<Transition, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6333a = new e();

        public e() {
            super(1);
        }

        public final void b(@a7.d Transition it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Transition transition) {
            b(transition);
            return l2.f34958a;
        }
    }

    public static final class f implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l<Transition, l2> f6334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l<Transition, l2> f6335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<Transition, l2> f6336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ l<Transition, l2> f6337d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l<Transition, l2> f6338e;

        /* JADX WARN: Multi-variable type inference failed */
        public f(l<? super Transition, l2> lVar, l<? super Transition, l2> lVar2, l<? super Transition, l2> lVar3, l<? super Transition, l2> lVar4, l<? super Transition, l2> lVar5) {
            this.f6334a = lVar;
            this.f6335b = lVar2;
            this.f6336c = lVar3;
            this.f6337d = lVar4;
            this.f6338e = lVar5;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6337d.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6334a.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6336c.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6335b.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6338e.z(transition);
        }
    }

    public static final class g implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6339a;

        public g(l lVar) {
            this.f6339a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6339a.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }
    }

    public static final class h implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6340a;

        public h(l lVar) {
            this.f6340a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6340a.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }
    }

    public static final class i implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6341a;

        public i(l lVar) {
            this.f6341a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6341a.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }
    }

    public static final class j implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6342a;

        public j(l lVar) {
            this.f6342a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6342a.z(transition);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }
    }

    public static final class k implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6343a;

        public k(l lVar) {
            this.f6343a = lVar;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(@a7.d Transition transition) {
            l0.p(transition, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(@a7.d Transition transition) {
            l0.p(transition, "transition");
            this.f6343a.z(transition);
        }
    }

    @a7.d
    @t0(19)
    public static final Transition.TransitionListener a(@a7.d Transition transition, @a7.d l<? super Transition, l2> onEnd, @a7.d l<? super Transition, l2> onStart, @a7.d l<? super Transition, l2> onCancel, @a7.d l<? super Transition, l2> onResume, @a7.d l<? super Transition, l2> onPause) {
        l0.p(transition, "<this>");
        l0.p(onEnd, "onEnd");
        l0.p(onStart, "onStart");
        l0.p(onCancel, "onCancel");
        l0.p(onResume, "onResume");
        l0.p(onPause, "onPause");
        f fVar = new f(onEnd, onResume, onPause, onCancel, onStart);
        transition.addListener(fVar);
        return fVar;
    }

    public static /* synthetic */ Transition.TransitionListener b(Transition transition, l onEnd, l lVar, l lVar2, l onResume, l onPause, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            onEnd = C0075a.f6329a;
        }
        if ((i7 & 2) != 0) {
            lVar = b.f6330a;
        }
        l onStart = lVar;
        if ((i7 & 4) != 0) {
            lVar2 = c.f6331a;
        }
        l onCancel = lVar2;
        if ((i7 & 8) != 0) {
            onResume = d.f6332a;
        }
        if ((i7 & 16) != 0) {
            onPause = e.f6333a;
        }
        l0.p(transition, "<this>");
        l0.p(onEnd, "onEnd");
        l0.p(onStart, "onStart");
        l0.p(onCancel, "onCancel");
        l0.p(onResume, "onResume");
        l0.p(onPause, "onPause");
        f fVar = new f(onEnd, onResume, onPause, onCancel, onStart);
        transition.addListener(fVar);
        return fVar;
    }

    @a7.d
    @t0(19)
    public static final Transition.TransitionListener c(@a7.d Transition transition, @a7.d l<? super Transition, l2> action) {
        l0.p(transition, "<this>");
        l0.p(action, "action");
        g gVar = new g(action);
        transition.addListener(gVar);
        return gVar;
    }

    @a7.d
    @t0(19)
    public static final Transition.TransitionListener d(@a7.d Transition transition, @a7.d l<? super Transition, l2> action) {
        l0.p(transition, "<this>");
        l0.p(action, "action");
        h hVar = new h(action);
        transition.addListener(hVar);
        return hVar;
    }

    @a7.d
    @t0(19)
    public static final Transition.TransitionListener e(@a7.d Transition transition, @a7.d l<? super Transition, l2> action) {
        l0.p(transition, "<this>");
        l0.p(action, "action");
        i iVar = new i(action);
        transition.addListener(iVar);
        return iVar;
    }

    @a7.d
    @t0(19)
    public static final Transition.TransitionListener f(@a7.d Transition transition, @a7.d l<? super Transition, l2> action) {
        l0.p(transition, "<this>");
        l0.p(action, "action");
        j jVar = new j(action);
        transition.addListener(jVar);
        return jVar;
    }

    @a7.d
    @t0(19)
    public static final Transition.TransitionListener g(@a7.d Transition transition, @a7.d l<? super Transition, l2> action) {
        l0.p(transition, "<this>");
        l0.p(action, "action");
        k kVar = new k(action);
        transition.addListener(kVar);
        return kVar;
    }
}
