package net.kuleasycode.tksmartchoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kuleasycode.tksmartchoice.entity.SearchHistoryEntity;

public interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity, String>{

}
