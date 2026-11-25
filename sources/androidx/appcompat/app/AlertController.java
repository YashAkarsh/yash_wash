package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.n2;
import androidx.core.widget.NestedScrollView;
import c.o0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f630J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final l f632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ListView f637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f643m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Button f645o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f646p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Message f647q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f648r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Button f649s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f650t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Message f651u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f652v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Button f653w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f654x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Message f655y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f656z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f644n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f658b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z7, boolean z8) {
            if (z8 && z7) {
                return;
            }
            setPadding(getPaddingLeft(), z7 ? getPaddingTop() : this.f657a, getPaddingRight(), z8 ? getPaddingBottom() : this.f658b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f658b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f657a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.f645o && (message3 = alertController.f647q) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != alertController.f649s || (message2 = alertController.f651u) == null) {
                messageObtain = (view != alertController.f653w || (message = alertController.f655y) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f632b).sendToTarget();
        }
    }

    class b implements NestedScrollView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f661b;

        b(View view, View view2) {
            this.f660a = view;
            this.f661b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.c
        public void a(NestedScrollView nestedScrollView, int i7, int i8, int i9, int i10) {
            AlertController.g(nestedScrollView, this.f660a, this.f661b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f664b;

        c(View view, View view2) {
            this.f663a = view;
            this.f664b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.A, this.f663a, this.f664b);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f667b;

        d(View view, View view2) {
            this.f666a = view;
            this.f667b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
            AlertController.g(absListView, this.f666a, this.f667b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i7) {
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f670b;

        e(View view, View view2) {
            this.f669a = view;
            this.f670b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f637g, this.f669a, this.f670b);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f672J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public AdapterView.OnItemSelectedListener O;
        public e P;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f674b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f676d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f678f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f679g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f680h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f681i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f682j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f683k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f684l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f685m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f686n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f687o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f688p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f689q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f691s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f692t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f693u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f694v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f695w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f696x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f697y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f698z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f675c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f677e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean Q = true;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f690r = true;

        class a extends ArrayAdapter<CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f699a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i7, int i8, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i7, i8, charSequenceArr);
                this.f699a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i7, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i7, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i7]) {
                    this.f699a.setItemChecked(i7, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f701a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f702b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f703c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertController f704d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z7, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z7);
                this.f703c = recycleListView;
                this.f704d = alertController;
                Cursor cursor2 = getCursor();
                this.f701a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f702b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(android.R.id.text1)).setText(cursor.getString(this.f701a));
                this.f703c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f702b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f674b.inflate(this.f704d.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AlertController f706a;

            c(AlertController alertController) {
                this.f706a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                f.this.f696x.onClick(this.f706a.f632b, i7);
                if (f.this.H) {
                    return;
                }
                this.f706a.f632b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f708a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f709b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f708a = recycleListView;
                this.f709b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i7] = this.f708a.isItemChecked(i7);
                }
                f.this.f672J.onClick(this.f709b.f632b, i7, this.f708a.isItemChecked(i7));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f673a = context;
            this.f674b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter hVar;
            RecycleListView recycleListView = (RecycleListView) this.f674b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                hVar = this.K == null ? new a(this.f673a, alertController.M, android.R.id.text1, this.f694v, recycleListView) : new b(this.f673a, this.K, false, recycleListView, alertController);
            } else {
                int i7 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    hVar = new SimpleCursorAdapter(this.f673a, i7, this.K, new String[]{this.L}, new int[]{android.R.id.text1});
                } else {
                    hVar = this.f695w;
                    if (hVar == null) {
                        hVar = new h(this.f673a, i7, android.R.id.text1, this.f694v);
                    }
                }
            }
            e eVar = this.P;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = hVar;
            alertController.I = this.I;
            if (this.f696x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.f672J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.O;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f637g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f679g;
            if (view != null) {
                alertController.n(view);
            } else {
                CharSequence charSequence = this.f678f;
                if (charSequence != null) {
                    alertController.s(charSequence);
                }
                Drawable drawable = this.f676d;
                if (drawable != null) {
                    alertController.p(drawable);
                }
                int i7 = this.f675c;
                if (i7 != 0) {
                    alertController.o(i7);
                }
                int i8 = this.f677e;
                if (i8 != 0) {
                    alertController.o(alertController.d(i8));
                }
            }
            CharSequence charSequence2 = this.f680h;
            if (charSequence2 != null) {
                alertController.q(charSequence2);
            }
            CharSequence charSequence3 = this.f681i;
            if (charSequence3 != null || this.f682j != null) {
                alertController.l(-1, charSequence3, this.f683k, null, this.f682j);
            }
            CharSequence charSequence4 = this.f684l;
            if (charSequence4 != null || this.f685m != null) {
                alertController.l(-2, charSequence4, this.f686n, null, this.f685m);
            }
            CharSequence charSequence5 = this.f687o;
            if (charSequence5 != null || this.f688p != null) {
                alertController.l(-3, charSequence5, this.f689q, null, this.f688p);
            }
            if (this.f694v != null || this.K != null || this.f695w != null) {
                b(alertController);
            }
            View view2 = this.f698z;
            if (view2 != null) {
                if (this.E) {
                    alertController.v(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.u(view2);
                    return;
                }
            }
            int i9 = this.f697y;
            if (i9 != 0) {
                alertController.t(i9);
            }
        }
    }

    private static final class g extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f711b = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f712a;

        public g(DialogInterface dialogInterface) {
            this.f712a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == -3 || i7 == -2 || i7 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f712a.get(), message.what);
            } else {
                if (i7 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i7, int i8, CharSequence[] charSequenceArr) {
            super(context, i7, i8, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i7) {
            return i7;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, l lVar, Window window) {
        this.f631a = context;
        this.f632b = lVar;
        this.f633c = window;
        this.R = new g(lVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f630J = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f634d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        lVar.i(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f633c.findViewById(R.id.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(R.id.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(R.id.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R.id.customPanel);
        y(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupJ = j(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupJ2 = j(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupJ3 = j(viewFindViewById9, viewFindViewById6);
        x(viewGroupJ2);
        w(viewGroupJ3);
        z(viewGroupJ);
        boolean z7 = viewGroup.getVisibility() != 8;
        boolean z8 = (viewGroupJ == null || viewGroupJ.getVisibility() == 8) ? 0 : 1;
        boolean z9 = (viewGroupJ3 == null || viewGroupJ3.getVisibility() == 8) ? false : true;
        if (!z9 && viewGroupJ2 != null && (viewFindViewById2 = viewGroupJ2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z8 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f636f == null && this.f637g == null) ? null : viewGroupJ.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupJ2 != null && (viewFindViewById = viewGroupJ2.findViewById(R.id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f637g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z8, z9);
        }
        if (!z7) {
            View view = this.f637g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                r(viewGroupJ2, view, z8 | (z9 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f637g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i7 = this.I;
        if (i7 > -1) {
            listView2.setItemChecked(i7, true);
            listView2.setSelection(i7);
        }
    }

    private static boolean B(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    @o0
    private ViewGroup j(@o0 View view, @o0 View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i7 = this.K;
        if (i7 == 0) {
            return this.f630J;
        }
        return this.Q == 1 ? i7 : this.f630J;
    }

    private void r(ViewGroup viewGroup, View view, int i7, int i8) {
        View viewFindViewById = this.f633c.findViewById(R.id.scrollIndicatorUp);
        View viewFindViewById2 = this.f633c.findViewById(R.id.scrollIndicatorDown);
        n2.p2(view, i7, i8);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void w(ViewGroup viewGroup) {
        int i7;
        Button button = (Button) viewGroup.findViewById(android.R.id.button1);
        this.f645o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f646p) && this.f648r == null) {
            this.f645o.setVisibility(8);
            i7 = 0;
        } else {
            this.f645o.setText(this.f646p);
            Drawable drawable = this.f648r;
            if (drawable != null) {
                int i8 = this.f634d;
                drawable.setBounds(0, 0, i8, i8);
                this.f645o.setCompoundDrawables(this.f648r, null, null, null);
            }
            this.f645o.setVisibility(0);
            i7 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(android.R.id.button2);
        this.f649s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f650t) && this.f652v == null) {
            this.f649s.setVisibility(8);
        } else {
            this.f649s.setText(this.f650t);
            Drawable drawable2 = this.f652v;
            if (drawable2 != null) {
                int i9 = this.f634d;
                drawable2.setBounds(0, 0, i9, i9);
                this.f649s.setCompoundDrawables(this.f652v, null, null, null);
            }
            this.f649s.setVisibility(0);
            i7 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(android.R.id.button3);
        this.f653w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f654x) && this.f656z == null) {
            this.f653w.setVisibility(8);
        } else {
            this.f653w.setText(this.f654x);
            Drawable drawable3 = this.f656z;
            if (drawable3 != null) {
                int i10 = this.f634d;
                drawable3.setBounds(0, 0, i10, i10);
                this.f653w.setCompoundDrawables(this.f656z, null, null, null);
            }
            this.f653w.setVisibility(0);
            i7 |= 4;
        }
        if (B(this.f631a)) {
            if (i7 == 1) {
                b(this.f645o);
            } else if (i7 == 2) {
                b(this.f649s);
            } else if (i7 == 4) {
                b(this.f653w);
            }
        }
        if (i7 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f633c.findViewById(R.id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(android.R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f636f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f637g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f637g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void y(ViewGroup viewGroup) {
        View viewInflate = this.f638h;
        if (viewInflate == null) {
            viewInflate = this.f639i != 0 ? LayoutInflater.from(this.f631a).inflate(this.f639i, viewGroup, false) : null;
        }
        boolean z7 = viewInflate != null;
        if (!z7 || !a(viewInflate)) {
            this.f633c.setFlags(131072, 131072);
        }
        if (!z7) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f633c.findViewById(R.id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f644n) {
            frameLayout.setPadding(this.f640j, this.f641k, this.f642l, this.f643m);
        }
        if (this.f637g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void z(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f633c.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f633c.findViewById(android.R.id.icon);
        if (!(!TextUtils.isEmpty(this.f635e)) || !this.P) {
            this.f633c.findViewById(R.id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f633c.findViewById(R.id.alertTitle);
        this.E = textView;
        textView.setText(this.f635e);
        int i7 = this.B;
        if (i7 != 0) {
            this.D.setImageResource(i7);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    public Button c(int i7) {
        if (i7 == -3) {
            return this.f653w;
        }
        if (i7 == -2) {
            return this.f649s;
        }
        if (i7 != -1) {
            return null;
        }
        return this.f645o;
    }

    public int d(int i7) {
        TypedValue typedValue = new TypedValue();
        this.f631a.getTheme().resolveAttribute(i7, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f637g;
    }

    public void f() {
        this.f632b.setContentView(k());
        A();
    }

    public boolean h(int i7, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.v(keyEvent);
    }

    public boolean i(int i7, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.v(keyEvent);
    }

    public void l(int i7, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i7, onClickListener);
        }
        if (i7 == -3) {
            this.f654x = charSequence;
            this.f655y = message;
            this.f656z = drawable;
        } else if (i7 == -2) {
            this.f650t = charSequence;
            this.f651u = message;
            this.f652v = drawable;
        } else {
            if (i7 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f646p = charSequence;
            this.f647q = message;
            this.f648r = drawable;
        }
    }

    public void m(int i7) {
        this.Q = i7;
    }

    public void n(View view) {
        this.G = view;
    }

    public void o(int i7) {
        this.C = null;
        this.B = i7;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i7 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void p(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void q(CharSequence charSequence) {
        this.f636f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(CharSequence charSequence) {
        this.f635e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void t(int i7) {
        this.f638h = null;
        this.f639i = i7;
        this.f644n = false;
    }

    public void u(View view) {
        this.f638h = view;
        this.f639i = 0;
        this.f644n = false;
    }

    public void v(View view, int i7, int i8, int i9, int i10) {
        this.f638h = view;
        this.f639i = 0;
        this.f644n = true;
        this.f640j = i7;
        this.f641k = i8;
        this.f642l = i9;
        this.f643m = i10;
    }
}
