package com.example.jluukvg.rxjava_jsonparserrecyclerview.model;

import android.util.SparseArray;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.DrupalImage;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.Section;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities.SectionParagraphs.SectionParagraph;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.utilities.Constants;

import java.util.ArrayList;
import java.util.EnumMap;

import static com.example.jluukvg.rxjava_jsonparserrecyclerview.model.DrupalModelSingleton.MenuType.kMenuDeportes;
import static com.example.jluukvg.rxjava_jsonparserrecyclerview.model.DrupalModelSingleton.MenuType.kMenuEntretenimiento;
import static com.example.jluukvg.rxjava_jsonparserrecyclerview.model.DrupalModelSingleton.MenuType.kMenuNoticias;
import static com.example.jluukvg.rxjava_jsonparserrecyclerview.model.DrupalModelSingleton.MenuType.kMenuTelevision;

/**
 * Created by jluukvg on 7/22/17.
 *
 */

public class DrupalModelSingleton {

    private static DrupalModelSingleton sharedInstance;

    public enum MenuType {
        kMenuNoticias,
        kMenuDeportes,
        kMenuEntretenimiento,
        kMenuTelevision
    }

    private final EnumMap<MenuType, ArrayList<Section>> applicationMenus = new EnumMap<>(MenuType.class);
    private final SparseArray<ArrayList<SectionParagraph>> paragraphsForSection = new SparseArray<>();

    public static DrupalModelSingleton getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new DrupalModelSingleton();

            ArrayList<Section> noticiasMenu = new ArrayList<>();
            noticiasMenu.add(new Section(Constants.PORTADA_NOTICIAS_TID, "", ""));

            ArrayList<Section> deportesMenu = new ArrayList<>();
            deportesMenu.add(new Section(Constants.PORTADA_DEPORTES_TID, "", ""));

            ArrayList<Section> entretenimientoMenu = new ArrayList<>();
            entretenimientoMenu.add(new Section(Constants.PORTADA_ENTRETENIMIENTO_TID, "", ""));

            ArrayList<Section> tvMenu = new ArrayList<>();
            tvMenu.add(new Section(Constants.PORTADA_TV_TID, "", ""));

            sharedInstance.applicationMenus.put(kMenuNoticias, noticiasMenu);
            sharedInstance.applicationMenus.put(kMenuDeportes, deportesMenu);
            sharedInstance.applicationMenus.put(kMenuEntretenimiento, entretenimientoMenu);
            sharedInstance.applicationMenus.put(kMenuTelevision, tvMenu);
        }
        return sharedInstance;
    }

}
