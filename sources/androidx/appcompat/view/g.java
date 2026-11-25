package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.k0;
import androidx.core.view.z0;
import c.h0;
import c.x0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f1029e = "SupportMenuInflater";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f1030f = "menu";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f1031g = "group";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f1032h = "item";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f1033i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Class<?>[] f1034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final Class<?>[] f1035k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object[] f1036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f1037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f1038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f1039d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Class<?>[] f1040c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f1041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f1042b;

        public a(Object obj, String str) {
            this.f1041a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1042b = cls.getMethod(str, f1040c);
            } catch (Exception e8) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e8);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1042b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1042b.invoke(this.f1041a, menuItem)).booleanValue();
                }
                this.f1042b.invoke(this.f1041a, menuItem);
                return true;
            } catch (Exception e8) {
                throw new RuntimeException(e8);
            }
        }
    }

    private class b {
        private static final int G = 0;
        private static final int H = 0;
        private static final int I = 0;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private static final int f1043J = 0;
        private static final int K = 0;
        private static final boolean L = false;
        private static final boolean M = true;
        private static final boolean N = true;
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Menu f1044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1047d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1048e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1049f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1050g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f1051h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1052i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f1053j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CharSequence f1054k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private CharSequence f1055l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f1056m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private char f1057n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f1058o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private char f1059p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f1060q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f1061r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f1062s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f1063t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f1064u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f1065v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f1066w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private String f1067x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f1068y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private String f1069z;

        public b(Menu menu) {
            this.f1044a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f1038c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e8) {
                Log.w(g.f1029e, "Cannot instantiate class: " + str, e8);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z7 = false;
            menuItem.setChecked(this.f1062s).setVisible(this.f1063t).setEnabled(this.f1064u).setCheckable(this.f1061r >= 1).setTitleCondensed(this.f1055l).setIcon(this.f1056m);
            int i7 = this.f1065v;
            if (i7 >= 0) {
                menuItem.setShowAsAction(i7);
            }
            if (this.f1069z != null) {
                if (g.this.f1038c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f1069z));
            }
            if (this.f1061r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.j) {
                    ((androidx.appcompat.view.menu.j) menuItem).w(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.k) {
                    ((androidx.appcompat.view.menu.k) menuItem).j(true);
                }
            }
            String str = this.f1067x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f1034j, g.this.f1036a));
                z7 = true;
            }
            int i8 = this.f1066w;
            if (i8 > 0) {
                if (z7) {
                    Log.w(g.f1029e, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i8);
                }
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                z0.l(menuItem, bVar);
            }
            z0.p(menuItem, this.B);
            z0.w(menuItem, this.C);
            z0.o(menuItem, this.f1057n, this.f1058o);
            z0.s(menuItem, this.f1059p, this.f1060q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                z0.r(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                z0.q(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f1051h = true;
            i(this.f1044a.add(this.f1045b, this.f1052i, this.f1053j, this.f1054k));
        }

        public SubMenu b() {
            this.f1051h = true;
            SubMenu subMenuAddSubMenu = this.f1044a.addSubMenu(this.f1045b, this.f1052i, this.f1053j, this.f1054k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f1051h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f1038c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f1045b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f1046c = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f1047d = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f1048e = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1049f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f1050g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            h1 h1VarF = h1.F(g.this.f1038c, attributeSet, R.styleable.MenuItem);
            this.f1052i = h1VarF.u(R.styleable.MenuItem_android_id, 0);
            this.f1053j = (h1VarF.o(R.styleable.MenuItem_android_menuCategory, this.f1046c) & k.a.f34390c) | (h1VarF.o(R.styleable.MenuItem_android_orderInCategory, this.f1047d) & 65535);
            this.f1054k = h1VarF.x(R.styleable.MenuItem_android_title);
            this.f1055l = h1VarF.x(R.styleable.MenuItem_android_titleCondensed);
            this.f1056m = h1VarF.u(R.styleable.MenuItem_android_icon, 0);
            this.f1057n = c(h1VarF.w(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f1058o = h1VarF.o(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f1059p = c(h1VarF.w(R.styleable.MenuItem_android_numericShortcut));
            this.f1060q = h1VarF.o(R.styleable.MenuItem_numericModifiers, 4096);
            if (h1VarF.C(R.styleable.MenuItem_android_checkable)) {
                this.f1061r = h1VarF.a(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1061r = this.f1048e;
            }
            this.f1062s = h1VarF.a(R.styleable.MenuItem_android_checked, false);
            this.f1063t = h1VarF.a(R.styleable.MenuItem_android_visible, this.f1049f);
            this.f1064u = h1VarF.a(R.styleable.MenuItem_android_enabled, this.f1050g);
            this.f1065v = h1VarF.o(R.styleable.MenuItem_showAsAction, -1);
            this.f1069z = h1VarF.w(R.styleable.MenuItem_android_onClick);
            this.f1066w = h1VarF.u(R.styleable.MenuItem_actionLayout, 0);
            this.f1067x = h1VarF.w(R.styleable.MenuItem_actionViewClass);
            String strW = h1VarF.w(R.styleable.MenuItem_actionProviderClass);
            this.f1068y = strW;
            boolean z7 = strW != null;
            if (z7 && this.f1066w == 0 && this.f1067x == null) {
                this.A = (androidx.core.view.b) e(strW, g.f1035k, g.this.f1037b);
            } else {
                if (z7) {
                    Log.w(g.f1029e, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = h1VarF.x(R.styleable.MenuItem_contentDescription);
            this.C = h1VarF.x(R.styleable.MenuItem_tooltipText);
            if (h1VarF.C(R.styleable.MenuItem_iconTintMode)) {
                this.E = k0.e(h1VarF.o(R.styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (h1VarF.C(R.styleable.MenuItem_iconTint)) {
                this.D = h1VarF.d(R.styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            h1VarF.I();
            this.f1051h = false;
        }

        public void h() {
            this.f1045b = 0;
            this.f1046c = 0;
            this.f1047d = 0;
            this.f1048e = 0;
            this.f1049f = true;
            this.f1050g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f1034j = clsArr;
        f1035k = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f1038c = context;
        Object[] objArr = {context};
        this.f1036a = objArr;
        this.f1037b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals(f1030f)) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        boolean z7 = false;
        boolean z8 = false;
        String str = null;
        while (!z7) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z8 && name2.equals(str)) {
                        z8 = false;
                        str = null;
                    } else if (name2.equals(f1031g)) {
                        bVar.h();
                    } else if (name2.equals(f1032h)) {
                        if (!bVar.d()) {
                            androidx.core.view.b bVar2 = bVar.A;
                            if (bVar2 == null || !bVar2.b()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals(f1030f)) {
                        z7 = true;
                    }
                }
            } else if (!z8) {
                String name3 = xmlPullParser.getName();
                if (name3.equals(f1031g)) {
                    bVar.f(attributeSet);
                } else if (name3.equals(f1032h)) {
                    bVar.g(attributeSet);
                } else if (name3.equals(f1030f)) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z8 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f1039d == null) {
            this.f1039d = a(this.f1038c);
        }
        return this.f1039d;
    }

    @Override // android.view.MenuInflater
    public void inflate(@h0 int i7, Menu menu) {
        if (!(menu instanceof k.a)) {
            super.inflate(i7, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f1038c.getResources().getLayout(i7);
                    c(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (XmlPullParserException e8) {
                    throw new InflateException("Error inflating menu XML", e8);
                }
            } catch (IOException e9) {
                throw new InflateException("Error inflating menu XML", e9);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
