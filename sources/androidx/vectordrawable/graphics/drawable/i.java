package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.q;
import androidx.core.graphics.g2;
import androidx.core.view.n2;
import c.l;
import c.m0;
import c.o0;
import c.t0;
import c.u;
import c.x0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class i extends androidx.vectordrawable.graphics.drawable.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final String f10925k = "VectorDrawableCompat";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final PorterDuff.Mode f10926l = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f10927m = "clip-path";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f10928n = "group";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f10929o = "path";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f10930p = "vector";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f10931q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f10932r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f10933s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f10934t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f10935u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f10936v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f10937w = 2048;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final boolean f10938x = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f10939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f10940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorFilter f10941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable.ConstantState f10944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f10945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Matrix f10946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Rect f10947j;

    private static class b extends f {
        b() {
        }

        private void j(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f10975b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f10974a = g2.d(string2);
            }
            this.f10976c = q.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.f
        public boolean e() {
            return true;
        }

        public void i(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (q.r(xmlPullParser, "pathData")) {
                TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.I);
                j(typedArrayS, xmlPullParser);
                typedArrayS.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f10996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f10997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f10998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f10999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Bitmap f11000f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int[] f11001g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ColorStateList f11002h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        PorterDuff.Mode f11003i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f11004j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f11005k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f11006l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Paint f11007m;

        public h(h hVar) {
            this.f10997c = null;
            this.f10998d = i.f10926l;
            if (hVar != null) {
                this.f10995a = hVar.f10995a;
                g gVar = new g(hVar.f10996b);
                this.f10996b = gVar;
                if (hVar.f10996b.f10983e != null) {
                    gVar.f10983e = new Paint(hVar.f10996b.f10983e);
                }
                if (hVar.f10996b.f10982d != null) {
                    this.f10996b.f10982d = new Paint(hVar.f10996b.f10982d);
                }
                this.f10997c = hVar.f10997c;
                this.f10998d = hVar.f10998d;
                this.f10999e = hVar.f10999e;
            }
        }

        public boolean a(int i7, int i8) {
            return i7 == this.f11000f.getWidth() && i8 == this.f11000f.getHeight();
        }

        public boolean b() {
            return !this.f11006l && this.f11002h == this.f10997c && this.f11003i == this.f10998d && this.f11005k == this.f10999e && this.f11004j == this.f10996b.getRootAlpha();
        }

        public void c(int i7, int i8) {
            if (this.f11000f == null || !a(i7, i8)) {
                this.f11000f = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
                this.f11006l = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f11000f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f11007m == null) {
                Paint paint = new Paint();
                this.f11007m = paint;
                paint.setFilterBitmap(true);
            }
            this.f11007m.setAlpha(this.f10996b.getRootAlpha());
            this.f11007m.setColorFilter(colorFilter);
            return this.f11007m;
        }

        public boolean f() {
            return this.f10996b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f10996b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f10995a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f10996b.g(iArr);
            this.f11006l |= zG;
            return zG;
        }

        public void i() {
            this.f11002h = this.f10997c;
            this.f11003i = this.f10998d;
            this.f11004j = this.f10996b.getRootAlpha();
            this.f11005k = this.f10999e;
            this.f11006l = false;
        }

        public void j(int i7, int i8) {
            this.f11000f.eraseColor(0);
            this.f10996b.b(new Canvas(this.f11000f), i7, i8, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public h() {
            this.f10997c = null;
            this.f10998d = i.f10926l;
            this.f10996b = new g();
        }
    }

    i() {
        this.f10943f = true;
        this.f10945h = new float[9];
        this.f10946i = new Matrix();
        this.f10947j = new Rect();
        this.f10939b = new h();
    }

    static int a(int i7, float f8) {
        return (i7 & n2.f6742s) | (((int) (Color.alpha(i7) * f8)) << 24);
    }

    @o0
    public static i e(@m0 Resources resources, @u int i7, @o0 Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f10924a = androidx.core.content.res.i.g(resources, i7, theme);
            iVar.f10944g = new C0132i(iVar.f10924a.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i7);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return f(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e8) {
            Log.e(f10925k, "parser error", e8);
            return null;
        } catch (XmlPullParserException e9) {
            Log.e(f10925k, "parser error", e9);
            return null;
        }
    }

    public static i f(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void i(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f10939b;
        g gVar = hVar.f10996b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f10986h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z7 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if (f10929o.equals(name)) {
                    c cVar = new c();
                    cVar.k(resources, attributeSet, theme, xmlPullParser);
                    dVar.f10961b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f10994p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f10995a = cVar.f10977d | hVar.f10995a;
                    z7 = false;
                } else if (f10927m.equals(name)) {
                    b bVar = new b();
                    bVar.i(resources, attributeSet, theme, xmlPullParser);
                    dVar.f10961b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f10994p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f10995a = bVar.f10977d | hVar.f10995a;
                } else if (f10928n.equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f10961b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f10994p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f10995a = dVar2.f10970k | hVar.f10995a;
                }
            } else if (eventType == 3 && f10928n.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z7) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean j() {
        return isAutoMirrored() && androidx.core.graphics.drawable.d.f(this) == 1;
    }

    private static PorterDuff.Mode k(int i7, PorterDuff.Mode mode) {
        if (i7 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i7 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i7 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i7) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void l(d dVar, int i7) {
        String str = "";
        for (int i8 = 0; i8 < i7; i8++) {
            str = str + "    ";
        }
        Log.v(f10925k, str + "current group is :" + dVar.getGroupName() + " rotation is " + dVar.f10962c);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("matrix is :");
        sb.append(dVar.getLocalMatrix().toString());
        Log.v(f10925k, sb.toString());
        for (int i9 = 0; i9 < dVar.f10961b.size(); i9++) {
            e eVar = dVar.f10961b.get(i9);
            if (eVar instanceof d) {
                l((d) eVar, i7 + 1);
            } else {
                ((f) eVar).g(i7 + 1);
            }
        }
    }

    private void n(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f10939b;
        g gVar = hVar.f10996b;
        hVar.f10998d = k(q.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = q.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            hVar.f10997c = colorStateListG;
        }
        hVar.f10999e = q.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f10999e);
        gVar.f10989k = q.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f10989k);
        float fJ = q.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f10990l);
        gVar.f10990l = fJ;
        if (gVar.f10989k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f10987i = typedArray.getDimension(3, gVar.f10987i);
        float dimension = typedArray.getDimension(2, gVar.f10988j);
        gVar.f10988j = dimension;
        if (gVar.f10987i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(q.j(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f10992n = string;
            gVar.f10994p.put(string, gVar);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f10924a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.d.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f10947j);
        if (this.f10947j.width() <= 0 || this.f10947j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f10941d;
        if (colorFilter == null) {
            colorFilter = this.f10940c;
        }
        canvas.getMatrix(this.f10946i);
        this.f10946i.getValues(this.f10945h);
        float fAbs = Math.abs(this.f10945h[0]);
        float fAbs2 = Math.abs(this.f10945h[4]);
        float fAbs3 = Math.abs(this.f10945h[1]);
        float fAbs4 = Math.abs(this.f10945h[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (this.f10947j.width() * fAbs);
        int iHeight = (int) (this.f10947j.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f10947j;
        canvas.translate(rect.left, rect.top);
        if (j()) {
            canvas.translate(this.f10947j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f10947j.offsetTo(0, 0);
        this.f10939b.c(iMin, iMin2);
        if (!this.f10943f) {
            this.f10939b.j(iMin, iMin2);
        } else if (!this.f10939b.b()) {
            this.f10939b.j(iMin, iMin2);
            this.f10939b.i();
        }
        this.f10939b.d(canvas, colorFilter, this.f10947j);
        canvas.restoreToCount(iSave);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public float g() {
        g gVar;
        h hVar = this.f10939b;
        if (hVar == null || (gVar = hVar.f10996b) == null) {
            return 1.0f;
        }
        float f8 = gVar.f10987i;
        if (f8 == 0.0f) {
            return 1.0f;
        }
        float f9 = gVar.f10988j;
        if (f9 == 0.0f) {
            return 1.0f;
        }
        float f10 = gVar.f10990l;
        if (f10 == 0.0f) {
            return 1.0f;
        }
        float f11 = gVar.f10989k;
        if (f11 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f11 / f8, f10 / f9);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f10924a;
        return drawable != null ? androidx.core.graphics.drawable.d.d(drawable) : this.f10939b.f10996b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f10939b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f10924a;
        return drawable != null ? androidx.core.graphics.drawable.d.e(drawable) : this.f10941d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f10924a != null && Build.VERSION.SDK_INT >= 24) {
            return new C0132i(this.f10924a.getConstantState());
        }
        this.f10939b.f10995a = getChangingConfigurations();
        return this.f10939b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f10939b.f10996b.f10988j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f10939b.f10996b.f10987i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    Object h(String str) {
        return this.f10939b.f10996b.f10994p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f10924a;
        return drawable != null ? androidx.core.graphics.drawable.d.h(drawable) : this.f10939b.f10999e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f10939b) != null && (hVar.g() || ((colorStateList = this.f10939b.f10997c) != null && colorStateList.isStateful())));
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    void m(boolean z7) {
        this.f10943f = z7;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f10942e && super.mutate() == this) {
            this.f10939b = new h(this.f10939b);
            this.f10942e = true;
        }
        return this;
    }

    PorterDuffColorFilter o(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z7;
        PorterDuff.Mode mode;
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f10939b;
        ColorStateList colorStateList = hVar.f10997c;
        if (colorStateList == null || (mode = hVar.f10998d) == null) {
            z7 = false;
        } else {
            this.f10940c = o(this.f10940c, colorStateList, mode);
            invalidateSelf();
            z7 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z7;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j7);
        } else {
            super.scheduleSelf(runnable, j7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setAlpha(i7);
        } else if (this.f10939b.f10996b.getRootAlpha() != i7) {
            this.f10939b.f10996b.setRootAlpha(i7);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.j(drawable, z7);
        } else {
            this.f10939b.f10999e = z7;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i7) {
        super.setChangingConfigurations(i7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i7, PorterDuff.Mode mode) {
        super.setColorFilter(i7, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z7) {
        super.setFilterBitmap(z7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f8, float f9) {
        super.setHotspot(f8, f9);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i7, int i8, int i9, int i10) {
        super.setHotspotBounds(i7, i8, i9, i10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(int i7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.n(drawable, i7);
        } else {
            setTintList(ColorStateList.valueOf(i7));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f10939b;
        if (hVar.f10997c != colorStateList) {
            hVar.f10997c = colorStateList;
            this.f10940c = o(this.f10940c, colorStateList, hVar.f10998d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.p(drawable, mode);
            return;
        }
        h hVar = this.f10939b;
        if (hVar.f10998d != mode) {
            hVar.f10998d = mode;
            this.f10940c = o(this.f10940c, hVar.f10997c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.setVisible(z7, z8) : super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.i$i, reason: collision with other inner class name */
    @t0(24)
    private static class C0132i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f11008a;

        public C0132i(Drawable.ConstantState constantState) {
            this.f11008a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f11008a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f11008a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f10924a = (VectorDrawable) this.f11008a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f10924a = (VectorDrawable) this.f11008a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f10924a = (VectorDrawable) this.f11008a.newDrawable(resources, theme);
            return iVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f10941d = colorFilter;
            invalidateSelf();
        }
    }

    private static abstract class f extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected static final int f10973e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected g2.b[] f10974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f10975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10977d;

        public f() {
            super();
            this.f10974a = null;
            this.f10976c = 0;
        }

        public void c(Resources.Theme theme) {
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public String f(g2.b[] bVarArr) {
            String str = " ";
            for (int i7 = 0; i7 < bVarArr.length; i7++) {
                str = str + bVarArr[i7].f5846a + ":";
                for (float f8 : bVarArr[i7].f5847b) {
                    str = str + f8 + ",";
                }
            }
            return str;
        }

        public void g(int i7) {
            String str = "";
            for (int i8 = 0; i8 < i7; i8++) {
                str = str + "    ";
            }
            Log.v(i.f10925k, str + "current path is :" + this.f10975b + " pathData is " + f(this.f10974a));
        }

        public g2.b[] getPathData() {
            return this.f10974a;
        }

        public String getPathName() {
            return this.f10975b;
        }

        public void h(Path path) {
            path.reset();
            g2.b[] bVarArr = this.f10974a;
            if (bVarArr != null) {
                g2.b.e(bVarArr, path);
            }
        }

        public void setPathData(g2.b[] bVarArr) {
            if (g2.b(this.f10974a, bVarArr)) {
                g2.k(this.f10974a, bVarArr);
            } else {
                this.f10974a = g2.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f10974a = null;
            this.f10976c = 0;
            this.f10975b = fVar.f10975b;
            this.f10977d = fVar.f10977d;
            this.f10974a = g2.f(fVar.f10974a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f10939b;
        hVar.f10996b = new g();
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10835a);
        n(typedArrayS, xmlPullParser, theme);
        typedArrayS.recycle();
        hVar.f10995a = getChangingConfigurations();
        hVar.f11006l = true;
        i(resources, xmlPullParser, attributeSet, theme);
        this.f10940c = o(this.f10940c, hVar.f10997c, hVar.f10998d);
    }

    i(@m0 h hVar) {
        this.f10943f = true;
        this.f10945h = new float[9];
        this.f10946i = new Matrix();
        this.f10947j = new Rect();
        this.f10939b = hVar;
        this.f10940c = o(this.f10940c, hVar.f10997c, hVar.f10998d);
    }

    private static class c extends f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int[] f10948f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.core.content.res.d f10949g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f10950h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        androidx.core.content.res.d f10951i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f10952j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f10953k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f10954l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float f10955m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        float f10956n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Paint.Cap f10957o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Paint.Join f10958p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        float f10959q;

        c() {
            this.f10950h = 0.0f;
            this.f10952j = 1.0f;
            this.f10953k = 1.0f;
            this.f10954l = 0.0f;
            this.f10955m = 1.0f;
            this.f10956n = 0.0f;
            this.f10957o = Paint.Cap.BUTT;
            this.f10958p = Paint.Join.MITER;
            this.f10959q = 4.0f;
        }

        private Paint.Cap i(int i7, Paint.Cap cap) {
            if (i7 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i7 != 1) {
                return i7 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join j(int i7, Paint.Join join) {
            if (i7 == 0) {
                return Paint.Join.MITER;
            }
            if (i7 != 1) {
                return i7 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        private void l(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f10948f = null;
            if (q.r(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f10975b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f10974a = g2.d(string2);
                }
                this.f10951i = q.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f10953k = q.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f10953k);
                this.f10957o = i(q.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f10957o);
                this.f10958p = j(q.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f10958p);
                this.f10959q = q.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f10959q);
                this.f10949g = q.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f10952j = q.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f10952j);
                this.f10950h = q.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f10950h);
                this.f10955m = q.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f10955m);
                this.f10956n = q.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f10956n);
                this.f10954l = q.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f10954l);
                this.f10976c = q.k(typedArray, xmlPullParser, "fillType", 13, this.f10976c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean a() {
            return this.f10951i.i() || this.f10949g.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean b(int[] iArr) {
            return this.f10949g.j(iArr) | this.f10951i.j(iArr);
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.f
        public void c(Resources.Theme theme) {
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.f
        public boolean d() {
            return this.f10948f != null;
        }

        float getFillAlpha() {
            return this.f10953k;
        }

        @l
        int getFillColor() {
            return this.f10951i.e();
        }

        float getStrokeAlpha() {
            return this.f10952j;
        }

        @l
        int getStrokeColor() {
            return this.f10949g.e();
        }

        float getStrokeWidth() {
            return this.f10950h;
        }

        float getTrimPathEnd() {
            return this.f10955m;
        }

        float getTrimPathOffset() {
            return this.f10956n;
        }

        float getTrimPathStart() {
            return this.f10954l;
        }

        public void k(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10873t);
            l(typedArrayS, xmlPullParser, theme);
            typedArrayS.recycle();
        }

        void setFillAlpha(float f8) {
            this.f10953k = f8;
        }

        void setFillColor(int i7) {
            this.f10951i.k(i7);
        }

        void setStrokeAlpha(float f8) {
            this.f10952j = f8;
        }

        void setStrokeColor(int i7) {
            this.f10949g.k(i7);
        }

        void setStrokeWidth(float f8) {
            this.f10950h = f8;
        }

        void setTrimPathEnd(float f8) {
            this.f10955m = f8;
        }

        void setTrimPathOffset(float f8) {
            this.f10956n = f8;
        }

        void setTrimPathStart(float f8) {
            this.f10954l = f8;
        }

        c(c cVar) {
            super(cVar);
            this.f10950h = 0.0f;
            this.f10952j = 1.0f;
            this.f10953k = 1.0f;
            this.f10954l = 0.0f;
            this.f10955m = 1.0f;
            this.f10956n = 0.0f;
            this.f10957o = Paint.Cap.BUTT;
            this.f10958p = Paint.Join.MITER;
            this.f10959q = 4.0f;
            this.f10948f = cVar.f10948f;
            this.f10949g = cVar.f10949g;
            this.f10950h = cVar.f10950h;
            this.f10952j = cVar.f10952j;
            this.f10951i = cVar.f10951i;
            this.f10976c = cVar.f10976c;
            this.f10953k = cVar.f10953k;
            this.f10954l = cVar.f10954l;
            this.f10955m = cVar.f10955m;
            this.f10956n = cVar.f10956n;
            this.f10957o = cVar.f10957o;
            this.f10958p = cVar.f10958p;
            this.f10959q = cVar.f10959q;
        }
    }

    private static class g {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final Matrix f10978q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f10979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f10980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Matrix f10981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f10982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f10983e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PathMeasure f10984f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f10985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final d f10986h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f10987i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f10988j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f10989k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f10990l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f10991m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f10992n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Boolean f10993o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final androidx.collection.a<String, Object> f10994p;

        public g() {
            this.f10981c = new Matrix();
            this.f10987i = 0.0f;
            this.f10988j = 0.0f;
            this.f10989k = 0.0f;
            this.f10990l = 0.0f;
            this.f10991m = 255;
            this.f10992n = null;
            this.f10993o = null;
            this.f10994p = new androidx.collection.a<>();
            this.f10986h = new d();
            this.f10979a = new Path();
            this.f10980b = new Path();
        }

        private static float a(float f8, float f9, float f10, float f11) {
            return (f8 * f11) - (f9 * f10);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i7, int i8, ColorFilter colorFilter) {
            dVar.f10960a.set(matrix);
            dVar.f10960a.preConcat(dVar.f10969j);
            canvas.save();
            for (int i9 = 0; i9 < dVar.f10961b.size(); i9++) {
                e eVar = dVar.f10961b.get(i9);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f10960a, canvas, i7, i8, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i7, i8, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i7, int i8, ColorFilter colorFilter) {
            float f8 = i7 / this.f10989k;
            float f9 = i8 / this.f10990l;
            float fMin = Math.min(f8, f9);
            Matrix matrix = dVar.f10960a;
            this.f10981c.set(matrix);
            this.f10981c.postScale(f8, f9);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.h(this.f10979a);
            Path path = this.f10979a;
            this.f10980b.reset();
            if (fVar.e()) {
                this.f10980b.setFillType(fVar.f10976c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f10980b.addPath(path, this.f10981c);
                canvas.clipPath(this.f10980b);
                return;
            }
            c cVar = (c) fVar;
            float f10 = cVar.f10954l;
            if (f10 != 0.0f || cVar.f10955m != 1.0f) {
                float f11 = cVar.f10956n;
                float f12 = (f10 + f11) % 1.0f;
                float f13 = (cVar.f10955m + f11) % 1.0f;
                if (this.f10984f == null) {
                    this.f10984f = new PathMeasure();
                }
                this.f10984f.setPath(this.f10979a, false);
                float length = this.f10984f.getLength();
                float f14 = f12 * length;
                float f15 = f13 * length;
                path.reset();
                if (f14 > f15) {
                    this.f10984f.getSegment(f14, length, path, true);
                    this.f10984f.getSegment(0.0f, f15, path, true);
                } else {
                    this.f10984f.getSegment(f14, f15, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f10980b.addPath(path, this.f10981c);
            if (cVar.f10951i.l()) {
                androidx.core.content.res.d dVar2 = cVar.f10951i;
                if (this.f10983e == null) {
                    Paint paint = new Paint(1);
                    this.f10983e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f10983e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f10981c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f10953k * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(i.a(dVar2.e(), cVar.f10953k));
                }
                paint2.setColorFilter(colorFilter);
                this.f10980b.setFillType(cVar.f10976c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f10980b, paint2);
            }
            if (cVar.f10949g.l()) {
                androidx.core.content.res.d dVar3 = cVar.f10949g;
                if (this.f10982d == null) {
                    Paint paint3 = new Paint(1);
                    this.f10982d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f10982d;
                Paint.Join join = cVar.f10958p;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f10957o;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f10959q);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f10981c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f10952j * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(i.a(dVar3.e(), cVar.f10952j));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f10950h * fMin * fE);
                canvas.drawPath(this.f10980b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i7, int i8, ColorFilter colorFilter) {
            c(this.f10986h, f10978q, canvas, i7, i8, colorFilter);
        }

        public boolean f() {
            if (this.f10993o == null) {
                this.f10993o = Boolean.valueOf(this.f10986h.a());
            }
            return this.f10993o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f10986h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f10991m;
        }

        public void setAlpha(float f8) {
            setRootAlpha((int) (f8 * 255.0f));
        }

        public void setRootAlpha(int i7) {
            this.f10991m = i7;
        }

        public g(g gVar) {
            this.f10981c = new Matrix();
            this.f10987i = 0.0f;
            this.f10988j = 0.0f;
            this.f10989k = 0.0f;
            this.f10990l = 0.0f;
            this.f10991m = 255;
            this.f10992n = null;
            this.f10993o = null;
            androidx.collection.a<String, Object> aVar = new androidx.collection.a<>();
            this.f10994p = aVar;
            this.f10986h = new d(gVar.f10986h, aVar);
            this.f10979a = new Path(gVar.f10979a);
            this.f10980b = new Path(gVar.f10980b);
            this.f10987i = gVar.f10987i;
            this.f10988j = gVar.f10988j;
            this.f10989k = gVar.f10989k;
            this.f10990l = gVar.f10990l;
            this.f10985g = gVar.f10985g;
            this.f10991m = gVar.f10991m;
            this.f10992n = gVar.f10992n;
            String str = gVar.f10992n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f10993o = gVar.f10993o;
        }
    }

    private static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f10960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<e> f10961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f10962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f10963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f10964e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f10965f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f10966g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f10967h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f10968i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Matrix f10969j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f10970k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int[] f10971l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f10972m;

        public d(d dVar, androidx.collection.a<String, Object> aVar) {
            f bVar;
            super();
            this.f10960a = new Matrix();
            this.f10961b = new ArrayList<>();
            this.f10962c = 0.0f;
            this.f10963d = 0.0f;
            this.f10964e = 0.0f;
            this.f10965f = 1.0f;
            this.f10966g = 1.0f;
            this.f10967h = 0.0f;
            this.f10968i = 0.0f;
            Matrix matrix = new Matrix();
            this.f10969j = matrix;
            this.f10972m = null;
            this.f10962c = dVar.f10962c;
            this.f10963d = dVar.f10963d;
            this.f10964e = dVar.f10964e;
            this.f10965f = dVar.f10965f;
            this.f10966g = dVar.f10966g;
            this.f10967h = dVar.f10967h;
            this.f10968i = dVar.f10968i;
            this.f10971l = dVar.f10971l;
            String str = dVar.f10972m;
            this.f10972m = str;
            this.f10970k = dVar.f10970k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f10969j);
            ArrayList<e> arrayList = dVar.f10961b;
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                e eVar = arrayList.get(i7);
                if (eVar instanceof d) {
                    this.f10961b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f10961b.add(bVar);
                    String str2 = bVar.f10975b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f10969j.reset();
            this.f10969j.postTranslate(-this.f10963d, -this.f10964e);
            this.f10969j.postScale(this.f10965f, this.f10966g);
            this.f10969j.postRotate(this.f10962c, 0.0f, 0.0f);
            this.f10969j.postTranslate(this.f10967h + this.f10963d, this.f10968i + this.f10964e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f10971l = null;
            this.f10962c = q.j(typedArray, xmlPullParser, androidx.constraintlayout.motion.widget.f.f3954i, 5, this.f10962c);
            this.f10963d = typedArray.getFloat(1, this.f10963d);
            this.f10964e = typedArray.getFloat(2, this.f10964e);
            this.f10965f = q.j(typedArray, xmlPullParser, "scaleX", 3, this.f10965f);
            this.f10966g = q.j(typedArray, xmlPullParser, "scaleY", 4, this.f10966g);
            this.f10967h = q.j(typedArray, xmlPullParser, "translateX", 6, this.f10967h);
            this.f10968i = q.j(typedArray, xmlPullParser, "translateY", 7, this.f10968i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f10972m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean a() {
            for (int i7 = 0; i7 < this.f10961b.size(); i7++) {
                if (this.f10961b.get(i7).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i7 = 0; i7 < this.f10961b.size(); i7++) {
                zB |= this.f10961b.get(i7).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10855k);
            e(typedArrayS, xmlPullParser);
            typedArrayS.recycle();
        }

        public String getGroupName() {
            return this.f10972m;
        }

        public Matrix getLocalMatrix() {
            return this.f10969j;
        }

        public float getPivotX() {
            return this.f10963d;
        }

        public float getPivotY() {
            return this.f10964e;
        }

        public float getRotation() {
            return this.f10962c;
        }

        public float getScaleX() {
            return this.f10965f;
        }

        public float getScaleY() {
            return this.f10966g;
        }

        public float getTranslateX() {
            return this.f10967h;
        }

        public float getTranslateY() {
            return this.f10968i;
        }

        public void setPivotX(float f8) {
            if (f8 != this.f10963d) {
                this.f10963d = f8;
                d();
            }
        }

        public void setPivotY(float f8) {
            if (f8 != this.f10964e) {
                this.f10964e = f8;
                d();
            }
        }

        public void setRotation(float f8) {
            if (f8 != this.f10962c) {
                this.f10962c = f8;
                d();
            }
        }

        public void setScaleX(float f8) {
            if (f8 != this.f10965f) {
                this.f10965f = f8;
                d();
            }
        }

        public void setScaleY(float f8) {
            if (f8 != this.f10966g) {
                this.f10966g = f8;
                d();
            }
        }

        public void setTranslateX(float f8) {
            if (f8 != this.f10967h) {
                this.f10967h = f8;
                d();
            }
        }

        public void setTranslateY(float f8) {
            if (f8 != this.f10968i) {
                this.f10968i = f8;
                d();
            }
        }

        public d() {
            super();
            this.f10960a = new Matrix();
            this.f10961b = new ArrayList<>();
            this.f10962c = 0.0f;
            this.f10963d = 0.0f;
            this.f10964e = 0.0f;
            this.f10965f = 1.0f;
            this.f10966g = 1.0f;
            this.f10967h = 0.0f;
            this.f10968i = 0.0f;
            this.f10969j = new Matrix();
            this.f10972m = null;
        }
    }
}
