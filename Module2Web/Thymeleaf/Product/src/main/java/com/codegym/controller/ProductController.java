package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
    Annotation @Controller giúp Spring xác định lớp hiện tại là một Controller.
    Annotation @GetMapping xác định phương thức Index sẽ đón nhận các request có HTTP method là GET và URI pattern là "/"
    Phương thức Index được truyền vào một tham số có kiểu dữ liệu là Model. Model có nhiệm vụ là truyền dữ liệu từ Controller tới View. Ở đây, chúng ta sẽ lấy ra danh sách các khách hàng thông qua customerService.findAll(). Sau đó gắn danh sách này vào Model thông qua phương thức addAttribute(). customers chính là tên biến đại diện cho danh sách mà ta sẽ dùng ở View sau này.
    Phương thức Index sẽ trả về một String, từ String này mà Spring MVC sẽ suy ra View nào sẽ nhận dữ liệu từ Controller (return "index"), vậy View sẽ nhận dữ liệu ở đây là index.html
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    /*
    Giá trị trong @GetMapping tương ứng đường link của button "Add new customer".
Chúng ta sẽ truyền sang view create.html một model Customer có tên là customer. Mỗi thuộc tính của customer sẽ tương ứng với một input trong form.
     */
    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    /*
    Do request gửi lên có HTTP method là POST, nên ta sẽ sử dụng @PostMapping.
Đối tượng customer được truyền vào save() chính là đối tượng customer chúng ta đã truyền từ phương thức create() sang view create.html. Đối tượng này sẽ lưu thông tin của người dùng nhập vào.
customer.setId() sẽ tạo Id ngẫu nhiên cho đối tượng customer.
Sau khi lưu customer, chúng ta sẽ redirect về trang danh sách khách hàng. Chuỗi đằng sau "redirect:" là đường dẫn của trang mà mình muốn redirect. Đồng thời, chúng ta cũng sẽ gửi một Flash message về trang danh sách khách hàng để thông báo lưu thành công, bằng cách sử dụng redirect.addFlashAttribute(messageName, messageContent).
     */
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }

    /*
    Tham số @PathVariable int id lấy id của customer từ đường dẫn rồi gán vào biến id.
hàm customerService.findById(id) sẽ lấy customer theo id rồi truyền sang view edit.html
     */
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}


