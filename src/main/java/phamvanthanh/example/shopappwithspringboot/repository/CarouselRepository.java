package phamvanthanh.example.shopappwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phamvanthanh.example.shopappwithspringboot.model.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, Long> {

}
