package com.sistema.plazas.controller;

/*
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.time.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
/*
import com.sistema.plazas.exception.CustomeFieldValidationException;
import com.sistema.plazas.exception.UsernameOrIdNotFound;
import com.sistema.plazas.dto.ChangePasswordForm;
import com.sistema.plazas.entity.Role;
import com.sistema.plazas.entity.User;
import com.sistema.plazas.entity.UserRol;
import com.sistema.plazas.repository.RoleRepository;
import com.sistema.plazas.service.UserRolService;
import com.sistema.plazas.service.UserService;
*/
@Controller
public class MainController {
	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
/*
	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRolService userRolService;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@GetMapping({"/","/index"})
	public String index(Model model) {
		//Configuracion de plantilla
		
		model.addAttribute("page", "index.html");
		model.addAttribute("title", "Pagina de postulación");
		return "display-page";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user-form/login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		//Configuraciones generales
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new User());
		//Configuracion de plantilla
		model.addAttribute("page", "user-form/user-register");
		model.addAttribute("title", "Formulario de registro");
		return "display-page";
	}
	@PostMapping("/register")
	public String registerAction(@Valid @ModelAttribute("userForm")User user, BindingResult result, Model model) {
		Role userRole = roleRepository.findByNameRole("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", user);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		if(result.hasErrors()) {
			//Configuracion de plantilla
			model.addAttribute("page", "user-form/user-register");
			model.addAttribute("title", "Formulario de registro");
			return "display-page";
		}else {
			try {
				//Insertar nuevo usuario
				//Generar clave unica en usuario
				Long idUser = generateUniqueId();
				Long idRole = 2L;
				user.setIdUser(idUser);
				UserRol userRol = new UserRol(idUser,idRole);
				userRol.setState('A');
				//Insertar fecha de registro
				LocalDate fechaPeru=LocalDate.now(ZoneId.of("America/Lima"));
				Date fechaRegistro=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
				//convertir la Fecha de nacimiento
				//SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
				//Date date=formatter.parse();
				user.setRegistrationDate(fechaRegistro);
				//user.setDateBirth(fechaRegistro);
				user.setState('A');
				userService.createUser(user);
				userRolService.createUserRol(userRol);
				return login();
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return index(model);
	}
	
	
	@GetMapping("/signup")
	public String signup(Model model) {
		Role userRole = roleRepository.findByNameRole("USER");
		List<Role> roles = Arrays.asList(userRole);
		//Configuraciones generales
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles",roles);
		//Configuracion de plantilla
		model.addAttribute("page", "user-form/user-signup");
		model.addAttribute("title", "Formulario de registro");
		return "display-page";
	}
	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("userForm")User user, BindingResult result, Model model) {
		Role userRole = roleRepository.findByNameRole("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", user);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		if(result.hasErrors()) {
			//Configuracion de plantilla
			model.addAttribute("page", "user-form/user-signup");
			model.addAttribute("title", "Formulario de registro");
			return "display-page";
		}else {
			try {
				userService.createUser(user);
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return index(model);
	}
	
	private void baseAttributerForUserForm(Model model, User user,String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		baseAttributerForUserForm(model, new User(), TAB_LIST );
		return "user-form/user-view";
	}
	
	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm")User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM);
			System.out.print("Usuario  "+user.getUsername());
		}else {
			try {
				userService.createUser(user);
				baseAttributerForUserForm(model, new User(), TAB_LIST );
				
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM );
			}
		}
		return "user-form/user-view";
	}
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		User userToEdit = userService.getUserById(id);

		baseAttributerForUserForm(model, userToEdit, TAB_FORM );
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
		
		return "user-form/user-view";
	}
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm")User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM );
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getIdUser()));
		}else {
			try {
				userService.updateUser(user);
				baseAttributerForUserForm(model, new User(), TAB_LIST );
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				
				baseAttributerForUserForm(model, user, TAB_FORM );
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getIdUser()));
			}
		}
		return "user-form/user-view";
		
	}
	/*
	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Long id) {
		try {
			userService.deleteUser(id);
		} 
		catch (UsernameOrIdNotFound uoin) {
			model.addAttribute("listErrorMessage",uoin.getMessage());
		}
		return userForm(model);
	}
	
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if( errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}
	*/
	
	//Encriptador de claves
	/*
	private static Long generateUniqueId()
    {	//maxId = 9000000000000000
        long val = -1;
        do
        {
            final UUID uid = UUID.randomUUID();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.longValue();
        } 
         // We also make sure that the ID is in positive space, if its not we simply repeat the process
        while (val < 0);
        return val;
    }*/
}


