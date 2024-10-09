package me.hang.elegant.coding.inspection;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

/**
 * @Author hang.wang
 * @Date 2024/10/8 19:06
 */
public class ConstantNamingInspection extends LocalInspectionTool {

    @Override
    public @NotNull PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new ConstantNamingVisitor(holder);
    }

    @Override
    public @NotNull String getDisplayName() {
        return "ECG Constant Naming";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }
}
