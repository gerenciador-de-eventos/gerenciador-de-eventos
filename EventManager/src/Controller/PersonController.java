/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Campus;
import model.DAO.CampusDAO;
import model.DAO.PersonDAO;
import model.Interfaces.ImplemetsPerson;
import model.Person;
import model.Table.TableModelCampus;
import model.Table.TableModelPerson;
import view.PersonJframe;
import view.PersonPanelForm;

/**
 *
 * @author MAGNO
 */
public class PersonController {

    private final PersonJframe panel;
    private final ImplemetsPerson implementPerson;
    private List<Person> list;

    public PersonController(PersonJframe panel) {
        this.panel = panel;
        implementPerson = new PersonDAO();
        list = implementPerson.getAllPerson();
    }

    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTxtCPF().setText("");
        panel.getTxtPassword().setText("");

        panel.getTxtRG().setText("");
        panel.getjDateChooserDateBirth().setCalendar(Calendar.getInstance());
        panel.getjCheckBoxPrivileges().setSelected(false);
        panel.getjComboBoxHourWork().setSelectedIndex(0); //
        panel.getTxtEmail().setText("");

        panel.getTablePerson().clearSelection();
    }

    public void setTable() {
        list = implementPerson.getAllPerson();
        panel.getTablePerson().setModel(new TableModelPerson(list));
    }

    public void getDataField() {
        int row = panel.getTablePerson().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getIdPerson()));
            panel.getTxtName().setText(list.get(row).getPersonName());
            panel.getTxtPassword().setText(list.get(row).getPersonPassword());
            panel.getTxtCPF().setText(list.get(row).getPersonCPF());

            panel.getTxtRG().setText(list.get(row).getPersonRG());
            panel.getjDateChooserDateBirth().setDate(list.get(row).getPersonDateBorn());
            panel.getTxtEmail().setText(list.get(row).getPersonEmail());

            panel.getjCheckBoxPrivileges().setSelected(list.get(row).getPersonPrivileges());
            panel.getjComboBoxHourWork().setSelectedItem(list.get(row).getPersonHourWork());

        }
    }

    public void insert() {
        Person person = new Person();
        person.setPersonName(panel.getTxtName().getText());
        person.setPersonPassword(panel.getTxtPassword().getText());
        person.setPersonCPF(panel.getTxtCPF().getText());
        person.setPersonRG(panel.getTxtRG().getText());
        person.setPersonDateBorn(panel.getjDateChooserDateBirth().getDate());
        person.setPersonPrivileges(panel.getjCheckBoxPrivileges().isSelected());
        person.setPersonHourWork(panel.getjComboBoxHourWork().getSelectedItem().toString());
        person.setPersonEmail(panel.getTxtEmail().getText());

        implementPerson.insert(person);
    }

    /**
     *
     */
    public void update() {

        Person person = new Person();
        person.setIdPerson(Integer.parseInt(panel.getTxtId().getText()));
        person.setPersonName(panel.getTxtName().getText());
        person.setPersonPassword(panel.getTxtPassword().getText());
        person.setPersonCPF(panel.getTxtCPF().getText());
        person.setPersonRG(panel.getTxtRG().getText());
        person.setPersonDateBorn(panel.getjDateChooserDateBirth().getDate());
        person.setPersonPrivileges(panel.getjCheckBoxPrivileges().isSelected());
        person.setPersonHourWork(panel.getjComboBoxHourWork().getSelectedItem().toString());
        person.setPersonEmail(panel.getTxtEmail().getText());

        implementPerson.update(person);
    }

    public void delete() {
        if (panel.getTxtId().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Sem dados para deletar.", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementPerson.delete(row);
    }

    public void getData() {
        if (panel.getTxtName().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Digite um nome de campus para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementPerson.getPersonByName(name);
        this.filterTable(name);
    }

    public void filterTable(String name) {
        list = implementPerson.getPersonByName(name);
        panel.getTablePerson().setModel(new TableModelPerson(list));
    }
}
