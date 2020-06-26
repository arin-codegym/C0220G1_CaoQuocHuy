package com.codegym.cotrollers;

import com.codegym.entity.FuramaFavorite;
import com.codegym.services.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("favorite")
public class HomeController {
    @Autowired
    private DichVuService dichVuService;
    @GetMapping("/")
    public ModelAndView getHomePage(@RequestParam(value = "fromPrice", required = false) Double fromPrice
            ,@RequestParam(value = "toPrice", required = false) Double toPrice)
    {
        ModelAndView modelAndView = new ModelAndView("home/index");
        if (fromPrice == null || toPrice == null){
            modelAndView.addObject("listDichVu", dichVuService.getAllDichVu());
        }else {
            modelAndView.addObject("listDichVu",dichVuService.findAllByChiPhiThueBetween(fromPrice,toPrice));
        }
        return modelAndView;
    }
//    @GetMapping
//    public ModelAndView homePage() {
//        return new ModelAndView("home/index", "listDichVu", dichVuService.getAllDichVu());
//    }

    @GetMapping("/dichvu/{id}")
    public ModelAndView getDichVuDetail(@PathVariable long id) {
      return new ModelAndView("dichvu/dichvuchitiet","dichvuchitiet",dichVuService.getDichVu(id));

    }
    @GetMapping("/favorite/{id}")
    public String saveSessionFavorite(@PathVariable long id, @ModelAttribute("favorite") FuramaFavorite sessionFavorite){

        sessionFavorite.add(dichVuService.getDichVu(id));

        return "redirect:/";
    }

    @GetMapping("/favoritePage")
    public String getFavoritePage(){
        return "home/favorite";
    }

    //setup Session favorite
    @ModelAttribute("favorite")
    public FuramaFavorite setupSession(){
        return new FuramaFavorite();
    }


}
