package com.busbooking.demo.Controller;

import com.busbooking.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping("/")
    public List<BusInfo> busInfoList(){
        return busService.busInfoList();
    }

    @PostMapping("/add")
    public BusInfo addBus(@RequestBody BusInfo busInfo){
        return busService.addBus(busInfo);
    }

    @PutMapping("/edit")
    public BusInfo editBus( @RequestBody BusInfo busInfo){
        return busService.editBus(busInfo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBus(@PathVariable("id") int id){
        busService.deleteBus(id);
    }

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public void signup(@RequestBody Login login){
        loginService.signup(login);
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public Login loginDetails( @RequestBody Login login){
//        System.out.println(login.getUserName());
////        System.out.println(login.getPassWord());

        return loginService.loginDetails(login);
    }

    @GetMapping("/userdetails")
    public List<Login> userList(){
        return loginService.userList();
    }

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/contactsent",method = RequestMethod.POST)
    public void contactSent(@RequestBody Contact contact) throws Exception{
        contactService.send(contact.getEmail(),
                "jvsprng@gmail.com",contact.getFname(),contact.getComment());
    }


    @Autowired
    UserService userService;

    @RequestMapping(value = "/usersignup",method = RequestMethod.POST)
    public void userSignup(@RequestBody UserLogin user){
        userService.userSignup(user);
    }

    @RequestMapping(value = "/userlogin",method = {RequestMethod.GET,RequestMethod.POST})
    public UserLogin userLogin(@RequestBody UserLogin login){
//        System.out.println(login.getUserName());
//        System.out.println(login.getPassWord());
        //login.setActive(1);
        return userService.userLogin(login);
    }

    @GetMapping("/udetails")
    public List<UserLogin> uList(){
        return userService.userList();
    }

//    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
//    public ModelAndView accessDenied() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("errors/access_denied");
//        return model;
//    }

    @RequestMapping(value = "/usersearch",method = {RequestMethod.GET,RequestMethod.POST})
    public List<BusInfo> userSearch(@RequestBody BusInfo busInfo){
        System.out.println(busInfo.getArrival());
        System.out.println(busInfo.getDestination());
        return busService.userSearch(busInfo.getArrival(),busInfo.getDestination(),busInfo.getBusDate());
    }

    @Autowired
    PaymentService paymentService;

    @PostMapping ("/save")
    public void pay(@RequestBody Payment payment){
        System.out.println("payment");
        paymentService.set(payment);

    }

    @RequestMapping(value = "/getpayment")
    public List<Payment> getpaymentdetails(){
        return paymentService.getpaymentdetails();
    }
}
