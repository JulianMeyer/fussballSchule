package de.mmbbs.fussball.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import de.mmbbs.fussball.Repository.TrefferRepository;
import de.mmbbs.fussball.service.TrefferService;

@Route("")
public class MainView extends VerticalLayout {
    TrefferService trefferService;
    public MainView(TrefferService trefferService) {
        this.trefferService = trefferService;
        VerticalLayout verticalLayout = new VerticalLayout();

        TextField taskField = new TextField();

        Button addButton = new Button("Add");

        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            verticalLayout.add(checkbox);
        });
        addButton.addClickShortcut(Key.ENTER);

        add(new H1("Vaadin Todo"), verticalLayout, new HorizontalLayout(taskField, addButton));
    }
}