package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.e1;
import androidx.core.view.n2;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import c.m0;
import c.o0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f832h = "AppCompatViewInflater";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f834a = new Object[2];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f826b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f827c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f828d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f829e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f830f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f831g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final androidx.collection.i<String, Constructor<? extends View>> f833i = new androidx.collection.i<>();

    private static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f838d;

        public a(@m0 View view, @m0 String str) {
            this.f835a = view;
            this.f836b = str;
        }

        private void a(@o0 Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f836b, View.class)) != null) {
                        this.f837c = method;
                        this.f838d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f835a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.f835a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f836b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f835a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@m0 View view) {
            if (this.f837c == null) {
                a(this.f835a.getContext());
            }
            try {
                this.f837c.invoke(this.f838d, view);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException("Could not execute method for android:onClick", e9);
            }
        }
    }

    private void a(@m0 Context context, @m0 View view, @m0 AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f828d);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            n2.C1(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f829e);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            n2.E1(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f830f);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            n2.n2(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && n2.K0(view)) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f827c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        String str3;
        androidx.collection.i<String, Constructor<? extends View>> iVar = f833i;
        Constructor<? extends View> constructor = iVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f826b);
            iVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f834a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(ViewHierarchyConstants.VIEW_KEY)) {
            str = attributeSet.getAttributeValue(null, InstrumentationResultPrinter.f10179m);
        }
        try {
            Object[] objArr = this.f834a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i7 = 0;
            while (true) {
                String[] strArr = f831g;
                if (i7 >= strArr.length) {
                    return null;
                }
                View viewS = s(context, str, strArr[i7]);
                if (viewS != null) {
                    return viewS;
                }
                i7++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f834a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z7, boolean z8) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.View, 0, 0);
        int resourceId = z7 ? typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (z8 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0)) != 0) {
            Log.i(f832h, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).c() == resourceId) ? context : new androidx.appcompat.view.d(context, resourceId);
        }
        return context;
    }

    private void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    @m0
    protected AppCompatAutoCompleteTextView c(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    @m0
    protected AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    @m0
    protected AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    @m0
    protected AppCompatCheckedTextView f(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    @m0
    protected AppCompatEditText g(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    @m0
    protected AppCompatImageButton h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    @m0
    protected AppCompatImageView i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    @m0
    protected AppCompatMultiAutoCompleteTextView j(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    @m0
    protected AppCompatRadioButton k(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    @m0
    protected AppCompatRatingBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    @m0
    protected AppCompatSeekBar m(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    @m0
    protected AppCompatSpinner n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    @m0
    protected AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    @m0
    protected AppCompatToggleButton p(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    @o0
    protected View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    final View r(View view, String str, @m0 Context context, @m0 AttributeSet attributeSet, boolean z7, boolean z8, boolean z9, boolean z10) {
        View viewL;
        Context context2 = (!z7 || view == null) ? context : view.getContext();
        if (z8 || z9) {
            context2 = u(context2, attributeSet, z8, z9);
        }
        if (z10) {
            context2 = e1.b(context2);
        }
        str.hashCode();
        byte b8 = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    b8 = 0;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    b8 = 1;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    b8 = 2;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    b8 = 3;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    b8 = 4;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    b8 = 5;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    b8 = 6;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    b8 = 7;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    b8 = 8;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    b8 = 9;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    b8 = 10;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
        }
        switch (b8) {
            case 0:
                viewL = l(context2, attributeSet);
                v(viewL, str);
                break;
            case 1:
                viewL = f(context2, attributeSet);
                v(viewL, str);
                break;
            case 2:
                viewL = j(context2, attributeSet);
                v(viewL, str);
                break;
            case 3:
                viewL = o(context2, attributeSet);
                v(viewL, str);
                break;
            case 4:
                viewL = h(context2, attributeSet);
                v(viewL, str);
                break;
            case 5:
                viewL = m(context2, attributeSet);
                v(viewL, str);
                break;
            case 6:
                viewL = n(context2, attributeSet);
                v(viewL, str);
                break;
            case 7:
                viewL = k(context2, attributeSet);
                v(viewL, str);
                break;
            case 8:
                viewL = p(context2, attributeSet);
                v(viewL, str);
                break;
            case 9:
                viewL = i(context2, attributeSet);
                v(viewL, str);
                break;
            case 10:
                viewL = c(context2, attributeSet);
                v(viewL, str);
                break;
            case 11:
                viewL = e(context2, attributeSet);
                v(viewL, str);
                break;
            case 12:
                viewL = g(context2, attributeSet);
                v(viewL, str);
                break;
            case 13:
                viewL = d(context2, attributeSet);
                v(viewL, str);
                break;
            default:
                viewL = q(context2, str, attributeSet);
                break;
        }
        if (viewL == null && context != context2) {
            viewL = t(context2, str, attributeSet);
        }
        if (viewL != null) {
            b(viewL, attributeSet);
            a(context2, viewL, attributeSet);
        }
        return viewL;
    }
}
