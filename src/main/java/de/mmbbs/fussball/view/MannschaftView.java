package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the mannschaft-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("mannschaft-view")
@JsModule("./mannschaft-view.ts")
@Route(value = "mannschaft",layout = MainView.class)
public class MannschaftView extends LitTemplate {

    @Id("textFieldName")
    private TextField textFieldName;
    @Id("daGriddy")
    private Grid daGriddy;
    @Id("buttonHinzufügen")
    private Button buttonHinzufügen;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;

    /**
     * Creates a new MannschaftView.
     */
    public MannschaftView() {
        // You can initialise any data required for the connected UI components here.
    }

}
