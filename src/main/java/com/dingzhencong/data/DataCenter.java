package com.dingzhencong.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    /**
     * 选择的文本
     */
    public static String SELECTED_TEXT = null;
    /**
     * 当前的文件名称
     */
    public static String CURRENT_FILE_NAME = null;
    /**
     *  当前的文件类型
     */
    public static String CURRENT_FILE_TYPE = null;

    /**
     * 笔记列表集合
     */
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

    private static String[] COLUMN_NAME={"标题","备注","文件名","代码段"};

    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null,COLUMN_NAME);


    public static void reset() {
        NOTE_LIST.clear();
        TABLE_MODEL.setDataVector(null,COLUMN_NAME);

    }

}

