package com.david.proj.simples.crud.Repository;

import com.david.proj.simples.crud.modells.Familias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<Familias,Long> {

}
