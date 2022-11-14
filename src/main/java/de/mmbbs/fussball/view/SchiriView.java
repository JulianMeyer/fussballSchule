package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;

/**
 * A Designer generated component for the schiri-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("schiri-view")
@JsModule("./schiri-view.ts")
public class SchiriView extends LitTemplate {

    @Id("daGriddy")
    private Grid daGriddy;
    @Id("textFieldName")
    private TextField textFieldName;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;

    /**
     * Creates a new SchiriView.
     */
    public SchiriView() {
        // You can initialise any data required for the connected UI components here.
    }

}
