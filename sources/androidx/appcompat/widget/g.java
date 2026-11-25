package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.core.graphics.v1;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f1833b = "AppCompatDrawableManag";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f1834c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PorterDuff.Mode f1835d = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static g f1836e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w0 f1837a;

    class a implements w0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f1838a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f1839b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f1840c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f1841d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f1842e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f1843f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i7) {
            for (int i8 : iArr) {
                if (i8 == i7) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(@c.m0 Context context) {
            return h(context, 0);
        }

        private ColorStateList h(@c.m0 Context context, @c.l int i7) {
            int iD = c1.d(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{c1.f1795c, c1.f1798f, c1.f1796d, c1.f1802j}, new int[]{c1.c(context, R.attr.colorButtonNormal), v1.t(iD, i7), v1.t(iD, i7), i7});
        }

        private ColorStateList i(@c.m0 Context context) {
            return h(context, c1.d(context, R.attr.colorAccent));
        }

        private ColorStateList j(@c.m0 Context context) {
            return h(context, c1.d(context, R.attr.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListF = c1.f(context, R.attr.colorSwitchThumbNormal);
            if (colorStateListF == null || !colorStateListF.isStateful()) {
                iArr[0] = c1.f1795c;
                iArr2[0] = c1.c(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = c1.f1799g;
                iArr2[1] = c1.d(context, R.attr.colorControlActivated);
                iArr[2] = c1.f1802j;
                iArr2[2] = c1.d(context, R.attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = c1.f1795c;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListF.getColorForState(iArr3, 0);
                iArr[1] = c1.f1799g;
                iArr2[1] = c1.d(context, R.attr.colorControlActivated);
                iArr[2] = c1.f1802j;
                iArr2[2] = colorStateListF.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(@c.m0 w0 w0Var, @c.m0 Context context, @c.p int i7) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i7);
            Drawable drawableJ = w0Var.j(context, R.drawable.abc_star_black_48dp);
            Drawable drawableJ2 = w0Var.j(context, R.drawable.abc_star_half_black_48dp);
            if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableJ;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableJ2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i7, PorterDuff.Mode mode) {
            if (k0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = g.f1835d;
            }
            drawable.setColorFilter(g.e(i7, mode));
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0051  */
        /* JADX WARN: Code duplicated, block: B:24:0x0057  */
        /* JADX WARN: Code duplicated, block: B:27:0x0068  */
        /* JADX WARN: Code duplicated, block: B:29:0x006c A[RETURN] */
        @Override // androidx.appcompat.widget.w0.f
        public boolean a(@c.m0 Context context, int i7, @c.m0 Drawable drawable) {
            int i8;
            boolean z7;
            int iRound;
            PorterDuff.Mode mode = g.f1835d;
            if (!f(this.f1838a, i7)) {
                if (f(this.f1840c, i7)) {
                    i8 = R.attr.colorControlActivated;
                } else {
                    if (f(this.f1841d, i7)) {
                        mode = PorterDuff.Mode.MULTIPLY;
                    } else if (i7 == R.drawable.abc_list_divider_mtrl_alpha) {
                        z7 = true;
                        iRound = Math.round(40.8f);
                        i8 = 16842800;
                        mode = mode;
                    } else if (i7 != R.drawable.abc_dialog_material_background) {
                        i8 = 0;
                        z7 = false;
                        iRound = -1;
                    }
                    mode = mode;
                    iRound = -1;
                    i8 = 16842801;
                    z7 = true;
                }
                if (z7) {
                    return false;
                }
                if (k0.a(drawable)) {
                    drawable = drawable.mutate();
                }
                drawable.setColorFilter(g.e(c1.d(context, i8), mode));
                if (iRound != -1) {
                    drawable.setAlpha(iRound);
                }
                return true;
            }
            i8 = R.attr.colorControlNormal;
            z7 = true;
            iRound = -1;
            if (z7) {
                return false;
            }
            if (k0.a(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(g.e(c1.d(context, i8), mode));
            if (iRound != -1) {
                drawable.setAlpha(iRound);
            }
            return true;
        }

        @Override // androidx.appcompat.widget.w0.f
        public PorterDuff.Mode b(int i7) {
            if (i7 == R.drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.w0.f
        public Drawable c(@c.m0 w0 w0Var, @c.m0 Context context, int i7) {
            if (i7 == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{w0Var.j(context, R.drawable.abc_cab_background_internal_bg), w0Var.j(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i7 == R.drawable.abc_ratingbar_material) {
                return l(w0Var, context, R.dimen.abc_star_big);
            }
            if (i7 == R.drawable.abc_ratingbar_indicator_material) {
                return l(w0Var, context, R.dimen.abc_star_medium);
            }
            if (i7 == R.drawable.abc_ratingbar_small_material) {
                return l(w0Var, context, R.dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.w0.f
        public ColorStateList d(@c.m0 Context context, int i7) {
            if (i7 == R.drawable.abc_edit_text_material) {
                return e.a.a(context, R.color.abc_tint_edittext);
            }
            if (i7 == R.drawable.abc_switch_track_mtrl_alpha) {
                return e.a.a(context, R.color.abc_tint_switch_track);
            }
            if (i7 == R.drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i7 == R.drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i7 == R.drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i7 == R.drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i7 == R.drawable.abc_spinner_mtrl_am_alpha || i7 == R.drawable.abc_spinner_textfield_background_material) {
                return e.a.a(context, R.color.abc_tint_spinner);
            }
            if (f(this.f1839b, i7)) {
                return c1.f(context, R.attr.colorControlNormal);
            }
            if (f(this.f1842e, i7)) {
                return e.a.a(context, R.color.abc_tint_default);
            }
            if (f(this.f1843f, i7)) {
                return e.a.a(context, R.color.abc_tint_btn_checkable);
            }
            if (i7 == R.drawable.abc_seekbar_thumb_material) {
                return e.a.a(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.w0.f
        public boolean e(@c.m0 Context context, int i7, @c.m0 Drawable drawable) {
            if (i7 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(android.R.id.background), c1.d(context, R.attr.colorControlNormal), g.f1835d);
                m(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), c1.d(context, R.attr.colorControlNormal), g.f1835d);
                m(layerDrawable.findDrawableByLayerId(android.R.id.progress), c1.d(context, R.attr.colorControlActivated), g.f1835d);
                return true;
            }
            if (i7 != R.drawable.abc_ratingbar_material && i7 != R.drawable.abc_ratingbar_indicator_material && i7 != R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(android.R.id.background), c1.c(context, R.attr.colorControlNormal), g.f1835d);
            m(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), c1.d(context, R.attr.colorControlActivated), g.f1835d);
            m(layerDrawable2.findDrawableByLayerId(android.R.id.progress), c1.d(context, R.attr.colorControlActivated), g.f1835d);
            return true;
        }
    }

    public static synchronized g b() {
        if (f1836e == null) {
            i();
        }
        return f1836e;
    }

    public static synchronized PorterDuffColorFilter e(int i7, PorterDuff.Mode mode) {
        return w0.l(i7, mode);
    }

    public static synchronized void i() {
        if (f1836e == null) {
            g gVar = new g();
            f1836e = gVar;
            gVar.f1837a = w0.h();
            f1836e.f1837a.u(new a());
        }
    }

    static void j(Drawable drawable, f1 f1Var, int[] iArr) {
        w0.w(drawable, f1Var, iArr);
    }

    public synchronized Drawable c(@c.m0 Context context, @c.u int i7) {
        return this.f1837a.j(context, i7);
    }

    synchronized Drawable d(@c.m0 Context context, @c.u int i7, boolean z7) {
        return this.f1837a.k(context, i7, z7);
    }

    synchronized ColorStateList f(@c.m0 Context context, @c.u int i7) {
        return this.f1837a.m(context, i7);
    }

    public synchronized void g(@c.m0 Context context) {
        this.f1837a.s(context);
    }

    synchronized Drawable h(@c.m0 Context context, @c.m0 q1 q1Var, @c.u int i7) {
        return this.f1837a.t(context, q1Var, i7);
    }

    boolean k(@c.m0 Context context, @c.u int i7, @c.m0 Drawable drawable) {
        return this.f1837a.x(context, i7, drawable);
    }
}
