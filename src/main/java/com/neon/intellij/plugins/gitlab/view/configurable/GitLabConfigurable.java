package com.neon.intellij.plugins.gitlab.view.configurable;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.neon.intellij.plugins.gitlab.model.intellij.ConfigurableState;
import javax.swing.JComponent;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GitLabConfigurable implements SearchableConfigurable {

    private final ConfigurableState settings = ConfigurableState.getInstance();

    private SettingsView view;


    public GitLabConfigurable( ) {

    }

    @Nls
    @Override
    public String getDisplayName() {
        return "GitLab Integration";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Override
    public JComponent createComponent() {
        view = new SettingsView();
        reset();
        return view;
    }

    /**
     * method constantly called to check for changed content in the view.
     * if false, 'apply' button will be disabled.
     *
     */
    public boolean isModified() {
        Object[] save = view.save();
        return save == null
                || ! settings.getHost().equals( save[0] )
                || ! settings.getToken().equals( save[1] )
                || ! settings.getIgnoreCertificateErrors().equals( save[2] );
    }

    /**
     * called on 'apply' or 'ok' button click.
     */
    @Override
    public void apply() throws ConfigurationException {
        Object[] save = view.save();
        settings.setHost( ( String ) save[0] );
        settings.setToken( ( String ) save[1] );
        settings.setIgnoreCertificateErrors( ( Boolean ) save[2] );
    }

    /**
     * called on 'cancel' button click.
     */
    @Override
    public void reset() {
        if ( view != null ) {
            view.fill(settings);
        }
    }

    @Override
    public void disposeUIResources() {
        view = null;
    }

    @NotNull
    @Override
    public String getId() {
        return "com.neon.intellij.plugins.gitlab.configurable";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }
}
