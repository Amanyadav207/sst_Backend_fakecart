package spring.example.fakecartstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.example.fakecartstore.Dto.CartDto;
import spring.example.fakecartstore.Dto.singleDto;
import spring.example.fakecartstore.services.CartServices;

import java.util.*;

@RestController
public class Cartcontroller {
    private CartServices cartServices;

     Cartcontroller(CartServices cartServices) {
        this.cartServices = cartServices;
     }

    @GetMapping("/Carts/")
    public ArrayList<singleDto> getAl(){
        return cartServices.getAll();
    }
    @GetMapping("/Carts/{id}")
    public singleDto getCartbyId(@PathVariable long id){
        return cartServices.getCartbyId(id);
    }


//
//    @GetMapping("/Carts?startdate={sdate}")
//    public ArrayList<singleDto> fromstart( @PathVariable Date sdate){
//        ArrayList<singleDto> Alldata = getAl();
//        ArrayList<singleDto> ans = new ArrayList<singleDto>() {};
//        for(singleDto i : Alldata){
//            if((i.date.after(sdate))){
//                ans.add(i);
//            }
//        }
//        return ans;
//    }
    @GetMapping("/Carts?startdate={sdate}")
    public ArrayList<singleDto> fromstart(@PathVariable Date sdate){
         return cartServices.fromdate(sdate);
    }


}
