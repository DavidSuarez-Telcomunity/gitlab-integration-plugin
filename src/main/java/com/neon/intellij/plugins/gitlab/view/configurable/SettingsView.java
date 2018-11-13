package com.neon.intellij.plugins.gitlab.view.configurable;

import com.neon.intellij.plugins.gitlab.model.EditableView;
import com.neon.intellij.plugins.gitlab.model.intellij.ConfigurableState;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingsView extends JPanel implements EditableView<ConfigurableState, Object[] > {

    private final JLabel labelHost = new JLabel( "GitLab Host" );
    private final JTextField textHost = new JTextField();

    private final JLabel labelAPI = new JLabel( "GitLab API Key" );
    private final JTextField textAPI = new JTextField();

    private final JCheckBox checkIgnoreCertificateErrors = new JCheckBox( "Ignore Certificate Errors", true );

    public SettingsView( ) {
        setupLayout();
    }

    private void setupLayout() {
        this.setLayout( new TableLayout(
                new double[] { TableLayout.FILL },
                new double[] {
                    TableLayout.MINIMUM, TableLayout.MINIMUM, TableLayout.MINIMUM, TableLayout.MINIMUM, TableLayout.MINIMUM
                }
        ) );
        this.add( labelHost, new TableLayoutConstraints( 0, 0, 0, 0, TableLayout.FULL, TableLayout.FULL ) );
        this.add( textHost, new TableLayoutConstraints( 0, 1, 0, 1, TableLayout.FULL, TableLayout.FULL ) );
        this.add( labelAPI, new TableLayoutConstraints( 0, 2, 0, 2, TableLayout.FULL, TableLayout.FULL ) );
        this.add( textAPI, new TableLayoutConstraints( 0, 3, 0, 3, TableLayout.FULL, TableLayout.FULL ) );
        this.add( checkIgnoreCertificateErrors, new TableLayoutConstraints( 0, 4, 0, 4, TableLayout.FULL, TableLayout.FULL ) );
    }

    @Override
    public void fill( ConfigurableState state ) {
        textHost.setText( state == null ? "" : state.getHost() );
        textAPI.setText( state == null ? "" : state.getToken() );
        checkIgnoreCertificateErrors.setSelected( state == null ? true : state.getIgnoreCertificateErrors() );
    }

    @Override
    public Object[] save() {
        return new Object[] { textHost.getText(), textAPI.getText(), checkIgnoreCertificateErrors.isSelected() };
    }

}
