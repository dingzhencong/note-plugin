package com.dzc.note.processor;


import com.dzc.note.data.NoteData;

import java.util.List;

public interface SourceNoteData {
    public String getFileName();

    public String getTopic();

    public List<NoteData> getNoteList();


}
