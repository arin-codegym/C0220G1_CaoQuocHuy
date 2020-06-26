package com.codegym.cotrollers;

import com.codegym.entity.FuramaKhachHang;
import com.codegym.entity.FuramaLoaiKhachHang;
import com.codegym.services.KhachHangService;
import com.codegym.services.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.*;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    LoaiKhachHangService loaiKhachHangService;

    @GetMapping("/addNewCustomer")
    public ModelAndView getNewKhachHang() {
        ModelAndView modelAndView = new ModelAndView("admin/customer/addNewCustomer");
        modelAndView.addObject("khachhang", new FuramaKhachHang());

        modelAndView.addObject("listLoaiKhach", loaiKhachHangService.getAllLoaiKhachHang());
        return modelAndView;
    }

    @PostMapping("/admin/addNewCustomer")
    public String saveKhachHang(@ModelAttribute("khachhang") FuramaKhachHang khachhang) {
        khachHangService.saveKhachHang(khachhang);
        return "khachhang/danhsachkhachhang";
    }

    @GetMapping("/listKhachHang")
    public ModelAndView getListKhachHang(@PageableDefault(value = 5) Pageable pageable,
                                         @RequestParam(name = "firstname") Optional<String> name, Model model) {
        Page<FuramaKhachHang> listKhachHang;
        if (name.isPresent()) {
            listKhachHang = khachHangService.findAllByHoTenContaining(name.get(), pageable);
            model.addAttribute("listKhachHang", listKhachHang);
            model.addAttribute("firstname", name);
        } else {
            listKhachHang = khachHangService.getAllKhachHang(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("admin/customer/listKhachHang");
        modelAndView.addObject("listKhachHang", listKhachHang);
        return modelAndView;
    }

    @GetMapping("/admin/xoakhachhang")
    public String delKhachHang(@RequestParam(name = "id") long id) {
        khachHangService.deleteKhachHang(id);
        return "redirect:/admin/listKhachHang";
    }

    @GetMapping("/admin/suathongtinkhachhang")
    public ModelAndView editKhachHang(@RequestParam(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("/admin/customer/edit");
        modelAndView.addObject("khachhang", khachHangService.getKhachHang(id));
        modelAndView.addObject("listLoaiKhach",loaiKhachHangService.getAllLoaiKhachHang());
        return modelAndView;

    }
    @PostMapping("suathongtinkhachhang")
    public String saveEditKhachHang(){
        return "redirect:/admin/addNewCustomer";
    }
}
