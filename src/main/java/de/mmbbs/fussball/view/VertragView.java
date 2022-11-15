package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the vertrag-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vertrag-view")
@JsModule("./vertrag-view.ts")
@Route(value = "vertrag",layout = MainView.class)
public class VertragView extends LitTemplate {

    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    @Id("comboboxSpieler")
    private ComboBox<String> comboboxSpieler;
    @Id("numberfieldGehalt")
    private NumberField numberfieldGehalt;
    @Id("daGriddy")
    private Grid daGriddy;

    /**
     * Creates a new VertragView.
     */
    public VertragView() {
        // You can initialise any data required for the connected UI components here.
    }

}
