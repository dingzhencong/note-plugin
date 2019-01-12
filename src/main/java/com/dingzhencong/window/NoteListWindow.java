package com.dingzhencong.window;

import com.dingzhencong.data.DataCenter;
import com.dingzhencong.processor.DefaultSourceNoteData;
import com.dingzhencong.processor.MDFreeMarkProcessor;
import com.dingzhencong.processor.Processor;
import com.dingzhencong.util.NotifyUtil;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteListWindow {
    private JTextField topicEtf;
    private JPanel jcontent;
    private JButton createBtn;
    private JButton clearBtn;
    private JButton closeBtn;
    private JTable contentTable;

    public void init() {
        contentTable.setModel(DataCenter.TABLE_MODEL);
        contentTable.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topic = topicEtf.getText();
                if(topic==null||"".equals(topic)){
                    NotifyUtil.notifyWarning("请填写需要生成的文档标题");
                    topicEtf.grabFocus();
                    return;
                }
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                if (virtualFile != null) {
                    String path = virtualFile.getPath();

                    String filePath = path + "/" + topic + ".md";
                    Processor processor = new MDFreeMarkProcessor();
                    try {
                        processor.process(new DefaultSourceNoteData(topic, filePath, DataCenter.NOTE_LIST));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    MessageDialogBuilder.yesNo("操作结果",String.format("生成文档成功 %s",filePath)).show();
                }
            }
        });
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
            }
        });
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
    }

    public JPanel getJcontent() {
        return jcontent;
    }
}
