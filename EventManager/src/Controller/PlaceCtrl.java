/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.DAO.PlaceDAO;
import model.Interfaces.ImplemetsPlace;
import model.Place;
import model.Table.TableModelPlace;
import view.PlaceJFrame;
import view.PlacePanelForm;

/**
 *
 * @author MAGNO
 */
public class PlaceCtrl {

    private final PlaceJFrame panel;
        
    

    private final ImplemetsPlace implementCampus;
    private List<Place> list;

    public PlaceCtrl(PlaceJFrame panel) {
        this.panel = panel;
        implementCampus = new PlaceDAO();
        list = implementCampus.getAllCampus();

    }
     
    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTxtLocal().setText("");
       

        panel.getTablePlace().clearSelection();
    }

    public void setTabel() {
        list = implementCampus.getAllCampus();
        panel.getTablePlace().setModel(new TableModelPlace(list));
    }

    public void getDataField() {
        int row = panel.getTablePlace().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getIdPlace()));
            panel.getTxtName().setText(list.get(row).getPlaceName());
            panel.getTxtLocal().setText(list.get(row).getPlaceName());
        }
    }
    public void insert() {
        Place course = new Place();
        course.setPlaceName(panel.getTxtName().getText());
        course.setPlaceCampus(panel.getTxtLocal().getText());
       

        implementCampus.insert(course);
    }

    /**
     *
     */
    public void update() {

        Place course = new Place();
        course.setIdPlace(Integer.parseInt(panel.getTxtId().getText()));
        course.setPlaceName(panel.getTxtName().getText());
        course.setPlaceCampus(panel.getTxtLocal().getText());
        
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
     

}
