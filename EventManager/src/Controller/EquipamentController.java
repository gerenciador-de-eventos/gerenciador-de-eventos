/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Interfaces.ImplementsEquipament;
import java.util.List;
import javax.swing.JOptionPane;
import model.DAO.EquipamentDAO;
import model.Equipaments;
import model.Table.TableModelEquipament;
import model.Type;
import view.EquipamentPanelForm;

/**
 *
 * @author felipe
 */
public class EquipamentController {

    private final EquipamentPanelForm panel;
    private final ImplementsEquipament implementsEquipament;
    private List<Equipaments> list;

    public EquipamentController(EquipamentPanelForm panel) {
        this.panel = panel;
        implementsEquipament = new EquipamentDAO();
        list = implementsEquipament.getAllEquipaments();
    }

    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
//        panel.getjComboBoxType().setSelectedIndex(0);
        panel.getTableEquipament().clearSelection();
    }

    public void setTable() {
        list = implementsEquipament.getAllEquipaments();
        panel.getTableEquipament().setModel(new TableModelEquipament(list));
    }

    public void getDataField() {
        int row = panel.getTableEquipament().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getIdEquipaments()));
            panel.getTxtName().setText(list.get(row).getEquipamentsName());

            panel.getjComboBoxType().setIdType(list.get(row).getIdEquipaments());

        }
    }

    public void insert() {
        Equipaments equipaments = new Equipaments();
        equipaments.setEquipamentsName(panel.getTxtName().getText());

        equipaments.setEquipamentsType(panel.getjComboBoxType());

        implementsEquipament.insert(equipaments);
    }

    /**
     *
     */
    public void update() {

        Equipaments equipaments = new Equipaments();

        equipaments.setIdEquipaments(Integer.parseInt(panel.getTxtId().getText()));

        equipaments.setEquipamentsName(panel.getTxtName().getText());
//        equipaments.setEquipamentsType(panel.getjComboBoxType().getIdType());

        //  equipaments.setEquipamentsType(panel.getjComboBoxType().getSelectedItem().toString());
        implementsEquipament.update(equipaments);
    }

    public void delete() {
        if (panel.getTxtId().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Sem dados para deletar.", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementsEquipament.delete(row);
    }

    public void getData() {
        if (panel.getTxtName().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Digite um nome de equipamento para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementsEquipament.getEquipamentsByName(name);

        this.filterTable(name);
    }

    public void filterTable(String name) {
        list = implementsEquipament.getEquipamentsByName(name);
        panel.getTableEquipament().setModel(new TableModelEquipament(list));
    }

}
