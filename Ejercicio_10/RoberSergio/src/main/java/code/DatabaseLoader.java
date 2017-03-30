package code;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    @Autowired
    private TablonDeAnunciosRepository repository;

    @PostConstruct
    private void initDatabase() {
        // Create
        repository.save(new TablonDeAnuncios("Nota1", "Prueba", "Prueba de la nota1"));
        repository.save(new TablonDeAnuncios("Nota2", "Prueba2", "Prueba de la segunda nota (nota2)"));

        // Update
        TablonDeAnuncios firstCustomet = repository.findAll().iterator().next();
        System.out.println(firstCustomet);
        firstCustomet.setAsunto("Peter");
        repository.save(firstCustomet);

        // Read
        Iterable<TablonDeAnuncios> all = repository.findAll();
        for (TablonDeAnuncios TablonDeAnuncios : all) {
            System.out.println(TablonDeAnuncios);
        }

        // Delete
        long firstId = repository.findAll().iterator().next().getId();
        repository.delete(firstId);
        System.out.println(repository.count());
    }
}