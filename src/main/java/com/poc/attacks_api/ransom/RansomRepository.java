package com.poc.attacks_api.ransom;

import com.poc.attacks_api.ransom.entity.Ransomware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RansomRepository extends JpaRepository<Ransomware, Long> {

    @Query("SELECT p FROM Ransomware p JOIN p.ransomwareAlias c WHERE c.alias = :ransomwareName")
    List<Ransomware> getRansomwareByName(@Param("ransomwareName") String ransomwareName);
}
