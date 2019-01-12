package com.dingzhencong.processor;


import com.dingzhencong.data.NoteData;

import java.util.List;

public class DefaultSourceNoteData implements SourceNoteData {

    String noteTopic;
    String filePath;
    List<NoteData> noteDataList;

    public DefaultSourceNoteData(String noteTopic, String filePath, List<NoteData> noteDataList) {
        this.noteTopic = noteTopic;
        this.filePath = filePath;
        this.noteDataList = noteDataList;
    }


    @Override
    public String getNoteTopic() {
        return this.noteTopic;
    }

    @Override
    public String getFilePath() {
        return this.filePath;
    }

    @Override
    public List<NoteData> getNoteDataList() {
        return this.noteDataList;
    }
}
