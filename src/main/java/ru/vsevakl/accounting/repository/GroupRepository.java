package ru.vsevakl.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsevakl.accounting.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}