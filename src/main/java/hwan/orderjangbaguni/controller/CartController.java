package hwan.orderjangbaguni.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CartController {

    @GetMapping(value = "/cart")
    public String showCart() {
        return "/carts/cartform";
    }
}
