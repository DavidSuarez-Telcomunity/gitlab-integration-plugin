package com.neon.intellij.plugins.gitlab.model.intellij;

import com.neon.intellij.plugins.gitlab.model.GLTreeNode;
import org.gitlab.api.models.GitlabNamespace;

public class GLNamespaceNode extends GLTreeNode< GitlabNamespace > {

    public GLNamespaceNode( GitlabNamespace namespace ) {
        super( namespace, true );
    }

}
