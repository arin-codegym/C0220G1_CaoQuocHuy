package com.rin.controller;

import com.rin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
/*
Annotation @SessionAttributes("user") được sử dụng để lưu trữ thông tin của model attribute có tên là user.
 */
@SessionAttributes("user")
public class LoginController {

    /*add user in model attribute
    * Đoạn mã sau đây sẽ add User vào trong model attribute:
    * */
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/dologin")
    /*
    Annotation @ModelAttribute("user") sẽ nhận user trả về từ view, sau đó đưa vào session:
     */
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        //implement business logic
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null)
                setUser = user.getEmail();

            /*

            Annotation @CookieValue để ràng buộc giá trị của cookie HTTP với tham số phương thức trong controller.

response sẽ trả cookie về cho view sử dụng phương thức: response.addCookie(cookie);
           Đoạn mã trên sẽ so sánh email truyền vào có bằng với "admin@gmail.com" và password truyền vào có bằng với "12345" hay không. Nếu đúng sẽ thực hiện các công việc sau:

Gán email truyền vào cho biến setUser
Tạo cookie và trả về cho client
             */
            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            //get all cookies
            Cookie[] cookies = request.getCookies();
            //iterate each cookie
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                /*
                Đoạn mã trên sẽ duyệt danh sách cookie và lấy cookie có tên 'setUser' sau đó truyền vào model.
                 */
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            /*
            model sẽ trả message về cho view trong trường hợp login thành công hoặc thất bại.
             */
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }
}