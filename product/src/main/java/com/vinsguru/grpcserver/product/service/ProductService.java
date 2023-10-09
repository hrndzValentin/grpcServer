package com.vinsguru.grpcserver.product.service;

import com.vinsguru.GrpcServermongoDb.product.*;
import com.vinsguru.grpcserver.product.repository.ProductRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    @Autowired
    private ProductRepository repository;
    @Override
    public void getProductById(ProductSearchRequest request, StreamObserver<ProductResponse> responseObserver) {
        ProductResponse.Builder builder = ProductResponse.newBuilder();
        Product.Builder product1 = Product.newBuilder();
        this.repository.findById(request.getId())
                .ifPresent(product -> {

                    product1.setId(product.getId())
                                    .setCode(product.getCode())
                                            .setName(product.getName())
                                                    .setPriceSale(product.getPrice());

                    builder.setProductoDto(product1);
                });

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void postProduct(Product request, StreamObserver<ProductPostResponse> responseObserver) {
        ProductPostResponse.Builder productResponse = ProductPostResponse.newBuilder();
        com.vinsguru.grpcserver.product.entity.Product product = new com.vinsguru.grpcserver.product.entity.Product(request.getId(), request.getCode(), request.getName(), request.getPriceSale());
        this.repository.save(product);
        productResponse.setMensaje("Producto ingresado en la base de datos");

        responseObserver.onNext(productResponse.build());
        responseObserver.onCompleted();
    }
}
