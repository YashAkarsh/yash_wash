package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.widget.TextView;
import androidx.databinding.library.baseAdapters.R;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:autoLink", method = "setAutoLinkMask", type = TextView.class), @androidx.databinding.g(attribute = "android:drawablePadding", method = "setCompoundDrawablePadding", type = TextView.class), @androidx.databinding.g(attribute = "android:editorExtras", method = "setInputExtras", type = TextView.class), @androidx.databinding.g(attribute = "android:inputType", method = "setRawInputType", type = TextView.class), @androidx.databinding.g(attribute = "android:scrollHorizontally", method = "setHorizontallyScrolling", type = TextView.class), @androidx.databinding.g(attribute = "android:textAllCaps", method = "setAllCaps", type = TextView.class), @androidx.databinding.g(attribute = "android:textColorHighlight", method = "setHighlightColor", type = TextView.class), @androidx.databinding.g(attribute = "android:textColorHint", method = "setHintTextColor", type = TextView.class), @androidx.databinding.g(attribute = "android:textColorLink", method = "setLinkTextColor", type = TextView.class), @androidx.databinding.g(attribute = "android:onEditorAction", method = "setOnEditorActionListener", type = TextView.class)})
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7220a = "TextViewBindingAdapters";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7221b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7222c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7223d = 5;

    static class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f7225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f7227d;

        a(c cVar, d dVar, androidx.databinding.m mVar, b bVar) {
            this.f7224a = cVar;
            this.f7225b = dVar;
            this.f7226c = mVar;
            this.f7227d = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            b bVar = this.f7227d;
            if (bVar != null) {
                bVar.afterTextChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            c cVar = this.f7224a;
            if (cVar != null) {
                cVar.beforeTextChanged(charSequence, i7, i8, i9);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            d dVar = this.f7225b;
            if (dVar != null) {
                dVar.onTextChanged(charSequence, i7, i8, i9);
            }
            androidx.databinding.m mVar = this.f7226c;
            if (mVar != null) {
                mVar.a();
            }
        }
    }

    public interface b {
        void afterTextChanged(Editable editable);
    }

    public interface c {
        void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9);
    }

    public interface d {
        void onTextChanged(CharSequence charSequence, int i7, int i8, int i9);
    }

    @androidx.databinding.d({"android:text"})
    public static void A(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence == null && text.length() == 0) {
                return;
            }
            if (charSequence instanceof Spanned) {
                if (charSequence.equals(text)) {
                    return;
                }
            } else if (!b(charSequence, text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    @androidx.databinding.d({"android:textSize"})
    public static void B(TextView textView, float f8) {
        textView.setTextSize(0, f8);
    }

    @androidx.databinding.d(requireAll = false, value = {"android:beforeTextChanged", "android:onTextChanged", "android:afterTextChanged", "android:textAttrChanged"})
    public static void C(TextView textView, c cVar, d dVar, b bVar, androidx.databinding.m mVar) {
        a aVar = (cVar == null && bVar == null && dVar == null && mVar == null) ? null : new a(cVar, dVar, mVar, bVar);
        TextWatcher textWatcher = (TextWatcher) r.b(textView, aVar, R.id.textWatcher);
        if (textWatcher != null) {
            textView.removeTextChangedListener(textWatcher);
        }
        if (aVar != null) {
            textView.addTextChangedListener(aVar);
        }
    }

    @androidx.databinding.l(attribute = "android:text", event = "android:textAttrChanged")
    public static String a(TextView textView) {
        return textView.getText().toString();
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) != (charSequence2 == null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (charSequence.charAt(i7) != charSequence2.charAt(i7)) {
                return true;
            }
        }
        return false;
    }

    @androidx.databinding.d({"android:autoText"})
    public static void c(TextView textView, boolean z7) {
        KeyListener keyListener = textView.getKeyListener();
        TextKeyListener.Capitalize capitalize = TextKeyListener.Capitalize.NONE;
        int inputType = keyListener != null ? keyListener.getInputType() : 0;
        if ((inputType & 4096) != 0) {
            capitalize = TextKeyListener.Capitalize.CHARACTERS;
        } else if ((inputType & 8192) != 0) {
            capitalize = TextKeyListener.Capitalize.WORDS;
        } else if ((inputType & 16384) != 0) {
            capitalize = TextKeyListener.Capitalize.SENTENCES;
        }
        textView.setKeyListener(TextKeyListener.getInstance(z7, capitalize));
    }

    @androidx.databinding.d({"android:bufferType"})
    public static void d(TextView textView, TextView.BufferType bufferType) {
        textView.setText(textView.getText(), bufferType);
    }

    @androidx.databinding.d({"android:capitalize"})
    public static void e(TextView textView, TextKeyListener.Capitalize capitalize) {
        textView.setKeyListener(TextKeyListener.getInstance((textView.getKeyListener().getInputType() & 32768) != 0, capitalize));
    }

    @androidx.databinding.d({"android:digits"})
    public static void f(TextView textView, CharSequence charSequence) {
        if (charSequence != null) {
            textView.setKeyListener(DigitsKeyListener.getInstance(charSequence.toString()));
        } else if (textView.getKeyListener() instanceof DigitsKeyListener) {
            textView.setKeyListener(null);
        }
    }

    @androidx.databinding.d({"android:drawableBottom"})
    public static void g(TextView textView, Drawable drawable) {
        p(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], drawable);
    }

    @androidx.databinding.d({"android:drawableEnd"})
    public static void h(TextView textView, Drawable drawable) {
        p(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], drawable, compoundDrawablesRelative[3]);
    }

    @androidx.databinding.d({"android:drawableLeft"})
    public static void i(TextView textView, Drawable drawable) {
        p(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    @androidx.databinding.d({"android:drawableRight"})
    public static void j(TextView textView, Drawable drawable) {
        p(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    @androidx.databinding.d({"android:drawableStart"})
    public static void k(TextView textView, Drawable drawable) {
        p(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    @androidx.databinding.d({"android:drawableTop"})
    public static void l(TextView textView, Drawable drawable) {
        p(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
    }

    @androidx.databinding.d({"android:imeActionId"})
    public static void m(TextView textView, int i7) {
        textView.setImeActionLabel(textView.getImeActionLabel(), i7);
    }

    @androidx.databinding.d({"android:imeActionLabel"})
    public static void n(TextView textView, CharSequence charSequence) {
        textView.setImeActionLabel(charSequence, textView.getImeActionId());
    }

    @androidx.databinding.d({"android:inputMethod"})
    public static void o(TextView textView, CharSequence charSequence) {
        try {
            textView.setKeyListener((KeyListener) Class.forName(charSequence.toString()).newInstance());
        } catch (ClassNotFoundException e8) {
            Log.e(f7220a, "Could not create input method: " + ((Object) charSequence), e8);
        } catch (IllegalAccessException e9) {
            Log.e(f7220a, "Could not create input method: " + ((Object) charSequence), e9);
        } catch (InstantiationException e10) {
            Log.e(f7220a, "Could not create input method: " + ((Object) charSequence), e10);
        }
    }

    private static void p(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @androidx.databinding.d({"android:lineSpacingExtra"})
    public static void q(TextView textView, float f8) {
        textView.setLineSpacing(f8, textView.getLineSpacingMultiplier());
    }

    @androidx.databinding.d({"android:lineSpacingMultiplier"})
    public static void r(TextView textView, float f8) {
        textView.setLineSpacing(textView.getLineSpacingExtra(), f8);
    }

    @androidx.databinding.d({"android:maxLength"})
    public static void s(TextView textView, int i7) {
        boolean z7;
        InputFilter[] filters = textView.getFilters();
        if (filters == null) {
            filters = new InputFilter[]{new InputFilter.LengthFilter(i7)};
        } else {
            int i8 = 0;
            while (true) {
                if (i8 >= filters.length) {
                    z7 = false;
                    break;
                }
                InputFilter inputFilter = filters[i8];
                if (inputFilter instanceof InputFilter.LengthFilter) {
                    if (((InputFilter.LengthFilter) inputFilter).getMax() != i7) {
                        filters[i8] = new InputFilter.LengthFilter(i7);
                    }
                    z7 = true;
                    break;
                }
                i8++;
            }
            if (!z7) {
                int length = filters.length + 1;
                InputFilter[] inputFilterArr = new InputFilter[length];
                System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                inputFilterArr[length - 1] = new InputFilter.LengthFilter(i7);
                filters = inputFilterArr;
            }
        }
        textView.setFilters(filters);
    }

    @androidx.databinding.d({"android:numeric"})
    public static void t(TextView textView, int i7) {
        textView.setKeyListener(DigitsKeyListener.getInstance((i7 & 3) != 0, (i7 & 5) != 0));
    }

    @androidx.databinding.d({"android:password"})
    public static void u(TextView textView, boolean z7) {
        if (z7) {
            textView.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textView.setTransformationMethod(null);
        }
    }

    @androidx.databinding.d({"android:phoneNumber"})
    public static void v(TextView textView, boolean z7) {
        if (z7) {
            textView.setKeyListener(DialerKeyListener.getInstance());
        } else if (textView.getKeyListener() instanceof DialerKeyListener) {
            textView.setKeyListener(null);
        }
    }

    @androidx.databinding.d({"android:shadowColor"})
    public static void w(TextView textView, int i7) {
        textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), textView.getShadowDy(), i7);
    }

    @androidx.databinding.d({"android:shadowDx"})
    public static void x(TextView textView, float f8) {
        int shadowColor = textView.getShadowColor();
        textView.setShadowLayer(textView.getShadowRadius(), f8, textView.getShadowDy(), shadowColor);
    }

    @androidx.databinding.d({"android:shadowDy"})
    public static void y(TextView textView, float f8) {
        int shadowColor = textView.getShadowColor();
        textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), f8, shadowColor);
    }

    @androidx.databinding.d({"android:shadowRadius"})
    public static void z(TextView textView, float f8) {
        textView.setShadowLayer(f8, textView.getShadowDx(), textView.getShadowDy(), textView.getShadowColor());
    }
}
