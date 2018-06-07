/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Campus;
import model.DAO.CampusDAO;
import model.Interfaces.ImplemetsCampus;
import model.Table.TableModelCampus;
import view.CampusPanelForm;

/**
 *
 * @author MAGNO
 */
public class CampusCtrl {

    private final CampusPanelForm panel;
    private final ImplemetsCampus implementCampus;
    private List<Campus> list;

    public CampusCtrl(CampusPanelForm panel) {
        this.panel = panel;
        implementCampus = new CampusDAO();
        list = implementCampus.getAllCampus();
    }

    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTxtCity().setText("");
        panel.getTxtFantasy().setText("");
       
        panel.getTabelCourse().clearSelection();
    }

    public void setTabel() {
        list = implementCampus.getAllCampus();
        panel.getTabelCourse().setModel(new TableModelCampus(list));
    }

    public void getDataField() {
        int row = panel.getTabelCourse().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getIdCampus()));
            panel.getTxtName().setText(list.get(row).getCampusName());
            panel.getTxtFantasy().setText(list.get(row).getCampusFantasyName());
            panel.getTxtCity().setText(list.get(row).getCampusCity());

        }
    }

    public void insert() {
        Campus course = new Campus();
        course.setCampusName(panel.getTxtName().getText());
        course.setCampusFantasyName(panel.getTxtFantasy().getText());
        course.setCampusCity(panel.getTxtCity().getText());

        

        implementCampus.insert(course);
    }

    /**
     *
     */
    public void update() {
        
        Campus course = new Campus();
        course.setIdCampus(Integer.parseInt(panel.getTxtId().getText()));
        course.setCampusName(panel.getTxtName().getText());
        course.setCampusFantasyName(panel.getTxtFantasy().getText());
        course.setCampusCity(panel.getTxtCity().getText());
        implementCampus.update(course);
    }

    public void delete() {
        if (panel.getTxtId().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Sem dados para deletar.", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementCampus.delete(row);
    }

    public void getData() {
        if (panel.getTxtName().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Digite um nome de campus para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementCampus.getCampusByName(name);
        this.filterTable(name);
    }

    public void filterTable(String name) {
        list = implementCampus.getCampusByName(name);
        panel.getTabelCourse().setModel(new TableModelCampus(list));
    }
}
