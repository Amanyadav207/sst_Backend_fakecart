package spring.example.fakecartstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.example.fakecartstore.Dto.CartDto;
import spring.example.fakecartstore.Dto.singleDto;

import java.util.*;

@Service
public class CartServices {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com";


    public ArrayList<singleDto> getAll(){
        ArrayList<singleDto> response = restTemplate.getForObject(url + "/Carts/", ArrayList.class);
        return response;
    }
    public singleDto getCartbyId(long id){
        singleDto reponse = restTemplate.getForObject((url+"/Carts/") +id, singleDto.class);
        return  reponse ;
    }
    public ArrayList<singleDto> fromdate(Date d){
        ArrayList<singleDto> reponse= restTemplate.getForObject(url+"carts?startdate="+d+"&",ArrayList.class);
        return reponse;
    }
}
