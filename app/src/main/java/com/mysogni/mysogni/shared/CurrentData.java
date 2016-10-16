package com.mysogni.mysogni.shared;


import com.mysogni.mysogni.models.Dream;
import com.mysogni.mysogni.models.Mood;
import com.mysogni.mysogni.models.Tag;

import java.util.List;

public class CurrentData {
    private Dream dream;

    public Dream getCurrentDream(){
        if(dream == null)
            dream = new Dream();

        return dream;
    }

    public void resetDream(){
        dream = new Dream();
    }

    public void setText(String text){
        getCurrentDream().text = text;
    }

    public void setMood(Mood mood){
        getCurrentDream().mood = mood;
    }

    public void setTags(List<Tag> tags){
        getCurrentDream().tags = tags;
    }

}
