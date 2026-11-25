package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.n2;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements androidx.appcompat.view.c {

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    static final boolean f1594c1 = false;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    static final String f1595d1 = "SearchView";

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private static final String f1596e1 = "nm";

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    static final o f1597f1;
    private l A0;
    final SearchAutoComplete B;
    View.OnFocusChangeListener B0;
    private final View C;
    private n C0;
    private final View D;
    private View.OnClickListener D0;
    private final View E;
    private boolean E0;
    final ImageView F;
    private boolean F0;
    final ImageView G;
    androidx.cursoradapter.widget.a G0;
    final ImageView H;
    private boolean H0;
    final ImageView I;
    private CharSequence I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final View f1598J;
    private boolean J0;
    private p K;
    private boolean K0;
    private Rect L;
    private int L0;
    private Rect M;
    private boolean M0;
    private int[] N;
    private CharSequence N0;
    private int[] O;
    private CharSequence O0;
    private final ImageView P;
    private boolean P0;
    private final Drawable Q;
    private int Q0;
    private final int R;
    SearchableInfo R0;
    private final int S;
    private Bundle S0;
    private final Intent T;
    private final Runnable T0;
    private final Intent U;
    private Runnable U0;
    private final CharSequence V;
    private final WeakHashMap<String, Drawable.ConstantState> V0;
    private m W;
    private final View.OnClickListener W0;
    View.OnKeyListener X0;
    private final TextView.OnEditorActionListener Y0;
    private final AdapterView.OnItemClickListener Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f1599a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private TextWatcher f1600b1;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1601c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1601c + com.alipay.sdk.util.j.f13808d;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeValue(Boolean.valueOf(this.f1601c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1601c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private SearchView f1603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Runnable f1605h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.e();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i7 = configuration.screenWidthDp;
            int i8 = configuration.screenHeightDp;
            if (i7 >= 960 && i8 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i7 >= 600) {
                return com.alibaba.fastjson.asm.j.f12606c0;
            }
            if (i7 < 640 || i8 < 480) {
                return 160;
            }
            return com.alibaba.fastjson.asm.j.f12606c0;
        }

        void c() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f1597f1.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean d() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void e() {
            if (this.f1604g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1604g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1602e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1604g) {
                removeCallbacks(this.f1605h);
                post(this.f1605h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z7, int i7, Rect rect) {
            super.onFocusChanged(z7, i7, rect);
            this.f1603f.f0();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i7, KeyEvent keyEvent) {
            if (i7 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1603f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i7, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z7) {
            super.onWindowFocusChanged(z7);
            if (z7 && this.f1603f.hasFocus() && getVisibility() == 0) {
                this.f1604g = true;
                if (SearchView.Q(getContext())) {
                    c();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z7) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z7) {
                this.f1604g = false;
                removeCallbacks(this.f1605h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f1604g = true;
                    return;
                }
                this.f1604g = false;
                removeCallbacks(this.f1605h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f1603f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i7) {
            super.setThreshold(i7);
            this.f1602e = i7;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i7) {
            super(context, attributeSet, i7);
            this.f1605h = new a();
            this.f1602e = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            SearchView.this.e0(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.k0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.cursoradapter.widget.a aVar = SearchView.this.G0;
            if (aVar instanceof b1) {
                aVar.b(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z7) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.B0;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z7);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            SearchView.this.E();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.F) {
                searchView.b0();
                return;
            }
            if (view == searchView.H) {
                searchView.X();
                return;
            }
            if (view == searchView.G) {
                searchView.c0();
            } else if (view == searchView.I) {
                searchView.g0();
            } else if (view == searchView.B) {
                searchView.K();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i7, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.R0 == null) {
                return false;
            }
            if (searchView.B.isPopupShowing() && SearchView.this.B.getListSelection() != -1) {
                return SearchView.this.d0(view, i7, keyEvent);
            }
            if (SearchView.this.B.d() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i7 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.V(0, null, searchView2.B.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
            SearchView.this.c0();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            SearchView.this.Y(i7, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j7) {
            SearchView.this.Z(i7);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @c.t0(29)
    static class k {
        private k() {
        }

        @c.t
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        @c.t
        static void b(SearchAutoComplete searchAutoComplete, int i7) {
            searchAutoComplete.setInputMethodMode(i7);
        }
    }

    public interface l {
        boolean onClose();
    }

    public interface m {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface n {
        boolean onSuggestionClick(int i7);

        boolean onSuggestionSelect(int i7);
    }

    private static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f1617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f1618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f1619c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        o() {
            this.f1617a = null;
            this.f1618b = null;
            this.f1619c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1617a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1618b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1619c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1618b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1617a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1619c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static class p extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f1620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f1621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Rect f1622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f1623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f1624e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1625f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1624e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1621b = new Rect();
            this.f1623d = new Rect();
            this.f1622c = new Rect();
            a(rect, rect2);
            this.f1620a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1621b.set(rect);
            this.f1623d.set(rect);
            Rect rect3 = this.f1623d;
            int i7 = this.f1624e;
            rect3.inset(-i7, -i7);
            this.f1622c.set(rect2);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003f  */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z7;
            boolean z8;
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z9 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z8 = this.f1625f;
                    if (z8 && !this.f1623d.contains(x7, y7)) {
                        z9 = z8;
                        z7 = false;
                    }
                } else if (action != 3) {
                    z7 = true;
                    z9 = false;
                } else {
                    z8 = this.f1625f;
                    this.f1625f = false;
                }
                z9 = z8;
                z7 = true;
            } else if (this.f1621b.contains(x7, y7)) {
                this.f1625f = true;
                z7 = true;
            } else {
                z7 = true;
                z9 = false;
            }
            if (!z9) {
                return false;
            }
            if (!z7 || this.f1622c.contains(x7, y7)) {
                Rect rect = this.f1622c;
                motionEvent.setLocation(x7 - rect.left, y7 - rect.top);
            } else {
                motionEvent.setLocation(this.f1620a.getWidth() / 2, this.f1620a.getHeight() / 2);
            }
            return this.f1620a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f1597f1 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(@c.m0 Context context) {
        this(context, null);
    }

    private Intent F(String str, Uri uri, String str2, String str3, int i7, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.O0);
        if (str3 != null) {
            intent.putExtra(b1.d.f11283b, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.S0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i7 != 0) {
            intent.putExtra("action_key", i7);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.R0.getSearchActivity());
        return intent;
    }

    private Intent G(Cursor cursor, int i7, String str) {
        int position;
        String strU;
        try {
            String strU2 = b1.u(cursor, "suggest_intent_action");
            if (strU2 == null) {
                strU2 = this.R0.getSuggestIntentAction();
            }
            if (strU2 == null) {
                strU2 = "android.intent.action.SEARCH";
            }
            String str2 = strU2;
            String strU3 = b1.u(cursor, "suggest_intent_data");
            if (strU3 == null) {
                strU3 = this.R0.getSuggestIntentData();
            }
            if (strU3 != null && (strU = b1.u(cursor, "suggest_intent_data_id")) != null) {
                strU3 = strU3 + "/" + Uri.encode(strU);
            }
            return F(str2, strU3 == null ? null : Uri.parse(strU3), b1.u(cursor, "suggest_intent_extra_data"), b1.u(cursor, "suggest_intent_query"), i7, str);
        } catch (RuntimeException e8) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w(f1595d1, "Search suggestions cursor at row " + position + " returned exception.", e8);
            return null;
        }
    }

    private Intent H(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.S0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent I(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void J() {
        this.B.dismissDropDown();
    }

    private void L(View view, Rect rect) {
        view.getLocationInWindow(this.N);
        getLocationInWindow(this.O);
        int[] iArr = this.N;
        int i7 = iArr[1];
        int[] iArr2 = this.O;
        int i8 = i7 - iArr2[1];
        int i9 = iArr[0] - iArr2[0];
        rect.set(i9, i8, view.getWidth() + i9, view.getHeight() + i8);
    }

    private CharSequence M(CharSequence charSequence) {
        if (!this.E0 || this.Q == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.B.getTextSize()) * 1.25d);
        this.Q.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.Q), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean N() {
        Intent intent;
        SearchableInfo searchableInfo = this.R0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.R0.getVoiceSearchLaunchWebSearch()) {
            intent = this.T;
        } else {
            intent = this.R0.getVoiceSearchLaunchRecognizer() ? this.U : null;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean Q(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean S() {
        return (this.H0 || this.M0) && !P();
    }

    private void U(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e8) {
            Log.e(f1595d1, "Failed launch activity: " + intent, e8);
        }
    }

    private boolean W(int i7, int i8, String str) {
        Cursor cursorC = this.G0.c();
        if (cursorC == null || !cursorC.moveToPosition(i7)) {
            return false;
        }
        U(G(cursorC, i8, str));
        return true;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void h0() {
        post(this.T0);
    }

    private void i0(int i7) {
        Editable text = this.B.getText();
        Cursor cursorC = this.G0.c();
        if (cursorC == null) {
            return;
        }
        if (!cursorC.moveToPosition(i7)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceA = this.G0.a(cursorC);
        if (charSequenceA != null) {
            setQuery(charSequenceA);
        } else {
            setQuery(text);
        }
    }

    private void j0() {
        boolean z7 = true;
        boolean z8 = !TextUtils.isEmpty(this.B.getText());
        if (!z8 && (!this.E0 || this.P0)) {
            z7 = false;
        }
        this.H.setVisibility(z7 ? 0 : 8);
        Drawable drawable = this.H.getDrawable();
        if (drawable != null) {
            drawable.setState(z8 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void l0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.B;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(M(queryHint));
    }

    private void m0() {
        this.B.setThreshold(this.R0.getSuggestThreshold());
        this.B.setImeOptions(this.R0.getImeOptions());
        int inputType = this.R0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.R0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.B.setInputType(inputType);
        androidx.cursoradapter.widget.a aVar = this.G0;
        if (aVar != null) {
            aVar.b(null);
        }
        if (this.R0.getSuggestAuthority() != null) {
            b1 b1Var = new b1(getContext(), this, this.R0, this.V0);
            this.G0 = b1Var;
            this.B.setAdapter(b1Var);
            ((b1) this.G0).E(this.J0 ? 2 : 1);
        }
    }

    private void n0() {
        this.E.setVisibility((S() && (this.G.getVisibility() == 0 || this.I.getVisibility() == 0)) ? 0 : 8);
    }

    private void o0(boolean z7) {
        this.G.setVisibility((this.H0 && S() && hasFocus() && (z7 || !this.M0)) ? 0 : 8);
    }

    private void p0(boolean z7) {
        this.F0 = z7;
        int i7 = z7 ? 0 : 8;
        boolean z8 = !TextUtils.isEmpty(this.B.getText());
        this.F.setVisibility(i7);
        o0(z8);
        this.C.setVisibility(z7 ? 8 : 0);
        this.P.setVisibility((this.P.getDrawable() == null || this.E0) ? 8 : 0);
        j0();
        q0(!z8);
        n0();
    }

    private void q0(boolean z7) {
        int i7 = 8;
        if (this.M0 && !P() && z7) {
            this.G.setVisibility(8);
            i7 = 0;
        }
        this.I.setVisibility(i7);
    }

    void E() {
        if (this.f1598J.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.D.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = r1.b(this);
            int dimensionPixelSize = this.E0 ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.B.getDropDownBackground().getPadding(rect);
            this.B.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.B.setDropDownWidth((((this.f1598J.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void K() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.B);
            return;
        }
        o oVar = f1597f1;
        oVar.b(this.B);
        oVar.a(this.B);
    }

    public boolean O() {
        return this.E0;
    }

    public boolean P() {
        return this.F0;
    }

    public boolean R() {
        return this.J0;
    }

    public boolean T() {
        return this.H0;
    }

    void V(int i7, String str, String str2) {
        getContext().startActivity(F("android.intent.action.SEARCH", null, null, str2, i7, str));
    }

    void X() {
        if (!TextUtils.isEmpty(this.B.getText())) {
            this.B.setText("");
            this.B.requestFocus();
            this.B.setImeVisibility(true);
        } else if (this.E0) {
            l lVar = this.A0;
            if (lVar == null || !lVar.onClose()) {
                clearFocus();
                p0(true);
            }
        }
    }

    boolean Y(int i7, int i8, String str) {
        n nVar = this.C0;
        if (nVar != null && nVar.onSuggestionClick(i7)) {
            return false;
        }
        W(i7, 0, null);
        this.B.setImeVisibility(false);
        J();
        return true;
    }

    boolean Z(int i7) {
        n nVar = this.C0;
        if (nVar != null && nVar.onSuggestionSelect(i7)) {
            return false;
        }
        i0(i7);
        return true;
    }

    protected void a0(@c.o0 CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // androidx.appcompat.view.c
    public void b() {
        if (this.P0) {
            return;
        }
        this.P0 = true;
        int imeOptions = this.B.getImeOptions();
        this.Q0 = imeOptions;
        this.B.setImeOptions(imeOptions | 33554432);
        this.B.setText("");
        setIconified(false);
    }

    void b0() {
        p0(false);
        this.B.requestFocus();
        this.B.setImeVisibility(true);
        View.OnClickListener onClickListener = this.D0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // androidx.appcompat.view.c
    public void c() {
        setQuery("", false);
        clearFocus();
        p0(true);
        this.B.setImeOptions(this.Q0);
        this.P0 = false;
    }

    void c0() {
        Editable text = this.B.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.W;
        if (mVar == null || !mVar.onQueryTextSubmit(text.toString())) {
            if (this.R0 != null) {
                V(0, null, text.toString());
            }
            this.B.setImeVisibility(false);
            J();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.K0 = true;
        super.clearFocus();
        this.B.clearFocus();
        this.B.setImeVisibility(false);
        this.K0 = false;
    }

    boolean d0(View view, int i7, KeyEvent keyEvent) {
        if (this.R0 != null && this.G0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i7 == 66 || i7 == 84 || i7 == 61) {
                return Y(this.B.getListSelection(), 0, null);
            }
            if (i7 == 21 || i7 == 22) {
                this.B.setSelection(i7 == 21 ? 0 : this.B.length());
                this.B.setListSelection(0);
                this.B.clearListSelection();
                this.B.c();
                return true;
            }
            if (i7 == 19) {
                this.B.getListSelection();
                return false;
            }
        }
        return false;
    }

    void e0(CharSequence charSequence) {
        Editable text = this.B.getText();
        this.O0 = text;
        boolean z7 = !TextUtils.isEmpty(text);
        o0(z7);
        q0(!z7);
        j0();
        n0();
        if (this.W != null && !TextUtils.equals(charSequence, this.N0)) {
            this.W.onQueryTextChange(charSequence.toString());
        }
        this.N0 = charSequence.toString();
    }

    void f0() {
        p0(P());
        h0();
        if (this.B.hasFocus()) {
            K();
        }
    }

    void g0() {
        SearchableInfo searchableInfo = this.R0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(I(this.T, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(H(this.U, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w(f1595d1, "Could not find voice search activity");
        }
    }

    public int getImeOptions() {
        return this.B.getImeOptions();
    }

    public int getInputType() {
        return this.B.getInputType();
    }

    public int getMaxWidth() {
        return this.L0;
    }

    public CharSequence getQuery() {
        return this.B.getText();
    }

    @c.o0
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.I0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.R0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.V : getContext().getText(this.R0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.S;
    }

    int getSuggestionRowLayout() {
        return this.R;
    }

    public androidx.cursoradapter.widget.a getSuggestionsAdapter() {
        return this.G0;
    }

    void k0() {
        int[] iArr = this.B.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.D.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.E.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.T0);
        post(this.U0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        if (z7) {
            L(this.B, this.L);
            Rect rect = this.M;
            Rect rect2 = this.L;
            rect.set(rect2.left, 0, rect2.right, i10 - i8);
            p pVar = this.K;
            if (pVar != null) {
                pVar.a(this.M, this.L);
                return;
            }
            p pVar2 = new p(this.M, this.L, this.B);
            this.K = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i7, int i8) {
        int i9;
        if (P()) {
            super.onMeasure(i7, i8);
            return;
        }
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        if (mode == Integer.MIN_VALUE) {
            int i10 = this.L0;
            size = i10 > 0 ? Math.min(i10, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.L0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i9 = this.L0) > 0) {
            size = Math.min(i9, size);
        }
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        p0(savedState.f1601c);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1601c = P();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z7) {
        super.onWindowFocusChanged(z7);
        h0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i7, Rect rect) {
        if (this.K0 || !isFocusable()) {
            return false;
        }
        if (P()) {
            return super.requestFocus(i7, rect);
        }
        boolean zRequestFocus = this.B.requestFocus(i7, rect);
        if (zRequestFocus) {
            p0(false);
        }
        return zRequestFocus;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.S0 = bundle;
    }

    public void setIconified(boolean z7) {
        if (z7) {
            X();
        } else {
            b0();
        }
    }

    public void setIconifiedByDefault(boolean z7) {
        if (this.E0 == z7) {
            return;
        }
        this.E0 = z7;
        p0(z7);
        l0();
    }

    public void setImeOptions(int i7) {
        this.B.setImeOptions(i7);
    }

    public void setInputType(int i7) {
        this.B.setInputType(i7);
    }

    public void setMaxWidth(int i7) {
        this.L0 = i7;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.A0 = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.B0 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.W = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.D0 = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.C0 = nVar;
    }

    public void setQuery(CharSequence charSequence, boolean z7) {
        this.B.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.B;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.O0 = charSequence;
        }
        if (!z7 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        c0();
    }

    public void setQueryHint(@c.o0 CharSequence charSequence) {
        this.I0 = charSequence;
        l0();
    }

    public void setQueryRefinementEnabled(boolean z7) {
        this.J0 = z7;
        androidx.cursoradapter.widget.a aVar = this.G0;
        if (aVar instanceof b1) {
            ((b1) aVar).E(z7 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.R0 = searchableInfo;
        if (searchableInfo != null) {
            m0();
            l0();
        }
        boolean zN = N();
        this.M0 = zN;
        if (zN) {
            this.B.setPrivateImeOptions(f1596e1);
        }
        p0(P());
    }

    public void setSubmitButtonEnabled(boolean z7) {
        this.H0 = z7;
        p0(P());
    }

    public void setSuggestionsAdapter(androidx.cursoradapter.widget.a aVar) {
        this.G0 = aVar;
        this.B.setAdapter(aVar);
    }

    public SearchView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.L = new Rect();
        this.M = new Rect();
        this.N = new int[2];
        this.O = new int[2];
        this.T0 = new b();
        this.U0 = new c();
        this.V0 = new WeakHashMap<>();
        f fVar = new f();
        this.W0 = fVar;
        this.X0 = new g();
        h hVar = new h();
        this.Y0 = hVar;
        i iVar = new i();
        this.Z0 = iVar;
        j jVar = new j();
        this.f1599a1 = jVar;
        this.f1600b1 = new a();
        h1 h1VarG = h1.G(context, attributeSet, R.styleable.SearchView, i7, 0);
        n2.z1(this, context, R.styleable.SearchView, attributeSet, h1VarG.B(), i7, 0);
        LayoutInflater.from(context).inflate(h1VarG.u(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.B = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.C = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.D = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.E = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.F = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.G = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.H = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.I = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.P = imageView5;
        n2.I1(viewFindViewById, h1VarG.h(R.styleable.SearchView_queryBackground));
        n2.I1(viewFindViewById2, h1VarG.h(R.styleable.SearchView_submitBackground));
        imageView.setImageDrawable(h1VarG.h(R.styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(h1VarG.h(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(h1VarG.h(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(h1VarG.h(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(h1VarG.h(R.styleable.SearchView_searchIcon));
        this.Q = h1VarG.h(R.styleable.SearchView_searchHintIcon);
        l1.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.R = h1VarG.u(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.S = h1VarG.u(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f1600b1);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.X0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(h1VarG.a(R.styleable.SearchView_iconifiedByDefault, true));
        int iG = h1VarG.g(R.styleable.SearchView_android_maxWidth, -1);
        if (iG != -1) {
            setMaxWidth(iG);
        }
        this.V = h1VarG.x(R.styleable.SearchView_defaultQueryHint);
        this.I0 = h1VarG.x(R.styleable.SearchView_queryHint);
        int iO = h1VarG.o(R.styleable.SearchView_android_imeOptions, -1);
        if (iO != -1) {
            setImeOptions(iO);
        }
        int iO2 = h1VarG.o(R.styleable.SearchView_android_inputType, -1);
        if (iO2 != -1) {
            setInputType(iO2);
        }
        setFocusable(h1VarG.a(R.styleable.SearchView_android_focusable, true));
        h1VarG.I();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.T = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.U = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1598J = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        p0(this.E0);
        l0();
    }

    private void setQuery(CharSequence charSequence) {
        this.B.setText(charSequence);
        this.B.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }
}
