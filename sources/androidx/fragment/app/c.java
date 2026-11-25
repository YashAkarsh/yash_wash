package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import c.b1;
import c.h0;
import c.j0;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;

    @o0
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private androidx.lifecycle.x<androidx.lifecycle.q> mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            c.this.mOnDismissListener.onDismiss(c.this.mDialog);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(@o0 DialogInterface dialogInterface) {
            if (c.this.mDialog != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.mDialog);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    class DialogInterfaceOnDismissListenerC0097c implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC0097c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(@o0 DialogInterface dialogInterface) {
            if (c.this.mDialog != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.mDialog);
            }
        }
    }

    class d implements androidx.lifecycle.x<androidx.lifecycle.q> {
        d() {
        }

        @Override // androidx.lifecycle.x
        @SuppressLint({"SyntheticAccessor"})
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.q qVar) {
            if (qVar == null || !c.this.mShowsDialog) {
                return;
            }
            View viewRequireView = c.this.requireView();
            if (viewRequireView.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (c.this.mDialog != null) {
                if (FragmentManager.T0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + c.this.mDialog);
                }
                c.this.mDialog.setContentView(viewRequireView);
            }
        }
    }

    class e extends androidx.fragment.app.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.fragment.app.e f7950a;

        e(androidx.fragment.app.e eVar) {
            this.f7950a = eVar;
        }

        @Override // androidx.fragment.app.e
        @o0
        public View c(int i7) {
            return this.f7950a.d() ? this.f7950a.c(i7) : c.this.onFindViewById(i7);
        }

        @Override // androidx.fragment.app.e
        public boolean d() {
            return this.f7950a.d() || c.this.onHasView();
        }
    }

    public c() {
        this.mDismissRunnable = new a();
        this.mOnCancelListener = new b();
        this.mOnDismissListener = new DialogInterfaceOnDismissListenerC0097c();
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new d();
        this.mDialogCreated = false;
    }

    private void A(boolean z7, boolean z8) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z8) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            getParentFragmentManager().m1(this.mBackStackId, 1);
            this.mBackStackId = -1;
            return;
        }
        v vVarR = getParentFragmentManager().r();
        vVarR.C(this);
        if (z7) {
            vVarR.s();
        } else {
            vVarR.r();
        }
    }

    private void B(@o0 Bundle bundle) {
        if (this.mShowsDialog && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog dialogOnCreateDialog = onCreateDialog(bundle);
                this.mDialog = dialogOnCreateDialog;
                if (this.mShowsDialog) {
                    setupDialog(dialogOnCreateDialog, this.mStyle);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
            } finally {
                this.mCreatingDialog = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @m0
    androidx.fragment.app.e createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public void dismiss() {
        A(false, false);
    }

    public void dismissAllowingStateLoss() {
        A(true, false);
    }

    @o0
    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @b1
    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onAttach(@m0 Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().k(this.mObserver);
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@m0 DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    @m0
    @j0
    public Dialog onCreateDialog(@o0 Bundle bundle) {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().o(this.mObserver);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@m0 DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        A(true, true);
    }

    @o0
    View onFindViewById(int i7) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i7);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    @m0
    public LayoutInflater onGetLayoutInflater(@o0 Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.mShowsDialog && !this.mCreatingDialog) {
            B(bundle);
            if (FragmentManager.T0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.mDialog;
            return dialog != null ? layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext()) : layoutInflaterOnGetLayoutInflater;
        }
        if (FragmentManager.T0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.mShowsDialog) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return layoutInflaterOnGetLayoutInflater;
    }

    boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onSaveInstanceState(@m0 Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, bundleOnSaveInstanceState);
        }
        int i7 = this.mStyle;
        if (i7 != 0) {
            bundle.putInt(SAVED_STYLE, i7);
        }
        int i8 = this.mTheme;
        if (i8 != 0) {
            bundle.putInt(SAVED_THEME, i8);
        }
        boolean z7 = this.mCancelable;
        if (!z7) {
            bundle.putBoolean(SAVED_CANCELABLE, z7);
        }
        boolean z8 = this.mShowsDialog;
        if (!z8) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z8);
        }
        int i9 = this.mBackStackId;
        if (i9 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i9);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            r0.b(decorView, this);
            t0.b(decorView, this);
            androidx.savedstate.e.b(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @j0
    public void onViewStateRestored(@o0 Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    void performCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @m0
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z7) {
        this.mCancelable = z7;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z7);
        }
    }

    public void setShowsDialog(boolean z7) {
        this.mShowsDialog = z7;
    }

    public void setStyle(int i7, @b1 int i8) {
        if (FragmentManager.T0(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i7 + ", " + i8);
        }
        this.mStyle = i7;
        if (i7 == 2 || i7 == 3) {
            this.mTheme = R.style.Theme.Panel;
        }
        if (i8 != 0) {
            this.mTheme = i8;
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@m0 Dialog dialog, int i7) {
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(@m0 FragmentManager fragmentManager, @o0 String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        v vVarR = fragmentManager.r();
        vVarR.l(this, str);
        vVarR.r();
    }

    public void showNow(@m0 FragmentManager fragmentManager, @o0 String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        v vVarR = fragmentManager.r();
        vVarR.l(this, str);
        vVarR.t();
    }

    public int show(@m0 v vVar, @o0 String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        vVar.l(this, str);
        this.mViewDestroyed = false;
        int iR = vVar.r();
        this.mBackStackId = iR;
        return iR;
    }

    public c(@h0 int i7) {
        super(i7);
        this.mDismissRunnable = new a();
        this.mOnCancelListener = new b();
        this.mOnDismissListener = new DialogInterfaceOnDismissListenerC0097c();
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new d();
        this.mDialogCreated = false;
    }
}
