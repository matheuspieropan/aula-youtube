import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<UsuarioRequestDto> usuariosRequest = usuariosRequest();

        usuariosRequest.stream()
                .forEach(new MeuConsumer());

        usuariosRequest.stream()
                .forEach(u -> System.out.println());

        usuariosRequest.stream()
                .map(new MinhaFunction()).toList().forEach(System.out::println);

        usuariosRequest.stream()
                .map(u -> new UsuarioResponseDto(u.nome(), u.email(), u.idade())).toList().forEach(System.out::println);


        usuariosRequest.stream()
                .filter(new MeuPredicate()).toList().forEach(System.out::println);

        usuariosRequest.stream()
                .filter(u -> u.idade() >= 18).toList().forEach(System.out::println);
    }

    // Utilizado no Stream.generate
    public static class MeuSupplier implements Supplier<UsuarioRequestDto> {

        @Override
        public UsuarioRequestDto get() {
            return new UsuarioRequestDto("Matheus", "matheus@dev.com", "123", 30);
        }
    }

    // Utilizado no MAP
    public static class MinhaFunction implements Function<UsuarioRequestDto, UsuarioResponseDto> {

        @Override
        public UsuarioResponseDto apply(UsuarioRequestDto request) {
            return new UsuarioResponseDto(request.nome(), request.email(), request.idade());
        }
    }

    // Utilizado no FILTER
    public static class MeuPredicate implements Predicate<UsuarioRequestDto> {

        @Override
        public boolean test(UsuarioRequestDto usuarioRequestDto) {
            return usuarioRequestDto.idade() >= 18;
        }
    }

    // Utilizado no Foreach
    public static class MeuConsumer implements Consumer<UsuarioRequestDto> {

        @Override
        public void accept(UsuarioRequestDto usuarioRequest) {
            System.out.println(usuarioRequest.idade());
        }
    }

    public static List<UsuarioRequestDto> usuariosRequest() {
        return Arrays.asList(new UsuarioRequestDto("Matheus", "matheus@dev.com.br", "123", 10),
                new UsuarioRequestDto("Marcos", "marcos@dev.com.br", "456", 16),
                new UsuarioRequestDto("Lucas", "lucas@dev.com.br", "789", 55),
                new UsuarioRequestDto("João", "joao@dev.com.br", "101", 42)
        );
    }
}