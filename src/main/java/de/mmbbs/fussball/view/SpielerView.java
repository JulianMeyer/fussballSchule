package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the spieler-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("spieler-view")
@JsModule("./spieler-view.ts")
@Route(value = "spieler",layout = MainView.class)
public class SpielerView extends LitTemplate {

    @Id("trikotnummer")
    private NumberField trikotnummer;
    @Id("buttonHinzufügen")
    private Button buttonHinzufügen;
    @Id("checkboxTreffer")
    private Checkbox checkboxTreffer;
    @Id("minute")
    private NumberField minute;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    @Id("textFieldSpieler")
    private TextField textFieldSpieler;
    @Id("elfmeter")
    private NumberField elfmeter;
    @Id("daGriddy")
    private Grid daGriddy;

    /**
     * Creates a new SpielerView.
     */
    public SpielerView() {
        // You can initialise any data required for the connected UI components here.
    }

}
