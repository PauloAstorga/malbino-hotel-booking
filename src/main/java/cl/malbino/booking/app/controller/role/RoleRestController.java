package cl.malbino.booking.app.controller.role;

import cl.malbino.booking.app.model.entity.Role;
import cl.malbino.booking.app.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/role/")
public class RoleRestController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping(path = "/findAll", method = RequestMethod.GET)
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @RequestMapping(path = "/findById/{id}", method = RequestMethod.POST)
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

}
