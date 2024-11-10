package org.factoriaf5.computershop.computers; // la ruta hasta donde está este fichero .java 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CompRepository extends JpaRepository<Computers, Long> {

    @Transactional
    void deleteByTrade(String trade);

    List<Computers> findByTrade(String trade);
}

/*  @Transactional
Al realizar operaciones de escritura como save, update o delete,
es crucial usar transacciones para asegurar la integridad de los datos

Es esencial para asegurar que las operaciones de base de datos se
manejen de manera segura y consistente

Al usarla en tu método te aseguras de que la operación de borrado se complete
con éxito o se revierta completamente en caso de error

Atomicidad: Garantiza que todas las operaciones dentro del método se realicen de manera atómica.
Si ocurre una falla en alguna de las operaciones, todas las operaciones previas se revierten (rollback),
dejando la base de datos en un estado consistente.

Consistencia: Asegura que la base de datos siempre pase de un estado consistente a otro estado consistente.

Aislamiento: Las transacciones permiten que las operaciones sean aisladas unas de otras hasta que se completen,
evitando conflictos de acceso concurrente.

Durabilidad: Una vez que una transacción se confirma (commit),
sus cambios son permanentes, incluso en caso de fallos del sistema.
*/