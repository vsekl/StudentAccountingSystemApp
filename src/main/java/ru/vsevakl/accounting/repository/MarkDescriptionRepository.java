package ru.vsevakl.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsevakl.accounting.domain.MarkDescription;

@Repository
public interface MarkDescriptionRepository extends JpaRepository<MarkDescription, Long> {
}
