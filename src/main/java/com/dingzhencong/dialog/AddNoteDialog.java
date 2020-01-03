package com.dingzhencong.dialog;

import com.dingzhencong.data.DataCenter;
import com.dingzhencong.data.DataConvert;
import com.dingzhencong.data.NoteData;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AddNoteDialog extends DialogWrapper {
    /**
     * 标题输入框
     */
    private EditorTextField etfTitle;
    /**
     * 内容输入框
     */
    private EditorTextField etfMark;

    public AddNoteDialog(@Nullable Project project) {
        super(project);
        init();
        setTitle("设置标题");
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        etfTitle = new EditorTextField("笔记标题");
        etfMark = new EditorTextField("笔记内容");
        etfMark.setPreferredSize(new Dimension(200,100));
        panel.add(etfTitle, BorderLayout.NORTH);
        panel.add(etfMark, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("添加到笔记列表");
        //按钮点击事件处理
        btnAdd.addActionListener(e -> {
            //获取标题
            String title = etfTitle.getText();
            //获取内容
            String mark = etfMark.getText();

            System.out.println(title + ":" + mark);

            //添加笔记到笔记列表
            NoteData noteData = new NoteData(title, mark, DataCenter.SELECTED_TEXT, DataCenter.CURRENT_FILE_NAME, DataCenter.CURRENT_FILE_TYPE);
            DataCenter.NOTE_LIST.add(noteData);

            //添加
            DataCenter.TABLE_MODEL.addRow(DataConvert.toStringArray(noteData));
            AddNoteDialog.this.dispose();
        });
        panel.add(btnAdd);
        return panel;
    }

}

