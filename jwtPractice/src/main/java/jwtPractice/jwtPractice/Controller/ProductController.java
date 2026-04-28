package jwtPractice.jwtPractice.Controller;

import jwtPractice.jwtPractice.DTOs.ProductDTO;
import jwtPractice.jwtPractice.Model.Product;
import jwtPractice.jwtPractice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Void> salvarProduct(@RequestBody ProductDTO dto){

        service.saveProduct(dto);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> listarProducts() {

        return ResponseEntity.ok(service.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> buscarPorId(@PathVariable UUID id) {

        return ResponseEntity.ok(service.findProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarProduct(
            @PathVariable UUID id,
            @RequestBody ProductDTO dto
    ) {

        service.updateProduct(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduct(@PathVariable UUID id) {

        service.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}