package l1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.view.d;
import androidx.core.view.n2;
import c.a1;
import c.b1;
import c.e;
import c.f;
import c.m0;
import c.o0;
import c.q;
import c.r0;
import c.u;
import com.google.android.material.R;
import com.google.android.material.shape.j;

/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.appcompat.app.c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @f
    private static final int f37413e = R.attr.alertDialogStyle;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b1
    private static final int f37414f = R.style.MaterialAlertDialog_MaterialComponents;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @f
    private static final int f37415g = R.attr.materialAlertDialogTheme;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private Drawable f37416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    @q
    private final Rect f37417d;

    public b(@m0 Context context) {
        this(context, 0);
    }

    private static Context P(@m0 Context context) {
        int iR = R(context);
        Context contextC = q1.a.c(context, null, f37413e, f37414f);
        return iR == 0 ? contextC : new d(contextC, iR);
    }

    private static int R(@m0 Context context) {
        TypedValue typedValueA = com.google.android.material.resources.b.a(context, f37415g);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    private static int S(@m0 Context context, int i7) {
        return i7 == 0 ? R(context) : i7;
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public b G(@o0 Cursor cursor, int i7, @m0 String str, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.G(cursor, i7, str, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public b H(@o0 ListAdapter listAdapter, int i7, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.H(listAdapter, i7, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b I(@o0 CharSequence[] charSequenceArr, int i7, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.I(charSequenceArr, i7, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b J(@a1 int i7) {
        return (b) super.J(i7);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public b K(@o0 CharSequence charSequence) {
        return (b) super.K(charSequence);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public b L(int i7) {
        return (b) super.L(i7);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public b M(@o0 View view) {
        return (b) super.M(view);
    }

    @o0
    public Drawable Q() {
        return this.f37416c;
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public b c(@o0 ListAdapter listAdapter, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.c(listAdapter, onClickListener);
    }

    @m0
    public b U(@o0 Drawable drawable) {
        this.f37416c = drawable;
        return this;
    }

    @m0
    public b V(@r0 int i7) {
        this.f37417d.bottom = i7;
        return this;
    }

    @m0
    public b W(@r0 int i7) {
        if (b().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.f37417d.left = i7;
        } else {
            this.f37417d.right = i7;
        }
        return this;
    }

    @m0
    public b X(@r0 int i7) {
        if (b().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.f37417d.right = i7;
        } else {
            this.f37417d.left = i7;
        }
        return this;
    }

    @m0
    public b Y(@r0 int i7) {
        this.f37417d.top = i7;
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b d(boolean z7) {
        return (b) super.d(z7);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    public androidx.appcompat.app.c a() {
        androidx.appcompat.app.c cVarA = super.a();
        Window window = cVarA.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f37416c;
        if (drawable instanceof j) {
            ((j) drawable).m0(n2.R(decorView));
        }
        window.setBackgroundDrawable(c.b(this.f37416c, this.f37417d));
        decorView.setOnTouchListener(new a(cVarA, this.f37417d));
        return cVarA;
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public b e(@o0 Cursor cursor, @o0 DialogInterface.OnClickListener onClickListener, @m0 String str) {
        return (b) super.e(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b f(@o0 View view) {
        return (b) super.f(view);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b g(@u int i7) {
        return (b) super.g(i7);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public b h(@o0 Drawable drawable) {
        return (b) super.h(drawable);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b i(@f int i7) {
        return (b) super.i(i7);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public b k(@e int i7, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.k(i7, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public b l(@o0 CharSequence[] charSequenceArr, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.l(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public b m(@a1 int i7) {
        return (b) super.m(i7);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public b n(@o0 CharSequence charSequence) {
        return (b) super.n(charSequence);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b o(@e int i7, @o0 boolean[] zArr, @o0 DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.o(i7, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b p(@o0 Cursor cursor, @m0 String str, @m0 String str2, @o0 DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.p(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b q(@o0 CharSequence[] charSequenceArr, @o0 boolean[] zArr, @o0 DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.q(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b r(@a1 int i7, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.r(i7, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b s(@o0 CharSequence charSequence, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.s(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b t(@o0 Drawable drawable) {
        return (b) super.t(drawable);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public b u(@a1 int i7, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.u(i7, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b v(@o0 CharSequence charSequence, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.v(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b w(@o0 Drawable drawable) {
        return (b) super.w(drawable);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b x(@o0 DialogInterface.OnCancelListener onCancelListener) {
        return (b) super.x(onCancelListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b y(@o0 DialogInterface.OnDismissListener onDismissListener) {
        return (b) super.y(onDismissListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public b z(@o0 AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (b) super.z(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public b A(@o0 DialogInterface.OnKeyListener onKeyListener) {
        return (b) super.A(onKeyListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public b B(@a1 int i7, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.B(i7, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public b C(@o0 CharSequence charSequence, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.C(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public b D(@o0 Drawable drawable) {
        return (b) super.D(drawable);
    }

    @Override // androidx.appcompat.app.c.a
    @m0
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public b F(@e int i7, int i8, @o0 DialogInterface.OnClickListener onClickListener) {
        return (b) super.F(i7, i8, onClickListener);
    }

    public b(@m0 Context context, int i7) {
        super(P(context), S(context, i7));
        Context contextB = b();
        Resources.Theme theme = contextB.getTheme();
        int i8 = f37413e;
        int i9 = f37414f;
        this.f37417d = c.a(contextB, i8, i9);
        int iC = k1.a.c(contextB, R.attr.colorSurface, getClass().getCanonicalName());
        j jVar = new j(contextB, null, i8, i9);
        jVar.Y(contextB);
        jVar.n0(ColorStateList.valueOf(iC));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(b().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                jVar.j0(dimension);
            }
        }
        this.f37416c = jVar;
    }
}
