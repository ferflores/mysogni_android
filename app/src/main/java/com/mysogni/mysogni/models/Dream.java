package com.mysogni.mysogni.models;

import java.util.List;
import java.util.Date;

public class Dream {
    public String id;
    public String userId;
    public String text;
    public Date createdOn;
    public Mood mood;
    public List<Tag> tags;

}
