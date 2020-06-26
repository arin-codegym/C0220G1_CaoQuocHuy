package com.codegym.cotrollers;

import com.codegym.entity.FuramaDichVu;
import com.codegym.entity.FuramaHopDong;

import com.codegym.services.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HistoryBookingController {
    @Autowired
    DichVuService dichVuService;

    @GetMapping("/history")
    public ModelAndView getHistoryPage(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("dichvu/history");
        Cookie[] cookies = request.getCookies();
        List<FuramaHopDong> listhopdong = new ArrayList<>();
        for (int i = 0; i < cookies.length; i++){
            if (cookies[i].getName().contains("hopdong")){
                FuramaHopDong hopDong = new FuramaHopDong();
                String[] cookiaValue = cookies[i].getValue().split("\\_");
                hopDong.setId(Long.parseLong(cookiaValue[0]));
                FuramaDichVu furamaDichVu=dichVuService.getDichVu(Long.parseLong(cookiaValue[1]));
                hopDong.setFuramaDichVu(furamaDichVu);
                hopDong.setNgayLamHopDong(Date.valueOf(cookiaValue[2]));
                hopDong.setNgayKetThuc(Date.valueOf(cookiaValue[3]));
                listhopdong.add(hopDong);
            }
        }
        modelAndView.addObject("historyHopdong", listhopdong);

        return modelAndView;
    }
}
