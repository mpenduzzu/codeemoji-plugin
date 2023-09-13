package codeemoji.inlay.implicit;

import codeemoji.core.collector.implicit.CEJPAEmbeddableCollector;
import codeemoji.core.collector.implicit.CEJPAEntityCollector;
import codeemoji.core.provider.CEProviderMulti;
import com.intellij.codeInsight.hints.InlayHintsCollector;
import com.intellij.codeInsight.hints.NoSettings;
import com.intellij.openapi.editor.Editor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@SuppressWarnings("UnstableApiUsage")
public class ImplicitAnnotations extends CEProviderMulti<NoSettings> {

    @Override
    public String getPreviewText() {
        return null;
    }

    @Override
    public List<InlayHintsCollector> buildCollectors(Editor editor) {
        return new ArrayList<>(
                Arrays.asList(
                        new CEJPAEntityCollector(editor, getKeyId(), 0x1F4AD),
                        new CEJPAEmbeddableCollector(editor, getKeyId(), 0x1F4AD)
                ));
    }
}