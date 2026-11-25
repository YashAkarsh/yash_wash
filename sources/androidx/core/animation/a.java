package androidx.core.animation;

import android.animation.Animator;
import c.t0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.core.animation.a$a, reason: collision with other inner class name */
    public static final class C0050a extends n0 implements i5.l<Animator, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0050a f5032a = new C0050a();

        public C0050a() {
            super(1);
        }

        public final void b(@a7.d Animator it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Animator animator) {
            b(animator);
            return l2.f34958a;
        }
    }

    public static final class b extends n0 implements i5.l<Animator, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5033a = new b();

        public b() {
            super(1);
        }

        public final void b(@a7.d Animator it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Animator animator) {
            b(animator);
            return l2.f34958a;
        }
    }

    public static final class c extends n0 implements i5.l<Animator, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5034a = new c();

        public c() {
            super(1);
        }

        public final void b(@a7.d Animator it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Animator animator) {
            b(animator);
            return l2.f34958a;
        }
    }

    public static final class d extends n0 implements i5.l<Animator, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5035a = new d();

        public d() {
            super(1);
        }

        public final void b(@a7.d Animator it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Animator animator) {
            b(animator);
            return l2.f34958a;
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<Animator, l2> f5036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<Animator, l2> f5037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.l<Animator, l2> f5038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i5.l<Animator, l2> f5039d;

        /* JADX WARN: Multi-variable type inference failed */
        public e(i5.l<? super Animator, l2> lVar, i5.l<? super Animator, l2> lVar2, i5.l<? super Animator, l2> lVar3, i5.l<? super Animator, l2> lVar4) {
            this.f5036a = lVar;
            this.f5037b = lVar2;
            this.f5038c = lVar3;
            this.f5039d = lVar4;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5038c.z(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5037b.z(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5036a.z(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5039d.z(animator);
        }
    }

    public static final class f extends n0 implements i5.l<Animator, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f5040a = new f();

        public f() {
            super(1);
        }

        public final void b(@a7.d Animator it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Animator animator) {
            b(animator);
            return l2.f34958a;
        }
    }

    public static final class g extends n0 implements i5.l<Animator, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f5041a = new g();

        public g() {
            super(1);
        }

        public final void b(@a7.d Animator it) {
            l0.p(it, "it");
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Animator animator) {
            b(animator);
            return l2.f34958a;
        }
    }

    public static final class h implements Animator.AnimatorPauseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<Animator, l2> f5042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<Animator, l2> f5043b;

        /* JADX WARN: Multi-variable type inference failed */
        public h(i5.l<? super Animator, l2> lVar, i5.l<? super Animator, l2> lVar2) {
            this.f5042a = lVar;
            this.f5043b = lVar2;
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5042a.z(animator);
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5043b.z(animator);
        }
    }

    public static final class i implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f5044a;

        public i(i5.l lVar) {
            this.f5044a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5044a.z(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }
    }

    public static final class j implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f5045a;

        public j(i5.l lVar) {
            this.f5045a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5045a.z(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }
    }

    public static final class k implements Animator.AnimatorPauseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f5046a;

        public k(i5.l lVar) {
            this.f5046a = lVar;
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5046a.z(animator);
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }
    }

    public static final class l implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f5047a;

        public l(i5.l lVar) {
            this.f5047a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5047a.z(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }
    }

    public static final class m implements Animator.AnimatorPauseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f5048a;

        public m(i5.l lVar) {
            this.f5048a = lVar;
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5048a.z(animator);
        }
    }

    public static final class n implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f5049a;

        public n(i5.l lVar) {
            this.f5049a = lVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@a7.d Animator animator) {
            l0.p(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@a7.d Animator animator) {
            l0.p(animator, "animator");
            this.f5049a.z(animator);
        }
    }

    @a7.d
    public static final Animator.AnimatorListener a(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> onEnd, @a7.d i5.l<? super Animator, l2> onStart, @a7.d i5.l<? super Animator, l2> onCancel, @a7.d i5.l<? super Animator, l2> onRepeat) {
        l0.p(animator, "<this>");
        l0.p(onEnd, "onEnd");
        l0.p(onStart, "onStart");
        l0.p(onCancel, "onCancel");
        l0.p(onRepeat, "onRepeat");
        e eVar = new e(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(eVar);
        return eVar;
    }

    public static /* synthetic */ Animator.AnimatorListener b(Animator animator, i5.l onEnd, i5.l onStart, i5.l onCancel, i5.l onRepeat, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            onEnd = C0050a.f5032a;
        }
        if ((i7 & 2) != 0) {
            onStart = b.f5033a;
        }
        if ((i7 & 4) != 0) {
            onCancel = c.f5034a;
        }
        if ((i7 & 8) != 0) {
            onRepeat = d.f5035a;
        }
        l0.p(animator, "<this>");
        l0.p(onEnd, "onEnd");
        l0.p(onStart, "onStart");
        l0.p(onCancel, "onCancel");
        l0.p(onRepeat, "onRepeat");
        e eVar = new e(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(eVar);
        return eVar;
    }

    @a7.d
    @t0(19)
    public static final Animator.AnimatorPauseListener c(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> onResume, @a7.d i5.l<? super Animator, l2> onPause) {
        l0.p(animator, "<this>");
        l0.p(onResume, "onResume");
        l0.p(onPause, "onPause");
        h hVar = new h(onPause, onResume);
        animator.addPauseListener(hVar);
        return hVar;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener d(Animator animator, i5.l onResume, i5.l onPause, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            onResume = f.f5040a;
        }
        if ((i7 & 2) != 0) {
            onPause = g.f5041a;
        }
        l0.p(animator, "<this>");
        l0.p(onResume, "onResume");
        l0.p(onPause, "onPause");
        h hVar = new h(onPause, onResume);
        animator.addPauseListener(hVar);
        return hVar;
    }

    @a7.d
    public static final Animator.AnimatorListener e(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> action) {
        l0.p(animator, "<this>");
        l0.p(action, "action");
        i iVar = new i(action);
        animator.addListener(iVar);
        return iVar;
    }

    @a7.d
    public static final Animator.AnimatorListener f(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> action) {
        l0.p(animator, "<this>");
        l0.p(action, "action");
        j jVar = new j(action);
        animator.addListener(jVar);
        return jVar;
    }

    @a7.d
    @t0(19)
    public static final Animator.AnimatorPauseListener g(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> action) {
        l0.p(animator, "<this>");
        l0.p(action, "action");
        k kVar = new k(action);
        animator.addPauseListener(kVar);
        return kVar;
    }

    @a7.d
    public static final Animator.AnimatorListener h(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> action) {
        l0.p(animator, "<this>");
        l0.p(action, "action");
        l lVar = new l(action);
        animator.addListener(lVar);
        return lVar;
    }

    @a7.d
    @t0(19)
    public static final Animator.AnimatorPauseListener i(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> action) {
        l0.p(animator, "<this>");
        l0.p(action, "action");
        m mVar = new m(action);
        animator.addPauseListener(mVar);
        return mVar;
    }

    @a7.d
    public static final Animator.AnimatorListener j(@a7.d Animator animator, @a7.d i5.l<? super Animator, l2> action) {
        l0.p(animator, "<this>");
        l0.p(action, "action");
        n nVar = new n(action);
        animator.addListener(nVar);
        return nVar;
    }
}
