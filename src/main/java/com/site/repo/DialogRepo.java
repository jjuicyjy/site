package com.site.repo;

import com.site.entity.Dialog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialogRepo extends JpaRepository<Dialog, Long> {
}
