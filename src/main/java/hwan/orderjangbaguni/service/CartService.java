package hwan.orderjangbaguni.service;


import hwan.orderjangbaguni.domain.item.Item;
import hwan.orderjangbaguni.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<Item> findItems() {
        return cartRepository.findCart();
    }
}
