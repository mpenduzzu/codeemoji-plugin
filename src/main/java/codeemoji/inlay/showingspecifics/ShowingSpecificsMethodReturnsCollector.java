package codeemoji.inlay.showingspecifics;

import codeemoji.core.CEMethodCollector;
import codeemoji.core.CESymbol;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static codeemoji.core.enums.CEElementRule.METHOD;
import static codeemoji.core.enums.CEFeatureRule.RETURNS;

public class ShowingSpecificsMethodReturnsCollector extends CEMethodCollector {

    public ShowingSpecificsMethodReturnsCollector(@NotNull Editor editor, @NotNull String mainKeyId, CESymbol symbol, List<String> ruleValues) {
        super(editor, mainKeyId + "." + METHOD.getValue() + "." + RETURNS.getValue(), symbol);
    }

    @Override
    public boolean isHintable(@NotNull PsiMethod element) {
        return true;
    }
}