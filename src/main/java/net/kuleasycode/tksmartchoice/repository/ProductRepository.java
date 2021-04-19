package net.kuleasycode.tksmartchoice.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.kuleasycode.tksmartchoice.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

	Page<ProductEntity> findAllByProductNameFromDateLessThanEqualAndValidToDateGreaterThanEqual(String productName, Date startDate, Date endDate, Pageable pageable);
}
