package com.dingzhencong.action;

import com.dingzhencong.data.DataCenter;
import com.dingzhencong.dialog.AddNoteDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        //获取当前编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        //获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取当前选择的文本
        String selectedText = selectionModel.getSelectedText();

        System.out.println(selectedText);
        //选择的内容
        DataCenter.SELECTED_TEXT = selectedText;
        if(selectedText==null||"".equals(selectedText)){
//            NotifyUtil.notifyWarning("没有选中需要记录的内容");
            return;
        }
        //获取文件名称和类型，存储在全局变量
        DataCenter.CURRENT_FILE_NAME = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.CURRENT_FILE_TYPE =DataCenter.CURRENT_FILE_NAME.substring(DataCenter.CURRENT_FILE_NAME.lastIndexOf(".")+1);


        AddNoteDialog dialog = new AddNoteDialog(e.getProject());
        dialog.show();

    }
}

