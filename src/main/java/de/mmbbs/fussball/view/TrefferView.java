package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.model.Treffer;
/**
 * A Designer generated component for the treffer-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("treffer-view")
@JsModule("./treffer-view.ts")
@Route(value = "treffer",layout = MainView.class)
public class TrefferView extends LitTemplate {

    @Id("buttonSpeichern")
    private Button buttonSpeichern;
    @Id("checkboxTreffer")
    private Checkbox checkboxTreffer;
    @Id("minute")
    private NumberField minute;
    @Id("daGriddy")
    private Grid<Treffer> daGriddy;

    /**
     * Creates a new TrefferView.
     */
    public TrefferView() {
        addClassName("treffer-view");
        configureGrid();


    }

    private void configureGrid() {

        daGriddy.addColumn(Treffer::getMinute).setHeader("Minute des Treffers");
        daGriddy.addColumn(Treffer::isEigentor).setHeader("Ist Eigentor?");

        daGriddy.getColumns().forEach(col -> col.setAutoWidth(true));


    }
}
