package com.dingzhencong.processor;


import com.dingzhencong.data.NoteData;

import java.util.List;

public interface SourceNoteData {

    public String getNoteTopic();

    public String getFilePath();

    public List<NoteData> getNoteDataList();

}
