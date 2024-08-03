package stepdefinitions;

import com.pieropan.integracao.entity.Usuario;
import com.pieropan.integracao.repository.UsuarioRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class UsuarioStep extends StepDefsDefault {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private ResponseEntity<Usuario[]> response;

    private final List<Usuario> usuariosCadastrados = new ArrayList<>();

    @Dado("que existem usuários cadastrados no sistema:")
    public void queExistemUsuáriosCadastradosNoSistema(DataTable dataTable) {
        List<Map<String, Object>> usuarios = dataTable.asMaps(String.class, Object.class);
        for (Map<String, Object> usuarioData : usuarios) {
            Usuario usuario = new Usuario();
            usuario.setNome((String) usuarioData.get("nome"));
            usuario.setEmail((String) usuarioData.get("email"));
            usuario.setIdade(Integer.parseInt((String) usuarioData.get("idade")));
            usuarioRepository.save(usuario);
            usuariosCadastrados.add(usuario);
        }
    }

    @Quando("eu faço uma requisição GET para obter usuários")
    public void euFaçoUmaRequisiçãoGETPara() throws URISyntaxException {
        response = testRestTemplate.getForEntity(new URI("/usuario"), Usuario[].class);
    }

    @Então("a resposta deve ter o status code {int}")
    public void aRespostaDeveTerOStatusCode(int statusCode) {
        assertThat(response.getStatusCode().value()).isEqualTo(statusCode);
    }

    @E("a resposta deve conter uma lista de usuários")
    public void aRespostaDeveConterUmaListaDeUsuários() {
        assertThat(response.getBody()).isNotEmpty();
    }

    @E("a resposta deve conter uma lista de usuários com os seguintes dados:")
    public void aRespostaDeveConterUmaListaDeUsuáriosComOsSeguintesDados(DataTable dataTable) {
        System.out.println(dataTable);
    }

    @E("a resposta deve conter os dados que foram cadastrados previamente")
    public void aRespostaDeveConterOsDadosQueForamCadastradosPreviamente() {
        usuariosCadastrados.forEach(usuarioCadastrado -> {
            List<Usuario> usuariosResponse = Arrays.stream(response.getBody()).toList();
            assertTrue(usuariosResponse.contains(usuarioCadastrado));
        });
    }
}