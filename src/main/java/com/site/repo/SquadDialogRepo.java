package com.site.repo;

import com.site.entity.SquadDialog;
import com.site.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadDialogRepo extends JpaRepository<SquadDialog, Long> {
    boolean existsByUserId(User userId);
}
