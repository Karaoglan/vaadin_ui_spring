package com.example.vaadindemo.ui;

import com.example.vaadindemo.model.Customer;
import com.example.vaadindemo.service.CustomerService;
import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by bk on 31/08/2017.
 */
@SpringUI
@Theme("valo")
public class VaadinUI extends UI {
    @Autowired
    private CustomerService service;

    private Customer customer;

    private Grid grid = new Grid();
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private Button save = new Button("Save", e -> saveCustomer());

    @Override
    protected void init(VaadinRequest request) {
        updateGrid();
        grid.setColumns("firstName", "lastName");
        grid.addSelectionListener(e -> updateForm());

        VerticalLayout layout = new VerticalLayout(grid, firstName, lastName, save);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }

    private void updateGrid() {
        List<Customer> customers = service.findAll();
        List<Customer> customersProc = service.findAllWithProcedure();

        grid.setContainerDataSource(new BeanItemContainer<>(Customer.class, customers));
        setFormVisible(false);
    }

    private void updateForm() {
        if (grid.getSelectedRows().isEmpty()) {
            setFormVisible(false);
        } else {
            customer = (Customer) grid.getSelectedRow();
            BeanFieldGroup.bindFieldsUnbuffered(customer, this);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        firstName.setVisible(visible);
        lastName.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveCustomer() {
        service.update(customer);
        updateGrid();
    }
}
