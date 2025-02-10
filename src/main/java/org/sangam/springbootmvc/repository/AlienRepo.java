package org.sangam.springbootmvc.repository;

import org.sangam.springbootmvc.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlienRepo extends JpaRepository<Alien,Integer> {

   // List<Alien> findByAname(String name); //Query DSL

    @Query("from Alien where aname = :name")
    List<Alien> find(@Param("name") String aname);
}
