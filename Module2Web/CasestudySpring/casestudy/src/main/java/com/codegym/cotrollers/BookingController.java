package com.codegym.cotrollers;

import com.codegym.entity.FuramaDichVu;
import com.codegym.entity.FuramaHopDong;
import com.codegym.services.DichVuService;
import com.codegym.services.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
public class BookingController {
    @Autowired
    DichVuService dichVuService;
    @Autowired
    HopDongService hopDongService;

    @GetMapping("/booking/{id}")
    public ModelAndView getBookingPage(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("dichvu/booking");
        FuramaDichVu furamaDichVu = dichVuService.getDichVu(id);
        FuramaHopDong furamaHopDong = hopDongService.getHopDong(id);
        System.out.println(furamaHopDong);
        modelAndView.addObject("dichvu", furamaDichVu);
        return modelAndView;
    }
    @PostMapping("booking")
    public ModelAndView saveBooking(@RequestParam(value = "id") Long id, @RequestParam(value = "ngaybatdau") Date ngaybatdau
            , @RequestParam(value = "ngayketthuc") Date ngayketthuc
            , HttpServletRequest request, HttpServletResponse response
    ) {
        FuramaHopDong furamaHopDong = new FuramaHopDong();
        furamaHopDong.setFuramaDichVu(dichVuService.getDichVu(id));
        System.out.println(furamaHopDong.getId());
        furamaHopDong.setNgayLamHopDong(ngaybatdau);
        furamaHopDong.setNgayKetThuc(ngayketthuc);
        furamaHopDong.setIdKhachHang((long) 1);
        furamaHopDong.setIdNhanVien((long) 1);
        hopDongService.saveHopDong(furamaHopDong);
        Iterable<FuramaHopDong> listHopDong = hopDongService.findAllByIdKhachHang((long) 1);
        for (FuramaHopDong hopdong : listHopDong){
            String cookieValue = hopdong.getId() + "_" + hopdong.getFuramaDichVu().getId() + "_" + hopdong.getNgayLamHopDong() +
                    "_" + hopdong.getNgayKetThuc();
            Cookie cookie = new Cookie("hopdong" + hopdong.getId(),cookieValue);
            cookie.setMaxAge(60*60);
            cookie.setPath("/history");
            response.addCookie(cookie);
        }

        ModelAndView modelAndView = new ModelAndView("dichvu/bookingSuccess");
        return modelAndView;
    }
}
