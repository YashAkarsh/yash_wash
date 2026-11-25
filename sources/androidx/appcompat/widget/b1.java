package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class b1 extends androidx.cursoradapter.widget.c implements View.OnClickListener {
    private static final boolean C = false;
    private static final String D = "SuggestionsAdapter";
    private static final int E = 50;
    static final int F = 0;
    static final int G = 1;
    static final int H = 2;
    static final int I = -1;
    private int A;
    private int B;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final SearchView f1742o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final SearchableInfo f1743p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Context f1744q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1745r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f1746s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1747t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1748u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ColorStateList f1749v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1750w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f1751x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1752y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f1753z;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f1754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f1755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f1756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f1757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f1758e;

        public a(View view) {
            this.f1754a = (TextView) view.findViewById(R.id.text1);
            this.f1755b = (TextView) view.findViewById(R.id.text2);
            this.f1756c = (ImageView) view.findViewById(R.id.icon1);
            this.f1757d = (ImageView) view.findViewById(R.id.icon2);
            this.f1758e = (ImageView) view.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public b1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1747t = false;
        this.f1748u = 1;
        this.f1750w = -1;
        this.f1751x = -1;
        this.f1752y = -1;
        this.f1753z = -1;
        this.A = -1;
        this.B = -1;
        this.f1742o = searchView;
        this.f1743p = searchableInfo;
        this.f1746s = searchView.getSuggestionCommitIconResId();
        this.f1744q = context;
        this.f1745r = weakHashMap;
    }

    private Drawable A(Cursor cursor) {
        int i7 = this.A;
        if (i7 == -1) {
            return null;
        }
        return y(cursor.getString(i7));
    }

    private static String D(Cursor cursor, int i7) {
        if (i7 == -1) {
            return null;
        }
        try {
            return cursor.getString(i7);
        } catch (Exception e8) {
            Log.e(D, "unexpected error retrieving valid column from cursor, did the remote process die?", e8);
            return null;
        }
    }

    private void F(ImageView imageView, Drawable drawable, int i7) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i7);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void G(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void H(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1745r.put(str, drawable.getConstantState());
        }
    }

    private void I(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable p(String str) {
        Drawable.ConstantState constantState = this.f1745r.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence r(CharSequence charSequence) {
        if (this.f1749v == null) {
            TypedValue typedValue = new TypedValue();
            this.f1744q.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, typedValue, true);
            this.f1749v = this.f1744q.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1749v, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable s(ComponentName componentName) {
        PackageManager packageManager = this.f1744q.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w(D, "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e8) {
            Log.w(D, e8.toString());
            return null;
        }
    }

    private Drawable t(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f1745r.containsKey(strFlattenToShortString)) {
            Drawable drawableS = s(componentName);
            this.f1745r.put(strFlattenToShortString, drawableS != null ? drawableS.getConstantState() : null);
            return drawableS;
        }
        Drawable.ConstantState constantState = this.f1745r.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f1744q.getResources());
    }

    public static String u(Cursor cursor, String str) {
        return D(cursor, cursor.getColumnIndex(str));
    }

    private Drawable v() {
        Drawable drawableT = t(this.f1743p.getSearchActivity());
        return drawableT != null ? drawableT : this.f1744q.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable w(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return x(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f1744q.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e8) {
                    Log.e(D, "Error closing icon stream for " + uri, e8);
                }
                return drawableCreateFromStream;
            } catch (Throwable th) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e9) {
                    Log.e(D, "Error closing icon stream for " + uri, e9);
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            Log.w(D, "Icon not found: " + uri + ", " + e10.getMessage());
            return null;
        }
        Log.w(D, "Icon not found: " + uri + ", " + e10.getMessage());
        return null;
    }

    private Drawable y(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i7 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1744q.getPackageName() + "/" + i7;
            Drawable drawableP = p(str2);
            if (drawableP != null) {
                return drawableP;
            }
            Drawable drawableI = androidx.core.content.d.i(this.f1744q, i7);
            H(str2, drawableI);
            return drawableI;
        } catch (Resources.NotFoundException unused) {
            Log.w(D, "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableP2 = p(str);
            if (drawableP2 != null) {
                return drawableP2;
            }
            Drawable drawableW = w(Uri.parse(str));
            H(str, drawableW);
            return drawableW;
        }
    }

    private Drawable z(Cursor cursor) {
        int i7 = this.f1753z;
        if (i7 == -1) {
            return null;
        }
        Drawable drawableY = y(cursor.getString(i7));
        return drawableY != null ? drawableY : v();
    }

    public int B() {
        return this.f1748u;
    }

    Cursor C(SearchableInfo searchableInfo, String str, int i7) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i7 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i7));
        }
        return this.f1744q.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void E(int i7) {
        this.f1748u = i7;
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.b.a
    public CharSequence a(Cursor cursor) {
        String strU;
        String strU2;
        if (cursor == null) {
            return null;
        }
        String strU3 = u(cursor, "suggest_intent_query");
        if (strU3 != null) {
            return strU3;
        }
        if (this.f1743p.shouldRewriteQueryFromData() && (strU2 = u(cursor, "suggest_intent_data")) != null) {
            return strU2;
        }
        if (!this.f1743p.shouldRewriteQueryFromText() || (strU = u(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strU;
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.b.a
    public void b(Cursor cursor) {
        if (this.f1747t) {
            Log.w(D, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f1750w = cursor.getColumnIndex("suggest_text_1");
                this.f1751x = cursor.getColumnIndex("suggest_text_2");
                this.f1752y = cursor.getColumnIndex("suggest_text_2_url");
                this.f1753z = cursor.getColumnIndex("suggest_icon_1");
                this.A = cursor.getColumnIndex("suggest_icon_2");
                this.B = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e8) {
            Log.e(D, "error changing cursor and caching columns", e8);
        }
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.b.a
    public Cursor d(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f1742o.getVisibility() == 0 && this.f1742o.getWindowVisibility() == 0) {
            try {
                Cursor cursorC = C(this.f1743p, string, 50);
                if (cursorC != null) {
                    cursorC.getCount();
                    return cursorC;
                }
            } catch (RuntimeException e8) {
                Log.w(D, "Search suggestions query threw an exception.", e8);
            }
        }
        return null;
    }

    @Override // androidx.cursoradapter.widget.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i7 = this.B;
        int i8 = i7 != -1 ? cursor.getInt(i7) : 0;
        if (aVar.f1754a != null) {
            G(aVar.f1754a, D(cursor, this.f1750w));
        }
        if (aVar.f1755b != null) {
            String strD = D(cursor, this.f1752y);
            CharSequence charSequenceR = strD != null ? r(strD) : D(cursor, this.f1751x);
            if (TextUtils.isEmpty(charSequenceR)) {
                TextView textView = aVar.f1754a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1754a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1754a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1754a.setMaxLines(1);
                }
            }
            G(aVar.f1755b, charSequenceR);
        }
        ImageView imageView = aVar.f1756c;
        if (imageView != null) {
            F(imageView, z(cursor), 4);
        }
        ImageView imageView2 = aVar.f1757d;
        if (imageView2 != null) {
            F(imageView2, A(cursor), 8);
        }
        int i9 = this.f1748u;
        if (i9 != 2 && (i9 != 1 || (i8 & 1) == 0)) {
            aVar.f1758e.setVisibility(8);
            return;
        }
        aVar.f1758e.setVisibility(0);
        aVar.f1758e.setTag(aVar.f1754a.getText());
        aVar.f1758e.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i7, view, viewGroup);
        } catch (RuntimeException e8) {
            Log.w(D, "Search suggestions cursor threw exception.", e8);
            View viewI = i(this.f1744q, c(), viewGroup);
            if (viewI != null) {
                ((a) viewI.getTag()).f1754a.setText(e8.toString());
            }
            return viewI;
        }
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i7, view, viewGroup);
        } catch (RuntimeException e8) {
            Log.w(D, "Search suggestions cursor threw exception.", e8);
            View viewJ = j(this.f1744q, c(), viewGroup);
            if (viewJ != null) {
                ((a) viewJ.getTag()).f1754a.setText(e8.toString());
            }
            return viewJ;
        }
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.c, androidx.cursoradapter.widget.a
    public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewJ = super.j(context, cursor, viewGroup);
        viewJ.setTag(new a(viewJ));
        ((ImageView) viewJ.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.f1746s);
        return viewJ;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        I(c());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        I(c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1742o.a0((CharSequence) tag);
        }
    }

    public void q() {
        b(null);
        this.f1747t = true;
    }

    Drawable x(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f1744q.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }
}
