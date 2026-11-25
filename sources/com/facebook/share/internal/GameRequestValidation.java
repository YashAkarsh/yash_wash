package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;

/* JADX INFO: loaded from: classes.dex */
public class GameRequestValidation {
    public static void validate(GameRequestContent gameRequestContent) {
        Validate.notNull(gameRequestContent.getMessage(), ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if ((gameRequestContent.getObjectId() != null) ^ (gameRequestContent.getActionType() == GameRequestContent.ActionType.ASKFOR || gameRequestContent.getActionType() == GameRequestContent.ActionType.SEND)) {
            throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
        }
        int i7 = gameRequestContent.getRecipients() != null ? 1 : 0;
        if (gameRequestContent.getSuggestions() != null) {
            i7++;
        }
        if (gameRequestContent.getFilters() != null) {
            i7++;
        }
        if (i7 > 1) {
            throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
        }
    }
}
