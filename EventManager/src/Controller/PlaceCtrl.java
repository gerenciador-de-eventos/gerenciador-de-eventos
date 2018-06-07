/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import model.DAO.PlaceDAO;
import model.Interfaces.ImplemetsPlace;
import model.Place;
import view.PlacePanelForm;

/**
 *
 * @author MAGNO
 */
public class PlaceCtrl {

    private final PlacePanelForm panel;
    private final ImplemetsPlace implementCampus;
    private List<Place> list;

    public PlaceCtrl(PlacePanelForm panel) {
        this.panel = panel;
        implementCampus = new PlaceDAO();
        list = implementCampus.getAllCampus();

    }

}
