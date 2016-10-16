package com.mysogni.mysogni.shared;

import com.mysogni.mysogni.models.ValidationResult;

public class Validator {
    public static ValidationResult ValidateDreamText(String text){
        String error = "";

        if(text == null || text.length() < 1)
            error = "empty_dream_text";

        if(text.length() > 2000)
            error = "max_dream_text_chars";

        if(text.matches("^[^a-zA-Z0-9 ,\\.\\?¿!¡\"\\-'@\\$\\(\\)\\[\\]_]+$"))
            error = "illegal_chars_dream_chars";

        if(error.length() > 0 )
            return new ValidationResult(true, error);

        return new ValidationResult(false, error);
    }

    public static ValidationResult ValidateTag(String text){
        String error = "";

        if(text == null || text.length() < 1)
            error = "empty_dream_text";

        if(text.length() > 25)
            error = "max_tag_chars";

        if(text.matches("^[^a-zA-Z0-9\\.\\-_]+$"))
            error = "illegal_chars_tag";

        if(error.length() > 0 )
            return new ValidationResult(true, error);

        return new ValidationResult(false, error);
    }
}
