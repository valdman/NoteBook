package com.lod.boris.notebook;

/**
 * Created by boris on 29.10.15.
 */
public class Note {
    private String Name;
    private String Short_text;
    private String Long_text;

    public Note(String name, String text){

        Name = name;
        Long_text = text;
        Short_text = Long_text.substring(0, 20);
    }

    public String getName() {
        return Name;
    }

    public String getLong_text() {
        return Long_text;
    }

    public String getShort_text() {
        return Short_text;
    }
}
