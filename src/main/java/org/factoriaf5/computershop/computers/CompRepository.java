package org.factoriaf5.computershop.computers; // la ruta hasta donde está este fichero .java 

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompRepository extends JpaRepository<Computers, Long> {

}
