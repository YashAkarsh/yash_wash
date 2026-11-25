package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public final class k4 {

    @kotlin.coroutines.jvm.internal.f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {406, 408}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
    static final class a extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super View>, kotlin.coroutines.d<? super kotlin.l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f6663d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f6664e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f6664e = view;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<kotlin.l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f6664e, dVar);
            aVar.f6663d = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.sequences.o oVar;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f6662c;
            if (i7 != 0) {
                if (i7 == 1) {
                    oVar = (kotlin.sequences.o) this.f6663d;
                    kotlin.e1.n(obj);
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.e1.n(obj);
                }
                return kotlin.l2.f34958a;
            }
            kotlin.e1.n(obj);
            oVar = (kotlin.sequences.o) this.f6663d;
            View view = this.f6664e;
            this.f6663d = oVar;
            this.f6662c = 1;
            if (oVar.a(view, this) == objH) {
                return objH;
            }
            View view2 = this.f6664e;
            if (view2 instanceof ViewGroup) {
                kotlin.sequences.m<View> mVarF = j4.f((ViewGroup) view2);
                this.f6663d = null;
                this.f6662c = 2;
                if (oVar.h(mVarF, this) == objH) {
                    return objH;
                }
            }
            return kotlin.l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super View> oVar, @a7.e kotlin.coroutines.d<? super kotlin.l2> dVar) {
            return ((a) D(oVar, dVar)).R(kotlin.l2.f34958a);
        }
    }

    /* synthetic */ class b extends kotlin.jvm.internal.h0 implements i5.l<ViewParent, ViewParent> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f6665j = new b();

        b() {
            super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
        }

        @Override // i5.l
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final ViewParent z(@a7.d ViewParent p7) {
            kotlin.jvm.internal.l0.p(p7, "p0");
            return p7.getParent();
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<View, kotlin.l2> f6667b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(View view, i5.l<? super View, kotlin.l2> lVar) {
            this.f6666a = view;
            this.f6667b = lVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@a7.d View view) {
            kotlin.jvm.internal.l0.p(view, "view");
            this.f6666a.removeOnAttachStateChangeListener(this);
            this.f6667b.z(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@a7.d View view) {
            kotlin.jvm.internal.l0.p(view, "view");
        }
    }

    public static final class d implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<View, kotlin.l2> f6669b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(View view, i5.l<? super View, kotlin.l2> lVar) {
            this.f6668a = view;
            this.f6669b = lVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@a7.d View view) {
            kotlin.jvm.internal.l0.p(view, "view");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@a7.d View view) {
            kotlin.jvm.internal.l0.p(view, "view");
            this.f6668a.removeOnAttachStateChangeListener(this);
            this.f6669b.z(view);
        }
    }

    public static final class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f6670a;

        public e(i5.l lVar) {
            this.f6670a = lVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@a7.d View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            kotlin.jvm.internal.l0.p(view, "view");
            view.removeOnLayoutChangeListener(this);
            this.f6670a.z(view);
        }
    }

    public static final class f implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<View, kotlin.l2> f6671a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(i5.l<? super View, kotlin.l2> lVar) {
            this.f6671a = lVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@a7.d View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            kotlin.jvm.internal.l0.p(view, "view");
            view.removeOnLayoutChangeListener(this);
            this.f6671a.z(view);
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<View, kotlin.l2> f6672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6673b;

        /* JADX WARN: Multi-variable type inference failed */
        public g(i5.l<? super View, kotlin.l2> lVar, View view) {
            this.f6672a = lVar;
            this.f6673b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6672a.z(this.f6673b);
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<kotlin.l2> f6674a;

        public h(i5.a<kotlin.l2> aVar) {
            this.f6674a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6674a.invoke();
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<kotlin.l2> f6675a;

        public i(i5.a<kotlin.l2> aVar) {
            this.f6675a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6675a.invoke();
        }
    }

    public static final void A(@a7.d View view, @c.r0 int i7, @c.r0 int i8, @c.r0 int i9, @c.r0 int i10) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setPadding(i7, i8, i9, i10);
    }

    public static /* synthetic */ void B(View view, int i7, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i7 = view.getPaddingLeft();
        }
        if ((i11 & 2) != 0) {
            i8 = view.getPaddingTop();
        }
        if ((i11 & 4) != 0) {
            i9 = view.getPaddingRight();
        }
        if ((i11 & 8) != 0) {
            i10 = view.getPaddingBottom();
        }
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setPadding(i7, i8, i9, i10);
    }

    @c.t0(17)
    public static final void C(@a7.d View view, @c.r0 int i7, @c.r0 int i8, @c.r0 int i9, @c.r0 int i10) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setPaddingRelative(i7, i8, i9, i10);
    }

    public static /* synthetic */ void D(View view, int i7, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i7 = view.getPaddingStart();
        }
        if ((i11 & 2) != 0) {
            i8 = view.getPaddingTop();
        }
        if ((i11 & 4) != 0) {
            i9 = view.getPaddingEnd();
        }
        if ((i11 & 8) != 0) {
            i10 = view.getPaddingBottom();
        }
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setPaddingRelative(i7, i8, i9, i10);
    }

    public static final void a(@a7.d View view, @a7.d i5.l<? super View, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        if (n2.O0(view)) {
            action.z(view);
        } else {
            view.addOnAttachStateChangeListener(new c(view, action));
        }
    }

    public static final void b(@a7.d View view, @a7.d i5.l<? super View, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        if (n2.O0(view)) {
            view.addOnAttachStateChangeListener(new d(view, action));
        } else {
            action.z(view);
        }
    }

    public static final void c(@a7.d View view, @a7.d i5.l<? super View, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        if (!n2.U0(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new e(action));
        } else {
            action.z(view);
        }
    }

    public static final void d(@a7.d View view, @a7.d i5.l<? super View, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        view.addOnLayoutChangeListener(new f(action));
    }

    @a7.d
    public static final c2 e(@a7.d View view, @a7.d i5.l<? super View, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        c2 c2VarA = c2.a(view, new g(action, view));
        kotlin.jvm.internal.l0.o(c2VarA, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return c2VarA;
    }

    @a7.d
    public static final Bitmap f(@a7.d View view, @a7.d Bitmap.Config config) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(config, "config");
        if (!n2.U0(view)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        kotlin.jvm.internal.l0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap g(View view, Bitmap.Config config, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return f(view, config);
    }

    @a7.d
    public static final kotlin.sequences.m<View> h(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        return kotlin.sequences.q.b(new a(view, null));
    }

    @a7.d
    public static final kotlin.sequences.m<ViewParent> i(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        return kotlin.sequences.s.n(view.getParent(), b.f6665j);
    }

    public static final int j(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int k(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return s0.b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int l(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int m(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int n(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return s0.c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int o(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean p(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean q(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean r(@a7.d View view) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        return view.getVisibility() == 0;
    }

    @a7.d
    public static final Runnable s(@a7.d View view, long j7, @a7.d i5.a<kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        h hVar = new h(action);
        view.postDelayed(hVar, j7);
        return hVar;
    }

    @a7.d
    @c.t0(16)
    public static final Runnable t(@a7.d View view, long j7, @a7.d i5.a<kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        i iVar = new i(action);
        view.postOnAnimationDelayed(iVar, j7);
        return iVar;
    }

    public static final void u(@a7.d View view, boolean z7) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setVisibility(z7 ? 8 : 0);
    }

    public static final void v(@a7.d View view, boolean z7) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setVisibility(z7 ? 4 : 0);
    }

    public static final void w(@a7.d View view, @c.r0 int i7) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setPadding(i7, i7, i7, i7);
    }

    public static final void x(@a7.d View view, boolean z7) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        view.setVisibility(z7 ? 0 : 8);
    }

    public static final void y(@a7.d View view, @a7.d i5.l<? super ViewGroup.LayoutParams, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        block.z(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    @h5.h(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void z(View view, i5.l<? super T, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(view, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        kotlin.jvm.internal.l0.y(1, "T");
        block.z(layoutParams);
        view.setLayoutParams(layoutParams);
    }
}
