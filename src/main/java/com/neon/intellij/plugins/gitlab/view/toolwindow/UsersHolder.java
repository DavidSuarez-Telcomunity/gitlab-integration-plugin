package com.neon.intellij.plugins.gitlab.view.toolwindow;

import java.util.Collection;
import org.gitlab.api.models.GitlabUser;

public interface UsersHolder {

    void setUsers( Collection<GitlabUser> users );

}
