package testesVagas;
import com.example.demo.entity.Vaga;
import com.example.demo.repository.VagaRepository;
import com.example.demo.service.VagaService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
public class TesteVagas {

    @Test
    public void testBuscarPorId_QuandoIdAstronauta_DeveRetornarVazio() {
        // Criando um mock do VagaRepository
        VagaRepository vagaRepository = mock(VagaRepository.class);

        // Criando uma instância do VagaService, passando o mock do repository
        VagaService vagaService = new VagaService(vagaRepository);

        // Simulando o retorno vazio do findById para o id "astronauta"
        when(vagaRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        // Chamando o método buscarPorId com um id qualquer (por exemplo, 1L)
        Optional<Vaga> resultado = vagaService.buscarPorId(1L);

        // Verificando se o resultado está vazio
        assertTrue(resultado.isEmpty(), "O resultado deveria estar vazio para o id 'astronauta'");
    }






}
