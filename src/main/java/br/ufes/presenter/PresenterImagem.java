package br.ufes.presenter;

import br.ufes.view.ViewManterImagens;
import java.awt.GridLayout;

/**
 *
 * @author Alcebiades
 */
public class PresenterImagem {

    private ViewManterImagens mi;

    public PresenterImagem() {
        this.mi = new ViewManterImagens();

        mi.setLayout(new GridLayout(3, 4, 5, 5));

        mi.add(mi.getImagem1());
        mi.add(mi.getImagem2());
        mi.add(mi.getImagem3());
        mi.add(mi.getImagem4());
        mi.add(mi.getImagem5());
        mi.add(mi.getImagem6());
        mi.add(mi.getImagem7());
        mi.add(mi.getImagem8());
        mi.add(mi.getImagem9());
        mi.add(mi.getImagem10());
        mi.add(mi.getImagem11());
        mi.add(mi.getImagem12());

    }

}
