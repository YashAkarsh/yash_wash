package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.h1;
import androidx.core.view.n2;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView extends LinearLayout implements o.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f1097r = "ListMenuItemView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f1098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f1099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RadioButton f1100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f1101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CheckBox f1102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f1103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f1104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f1105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f1106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f1107j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1108k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f1109l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f1111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1112o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LayoutInflater f1113p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1114q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i7) {
        LinearLayout linearLayout = this.f1106i;
        if (linearLayout != null) {
            linearLayout.addView(view, i7);
        } else {
            addView(view, i7);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f1102e = checkBox;
        a(checkBox);
    }

    private void e() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f1099b = imageView;
        b(imageView, 0);
    }

    private LayoutInflater getInflater() {
        if (this.f1113p == null) {
            this.f1113p = LayoutInflater.from(getContext());
        }
        return this.f1113p;
    }

    private void h() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f1100c = radioButton;
        a(radioButton);
    }

    private void setSubMenuArrowVisible(boolean z7) {
        ImageView imageView = this.f1104g;
        if (imageView != null) {
            imageView.setVisibility(z7 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1105h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1105h.getLayoutParams();
        rect.top += this.f1105h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean f() {
        return this.f1114q;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void g(j jVar, int i7) {
        this.f1098a = jVar;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.l(this));
        setCheckable(jVar.isCheckable());
        setShortcut(jVar.D(), jVar.j());
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.o.a
    public j getItemData() {
        return this.f1098a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        n2.I1(this, this.f1107j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f1101d = textView;
        int i7 = this.f1108k;
        if (i7 != -1) {
            textView.setTextAppearance(this.f1109l, i7);
        }
        this.f1103f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f1104g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1111n);
        }
        this.f1105h = (ImageView) findViewById(R.id.group_divider);
        this.f1106i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        if (this.f1099b != null && this.f1110m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1099b.getLayoutParams();
            int i9 = layoutParams.height;
            if (i9 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i9;
            }
        }
        super.onMeasure(i7, i8);
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setCheckable(boolean z7) {
        CompoundButton compoundButton;
        View view;
        if (!z7 && this.f1100c == null && this.f1102e == null) {
            return;
        }
        if (this.f1098a.p()) {
            if (this.f1100c == null) {
                h();
            }
            compoundButton = this.f1100c;
            view = this.f1102e;
        } else {
            if (this.f1102e == null) {
                c();
            }
            compoundButton = this.f1102e;
            view = this.f1100c;
        }
        if (z7) {
            compoundButton.setChecked(this.f1098a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1102e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1100c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setChecked(boolean z7) {
        CompoundButton compoundButton;
        if (this.f1098a.p()) {
            if (this.f1100c == null) {
                h();
            }
            compoundButton = this.f1100c;
        } else {
            if (this.f1102e == null) {
                c();
            }
            compoundButton = this.f1102e;
        }
        compoundButton.setChecked(z7);
    }

    public void setForceShowIcon(boolean z7) {
        this.f1114q = z7;
        this.f1110m = z7;
    }

    public void setGroupDividerEnabled(boolean z7) {
        ImageView imageView = this.f1105h;
        if (imageView != null) {
            imageView.setVisibility((this.f1112o || !z7) ? 8 : 0);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setIcon(Drawable drawable) {
        boolean z7 = this.f1098a.C() || this.f1114q;
        if (z7 || this.f1110m) {
            ImageView imageView = this.f1099b;
            if (imageView == null && drawable == null && !this.f1110m) {
                return;
            }
            if (imageView == null) {
                e();
            }
            if (drawable == null && !this.f1110m) {
                this.f1099b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1099b;
            if (!z7) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1099b.getVisibility() != 0) {
                this.f1099b.setVisibility(0);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setShortcut(boolean z7, char c8) {
        int i7 = (z7 && this.f1098a.D()) ? 0 : 8;
        if (i7 == 0) {
            this.f1103f.setText(this.f1098a.k());
        }
        if (this.f1103f.getVisibility() != i7) {
            this.f1103f.setVisibility(i7);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1101d.getVisibility() != 8) {
                this.f1101d.setVisibility(8);
            }
        } else {
            this.f1101d.setText(charSequence);
            if (this.f1101d.getVisibility() != 0) {
                this.f1101d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet);
        h1 h1VarG = h1.G(getContext(), attributeSet, R.styleable.MenuView, i7, 0);
        this.f1107j = h1VarG.h(R.styleable.MenuView_android_itemBackground);
        this.f1108k = h1VarG.u(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f1110m = h1VarG.a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f1109l = context;
        this.f1111n = h1VarG.h(R.styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f1112o = typedArrayObtainStyledAttributes.hasValue(0);
        h1VarG.I();
        typedArrayObtainStyledAttributes.recycle();
    }
}
