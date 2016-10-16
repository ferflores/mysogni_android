package com.mysogni.mysogni.shared;

import com.mysogni.mysogni.models.Dream;
import com.mysogni.mysogni.models.Mood;
import com.mysogni.mysogni.models.Tag;

import java.util.Date;
import java.util.List;

public class CurrentData {
    private static Dream dream;

    private static Dream getCurrentDream(){
        if(dream == null)
            dream = new Dream();

        return dream;
    }

    public static void resetDream(){
        dream = new Dream();
    }

    public static void setText(String text){
        getCurrentDream().text = text;
    }

    public static void setCreatedOn(Date date){
        getCurrentDream().createdOn = date;
    }

    public static void setMood(Mood mood){
        getCurrentDream().mood = mood;
    }

    public static void setTags(List<Tag> tags){
        getCurrentDream().tags = tags;
    }

}
