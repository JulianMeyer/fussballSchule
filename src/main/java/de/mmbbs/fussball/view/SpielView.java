package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.model.Spiel;
import de.mmbbs.fussball.service.DataService;

/**
 * A Designer generated component for the spiel-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("spiel-view")
@JsModule("./spiel-view.ts")
@Route(value = "spiel", layout = MainView.class)
public class SpielView extends LitTemplate {

    @Id("daGriddy")
    private Grid<Spiel> daGriddy;
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

    DataService dataService;

    public SpielView(DataService dataService) {
        this.dataService = dataService;
        init();
    }

    private void init() {
    }

}
