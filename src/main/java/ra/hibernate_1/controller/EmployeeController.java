package ra.hibernate_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ra.hibernate_1.dao.IEmployeeDao;
import ra.hibernate_1.entity.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeDao employeeDao;
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(sf,true));
//    }

    @RequestMapping(value = {"/","/initInsertEmployee"})

    public String initInsertEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("e",employee);
        return "addEmployee";
    }

    @RequestMapping("/insertEmployee")
    public String insertEmployee(@ModelAttribute("e")Employee emp, Model model){
        boolean bl = employeeDao.insertEmployee(emp);
        if(bl){
            return "redirect:/loadEmployee"; //Gọi tiếp tới method trên controller
        }else{
            model.addAttribute("err","Insert failed!");
            model.addAttribute("e",emp);
            return "addEmployee";
        }
    }

    @RequestMapping("/loadEmployee")
    public String loadEmployee(Model model){
        List<Employee> list = employeeDao.getEmployee();
        model.addAttribute("list",list);
        return "listEmployee";
    }

    @RequestMapping("/delete/{empId}")
    public String delete(@PathVariable("empId") Integer empId, Model model){
        employeeDao.deleteEmployee(empId);
        List<Employee> list = employeeDao.getEmployee();
        model.addAttribute("list",list);
        return "listEmployee";
    }

    @GetMapping("/edit/{id}")
    public String handEdit(@PathVariable("id") Integer id, Model model) {
        Employee e =employeeDao.getEmployeeById(id);
        model.addAttribute("e", e);
        return "editEmployee";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("e") Employee emp,Model model) {
        employeeDao.updateEmployee(emp);
        List<Employee> list = employeeDao.getEmployee();
        model.addAttribute("list",list);
        return "listEmployee";
    }
}
