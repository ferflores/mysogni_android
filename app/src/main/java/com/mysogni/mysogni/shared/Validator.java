package com.mysogni.mysogni.shared;

import android.content.res.Resources;
import com.mysogni.mysogni.R;
import com.mysogni.mysogni.models.ValidationResult;

import java.util.Date;

public class Validator {
    public static ValidationResult ValidateDreamText(String text, Resources resources){
        String error = "";

        if(text == null || text.length() < 1)
            error = resources.getString(R.string.empty_dream_text);

        if(text.length() > 2000)
            error = resources.getString(R.string.max_dream_text_chars);

        if(text.matches("^[^a-zA-Z0-9 ,\\.\\?¿!¡\"\\-'@\\$\\(\\)\\[\\]_]+$"))
            error = resources.getString(R.string.illegal_chars_dream_chars);

        if(error.length() > 0 )
            return new ValidationResult(true, error);

        return new ValidationResult(false, error);
    }

    public static ValidationResult ValidateTag(String text, Resources resources){
        String error = "";

        if(text == null || text.length() < 1)
            error = resources.getString(R.string.empty_tag_text);

        if(text.length() > 25)
            error = resources.getString(R.string.max_tag_chars);

        if(text.matches("^[^a-zA-Z0-9\\.\\-_]+$"))
            error = resources.getString(R.string.illegal_chars_tag);

        if(error.length() > 0 )
            return new ValidationResult(true, error);

        return new ValidationResult(false, error);
    }

    public static ValidationResult ValidateDate(Date date, Resources resources){
        String error = "";

        if(date == null)
            error = resources.getString(R.string.empty_dream_date);

        if(date.after(new Date()))
            error = resources.getString(R.string.future_date);

        if(error.length() > 0 )
            return new ValidationResult(true, error);

        return new ValidationResult(false, error);
    }
}
