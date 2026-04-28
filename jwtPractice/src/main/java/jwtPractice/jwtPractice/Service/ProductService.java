package jwtPractice.jwtPractice.Service;

import jwtPractice.jwtPractice.DTOs.ProductDTO;
import jwtPractice.jwtPractice.Model.Product;
import jwtPractice.jwtPractice.Model.User;
import jwtPractice.jwtPractice.repository.ProductRepository;
import jwtPractice.jwtPractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private void validateInput(ProductDTO dto){

        if(dto.getTitle().isBlank()){
            throw new IllegalArgumentException("Título não pode estar vazio");
        }
    }

    public void saveProduct(ProductDTO dto){

        validateInput(dto);

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Product product = Product.builder()
                .title(dto.getTitle())
                .user(user)
                .build();

        productRepository.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(UUID id){

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void updateProduct(UUID id, ProductDTO dto){

        validateInput(dto);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setTitle(dto.getTitle());

        productRepository.save(product);
    }

    public void deleteProduct(UUID id){

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        productRepository.delete(product);
    }
}