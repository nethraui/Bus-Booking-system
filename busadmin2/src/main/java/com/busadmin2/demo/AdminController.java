package com.busadmin2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    RestTemplate restTemplate;

//    @RequestMapping("/")
//    public ModelAndView home(){
//        ModelAndView model = new ModelAndView("home");
//        return model;
//    }

    @RequestMapping("/")
    public String home( Map< Object, Object> model) {
        BusInfo bus = new BusInfo();
        model.put("search", bus);
        return "home";
    }

    @RequestMapping("/list")
    public ModelAndView getSearch(Model model) {
        ResponseEntity<BusInfo[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/", BusInfo[].class);
        responseEntity.getStatusCode();
        //System.out.println(responseEntity);
        List<BusInfo> busInfoList = Arrays.asList(responseEntity.getBody());
        //System.out.println(busInfoList);

        model.addAttribute("bus", new BusInfo());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminhome");
        modelAndView.addObject("buslist",busInfoList);

        return modelAndView;
    }

    @RequestMapping("/add")
    public String newBus( Map< Object, Object> model) {
        BusInfo bus = new BusInfo();
        model.put("bus", bus);
        return "addbus";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createAccount(@RequestBody @ModelAttribute("bus") BusInfo busInfo){

        BusInfo newBus = new BusInfo();

        newBus.setArrival(busInfo.getArrival());
        newBus.setBusInfo(busInfo.getBusInfo());
        newBus.setBusName(busInfo.getBusName());
        newBus.setBusTime(busInfo.getBusTime());
        newBus.setBusDate(busInfo.getBusDate());
        newBus.setDestination(busInfo.getDestination());

        ResponseEntity<BusInfo> responseEntity = restTemplate.postForEntity("http://localhost:8080/add",
                newBus, BusInfo.class);
        responseEntity.getStatusCode();
        System.out.println(responseEntity);
//
//        ModelAndView add = new ModelAndView();
//
//        add.setViewName("addbus");
//        add.addObject("add",add);
        return "redirect:/list";
    }

    @RequestMapping("/edit")
    public ModelAndView editBus(@RequestParam int id) {

        BusInfo bus = new BusInfo();

        bus.setId(id);
        ModelAndView modelAndView = new ModelAndView("editbus");

        modelAndView.addObject("bus",bus);
        return modelAndView;
    }

    @RequestMapping(value = "/editnext",method = {RequestMethod.PUT,RequestMethod.POST})
    public String editAccount(@RequestBody @ModelAttribute("bus") BusInfo busInfo){

        BusInfo updatedBus = new BusInfo();

        //ResponseEntity createResponse = ;
        updatedBus.setId(busInfo.getId());
        //updatedBus.setId(createResponse.getBody().getId());
        updatedBus.setArrival(busInfo.getArrival());
        updatedBus.setBusInfo(busInfo.getBusInfo());
        updatedBus.setBusName(busInfo.getBusName());
        updatedBus.setBusTime(busInfo.getBusTime());
        updatedBus.setDestination(busInfo.getDestination());

        restTemplate.put("http://localhost:8080/edit",updatedBus);

        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteBus( @PathVariable("id") int id){

        BusInfo busInfo = new BusInfo();

        busInfo.setId(id);
        restTemplate.delete("http://localhost:8080/delete/" + busInfo.getId());

        return "redirect:/list";
    }


    @RequestMapping(value = "/signupnext", method = {RequestMethod.POST,RequestMethod.GET})
    public String signup(@RequestBody @ModelAttribute("signup") Login login){

        Login signin = new Login();

        signin.setFullName(login.getFullName());
        signin.setEmailId(login.getEmailId());
        signin.setUserName(login.getUserName());
        signin.setGender(login.getGender());
        signin.setPassWord(login.getPassWord());

        ResponseEntity<Login> responseEntity = restTemplate.postForEntity("http://localhost:8080/signup",
                signin, Login.class);
        responseEntity.getStatusCode();
        System.out.println(responseEntity);
//
//        ModelAndView model = new ModelAndView();
//
//        model.setViewName("adminhome");
//        model.addObject("signup",signin);

        return "redirect:/list";
    }

    @RequestMapping("/signup")
    public ModelAndView welcome(Model model){
        model.addAttribute("signup",new Login());
        //List<Account> accountList = accountServices.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup");
        //modelAndView.addObject("accountList",accountList);
        return modelAndView;
    }

    @RequestMapping(value = "/loginnext", method = {RequestMethod.GET,RequestMethod.POST})
    public String loginDetails(@RequestBody @ModelAttribute("logintry") Login login, ModelMap modelMap){

        Login login1 = new Login();
        login1.setUserName(login.getUserName());
        login1.setPassWord(login.getPassWord());

//        System.out.println(login.getUserName());
//
//        System.out.println(login.getPassWord());

        ResponseEntity<Login> responseEntity = restTemplate.postForEntity("http://localhost:8080/login",login1, Login.class);
        System.out.println(responseEntity);

        Login loginneww = responseEntity.getBody();

        if(responseEntity.getBody() == null || responseEntity.getBody().equals(null)){
            modelMap.put("errormsg","Invalid username/passwprd");
            return "/login";
        }
        System.out.println(loginneww);

        modelMap.put("name",loginneww.getFullName());
        System.out.println(modelMap);
        return "redirect:/list";
    }

    @RequestMapping("/login")
    public ModelAndView mainLogin(Model model){
        model.addAttribute("logintry",new Login());
        //List<Account> accountList = accountServices.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        //modelAndView.addObject("accountList",accountList);
        return modelAndView;
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "home";
    }

    @RequestMapping("/adminaccount")
    @ModelAttribute("logintry")
    public ModelAndView adminAccount(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminaccount");
        return modelAndView;
    }

    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String contactt(ModelMap model){
        model.put("contactatt", new Contact());
        System.out.println("hehe");
        return "contact";
    }

    @RequestMapping(value = "/contactsent",method = RequestMethod.POST)
    public String contactSent( @RequestBody @ModelAttribute("contactatt") Contact contact, ModelMap modelMap){

        System.out.println(contact.getFname());
        System.out.println("hjgfg");
    try {
        Contact contact1 = new Contact();

        contact1.setFname(contact.getFname());
        contact1.setEmail(contact.getEmail());
        contact1.setComment(contact.getComment());

        System.out.println(contact.getFname());
        ResponseEntity<Contact> responseEntity = restTemplate.postForEntity("http://localhost:8080/contactsent", contact1, Contact.class);
        System.out.println(responseEntity);
        modelMap.put("msg","Done!");
        } catch (Exception e){
            modelMap.put("msg",e.getMessage());
        }

        return "contact";
    }

    @RequestMapping("/usersignup")
    public ModelAndView userSignup(Model model){
        model.addAttribute("usersignup",new UserLogin());
        //List<Account> accountList = accountServices.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userregistration");
        //modelAndView.addObject("accountList",accountList);
        return modelAndView;
    }

    @RequestMapping(value = "/usersignupnext", method = {RequestMethod.POST,RequestMethod.GET})
    public String userSignup(@RequestBody @ModelAttribute("usersignup") UserLogin userLogin){

        UserLogin signin = new UserLogin();

        signin.setFullName(userLogin.getFullName());
        signin.setEmailId(userLogin.getEmailId());
        signin.setUserName(userLogin.getUserName());
        signin.setGender(userLogin.getGender());
        signin.setPassWord(userLogin.getPassWord());

        ResponseEntity<UserLogin> responseEntity = restTemplate.postForEntity("http://localhost:8080/usersignup",
                signin, UserLogin.class);
        responseEntity.getStatusCode();
        System.out.println(responseEntity);
//
//        ModelAndView model = new ModelAndView();
//
//        model.setViewName("adminhome");
//        model.addObject("signup",signin);

        return "redirect:/";
    }


    @RequestMapping(value = "/userloginnext", method = {RequestMethod.GET,RequestMethod.POST})
    public String userloginDetails(@RequestBody @ModelAttribute("userlogin") UserLogin userLogin,ModelMap modelMap){

        UserLogin login = new UserLogin();
        login.setUserName(userLogin.getUserName());
        login.setPassWord(userLogin.getPassWord());

//        System.out.println(login.getUserName());
//
//        System.out.println(login.getPassWord());

        ResponseEntity<UserLogin> responseEntity = restTemplate.postForEntity(
                "http://localhost:8080/userlogin",
                login, UserLogin.class);

        modelMap.put("usernameee",responseEntity.getBody());
        System.out.println(modelMap);

        System.out.println(responseEntity.getBody());

        if(responseEntity.getBody() == null || responseEntity.getBody().equals(null)){
            modelMap.put("errormsg","Invalid username/password");
            return "/userlogin";
        }

        return "redirect:/userwelcome";
    }

    @RequestMapping("/userlogin")
    public ModelAndView userLogin(Model model){
        model.addAttribute("userlogin",new UserLogin());
        //List<Account> accountList = accountServices.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userlogin");
        //modelAndView.addObject("accountList",accountList);
        return modelAndView;
    }

    @RequestMapping("/userwelcome")
    public ModelAndView userWelcome(Map< Object, Object> model){

        model.put("usersearch", new BusInfo());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userwelcome");

        return modelAndView;
    }

    @RequestMapping("/useraccount")
    public ModelAndView userAccount(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("useraccount");
        return modelAndView;
    }

    @RequestMapping("/bookinghistory")
    public ModelAndView bookingHistory(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookinghistory");
        return modelAndView;
    }

    @RequestMapping(value = "/searchlist",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView normalSearch(@RequestBody @ModelAttribute("search") BusInfo busInfo) {

        BusInfo searchBus = new BusInfo();

        searchBus.setArrival(busInfo.getArrival());
        searchBus.setDestination(busInfo.getDestination());
        searchBus.setBusDate(busInfo.getBusDate());

        ResponseEntity<BusInfo[]> responseEntity = restTemplate.postForEntity("http://localhost:8080/usersearch", searchBus,BusInfo[].class);
        responseEntity.getStatusCode();
        //System.out.println(responseEntity);
        List<BusInfo> searchList = Arrays.asList(responseEntity.getBody());
        //System.out.println(busInfoList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchlist");
        modelAndView.addObject("searchlist",searchList);
        System.out.println(searchList);
        //modelAndView.addAttribute("usersearch", new BusInfo());
        return modelAndView;
    }

    @RequestMapping(value = "/usersearchlist",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView userSearch(@RequestBody @ModelAttribute("usersearch") BusInfo busInfo) {

        BusInfo searchBus = new BusInfo();

        searchBus.setArrival(busInfo.getArrival());
        searchBus.setDestination(busInfo.getDestination());
        searchBus.setBusDate(busInfo.getBusDate());

        ResponseEntity<BusInfo[]> responseEntity1 = restTemplate.postForEntity("http://localhost:8080/usersearch", searchBus,BusInfo[].class);
        responseEntity1.getStatusCode();
        System.out.println(responseEntity1);
        List<BusInfo> usersearchList = Arrays.asList(responseEntity1.getBody());
        System.out.println(usersearchList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersearchlist");
        modelAndView.addObject("usersearchlist",usersearchList);
        System.out.println(usersearchList);
        //modelAndView.addAttribute("usersearch", new BusInfo());
        return modelAndView;
    }

    @RequestMapping(value = "/bookbus/{id}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView bookBus(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookbus");
        return modelAndView;
    }


    @RequestMapping(value = "/payment")
    public ModelAndView payment()
    {
        ModelAndView modelAndView=new ModelAndView("payment");
        return modelAndView;
    }


    @RequestMapping(value = "/paymentsave", method = RequestMethod.POST)
    public String registrationDetails(@ModelAttribute Payment payment,ModelMap modelMap) {

        try {
            //System.out.println("payment success");
            ResponseEntity<Payment[]> paymentResponseEntity = restTemplate.postForEntity("http://localhost:8080/save", payment, Payment[].class);
            System.out.println(paymentResponseEntity);
            modelMap.put("msg","Payment Done!!!");

        } catch (Exception e){
            modelMap.put("msg",e.getMessage());
        }
         return "userwelcome";
    }

    @RequestMapping(value = "/about")
    public ModelAndView about()
    {
        ModelAndView modelAndView=new ModelAndView("about");
        return modelAndView;
    }
}
