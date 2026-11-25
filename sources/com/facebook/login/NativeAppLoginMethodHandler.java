package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;

/* JADX INFO: loaded from: classes.dex */
abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private String getError(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE) : string;
    }

    private String getErrorMessage(Bundle bundle) {
        String string = bundle.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
        return string == null ? bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION) : string;
    }

    private LoginClient.Result handleResultCancel(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String string = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null ? extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString() : null;
        return ServerProtocol.errorConnectionFailure.equals(string) ? LoginClient.Result.createErrorResult(request, error, getErrorMessage(extras), string) : LoginClient.Result.createCancelResult(request, error);
    }

    private LoginClient.Result handleResultOk(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String string = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null ? extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString() : null;
        String errorMessage = getErrorMessage(extras);
        String string2 = extras.getString("e2e");
        if (!Utility.isNullOrEmpty(string2)) {
            logWebLoginCompleted(string2);
        }
        if (error == null && string == null && errorMessage == null) {
            try {
                return LoginClient.Result.createTokenResult(request, LoginMethodHandler.createAccessTokenFromWebBundle(request.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.getApplicationId()));
            } catch (FacebookException e8) {
                return LoginClient.Result.createErrorResult(request, null, e8.getMessage());
            }
        }
        if (ServerProtocol.errorsProxyAuthDisabled.contains(error)) {
            return null;
        }
        return ServerProtocol.errorsUserCanceled.contains(error) ? LoginClient.Result.createCancelResult(request, null) : LoginClient.Result.createErrorResult(request, error, errorMessage, string);
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean onActivityResult(int i7, int i8, Intent intent) {
        LoginClient.Result resultCreateErrorResult;
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (intent == null) {
            resultCreateErrorResult = LoginClient.Result.createCancelResult(pendingRequest, "Operation canceled");
        } else if (i8 == 0) {
            resultCreateErrorResult = handleResultCancel(pendingRequest, intent);
        } else {
            resultCreateErrorResult = i8 != -1 ? LoginClient.Result.createErrorResult(pendingRequest, "Unexpected resultCode from authorization.", null) : handleResultOk(pendingRequest, intent);
        }
        if (resultCreateErrorResult != null) {
            this.loginClient.completeAndValidate(resultCreateErrorResult);
            return true;
        }
        this.loginClient.tryNextHandler();
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    abstract boolean tryAuthorize(LoginClient.Request request);

    protected boolean tryIntent(Intent intent, int i7) {
        if (intent == null) {
            return false;
        }
        try {
            this.loginClient.getFragment().startActivityForResult(intent, i7);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
