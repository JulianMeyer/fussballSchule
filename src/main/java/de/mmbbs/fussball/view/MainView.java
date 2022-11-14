package de.mmbbs.fussball.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

//@Route("")
public class MainView extends AppLayout implements HasDynamicTitle {

    public static final String MAIN_PAGE_TITLE = "Fussball-Anwendung";
    protected DrawerToggle drawerToggle = new DrawerToggle();

    public MainView() {
        createHeader();
        createDrawer();
    }

    @Override
    public String getPageTitle() {
        return MAIN_PAGE_TITLE;
    }

    protected void createHeader() {
        try {

            H1 title = new H1(this.getPageTitle());
            title.addClassName("title");
            title.getStyle().set("width", "100%");

            MenuBar userMenuBar = new MenuBar();

            HorizontalLayout header = new HorizontalLayout(drawerToggle, title, userMenuBar);
            header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
            header.setWidth("100%");
            header.addClassName("header");

            VerticalLayout verticalLayout = new VerticalLayout();
            verticalLayout.add(header);
            verticalLayout.setPadding(false);
            verticalLayout.setSpacing(false);
            verticalLayout.setWidth("100%");
            verticalLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);

            addToNavbar(verticalLayout);
        } catch (Exception ex) {
            System.out.println("fehler bei der erstellung des headers");
        }
    }

    protected void createDrawer() {
        VerticalLayout layout = new VerticalLayout();

        for (Component component : this.getMenuItems()) {
            if (component instanceof RouterLink) {
                ((RouterLink) component).setHighlightCondition(HighlightConditions.sameLocation());
            }
            layout.add(component);
        }

        Label powered = new Label("powered by Team Omega");
        powered.getStyle().set("margin-top", "auto");

        layout.add(powered);
        layout.setSizeFull();
        addToDrawer(layout);
    }

    protected List<Component> getMenuItems() {
        Map<String, Class<? extends Component>> menuItemsMap = new LinkedHashMap<>();
        menuItemsMap.put("Treffer", TrefferView.class);

        return createAllowedRouterLinks(menuItemsMap);
    }

    protected final List<Component> createAllowedRouterLinks(Map<String, Class<? extends Component>> classMap) {
        List<Component> routerLinks = new ArrayList<>();
        classMap.forEach((bezeichnung, klasse) -> {

            RouterLink currentLink = new RouterLink(bezeichnung, klasse);
            currentLink.setHighlightCondition(HighlightConditions.sameLocation());
            routerLinks.add(currentLink);

        });
        return routerLinks;
    }

}