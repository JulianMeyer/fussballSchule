package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;

/**
 * A Designer generated component for the spiel-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("spiel-view")
@JsModule("./spiel-view.ts")
public class SpielView extends LitTemplate {

    @Id("daGriddy")
    private Grid daGriddy;
    @Id("comboboxHeim")
    private ComboBox<String> comboboxHeim;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    @Id("schiribox")
    private ComboBox<String> schiribox;
    @Id("comboboxAusw")
    private ComboBox<String> comboboxAusw;
    @Id("datepicker")
    private DatePicker datepicker;

    /**
     * Creates a new SpielView.
     */
    public SpielView() {
        // You can initialise any data required for the connected UI components here.
    }

}
