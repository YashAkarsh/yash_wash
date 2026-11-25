package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements androidx.appcompat.widget.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final f f1375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f1377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Drawable f1378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final FrameLayout f1379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f1380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final FrameLayout f1381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f1382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f1383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    androidx.core.view.b f1384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final DataSetObserver f1385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f1386l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ListPopupWindow f1387m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    PopupWindow.OnDismissListener f1388n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f1389o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f1390p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1391q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1392r;

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f1393a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            h1 h1VarF = h1.F(context, attributeSet, f1393a);
            setBackgroundDrawable(h1VarF.h(0));
            h1VarF.I();
        }
    }

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1375a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1375a.notifyDataSetInvalidated();
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.b()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().b();
                androidx.core.view.b bVar = ActivityChooserView.this.f1384j;
                if (bVar != null) {
                    bVar.m(true);
                }
            }
        }
    }

    class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            androidx.core.view.accessibility.l0.X1(accessibilityNodeInfo).T0(true);
        }
    }

    class d extends p0 {
        d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.p0
        public androidx.appcompat.view.menu.q b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.p0
        protected boolean c() {
            ActivityChooserView.this.c();
            return true;
        }

        @Override // androidx.appcompat.widget.p0
        protected boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.e();
        }
    }

    private class f extends BaseAdapter {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f1399g = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f1400h = 4;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f1401i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f1402j = 1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f1403k = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private androidx.appcompat.widget.c f1404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1405b = 4;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1408e;

        f() {
        }

        public int a() {
            return this.f1404a.f();
        }

        public androidx.appcompat.widget.c b() {
            return this.f1404a;
        }

        public ResolveInfo c() {
            return this.f1404a.h();
        }

        public int d() {
            return this.f1404a.j();
        }

        public boolean e() {
            return this.f1406c;
        }

        public int f() {
            int i7 = this.f1405b;
            this.f1405b = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int iMax = 0;
            View view = null;
            for (int i8 = 0; i8 < count; i8++) {
                view = getView(i8, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f1405b = i7;
            return iMax;
        }

        public void g(androidx.appcompat.widget.c cVar) {
            androidx.appcompat.widget.c cVarB = ActivityChooserView.this.f1375a.b();
            if (cVarB != null && ActivityChooserView.this.isShown()) {
                cVarB.unregisterObserver(ActivityChooserView.this.f1385k);
            }
            this.f1404a = cVar;
            if (cVar != null && ActivityChooserView.this.isShown()) {
                cVar.registerObserver(ActivityChooserView.this.f1385k);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iF = this.f1404a.f();
            if (!this.f1406c && this.f1404a.h() != null) {
                iF--;
            }
            int iMin = Math.min(iF, this.f1405b);
            return this.f1408e ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i7) {
            int itemViewType = getItemViewType(i7);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f1406c && this.f1404a.h() != null) {
                i7++;
            }
            return this.f1404a.e(i7);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i7) {
            return i7;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i7) {
            return (this.f1408e && i7 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i7, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i7);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(androidx.appcompat.R.id.title)).setText(ActivityChooserView.this.getContext().getString(androidx.appcompat.R.string.abc_activity_chooser_view_see_all));
                return viewInflate;
            }
            if (view == null || view.getId() != androidx.appcompat.R.id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(androidx.appcompat.R.id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i7);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(androidx.appcompat.R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f1406c && i7 == 0 && this.f1407d) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void h(int i7) {
            if (this.f1405b != i7) {
                this.f1405b = i7;
                notifyDataSetChanged();
            }
        }

        public void i(boolean z7, boolean z8) {
            if (this.f1406c == z7 && this.f1407d == z8) {
                return;
            }
            this.f1406c = z7;
            this.f1407d = z8;
            notifyDataSetChanged();
        }

        public void j(boolean z7) {
            if (this.f1408e != z7) {
                this.f1408e = z7;
                notifyDataSetChanged();
            }
        }
    }

    private class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        g() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1388n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1381g) {
                if (view != activityChooserView.f1379e) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.f1389o = false;
                activityChooserView.d(activityChooserView.f1390p);
                return;
            }
            activityChooserView.a();
            Intent intentB = ActivityChooserView.this.f1375a.b().b(ActivityChooserView.this.f1375a.b().g(ActivityChooserView.this.f1375a.c()));
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            androidx.core.view.b bVar = ActivityChooserView.this.f1384j;
            if (bVar != null) {
                bVar.m(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i7);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.d(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.f1389o) {
                if (i7 > 0) {
                    activityChooserView.f1375a.b().r(i7);
                    return;
                }
                return;
            }
            if (!activityChooserView.f1375a.e()) {
                i7++;
            }
            Intent intentB = ActivityChooserView.this.f1375a.b().b(i7);
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1381g) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f1375a.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.f1389o = true;
                activityChooserView2.d(activityChooserView2.f1390p);
            }
            return true;
        }
    }

    public ActivityChooserView(@c.m0 Context context) {
        this(context, null);
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1386l);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().c();
    }

    public boolean c() {
        if (b() || !this.f1391q) {
            return false;
        }
        this.f1389o = false;
        d(this.f1390p);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
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
    void d(int i7) {
        if (this.f1375a.b() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1386l);
        ?? r7 = this.f1381g.getVisibility() == 0 ? 1 : 0;
        int iA = this.f1375a.a();
        if (i7 == Integer.MAX_VALUE || iA <= i7 + r7) {
            this.f1375a.j(false);
            this.f1375a.h(i7);
        } else {
            this.f1375a.j(true);
            this.f1375a.h(i7 - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.c()) {
            return;
        }
        if (this.f1389o || r7 == 0) {
            this.f1375a.i(true, r7);
        } else {
            this.f1375a.i(false, false);
        }
        listPopupWindow.U(Math.min(this.f1375a.f(), this.f1383i));
        listPopupWindow.b();
        androidx.core.view.b bVar = this.f1384j;
        if (bVar != null) {
            bVar.m(true);
        }
        listPopupWindow.l().setContentDescription(getContext().getString(androidx.appcompat.R.string.abc_activitychooserview_choose_application));
        listPopupWindow.l().setSelector(new ColorDrawable(0));
    }

    void e() {
        if (this.f1375a.getCount() > 0) {
            this.f1379e.setEnabled(true);
        } else {
            this.f1379e.setEnabled(false);
        }
        int iA = this.f1375a.a();
        int iD = this.f1375a.d();
        if (iA == 1 || (iA > 1 && iD > 0)) {
            this.f1381g.setVisibility(0);
            ResolveInfo resolveInfoC = this.f1375a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1382h.setImageDrawable(resolveInfoC.loadIcon(packageManager));
            if (this.f1392r != 0) {
                this.f1381g.setContentDescription(getContext().getString(this.f1392r, resolveInfoC.loadLabel(packageManager)));
            }
        } else {
            this.f1381g.setVisibility(8);
        }
        if (this.f1381g.getVisibility() == 0) {
            this.f1377c.setBackgroundDrawable(this.f1378d);
        } else {
            this.f1377c.setBackgroundDrawable(null);
        }
    }

    @c.x0({c.x0.a.LIBRARY})
    public androidx.appcompat.widget.c getDataModel() {
        return this.f1375a.b();
    }

    ListPopupWindow getListPopupWindow() {
        if (this.f1387m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1387m = listPopupWindow;
            listPopupWindow.q(this.f1375a);
            this.f1387m.S(this);
            this.f1387m.d0(true);
            this.f1387m.f0(this.f1376b);
            this.f1387m.e0(this.f1376b);
        }
        return this.f1387m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.appcompat.widget.c cVarB = this.f1375a.b();
        if (cVarB != null) {
            cVarB.registerObserver(this.f1385k);
        }
        this.f1391q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.c cVarB = this.f1375a.b();
        if (cVarB != null) {
            cVarB.unregisterObserver(this.f1385k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1386l);
        }
        if (b()) {
            a();
        }
        this.f1391q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        this.f1377c.layout(0, 0, i9 - i7, i10 - i8);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        View view = this.f1377c;
        if (this.f1381g.getVisibility() != 0) {
            i8 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i8), 1073741824);
        }
        measureChild(view, i7, i8);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.c.a
    @c.x0({c.x0.a.LIBRARY})
    public void setActivityChooserModel(androidx.appcompat.widget.c cVar) {
        this.f1375a.g(cVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i7) {
        this.f1392r = i7;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i7) {
        this.f1380f.setContentDescription(getContext().getString(i7));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1380f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i7) {
        this.f1390p = i7;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1388n = onDismissListener;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setProvider(androidx.core.view.b bVar) {
        this.f1384j = bVar;
    }

    public ActivityChooserView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f1385k = new a();
        this.f1386l = new b();
        this.f1390p = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ActivityChooserView, i7, 0);
        n2.z1(this, context, androidx.appcompat.R.styleable.ActivityChooserView, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        this.f1390p = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        g gVar = new g();
        this.f1376b = gVar;
        View viewFindViewById = findViewById(androidx.appcompat.R.id.activity_chooser_view_content);
        this.f1377c = viewFindViewById;
        this.f1378d = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(androidx.appcompat.R.id.default_activity_button);
        this.f1381g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        this.f1382h = (ImageView) frameLayout.findViewById(androidx.appcompat.R.id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(androidx.appcompat.R.id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f1379e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(androidx.appcompat.R.id.image);
        this.f1380f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f1375a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f1383i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_config_prefDialogWidth));
    }
}
