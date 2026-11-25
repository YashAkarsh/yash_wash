package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.w;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f7716a;

    @t0(19)
    private static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f7717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f7718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7719c = true;

        a(TextView textView) {
            this.f7717a = textView;
            this.f7718b = new d(textView);
        }

        @m0
        private InputFilter[] g(@m0 InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f7718b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f7718b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> h(@m0 InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i7 = 0; i7 < inputFilterArr.length; i7++) {
                InputFilter inputFilter = inputFilterArr[i7];
                if (inputFilter instanceof d) {
                    sparseArray.put(i7, inputFilter);
                }
            }
            return sparseArray;
        }

        @m0
        private InputFilter[] i(@m0 InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArrayH = h(inputFilterArr);
            if (sparseArrayH.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayH.size()];
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                if (sparseArrayH.indexOfKey(i8) < 0) {
                    inputFilterArr2[i7] = inputFilterArr[i8];
                    i7++;
                }
            }
            return inputFilterArr2;
        }

        @o0
        private TransformationMethod k(@o0 TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void l() {
            this.f7717a.setFilters(a(this.f7717a.getFilters()));
        }

        @m0
        private TransformationMethod m(@o0 TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        @m0
        InputFilter[] a(@m0 InputFilter[] inputFilterArr) {
            return !this.f7719c ? i(inputFilterArr) : g(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        public boolean b() {
            return this.f7719c;
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        void c(boolean z7) {
            if (z7) {
                e();
            }
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        void d(boolean z7) {
            this.f7719c = z7;
            e();
            l();
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        void e() {
            this.f7717a.setTransformationMethod(f(this.f7717a.getTransformationMethod()));
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        @o0
        TransformationMethod f(@o0 TransformationMethod transformationMethod) {
            return this.f7719c ? m(transformationMethod) : k(transformationMethod);
        }

        @x0({x0.a.LIBRARY})
        void j(boolean z7) {
            this.f7719c = z7;
        }
    }

    static class b {
        b() {
        }

        @m0
        InputFilter[] a(@m0 InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        void c(boolean z7) {
        }

        void d(boolean z7) {
        }

        void e() {
        }

        @o0
        TransformationMethod f(@o0 TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    @t0(19)
    private static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f7720a;

        c(TextView textView) {
            this.f7720a = new a(textView);
        }

        private boolean g() {
            return !androidx.emoji2.text.f.n();
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        @m0
        InputFilter[] a(@m0 InputFilter[] inputFilterArr) {
            return g() ? inputFilterArr : this.f7720a.a(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        public boolean b() {
            return this.f7720a.b();
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        void c(boolean z7) {
            if (g()) {
                return;
            }
            this.f7720a.c(z7);
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        void d(boolean z7) {
            if (g()) {
                this.f7720a.j(z7);
            } else {
                this.f7720a.d(z7);
            }
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        void e() {
            if (g()) {
                return;
            }
            this.f7720a.e();
        }

        @Override // androidx.emoji2.viewsintegration.f.b
        @o0
        TransformationMethod f(@o0 TransformationMethod transformationMethod) {
            return g() ? transformationMethod : this.f7720a.f(transformationMethod);
        }
    }

    public f(@m0 TextView textView) {
        this(textView, true);
    }

    @m0
    public InputFilter[] a(@m0 InputFilter[] inputFilterArr) {
        return this.f7716a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f7716a.b();
    }

    public void c(boolean z7) {
        this.f7716a.c(z7);
    }

    public void d(boolean z7) {
        this.f7716a.d(z7);
    }

    public void e() {
        this.f7716a.e();
    }

    @o0
    public TransformationMethod f(@o0 TransformationMethod transformationMethod) {
        return this.f7716a.f(transformationMethod);
    }

    public f(@m0 TextView textView, boolean z7) {
        w.m(textView, "textView cannot be null");
        if (z7) {
            this.f7716a = new a(textView);
        } else {
            this.f7716a = new c(textView);
        }
    }
}
