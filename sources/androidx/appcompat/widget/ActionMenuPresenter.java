package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements androidx.core.view.b.a {
    private static final String E = "ActionMenuPresenter";
    c A;
    private b B;
    final f C;
    int D;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    d f1341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f1342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1351u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1352v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1353w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final SparseBooleanArray f1354x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    e f1355y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    a f1356z;

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1357a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f1357a);
        }

        SavedState(Parcel parcel) {
            this.f1357a = parcel.readInt();
        }
    }

    private class a extends androidx.appcompat.view.menu.m {
        public a(Context context, androidx.appcompat.view.menu.s sVar, View view) {
            super(context, sVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.j) sVar.getItem()).o()) {
                View view2 = ActionMenuPresenter.this.f1341k;
                h(view2 == null ? (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1139i : view2);
            }
            a(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.m
        protected void g() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f1356z = null;
            actionMenuPresenter.D = 0;
            super.g();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.q a() {
            a aVar = ActionMenuPresenter.this.f1356z;
            if (aVar != null) {
                return aVar.e();
            }
            return null;
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f1360a;

        public c(e eVar) {
            this.f1360a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1133c != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1133c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1139i;
            if (view != null && view.getWindowToken() != null && this.f1360a.o()) {
                ActionMenuPresenter.this.f1355y = this.f1360a;
            }
            ActionMenuPresenter.this.A = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        class a extends p0 {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ ActionMenuPresenter f1363j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f1363j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.p0
            public androidx.appcompat.view.menu.q b() {
                e eVar = ActionMenuPresenter.this.f1355y;
                if (eVar == null) {
                    return null;
                }
                return eVar.e();
            }

            @Override // androidx.appcompat.widget.p0
            public boolean c() {
                ActionMenuPresenter.this.R();
                return true;
            }

            @Override // androidx.appcompat.widget.p0
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.A != null) {
                    return false;
                }
                actionMenuPresenter.F();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            l1.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.R();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i7, int i8, int i9, int i10) {
            boolean frame = super.setFrame(i7, i8, i9, i10);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.d.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e extends androidx.appcompat.view.menu.m {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z7) {
            super(context, gVar, view, z7, R.attr.actionOverflowMenuStyle);
            j(androidx.core.view.n0.f6718c);
            a(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.m
        protected void g() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1133c != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1133c.close();
            }
            ActionMenuPresenter.this.f1355y = null;
            super.g();
        }
    }

    private class f implements androidx.appcompat.view.menu.n.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public void d(@c.m0 androidx.appcompat.view.menu.g gVar, boolean z7) {
            if (gVar instanceof androidx.appcompat.view.menu.s) {
                gVar.G().f(false);
            }
            androidx.appcompat.view.menu.n.a aVarR = ActionMenuPresenter.this.r();
            if (aVarR != null) {
                aVarR.d(gVar, z7);
            }
        }

        @Override // androidx.appcompat.view.menu.n.a
        public boolean e(@c.m0 androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f1133c) {
                return false;
            }
            ActionMenuPresenter.this.D = ((androidx.appcompat.view.menu.s) gVar).getItem().getItemId();
            androidx.appcompat.view.menu.n.a aVarR = ActionMenuPresenter.this.r();
            if (aVarR != null) {
                return aVarR.e(gVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.f1354x = new SparseBooleanArray();
        this.C = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View D(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1139i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            if ((childAt instanceof androidx.appcompat.view.menu.o.a) && ((androidx.appcompat.view.menu.o.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean C() {
        return F() | G();
    }

    public Drawable E() {
        d dVar = this.f1341k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1343m) {
            return this.f1342l;
        }
        return null;
    }

    public boolean F() {
        Object obj;
        c cVar = this.A;
        if (cVar != null && (obj = this.f1139i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        e eVar = this.f1355y;
        if (eVar == null) {
            return false;
        }
        eVar.dismiss();
        return true;
    }

    public boolean G() {
        a aVar = this.f1356z;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    public boolean H() {
        return this.A != null || I();
    }

    public boolean I() {
        e eVar = this.f1355y;
        return eVar != null && eVar.f();
    }

    public boolean J() {
        return this.f1344n;
    }

    public void K(Configuration configuration) {
        if (!this.f1349s) {
            this.f1348r = androidx.appcompat.view.a.b(this.f1132b).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f1133c;
        if (gVar != null) {
            gVar.N(true);
        }
    }

    public void L(boolean z7) {
        this.f1352v = z7;
    }

    public void M(int i7) {
        this.f1348r = i7;
        this.f1349s = true;
    }

    public void N(ActionMenuView actionMenuView) {
        this.f1139i = actionMenuView;
        actionMenuView.e(this.f1133c);
    }

    public void O(Drawable drawable) {
        d dVar = this.f1341k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f1343m = true;
            this.f1342l = drawable;
        }
    }

    public void P(boolean z7) {
        this.f1344n = z7;
        this.f1345o = true;
    }

    public void Q(int i7, boolean z7) {
        this.f1346p = i7;
        this.f1350t = z7;
        this.f1351u = true;
    }

    public boolean R() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.f1344n || I() || (gVar = this.f1133c) == null || this.f1139i == null || this.A != null || gVar.C().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f1132b, this.f1133c, this.f1341k, true));
        this.A = cVar;
        ((View) this.f1139i).post(cVar);
        return true;
    }

    @Override // androidx.core.view.b.a
    public void b(boolean z7) {
        if (z7) {
            super.m(null);
            return;
        }
        androidx.appcompat.view.menu.g gVar = this.f1133c;
        if (gVar != null) {
            gVar.f(false);
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public void d(androidx.appcompat.view.menu.g gVar, boolean z7) {
        C();
        super.d(gVar, z7);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public void e(boolean z7) {
        super.e(z7);
        ((View) this.f1139i).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f1133c;
        boolean z8 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.j> arrayListV = gVar.v();
            int size = arrayListV.size();
            for (int i7 = 0; i7 < size; i7++) {
                androidx.core.view.b bVarB = arrayListV.get(i7).b();
                if (bVarB != null) {
                    bVarB.k(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f1133c;
        ArrayList<androidx.appcompat.view.menu.j> arrayListC = gVar2 != null ? gVar2.C() : null;
        if (this.f1344n && arrayListC != null) {
            int size2 = arrayListC.size();
            if (size2 == 1) {
                z8 = !arrayListC.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z8 = true;
            }
        }
        if (z8) {
            if (this.f1341k == null) {
                this.f1341k = new d(this.f1131a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1341k.getParent();
            if (viewGroup != this.f1139i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1341k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1139i;
                actionMenuView.addView(this.f1341k, actionMenuView.I());
            }
        } else {
            d dVar = this.f1341k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f1139i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1341k);
                }
            }
        }
        ((ActionMenuView) this.f1139i).setOverflowReserved(this.f1344n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.ActionMenuPresenter] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.j] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public boolean f() {
        ArrayList<androidx.appcompat.view.menu.j> arrayListH;
        int size;
        int i7;
        int iO;
        ?? r7;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.g gVar = actionMenuPresenter.f1133c;
        View view = null;
        ?? r8 = 0;
        if (gVar != null) {
            arrayListH = gVar.H();
            size = arrayListH.size();
        } else {
            arrayListH = null;
            size = 0;
        }
        int i8 = actionMenuPresenter.f1348r;
        int i9 = actionMenuPresenter.f1347q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1139i;
        boolean z7 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            androidx.appcompat.view.menu.j jVar = arrayListH.get(i12);
            if (jVar.d()) {
                i10++;
            } else if (jVar.q()) {
                i11++;
            } else {
                z7 = true;
            }
            if (actionMenuPresenter.f1352v && jVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.f1344n && (z7 || i11 + i10 > i8)) {
            i8--;
        }
        int i13 = i8 - i10;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1354x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1350t) {
            int i14 = actionMenuPresenter.f1353w;
            iO = i9 / i14;
            i7 = i14 + ((i9 % i14) / iO);
        } else {
            i7 = 0;
            iO = 0;
        }
        int i15 = 0;
        int i16 = 0;
        ?? r9 = actionMenuPresenter;
        while (i15 < size) {
            androidx.appcompat.view.menu.j jVar2 = arrayListH.get(i15);
            if (jVar2.d()) {
                View viewS = r9.s(jVar2, view, viewGroup);
                if (r9.f1350t) {
                    iO -= ActionMenuView.O(viewS, i7, iO, iMakeMeasureSpec, r8);
                } else {
                    viewS.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewS.getMeasuredWidth();
                i9 -= measuredWidth;
                if (i16 == 0) {
                    i16 = measuredWidth;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                jVar2.x(true);
                r7 = r8;
            } else if (jVar2.q()) {
                int groupId2 = jVar2.getGroupId();
                boolean z8 = sparseBooleanArray.get(groupId2);
                boolean z9 = (i13 > 0 || z8) && i9 > 0 && (!r9.f1350t || iO > 0);
                boolean z10 = z9;
                if (z9) {
                    View viewS2 = r9.s(jVar2, null, viewGroup);
                    if (r9.f1350t) {
                        int iO2 = ActionMenuView.O(viewS2, i7, iO, iMakeMeasureSpec, 0);
                        iO -= iO2;
                        if (iO2 == 0) {
                            z10 = false;
                        }
                    } else {
                        viewS2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z11 = z10;
                    int measuredWidth2 = viewS2.getMeasuredWidth();
                    i9 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z9 = z11 & (!r9.f1350t ? i9 + i16 <= 0 : i9 < 0);
                }
                if (z9 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z8) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        androidx.appcompat.view.menu.j jVar3 = arrayListH.get(i17);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.o()) {
                                i13++;
                            }
                            jVar3.x(false);
                        }
                    }
                }
                if (z9) {
                    i13--;
                }
                jVar2.x(z9);
                r7 = 0;
            } else {
                r7 = r8;
                jVar2.x(r7);
            }
            i15++;
            r8 = r7;
            size = size;
            view = null;
            r9 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public void j(@c.m0 Context context, @c.o0 androidx.appcompat.view.menu.g gVar) {
        super.j(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(context);
        if (!this.f1345o) {
            this.f1344n = aVarB.h();
        }
        if (!this.f1351u) {
            this.f1346p = aVarB.c();
        }
        if (!this.f1349s) {
            this.f1348r = aVarB.d();
        }
        int measuredWidth = this.f1346p;
        if (this.f1344n) {
            if (this.f1341k == null) {
                d dVar = new d(this.f1131a);
                this.f1341k = dVar;
                if (this.f1343m) {
                    dVar.setImageDrawable(this.f1342l);
                    this.f1342l = null;
                    this.f1343m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1341k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1341k.getMeasuredWidth();
        } else {
            this.f1341k = null;
        }
        this.f1347q = measuredWidth;
        this.f1353w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.n
    public void k(Parcelable parcelable) {
        int i7;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i7 = ((SavedState) parcelable).f1357a) > 0 && (menuItemFindItem = this.f1133c.findItem(i7)) != null) {
            m((androidx.appcompat.view.menu.s) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public void l(androidx.appcompat.view.menu.j jVar, androidx.appcompat.view.menu.o.a aVar) {
        aVar.g(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1139i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public boolean m(androidx.appcompat.view.menu.s sVar) {
        boolean z7 = false;
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.s sVar2 = sVar;
        while (sVar2.n0() != this.f1133c) {
            sVar2 = (androidx.appcompat.view.menu.s) sVar2.n0();
        }
        View viewD = D(sVar2.getItem());
        if (viewD == null) {
            return false;
        }
        this.D = sVar.getItem().getItemId();
        int size = sVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = sVar.getItem(i7);
            if (item.isVisible() && item.getIcon() != null) {
                z7 = true;
                break;
            }
        }
        a aVar = new a(this.f1132b, sVar, viewD);
        this.f1356z = aVar;
        aVar.i(z7);
        this.f1356z.l();
        super.m(sVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public androidx.appcompat.view.menu.o n(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.o oVar = this.f1139i;
        androidx.appcompat.view.menu.o oVarN = super.n(viewGroup);
        if (oVar != oVarN) {
            ((ActionMenuView) oVarN).setPresenter(this);
        }
        return oVarN;
    }

    @Override // androidx.appcompat.view.menu.n
    public Parcelable o() {
        SavedState savedState = new SavedState();
        savedState.f1357a = this.D;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean q(ViewGroup viewGroup, int i7) {
        if (viewGroup.getChildAt(i7) == this.f1341k) {
            return false;
        }
        return super.q(viewGroup, i7);
    }

    @Override // androidx.appcompat.view.menu.b
    public View s(androidx.appcompat.view.menu.j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.m()) {
            actionView = super.s(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean u(int i7, androidx.appcompat.view.menu.j jVar) {
        return jVar.o();
    }
}
