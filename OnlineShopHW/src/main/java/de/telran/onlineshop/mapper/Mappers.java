package de.telran.onlineshop.mapper;

import de.telran.onlineshop.configure.MapperUtil;
import de.telran.onlineshop.dto.*;
import de.telran.onlineshop.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class Mappers {

    //@Autowired
    private final ModelMapper modelMapper;

    // Cart
    public CartDto convertToCartDto(CartEntity cartEntity) {
        CartDto cartDto = null;
        if(cartEntity!=null)
            cartDto = modelMapper.map(cartEntity, CartDto.class); //автомат

        if (cartEntity.getCartItems() != null) {
            Set<CartItemDto> cartItemDtoSet = MapperUtil.convertSet(cartEntity.getCartItems(), this::convertToCartItemDto);
            cartDto.setCartItems(cartItemDtoSet);
        }

        UserDto userDto = convertToUserDto(cartEntity.getUser()); // второй связанный объект
        cartDto.setUser(userDto);

        return cartDto;
    }

    public CartEntity convertToCartEntity(CartDto cartDto) {
        CartEntity cartEntity = modelMapper.map(cartDto, CartEntity.class);

        if (cartDto.getCartItems() != null) {
            Set<CartItemsEntity> cartItemsEntitySet = MapperUtil.convertSet(cartDto.getCartItems(), this::convertToCartItemsEntity);
            cartEntity.setCartItems(cartItemsEntitySet);
        }

        UsersEntity usersEntity = convertToUserEntity(cartDto.getUser()); // второй связанный объект
        cartEntity.setUser(usersEntity);

        return cartEntity;

    }


    // CartItem
    public CartItemDto convertToCartItemDto(CartItemsEntity cartItemsEntity) {
        CartItemDto cartItemDto = modelMapper.map(cartItemsEntity, CartItemDto.class);

        CartDto cartDto = convertToCartDto(cartItemsEntity.getCart()); // второй связанный объект
        cartItemDto.setCart(cartDto);

        ProductDto productDto = convertToProductDto(cartItemsEntity.getProduct()); // второй связанный объект
        cartItemDto.setProduct(productDto);

        return cartItemDto;

    }

    public CartItemsEntity convertToCartItemsEntity(CartItemDto cartItemDto) {
        CartItemsEntity cartItemsEntity = modelMapper.map(cartItemDto, CartItemsEntity.class);

        CartEntity cartEntity = convertToCartEntity(cartItemDto.getCart());
        cartItemsEntity.setCart(cartEntity);

        ProductsEntity productsEntity = convertToProductEntity(cartItemDto.getProduct());
        cartItemsEntity.setProduct(productsEntity);

        return cartItemsEntity;
    }


    // Category
    public CategoryDto convertToCategoryDto(CategoriesEntity categoriesEntity) {
        CategoryDto categoryDto = modelMapper.map(categoriesEntity, CategoryDto.class);

        if (categoriesEntity.getProducts() != null) {
            Set<ProductDto> productDtoSet = MapperUtil.convertSet(categoriesEntity.getProducts(), this::convertToProductDto);
            categoryDto.setProducts(productDtoSet);
        }

        return categoryDto;
    }

    public CategoriesEntity convertToCategoriesEntity(CategoryDto categoryDto) {
        CategoriesEntity categoriesEntity = modelMapper.map(categoryDto, CategoriesEntity.class);

        if (categoryDto.getProducts() != null) {
            Set<ProductsEntity> productsEntitySet = MapperUtil.convertSet(categoryDto.getProducts(), this::convertToProductEntity);
            categoriesEntity.setProducts(productsEntitySet);
        }

        return categoriesEntity;
    }

    // Favorite
    public FavoriteDto convertToFavoritesDto(FavoritesEntity favoritesEntity) {
        FavoriteDto favoriteDto = modelMapper.map(favoritesEntity, FavoriteDto.class); //автомат

        favoriteDto.setUser(null);

        ProductDto productDto = convertToProductDto(favoritesEntity.getProduct()); // второй связанный объект
        favoriteDto.setProduct(productDto);

        return favoriteDto;
    }

    public FavoritesEntity convertToFavoritesEntity(FavoriteDto favoriteDto) {
        FavoritesEntity favoritesEntity = modelMapper.map(favoriteDto, FavoritesEntity.class); //автомат

        modelMapper.typeMap(FavoriteDto.class, FavoritesEntity.class)
                .addMappings(mapper -> mapper.skip(FavoritesEntity::setUser)); // исключаем этот метод из работы

        ProductsEntity productsEntity = convertToProductEntity(favoriteDto.getProduct());
        favoritesEntity.setProduct(productsEntity);

        return favoritesEntity;
    }



    // Order
    public OrderDto convertToOrderDto(OrdersEntity ordersEntity) {
        OrderDto orderDto = modelMapper.map(ordersEntity, OrderDto.class); //автомат

        UserDto userDto = convertToUserDto(ordersEntity.getUser()); // второй связанный объект
        orderDto.setUser(userDto);

        if (ordersEntity.getOrderItems() != null) {
            Set<OrderItemDto> orderItemDtoSet = MapperUtil.convertSet(ordersEntity.getOrderItems(), this::convertToOrderItemDto);
            orderDto.setOrderItems(orderItemDtoSet);
        }

        return orderDto;
    }

    public OrdersEntity convertToOrderEntity(OrderDto orderDto) {
        OrdersEntity ordersEntity = modelMapper.map(orderDto, OrdersEntity.class); //автомат

        UsersEntity usersEntity = convertToUserEntity(orderDto.getUser());
        ordersEntity.setUser(usersEntity);

        if (orderDto.getOrderItems() != null){
            Set<OrderItemsEntity> orderItemsEntitySet = MapperUtil.convertSet(orderDto.getOrderItems(), this::convertToOrderItemsEntity);
            ordersEntity.setOrderItems(orderItemsEntitySet);
        }

        return ordersEntity;
    }


    // OrderItem
    public OrderItemDto convertToOrderItemDto(OrderItemsEntity orderItemsEntity) {
        OrderItemDto orderItemDto = modelMapper.map(orderItemsEntity, OrderItemDto.class); //автомат

        ProductDto productDto = convertToProductDto(orderItemsEntity.getProduct()); // второй связанный объект
        orderItemDto.setProduct(productDto);

        OrderDto orderDto = convertToOrderDto(orderItemsEntity.getOrder()); // второй связанный объект
        orderItemDto.setOrder(orderDto);

        return orderItemDto;
    }

    public OrderItemsEntity convertToOrderItemsEntity(OrderItemDto orderItemDto) {
        OrderItemsEntity orderItemsEntity = modelMapper.map(orderItemDto, OrderItemsEntity.class); //автомат

        ProductsEntity productsEntity = convertToProductEntity(orderItemDto.getProduct());
        orderItemsEntity.setProduct(productsEntity);

        OrdersEntity ordersEntity = convertToOrderEntity(orderItemDto.getOrder());
        orderItemsEntity.setOrder(ordersEntity);

        return orderItemsEntity;
    }



    // Product
    public ProductDto convertToProductDto(ProductsEntity productsEntity) {
        ProductDto productDto = modelMapper.map(productsEntity, ProductDto.class);

        if (productsEntity.getFavorites() != null) {
            Set<FavoriteDto> favoritesDtoSet = MapperUtil.convertSet(productsEntity.getFavorites(), this::convertToFavoritesDto);
            productDto.setFavorites(favoritesDtoSet);
        }

        if (productsEntity.getOrderItems() != null) {
            Set<OrderItemDto> orderItemsDtoSet = MapperUtil.convertSet(productsEntity.getOrderItems(), this::convertToOrderItemDto);
            productDto.setOrderItems(orderItemsDtoSet);
        }

        if (productsEntity.getCartItems() != null) {
            Set<CartItemDto> cartItemDtoSet = MapperUtil.convertSet(productsEntity.getCartItems(), this::convertToCartItemDto);
            productDto.setCartItems(cartItemDtoSet);
        }

        CategoryDto categoryDto = convertToCategoryDto(productsEntity.getCategory()); // второй связанный объект
        productDto.setCategory(categoryDto);

        return productDto;
    }

    public ProductsEntity convertToProductEntity(ProductDto productDto) {
        ProductsEntity productsEntity = modelMapper.map(productDto, ProductsEntity.class);

        if (productDto.getFavorites() != null) {
            Set<FavoritesEntity> favoritesEntitySet = MapperUtil.convertSet(productDto.getFavorites(), this::convertToFavoritesEntity);
            productsEntity.setFavorites(favoritesEntitySet);
        }

        if (productDto.getOrderItems() != null) {
            Set<OrderItemsEntity> orderItemsEntitySet = MapperUtil.convertSet(productDto.getOrderItems(), this::convertToOrderItemsEntity);
            productsEntity.setOrderItems(orderItemsEntitySet);
        }

        if (productDto.getCartItems() != null) {
            Set<CartItemsEntity> cartItemsEntitySet = MapperUtil.convertSet(productDto.getCartItems(), this::convertToCartItemsEntity);
            productsEntity.setCartItems(cartItemsEntitySet);
        }

        CategoriesEntity categoriesEntity = convertToCategoriesEntity(productDto.getCategory()); // второй связанный объект
        productsEntity.setCategory(categoriesEntity);

        return productsEntity;
    }


    // User
    public UserDto convertToUserDto(UsersEntity usersEntity) {
        modelMapper.typeMap(UsersEntity.class, UserDto.class)
                .addMappings(mapper -> mapper.skip(UserDto::setEmail)); // исключаем этот метод из работы
        UserDto userDto = modelMapper.map(usersEntity, UserDto.class); //автомат
        if (userDto.getPasswordHash()!=null)
            userDto.setPasswordHash("***"); // замещаем данных

        // преобразовываем
        if (usersEntity.getFavorites() != null) {
            Set<FavoriteDto> favoritesDtoSet = MapperUtil.convertSet(usersEntity.getFavorites(), this::convertToFavoritesDto);
            userDto.setFavorites(favoritesDtoSet);
        }

        if (usersEntity.getOrders() != null) {
            Set<OrderDto> orderDtoSet = MapperUtil.convertSet(usersEntity.getOrders(), this::convertToOrderDto);
            userDto.setOrders(orderDtoSet);
        }

        CartDto cartDto = convertToCartDto(usersEntity.getCart()); // второй связанный объект
        userDto.setCart(cartDto);
        return userDto;
    }

    public UsersEntity convertToUserEntity(UserDto userDto) {
        UsersEntity usersEntity = modelMapper.map(userDto, UsersEntity.class); //автомат
        modelMapper.typeMap(UserDto.class, UsersEntity.class)
                .addMappings(mapper -> mapper.skip(UsersEntity::setEmail)); // исключаем этот метод из работы

        modelMapper.typeMap(UserDto.class, UsersEntity.class)
                .addMappings(mapper -> mapper.skip(UsersEntity::setPasswordHash)); // исключаем этот метод из работы

        if (userDto.getFavorites() != null){
            Set<FavoritesEntity> favoritesEntitySet = MapperUtil.convertSet(userDto.getFavorites(), this::convertToFavoritesEntity);
            usersEntity.setFavorites(favoritesEntitySet);
        }

        if (userDto.getOrders() != null){
            Set<OrdersEntity> ordersEntitySet = MapperUtil.convertSet(userDto.getOrders(), this::convertToOrderEntity);
            usersEntity.setOrders(ordersEntitySet);
        }

        CartEntity cartEntity = convertToCartEntity(userDto.getCart()); // второй связанный объект
        usersEntity.setCart(cartEntity);

        return usersEntity;
    }
}
