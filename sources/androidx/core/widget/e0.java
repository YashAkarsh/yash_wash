package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    public static final class a extends n0 implements i5.r<CharSequence, Integer, Integer, Integer, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7032a = new a();

        public a() {
            super(4);
        }

        @Override // i5.r
        public /* bridge */ /* synthetic */ l2 K(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            b(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return l2.f34958a;
        }

        public final void b(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    public static final class b extends n0 implements i5.r<CharSequence, Integer, Integer, Integer, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7033a = new b();

        public b() {
            super(4);
        }

        @Override // i5.r
        public /* bridge */ /* synthetic */ l2 K(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            b(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return l2.f34958a;
        }

        public final void b(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    public static final class c extends n0 implements i5.l<Editable, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f7034a = new c();

        public c() {
            super(1);
        }

        public final void b(@a7.e Editable editable) {
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Editable editable) {
            b(editable);
            return l2.f34958a;
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<Editable, l2> f7035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.r<CharSequence, Integer, Integer, Integer, l2> f7036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.r<CharSequence, Integer, Integer, Integer, l2> f7037c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(i5.l<? super Editable, l2> lVar, i5.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar, i5.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar2) {
            this.f7035a = lVar;
            this.f7036b = rVar;
            this.f7037c = rVar2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@a7.e Editable editable) {
            this.f7035a.z(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
            this.f7036b.K(charSequence, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
            this.f7037c.K(charSequence, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        }
    }

    public static final class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f7038a;

        public e(i5.l lVar) {
            this.f7038a = lVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@a7.e Editable editable) {
            this.f7038a.z(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    public static final class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.r f7039a;

        public f(i5.r rVar) {
            this.f7039a = rVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@a7.e Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
            this.f7039a.K(charSequence, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.r f7040a;

        public g(i5.r rVar) {
            this.f7040a = rVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@a7.e Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@a7.e CharSequence charSequence, int i7, int i8, int i9) {
            this.f7040a.K(charSequence, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        }
    }

    @a7.d
    public static final TextWatcher a(@a7.d TextView textView, @a7.d i5.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> beforeTextChanged, @a7.d i5.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> onTextChanged, @a7.d i5.l<? super Editable, l2> afterTextChanged) {
        l0.p(textView, "<this>");
        l0.p(beforeTextChanged, "beforeTextChanged");
        l0.p(onTextChanged, "onTextChanged");
        l0.p(afterTextChanged, "afterTextChanged");
        d dVar = new d(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(dVar);
        return dVar;
    }

    public static /* synthetic */ TextWatcher b(TextView textView, i5.r beforeTextChanged, i5.r onTextChanged, i5.l afterTextChanged, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            beforeTextChanged = a.f7032a;
        }
        if ((i7 & 2) != 0) {
            onTextChanged = b.f7033a;
        }
        if ((i7 & 4) != 0) {
            afterTextChanged = c.f7034a;
        }
        l0.p(textView, "<this>");
        l0.p(beforeTextChanged, "beforeTextChanged");
        l0.p(onTextChanged, "onTextChanged");
        l0.p(afterTextChanged, "afterTextChanged");
        d dVar = new d(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(dVar);
        return dVar;
    }

    @a7.d
    public static final TextWatcher c(@a7.d TextView textView, @a7.d i5.l<? super Editable, l2> action) {
        l0.p(textView, "<this>");
        l0.p(action, "action");
        e eVar = new e(action);
        textView.addTextChangedListener(eVar);
        return eVar;
    }

    @a7.d
    public static final TextWatcher d(@a7.d TextView textView, @a7.d i5.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> action) {
        l0.p(textView, "<this>");
        l0.p(action, "action");
        f fVar = new f(action);
        textView.addTextChangedListener(fVar);
        return fVar;
    }

    @a7.d
    public static final TextWatcher e(@a7.d TextView textView, @a7.d i5.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> action) {
        l0.p(textView, "<this>");
        l0.p(action, "action");
        g gVar = new g(action);
        textView.addTextChangedListener(gVar);
        return gVar;
    }
}
