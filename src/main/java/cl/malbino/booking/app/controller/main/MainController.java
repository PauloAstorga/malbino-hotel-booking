package cl.malbino.booking.app.controller.main;

import cl.malbino.booking.app.controller.home.HomeController;
import cl.malbino.booking.app.facade.controller.IMainControllerFacade;
import cl.malbino.booking.app.facade.controller.MainControllerFacade;
import cl.malbino.booking.app.handler.ValidadorHandler;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MainController implements IMainControllerFacade {

    private HomeController home;
    private ValidadorHandler validadorHandler;

    public MainController(HomeController home) {
        this.home = home;
    }

    @Override
    public void doValidation() {

    }

    @Override
    public void doBussiness() {

    }

    @Override
    public void doFinally() {

    }

}
