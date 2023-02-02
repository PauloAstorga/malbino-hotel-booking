package cl.malbino.booking.app.controller.role;

import cl.malbino.booking.app.controller.main.MainController;
import cl.malbino.booking.app.model.entity.AuditLog;
import cl.malbino.booking.app.model.entity.Role;
import cl.malbino.booking.app.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/role/")
public class RoleRestController extends MainController {

    @Autowired
    private IRoleService roleService;

    private Logger logger = Logger.getLogger(RoleRestController.class.getName());

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRoleById(@PathVariable("id") long id) {

        Map<String, Object> response = new HashMap<>();

        try {

            Optional<Role> roleObj = Optional.ofNullable(roleService.findById(id));

            if ( roleObj.isPresent() ) {
                return new ResponseEntity<>(roleObj.get(), HttpStatus.OK);
            }

            response.put("error", "The Role of ID: [" + id + "] doesn't exist.");

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            response.put("error", "Internal Exception: " + e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            response = null;
        }
    }

    public ResponseEntity<?> getRoleByName(@PathVariable("name") String name) {
        return null;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {

        Map<String, Object> response = new HashMap<>();

        String name = ex.getName();
        String type = ex.getRequiredType().getSimpleName();
        Object value = ex.getValue();
        String message = String.format("'%s' should be a valid '%s' and '%s' isn't",
                name, type, value);

        logger.log(Level.INFO, "Error is:" + message);

        response.put("error", message);
        response.put("type", ex.getMessage());

        AuditLog auditLog = AuditLog.builder().type("error").log(ex.getMessage()).build();


        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
