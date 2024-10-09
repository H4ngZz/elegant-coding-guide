package me.hang.elegant.coding.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

/**
 * @Author hang.wang
 * @Date 2024/10/8 18:03
 */
public class ElegantCodingGuideAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Messages.showMessageDialog("https://github.com/H4ngZz/elegant-coding-guide", "Get more information on Github", Messages.getInformationIcon());
    }
}
