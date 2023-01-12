package com.javatechie.jwt.api.controller;



import com.javatechie.jwt.api.dto.request.AccountRequestdto;
import com.javatechie.jwt.api.dto.request.AccountResponseDto;
import com.javatechie.jwt.api.dto.request.CustomerRequestDto;
import com.javatechie.jwt.api.entity.Account;
import com.javatechie.jwt.api.entity.Address;
import com.javatechie.jwt.api.entity.AuthRequest;

import com.javatechie.jwt.api.entity.Customer;
import com.javatechie.jwt.api.entity.Transaction;
import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.AccRepo;
import com.javatechie.jwt.api.repository.AddRepo;
//import com.javatechie.jwt.api.filter.JwtFilter;
import com.javatechie.jwt.api.repository.CustRepo;
import com.javatechie.jwt.api.repository.TransactRepo;
import com.javatechie.jwt.api.repository.UserRepository;
import com.javatechie.jwt.api.service.CustDocService;
import com.javatechie.jwt.api.service.CustService;
//import com.javatechie.jwt.api.util.JwtUtil;
import com.javatechie.jwt.api.util.JwtUtil;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private CustRepo crp;
    
//    @Autowired
//    private AccountRequestdto adto;
//    
    @Autowired
    private AccRepo arp;
    
    @Autowired
    private AddRepo adrp;
    
    @Autowired
	TransactRepo tr;
    
    @Autowired
    private UserRepository ur;
    
    @Autowired
	private CustDocService productImageService;
    
    String userName;
    
    @Autowired
    private CustService csc;
//    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to javatechie 56788 !!";
    }
    
    @GetMapping("/welcome")
    public String welcome1() {
        return "Welcome to javatechie 7876555 !!";
    }

    @PostMapping("/create")
    public void create( @RequestBody  CustomerRequestDto crdto) {
    	
    	 csc.saveCust(crdto);
    	 
       
    	
    }
    
    @PostMapping("/createAcc")
    public void createAcc( @RequestBody AccountRequestdto accReq) {
    	
    	 csc.saveAccount(accReq);
    	 
       
    	
    }
    
   
    
    @RequestMapping(value = "/getAcc", method = RequestMethod.GET)
    public List<Account> getUser(Authentication authentication, Principal principal) {
      //  System.out.println(authentication.name());
        System.out.println("-----------------");
        System.out.println(principal.getName());
        
        
       userName= principal.getName();
       
       
        
        int id= crp.findByFirstName(userName).getCustomerId();

        Optional<Customer> optCust=crp.findById(id);
        Customer c1=optCust.get();
       // adto.setAccountType(userName)
        //return arp.getAcc(id);
        return c1.getAccoutns();
    }
    
//    @RequestMapping(value = "/getAcc", method = RequestMethod.GET)
//    public List<Account> getAcc(Authentication authentication, Principal principal) {
//      //  System.out.println(authentication.name());
//        System.out.println("-----------------");
//        System.out.println(principal.getName());
//        
//        
//       userName= principal.getName();
//       
//       
//        
//        int id= crp.findByFirstName(userName).getCustomerId();
//
//        Optional<Customer> optCust=crp.findById(id);
//        Customer c1=optCust.get();
//       // adto.setAccountType(userName)
//        //return arp.getAcc(id);
//        return c1.getAccoutns();
//    }
    
    @RequestMapping(value = "/getAdd", method = RequestMethod.GET)
    public Address getAddress(Authentication authentication, Principal principal) {
      //  System.out.println(authentication.name());
        System.out.println("-----------------");
        System.out.println(principal.getName());
        
       userName= principal.getName();
       
       
        
        int id= crp.findByFirstName(userName).getCustomerId();
       // return arp.getAcc(id);
       
        
        Optional<Customer> optCust=crp.findById(id);
        Customer c1=optCust.get();
        return c1.getAddress();
      //  return  crp.findByCustomerId(id);
    }
    
    
    @RequestMapping(value = "/getTransact", method = RequestMethod.GET)
    public List<Transaction> getUserTransact(Authentication authentication, Principal principal) {
      //  System.out.println(authentication.name());
        System.out.println("-----------------");
        System.out.println(principal.getName());
        
       userName= principal.getName();
       
       
        
        int id= crp.findByFirstName(userName).getCustomerId();
       // return tr.gettrdata(id);
        return tr.gettrdata(id);
      //  return  crp.findByCustomerId(id);
    }
    
    
    @RequestMapping(value = "/getDoc", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getUserDoc(Authentication authentication, Principal principal) throws IOException {
      //  System.out.println(authentication.name());
        System.out.println("-----------------");
        System.out.println(principal.getName());
        
       userName= principal.getName();
       
       Integer id= crp.findByFirstName(userName).getCustomerId();
        
       byte[] image = productImageService.downloadImage(id.toString());
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
    
    
    
    
    
//  @RequestMapping(value = "/name", method = RequestMethod.GET)
//  public Address getUser(Authentication authentication, Principal principal) {
//    //  System.out.println(authentication.name());
//      System.out.println("-----------------");
//      System.out.println(principal.getName());
//      
//     userName= principal.getName();
//     
//     
//      
//      return crp.;
//  }
    
    
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public Address getAddress(Authentication authentication, Principal principal) {
//      //  System.out.println(authentication.name());
//        System.out.println("-----------------");
//        System.out.println(principal.getName());
//        
//       userName= principal.getName();
//       
//       
//        
//        return crp.findByUserName(userName);
//    }
//    
  @PostMapping("/authenticate")
  public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
      try {
          authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
          );
      } catch (Exception ex) {
          throw new Exception("inavalid username/password");
      }
      return jwtUtil.generateToken(authRequest.getUserName());
  }
  
}
