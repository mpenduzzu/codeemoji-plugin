package codeemoji.core.collector.project;

import codeemoji.core.collector.project.config.CERuleFeature;
import codeemoji.core.util.CESymbol;
import codeemoji.core.util.CEUtils;
import com.intellij.codeInsight.hints.InlayHintsSink;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static codeemoji.core.collector.project.config.CERuleElement.CLASS;

@SuppressWarnings("UnstableApiUsage")
public interface CEIProjectReferenceList<H extends PsiReferenceList, A extends PsiElement> extends CEIProjectConfig {

    default void processReferenceListFR(@NotNull CERuleFeature featureRule, @Nullable H evaluationElement,
                                        @NotNull A hintElement, @NotNull InlayHintsSink sink,
                                        @NotNull CESymbol symbol, @NotNull String keyTooltip) {
        addInlayReferenceListFR(hintElement, needsHintReferenceListFR(featureRule, evaluationElement), sink,
                symbol, keyTooltip);
    }

    default @NotNull List<String> needsHintReferenceListFR(@NotNull CERuleFeature featureRule, @Nullable PsiReferenceList refList) {
        var rules = readRuleFeatures(CLASS);
        var featureValues = rules.get(featureRule);
        List<String> hintValues = new ArrayList<>();
        if (featureValues != null && (refList != null)) {
            var refs = refList.getReferencedTypes();
            for (var psiType : refs) {
                for (var value : featureValues) {
                    var qualifiedName = CEUtils.resolveQualifiedName(psiType);
                    if (qualifiedName != null && qualifiedName.equalsIgnoreCase(value)) {
                        hintValues.add(value);
                    }
                }
            }

        }
        return hintValues;
    }

    void addInlayReferenceListFR(@NotNull A addHintElement, @NotNull List<String> hintValues,
                                 @NotNull InlayHintsSink sink, @NotNull CESymbol symbol, @NotNull String keyTooltip);

}
