package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.model.Schiri;
import de.mmbbs.fussball.service.DataService;

import javax.annotation.PostConstruct;

/**
 * A Designer generated component for the schiri-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("schiri-view")
@JsModule("./schiri-view.ts")
@Route(value = "schiri", layout = MainView.class)
public class SchiriView extends LitTemplate {

    @Id("daGriddy")
    private Grid<Schiri> daGriddy;
    @Id("textFieldName")
    private TextField textFieldName;
    @Id("buttonSpeichern")
    private Button buttonSpeichern;

    DataService dataService;

    public SchiriView(DataService dataService) {
        this.dataService = dataService;
        daGriddy.addColumn(Schiri::getName);
        buttonSpeichern.addClickListener(buttonClickEvent -> speichern());
    }

    private void speichern() {
        Schiri neuerSchiri = new Schiri();
        String fieldNameValue = textFieldName.getValue();
        neuerSchiri.setName(fieldNameValue);
        if (!fieldNameValue.isEmpty()) {
            dataService.saveSchiri(neuerSchiri);
            init();
            textFieldName.clear();
        } else {
            textFieldName.setErrorMessage("Bitte einen Gültigen Namen eingeben");
        }
    }

    @PostConstruct
    private void init() {
        daGriddy.setItems(dataService.getAllSchiri());
    }
}
