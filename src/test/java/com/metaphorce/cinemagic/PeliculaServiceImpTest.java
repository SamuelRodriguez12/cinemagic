package com.metaphorce.cinemagic;

import com.metaphorce.cinemagic.entities.Pelicula;
import com.metaphorce.cinemagic.repositories.PeliculaRepository;
import com.metaphorce.cinemagic.services.PeliculaServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;

public class PeliculaServiceImpTest {

    @Mock
    PeliculaRepository repository;
    @InjectMocks
    PeliculaServiceImp serviceImp;
    Pelicula pelicula;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        pelicula = new Pelicula();
        pelicula.setIdPelicula(1);
        pelicula.setNombrePelicula("Lego Movie");
    }

    @Test
    public void testGetPelicula(){
        when(repository.findAll()).thenReturn(List.of(pelicula));
        List<Pelicula> peliculasActuales = serviceImp.getPelicula();
        assertEquals(1, peliculasActuales.get(0).getIdPelicula());
    }

    @Test
    public void testGetPeliculaSize(){
        when(repository.findAll()).thenReturn(List.of(new Pelicula(), new Pelicula()));
        List<Pelicula> peliculasActuales = serviceImp.getPelicula();
        assertEquals(2, peliculasActuales.size());
    }

    @Test
    public void testSendPelicula(){
        when(repository.save(pelicula)).thenReturn(pelicula);
        Pelicula nuevaPelicula = serviceImp.sendPelicula(pelicula);
        assertEquals(1, nuevaPelicula.getIdPelicula());
    }

    @Test
    public void testUpdatePelicula(){
        when(repository.findById(pelicula.getIdPelicula())).thenReturn(Optional.ofNullable(pelicula));
        pelicula.setNombrePelicula("Rocky");
        when(repository.save(pelicula)).thenReturn(pelicula);
        Pelicula peliculaActualizada = serviceImp.updatePelicula(pelicula.getIdPelicula(), pelicula);
        assertEquals("Rocky", peliculaActualizada.getNombrePelicula());
    }

    @Test
    public void testDeletePelicula(){
        when(repository.findById(pelicula.getIdPelicula())).thenReturn(Optional.ofNullable(pelicula));
        willDoNothing().given(repository).deleteById(1);
        Boolean peliculaEliminada = serviceImp.deletePelicula(1);
        assertEquals(true, peliculaEliminada);
    }
}
