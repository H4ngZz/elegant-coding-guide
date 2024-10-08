package me.hang.elegant.coding;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

/**
 * @Author hang.wang
 * @Date 2024/10/8 18:03
 */
public class HelloWorldAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // 显示一个 "Hello, World!" 的对话框
        Messages.showMessageDialog("Hello, world!", "Greeting", Messages.getInformationIcon());
    }
}
