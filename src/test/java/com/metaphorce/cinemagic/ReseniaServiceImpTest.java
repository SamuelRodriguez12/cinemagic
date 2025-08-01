package com.metaphorce.cinemagic;

import com.metaphorce.cinemagic.entities.Pelicula;
import com.metaphorce.cinemagic.entities.Resenia;
import com.metaphorce.cinemagic.repositories.ReseniaRepository;
import com.metaphorce.cinemagic.services.ReseniaServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReseniaServiceImpTest {

    @Mock
    ReseniaRepository repository;

    @InjectMocks
    ReseniaServiceImp serviceImp;
    Resenia resenia;
    Pelicula pelicula;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        pelicula = new Pelicula();
        pelicula.setIdPelicula(10);
        pelicula.setNombrePelicula("Lego Movie");
        resenia = new Resenia();
        resenia.setIdResenia(1);
        resenia.setDetalleResenia("Me gusto");
        resenia.setCalificacion(5.0);
        resenia.setPelicula(pelicula);
    }

    @Test
    public void testGetResenia(){
        when(repository.findAll()).thenReturn(List.of(resenia));
        List<Resenia> resenias = serviceImp.getResenia();
        assertEquals("Me gusto", resenias.get(0).getDetalleResenia());
    }

    @Test
    public void testSendResenia(){
        when(repository.save(resenia)).thenReturn(resenia);
        Resenia reseniaNueva = serviceImp.sendResenia(resenia);
        assertEquals(5, reseniaNueva.getCalificacion());
    }
}
