package com.dzc.note.processor;

import freemarker.template.TemplateException;

import java.io.IOException;

public interface Processor {
    public void process(SourceNoteData sourceNoteData) throws IOException, TemplateException, Exception;
}
