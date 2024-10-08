package me.hang.elegant.coding.inspection;

import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiModifier;
import org.jetbrains.annotations.NotNull;

/**
 * @Author hang.wang
 * @Date 2024/10/8 19:11
 */
public class ConstantNamingVisitor extends JavaElementVisitor {

    private final ProblemsHolder holder;

    public ConstantNamingVisitor(ProblemsHolder holder) {
        this.holder = holder;
    }

    @Override
    public void visitField(@NotNull PsiField field) {
        super.visitField(field);

        if ((field.hasModifierProperty(PsiModifier.PUBLIC) || field.hasModifierProperty(PsiModifier.PRIVATE))
                && field.hasModifierProperty(PsiModifier.STATIC)) {

            String fieldName = field.getName();

            if (!fieldName.equals(fieldName.toUpperCase())) {
                holder.registerProblem(field.getNameIdentifier(), "当定义常量时，变量名需要全部大写");
            }
        }
    }
}
