package net.kuleasycode.tksmartchoice.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.kuleasycode.tksmartchoice.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

//	@Query("SELECT pr FROM ProductEntity pr "
//			+ " WHERE pr.productName like :productName "
//			+ " AND DATE(pr.createdDate) BETWEEN DATE(:startDate) AND DATE(:endDate) ")
//	Page<ProductEntity> findAllByProductNameContainingAndCreatedDateBetween(@Param("productName")String productName, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);
	
	Page<ProductEntity> findByProductNameIgnoreCaseContaining(String productName, Pageable pageable);
}
