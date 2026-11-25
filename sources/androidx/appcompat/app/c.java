package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import c.a1;
import c.b1;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class c extends l implements DialogInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f803f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f804g = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final AlertController f805e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlertController.f f806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f807b;

        public a(@m0 Context context) {
            this(context, c.n(context, 0));
        }

        public a A(DialogInterface.OnKeyListener onKeyListener) {
            this.f806a.f693u = onKeyListener;
            return this;
        }

        public a B(@a1 int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f681i = fVar.f673a.getText(i7);
            this.f806a.f683k = onClickListener;
            return this;
        }

        public a C(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f681i = charSequence;
            fVar.f683k = onClickListener;
            return this;
        }

        public a D(Drawable drawable) {
            this.f806a.f682j = drawable;
            return this;
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public a E(boolean z7) {
            this.f806a.Q = z7;
            return this;
        }

        public a F(@c.e int i7, int i8, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f694v = fVar.f673a.getResources().getTextArray(i7);
            AlertController.f fVar2 = this.f806a;
            fVar2.f696x = onClickListener;
            fVar2.I = i8;
            fVar2.H = true;
            return this;
        }

        public a G(Cursor cursor, int i7, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.K = cursor;
            fVar.f696x = onClickListener;
            fVar.I = i7;
            fVar.L = str;
            fVar.H = true;
            return this;
        }

        public a H(ListAdapter listAdapter, int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f695w = listAdapter;
            fVar.f696x = onClickListener;
            fVar.I = i7;
            fVar.H = true;
            return this;
        }

        public a I(CharSequence[] charSequenceArr, int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f694v = charSequenceArr;
            fVar.f696x = onClickListener;
            fVar.I = i7;
            fVar.H = true;
            return this;
        }

        public a J(@a1 int i7) {
            AlertController.f fVar = this.f806a;
            fVar.f678f = fVar.f673a.getText(i7);
            return this;
        }

        public a K(@o0 CharSequence charSequence) {
            this.f806a.f678f = charSequence;
            return this;
        }

        public a L(int i7) {
            AlertController.f fVar = this.f806a;
            fVar.f698z = null;
            fVar.f697y = i7;
            fVar.E = false;
            return this;
        }

        public a M(View view) {
            AlertController.f fVar = this.f806a;
            fVar.f698z = view;
            fVar.f697y = 0;
            fVar.E = false;
            return this;
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public a N(View view, int i7, int i8, int i9, int i10) {
            AlertController.f fVar = this.f806a;
            fVar.f698z = view;
            fVar.f697y = 0;
            fVar.E = true;
            fVar.A = i7;
            fVar.B = i8;
            fVar.C = i9;
            fVar.D = i10;
            return this;
        }

        public c O() {
            c cVarA = a();
            cVarA.show();
            return cVarA;
        }

        @m0
        public c a() {
            c cVar = new c(this.f806a.f673a, this.f807b);
            this.f806a.a(cVar.f805e);
            cVar.setCancelable(this.f806a.f690r);
            if (this.f806a.f690r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f806a.f691s);
            cVar.setOnDismissListener(this.f806a.f692t);
            DialogInterface.OnKeyListener onKeyListener = this.f806a.f693u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        @m0
        public Context b() {
            return this.f806a.f673a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f695w = listAdapter;
            fVar.f696x = onClickListener;
            return this;
        }

        public a d(boolean z7) {
            this.f806a.f690r = z7;
            return this;
        }

        public a e(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.f fVar = this.f806a;
            fVar.K = cursor;
            fVar.L = str;
            fVar.f696x = onClickListener;
            return this;
        }

        public a f(@o0 View view) {
            this.f806a.f679g = view;
            return this;
        }

        public a g(@c.u int i7) {
            this.f806a.f675c = i7;
            return this;
        }

        public a h(@o0 Drawable drawable) {
            this.f806a.f676d = drawable;
            return this;
        }

        public a i(@c.f int i7) {
            TypedValue typedValue = new TypedValue();
            this.f806a.f673a.getTheme().resolveAttribute(i7, typedValue, true);
            this.f806a.f675c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public a j(boolean z7) {
            this.f806a.N = z7;
            return this;
        }

        public a k(@c.e int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f694v = fVar.f673a.getResources().getTextArray(i7);
            this.f806a.f696x = onClickListener;
            return this;
        }

        public a l(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f694v = charSequenceArr;
            fVar.f696x = onClickListener;
            return this;
        }

        public a m(@a1 int i7) {
            AlertController.f fVar = this.f806a;
            fVar.f680h = fVar.f673a.getText(i7);
            return this;
        }

        public a n(@o0 CharSequence charSequence) {
            this.f806a.f680h = charSequence;
            return this;
        }

        public a o(@c.e int i7, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f694v = fVar.f673a.getResources().getTextArray(i7);
            AlertController.f fVar2 = this.f806a;
            fVar2.f672J = onMultiChoiceClickListener;
            fVar2.F = zArr;
            fVar2.G = true;
            return this;
        }

        public a p(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.K = cursor;
            fVar.f672J = onMultiChoiceClickListener;
            fVar.M = str;
            fVar.L = str2;
            fVar.G = true;
            return this;
        }

        public a q(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f694v = charSequenceArr;
            fVar.f672J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public a r(@a1 int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f684l = fVar.f673a.getText(i7);
            this.f806a.f686n = onClickListener;
            return this;
        }

        public a s(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f684l = charSequence;
            fVar.f686n = onClickListener;
            return this;
        }

        public a t(Drawable drawable) {
            this.f806a.f685m = drawable;
            return this;
        }

        public a u(@a1 int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f687o = fVar.f673a.getText(i7);
            this.f806a.f689q = onClickListener;
            return this;
        }

        public a v(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f806a;
            fVar.f687o = charSequence;
            fVar.f689q = onClickListener;
            return this;
        }

        public a w(Drawable drawable) {
            this.f806a.f688p = drawable;
            return this;
        }

        public a x(DialogInterface.OnCancelListener onCancelListener) {
            this.f806a.f691s = onCancelListener;
            return this;
        }

        public a y(DialogInterface.OnDismissListener onDismissListener) {
            this.f806a.f692t = onDismissListener;
            return this;
        }

        public a z(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f806a.O = onItemSelectedListener;
            return this;
        }

        public a(@m0 Context context, @b1 int i7) {
            this.f806a = new AlertController.f(new ContextThemeWrapper(context, c.n(context, i7)));
            this.f807b = i7;
        }
    }

    protected c(@m0 Context context) {
        this(context, 0);
    }

    static int n(@m0 Context context, @b1 int i7) {
        if (((i7 >>> 24) & 255) >= 1) {
            return i7;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button j(int i7) {
        return this.f805e.c(i7);
    }

    public ListView k() {
        return this.f805e.e();
    }

    public void o(int i7, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f805e.l(i7, charSequence, onClickListener, null, null);
    }

    @Override // androidx.appcompat.app.l, androidx.activity.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f805e.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (this.f805e.h(i7, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i7, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i7, KeyEvent keyEvent) {
        if (this.f805e.i(i7, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i7, keyEvent);
    }

    public void p(int i7, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.f805e.l(i7, charSequence, onClickListener, null, drawable);
    }

    public void r(int i7, CharSequence charSequence, Message message) {
        this.f805e.l(i7, charSequence, null, message, null);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    void s(int i7) {
        this.f805e.m(i7);
    }

    @Override // androidx.appcompat.app.l, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f805e.s(charSequence);
    }

    public void t(View view) {
        this.f805e.n(view);
    }

    public void u(int i7) {
        this.f805e.o(i7);
    }

    public void v(Drawable drawable) {
        this.f805e.p(drawable);
    }

    public void w(int i7) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i7, typedValue, true);
        this.f805e.o(typedValue.resourceId);
    }

    public void x(CharSequence charSequence) {
        this.f805e.q(charSequence);
    }

    public void y(View view) {
        this.f805e.u(view);
    }

    public void z(View view, int i7, int i8, int i9, int i10) {
        this.f805e.v(view, i7, i8, i9, i10);
    }

    protected c(@m0 Context context, @b1 int i7) {
        super(context, n(context, i7));
        this.f805e = new AlertController(getContext(), this, getWindow());
    }

    protected c(@m0 Context context, boolean z7, @o0 DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z7);
        setOnCancelListener(onCancelListener);
    }
}
